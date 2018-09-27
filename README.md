# HikedIn
----------

This simple java play application lets you add and update hikes along with reviews.

#### To run the application

1.  Start a local mysql database and update the configuration file located in `conf/application.conf` with the `url, username and password`
2.  In your terminal, cd into the root dir of the project and run the command `sbt run`. This should open up a browser with the default url `localhost:9000`
3.  You can use the routes specified in the `conf/routes` files. Listed below are the Urls.
    ```
    #Hike urls
    GET     /hikes
    GET     /hikes/:hikeId
    POST    /hikes
    PUT     /hikes
    DELETE  /hikes/:hikeId

    # Review urls
    GET     /reviews
    GET     /reviews/:hikeId
    POST    /reviews
    PUT     /reviews/:reviewId
    DELETE  /reviews/:review
    ```


#### Controllers

- HikeController.java:

  An async controller for performing CRUD operations for Hikes.

- ReviewController.java:

  An async controller for performing CRUD operations for Reviews.

#### Future work

- [ ] Add unit/integration tests for all controllers
- [ ] Add user profiles and relationships
- [ ] Host the application on a AWS server
- [ ] Create native android application support

