package requestobjects;

public class ReviewRequestObject {
  
  public Integer hike_id;
  public String description;
  
  public ReviewRequestObject(Integer hike_id, String description){
    this.hike_id = hike_id;
    this.description = description;
  }
  
  public ReviewRequestObject(){}
}
