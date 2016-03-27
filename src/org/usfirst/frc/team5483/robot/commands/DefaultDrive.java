package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;

public class DefaultDrive extends CommandBase {
	
	private double speedMultiplier = 1;
	private double xMultiplier = 0.5, yMultiplier = 0.75;
	
	private boolean realFront = true;
	
	public DefaultDrive() {
		requires(chassis);
		requires(bcrs);
	}
	
	protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	if(IO.isPrimaryAButtonPressed()) {
    		realFront = true;
    	}
    	
        if(IO.isPrimaryBButtonPressed()) {
        	realFront = false;
        }
    	
    	if(IO.isPrimaryRBButtonPressed()) {
    		bcrs.suck();
    	} else if (IO.isPrimaryLBButtonPressed()) {
    		bcrs.shoot();
    	} else {
    		bcrs.stopMotors();
    	}
    	
    	double y = IO.getPrimaryControllerLeftStickY();
		double x = IO.getPrimaryControllerRightStickX();
    	
    	if(realFront) {
    		chassis.drive(-y,x);
    	} else {
    		chassis.drive(y,x);
    	}
    }
    
    protected void interrupted() {
    }
    
    protected void end() {
    }
    
    protected boolean isFinished() {
        return false;
    }

}