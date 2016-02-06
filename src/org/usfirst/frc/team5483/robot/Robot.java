
package org.usfirst.frc.team5483.robot;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team5483.robot.commands.Autonomous;
import org.usfirst.frc.team5483.robot.commands.DefaultDrive;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Robot extends IterativeRobot {
	
	//Subsystems
	public static Chassis chassis;
	
	//Commands
	public static Command operatorTankDrive;
	
	public static IO io;

    Command autonomousCommand = null;
    SendableChooser chooser;
    
	CameraServer server;
	
	public void robotInit() {
    	chassis	 = new Chassis();
    	
    	server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        server.startAutomaticCapture("cam1");
        
    	operatorTankDrive = new DefaultDrive();
    	
		io = new IO();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Autonomous());
        chooser.addObject("My Auto", new Autonomous());
        SmartDashboard.putData("Auto Modes", chooser);
        
    }
	
	public void disabledInit(){
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Scheduler.getInstance().add(operatorTankDrive);
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
