import java.util.*;

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
		/*Constructor*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.nanoTime();
				pointObjects[i] = new PointCPDesign2(rhos[i],thetas[i]);	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Constructor: PointCPDesign2(doouble rho, double theta) takes an average of "+time+"ns per operations");

		/*GetX*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.nanoTime();
				pointObjects[i].getX();	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: getX() takes an average of "+time+"ns per operations");

		/*GetY*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.nanoTime();
				pointObjects[i].getY();	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: getY() takes an average of "+time+"ns per operations");

		/*GetRho*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.nanoTime();
				pointObjects[i].getRho();	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: getRho() takes an average of "+time+"ns per operations");

		/*GetTheta*/

		sum = 0;
		for(int i = 0; i < pointObjects.length ;i++){
			long s = System.nanoTime();
				pointObjects[i].getTheta();	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: getTheta() takes an average of "+time+"ns per operations");


		/*getDistance*/


		sum = 0;
		for(int i = 0; i < pointObjects.length;i++){
			//We get a random vector from our pool of random vectors
			PointCPDesign2 j = pointObjects[rand.nextInt(pointObjects.length)];

			long s = System.nanoTime();
				pointObjects[i].getDistance(j);	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: getDistance() takes an average of "+time+"ns per operations");


		/*rotatePoint*/
		sum = 0;
		for(int i = 0; i < pointObjects.length;i++){
			//We get a random theta from our pool of random vectors
			double theta = pointObjects[rand.nextInt(pointObjects.length)].getTheta();
			long s = System.nanoTime();
				pointObjects[i].rotatePoint(theta);	
			long e = System.nanoTime();
			sum += (e-s);
		}

		time = sum/(pointObjects.length);

		System.out.println("Method: rotatePoint() takes an average of "+time+"ns per operations");


	}

}