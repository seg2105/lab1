/**
 * This class contains instances of coordinates in both polar and
 * cartesian format. This is Design #4.
 * 
 * @author Sarmad Hashmi
 * @author Samy Abidib
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
  public PointCPDesign4(double rho, double theta, double x, double y)
  {
	// check if rho theta values correspond to the correct (x,y)
	  double xError = Math.abs((Math.cos(Math.toRadians(theta)) * rho) - x);
	  double yError = Math.abs((Math.sin(Math.toRadians(theta)) * rho) - y);
	  if (xError > 000000000000001 || yError > 000000000000001)		// this is because when calculating the x/y value in here, it adds decimal places (ex: 5.0 becomes 5.0000000001)
		  throw new IllegalArgumentException();
	  this.rho = rho;
	  this.theta = theta;
	  this.x = x;
	  this.y = y;
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
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
	  return;
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
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
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCPDesign4 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
    double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
    double newY =  (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y); 
        
    return new PointCPDesign4(
    		Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2)),
			Math.toDegrees(Math.atan2(newY, newX)),
			newX,
			newY);
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