create database project1;
use project1;
CREATE TABLE agent (
  agent_name VARCHAR(255),
  agent_id INT PRIMARY KEY,
  contact VARCHAR(20),
  address VARCHAR(255),
  mail_id VARCHAR(255)
); 
CREATE TABLE property (
  propertyid INT PRIMARY KEY,
  area INT,
  city VARCHAR(255),
  pincode INT,
  street_address VARCHAR(255),
  no_of_rooms INT,
  buy_rent VARCHAR(255),
  buy_price INT,
  rent_price INT,
  build_date INT,
  availabilty_status VARCHAR(255)
);
CREATE TABLE owner (
  ownerid INT PRIMARY KEY,
  owner_name VARCHAR(50),
  city VARCHAR(50),
  pincode INT,
  emailid VARCHAR(50),
  contact bigint
);

CREATE TABLE buyer (
  buyerid INT PRIMARY KEY,
  buyer_name VARCHAR(255),
  city VARCHAR(255),
  pincode INT,
  emailid VARCHAR(255),
  contact bigint
);
CREATE TABLE owner_relation (
  ownerid INT,
  propertyid INT,
  PRIMARY KEY (ownerid, propertyid),
  FOREIGN KEY (ownerid) REFERENCES owner(ownerid),
  FOREIGN KEY (propertyid) REFERENCES property(propertyid)
);
CREATE TABLE buyer_relation (
  buyerid INT,
  agent_id INT,
  PRIMARY KEY (buyerid, agent_id),
  FOREIGN KEY (buyerid) REFERENCES buyer(buyerid),
  FOREIGN KEY (agent_id) REFERENCES agent(agent_id)
);
CREATE TABLE property_relation (
  agent_id INT,
  propertyid INT,
  PRIMARY KEY (agent_id, propertyid),
  FOREIGN KEY (propertyid) REFERENCES property(propertyid),
  FOREIGN KEY (agent_id) REFERENCES agent(agent_id)
);
CREATE TABLE owner_agent_relation (
  ownerid INT,
  agent_id INT,
  PRIMARY KEY (ownerid, agent_id),
  FOREIGN KEY (ownerid) REFERENCES owner(ownerid),
  FOREIGN KEY (agent_id) REFERENCES agent(agent_id)
);
create table loginsystem
(
	id int primary key,
    password varchar(255),
    role varchar(255),
    foreign key (id) references buyer(buyerid),
    foreign key (id) references owner(ownerid)
);
INSERT INTO buyer (buyerid, buyer_name, city, pincode, emailid, contact) VALUES
(1, 'Amit Kumar', 'Delhi', 110001, 'amitkumar@gmail.com', 9876543210),
(2, 'Rahul Sharma', 'Mumbai', 400001, 'rahulsharma@gmail.com', 9988776655),
(3, 'Priya Singh', 'Bangalore', 560001, 'priyasingh@gmail.com', 9765432100),
(4, 'Aarav Patel', 'Ahmedabad', 380001, 'aaravpatel@gmail.com', 9876543211),
(5, 'Sneha Gupta', 'Kolkata', 700001, 'snehagupta@gmail.com', 9876543212),
(6, 'Rohit Verma', 'Chennai', 600001, 'rohitverma@gmail.com', 9876543213),
(7, 'Swati Mishra', 'Delhi', 110002, 'swatimishra@gmail.com', 9876543214),
(8, 'Kunal Mehta', 'Mumbai', 400002, 'kunalmehta@gmail.com', 9876543215),
(9, 'Anjali Singh', 'Bangalore', 560002, 'anjalisingh@gmail.com', 9876543216),
(10, 'Rajeev Sharma', 'Kolkata', 700002, 'rajeevsharma@gmail.com', 9876543217);

insert into loginsystem(id,password,role)values
(1,'amit@123','buyer'),
(2,'rahu@434','buyer'),
(3,'priya@34','buyer');

insert into loginsystem(id,password,role)values
(4,'hit@124','user');


insert into loginsystem(id,password,role)values
(5,'kusu@56','seller');
drop table loginsystem;
    
drop table owner_agent_relation;
drop table owner_relation;
drop table loginsystem;
select * from property;
select * from owner;
select * from buyer_relation;

