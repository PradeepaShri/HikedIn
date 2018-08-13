package models;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.mvc.PathBindable;

@Entity
@Table(name="hike")
public class Hike extends Model {
  
  @Id
  @Column(name="hike_id")
  public Integer hike_id;
  
  @Column(name="hike_name")
  public String hike_name;
  
  @Column(name="hike_distance")
  public Double hike_distance;
  
  public static final Finder<Integer, Hike> find = new Finder<>(Hike.class);
  
  public Hike(Integer hike_id, String hike_name, Double hike_distance){
    this.hike_id = hike_id;
    this.hike_name = hike_name;
    this.hike_distance = hike_distance;
  }
  
  public Boolean setHikeName(String hike_name){
    this.hike_name = hike_name;
    return Boolean.TRUE;
  }
  
  public static Boolean addHike(Integer hike_id, String hike_name, Double hike_distance){
    Hike hike = new Hike(hike_id, hike_name, hike_distance);
    hike.save();
    return Boolean.TRUE;
  }
  
  public static List<Hike> getAllHikes(){
    return Hike.find.all();
  }
  
  public static Hike getHikeNameByHikeId(Integer hike_id){
    return Hike.find.byId(hike_id);
  }
  
  public static Boolean deleteHikeByHikeId(Integer hike_id){
    Hike hike = Hike.find.byId(hike_id);
    return hike.delete();
  }
  
  public static Boolean updateHikeByHikeId(Integer hike_id, String hike_name){
    Hike hike = Hike.find.byId(hike_id);
    hike.setHikeName(hike_name);
    hike.save();
    return Boolean.TRUE;
  }
}
