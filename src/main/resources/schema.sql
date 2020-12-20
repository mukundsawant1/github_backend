DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS repo;

create table actor (
id BIGINT,
login varchar(100),
avatar_url varchar(200),
 PRIMARY KEY (id)
);

create table event(
  id BIGINT,
  type varchar(100),
  created_at TIMESTAMP,
  avatar_id BIGINT,
   PRIMARY KEY (id),
  foreign key (avatar_id) references actor(id)
);

create table repo(
 	id BIGINT,
    name varchar(100),
    url  varchar(100),
    avatar_id BIGINT,
     PRIMARY KEY (id),
    foreign key (avatar_id) references actor(id)
);
