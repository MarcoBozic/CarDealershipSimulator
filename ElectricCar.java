public class ElectricCar extends Car
{
    //instance variables
    private int rechargeTime;
    private String batteryType;

     /**
     * Constructor: initializes rechargeTime, batteryType, model, maxRange, safetyRating, AWD, price, mfr, color, power, numWheels
     */
    public ElectricCar(int rechargeTime, String batteryType, CarModel model, int maxRange, double safetyRating, boolean AWD, double price, String mfr, String color, PowerSource power, int numWheels)
    {
        super(model, maxRange, safetyRating, AWD, price, mfr, color, power, numWheels);
        this.rechargeTime = rechargeTime;
        this.batteryType = batteryType;
    }

    /**
       Returns the power source
       @return the power source
     */
    public PowerSource getPower()
    {
        return power;
    }
}