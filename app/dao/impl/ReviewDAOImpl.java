package dao.impl;

import java.util.ArrayList;
import java.util.List;
import models.Hike;
import models.Review;
import dao.ReviewDAO;
import requestobjects.ReviewRequestObject;

public class ReviewDAOImpl implements ReviewDAO {
  
  @Override public List<Review> getListOfAllReviews() {
    List<Review> listOfAllReviews = new ArrayList<>();
    for (Hike hike : new HikeDAOImpl().getListOfAllHikes()) {
      listOfAllReviews.addAll(hike.getListOfReviews());
    }
    return listOfAllReviews;
  }
  
  @Override public List<Review> getListOfAllReviewsForHike(Hike hike) throws NullPointerException {
    List<Review> listOfAllReviewsForHike = new ArrayList<>();
    listOfAllReviewsForHike.addAll(hike.getListOfReviews());
    return listOfAllReviewsForHike;
  }
  
  public Review addReview(ReviewRequestObject reviewRequestObject) throws NullPointerException {
    Review review = new Review(reviewRequestObject.description);
    Hike hike = Hike.findByHikeId(reviewRequestObject.hike_id);
    
    boolean isDuplicateReview = hike.getListOfReviews().parallelStream()
      .anyMatch((Review existingReview) -> review.description.equals(existingReview.description));
    
    if (!isDuplicateReview) {
      review.setHike(hike);
      hike.addReview(review);
      review.save();
      return review;
    } else {
      return null;
    }
  }
  
  @Override public Boolean deleteReview(Review review) throws NullPointerException {
    return review.delete();
  }
  
  @Override public Review updateReview(ReviewRequestObject reviewRequestObject, Review review) throws NullPointerException {
    Review existingReview = Review.find.byId(review.review_id);
    existingReview.setDescription(reviewRequestObject.description);
    existingReview.save();
    return existingReview;
  }
}
