package xklaim.robot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import klava.Locality;
import klava.Tuple;
import klava.topology.KlavaProcess;
import messages.Odometry;
import messages.Quaternion;
import messages.XklaimToRosConnection;
import org.eclipse.xtext.xbase.lib.Exceptions;
import ros.Publisher;
import ros.RosListenDelegate;
import ros.SubscriptionRequestMsg;
import ros.msgs.geometry_msgs.Twist;
import utils.EulerAngles;

@SuppressWarnings("all")
public class MoveTo extends KlavaProcess {
  private String robotId;
  
  private Double x;
  
  private Double y;
  
  public MoveTo(final String robotId, final Double x, final Double y) {
    this.robotId = robotId;
    this.x = x;
    this.y = y;
  }
  
  @Override
  public void executeProcess() {
    final Locality local = this.self;
    final XklaimToRosConnection bridge = new XklaimToRosConnection(RobotConstants.ROS_BRIDGE_SOCKET_URI);
    out(new Tuple(new Object[] {RobotConstants.BRIDGE, bridge}), this.self);
    final Publisher pub = new Publisher((("/" + this.robotId) + "/cmd_vel"), "geometry_msgs/Twist", bridge);
    final Twist vel_msg = new Twist();
    final double distanceTolerance = 0.1;
    final double angleTolerance = 0.1;
    final double K_l = 0.5;
    final double K_a = 1.0;
    final double PI = 3.141592653589793;
    final RosListenDelegate _function = (JsonNode data, String stringRep) -> {
      try {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rosMsgNode = data.get("msg");
        Odometry odom = mapper.<Odometry>treeToValue(rosMsgNode, Odometry.class);
        double currentX = odom.pose.pose.getPosition().getX();
        double currentY = odom.pose.pose.getPosition().getY();
        Quaternion _orientation = odom.pose.pose.getOrientation();
        EulerAngles angle = new EulerAngles(_orientation);
        double currentTheta = angle.getYaw();
        double deltaX = ((this.x).doubleValue() - currentX);
        double deltaY = ((this.y).doubleValue() - currentY);
        double angular = Math.atan2(deltaY, deltaX);
        double headingError = (angular - currentTheta);
        if ((headingError > PI)) {
          headingError = (headingError - (2 * PI));
        }
        if ((headingError < (-PI))) {
          headingError = (headingError + (2 * PI));
        }
        double _pow = Math.pow(((this.x).doubleValue() - currentX), 2);
        double _pow_1 = Math.pow(((this.y).doubleValue() - currentY), 2);
        double _plus = (_pow + _pow_1);
        double distance = Math.sqrt(_plus);
        if ((distance > distanceTolerance)) {
          double _abs = Math.abs(headingError);
          boolean _greaterThan = (_abs > angleTolerance);
          if (_greaterThan) {
            vel_msg.linear.x = 0.0;
            vel_msg.angular.z = (K_a * headingError);
          } else {
            vel_msg.linear.x = (K_l * distance);
            vel_msg.angular.z = 0.0;
          }
          pub.publish(vel_msg);
        } else {
          vel_msg.linear.x = 0;
          vel_msg.angular.z = 0;
          pub.publish(vel_msg);
          out(new Tuple(new Object[] {RobotConstants.MOVE_TO_COMPLETED}), local);
          bridge.unsubscribe((("/" + this.robotId) + "/odom"));
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    bridge.subscribe(
      SubscriptionRequestMsg.generate((("/" + this.robotId) + "/odom")).setType("nav_msgs/Odometry").setThrottleRate(Integer.valueOf(1)).setQueueLength(Integer.valueOf(1)), _function);
  }
}
