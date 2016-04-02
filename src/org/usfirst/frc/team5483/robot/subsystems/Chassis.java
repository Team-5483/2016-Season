package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Chassis extends Subsystem {
	
	private Gyro gyro;
	
	private Victor leftFrontMotor;
	private Victor leftBackMotor;
	private Victor rightFrontMotor;
	private Victor rightBackMotor;
	
	RobotDrive drive;
	
	private CameraServer camera;
	private boolean frontCameraActive = true;
	
	protected void initDefaultCommand() {
		setDefaultCommand(Robot.defaultDrive);	
	}
	
	public Chassis() {
        leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
        leftBackMotor = new Victor(RobotMap.leftBackMotor);
        rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
        rightBackMotor = new Victor(RobotMap.rightBackMotor);
        
        //TO REMOVE AFTER LAST MATCH
        drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
        drive.setSafetyEnabled(false);
        
        camera = CameraServer.getInstance();
        camera.setQuality(50);
        camera.startAutomaticCapture("cam0");
    }
	
	public void drive(double y, double x) {
		drive.arcadeDrive(y, x);
		
		
	}
    
}