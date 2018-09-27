package controllers;

import com.google.inject.Inject;
import java.util.concurrent.CompletableFuture;
import models.Hike;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import play.libs.Json;
import dao.HikeDAO;
import java.util.List;

public class HikeController extends Controller {
  
  @Inject HikeDAO hikeDAO;
  private HttpExecutionContext httpExecutionContext;
  
  @Inject
  public HikeController(HttpExecutionContext ec) {
    this.httpExecutionContext = ec;
  }
  
  public CompletableFuture<Result> getListOfAllHikes() {
    return CompletableFuture
      .supplyAsync(() -> hikeDAO.getListOfAllHikes())
      .thenApply((List<Hike> listOfAllHikes) -> ok(Json.toJson(listOfAllHikes)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> getHike(Hike hike) {
    return CompletableFuture
      .supplyAsync(() -> hikeDAO.getHike(hike))
      .thenApply((Hike retrievedHike) -> ok(Json.toJson(retrievedHike)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> addHike() {
    return CompletableFuture
      .supplyAsync(() -> Json.fromJson(request().body().asJson(), Hike.class), httpExecutionContext.current())
      .thenApply((Hike hike) -> hikeDAO.addHike(hike))
      .thenApply((Hike addedHike) -> ok(Json.toJson(addedHike)))
      .exceptionally(ex -> forbidden("Given hike already exists"));
  }
  
  public CompletableFuture<Result> updateHike() {
    return CompletableFuture
      .supplyAsync(() -> Json.fromJson(request().body().asJson(), Hike.class), httpExecutionContext.current())
      .thenApply((Hike hike) -> hikeDAO.updateHike(hike))
      .thenApply((Hike updatedHike) -> ok(Json.toJson(updatedHike)))
      .exceptionally(ex -> notFound());
  }
  
  public CompletableFuture<Result> deleteHike(Hike hike) {
    return CompletableFuture
      .supplyAsync(() -> hikeDAO.deleteHike(hike))
      .thenApply((deleteHikeResult) -> ok("Hike deleted Successfully.."))
      .exceptionally(ex -> notFound());
  }
}

