package frc.robot.commands.Auto.AutoCommands;
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Timer;

public class inOutIntake extends CommandBase {
double autoSpeed;
boolean move;
boolean isFinished;
double seconds;
Timer timeElapsed= new Timer();
    public final intakeS inOut;

    public inOutIntake(intakeS inOutS,intakeS subsystem, double desiredTime, double MotorSpeed) {
        seconds= desiredTime;
        inOut = inOutS;

        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
    }
    @Override

    public void initialize(){
        timeElapsed.start();
    inOut.resetEncoders();

    if (autoSpeed<0){
        move=true;
    }else{
        move=false;
    }
    isFinished=false;
    }
    @Override
    public void execute(){
        if (timeElapsed.get() <= seconds) {
            inOut.inOutMotor1.set(autoSpeed);
            inOut.inOutMotor2.set(-autoSpeed);
        } else {
            isFinished = true;
        }
    }
    @Override
    public void end(boolean interrupted) {
        inOut.stopLift();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}