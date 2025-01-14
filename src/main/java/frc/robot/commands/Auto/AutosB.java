// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import frc.robot.commands.Auto.AutoCommands.encDriveA;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.AutoCommands.encDriveB;


public final class AutosB extends SequentialCommandGroup{
  public AutosB(ExampleSubsystem drive) {
    super(
      Commands.sequence(
        new encDriveA(drive, 10),
        new encDriveB(drive, 5),
        
        new encDriveB(drive, -5),
        new encDriveA(drive, -10)
        
      )
    );
  }
}
