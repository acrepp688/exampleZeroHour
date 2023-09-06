// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems; //we are LOCATED UNDER the robot folder, and the subsys.
import edu.wpi.first.wpilibj.Solenoid;
//API is like a book. we IMPORT "chapters" of this book, to then use their knowledge.
//Imagine our .command.CommandBase saying "we're in this chapter! use this data."
import edu.wpi.first.wpilibj2.command.CommandBase; //we are a commandbase, using methods
import edu.wpi.first.wpilibj2.command.SubsystemBase; //duh
//  typing a . means going inside another {}
//public means it can be accessed by other files. 
public class ExampleSubsystem extends SubsystemBase { //create a subsystem
  /** Creates a new ExampleSubsystem. */
  public Solenoid solenoid;
  public CANSparkMax frontLeft = new CANSparkMax(Constants.DriveConstants.FL_ID,MotorType.kBrushless); //majic?
  public ExampleSubsystem() {}

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
