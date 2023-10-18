package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;


public class intakeS extends SubsystemBase {
    public CANSparkMax liftMotor = new CANSparkMax(Constants.IntakeConstants.intakeID, MotorType.kBrushless);
    public CANSparkMax inOutMotor1 = new CANSparkMax(Constants.IntakeConstants.intakeID2, MotorType.kBrushless);
    public CANSparkMax inOutMotor2 = new CANSparkMax(Constants.IntakeConstants.intakeID3, MotorType.kBrushless);
    public CANSparkMax squeezeMotor = new CANSparkMax(Constants.IntakeConstants.intakeID4, MotorType.kBrushless);

    public RelativeEncoder liftEncoder = liftMotor.getEncoder();
    public RelativeEncoder inOut1Encoder = inOutMotor1.getEncoder();
    public RelativeEncoder inOut2Encoder = inOutMotor2.getEncoder();
    public RelativeEncoder squeezeEncoder = squeezeMotor.getEncoder();


    public intakeS() {
        liftMotor.setIdleMode(IdleMode.kBrake);
        inOutMotor1.setIdleMode(IdleMode.kBrake);
        inOutMotor2.setIdleMode(IdleMode.kBrake);
        squeezeMotor.setIdleMode(IdleMode.kBrake);
        //anything to START your subsystem/what variables get set to (that require it being focused)
    }



    public void moveLiftDown(double speed){
        liftMotor.set(speed);
    }

    public void moveLiftUp(double speed){
        liftMotor.set(speed);
    }

    public void stopLift(){
        liftMotor.set(0);
    }



    public void moveInOutIn(double speed){ //This moves the inOutMotors in which means it spins the wheels on the intake and pulls an object in
        inOutMotor1.set(speed);
        inOutMotor2.set(speed);
    }

    public void moveInOutOut(double speed){ //This moves the inOutMotors out which means it spins the wheels on the intake and shoots the object
        inOutMotor1.set(speed);
        inOutMotor2.set(speed);
    }

    public void stopInOut(){
        inOutMotor1.set(0);
        inOutMotor1.set(0);
    }



    public void moveSqueezeMotorIn(double speed){
        squeezeMotor.set(speed);
    }

    public void moveSqueezeMotorOut(double speed){
        squeezeMotor.set(speed);
    }

    public void stopSqueezeMotor(){
        squeezeMotor.set(0);
    }



    public void resetEncoders() {
        liftEncoder.setPosition(0);
        inOut1Encoder.setPosition(0);
        inOut2Encoder.setPosition(0);
        squeezeEncoder.setPosition(0);
      }
}
