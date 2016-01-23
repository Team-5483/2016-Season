package org.usfirst.frc.team5483.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class IO {
    public static Joystick xboxController;
	
	private static double DEADZONE_MAGIC_NUMBER = .15;
	private static int LEFT_STICK_X = 0, LEFT_STICK_Y = 1,
			RIGHT_STICK_X = 4 , RIGHT_STICK_Y = 5;
	
	public IO() {
		xboxController = new Joystick(RobotMap.xboxController);
	}
	
	private static double deadzone(double d) {
        if (Math.abs(d) < DEADZONE_MAGIC_NUMBER)
            return 0;
        
        return (d / Math.abs(d)) * ((Math.abs(d) - DEADZONE_MAGIC_NUMBER) / (1 - DEADZONE_MAGIC_NUMBER));
    }
	
	public static double getPrimaryControllerLeftStickX() {
        return deadzone(-xboxController.getRawAxis(LEFT_STICK_X));
    }

    public static double getPrimaryControllerLeftStickY() {
        return deadzone(-xboxController.getRawAxis(LEFT_STICK_Y));
    }

    public static double getPrimaryControllerRightStickX() {
        return deadzone(-xboxController.getRawAxis(RIGHT_STICK_X));
    }

    public static double getPrimaryControllerRightStickY() {
        return deadzone(-xboxController.getRawAxis(RIGHT_STICK_Y));
    }
	
    public static boolean isPrimaryXButtonPressed() {
        return xboxController.getRawButton(RobotMap.X_BUTTON);
    }

    public static boolean isPrimaryYButtonPressed() {
        return xboxController.getRawButton(RobotMap.Y_BUTTON);
    }

    public static boolean isPrimaryAButtonPressed() {
        return xboxController.getRawButton(RobotMap.A_BUTTON);
    }

    public static boolean isPrimaryBButtonPressed() {
        return xboxController.getRawButton(RobotMap.B_BUTTON);
    }

    public static boolean isPrimaryRBButtonPressed() {
        return xboxController.getRawButton(RobotMap.RB);
    }

    public static boolean isPrimaryLBButtonPressed() {
        return xboxController.getRawButton(RobotMap.LB);
    }

    public static boolean isPrimaryLeftJoyClick() {
        return xboxController.getRawButton(RobotMap.RIGHT_JOY_CLICK);
    }

    public static boolean isPrimaryRightJoyClick() {
        return xboxController.getRawButton(RobotMap.LEFT_JOY_CLICK);
    }

    public static boolean isPrimarySelectButtonPressed() {
        return xboxController.getRawButton(RobotMap.SELECT);
    }

    public static boolean isPrimaryStartButtonPressed() {
        return xboxController.getRawButton(RobotMap.START);
    }
	
	
}


