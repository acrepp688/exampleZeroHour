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
  private final ExampleSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    //Will not run without the ExampleSubsystem. If it DID, it'd CRASH!
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { //Ran a TON, as this command has been set to the default, and therefore is CONSTANTLY checked/on.
    double left = RobotContainer.m_driverController.getLeftY();
    double right = RobotContainer.m_driverController.getRightY();
    m_subsystem.tankDrive(left,right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //When the command ends, run this code. Example
    //m_subsystem.tankDrive(0,0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; //Stop this commmand. We don't want to do this, however, because we never want driving to stop.
  }
}
