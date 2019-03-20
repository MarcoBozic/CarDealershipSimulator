import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class CarDealership 
{
    //instance variables
    private ArrayList<Car> cars;
    private boolean electricFilter;
    private boolean AWDFilter;
    private boolean priceFilter;
    private double minPrice;
    private double maxPrice;
    //public Car latestPurchase;

    /**
     * Constructor: initializes ArrayList
     */
    public CarDealership()
    {
        ArrayList<Car> emptyList = new ArrayList<Car>();
        this.cars = emptyList;
        electricFilter = false;
        AWDFilter = false;
        priceFilter = false;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        //this.latestPurchase = latestPurchase;
    }

    //adds cars to the ArrayList 
    public void addCars(ArrayList<Car> newCars)
    {
        
        cars.addAll(newCars);
    }

    //takes car out of ArrayList
    public Car buyCar(Car car, int i)
    {
        if (i >= 0 && i < cars.size())
        {
            return cars.remove(i);
        }
        else
        {
            car = null;
        }    
        return car;
    }

    //add car back to ArrayList
    public void returnCar(Car latestPurchase)
    {
        System.out.println("_____________");
        System.out.println(latestPurchase);
        if (latestPurchase != null)
        {
            cars.add(latestPurchase);
        }
        //cars.add(car);
        else
        {
            System.out.println("A CAR HAS NOT BEEN PURCHASED!");
        }
    }

    //use filters to display proper vehicles
    public void displayInventory()
    {
        for (int i = 0; i < cars.size(); i++)
        {
            boolean doNotPrint = false;
            if (electricFilter == true)
            {
                if (cars.get(i).getPower()==Vehicle.PowerSource.GAS_ENGINE)
                {
                    doNotPrint = true;
                }
            }
            if (AWDFilter == true)
            {
                if (cars.get(i).getAWD()==false)
                {
                    doNotPrint = true;
                }
            }
            if (priceFilter == true) 
            {
                //double cost = cars.get(i).getPrice();
                if (cars.get(i).getPrice()<minPrice || cars.get(i).getPrice()>maxPrice)
                {
                    doNotPrint = true;
                }
            }
            if (doNotPrint == false)
            {
                System.out.println(i+" "+cars.get(i).display());
            }
        }
    }

    //set electricFilter to true if called
    public void filterByElectric()
    {
        electricFilter = true;
    }

    //set AWDFilter to true if called
    public void filterByAWD()
    {
        AWDFilter = true;
    }

    //set priceFilter to true if called use parameters in displayInventory
    public void filterByPrice(double minPrice, double maxPrice)
    {
        priceFilter = true;
    }

    //set all filters to false if called
    public void filtersClear()
    {
        electricFilter = false;
        AWDFilter = false;
        priceFilter = false;
    }

    //sort ArrayList by price
    public void sortByPrice()
    {
        Collections.sort(cars);
    }

    //sort by Max Range of cars using comparator
    public void sortByMaxRange()
    {
        Collections.sort(cars, new Comparator<Car>()
        {
            public int compare(Car thisCar, Car otherCar)
            {
                if (thisCar.getMaxRange() > otherCar.getMaxRange())
                {
                    return 1;
                }
                if (thisCar.getMaxRange() < otherCar.getMaxRange())
                {
                    return -1;
                }
                return 0;
            }
        });
    }

    //sort by Safety Rating using comparator
    public void sortBySafetyRating()
    {
        Collections.sort(cars, new Comparator<Car>()
        {
            public int compare(Car thisCar, Car otherCar)
            {
                if (thisCar.getSafetyRating() > otherCar.getSafetyRating())
                {
                    return 1;
                }
                if (thisCar.getSafetyRating() < otherCar.getSafetyRating())
                {
                    return -1;
                }
                return 0;
            }
        });
    }
}       