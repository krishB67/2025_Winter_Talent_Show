import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkBase.ControlType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase{
      
    private final WPI_TalonSRX indexmotor = new WPI_TalonSRX(Constants.IndexerConstants.INDEX_MOTOR_ID);
    private double currSpeed = 0;
    private DigitalInput m_proximitySensor = new DigitalInput(Constants.IndexerConstants.INDEX_PROXIMITY_PORT);
    public void robotInit() {
        DigitalInput m_proximitySensor = new DigitalInput(Constants.IndexerConstants.PROXIMITY_CHANNEL); 
    }
    public boolean getProximity(){
        return m_proximitySensor.get();
    }

    public IndexerSubsystem(){
        indexmotor.setInverted(Constants.IndexerConstants.INDEX_MOTOR_INVERSED);
        indexmotor.setNeutralMode(NeutralMode.Coast);
    }
    


    public void setSpeed(double speed) {
        currSpeed = speed;
        indexmotor.set(currSpeed);
    }

    public double getSpeed(){
        return currSpeed;
    }

}
