package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.utils.CommandLogger;

import edu.wpi.first.wpilibj.Joystick.RumbleType;

public class DefaultDrive extends CommandBase {
	
	private CommandLogger cmd_log;
	
	private double speedMultiplier = 0.666;
	//loominati confirmed
	private int xMultiplier = 1;
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
    	}
    	
    	if(IO.isPrimaryXButtonPressed()) {
    		IO.getXboxController().setRumble(RumbleType.kLeftRumble, 100);
    	}
    	
    	if(IO.getXboxController().getTrigger()) {
    		bcrs.shoot();
    	} else if (!IO.getXboxController().getTrigger()) {
    		bcrs.suck();
    	} else {
    		bcrs.stopMotors();
    	}
    	
    	double x = IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier - angle;
    	double y = -IO.getPrimaryControllerRightStickY() * speedMultiplier;
    	
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