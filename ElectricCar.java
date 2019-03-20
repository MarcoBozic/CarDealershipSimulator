public class ElectricCar extends Car
{
    //instance variables
    private int rechargeTime;
    private String batteryType;

     /**
     * Constructor: initializes rechargeTime, batteryType, model, maxRange, safetyRating, AWD, price, mfr, color, power, numWheels
     */
    public ElectricCar(String mfr, String color, String model, PowerSource power,double safetyRating, int maxRange,  boolean AWD, double price, String batteryType, int rechargeTime)
    {
        super(mfr, color, model, power, safetyRating, maxRange, AWD, price);
        this.batteryType = batteryType;
        this.rechargeTime = rechargeTime;
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
        return super.display() + " EL, BAT: " + batteryType + " RCH: " + rechargeTime;
    }
}