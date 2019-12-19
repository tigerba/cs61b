public class Planet{
    /** instance variables
     *
     */
    public double xxPos; // current x position
    public double yyPos; // current y position
    public double xxVel; // current velocity in x direction
    public double yyVel; // current velocity in y direction
    public double mass; // its mass
    public String imgFileName; // The name of the file that corresponds to the image that depicts the planet
    public static final double GRAVITATIONAL_CONSTANT = 6.67e-11;

    /** constructor
     *
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /** constructor
     * initialize an identical Planet object
     * @param p
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** method
     * calculates the distance between two Planets
     */
    public double calcDistance(Planet p) {
        double dxxPos_sq = Math.pow(this.xxPos - p.xxPos, 2);
        double dyyPos_sq = Math.pow(this.yyPos - p.yyPos, 2);
        return Math.pow(dxxPos_sq + dyyPos_sq, 0.5);
    }

    /** method
     * returns a double describing the force exerted on this planet by the given planet
     */
    public double calcForceExertedBy(Planet p) {
        double dist_sq = Math.pow(this.calcDistance(p), 2);
        return GRAVITATIONAL_CONSTANT * this.mass * p.mass / dist_sq;
    }

    /** method
     * the force exerted in the X direction
     */
    public double calcForceExertedByX(Planet p) {
        if (this.equals(p)) {
            return 0;
        } else {
            double dxxPos = p.xxPos - this.xxPos;
            double dist = this.calcDistance(p);
            double force = this.calcForceExertedBy(p);
            return force * dxxPos / dist;
        }
    }

    /** method
     * the force exerted in the Y direction
     */
    public double calcForceExertedByY(Planet p) {
        if (this.equals(p)) {
            return 0;
        } else {
            double dyyPos = p.yyPos - this.yyPos;
            double dist = this.calcDistance(p);
            double force = this.calcForceExertedBy(p);
            return force * dyyPos / dist;
        }
    }

    /** method
     * the net force exerted in the X direction
     */
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double xxNet = 0;

        for (Planet p : allPlanets) {
            xxNet += this.calcForceExertedByX(p);
        }
        return xxNet;
    }

    /** method
     * the net force exerted in the Y direction
     */
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double yyNet = 0;

        for (Planet p : allPlanets) {
            yyNet += this.calcForceExertedByY(p);
        }

        return yyNet;
    }

    /** method
     * determines how much the forces exerted on the planet will cause that planet to accelerate,
     * and the resulting change in the planet’s velocity and position in a small period of time dt
     */
    public void update(double dt, double xxForce, double yyForce) {
        double xxAcc = xxForce / this.mass;
        double yyAcc = yyForce / this.mass;
        this.xxVel = this.xxVel + xxAcc * dt;
        this.yyVel = this.yyVel + yyAcc * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw() {
        String path = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, path);

        StdDraw.show();
        //StdDraw.pause(2000);
    }
}