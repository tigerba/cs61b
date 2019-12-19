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
        double dxxPos = p.xxPos - this.xxPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dxxPos / dist;
    }

    /** method
     * the force exerted in the Y direction
     */
    public double calcForceExertedByY(Planet p) {
        double dyyPos = p.yyPos - this.yyPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dyyPos / dist;
    }
}