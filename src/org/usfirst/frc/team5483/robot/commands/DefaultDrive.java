package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.utils.CommandLogger;

public class DefaultDrive extends CommandBase {
	
	private CommandLogger cmd_log;
	
	private double speedMultiplier = 1;
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
    	if(timeElapsed < buttLimit) {
    		timeElapsed++;
    	}
    	
    	if(IO.isPrimaryAButtonPressed() && timeElapsed >= buttLimit) {
    		xMultiplier*=-1;
    		timeElapsed = 0;
    	}
    	
    	if(IO.isPrimaryAButtonPressed()) {
    		bcrs.shoot();
    	} else if (IO.isPrimaryBButtonPressed()) {
    		bcrs.suck();
    	} else {
    		bcrs.stopMotors();
    	}
    	
    	double x = IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier;
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