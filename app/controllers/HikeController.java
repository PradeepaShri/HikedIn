package controllers;

import java.util.List;
import models.Hike;
import play.mvc.*;
import views.html.*;

public class HikeController extends Controller {
  
  public Result addNewHike(Integer hike_id, String hike_name, Double hike_distance) {
    Boolean result = Hike.addHike(hike_id, hike_name, hike_distance);
    return ok("Hike Added..." + hike_name);
  }
  
  public Result getAllHikes() {
    List<Hike> listOfAllHikes = Hike.getAllHikes();
    String listOfAllHikesAsString = " ";
    for (Hike hike : listOfAllHikes) {
      listOfAllHikesAsString = listOfAllHikesAsString.concat(hike.hike_name + '\n');
    }
    return ok("List of all hikes:\n" + listOfAllHikesAsString);
  }
  
  public Result getHikeNameByHikeId(Integer hike_id) {
    Hike hike = Hike.getHikeNameByHikeId(hike_id);
    return ok("Hike Name corresponding to Hike Id: " + hike_id.toString() + " is: " + hike.hike_name);
  }
  
  public Result deleteHikeByHikeId(Integer hike_id) {
    Boolean deleteHike = Hike.deleteHikeByHikeId(hike_id);
    if (deleteHike) {
      return ok("Hike corresponding to Hike Id: " + hike_id.toString() + " is deleted successfully");
    } else {
      return ok("Problem in deleting Hike corresponding to Hike Id: " + hike_id.toString());
    }
  }
  
  public Result updateHikeNameByHikeId(Integer hike_id, String hike_name) {
    Boolean updateHike = Hike.updateHikeByHikeId(hike_id, hike_name);
    return ok("Hike name corresponding to Hike Id: "
      + hike_id.toString()
      + " is updated successfully to"
      + hike_name);
  }
}
  
  
  //
  //public Result updateProduct(String productId){
  //  return ok("update product" + productId);
  //}

