create DATABASE if not exists dealership;
use dealership;
drop table if exists cars;
drop table if exists invoices;
drop table if exists customers;
create table invoices ();
create table cars (id car_int(10) not null AUTO_INCREMENT,
  customer_id int(10) not null,
  invoice_id int(10) not null,
  year int(4) not null,
  make varchar(15) not null,
  model varchar(15) not null,
  cost double(7,2) not null,
  PRIMARY KEY(car_id),
  FOREIGN KEY(invoice_id) references invoices(invoice_id),
  FOREIGN KEY(customer_id) references customers(customer_id));
                                                
create table customers (customer_id int(10) not NULL AUTO_INCREMENT , name VARCHAR (50) NOT null, 
                        address VARCHAR (60) NOT null, phone VARCHAR(10) NOT NULL , email VARCHAR(20) ,
                        invoice_id int (10) not null, car_id int(10) not null, PRIMARY KEY (customer_id), 
                        FOREIGN KEY (car_id) REFERENCES cars(car_id),
                        FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id));

create table invoice ( 
invoice_id int (10) not NULL AUTO_INCREMENT ,  
order_date date NOT null,  
final_price double (7,2) NOT null,  
PRIMARY KEY (invoice_id), 
FOREIGN KEY (customer_id) REFERENCES customers(customer_id), 
FOREIGN KEY (car_id) REFERENCES cars(car_id), 
); 
