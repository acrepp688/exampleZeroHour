package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.solenoidS;

public class solenoidC extends CommandBase{

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
       if(RobotContainer.m_driverController.getAButtonPressed() == true) {
        solenoidS.solenoidLeft.set(true);
       } else if(RobotContainer.m_driverController.getAButtonReleased() == true) {
        solenoidS.solenoidLeft.set(false);
       }
    
    if(RobotContainer.m_driverController.getBButtonPressed() == true) {
        solenoidS.solenoidRight.set(true);
       } else if(RobotContainer.m_driverController.getBButtonReleased() == true) {
        solenoidS.solenoidRight.set(false);
       }
    }


@Override
public void end(boolean interrupted) {

}

@Override
public boolean isFinished() {
    return false;
}
}

