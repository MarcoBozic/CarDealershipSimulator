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
    }

    //adds cars to the ArrayList 
    public void addCars(ArrayList<Car> newCars)
    {
        
        cars.addAll(newCars);
        //int n = newCars.size();
        //for (int i = 0; i < n; i++)
        //{
         //   Car currCar = newCars.get(i);
           // cars.addall(newCars);
            //cars.add(newCars.get(i));
           // System.out.println(i + " " + newCars);
           // System.out.println(i + " " + currCar);
       // }
    }

    //takes car out of ArrayList
    public Car buyCar(int index)
    {
        if (index >= 0 && index < cars.size())
        {
            cars.remove(index);
        }
        return null;
    }

    //add car back to ArrayList
    public void returnCar(Car car)
    {
        cars.add(car);
    }

    //use filters to display proper vehicles
    public void displayInventory()
    {
        for (int i = 0; i < cars.size(); i++)
        {
            boolean doNotPrint = false;
            if (electricFilter == true)
            {
                if (cars.get(i).getPower()==Vehicle.PowerSource.ELECTRIC_MOTOR)
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
                double cost = cars.get(i).getPrice();
                if (cost<minPrice || cost>maxPrice)
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