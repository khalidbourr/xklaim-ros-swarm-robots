import java.util.Collections;
import java.util.List;
import klava.Locality;
import klava.LogicalLocality;
import klava.PhysicalLocality;
import klava.topology.ClientNode;
import klava.topology.KlavaNodeCoordinator;
import klava.topology.LogicalNet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.mikado.imc.common.IMCException;
import xklaim.robot.RobotBehaviour;

@SuppressWarnings("all")
public class Robot extends LogicalNet {
  private static final LogicalLocality robot1 = new LogicalLocality("robot1");
  
  private static final LogicalLocality robot2 = new LogicalLocality("robot2");
  
  private static final LogicalLocality robot3 = new LogicalLocality("robot3");
  
  private static final LogicalLocality robot4 = new LogicalLocality("robot4");
  
  private static final LogicalLocality robot5 = new LogicalLocality("robot5");
  
  private static final LogicalLocality robot6 = new LogicalLocality("robot6");
  
  private static final LogicalLocality robot7 = new LogicalLocality("robot7");
  
  public static class robot1 extends ClientNode {
    private static class robot1Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot1";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot2, Robot.robot3, Robot.robot4, Robot.robot5, Robot.robot6, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot1() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot1"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot1.robot1Process());
    }
  }
  
  public static class robot2 extends ClientNode {
    private static class robot2Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot2";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot3, Robot.robot4, Robot.robot5, Robot.robot6, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot2() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot2"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot2.robot2Process());
    }
  }
  
  public static class robot3 extends ClientNode {
    private static class robot3Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot3";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot2, Robot.robot4, Robot.robot5, Robot.robot6, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot3() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot3"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot3.robot3Process());
    }
  }
  
  public static class robot4 extends ClientNode {
    private static class robot4Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot4";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot2, Robot.robot3, Robot.robot5, Robot.robot6, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot4() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot4"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot4.robot4Process());
    }
  }
  
  public static class robot5 extends ClientNode {
    private static class robot5Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot5";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot2, Robot.robot3, Robot.robot4, Robot.robot6, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot5() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot5"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot5.robot5Process());
    }
  }
  
  public static class robot6 extends ClientNode {
    private static class robot6Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot6";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot2, Robot.robot3, Robot.robot4, Robot.robot5, Robot.robot7));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot6() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot6"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot6.robot6Process());
    }
  }
  
  public static class robot7 extends ClientNode {
    private static class robot7Process extends KlavaNodeCoordinator {
      @Override
      public void executeProcess() {
        final String robotId = "robot7";
        final List<Locality> neighbours = Collections.<Locality>unmodifiableList(CollectionLiterals.<Locality>newArrayList(Robot.robot1, Robot.robot2, Robot.robot3, Robot.robot4, Robot.robot5, Robot.robot6));
        final double centerX = 0.0;
        final double centerY = 0.0;
        final int numWaypoints = 10;
        RobotBehaviour _robotBehaviour = new RobotBehaviour(robotId, Double.valueOf(centerX), Double.valueOf(centerY), Integer.valueOf(numWaypoints), neighbours);
        eval(_robotBehaviour, this.self);
      }
    }
    
    public robot7() {
      super(new PhysicalLocality("localhost:9999"), new LogicalLocality("robot7"));
    }
    
    public void addMainProcess() throws IMCException {
      addNodeCoordinator(new Robot.robot7.robot7Process());
    }
  }
  
  public Robot() throws IMCException {
    super(new PhysicalLocality("localhost:9999"));
  }
  
  public void addNodes() throws IMCException {
    Robot.robot1 robot1 = new Robot.robot1();
    Robot.robot2 robot2 = new Robot.robot2();
    Robot.robot3 robot3 = new Robot.robot3();
    Robot.robot4 robot4 = new Robot.robot4();
    Robot.robot5 robot5 = new Robot.robot5();
    Robot.robot6 robot6 = new Robot.robot6();
    Robot.robot7 robot7 = new Robot.robot7();
    robot1.addMainProcess();
    robot2.addMainProcess();
    robot3.addMainProcess();
    robot4.addMainProcess();
    robot5.addMainProcess();
    robot6.addMainProcess();
    robot7.addMainProcess();
  }
}
