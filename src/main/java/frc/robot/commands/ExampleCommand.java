// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem; //make an instance of the ExampleSubsystem 

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    //If you don't add the requirement, it will "CRASH".
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //we need to get the controller sticks and make them the left and right double
    //then, we need to update the tank drive/motors to go at that speed.
    double left = RobotContainer.m_driverController.getLeftY();
    double right = RobotContainer.m_driverController.getRightY();
    m_subsystem.tankDrive(left,right); //1 = MAX FORWARD, -1 = MAX BACKWARD
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //as an example, this stops the motors.
    //ExampleSubsystem.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; //we never want the motors to stop for teleop, so we ALWAYS return false.
  }
}
