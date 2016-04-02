package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.DefaultDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BCRS extends Subsystem {
	//BCRS: Boulder Catch Release System
	
	Victor leftMotor;
	Victor rightMotor;
	
	protected void initDefaultCommand() {
		setDefaultCommand(Robot.defaultDrive);
	}
	
	public BCRS() {
        leftMotor = new Victor(RobotMap.leftCRMotor);
        rightMotor = new Victor(RobotMap.rightCRMotor);
    }
	
	public void shoot() {
		leftMotor.setInverted(true);
		rightMotor.setInverted(false);
		leftMotor.set(1);
		rightMotor.set(1);
	}
	
	public void suck() {
		leftMotor.setInverted(false);
		rightMotor.setInverted(true);
		leftMotor.set(1);
		rightMotor.set(1);
	}
	
	public void stopMotors() {
		leftMotor.set(0);
		rightMotor.set(0);
	}
	
	
	
}
