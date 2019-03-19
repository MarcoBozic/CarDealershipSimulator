public class Car extends Vehicle implements Comparable<Car>
{
    //private String model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD;
    private double price;
    private String model;
    private int numWheels;

    final String SEDAN = "SEDAN";
    final String SUV = "SUV";
    final String SPORTS = "SPORTS";
    final String MINIVAN = "MINIVAN";


    /**
     * Constructor: initializes model, maxRange, safetyRating, AWD, price, mfr, color, power, numWheels
     */
    public Car(String mfr, String color, String model, PowerSource power,double safetyRating, int maxRange,  boolean AWD, double price, int numWheels)
    {
        super(mfr,color,power,numWheels);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;
        this.numWheels = numWheels;
    }

    /**
       Returns the string containing model, maxRange, safetyRating, AWD, price, manufacturer name and color seperated by a spaces
       @return the display
     */
    public String display()
    {
        super.display();
        return model + " " + maxRange + " " + safetyRating + " " + AWD + " " + price;
    }

    /**
       Returns the boolean value true or false if cars are equal
       @return answer
     */
    public boolean equals (Object other)
	{
		Car obj = (Car) other; 
		if ((super.equals(obj)) && ((this.model.equals(obj.model))) && (this.AWD==obj.AWD))
		{
			return true;
		}
		else 
			return false; 
	}

    /**
       Compares this car with another in the form of Comparable interface.
       @return -1 if this price is lower than other's price
       +1 if this price is higher than other's price
       0 if the prices are the same
    */    
    public int compareTo(Car other)
    {
        if (this.price>other.price)
        {
            return 1;
        }
        if (this.price<other.price)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    /**
       Returns the maximum range
       @return the maximun range
     */
    public int getMaxRange()
    {
        return maxRange;
    }

    /**
       Returns the safety rating
       @return the safety rating
     */
    public double getSafetyRating()
    {
        return safetyRating;
    }

    /**
       Returns true if vehicle is AWD
       @return true if car is AWD
     */
    public boolean getAWD()
    {
        return AWD;
    }

    /**
       Returns the price value
       @return price
     */
    public double getPrice()
    {
        return price;
    }
}