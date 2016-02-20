package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.utils.CommandLogger;

import edu.wpi.first.wpilibj.Joystick.RumbleType;

public class DefaultDrive extends CommandBase {
	
	private CommandLogger cmd_log;
	
	private double speedMultiplier = 1;
	private double xMultiplier = 0.5,yMultiplier = 0.75;
	int buttLimit = 10,timeElapsed = 0;
	
	public DefaultDrive() {
		requires(chassis);
		requires(bcrs);
		cmd_log = new CommandLogger();
    }
	
	protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	double angle = chassis.gyro.getAngle();
    	
    	if(timeElapsed < buttLimit) {
    		timeElapsed++;
    	}
    	
    	if(IO.isPrimaryAButtonPressed() && timeElapsed >= buttLimit) {
    		xMultiplier*=-1;
    		timeElapsed = 0;
    		//chassis.switchCameras();
    	}
    	
    	if(IO.isPrimaryXButtonPressed()) {
    		IO.getXboxController().setRumble(RumbleType.kLeftRumble, 100);
    	} else {
    		IO.getXboxController().setRumble(RumbleType.kLeftRumble, 00);
    	}
    	System.out.println(IO.getXboxController().getThrottle());
    	if(IO.isPrimaryRBButtonPressed()) {
    		bcrs.suck();
    	} else if (IO.isPrimaryLBButtonPressed()) {
    		bcrs.shoot();
    	} else {
    		bcrs.stopMotors();
    	}
    	
    	double x = IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier;
    	double y = -IO.getPrimaryControllerRightStickY() * speedMultiplier * yMultiplier;
    	
    	cmd_log.logCommand(Double.toString(x)+','+Double.toString(y)+"\n");
    	
    	chassis.drive(x,y);
    }
    
    protected void interrupted() {
    }
    
    protected void end() {
    }
    
    protected boolean isFinished() {
        return false;
    }

}