package controllers;

import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import models.Hike;
import models.Review;
import play.libs.Json;
import play.mvc.*;
import dao.ReviewDAO;
import requestobjects.ReviewRequestObject;
import play.libs.concurrent.HttpExecutionContext;
import java.util.List;

public class ReviewController extends Controller {
  
  @Inject ReviewDAO reviewDAO;
  private HttpExecutionContext httpExecutionContext;
  
  @Inject
  public ReviewController(HttpExecutionContext ec) {
    this.httpExecutionContext = ec;
  }
  
  public  CompletableFuture<Result> getListOfAllReviews() {
    return CompletableFuture
      .supplyAsync(() -> reviewDAO.getListOfAllReviews())
      .thenApply((List<Review> listOfAllReviews) -> ok(Json.toJson(listOfAllReviews)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> getListOfAllReviewsForHike(Hike hike) {
    return CompletableFuture
      .supplyAsync(() -> reviewDAO.getListOfAllReviewsForHike(hike))
      .thenApply((List<Review> listOfAllReviewsForHike) -> ok(Json.toJson(listOfAllReviewsForHike)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> addReview() {
    return CompletableFuture
      .supplyAsync(() -> Json.fromJson(request().body().asJson(), ReviewRequestObject.class), httpExecutionContext.current())
      .thenApply((ReviewRequestObject reviewRequestObject) -> reviewDAO.addReview(reviewRequestObject))
      .thenApply((Review addedReview) -> {
        if (addedReview != null) {
          return ok(Json.toJson(addedReview));
        } else {
          return forbidden("Review with same description already exists");
        }})
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> updateReview(Review review) {
    return CompletableFuture
      .supplyAsync(() -> Json.fromJson(request().body().asJson(), ReviewRequestObject.class), httpExecutionContext.current())
      .thenApply((ReviewRequestObject reviewRequestObject) -> reviewDAO.updateReview(reviewRequestObject, review))
      .thenApply((Review updatedReview) -> ok(Json.toJson(updatedReview)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> deleteReview(Review review) {
    return CompletableFuture
      .supplyAsync(() -> reviewDAO.deleteReview(review))
      .thenApply((deleteReviewResult) -> ok("Review deleted successfully"))
      .exceptionally(ex -> notFound());
  }
}