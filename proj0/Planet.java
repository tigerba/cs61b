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

    /**
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
        double dxxPos = Math.pow(this.xxPos - p.xxPos, 2);
        double dyyPos = Math.pow(this.yyPos - p.yyPos, 2);
        return Math.pow(dxxPos + dyyPos, 0.5);
    }
}