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
