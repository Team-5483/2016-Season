
package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.gdlib.Math;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Chassis extends Subsystem {
	
	public Gyro gyro;
	
	private Victor leftFrontMotor;
	private Victor leftBackMotor;
	private Victor rightFrontMotor;
	private Victor rightBackMotor;
	
	private CameraServer cameras;
	private boolean frontCameraActive = true;
	
	protected void initDefaultCommand() {
		setDefaultCommand(Robot.defaultDrive);	
	}
	
	public Chassis() {
        leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
        leftBackMotor = new Victor(RobotMap.leftBackMotor);
        rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
        rightBackMotor = new Victor(RobotMap.rightBackMotor);
        gyro = new AnalogGyro(1);
        
        cameras = CameraServer.getInstance();
        cameras.setQuality(50);
        cameras.startAutomaticCapture("cam0");
    }
	
	public void switchCameras() {
		if(!frontCameraActive) {
			cameras.startAutomaticCapture("cam0");
			frontCameraActive = true;
		}
		
		if(frontCameraActive) {
			cameras.startAutomaticCapture("cam1");
			frontCameraActive = false;
		}
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