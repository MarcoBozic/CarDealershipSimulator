import java.util.ArrayList;
import java.util.Scanner;

public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
    
	  // Create a CarDealership object
    CarDealership dealership = new CarDealership(carList, false, false, false, 0, 0);
	  // Then create an (initially empty) array list of type Car
	  ArrayList<Car> carList = new ArrayList<Car>();
      // Then create some new car objects of different types
	  carList.add(new Car("Toyota","blue",Car.Model.SEDAN,Vehicle.PowerSource.GAS_ENGINE,9.5,500,false,25000));
     //carList.add(new Car("SPORTS",450, 9.2, false, 30000, "Honda",  "red", 1, 4));
     //carList.add(new Car("MINIVAN",550, 9.7, false, 20000, "Kia",  "white", 1, 4));
     //carList.add(new Car("SEDAN",600, 9.6, true, 55000, "BMW",  "black", 1, 4));
     //carList.add(new ElectricCar("SEDAN",425, 9.1, false, 85000, "Tesla",  "red", 0, 4, 30, "Lithium-Ion"));
     //carList.add(new Car("MINIVAN",475, 9.25, false, 40000, "Chevy",  "red", 1, 4));
     //carList.add(new ElectricCar("SEDAN",375, 8.9, true, 37000, "ChevyColt",  "green", 0, 4, 45, "Lithum-Ion"));
     //carList.add(new Car("SEDAN",575, 9.8, false, 150000, "Bentley",  "black", 1, 4));
     //carList.add(new ElectricCar("SEDAN",325, 8.8, true, 32000, "NissanLeaf",  "green", 0, 4, 55, "Lithium-Ion"));


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