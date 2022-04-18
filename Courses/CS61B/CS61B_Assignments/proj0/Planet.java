public class Planet{
	/** This Planet class includes basic elements of a planet
	 * and methods to calculate several kinds of force between
	   every planets
	*/
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              	double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	// Calculates the distance between two Planets
	public double calcDistance(Planet p) {
		double xDistance = this.xxPos - p.xxPos;
		double yDistance = this.yyPos - p.yyPos;
		double xyDistance = Math.sqrt(xDistance*xDistance + yDistance*yDistance);
		return xyDistance;
	}

	// This method takes in a planet, and returns a double describing the force exerted on this planet by the given planet
	public double calcForceExertedBy(Planet p) {
		double gConstant = 6.67e-11;
		double xyDistance = this.calcDistance(p);
		double gForce = (gConstant*this.mass*p.mass)/(xyDistance*xyDistance);
		return gForce;
	}

	// This method describes the force exerted in the X direction
	public double calcForceExertedByX(Planet p) {
		double totalForce = this.calcForceExertedBy(p);
		double xyDistance = this.calcDistance(p);
		double distanceInXDirection = p.xxPos - this.xxPos;
		double forceInXDirection = totalForce*(distanceInXDirection/xyDistance);
		return forceInXDirection;
	} 

	// This method describes the force exerted in the Y direction
	public double calcForceExertedByY(Planet p) {
		double totalForce = this.calcForceExertedBy(p);
		double xyDistance = this.calcDistance(p);
		double distanceInYDirection = p.yyPos - this.yyPos;
		double forceInYDirection = totalForce*(distanceInYDirection/xyDistance);
		return forceInYDirection;
	} 

	/* This method takes in an array of Planets and calculate the net X force
	    exerted by all planets in that array upon the current Planet
	 */
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		boolean judgeSamePlanet;
		double netForceExertedByX = 0;
		for(int i = 0; i < allPlanets.length; i++) {
			judgeSamePlanet = this.equals(allPlanets[i]);
			if(judgeSamePlanet) {
				continue;
			}
			netForceExertedByX = netForceExertedByX + this.calcForceExertedByX(allPlanets[i]);
		}
		return netForceExertedByX;
	}

	/* This method takes in an array of Planets and calculate the net Y force
	    exerted by all planets in that array upon the current Planet
	 */
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		boolean judgeSamePlanet;
		double netForceExertedByY = 0;
		for(int i = 0; i < allPlanets.length; i++) {
			judgeSamePlanet = this.equals(allPlanets[i]);
			if(judgeSamePlanet) {
				continue;
			}
			netForceExertedByY = netForceExertedByY + this.calcForceExertedByY(allPlanets[i]);
		}
		return netForceExertedByY;
	}

    /* This method determines how much the forces exerted on the planet will cause that planet to accelerate, 
        and the resulting change in the planet’s velocity and position in a small period of time dt
    */
	public void update(double dt, double xNetForce, double yNetForce) {
		double xAcceleration = xNetForce/this.mass;
		double yAcceleration = yNetForce/this.mass;
		this.xxVel = this.xxVel + dt*xAcceleration;
		this.yyVel = this.yyVel + dt*yAcceleration;
		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;
	}

	// This methond draw this planet on the screen
	public void draw() {
		String imageToDraw = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
	}
}