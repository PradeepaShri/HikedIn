package models;

import java.util.List;
import java.util.ArrayList;


public class Product {
  
  public String productId;
  public String productName;
  
  private static List<Product> listOfProducts;
  
  static {
    listOfProducts = new ArrayList<>();
    listOfProducts.add(new Product("111", "Product one"));
    listOfProducts.add(new Product("222", "Product two"));
    listOfProducts.add(new Product("333", "Product three"));
  }
  
  public Product(String productId, String productName) {
    this.productId = productId;
    this.productName = productName;
  }
  
  public String toString(){
    return "Product ID: " + this.productId + " Product Name: " + this.productName;
  }
  
  public static List<Product> getListOfProducts(){
    return Product.listOfProducts;
  }
  
  public static void addProduct(String productId, String productName){
    
    Product newProduct = new Product(productId, productName);
    Product.listOfProducts.add(newProduct);
  }
}
