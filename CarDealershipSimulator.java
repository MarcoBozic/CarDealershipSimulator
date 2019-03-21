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
	  //creates a CarDealership object
    CarDealership dealership = new CarDealership();
	
    //new car objects of different types
    carList.add(new Car("Toyota","blue","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.5,500,false,25000));
    carList.add(new Car("Honda","red","SPORTS",Vehicle.PowerSource.GAS_ENGINE,9.2,450,false,30000));
    carList.add(new Car("Kia","white","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.7,550,false,20000));
    carList.add(new Car("BMW","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.6,600,true,55000));
    carList.add(new ElectricCar("Tesla","red","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,9.1,425,true,85000,"Lithium",30));
    carList.add(new Car("Chevy","red","MINIVAN",Vehicle.PowerSource.GAS_ENGINE,9.25,475,false,40000));
    carList.add(new ElectricCar("ChevyColt","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.9,375,true,37000,"Lithium",45));
    carList.add(new Car("Bentley","black","SEDAN",Vehicle.PowerSource.GAS_ENGINE,9.8,575,false,150000));
    carList.add(new ElectricCar("NissanLeaf","green","SEDAN",Vehicle.PowerSource.ELECTRIC_MOTOR,8.8,325,true,32000,"Lithium",55));

	  //scanner object used for reading input
	  Scanner scanner = new Scanner(System.in);
	  //while the scanner has another line
	  //read the input line
      while(scanner.hasNextLine())
      {
        //another scanner object that uses input line instead of System.in
        Scanner commandLine = new Scanner(scanner.nextLine());
        //reads the next word from the commandLine scanner
        String input = commandLine.next();

        //checks to see if the word(string) is equal to one of the commands and if so, calls the appropriate method via the CarDealership object
        //outputs the carList
        if(input.equals("L"))
        {
          //calls the displayInventory method
          dealership.displayInventory();
        }
        //quits the program
        else if (input.equals("Q"))
        {
          return;
        }
        //buys a car and takes it out of carList
        else if(input.equals("BUY"))
        {
            if(commandLine.hasNextInt())
            {
              int i = commandLine.nextInt();
              //checks to see if index is greater than carList to prevent program from crashing
              if (i > carList.size())
              {
                System.out.println("INDEX CANNOT BE GREATER THAN CAR LIST!");
              }
              //checks to see if index is less than zero to prevent program from crashing
              if (i < 0)
              {
                System.out.println("INDEX CANNOT BE LESS THAN ZERO!");
              }
              //takes car out of carList and saves car object in latestPurchase
              if (i < carList.size() && i >= 0)
              {
                //car object that is purchased
                Car carBought = carList.get(i);
                //calls the buyCar method
                Car car = dealership.buyCar(carList.get(i),i);
                //updates the last car that has been purchased
                latestPurchase = carBought;
              }
            
            }
            //forces user to enter an index value
            else 
            {
              System.out.println("ENTER AN INDEX VALUE!");
            }
        }
        //returns previous purchase into carList
        else if(input.equals("RET"))
        {
          //if a car has been purchased it will run the returnCar method
          if (latestPurchase != null)
          {
            //calls the returnCar method
            dealership.returnCar(latestPurchase);
          }  
          //program does not return a car object if a car has been purchased 
          else
          {
            System.out.println("A CAR HAS NOT BEEN PURCHASED!");
          }
          
        }
        //adds all the car object to the ArrayList
        else if(input.equals("ADD"))
        {
          //calls the addCars method
          dealership.addCars(carList);
        }
        //sorts car objects by price
        else if(input.equals("SPR"))
        {
          //calls the sortByPrice method
          dealership.sortByPrice();
        }
        //sorts car objects by safety rating
        else if (input.equals("SSR"))
        {
          //calls the sortBySafetyRating method
          dealership.sortBySafetyRating();
        }
        //sorts car objects by max range
        else if (input.equals("SMR"))
        {
          //calls the sortByMaxRange method
          dealership.sortByMaxRange();
        }
        //filters car objects between a price range
        else if(input.equals("FPR"))
        {
          //values of minimum and maximum price
          double minPrice = commandLine.nextDouble();
          double maxPrice = commandLine.nextDouble();
          //if first input is double then the program will check the next value
          if(commandLine.hasNextDouble() == true)
          {
            continue;
          }
          //if second input is a double then the program will continue
          if(commandLine.hasNextDouble() == true)
          {
            continue;
          }
          //if the inputted price is below zero or if the minimum price is greater than the maximum price then the program will not continue
          if(minPrice < 0 || minPrice > maxPrice)
          {
            System.out.println("IMPROPER PRICE RANGE!");
          }
          //calls the filterByPrice method
          dealership.filterByPrice(minPrice, maxPrice);
          
        }
        //only displays the electric cars
        else if(input.equals("FEL"))
        {
          //calls the filterByElectric method
          dealership.filterByElectric();
        }
        //only displays the AWD cars
        else if (input.equals("FAW"))
        {
          //calls the filterByAWD method
          dealership.filterByAWD();
        }
        //clears all filters
        else if (input.equals("FCL"))
        {
          //calls the filtersClear method
          dealership.filtersClear();
        }
        //does not crash program if unknown command is entered
        else
        {
          System.out.println("INVALID COMMAND!");
        }
      }
  }

}