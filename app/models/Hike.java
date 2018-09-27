package models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.mvc.PathBindable;

@Entity
@Table(name="hike")
public class Hike extends Model implements PathBindable<Hike> {
  
  @Id
  @Column(name="hike_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer hike_id;
  
  @Column(name="hike_name")
  public String hike_name;
  
  @Column(name="hike_distance")
  public Double hike_distance;
  
  @Column(name="region_name")
  public String region_name;
  
  @Column(name="difficulty_level")
  public Integer difficulty_level;
  
  @Column(name="latitude")
  public Double latitude;
  
  @Column(name="longitude")
  public Double longitude;
  
  @Column(name="average_temperature")
  public Double average_temperature;
  
  @OneToMany(mappedBy = "hike")
  List<Review> listOfReviews = new ArrayList<Review>();
  
  public static final Finder<Integer, Hike> find = new Finder<>(Hike.class);
  
  public Hike(String hike_name, Double hike_distance){
    this.hike_name = hike_name;
    this.hike_distance = hike_distance;
  }
  
  public void setHikeName(String hike_name){
    this.hike_name = hike_name;
  }
  
  public void setHikeDistance(Double hike_distance){
    this.hike_distance = hike_distance;
  }
  
  public void setRegionName(String region_name){
    this.region_name = region_name;
  }
  
  public void setDifficultyLevel(Integer difficulty_level ){
    this.difficulty_level = difficulty_level;
  }
  
  public void setLatitude(Double latitude ){
    this.latitude = latitude;
  }
  
  public void setLongitude(Double longitude ){
    this.longitude = longitude;
  }
  
  public void setAverageTemperature(Double average_temperature ){
    this.average_temperature = average_temperature;
  }
  
  public Boolean addReview(Review review){
    this.listOfReviews.add(review);
    return Boolean.TRUE;
  }
  
  public List<Review> getListOfReviews(){
    return listOfReviews;
  }
  
  public static Hike findByHikeId(Integer hike_id){
    Hike hike = Hike.find.byId(hike_id);
    return hike;
  }
  
  @Override public Hike bind(String key, String txt) {
    Integer hike_id = Integer.valueOf(txt);
    Hike hike = findByHikeId(hike_id);
    return hike;
  }
  
  @Override public String unbind(String key) {
    return this.hike_name;
  }
  
  @Override public String javascriptUnbind() {
    return this.hike_name;
  }
}