INSERT INTO property (propertyid, area, city, pincode, street_address, no_of_rooms, buy_rent, buy_price, rent_price, build_date, availabilty_status) VALUES
(1, 1000, 'Mumbai', 400001, 'Bandra West', 2, 'both', 10000000, 10000, 2022, 'yes'),
(2, 1500, 'Delhi', 110001, 'Connaught Place', 3, 'rent', NULL, 20000, 2021, 'yes'),
(3, 1200, 'Bangalore', 560001, 'Indiranagar', 2, 'buy', 8000000, NULL, 2022, 'yes'),
(4, 2000, 'Chennai', 600001, 'Egmore', 4, 'buy', 15000000, NULL, 2021, 'yes'),
(5, 800, 'Hyderabad', 500001, 'Banjara Hills', 1, 'both', 5000000, 10000, 2022, 'yes'),
(6, 2500, 'Mumbai', 400002, 'Colaba', 5, 'rent', NULL, 40000, 2021, 'yes'),
(7, 1800, 'Delhi', 110002, 'Karol Bagh', 3, 'buy', 12000000, NULL, 2022, 'yes'),
(8, 900, 'Bangalore', 560002, 'Jayanagar', 1, 'rent', NULL, 8000, 2022, 'yes'),
(9, 1600, 'Chennai', 600002, 'T Nagar', 3, 'buy', 10000000, NULL, 2021, 'yes'),
(10, 3000, 'Hyderabad', 500002, 'Gachibowli', 6, 'rent', NULL, 50000, 2021, 'yes'),
(11, 2200, 'Mumbai', 400003, 'Dadar', 4, 'rent', NULL, 35000, 2022, 'yes'),
(12, 1100, 'Delhi', 110003, 'Lajpat Nagar', 2, 'buy', 6000000, NULL, 2022, 'yes'),
(13, 1300, 'Bangalore', 560003, 'Koramangala', 2, 'rent', NULL, 12000, 2021, 'yes'),
(14, 1500, 'Mumbai', 400008, 'Juhu Tara Road', 3, 'buy', 20000000, NULL, 2010, 'yes'),
(15, 1200, 'Delhi', 110023, 'Connaught Place', 2, 'rent', NULL, 35000, 2005, 'yes'),
(16, 800, 'Mumbai', 400056, 'Bandra West', 1, 'rent', NULL, 15000, 2012, 'yes'),
(17, 900, 'Kolkata', 700064, 'Salt Lake City', 2, 'buy', 8000000, NULL, 2012, 'yes'),
(18, 2000, 'Delhi', 110017, 'Greater Kailash', 4, 'buy', 30000000, NULL,2008, 'yes'),
(19, 1600, 'Mumbai', 400101, 'Goregaon East', 3, 'rent', NULL, 25000, 2017, 'yes'),
(20, 1200, 'Bangalore', 560102, 'Indiranagar', 2, 'both', 10000000, 30000, 2014, 'yes'),
(21, 700, 'Hyderabad', 500034, 'Banjara Hills', 1, 'buy', 5000000, NULL, 2011, 'yes'),
(22, 850, 'Pune', 411001, 'MG Road', 2, 'rent', NULL, 20000, 2019, 'yes'),
(23, 1100, 'Kolkata', 700029, 'Ballygunge', 2, 'buy', 15000000, NULL, 2013, 'yes'),
(24, 750, 'Delhi', 110003, 'Lodhi Road', 1, 'rent', NULL, 12000, 2018, 'yes'),
(25, 1800, 'Mumbai', 400050, 'Cuffe Parade', 4, 'buy', 40000000, NULL, 2016, 'yes'),
(26, 950, 'Bangalore', 560076, 'BTM Layout', 2, 'rent', NULL, 18000, 2010, 'yes'),
(27, 1200, 'Hyderabad', 500032, 'Jubilee Hills', 2, 'buy', 13000000, NULL, 2007, 'yes'),
(28, 850, 'Pune', 411004, 'Deccan Gymkhana', 2, 'rent', NULL, 22000, 2015, 'yes'),
(29, 900, 'Kolkata', 700019, 'Bhowanipore', 2, 'buy', 10000000, NULL, 2012, 'yes');

