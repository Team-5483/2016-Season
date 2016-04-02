
package org.usfirst.frc.team5483.robot;
import org.usfirst.frc.team5483.robot.commands.CommandBase;
import org.usfirst.frc.team5483.robot.commands.DefaultDrive;
import org.usfirst.frc.team5483.robot.commands.auto.GyroCrossAuto;
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
	
	//AUTONOMOUS COMMANDS
	public static Command gyroCrossAuto;
	
	//TELEOP COMMANDS
	public static Command defaultDrive;
	
	public static IO io;
	
	public int countAuto = 0;
	
	public void robotInit() {
		io = new IO();
		CommandBase.init();
		
		//TELEOP COMMANDS INIT
		defaultDrive = new DefaultDrive();
		
		//AUTO COMMANDS INIT
		//gyroCrossAuto = new GyroCrossAuto();
        
    }
	
	//AUTOMOUS
	public void autonomousInit() {
		countAuto = 0;
    }
	
	public void autonomousPeriodic() {
//	    if(countAuto++ <= 100) {
//	    	CommandBase.chassis.drive(-0.7, 0.2);
//	    } else {
//	    	CommandBase.chassis.drive(0.0, 0.0);
//	    }	
//	    
//	    if(countAuto > 10000){ countAuto = 0;}
    }
    	
    //TELEOP
    public void teleopInit() {
    	Scheduler.getInstance().add(defaultDrive);
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
    }
    
    //DISABLE
    public void disabledInit(){
    	
    	
    }
    
    public void disabledPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    //TEST
    public void testPeriodic() {
        LiveWindow.run();
    }
}
