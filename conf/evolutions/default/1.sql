# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hike (
  hike_id                       integer auto_increment not null,
  hike_name                     varchar(255),
  hike_distance                 double,
  region_name                   varchar(255),
  difficulty_level              integer,
  latitude                      double,
  longitude                     double,
  average_temperature           double,
  constraint pk_hike primary key (hike_id)
);

create table review (
  review_id                     integer auto_increment not null,
  description                   varchar(255),
  created_datetime              datetime(6),
  hike_hike_id                  integer,
  constraint pk_review primary key (review_id)
);

create table user (
  user_id                       integer auto_increment not null,
  user_name                     varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (user_id)
);

alter table review add constraint fk_review_hike_hike_id foreign key (hike_hike_id) references hike (hike_id) on delete restrict on update restrict;
create index ix_review_hike_hike_id on review (hike_hike_id);


# --- !Downs

alter table review drop foreign key fk_review_hike_hike_id;
drop index ix_review_hike_hike_id on review;

drop table if exists hike;

drop table if exists review;

drop table if exists user;

