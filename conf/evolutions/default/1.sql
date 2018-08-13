# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hike (
  hike_id                       integer auto_increment not null,
  hike_name                     varchar(255),
  hike_distance                 double,
  constraint pk_hike primary key (hike_id)
);


# --- !Downs

drop table if exists hike;