INSERT INTO owner (ownerid, owner_name, city, pincode, emailid, contact) VALUES
(1, 'Priya Sharma', 'Delhi', 110001, 'priyasharma@example.com', 9898989898),
(2, 'Rajesh Patel', 'Mumbai', 400001, 'rajeshpatel@example.com', 9876543210),
(3, 'Sarika Singh', 'Lucknow', 226001, 'sarikasingh@example.com', 8765432109),
(4, 'Amit Gupta', 'Chandigarh', 160001, 'amitgupta@example.com', 7654321098),
(5, 'Anjali Verma', 'Jaipur', 302001, 'anjaliverma@example.com', 6543210987),
(6, 'Sandeep Kaur', 'Amritsar', 143001, 'sandeepkaur@example.com', 5432109876),
(7, 'Ravi Kumar', 'Patna', 800001, 'ravikumar@example.com', 4321098765),
(8, 'Meena Sharma', 'Bhopal', 462001, 'meenasharma@example.com', 3210987654),
(9, 'Ajay Singh', 'Jodhpur', 342001, 'ajaysingh@example.com', 2109876543),
(10, 'Suman Tiwari', 'Allahabad', 211001, 'sumantiwari@example.com', 1098765432),
(11, 'Suresh Mehta', 'Ahmedabad', 380001, 'sureshmehta@example.com', 9988776655),
(12, 'Neha Shah', 'Surat', 395001, 'nehashah@example.com', 9876543211),
(13, 'Kunal Sharma', 'Nashik', 422001, 'kunalsharma@example.com', 8765432100),
(14, 'Preeti Jain', 'Indore', 452001, 'preetijain@example.com', 7654321099),
(15, 'Siddharth Verma', 'Ghaziabad', 201001, 'siddharthverma@example.com', 6543210988),
(16, 'Arjun Patel', 'Vadodara', 390001, 'arjunpatel@example.com', 5432109877),
(17, 'Rashmi Singh', 'Varanasi', 221001, 'rashmisingh@example.com', 4321098766),
(18, 'Alok Tiwari', 'Agra', 282001, 'aloktiwari@example.com', 3210987655),
(19, 'Kavita Gupta', 'Gwalior', 474001, 'kavitagupta@example.com', 2109876544),
(20, 'Sanjay Sharma', 'Raipur', 492001, 'sanjaysharma@example.com', 1098765433);
INSERT INTO owner_relation (ownerid, propertyid)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20);
INSERT INTO agent (agent_name, agent_id, contact, address, mail_id) VALUES 
('Amit Sharma', 1, '9876543210', 'Delhi, India', 'amit.sharma@example.com'),
('Sneha Gupta', 2, '9876543211', 'Mumbai, India', 'sneha.gupta@example.com'),
('Raj Patel', 3, '9876543212', 'Ahmedabad, India', 'raj.patel@example.com'),
('Meera Singh', 4, '9876543213', 'Jaipur, India', 'meera.singh@example.com'),
('Ravi Kumar', 5, '9876543214', 'Chennai, India', 'ravi.kumar@example.com'),
('Neha Sharma', 6, '9876543215', 'Hyderabad, India', 'neha.sharma@example.com'),
('Vikas Singh', 7, '9876543216', 'Bangalore, India', 'vikas.singh@example.com'),
('Priya Patel', 8, '9876543217', 'Surat, India', 'priya.patel@example.com'),
('Karan Malhotra', 9, '9876543218', 'Pune, India', 'karan.malhotra@example.com'),
('Aarav Desai', 10, '9876543219', 'Mumbai, India', 'aarav.desai@example.com'),
('Neha Gupta', 11, '9876543220', 'Ahmedabad, India', 'neha.gupta@example.com'),
('Ravi Patel', 12, '9876543221', 'Delhi, India', 'ravi.patel@example.com'),
('Anjali Verma', 13, '9876543222', 'Jaipur, India', 'anjali.verma@example.com'),
('Akash Singh', 14, '9876543223', 'Hyderabad, India', 'akash.singh@example.com'),
('Radhika Sharma', 15, '9876543224', 'Bangalore, India', 'radhika.sharma@example.com'),
('Aryan Patel', 16, '9876543225', 'Surat, India', 'aryan.patel@example.com'),
('Tanvi Malhotra', 17, '9876543226', 'Pune, India', 'tanvi.malhotra@example.com'),
('Arjun Desai', 18, '9876543227', 'Mumbai, India', 'arjun.desai@example.com'),
('Shreya Gupta', 19, '9876543228', 'Ahmedabad, India', 'shreya.gupta@example.com'),
('Kunal Patel', 20, '9876543229', 'Delhi, India', 'kunal.patel@example.com');

INSERT INTO property_relation (agent_id, propertyid)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20);

CREATE TABLE transaction (
agent_id int not null ,
buyerid int not null ,
ownerid int not null ,
propertyid int not null ,
date_of_transaction varchar(255) not null ,
buy_rent varchar(255) , 
buy_price INT,
rent_price INT,
primary key (agent_id , buyerid , ownerid , propertyid ),
FOREIGN KEY (propertyid) REFERENCES property(propertyid),
FOREIGN KEY (ownerid) REFERENCES owner(ownerid),
FOREIGN KEY (buyerid) REFERENCES buyer(buyerid),
FOREIGN KEY (agent_id) REFERENCES agent(agent_id)
);
drop table transaction;
select * from transaction;
update property set availabilty_status='yes';

