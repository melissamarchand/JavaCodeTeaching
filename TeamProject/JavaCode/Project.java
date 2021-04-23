import java.util.Scanner;
public class Project{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Bool loop = true;
        while (loop){
            menuText();
            String selection = sc.nextLine();
            switch(selection){
                case "1": 
                    buyCar(); break;
                case "2": 
                    sellCar();  break;
                case "3": 
                    updatePrice(); break;
                case "4": 
                    listCars(); break;
                case "5": 
                    newCustomer(); break;
                case "6": 
                    updateCustomer(); break;
                case "7": 
                    deleteCustomer(); break;
                case "8": 
                    listCustomer(); break;
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

    private static void buyCar(){
        System.out.println("what is the year of the car being bought?");
        int year = sc.nextLine();
        System.out.println("what is the make of the car being bought?");
        String make = sc.nextLine();
        System.out.println("what is the model of the car being bought?");
        String model = sc.nextLine();
        System.out.println("what is the description of the car being bought?");
        String description = sc.nextLine();
        System.out.println("what is the price of the car being bought?");
        Double price = sc.nextLine();
        CAR_SelectFromTable.insertCarRecord(year, make, model, description, price);
    }

    private static void sellCar(){
        System.out.println("What car would you like to sell");
        String sellCar = sc.nextLine();
        DeleteARecord.deleteRecord(sellCar);
    }

    private static void updatePrice(){
        System.out.println("What percent is the sale?");
        int sale = sc.nextLine();
        updateCarSale(sale);
    }

    private static void listCars(){
        listInventory();
    }

    private static void newCustomer(){
        System.out.println("What is the customer's name?");
        String name = sc.nextLine(); 
        System.out.println("what is the customers email?");
        String email = sc.nextLine(); 
        System.out.println("what is the customer's address?");
        String address = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String phone number = sc.nextLine();
        insertCustRecord(name, email, address, phone number);
    }

    private static void updateCustomer(){
        System.out.println("What customer would you like to update?");
        String update = sc.nextLine();
        System.out.println("What is the customer's name?");
        String customer name = sc.nextLine();
        System.out.println("what is the customers email?");
        String email = sc.nextLine();
        System.out.println("what is the customer's address?");
        String customer address = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String phone number = sc.nextLine();
        updateCustRecord(update, customer name, email, customer address, phone number );
    }

    private static void deleteCustomer(){
        System.out.println("What customer would you like to delete?");
        String delete = sc.nextLine();
        deleteCustRecord(delete);
    }

    private static void listCustomer(){
        System.out.println("What customer would you like to list?");
        String list = sc.nextLine();
        ListCustRecord(list);
    }

}