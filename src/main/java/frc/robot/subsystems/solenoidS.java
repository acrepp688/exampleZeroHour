package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants;


public class solenoidS extends SubsystemBase{

public static Solenoid solenoidLeft = new Solenoid(PneumaticsModuleType.REVPH, Constants.SolenoidConstants.LSol_ID);
public static Solenoid solenoidRight = new Solenoid(PneumaticsModuleType.REVPH, Constants.SolenoidConstants.RSol_ID);




}