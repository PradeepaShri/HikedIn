package models;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.mvc.PathBindable;

@Entity
@Table(name="user")
public class User extends Model {
  
  @Id
  @Column(name="user_id")
  public Integer user_id;
  
  @Column(name="user_name")
  public String user_name;
  
  @Column(name="password")
  public String password;
  
  public static final Finder<Integer, User> find = new Finder<>(User.class);
  
  public User(String user_name, Integer user_id){
    this.user_id = user_id;
    this.user_name = user_name;
  }
  
  public Boolean setUserName(String user_name){
    this.user_name = user_name;
    return Boolean.TRUE;
  }
  
  public static Boolean addUser(String user_name, Integer user_id){
    User user = new User(user_name, user_id);
    user.save();
    return Boolean.TRUE;
  }
  
  public static List<User> getAllUsers(){
    return User.find.all();
  }
  
  public static User getUserNameByUserId(Integer user_id){
    return User.find.byId(user_id);
  }
  
  public static Boolean deleteUserByUserId(Integer user_id){
    User user = User.find.byId(user_id);
    return user.delete();
  }
  
  public static Boolean updateUserNameByUserId(Integer user_id, String setUserName){
    User user = User.find.byId(user_id);
    user.setUserName(setUserName);
    user.save();
    return Boolean.TRUE;
  }
}
