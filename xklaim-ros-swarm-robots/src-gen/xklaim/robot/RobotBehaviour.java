package xklaim.robot;

import java.util.List;
import klava.Locality;
import klava.Tuple;
import klava.topology.KlavaProcess;

@SuppressWarnings("all")
public class RobotBehaviour extends KlavaProcess {
  private String robotId;
  
  private Double centerX;
  
  private Double centerY;
  
  private Integer numIterations;
  
  private List<Locality> neighbours;
  
  public RobotBehaviour(final String robotId, final Double centerX, final Double centerY, final Integer numIterations, final List<Locality> neighbours) {
    this.robotId = robotId;
    this.centerX = centerX;
    this.centerY = centerY;
    this.numIterations = numIterations;
    this.neighbours = neighbours;
  }
  
  @Override
  public void executeProcess() {
    Formation _formation = new Formation(this.robotId, this.centerX, this.centerY, this.numIterations, this.neighbours);
    eval(_formation, this.self);
    in(new Tuple(new Object[] {RobotConstants.FORMATION_COMPLETED}), this.self);
    RobotBehaviour _robotBehaviour = new RobotBehaviour(this.robotId, this.centerX, this.centerY, this.numIterations, this.neighbours);
    eval(_robotBehaviour, this.self);
  }
}
