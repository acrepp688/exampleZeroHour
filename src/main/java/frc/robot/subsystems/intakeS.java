package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakeS extends SubsystemBase {
    public CANSparkMax intakeMotor = new CANSparkMax(Constants.IntakeConstants.intakeID, MotorType.kBrushless);
    public CANSparkMax intakeMotor2 = new CANSparkMax(Constants.IntakeConstants.intakeID2, MotorType.kBrushless);
    
    public intakeS() {
        //anything to START your subsystem/what variables get set to (that require it being focused)
    }
}
