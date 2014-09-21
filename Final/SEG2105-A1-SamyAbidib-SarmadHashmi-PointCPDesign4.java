/**
 * SEG2105 B - Assignment 1: Design 4
 * This class contains instances of coordinates in both polar and
 * Cartesian format. This is Design #4.
 * 
 * @author Sarmad Hashmi (7249729)
 * @author Samy Abidib (6909624)
 * @version September 2014
 */
public class PointCPDesign4
{
  //Instance variables ************************************************

    /**
   * Contains the current value of rho.
   */
  private double rho;
  
  /**
   * Contains the current value of thetaA.
   */
  private double theta;
  
  /**
   * Contains the current value of X.
   */
  private double x;
  
  
  /**
   * Contains the current value of Y.
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object and stores both types of points (polar and cartesian).
   */
  public PointCPDesign4(char type, double xOrRho, double yOrTheta)
  {
	  if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	  // store both coordinate systems into instance variables
	  if (type == 'C') {
		  this.rho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
		  this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		  this.x = xOrRho;
		  this.y = yOrTheta;
	  }
	  else {
		  this.rho = xOrRho;
		  this.theta = yOrTheta;
		  this.x = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
		  this.y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
	  }
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
	  return x;
  }
  
  public double getY()
  {
	  return y;
  }
  
  public double getRho()
  {
	  return rho;
  }
  
  public double getTheta()
  {
	  return theta;
  }
  
  /**
   * Converts Cartesian coordinates to Polar coordinates. Not used in this design.
   */
  public void convertStorageToPolar()
  {
	  return;
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates. Not used in this design.
   */
  public void convertStorageToCartesian()
  {
	  return;
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCPDesign4 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   * 
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCPDesign4 rotatePoint(double rotation)
  {
	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCPDesign4('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian  (" + getX() + "," + getY() + ") \nStored as Polar [" + getRho() + "," + getTheta() + "]";
  }
}