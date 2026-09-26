import java.io.*;
/*
 Dummy Client class, used only to test UserInterface.
 */
public class Client implements Serializable {
  private String id;
  private String name;
  private String address;
  private String phone;
  private double balance;

  public Client(String id, String name, String address, String phone) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.balance = 0.0;
  }

  public String getId() {
    return id;
  }

  public String toString() {
    return String.format("Client %-4s name: %-10s address: %-12s phone: %-12s balance: $%.2f",
        id, name, address, phone, balance);
  }
}
