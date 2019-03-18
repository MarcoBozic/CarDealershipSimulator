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
     * Returns the recharge time
     * @return the recharge time
     */
    public int getRechargeTime()
    {
        return rechargeTime;
    }

    /** 
    * Sets the new recharge time (in minutes)
    * @param newRechargeTime recharge time (in minutes)
    */
    public void setRechargeTime(int newRechargeTime)
    {
        this.rechargeTime = newRechargeTime;
    }
    /**
     * Returns the battery type
     * @return the battery type
     */
    public String getBatteryType()
    {
        return batteryType;
    }

    /** 
    * Sets the new battery type
    * @param newBatteryType battery type
    */
    public void setBatteryType(String newBatteryType)
    {
        this.batteryType = newBatteryType;
    }

    /**
       Returns the string containing rechargeTime, batteryType, model, maxRange, safetyRating, AWD, price, manufacturer name and color seperated by a spaces
       @return the display
     */
    public String display()
    {
        super.display();
        return rechargeTime + " " + batteryType;
    }
}