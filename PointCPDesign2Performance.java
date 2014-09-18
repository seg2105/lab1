import java.util.*;


/**
 * @author  Samy Abidib
 * @author  Sarmad Hashmi
 * @version  September 2014
 */
class PointCPDesign2Performance{





	public static void main(String[] arg){
		
		/**
		 * Constants
		 */
		
		//Going higher than 10000000 might get a memory out of bounds error...
		
		int numberOfObjectsPerDesign = 10000000;
		
		int maxRho = 1000000;

		/**
		 * Variables
		 */

		Random rand = new Random();



		/**
		 * Cool Logic
		 */
		
		PointCPDesign2[] pointObjects = new PointCPDesign2[numberOfObjectsPerDesign];

		double[] rhos = new double[numberOfObjectsPerDesign]; 
		double[] thetas = new double[numberOfObjectsPerDesign]; 




		//Generate the values to be used for the points construction
		for(int i = 0; i  < numberOfObjectsPerDesign;i++){
			rhos[i] = rand.nextDouble()*maxRho;
			thetas[i] = rand.nextDouble()*(2*3.14);
		}
		

		/**
		 * ******************* TIMING
		 */

	
		double sum;
		double time;
		long maxTime = 0;
		long minTime = 0;		
		boolean firstTime = true;
		/*Constructor*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.currentTimeMillis();
				pointObjects[i] = new PointCPDesign2(rhos[i],thetas[i]);	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;					
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;				
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);			
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Constructor: PointCPDesign2(double rho, double theta, double x, double y) takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");

		/*GetX*/

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.currentTimeMillis();
				pointObjects[i].getX();	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: getX() takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");

		/*GetY*/

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.currentTimeMillis();
				pointObjects[i].getY();	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: getY() takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");

		/*GetRho*/

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.currentTimeMillis();
				pointObjects[i].getRho();	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: getRho() takes an average of "+time+" miliseconds per operatio miliseconds. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");

		/*GetTheta*/

		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.currentTimeMillis();
				pointObjects[i].getTheta();	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: getTheta() takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");


		/*getDistance*/


		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length;i++){
			//We get a random vector from our pool of random vectors
			PointCPDesign2 j = pointObjects[rand.nextInt(pointObjects.length)];

			long s = System.currentTimeMillis();
				pointObjects[i].getDistance(j);	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: getDistance() takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");


		/*rotatePoint*/
		sum = 0;
		maxTime = 0;
		minTime = 0;
		firstTime = true;
		for(int i = 0; i < pointObjects.length;i++){
			//We get a random theta from our pool of random vectors
			double theta = pointObjects[rand.nextInt(pointObjects.length)].getTheta();
			long s = System.currentTimeMillis();
				pointObjects[i].rotatePoint(theta);	
			long e = System.currentTimeMillis();
			long timeTaken = e-s;
			if (firstTime) {
				maxTime = timeTaken;
				minTime = timeTaken;
				firstTime = false;
			}
			else if (timeTaken > maxTime) {
				maxTime = timeTaken;
			}
			else if (timeTaken < minTime) {
				minTime = timeTaken;
			}
			sum += (e-s);
		}

		time = sum/(pointObjects.length)/1000;

		System.out.println("Method: rotatePoint() takes an average of "+time+" miliseconds per operation. MAX: "+maxTime+" miliseconds, MIN: "+minTime+" miliseconds");



	}

}