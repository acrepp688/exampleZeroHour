// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems; //we are LOCATED UNDER the robot folder, and the subsys.
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//API is like a book. we IMPORT "chapters" of this book, to then use their knowledge.
//Imagine our .command.CommandBase saying "we're in this chapter! use this data."
import edu.wpi.first.wpilibj2.command.CommandBase; //we are a commandbase, using methods
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import frc.robot.Constants;
//  typing a . means going inside another {}
//public means it can be accessed by other files. 
public class ExampleSubsystem extends SubsystemBase { //create a subsystem
  /** Creates a new ExampleSubsystem. */
  public CANSparkMax frontLeft = new CANSparkMax(Constants.DriveConstants.FL_ID,MotorType.kBrushless); //Create a motor using the ID given in constants, and all REV motors are Brushless.
  public CANSparkMax frontRight = new CANSparkMax(Constants.DriveConstants.FR_ID,MotorType.kBrushless); 
  public CANSparkMax backLeft = new CANSparkMax(Constants.DriveConstants.BL_ID,MotorType.kBrushless); 
  public CANSparkMax backRight = new CANSparkMax(Constants.DriveConstants.BR_ID,MotorType.kBrushless); 
  //^declare CANSparkMax's
  MotorControllerGroup MCGleft = new MotorControllerGroup(frontLeft,backLeft); //combine left side
  MotorControllerGroup MCGright = new MotorControllerGroup(frontRight,backRight); //combine right side
  public DifferentialDrive tank = new DifferentialDrive(MCGleft , MCGright); //allow TankDrive.
  public ExampleSubsystem() {
    //Anything that has to be declared using another part of the robot at startup goes here! Example,
    /*
    frontLeft.setSmartCurrentLimit(75, 75);     Set a limit for each motor. This can't be done just for code, it has to be done for the CANSparkMax,
    backLeft.setSmartCurrentLimit(75, 75);      and therefore is in this curly brace.
    frontRight.setSmartCurrentLimit(75, 75);
    backRight.setSmartCurrentLimit(75, 75);
    */
  }
  public void tankDrive(double left, double right){ //Allow other files to drive robot.
    tank.tankDrive(left, right); //...Drive!
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
