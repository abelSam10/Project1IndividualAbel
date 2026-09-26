import java.io.*;
/*
 Dummy Product class, used only to test UserInterface.
 */
public class Product implements Serializable {
  private String id;
  private String name;
  private int quantity;
  private double salePrice;

  public Product(String id, String name, int quantity, double salePrice) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.salePrice = salePrice;
  }

  public String getId() {
    return id;
  }

  public String toString() {
    return String.format("Product %-4s name: %-10s qty: %-5d price: $%.2f",
        id, name, quantity, salePrice);
  }
}
