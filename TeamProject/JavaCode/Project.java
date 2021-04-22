import java.util.Scanner;
public class Project{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Boolean loop = true;

        while (loop){
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
            String selection = sc.nextLine();
            switch(selection){
                case "1": {
                    System.out.println("What car would you like to buy");
                    String response = sc.nextLine();
                    DeleteARecord.deleteRecord(response);
                } break;
                case "2": {
                    System.out.println("What car would you like to sell");
                    String response = sc.nextLine();
                    DeleteARecord.deleteRecord(response);
                } break;

                case "3": {} break;
                case "4": {
                    System.out.println("What car would you like to buy");
                    String response = sc.nextLine();} break;
                case "5": {} break;
                case "6": {} break;
                case "7": {} break;
                case "8": {} break;
                case "9": loop = false; break;
                default: System.out.println("Error please reselect option"); break;
            }

        }
        sc.close();

    }

}