create DATABASE if not exists dealership;
use dealership;
drop table if exists cars;
drop table if exists invoices;
drop table if exists customers;
create table invoices ();
create table cars ();
create table customers (customer_id int(10) not NULL AUTO_INCREMENT , name VARCHAR (50) NOT null, 
                        address VARCHAR (60) NOT null, phone VARCHAR(10) NOT NULL , email VARCHAR(20) ,
                        invoice_id int (10) not null, PRIMARY KEY (customer_id), 
                        FOREIGN KEY (car_id) REFERENCES cars(car_id),
                        FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id));

