
package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.OperatorTankDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	
	public Victor leftFrontMotor;
	public Victor leftBackMotor;
	public Victor rightFrontMotor;
	public Victor rightBackMotor;

	protected void initDefaultCommand() {
		setDefaultCommand(new OperatorTankDrive());
	}
	
	public Chassis() {
        leftFrontMotor = new Victor(RobotMap.leftFrontMotor);
        leftBackMotor = new Victor(RobotMap.leftBackMotor);
        rightFrontMotor = new Victor(RobotMap.rightFrontMotor);
        rightBackMotor = new Victor(RobotMap.rightBackMotor);
        
    }
    
}

