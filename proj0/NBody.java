

public class NBody {

    public final static String backgroudImg = "./images/starfield.jpg";

    /**
     * method
     * given a file name, it should return a double corresponding to the radius of the universe in that file
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a path as a command line argument.");
            System.out.println("e.g. java NBody '.data/planets.txt'");
			/* NOTE: Please don't use System.exit() in your code.
			   It will break the autograder. */
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);
        int num = allPlanets.length;

        /** Sets up the universe so it goes from
         * -radius, -radius up to radius, radius */
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        double t = 0;
        while (t < T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for (int i = 0; i < num; i += 1) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }

            /** draw background */
            /* Clears the drawing window. */
            StdDraw.clear();

            StdDraw.picture(0, radius, backgroudImg);
            StdDraw.picture(0, -radius, backgroudImg);

            /** draw all planets */
            for (Planet p : allPlanets) {
                p.raw();
            }
            StdDraw.pause(1);

            t += dt;
        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < num; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel, allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }

    }

    public static double readRadius(String path) {
        In in = new In(path);

        int PlanetNum = in.readInt();
        double UniverseRadius = in.readDouble();

        return UniverseRadius;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);

        int PlanetNum = in.readInt();
        double UniverseRadius = in.readDouble();

        Planet[] allPlanets = new Planet[PlanetNum];

        /* Keep looking until the file is empty. */
        for (int i = 0; i < PlanetNum; i += 1) {
            /* Each line has xxPos, yyPos, xxVel, yyVel, mass, imgFileName
             */
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

        }
        return allPlanets;
    }

}