import java.util.*;

// reusing code from Samy's PointCPDesign2Performance.java
// added min/max times and made it compatible with design4

class PointCPDesign4Performance {

	public static void main(String[] arg) {

		/**
		 * Constants
		 */

		// Going higher than 10000000 might get a memory out of bounds error...

		int numberOfObjectsPerDesign = 10000000;

		int maxRho = 1000000;

		/**
		 * Variables
		 */

		Random rand = new Random();

		/**
		 * Cool Logic
		 */

		PointCPDesign4[] pointObjects = new PointCPDesign4[numberOfObjectsPerDesign];

		double[] rhos = new double[numberOfObjectsPerDesign];
		double[] thetas = new double[numberOfObjectsPerDesign];
		double[] convertedXValues = new double[numberOfObjectsPerDesign];
		double[] convertedYValues = new double[numberOfObjectsPerDesign];

		// Generate the values to be used for the points constructor
		for (int i = 0; i < numberOfObjectsPerDesign; i++) {
			rhos[i] = rand.nextDouble() * maxRho;
			thetas[i] = rand.nextDouble() * (2 * 3.14);
			convertedXValues[i] = Math.cos(Math.toRadians(thetas[i])) * rhos[i];
			convertedYValues[i] = Math.sin(Math.toRadians(thetas[i])) * rhos[i];

		}

		/**
		 * ******************* TIMING
		 */

		double sum;
		double time;
		long maxTime = 0;
		long minTime = 0;
		boolean firstTime = true;
		/* Constructor with Polar coordinates */

		sum = 0;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i] = new PointCPDesign4('P', rhos[i], thetas[i]);
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}		time = sum / (pointObjects.length);

		System.out
				.println("Constructor: PointCPDesign4('P', rho, theta) takes an average of "
						+ time
						+ "ms per operation. MAX: "
						+ maxTime
						+ "ms, MIN: " + minTime + "ms");

		/* Constructor with Cartesian coordinates */
		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i] = new PointCPDesign4('C', convertedXValues[i],
					convertedYValues[i]);
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out
				.println("Constructor: PointCPDesign4('C', x, y) takes an average of "
						+ time
						+ "ms per operation. MAX: "
						+ maxTime
						+ "ms, MIN: " + minTime + "ms");
		/* GetX */

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i].getX();
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: getX() takes an average of " + time
				+ "ms per operation. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");

		/* GetY */

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i].getY();
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: getY() takes an average of " + time
				+ "ms per operation. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");
		/* GetRho */

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i].getRho();
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: getRho() takes an average of " + time
				+ "ms per operatioms. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");

		/* GetTheta */

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			long s = System.currentTimeMillis();
			pointObjects[i].getTheta();
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: getTheta() takes an average of " + time
				+ "ms per operation. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");

		/* getDistance */

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			// We get a random vector from our pool of random vectors
			PointCPDesign4 j = pointObjects[rand.nextInt(pointObjects.length)];

			long s = System.currentTimeMillis();
			pointObjects[i].getDistance(j);
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: getDistance() takes an average of " + time
				+ "ms per operation. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");

		/* rotatePoint */
		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for (int i = 0; i < pointObjects.length; i++) {
			// We get a random theta from our pool of random vectors
			double theta = pointObjects[rand.nextInt(pointObjects.length)]
					.getTheta();
			long s = System.currentTimeMillis();
			pointObjects[i].rotatePoint(theta);
			long e = System.currentTimeMillis();
			long timeTaken = e - s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			} else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			} else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e - s);
		}

		time = sum / (pointObjects.length);

		System.out.println("Method: rotatePoint() takes an average of " + time
				+ "ms per operation. MAX: " + maxTime + "ms, MIN: " + minTime
				+ "ms");

	}

}