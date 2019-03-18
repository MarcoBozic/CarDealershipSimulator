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
    public CarDealership(ArrayList<Car> cars, boolean electricFilter, boolean AWDFilter, boolean priceFilter)
    {
        this.cars = cars;
        ArrayList<Car> carList = new ArrayList<Car>();
        cars = carList;
    }

    public void addCars(ArrayList<Car> newCars)
    {
        for (int i = 0; i < newCars.size(); i++)
        {
            cars.add(newCars.get(i));
        }
    }

    public Car buyCar(int index)
    {
        if (index >= 0 && index < cars.size())
        {
            cars.remove(index);
        }
        return null;
    }

    public void returnCar(Car car)
    {
        cars.add(car);
    }

    public void displayInventory()
    {
        for (int i = 0; i < cars.size(); i++)
        {
            boolean doNotPrint = false;
            if (electricFilter)
            {
                if (cars.get(i).getPower()==Vehicle.PowerSource.ELECTRIC_MOTOR)
                {
                    doNotPrint = true;
                }
            }
            if (AWDFilter)
            {
                if (cars.get(i).getAWD()==false)
                {
                    doNotPrint = true;
                }
            }
            if (priceFilter)
            {
                double cost = cars.get(i).getPrice();
                if (cost<minPrice || cost>maxPrice)
                {
                    doNotPrint = true;
                }
            }
            if (doNotPrint = false)
            {
                System.out.println(i+". "+cars.get(i).display());
            }
        }
    }

    public void filterByElectric()
    {
        electricFilter = true;
    }

    public void filterByAWD()
    {
        AWDFilter = true;
    }

    public void filterByPrice(double minPrice, double maxPrice)
    {
        priceFilter = true;
    }

    public void filtersClear()
    {
        electricFilter = false;
        AWDFilter = false;
        priceFilter = false;
    }

    public void sortByPrice()
    {
        Collections.sort(cars);
    }

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