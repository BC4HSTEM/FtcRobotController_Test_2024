package org.firstinspires.ftc.teamcode.opmodes.autonomous.paths;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.drivetrain.commands.SequentialActionCommand;
import org.firstinspires.ftc.teamcode.mechanisms.drivetrain.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;

public class TestPath1 {

    private HardwareMap hwMap;
    private Pose2d startPose;

    private Telemetry telemetry;

    private Motor fl, fr, bl, br;

    private DriveSubsystem driveSubsystem;

    private MecanumDrive drive;
    public TestPath1(HardwareMap hwMap, Pose2d sp, Telemetry telemetry){
        this.hwMap = hwMap;
        startPose = sp;
        this.telemetry = telemetry;
        driveSubsystem = new DriveSubsystem(hwMap, startPose);
        drive = driveSubsystem.getRRDrive();

    }

    public void createPath(){



    }

    public void execute(CommandOpMode commandOpMode){
        TrajectoryActionBuilder tab1 = drive.actionBuilder(startPose)
                .lineToYSplineHeading(33, Math.toRadians(0))
                .waitSeconds(2)
                .setTangent(Math.toRadians(90))
                .lineToY(48);
        SequentialActionCommand seqCommand1 = new SequentialActionCommand(tab1);

        commandOpMode.schedule(new WaitUntilCommand(commandOpMode::isStarted).andThen(
                seqCommand1
        ));
    }
}
