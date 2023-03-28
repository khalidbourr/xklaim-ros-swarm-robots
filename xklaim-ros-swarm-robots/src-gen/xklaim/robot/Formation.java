package xklaim.robot;

import java.util.List;
import klava.Locality;
import klava.Tuple;
import klava.topology.KlavaProcess;

@SuppressWarnings("all")
public class Formation extends KlavaProcess {
  private String robotId;
  
  private Double centerX;
  
  private Double centerY;
  
  private Integer numIterations;
  
  private List<Locality> neighbours;
  
  public Formation(final String robotId, final Double centerX, final Double centerY, final Integer numIterations, final List<Locality> neighbours) {
    this.robotId = robotId;
    this.centerX = centerX;
    this.centerY = centerY;
    this.numIterations = numIterations;
    this.neighbours = neighbours;
  }
  
  @Override
  public void executeProcess() {
    final double lineOffsetX = 30.0;
    final double lineOffsetY = 10.0;
    LineFormation _lineFormation = new LineFormation(this.robotId, this.centerX, this.centerY, Double.valueOf(lineOffsetX), Double.valueOf(lineOffsetY), this.numIterations, this.neighbours);
    eval(_lineFormation, this.self);
    in(new Tuple(new Object[] {RobotConstants.LINE_FORMATION_COMPLETED}), this.self);
    final double circleRadius = 10.0;
    CircleFormation _circleFormation = new CircleFormation(this.robotId, this.centerX, this.centerY, Double.valueOf(circleRadius), this.numIterations, this.neighbours);
    eval(_circleFormation, this.self);
    in(new Tuple(new Object[] {RobotConstants.CIRCLE_FORMATION_COMPLETED}), this.self);
    out(new Tuple(new Object[] {RobotConstants.FORMATION_COMPLETED}), this.self);
  }
}
