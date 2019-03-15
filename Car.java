public class Car extends Vehicle
{
    //private String model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD;
    private double price;

    enum CarModel
    {
        SEDAN,SUV,SPORTS,MINIVAN;
    }

    public CarModel model;

    public Car(CarModel model, int maxRange, double safetyRating, boolean AWD, double price, String mfr, String color, PowerSource power, int numWheels)
    {
        super(mfr,color,power,numWheels);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;
    }


}