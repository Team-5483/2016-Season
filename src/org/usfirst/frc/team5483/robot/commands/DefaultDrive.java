package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;

public class DefaultDrive extends CommandBase {
	
	
	private boolean realFront = true;
	
	//Real Front Speed Modifiers
	private double speedModifierRealFrontForward = 1; 
	private double speedModifierRealFrontTurn = 1;
	
	//Fake Front Speed Modifiers
	private double speedModifierFakeFrontForward = 0.5; 
	private double speedModifierFakeFrontTurn = 0.5;
			
	
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
    	
    	if(IO.isPrimaryLBButtonPressed()) {
    		bcrs.suck();
    	} else if (IO.isPrimaryRBButtonPressed()) {
    		bcrs.shoot();
    	} else {
    		bcrs.stopMotors();
    	}
    	
    	double y = IO.getPrimaryControllerLeftStickY();
		double x = IO.getPrimaryControllerRightStickX();
    	
    	if(realFront) {
    		chassis.drive(-y * speedModifierRealFrontTurn, x * speedModifierRealFrontForward);
    	} else {
    		chassis.drive(y * speedModifierFakeFrontTurn, x * speedModifierFakeFrontForward);
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