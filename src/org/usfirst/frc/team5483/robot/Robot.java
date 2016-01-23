
package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.commands.Autonomous;
import org.usfirst.frc.team5483.robot.commands.OperatorTankDrive;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	//Subsystems
	public static Chassis chassis;
	
	//Commands
	public static Command operatorTankDrive;
	
	public static IO io;

    Command autonomousCommand = null;
    SendableChooser chooser;

    public void robotInit() {
    	chassis	 = new Chassis();
    	
    	operatorTankDrive = new OperatorTankDrive();
    	
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

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Scheduler.getInstance().add(operatorTankDrive);
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	//Robot.chassis.tankDrive(IO.getPrimaryControllerLeftStickY(), IO.getPrimaryControllerRightStickY());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
