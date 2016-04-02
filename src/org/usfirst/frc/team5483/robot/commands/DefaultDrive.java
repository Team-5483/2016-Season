package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.IO;

public class DefaultDrive extends CommandBase {
	
	private boolean realFrontForward = true;
	
	//Real Front Speed Modifiers
	private double speedModifierRealFrontForward = 1.0; 
	private double speedModifierRealFrontTurn = 0.5;
	
	//Fake Front Speed Modifiers
	private double speedModifierFakeFrontForward = 1.0; 
	private double speedModifierFakeFrontTurn = 1.0;	
	
	public DefaultDrive() {
		requires(chassis);
		requires(bcrs);
	}
	
	protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	//DRIVE CODE
    	double y = IO.getPrimaryControllerLeftStickX();
		double x = IO.getPrimaryControllerRightStickY();
    	
		if(IO.isPrimaryAButtonPressed()) {
    		realFrontForward = true;
    	} else if(IO.isPrimaryBButtonPressed()) {
        	realFrontForward = false;
        }
		
		if(IO.isPrimaryYButtonPressed()) {
			speedModifierFakeFrontTurn = 0.3;
		}  if(IO.isPrimaryXButtonPressed()) {	
			speedModifierFakeFrontTurn = 1;
		}
		
    	if(realFrontForward) {
    		chassis.drive(-y, x);
    	} else {
    		chassis.drive(y, x);
    	}
    	
    	//Ball catch and release system
    	if(IO.isPrimaryLBButtonPressed()) {
    		bcrs.suck();
    	} else if (IO.isPrimaryRBButtonPressed()) {
    		bcrs.shoot();
    	} else {
    		bcrs.stopMotors();
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




