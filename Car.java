public class Car extends Vehicle implements Comparable<Car>
{
    //private String model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD;
    private double price;

    //enum used to set static final value for SEDAN, SUV, SPORTS, MINIVAN
    enum CarModel
    {
        SEDAN,SUV,SPORTS,MINIVAN;
    }

    //creating reference to enum so it can be assigned to the constructer
    public CarModel model;

    /**
     * Constructor: initializes model, maxRange, safetyRating, AWD, price, mfr, color, power, numWheels
     */
    public Car(CarModel model, int maxRange, double safetyRating, boolean AWD, double price, String mfr, String color, PowerSource power, int numWheels)
    {
        super(mfr,color,power,numWheels);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;
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
        if (this.price<other.price)
        {
            return -1;
        }
        if (this.price>other.price)
        {
            return 1;
        }
        return 0;
    }
}