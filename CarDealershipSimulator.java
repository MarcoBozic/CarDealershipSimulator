import java.util.ArrayList;
import java.util.Scanner;

public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
    ArrayList<Car> carList = new ArrayList<Car>();
	  // Create a CarDealership object
    //CarDealership dealership = new CarDealership(carList, false, false, false, 0, 0);
    CarDealership dealership = new CarDealership(carList, false, false, false, 0, 0);
	  // Then create an (initially empty) array list of type Car
	
      // Then create some new car objects of different types
    carList.add(new Car("Toyota","blue","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.5,500,false,25000));
    carList.add(new Car("Honda","red","SPORTS",Vehicle.PowerSource.GAS_ENGINE,9.2,450,false,30000));
    carList.add(new Car("Kia","white","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.7,550,false,20000));
    carList.add(new Car("Honda","red","SPORTS",Vehicle.PowerSource.GAS_ENGINE,9.2,450,false,30000));
    carList.add(new Car("BMW","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.6,600,false,55000));
    carList.add(new ElectricCar("Tesla","red","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,9.1,425,false,85000,"Lithium",30));
    carList.add(new Car("Chevy","red","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.25,475,false,40000));
    carList.add(new ElectricCar("ChevyColt","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.9,375,false,37000,"Lithium",45));
    carList.add(new Car("Bentley","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.8,575,false,150000));
    carList.add(new ElectricCar("NissanLeaf","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.8,325,false,32000,"Lithium",55));


	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  

	  // Create a scanner object
	  Scanner scanner = new Scanner(System.in);
	  // while the scanner has another line
	  //    read the input line
      while(scanner.hasNextLine())
      {
        Scanner commandLine = new Scanner(scanner.nextLine());

        String input = commandLine.next();
        //    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
        //    read the next word from the commandLine scanner
        //	check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object

        Car latestPurchase = null;

        if(input.equals("L"))
        {
          dealership.displayInventory();
        }
        else if (input.equals("Q"))
        {
          return;
        }
        else if(input.equals("BUY"))
        {
            if(commandLine.hasNextInt())
            {
              int index = commandLine.nextInt();
              Car car = dealership.buyCar(index);
              latestPurchase = car;
              car.display();
            }
        }
        else if(input.equals("RET"))
        {
            dealership.returnCar(latestPurchase);
        }
        else if(input.equals("ADD"))
        {
          dealership.addCars(carList);
        }
        else if(input.equals("SPR"))
        {
          dealership.sortByPrice();
        }
        else if (input.equals("SSR"))
        {
          dealership.sortBySafetyRating();
        }
        else if (input.equals("SMR"))
        {
          dealership.sortByMaxRange();
        }
        else if(input.equals("FPR"))
        {
          double minValue = commandLine.nextDouble();
          if(commandLine.hasNextDouble() == false)
          {
            continue;
          }

          double maxValue = commandLine.nextDouble();
          if(commandLine.hasNextDouble() == false)
          {
            continue;
          }

          if(minValue < 0 || minValue > maxValue)
          {
            System.out.println("Improper price range.");
          }

          dealership.filterByPrice(minValue, maxValue);

        }
        else if(input.equals("FEL"))
        {
          dealership.filterByElectric();
        }
        else if (input.equals("FAW"))
        {
          dealership.filterByAWD();
        }
        else if (input.equals("FCL"))
        {
          dealership.filtersClear();
        }
        else
        {
          System.out.println("Not a proper command");
        }
      }
  }

}