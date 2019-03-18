import java.util.ArrayList;
public class CarDealership
{
    //instance variable
    private ArrayList<Car> cars;

    /**
     * Constructor: initializes ArrayList
     */
    public CarDealership(ArrayList<Car> cars)
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
        if (index >= 0 && index < carList.size())
        {
            cars.remove(index);
        }
        return null;
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