public class Vehicle
{
    //instance variables
    private String mfr;
    private String color;
    private int numWheels;
    private boolean answer;

    enum PowerSource
    {
        ELECTRIC_MOTOR, GAS_ENGINE;
    }
    public PowerSource power;
    /**
     * Constructor: initializes 
     */
    public Vehicle(String mfr, String color, PowerSource power, int numWheels)
    {
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.numWheels = numWheels;
    }
    

    public PowerSource getPower()
    {
        return power;
    }
    
    public String getMfr()
    {
        return mfr;
    }

    public String getColor()
    {
        return color;
    }

    public int getNumWheels()
    {
        return numWheels;
    }

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

    public String display()
    {
        return mfr + " " + color; 
    }
}