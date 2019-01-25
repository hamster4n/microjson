create sequence hibernate_sequence start 1 increment 1;

create table document (
  count_id int8 not null,
  date_modified varchar(255),
  date_published varchar(255),
  description varchar(255),
  document_of varchar(255),
  document_type varchar(255),
  format varchar(255),
  hash varchar(255),
  json_id varchar(255),
  title varchar(255),
  url varchar(255),
  primary key (count_id)
);