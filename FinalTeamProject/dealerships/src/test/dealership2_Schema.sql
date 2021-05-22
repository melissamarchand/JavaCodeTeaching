create DATABASE if not exists dealership;
use dealership;
drop table if exists transactions;
drop table if exists employees;
drop table if exists vehicles;
drop table if exists dealerships;
drop table if exists customers;
create table customers ();
create table dealerships ();
create table vehicles ();
create table employees ();
create table transactions (
  transaction_ID int (10 NOT NULL AUTO_INCREMENT),
  vehicle_ID int (10) NOT NULL,
  customer_ID int(10) NOT NULL,
  employee_ID int(10) NOT NULL,
  dealership_ID int(10) NOT NULL,
  datestamp date NOT NULL,
  PRIMARY KEY (transaction_ID),
  FOREIGN KEY (vehicle_ID) REFERENCES vehicles(vehicle_ID),
  FOREIGN KEY (customer_ID) REFERENCES customers(customer_ID),
  FOREIGN KEY (employee_ID) REFERENCES employees(employee_ID),
  FOREIGN KEY (dealership_ID) REFERENCES dealerships(dealership_ID)