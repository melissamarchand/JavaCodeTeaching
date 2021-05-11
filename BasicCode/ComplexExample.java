package BasicCode;


//Base class
class Box{

    //Default constructor should be empty for inheritance if needed
    public Box(){}
	
	public void printBox()
	{
		System.out.println("The is a box");
	}
}
class Box2{
    //Box variables
    private final String brandName = "Big Box Comp";
    private int width;
    private int lenght;
    private int height;
    public boolean isOpen = false; //Defaults to being closes

    //Constructor
    //Creates a new box object
    public Box2(int width_param, int lenght_param, int height_param)
    {
        //Assign object variable with parameters from method
        this.width = width_param;
        this.lenght = lenght_param;
        this.height = height_param;
    }

    //Default constructor should be empty for inheritance if needed
    public Box2(){}

    //Object Methods
    public int volume()
    {
        return this.width * this.lenght * this.height;
    }
    public void openBox()
    {
        isOpen = true;
        System.out.println("The Box is open");
    }
    public void closeBox(){
        isOpen = false;
        System.out.println("The Box is closed");
    }



    //Setter methods
    public void setWidth(int width){this.width = width;}
    public void setLenght(int lenght){this.lenght = lenght;}
    public void setHeight(int height){this.height = height;}

    //Getter methods
    public String getBoxName(){return this.brandName;}
    public int getWidth(){return this.width;}
    public int getLenght(){return this.lenght;}
    public int getHeight(){return  this.height;}
    public boolean getClosedStatus(){return this.isOpen;}
    //Better descriptive getter method which is more specialized
    public String betterGetClosedStatus(){
        if(this.isOpen == false){return "The box is closed";}else {return "The box is open";}

    }

}
//Extended class (Inheritance) This will use the default constrictor from the Box class
class ShippingBox extends Box2{

    //Special variables
    public String destination;
    public String reciver;

    // Constructor
    public ShippingBox(int width, int lenght, int height, String destination, String reciver)
    {
        // invoking base-class (Box) constructor
        super(width, lenght, height); //build a sudo box2
        this.destination = destination;
        this.reciver = reciver;
    }

    //Special Methods
    public void printDestination()
    {
        System.out.println("The Dstination is " + this.destination);
    }
    public void printReciver()
    {
        System.out.println("The Reciver is " + this.reciver);
    }
    

}

public class ComplexExample {

    public static void main(String[] args){
		
		Box lameBox = new Box();
		lameBox.printBox();

	   //public Box2(int width_param, int lenght_param, int height_param)
        Box2 box_one = new Box2(10,12,20);
        Box2 box_two = new Box2(5,5,5);

        //Check volume of the boxes
        int bOneVol = box_one.volume();
        int bTwoVol = box_two.volume();

        // Display areas.
        System.out.println(bOneVol);
        System.out.println(bTwoVol);

        //close box 1 but open box 2
        box_one.closeBox();
        box_two.openBox();

        //Work with just Box 1 from here
        //Display box 1 current variables
        System.out.println("Box 1 Status are: W=" + box_one.getWidth() + " L=" + box_one.getLenght() +" H=" + box_one.getHeight() +" Status= " + box_one.getClosedStatus());
        System.out.println("Box 1 Status are: W=" + box_one.getWidth() + " L=" + box_one.getLenght() +" H=" + box_one.getHeight() +" Status= " + box_one.betterGetClosedStatus());

        System.out.println("Altering Box 1");
        //Test out setter methods now
        box_one.setHeight(30);
        box_one.setWidth(40);
        box_one.setLenght(6);
        box_one.openBox(); //Open box as it is currently closed
        System.out.println("Box 1 Status are: W=" + box_one.getWidth() + " L=" + box_one.getLenght() +" H=" + box_one.getHeight() +" Status= " + box_one.betterGetClosedStatus());


        //Lets use inheritance as an example now
        ShippingBox shipBox = new ShippingBox(10,10,20,"Tokyo","Gus");
        shipBox.printDestination();
        shipBox.printReciver();
        System.out.println("ShipBox Status are: W=" + shipBox.getWidth() + " L=" + shipBox.getLenght() +" H=" + shipBox.getHeight() +" Status= " + shipBox.betterGetClosedStatus());




    }
}
