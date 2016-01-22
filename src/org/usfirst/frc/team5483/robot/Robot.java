
package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.commands.Autonomous;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	//Subsystems
	public static final Chassis chassis	 = new Chassis();
	
	//Commands
	
	public static IO io;

    Command autonomousCommand = null;
    SendableChooser chooser;

    public void robotInit() {
		io = new IO();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Autonomous());
        //chooser.addObject("My Auto", new MyAutoCommand());
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

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
