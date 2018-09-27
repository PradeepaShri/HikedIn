package dao.impl;

import java.util.List;
import javax.persistence.PersistenceException;
import models.Hike;
import dao.HikeDAO;

public class HikeDAOImpl implements HikeDAO {
  
  @Override public List<Hike> getListOfAllHikes() {
    return Hike.find.all();
  }
  
  @Override public Hike getHike(Hike hike) {
    return hike;
  }
  
  @Override public Hike addHike(Hike hike) throws PersistenceException {
    hike.save();
    return hike;
  }
  
  @Override public Boolean deleteHike(Hike hike) throws NullPointerException {
    return hike.delete();
  }
  
  @Override public Hike updateHike(Hike hike) throws NullPointerException {
    Hike existingHike = Hike.find.byId(hike.hike_id);
    existingHike.setHikeName(hike.hike_name);
    existingHike.setHikeDistance(hike.hike_distance);
    existingHike.save();
    return existingHike;
  }
}
