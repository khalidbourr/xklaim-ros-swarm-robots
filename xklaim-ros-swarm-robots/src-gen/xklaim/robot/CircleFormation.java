package xklaim.robot;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import klava.Locality;
import klava.Tuple;
import klava.topology.KlavaProcess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class CircleFormation extends KlavaProcess {
  private String robotId;
  
  private Double centerX;
  
  private Double centerY;
  
  private Double radius;
  
  private Integer numIterations;
  
  private List<Locality> neighbours;
  
  public CircleFormation(final String robotId, final Double centerX, final Double centerY, final Double radius, final Integer numIterations, final List<Locality> neighbours) {
    this.robotId = robotId;
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.numIterations = numIterations;
    this.neighbours = neighbours;
  }
  
  @Override
  public void executeProcess() {
    try {
      final int syncInterval = 2000;
      int _size = this.neighbours.size();
      final int totalRobots = (_size + 1);
      int _hashCode = this.robotId.hashCode();
      final int robotIndex = (_hashCode % totalRobots);
      final double targetAngle = (robotIndex * ((2 * Math.PI) / totalRobots));
      double _cos = Math.cos(targetAngle);
      double _multiply = ((this.radius).doubleValue() * _cos);
      double posX = ((this.centerX).doubleValue() + _multiply);
      double _sin = Math.sin(targetAngle);
      double _multiply_1 = ((this.radius).doubleValue() * _sin);
      double posY = ((this.centerY).doubleValue() + _multiply_1);
      MoveTo _moveTo = new MoveTo(this.robotId, Double.valueOf(posX), Double.valueOf(posY));
      eval(_moveTo, this.self);
      in(new Tuple(new Object[] {RobotConstants.MOVE_TO_COMPLETED}), this.self);
      for (int i = 0; (i < (this.numIterations).intValue()); i++) {
        {
          for (final Locality neighbour : this.neighbours) {
            out(new Tuple(new Object[] {"POSITION", this.robotId, posX, posY}), neighbour);
          }
          final HashMap<String, List<Double>> positions = new HashMap<String, List<Double>>();
          for (final Locality neighbour_1 : this.neighbours) {
            {
              final String senderId;
              final Double x;
              final Double y;
              Tuple _Tuple = new Tuple(new Object[] {"POSITION", String.class, Double.class, Double.class});
              in(_Tuple, this.self);
              senderId = (String) _Tuple.getItem(1);
              x = (Double) _Tuple.getItem(2);
              y = (Double) _Tuple.getItem(3);
              positions.put(senderId, Collections.<Double>unmodifiableList(CollectionLiterals.<Double>newArrayList(x, y)));
            }
          }
          double avgX = posX;
          double avgY = posY;
          Collection<List<Double>> _values = positions.values();
          for (final List<Double> position : _values) {
            {
              double _avgX = avgX;
              Double _get = position.get(0);
              avgX = (_avgX + (_get).doubleValue());
              double _avgY = avgY;
              Double _get_1 = position.get(1);
              avgY = (_avgY + (_get_1).doubleValue());
            }
          }
          double _avgX = avgX;
          int _size_1 = this.neighbours.size();
          int _plus = (_size_1 + 1);
          avgX = (_avgX / _plus);
          double _avgY = avgY;
          int _size_2 = this.neighbours.size();
          int _plus_1 = (_size_2 + 1);
          avgY = (_avgY / _plus_1);
          double _cos_1 = Math.cos(targetAngle);
          double _multiply_2 = ((this.radius).doubleValue() * _cos_1);
          double _plus_2 = ((this.centerX).doubleValue() + _multiply_2);
          double _plus_3 = (_plus_2 + (0.5 * (avgX - posX)));
          posX = _plus_3;
          double _sin_1 = Math.sin(targetAngle);
          double _multiply_3 = ((this.radius).doubleValue() * _sin_1);
          double _plus_4 = ((this.centerY).doubleValue() + _multiply_3);
          double _plus_5 = (_plus_4 + (0.5 * (avgY - posY)));
          posY = _plus_5;
          MoveTo _moveTo_1 = new MoveTo(this.robotId, Double.valueOf(posX), Double.valueOf(posY));
          eval(_moveTo_1, this.self);
          in(new Tuple(new Object[] {RobotConstants.MOVE_TO_COMPLETED}), this.self);
          Thread.sleep(syncInterval);
        }
      }
      out(new Tuple(new Object[] {RobotConstants.CIRCLE_FORMATION_COMPLETED}), this.self);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
