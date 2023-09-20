package frc.robot.commands.Auto.AutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;

public class encDriveA extends CommandBase {
    private final ExampleSubsystem driveS;
    double Desired;
    boolean isFinished = false;
    
    public encDriveA(ExampleSubsystem subsystem, double desDis) {
        driveS = subsystem;
        Desired = desDis;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        driveS.resetEncoders();
        isFinished = false;
    }

    @Override
    public void execute() {
        if (driveS.getDrivePos() < Desired && Desired > 0) {
            driveS.tankDrive(0.5, 0.5);
        } else if (driveS.getDrivePos() > Desired && Desired < 0) {
            driveS.tankDrive(-0.5, -0.5);
        } else {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveS.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
