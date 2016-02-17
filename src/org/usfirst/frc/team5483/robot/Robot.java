
package org.usfirst.frc.team5483.robot;
import org.usfirst.frc.team5483.robot.commands.CommandBase;
import org.usfirst.frc.team5483.robot.commands.DefaultDrive;
import org.usfirst.frc.team5483.robot.commands.auto.Autonomous;
import org.usfirst.frc.team5483.robot.subsystems.BCRS;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static Command defaultDrive;
	
	public static IO io;

    Command autonomousCommand = null;
    SendableChooser chooser;
    
	CameraServer server;
	
	Gyro gyro = new AnalogGyro(1);
	
	public void robotInit() {
		io = new IO();
		CommandBase.init();
		defaultDrive = new DefaultDrive();
		
    	server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        
    	chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Autonomous());
        chooser.addObject("My Auto", new Autonomous());
        SmartDashboard.putData("Auto Modes", chooser);
        
        gyro.calibrate();
        
        
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
    	Scheduler.getInstance().add(defaultDrive);
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
    }
    
    public void disabledInit(){
    	
    }
    
    public void disabledPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
