create DATABASE if not exists dealership;
use dealership;
drop table if exists invoices;
drop table if exists cars;
drop table if exists customers;
create table cars (
  car_id int(10) not null AUTO_INCREMENT,
  year int(4) not null,
  make varchar(15) not null,
  model varchar(15) not null,
  description varchar(100),
  cost double(7, 2) not null,
  PRIMARY KEY(car_id)
);
create table customers (
  customer_id int(10) not NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT null,
  address VARCHAR (60) NOT null,
  phone VARCHAR(10) NOT NULL,
  email VARCHAR(20),
  PRIMARY KEY (customer_id)
);
create table invoices (
  invoice_id int (10) not NULL AUTO_INCREMENT,
  order_date date NOT null,
  final_price double (7, 2) NOT null,
  customer_id int(10),
  car_id int(10),
  PRIMARY KEY (invoice_id),
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
  FOREIGN KEY (car_id) REFERENCES cars(car_id)
);
INSERT INTO
  cars(car_id, year, make, model, description, cost)
VALUES
  (
    1,
    2014,
    "Honda",
    "CRV",
    "blue premium package",
    20600
  ),
  (
    2,
    2018,
    "Subaru",
    "Outback",
    "red base package",
    21100
  );
  INSERT INTO
  customers(customer_id, name, address, phone, email)
VALUES
  (
    101,
    "Surabhi Grover",
   "4306 Appomattox Rd, Mahtomedi, NH 03784",
    "612-555-1212",
    "address@domain.org"
  ),
  (
    102,
    "Solvig Thorvaldsen",
    "99 Duluth Street, Wayzata, MN 55424",
    "612-555-1212",
    "ssewaa@domain.org"
  );
  INSERT INTO
  invoices(invoice_id, order_date, final_price, customer_id, car_id)
VALUES
  (
    1001,
    "2021-02-02",
        23999,
    102,
    1
  ),
  (
    2,
    "2021-01-03",
        24999,
    "101,
    2
  );
