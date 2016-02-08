
package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.gdlib.Math;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	
	public Victor leftFrontMotor;
	public Victor leftBackMotor;
	public Victor rightFrontMotor;
	public Victor rightBackMotor;
	
	protected void initDefaultCommand() {
		setDefaultCommand(Robot.defaultDrive);	
	}
	
	public Chassis() {
        leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
        leftBackMotor = new Victor(RobotMap.leftBackMotor);
        rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
        rightBackMotor = new Victor(RobotMap.rightBackMotor);
    }
	
	public void drive(double left, double right) {
		double xInput = Math.squareMaintainSign(left);
        double yInput = right;
		double leftOut = Math.calcLeftDrive(xInput, yInput);
        double rightOut = Math.calcRightDrive(xInput, yInput);
		leftFrontMotor.set(leftOut);
		leftBackMotor.set(leftOut);
		rightFrontMotor.set(rightOut);
		rightBackMotor.set(rightOut);
	}
    
}