import java.util.*;
import java.io.*;
/*
 Dummy Warehouse class, used only to test UserInterface.
 It keeps clients, products and wishlists in simple collections and
 generates ids C1, C2, ... and P1, P2, ... in the order they are added.
 */
public class Warehouse implements Serializable {
  private static Warehouse warehouse;
  private List<Client> clients = new LinkedList<Client>();
  private List<Product> products = new LinkedList<Product>();
  private Map<String, List<Product>> wishlists = new HashMap<String, List<Product>>();

  private Warehouse() {
  }

  public static Warehouse instance() {
    if (warehouse == null) {
      warehouse = new Warehouse();
    }
    return warehouse;
  }

  public Client addClient(String name, String address, String phone) {
    Client client = new Client("C" + (clients.size() + 1), name, address, phone);
    clients.add(client);
    wishlists.put(client.getId(), new LinkedList<Product>());
    return client;
  }

  public Product addProduct(String name, int quantity, double salePrice) {
    if (quantity < 0 || salePrice < 0) {
      return null;
    }
    Product product = new Product("P" + (products.size() + 1), name, quantity, salePrice);
    products.add(product);
    return product;
  }

  public boolean addToWishlist(String clientId, String productId, int quantity) {
    List<Product> wishlist = wishlists.get(clientId);
    Product product = findProduct(productId);
    if (wishlist == null || product == null || quantity <= 0) {
      return false;
    }
    wishlist.add(product);
    return true;
  }

  public Iterator<Client> getClients() {
    return clients.iterator();
  }

  public Iterator<Product> getProducts() {
    return products.iterator();
  }

  public Iterator<Product> getWishlist(String clientId) {
    List<Product> wishlist = wishlists.get(clientId);
    if (wishlist == null) {
      return null;
    }
    return wishlist.iterator();
  }

  private Product findProduct(String productId) {
    for (Product product : products) {
      if (product.getId().equals(productId)) {
        return product;
      }
    }
    return null;
  }
}
