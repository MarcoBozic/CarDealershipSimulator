public class Vehicle
{
    //instance variables
    private String mfr;
    private String color;
    private int numWheels;
    public boolean answer;

    //enum used to set static final value for ELECTRIC_MOTOR and GAS_ENGINE
    enum PowerSource
    {
        ELECTRIC_MOTOR, GAS_ENGINE;
    }
    
    //creating reference to enum so it can be assigned to the constructer
    public PowerSource power;
    
    /**
     * Constructor: initializes mfr, color, power, numWheels
     */
    public Vehicle(String mfr, String color, PowerSource power, int numWheels)
    {
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.numWheels = numWheels;
    }
    
    /**
       Returns the power source
       @return the power source
     */
    public PowerSource getPower()
    {
        return power;
    }
    
    /**
       Returns the manufacturer
       @return the manufacturer
     */
    public String getMfr()
    {
        return mfr;
    }

    /**
       Returns the color
       @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
       Returns the number of wheels
       @return the number of wheels
     */
    public int getNumWheels()
    {
        return numWheels;
    }

    /**
       Returns the boolean value true or false if vehicles are equal
       @return answer
     */
    public boolean equal(Vehicle other)
    {
        if (this.getPower() == other.getPower() && this.getMfr() == other.getMfr() && this.getNumWheels() == other.getNumWheels())
        {
            answer = true;
        }
        else
        {
            answer = false;
        }
        return answer;
    }

    /**
       Returns the string containing manufacturer name and color seperated by a space
       @return the display
     */
    public String display()
    {
        return mfr + " " + color; 
    }
}