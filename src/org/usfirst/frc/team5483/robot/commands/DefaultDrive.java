package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;

public class DefaultDrive extends CommandBase {
	
	private double speedMultiplier = 1;
	private double xMultiplier = 0.5, yMultiplier = 0.75;
	
	public DefaultDrive() {
		requires(chassis);
		requires(bcrs);
	}
	
	protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	if(IO.isPrimaryRBButtonPressed()) {
    		bcrs.suck();
    	} else if (IO.isPrimaryLBButtonPressed()) {
    		bcrs.shoot();
    	} else {
    		bcrs.stopMotors();
    	}
    	
//    	double x = IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier;
//    	double y = -IO.getPrimaryControllerRightStickY() * speedMultiplier * yMultiplier;
    	
    	double y = IO.getPrimaryControllerLeftStickY();
    	double x = IO.getPrimaryControllerRightStickX();
    	
    	chassis.drive(y,x);
    }
    
    protected void interrupted() {
    }
    
    protected void end() {
    }
    
    protected boolean isFinished() {
        return false;
    }

}