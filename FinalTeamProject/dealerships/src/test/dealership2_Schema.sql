create DATABASE if not exists dealership;
use dealership;
drop table if exists transactions;
drop table if exists employees;
drop table if exists vehicles;
drop table if exists dealerships;
drop table if exists customers;
CREATE TABLE customers (
  customerID int (10) NOT NULL AUTO_INCREMENT,
  name varchar(45),
  address varchar(45),
  phone varchar(20),
  PRIMARY KEY (customerID)
);
create table dealerships ();
CREATE TABLE vehicles (
  vehicleID int (10) NOT NULL AUTO_INCREMENT,
  dealershipID int (10) NOT NULL AUTO_INCREMENT,
  is_sold boolean NOT NULL,
  price decimal(9, 2) NOT NULL,
  model varchar(40) NOT NULL,
  make varchar(40) NOT NULL,
  PRIMARY KEY (vehicleID),
  FOREIGN KEY (dealershipID) REFERENCES dealerships(dealershipID)
);
create table employees ();
create table transactions (
  transactionID int (10 NOT NULL AUTO_INCREMENT),
  vehicleID int (10) NOT NULL,
  customerID int(10) NOT NULL,
  employeeID int(10) NOT NULL,
  dealershipID int(10) NOT NULL,
  datestamp date NOT NULL,
  PRIMARY KEY (transactionID),
  FOREIGN KEY (vehicleID) REFERENCES vehicles(vehicleID),
  FOREIGN KEY (customerID) REFERENCES customers(customerID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID),
  FOREIGN KEY (dealershipID) REFERENCES dealerships(dealershipID)
