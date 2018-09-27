package dao;
import com.google.inject.ImplementedBy;
import dao.impl.HikeDAOImpl;
import java.util.List;
import models.Hike;

@ImplementedBy(HikeDAOImpl.class)
public interface HikeDAO {
  
  List<Hike> getListOfAllHikes();
  
  Hike getHike(Hike hike);
  
  Hike addHike(Hike hike);
  
  Hike updateHike(Hike hike);
  
  Boolean deleteHike(Hike hike);
}
