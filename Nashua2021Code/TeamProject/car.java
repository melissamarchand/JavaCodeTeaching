package entities;

//handles and holds data
public class car {

  // these match the db table fields
  private int carId;
  private String make;
  private String model;
  private int year;
  private double cost;

  // constructor
  public car(int carId, String make, String model, int year, double cost) {
    this.setCarId(carId);
    this.setMake(make);
    this.setModel(model);
    this.setYear(year);
    this.setCost(cost);
  }

  // getters and setters
  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

}
