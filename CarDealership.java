import java.util.ArrayList;
public class CarDealership
{
    //instance variable
    private int cars;
    private Car specific;

    /**
     * Constructor: initializes ArrayList
     */
    public CarDealership(int cars)
    {
        this.cars = cars;
        ArrayList<Car> carList = new ArrayList<Car>(cars);
    }

    public void addCars(ArrayList<Car> newCars)
    {
        for (int i = 0; i < newCars.size(); i++)
        {
            specific = newCars.get(i);
            carList.add(specific);
        }
    }

    public Car buyCar(int index)
    {
        if (index >= 0 && index < carList.size())
        {
            specific = carList.get(index);
            carList.remove(index);
        }
        return specific;
    }

    public void returnCar(Car car)
    {
        carList.add(car);
    }

    public void displayInventory()
    {
        for (int i = 0; i < carList.size(); i++)
        {
            System.out.println(i);
            Sytem.out.println(Car.display());
        }
    }

    public void filterByElectric()
    {
        //
    }

    public void filterByAWD()
    {
        //
    }

    public void filterByPrice(double minPrice, double maxPrice)
    {
        //
    }

    public void filtersClear()
    {
        //
    }

    public void sortByPrice()
    {
        //
    }

    public void sortBySafetyRating()
    {
        //
    }

    public void sortByMaxRange()
    {
        //
    }

    
    }



}