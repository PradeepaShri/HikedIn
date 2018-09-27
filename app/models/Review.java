package models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.mvc.PathBindable;
import java.sql.Timestamp;

@Entity
@Table(name="review")
public class Review extends Model implements PathBindable<Review> {
  
  @Id
  @Column(name="review_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Integer review_id;
  
  @Column(name="description")
  public String description;
  
  @Column(name="created_datetime")
  public Timestamp created_datetime;
  
  @ManyToOne
  @JsonIgnore
  Hike hike;
  
  public static final Finder<Integer, Review> find = new Finder<>(Review.class);
  
  public Review(String description){
    this.description = description;
    this.created_datetime = new Timestamp(System.currentTimeMillis());
  }
  
  public void setDescription(String description){
    this.description = description;
  }
  
  public void setHike(Hike hike){
    this.hike = hike;
  }
  
  public Hike getHike(){
    return this.hike;
  }
  
  public String getDescription(){
    return this.description;
  }
  
  public static Review findByReviewId(Integer reviewId){
    Review review = Review.find.byId(reviewId);
    return review;
  }
  
  @Override public Review bind(String key, String txt) {
    
    Integer review_id = Integer.valueOf(txt);
    Review review = findByReviewId(review_id);
    return review;
  }
  
  @Override public String unbind(String key) {
    return this.description;
  }
  
  @Override public String javascriptUnbind() {
    return this.description;
  }
}
