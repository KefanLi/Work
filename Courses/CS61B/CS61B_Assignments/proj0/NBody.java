public class NBody {
	/** This class contain reading radius method and reading planets methond
	 acting as main methond to show our outcome
	*/

	// Read redius of target file which contains basic information of several planets
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	// Read planets and return an array of planets in target file
	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int num = in.readInt();
		Planet[] planetSet = new Planet[num];
		int count = 0;
		in.readDouble();
		while(count < num) {
			double xCoordinate = in.readDouble();
			double yCoordinate = in.readDouble();
			double xVelocity = in.readDouble();
			double yVelocity = in.readDouble();
			double mass = in.readDouble();
			String planetName = in.readString();
			planetSet[count] = new Planet(xCoordinate, yCoordinate, xVelocity,
					                      yVelocity, mass, planetName);
			count ++;
		}
		return planetSet;
	}

	public static void main(String[] args) {
		// Collected all needed input
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		// Setting the background scale
	 	StdDraw.setScale(-radius, radius);

	 	// Preventing flickering in the animation
		StdDraw.enableDoubleBuffering();

		// Separating the time and calculating every step for this simulating
		double time = 0;
		In in = new In(filename);
		int num = in.readInt();
		
		while(time <= T) {
			double[] xForceArray = new double[num];
			double[] yForceArray = new double[num];
			
			for(int i = 0; i < planets.length; i ++) {
				xForceArray[i] = planets[i].calcNetForceExertedByX(planets);
				yForceArray[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < planets.length; i ++) {
				planets[i].update(dt, xForceArray[i], yForceArray[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			for(Planet p : planets) {
				p.draw();
			}
			
			StdDraw.show();
			T += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);

		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}