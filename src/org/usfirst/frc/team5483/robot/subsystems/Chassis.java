
package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.OperatorTankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	
	public Victor leftFrontMotor;
	public Victor leftBackMotor;
	public Victor rightFrontMotor;
	public Victor rightBackMotor;
	
	public RobotDrive drive;

	protected void initDefaultCommand() {
		setDefaultCommand(new OperatorTankDrive());
	}
	
	public Chassis() {
        leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
        leftBackMotor = new Victor(RobotMap.leftBackMotor);
        rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
        rightBackMotor = new Victor(RobotMap.rightBackMotor);
        
        leftFrontMotor.setSafetyEnabled(true);
        leftBackMotor.setSafetyEnabled(true);
        rightFrontMotor.setSafetyEnabled(true);
        rightBackMotor.setSafetyEnabled(true);
        
        drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    }
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}
    
}