import java.util.Scanner;
public class Project{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Bool loop = true;
gfbdfgbdfgnbdfgndfb
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
        InsertCarRecord.deleteRecord(year, make, model, description, price);
    }

    private static void sellCar(){
        System.out.println("What car would you like to sell");
        String response = sc.nextLine();
        DeleteARecord.deleteRecord(response);
    }

    private static void updatePrice(){

    }

    private static void listCars(){

    }

    private static void newCustomer(){
        System.out.println("What is the customer's name?");
        String response1 = sc.nextLine(); 
        System.out.println("what is the customers email?");
        String response2 = sc.nextLine(); 
        System.out.println("what is the customer's address?");
        String response3 = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String response4 = sc.nextLine();
        insertCustRecord(response1, response2, response3, response4);
    }

    private static void updateCustomer(){
        System.out.println("What customer would you like to update?");
        String response = sc.nextLine();
        System.out.println("What is the customer's name?");
        String response1 = sc.nextLine();
        System.out.println("what is the customers email?");
        String response2 = sc.nextLine();
        System.out.println("what is the customer's address?");
        String response3 = sc.nextLine();
        System.out.println("What is the customers phone number?");
        String response4 = sc.nextLine();
        updateCustRecord(response, response1, response2, response3, response4);
    }

    private static void deleteCustomer(){
        System.out.println("What customer would you like to delete?");
        String response = sc.nextLine();
        deleteCustRecord(response);
    }

    private static void listCustomer(){
        System.out.println("What customer would you like to list?");
        String response = sc.nextLine();
        ListCustRecord(response);
    }

}