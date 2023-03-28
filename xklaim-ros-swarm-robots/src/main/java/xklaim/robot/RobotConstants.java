package xklaim.robot;

public class RobotConstants {
	public static final String AVAILABLE_FOR_DELIVERY = "availableForDelivery";
	public static final String MOVE_TO_COMPLETED = "moveToCompleted";
	public static final String ROS_BRIDGE_SOCKET_URI = "ws://0.0.0.0:9090";
	public static final String FLAG_DISCOVERED = "flag_discovered";
	public static final String BRIDGE = "bridge";
	public static final String COMPLETED = "complete";
	public static final String ODOMETRYMESSAGE = "nav_msgs/Odometry";
	public static final String SONARMESSAGE = "sensor_msgs/Range";
	public static final String CMDVELMESSAGE = "geometry_msgs/Twist";
	public static final double MIN_RANGE = 5.0;
	public static final double MAX_SPEED = 2.0;
	public static final double MIN_ANGLE = 0.01;
	public static final String VICTIM_DISCOVERED = "victim_discovered";
	public static final String MOVE_TO_DESTINATION = "moveToDestination";
	public static final String SONAR_RANEG ="sonar_range";
	public static final String LINE_FORMATION_COMPLETED = "Line_completed";
	public static final String CIRCLE_FORMATION_COMPLETED = "Circle_completed";
	public static final String FORMATION_COMPLETED = "Formation_completed";
	public static final String GRID_FORMATION_COMPLETED = "Grid_completed";
}
