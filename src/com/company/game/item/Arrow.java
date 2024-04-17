package com.company.game.item;

import com.company.game.Configuration;

public class Arrow extends Item {
    private double speed;
    private double angle;
    private double t;

    public Arrow(double speed, double angle) {
        super("arrow", Configuration.ARROW_PATH);
        this.speed = speed;
        this.angle = angle;
        resizeWithKeepRatio(4);
        setRotate(-angle);
    }

    public void move() {
        double xf = x(t) / Configuration.PIXEL_TO_METERS;
        double yf = y(t) / Configuration.PIXEL_TO_METERS;
        setTranslateX(xf);
        setTranslateY(-yf);

        double rotation = Math.toDegrees(Math.atan2(uy(t), ux(t)));
        setRotate(-rotation);

        t+=0.05;
    }

    public double x(double t) {
        return speed * Math.cos(Math.toRadians(angle)) * t;
    }

    public double y(double t) {
        return speed * Math.sin(Math.toRadians(angle)) * t - Configuration.G * t * t / 2;
    }

    public double ux(double t) {
        return speed * Math.cos(Math.toRadians(angle));
    }

    public double uy(double t) {
        return speed * Math.sin(Math.toRadians(angle)) - Configuration.G * t;
    }

    public double maxHt() {
        return speed * Math.sin(Math.toRadians(angle)) / Configuration.G;
    }

    public double maxH() {
        return Math.pow(speed * Math.sin(Math.toRadians(angle)), 2) / (2 * Configuration.G);
    }

    public double maxR() {
        return speed * speed * Math.sin(Math.toRadians(2 * angle)) / Configuration.G;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
