package frc.robot.commands.Auto.AutoCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;

public class encDriveB extends CommandBase {
    private final ExampleSubsystem driveS;
    PIDController drivePID = new PIDController(0.01, 0, 0);
    double desired;
    boolean isFinished = false;
    
    public encDriveB(ExampleSubsystem subsystem, double desDis) {
        driveS = subsystem;
        desired = desDis; //desired in inches
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        driveS.resetEncoders();
        isFinished = false;
    }

    @Override
    public void execute() {
        double autoDriveSpeed = drivePID.calculate(driveS.getDrivePos(), desired);
        driveS.tankDrive(-autoDriveSpeed, autoDriveSpeed);
        if (Math.abs(drivePID.getPositionError()) < 0.1) {
            driveS.tankDrive(0,0);
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveS.tankDrive(0, 0);
        driveS.motorBrake();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
