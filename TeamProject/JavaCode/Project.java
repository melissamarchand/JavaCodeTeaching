import java.util.Scanner;
import SelectCarFromTable;
public class Project{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Bool loop = true;
        while (loop){
            menuText();
            String selection = sc.nextLine();
            switch(selection){
                case "1": 
                    buyCar(sc); break;
                case "2": 
                    sellCar(sc);  break;
                case "3": 
                    updatePrice(sc); break;
                case "4": 
                    listCars(); break;
                case "5": 
                    newCustomer(sc); break;
                case "6": 
                    updateCustomer(sc); break;
                case "7": 
                    deleteCustomer(sc); break;
                case "8": 
                    listCustomer(sc); break;
                case "9": 
                    loop = false; break;
                default: 
                    System.out.println("Error please reselect option"); break;
            }

        }
        sc.close();

    }

    private static void menuText(){
        System.out.println("Menu: ");
        System.out.println("1: buy a car");
        System.out.println("2: sell a car");
        System.out.println("3: Car sale");
        System.out.println("4: list all cars");
        System.out.println("5: New customer");
        System.out.println("6: Update customer");
        System.out.println("7: Delete customer");
        System.out.println("8: List customer");
        System.out.println("9: quit");
    }

    private static void buyCar(Scanner sc){
        System.out.println("what is the year of the car being bought?");
        int year = sc.nextInt();
        System.out.println("what is the make of the car being bought?");
        String make = sc.nextLine();
        System.out.println("what is the model of the car being bought?");
        String model = sc.nextLine();
        System.out.println("what is the description of the car being bought?");
        String description = sc.nextLine();
        System.out.println("what is the price of the car being bought?");
        Double price = sc.nextDouble();
        InsertACarRecord.insertCarRecord(year, make, model, description, price);
    }

    private static void sellCar(Scanner sc){
        System.out.println("What car would you like to sell");
        int carId = sc.nextInt();
        DeleteARecord.deleteRecord(carId);
    }

    private static void updatePrice(Scanner sc){
        System.out.println("What percent is the sale?");
        int carId = sc.nextInt();
        UpdateACarRecord.updateCarSale(carId);
    }

    private static void listCars(){
        SelectCarFromTable.listInventory();
    }

    private static void newCustomer(Scanner sc){
        System.out.println("What is the customer's name?");
        String name = sc.nextLine(); 
        System.out.println("what is the customers email?");
        String email = sc.nextLine(); 
        System.out.println("what is the customer's address?");
        String address = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String phonenumber = sc.nextLine();
        InsertACustRecord.insertCustRecord(name, email, address, phonenumber);
    }

    private static void updateCustomer(Scanner sc){
        System.out.println("What customer would you like to update?");
        int update = sc.nextInt();
        System.out.println("What is the customer's name?");
        String name = sc.nextLine();
        System.out.println("what is the customers email?");
        String email = sc.nextLine();
        System.out.println("what is the customer's address?");
        String address = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String phonenumber = sc.nextLine();
        UpdateACustRecord.updateCustRecord(update, name, email, address, phonenumber);
    }

    private static void deleteCustomer(Scanner sc){
        System.out.println("What customer would you like to delete?");
        int custId = sc.nextInt();
       DeleteACustRecord.deleteCustRecord(custId);
    }

    private static void listCustomer(Scanner sc){
        System.out.println("What customer would you like to list?");
        int custId = sc.nextInt();
        SelectCustFromTable.ListCustRecord(custId);
    }

}