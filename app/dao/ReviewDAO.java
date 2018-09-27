package dao;
import com.google.inject.ImplementedBy;
import dao.impl.ReviewDAOImpl;
import java.util.List;
import models.Hike;
import models.Review;
import requestobjects.ReviewRequestObject;

@ImplementedBy(ReviewDAOImpl.class)
public interface ReviewDAO {
  
  List<Review> getListOfAllReviews();
  
  List<Review> getListOfAllReviewsForHike(Hike hike);
  
  Review addReview(ReviewRequestObject reviewRequestObject);
  
  Review updateReview(ReviewRequestObject reviewRequestObject, Review review);
  
  Boolean deleteReview(Review review);
}
