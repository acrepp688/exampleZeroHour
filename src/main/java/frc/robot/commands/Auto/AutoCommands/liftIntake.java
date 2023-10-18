package frc.robot.commands.Auto.AutoCommands;
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class liftIntake extends CommandBase {
double autoSpeed;
boolean move;
boolean isFinished;

    public final intakeS lift;

    public liftIntake(intakeS liftS,intakeS subsystem, double MotorSpeed) {

        lift = liftS;

        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
    }
    @Override

    public void initialize(){
    lift.resetEncoders();

    if (autoSpeed<0){
        move=true;
    }else{
        move=false;
    }
    isFinished=false;
    }
    @Override
    public void execute(){
        if (move==true){
            while (lift.liftEncoder.getPosition()<0){
                lift.moveLiftUp(autoSpeed);
            }
        }else{
            while (lift.liftEncoder.getPosition()<27){
                lift.moveLiftUp(autoSpeed);
            }
        }
        lift.liftMotor.setIdleMode(IdleMode.kCoast);
        isFinished = true;
    }
    @Override
    public void end(boolean interrupted) {
        lift.stopLift();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}