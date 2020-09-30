CREATE TABLE classes (
  id SERIAL PRIMARY KEY,
  type VARCHAR(255) NOT NULL,
  hit_dice INTEGER NOT NULL,
  primary_stat VARCHAR NOT NULL

);

CREATE TABLE characters (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  class_id INTEGER NOT NULL REFERENCES classes(id),
  race VARCHAR(255) NOT NULL,
  background TEXT,
  level INTEGER NOT NULL
);