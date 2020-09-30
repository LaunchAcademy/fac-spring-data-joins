create table schools (
id SERIAL PRIMARY KEY,
name VARCHAR(255) not null,
description VARCHAR(1000)
);

create table spells (
id SERIAL PRIMARY KEY,
name VARCHAR(255) not null,
level INTEGER not null,
description VARCHAR(1000) not null,
school_id INTEGER not null REFERENCES schools(id)
);