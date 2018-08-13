package controllers;

import java.util.List;
import models.Product;
import play.mvc.*;
import views.html.*;

public class ProductsController extends Controller {
  
  public Result getProducts() {
    List<Product> getListOfProducts = Product.getListOfProducts();
    return ok(list.render(getListOfProducts));
  }
  
  public Result addNewProduct(String productId) {
    Product.addProduct(productId, "new product");
    return this.getProducts();
  }
  
  public Result deleteProduct(String productId){
    return ok("delete product" + productId);
  }
  
  public Result updateProduct(String productId){
    return ok("update product" + productId);
  }
}
