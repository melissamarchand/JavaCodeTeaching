//package entities;

//handles and holds data
public class invoice {

  // these match the db table fields
  private int invoiceID;
  private String orderDate;
  private double finalPrice;

  // constructor
  public invoice(int invoiceID, String orderDate, double finalPrice) {
    this.invoiceID = invoiceID;
    this.orderDate = orderDate;
    this.finalPrice = finalPrice;
  }

  // getters and setters
  public int getInvoiceID() {
    return invoiceID;
  }

  public void InvoiceID(int invoiceID) {
    this.invoiceID = invoiceID;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public double getFinalPrice() {
    return finalPrice;
  }

  public void setgetFinalPrice(double finalPrice) {
    this.finalPrice = finalPrice;
  }

}