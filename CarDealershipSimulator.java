import java.util.ArrayList;
import java.util.Scanner;

public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
    //instance variable
    Car latestPurchase = null;
    //creates a carList object
    ArrayList<Car> carList = new ArrayList<Car>();
	  // Create a CarDealership object
    CarDealership dealership = new CarDealership();
	
      // Then create some new car objects of different types
    carList.add(new Car("Toyota","blue","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.5,500,false,25000));
    carList.add(new Car("Honda","red","SPORTS",Vehicle.PowerSource.GAS_ENGINE,9.2,450,false,30000));
    carList.add(new Car("Kia","white","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.7,550,false,20000));
    carList.add(new Car("Honda","red","SPORTS",Vehicle.PowerSource.GAS_ENGINE,9.2,450,false,30000));
    carList.add(new Car("BMW","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.6,600,true,55000));
    carList.add(new ElectricCar("Tesla","red","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,9.1,425,true,85000,"Lithium",30));
    carList.add(new Car("Chevy","red","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.25,475,false,40000));
    carList.add(new ElectricCar("ChevyColt","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.9,375,true,37000,"Lithium",45));
    carList.add(new Car("Bentley","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.8,575,false,150000));
    carList.add(new ElectricCar("NissanLeaf","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.8,325,true,32000,"Lithium",55));

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
              int i = commandLine.nextInt();
              Car carBought = carList.get(i);
              Car car = dealership.buyCar(carList.get(i),i);
              latestPurchase = carBought;
            }
            else 
            {
              System.out.println("ENTER AN INDEX VALUE!");
            }
        }
        else if(input.equals("RET"))
        {
          if (latestPurchase != null)
          {
            dealership.returnCar(latestPurchase);
          }  
          else
          {
            System.out.println("A CAR HAS NOT BEEN PURCHASED");
          }
          
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
        else if(input.equals("FPR "))
        {
          double minPrice = commandLine.nextDouble();
          if(commandLine.hasNextDouble() == true)
          {
            continue;
          }

          double maxPrice = commandLine.nextDouble();
          if(commandLine.hasNextDouble() == false)
          {
            continue;
          }

          if(minPrice < 0 || minPrice > maxPrice)
          {
            System.out.println("IMPROPER PRICE RANGE!");
          }

          dealership.filterByPrice(minPrice, maxPrice);

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
          System.out.println("INVALID COMMAND!");
        }
      }
  }

}