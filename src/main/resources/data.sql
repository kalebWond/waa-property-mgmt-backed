-- Insert Role entries
INSERT INTO role (id, role) VALUES
                                (1, 'OWNER'),
                                (2, 'CUSTOMER'),
                                (3, 'ADMIN');

-- Insert Customer entries
INSERT INTO customer (id, first_name, last_name, email, password, role_id, status) VALUES
                                                                                       (100, 'John', 'Doe', 'johndoe@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 2, 'ACTIVE'),
                                                                                       (200, 'Jane', 'Doe', 'janedoe@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 2, 'ACTIVE'),
                                                                                       (300, 'Bob', 'Smith', 'bobsmith@gmail.com', 'password3', 2, 'ACTIVE'),
                                                                                       (400, 'Alice', 'Johnson', 'alicejohnson@gmail.com', 'password4', 2, 'ACTIVE'),
                                                                                       (500, 'Mike', 'Williams', 'mikewilliams@gmail.com', 'password5', 2, 'ACTIVE'),
                                                                                       (600, 'Emily', 'Davis', 'emilydavis@gmail.com', 'password6', 2, 'ACTIVE'),
                                                                                       (700, 'David', 'Brown', 'davidbrown@gmail.com', 'password7', 2, 'ACTIVE'),
                                                                                       (800, 'Sarah', 'Miller', 'sarahmiller@gmail.com', 'password8', 2, 'ACTIVE'),
                                                                                       (900, 'Mark', 'Wilson', 'markwilson@gmail.com', 'password9', 2, 'ACTIVE'),
                                                                                       (1000   , 'Karen', 'Moore', 'karenmoore@gmail.com', 'password10', 2, 'ACTIVE'),
                                                                                       (1100   , 'Tom', 'Taylor', 'tomtaylor@gmail.com', 'password11', 2, 'ACTIVE'),
                                                                                       (1200   , 'Olivia', 'Anderson', 'oliviaanderson@gmail.com', 'password12', 2, 'ACTIVE'),
                                                                                       (1300   , 'Chris', 'Thomas', 'christhomas@gmail.com', 'password13', 2, 'ACTIVE'),
                                                                                       (1400   , 'Samantha', 'Jackson', 'samanthajackson@gmail.com', 'password14', 2, 'ACTIVE'),
                                                                                       (1500   , 'George', 'White', 'georgewhite@gmail.com', 'password15', 2, 'ACTIVE'),
                                                                                       (1600   , 'Ella', 'Harris', 'ellaharris@gmail.com', 'password16', 2, 'ACTIVE'),
                                                                                       (1700   , 'Anthony', 'Martin', 'anthonymartin@gmail.com', 'password17', 2, 'ACTIVE'),
                                                                                       (1800   , 'Madison', 'Thompson', 'madisonthompson@gmail.com', 'password18', 2, 'ACTIVE'),
                                                                                       (1900   , 'Ryan', 'Garcia', 'ryangarcia@gmail.com', 'password19', 2, 'ACTIVE'),
                                                                                       (2000   , 'Julia', 'Davis', 'juliadavis@gmail.com', 'password20', 2, 'ACTIVE'),
                                                                                       (2100   , 'Justin', 'Rodriguez', 'justinrodriguez@gmail.com', 'password21', 2, 'ACTIVE'),
                                                                                       (2200   , 'Lauren', 'Perez', 'laurenperez@gmail.com', 'password22', 2, 'ACTIVE'),
                                                                                       (2300   , 'Joshua', 'Turner', 'joshuaturner@gmail.com', 'password23', 2, 'ACTIVE'),
                                                                                       (2400   , 'Ashley', 'Campbell', 'ashleycampbell@gmail.com', 'password24', 2, 'ACTIVE'),
                                                                                       (2500   , 'Brandon', 'Parker', 'brandonparker@gmail.com', 'password25', 2, 'ACTIVE');

-- Insert Owner entries
INSERT INTO owner (id, first_name, last_name, email, password, role_id, status) VALUES
                                                                                    (2600, 'Michael', 'Brown', 'brown@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 1, 'ACTIVE'),
                                                                                    (2700, 'Jennifer', 'Johnson', 'jenniferjohnson@gmail.com', 'password27', 1, 'ACTIVE'),
                                                                                    (2800, 'William', 'Lee', 'williamlee@gmail.com', 'password28', 1, 'ACTIVE'),
                                                                                    (2900, 'Sophia', 'Harris', 'sophiaharris@gmail.com', 'password29', 1, 'ACTIVE'),
                                                                                    (3000, 'Daniel', 'Jackson', 'danieljackson@gmail.com', 'password30', 1, 'ACTIVE'),
                                                                                    (3100, 'Grace', 'Moore', 'gracemoore@gmail.com', 'password31', 1, 'ACTIVE'),
                                                                                    (3200, 'Joseph', 'Clark', 'josephclark@gmail.com', 'password32', 1, 'ACTIVE'),
                                                                                    (3300, 'Olivia', 'Hall', 'oliviahall@gmail.com', 'password33', 1, 'ACTIVE'),
                                                                                    (3400, 'James', 'Gonzalez', 'jamesgonzalez@gmail.com', 'password34', 1, 'ACTIVE'),
                                                                                    (3500, 'Emma', 'Garcia', 'emmagarcia@gmail.com', 'password35', 1, 'ACTIVE'),
                                                                                    (3600, 'Benjamin', 'Rodriguez', 'benjaminrodriguez@gmail.com', 'password36', 1, 'ACTIVE'),
                                                                                    (3700, 'Ava', 'Wilson', 'avawilson@gmail.com', 'password37', 1, 'ACTIVE'),
                                                                                    (3800, 'David', 'Smith', 'davidsmith@gmail.com', 'password38', 1, 'ACTIVE'),
                                                                                    (3900, 'Mia', 'Taylor', 'miataylor@gmail.com', 'password39', 1, 'ACTIVE'),
                                                                                    (4000, 'Christopher', 'Anderson', 'christopheranderson@gmail.com', 'password40', 1, 'ACTIVE'),
                                                                                    (4100, 'Harper', 'Johnson', 'harperjohnson@gmail.com', 'password41', 1, 'ACTIVE'),
                                                                                    (4200, 'Andrew', 'Martinez', 'andrewmartinez@gmail.com', 'password42', 1, 'ACTIVE'),
                                                                                    (4300, 'Evelyn', 'Clark', 'evelynclark@gmail.com', 'password43', 1, 'ACTIVE'),
                                                                                    (4400, 'Matthew', 'White', 'matthewwhite@gmail.com', 'password44', 1, 'ACTIVE'),
                                                                                    (4500, 'Addison', 'Hernandez', 'addisonhernandez@gmail.com', 'password45', 1, 'ACTIVE'),
                                                                                    (4600, 'Amelia', 'Lee', 'ameliale@gmail.com', 'password46', 1, 'ACTIVE'),
                                                                                    (4700, 'Lucas', 'Thomas', 'lucasthomas@gmail.com', 'password47', 1, 'ACTIVE'),
                                                                                    (4800, 'Chloe', 'Robinson', 'chloerobinson@gmail.com', 'password48', 1, 'ACTIVE'),
                                                                                    (4900, 'Henry', 'Harris', 'henryharris@gmail.com', 'password49', 1, 'ACTIVE'),
                                                                                    (5000, 'Elizabeth', 'Turner', 'elizabethturner@gmail.com', 'password50', 1, 'ACTIVE');


--Insert dummy data for Admin
INSERT INTO admin (id, first_name, last_name, email, password, role_id, status) VALUES
                                                                                       (100, 'Jack', 'Blue', 'jackblue@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 3, 'ACTIVE'),
                                                                                       (200, 'Kate', 'Brown', 'katebrown@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 3, 'ACTIVE');
-- Insert dummy data for Address
INSERT INTO Address (id, street, city, state, zipcode)
VALUES (1000, '1234 Elm St', 'San Francisco', 'CA', '94107'),
       (2000, '5678 Oak St', 'Los Angeles', 'CA', '90001'),
       (3000, '9101 Maple St', 'New York', 'NY', '10001'),
       (4000, '2345 Cedar St', 'Chicago', 'IL', '60601'),
       (5000, '6789 Birch St', 'Houston', 'TX', '77001'),
       (6000, '1111 Pine St', 'Philadelphia', 'PA', '19101'),
       (7000, '2222 Willow St', 'Phoenix', 'AZ', '85001'),
       (8000, '3333 Cedar St', 'San Francisco', 'CA', '94107'),
       (9000, '4444 Oak St', 'Los Angeles', 'CA', '90001'),
       (10000, '5555 Maple St', 'New York', 'NY', '10001'),
       (11000, '6666 Cedar St', 'Chicago', 'IL', '60601'),
       (12000, '7777 Birch St', 'Houston', 'TX', '77001'),
       (13000, '8888 Pine St', 'Philadelphia', 'PA', '19101'),
       (14000, '9999 Willow St', 'Phoenix', 'AZ', '85001'),
       (15000, '1010 Cedar St', 'San Francisco', 'CA', '94107');


-- Insert dummy data for PropertyDetails
INSERT INTO property_details (id, pet, cooling, heater, deposit)
VALUES (600, true, 'Central AC', 'Gas', 2000.00),
       (700, false, 'Window AC', 'Electric', 1000.00),
       (800, true, 'Central AC', 'Gas', 2500.00),
       (900, false, 'Wall Unit AC', 'Electric', 1500.00),
       (1000, true, 'Central AC', 'Gas', 3000.00),
       (1100, false, 'Window AC', 'Electric', 1200.00),
       (1200, true, 'Central AC', 'Gas', 2800.00),
       (1300, false, 'Wall Unit AC', 'Electric', 1800.00),
       (1400, true, 'Central AC', 'Gas', 2300.00),
       (1500, false, 'Window AC', 'Electric', 900.00),
       (1600, true, 'Central AC', 'Gas', 2600.00),
       (1700, false, 'Wall Unit AC', 'Electric', 1600.00),
       (1800, true, 'Central AC', 'Gas', 2400.00),
       (1900, false, 'Window AC', 'Electric', 1100.00),
       (2000, true, 'Central AC', 'Gas', 2700.00);

-- Insert dummy data for Property
INSERT INTO property (id, property_type, price, bedrooms, bathrooms, property_status, lot_size, built_year, address_id, listing_type, property_details_id)
VALUES (2600, 'HOUSE', 150000, 3, 2, 'AVAILABLE', 1200, '2008-01-01', 1000, 'SALE', 600),
       (2700, 'APARTMENT', 1000, 1, 1, 'RENTED', 600, '2015-01-01', 2000, 'RENT', 700),
       (2800, 'CONDO', 180000, 2, 2, 'SOLD', 900, '2010-01-01', 3000, 'SALE', 800),
       (2900, 'TOWNHOUSE', 130000, 2, 2, 'AVAILABLE', 1000, '2012-01-01', 4000, 'RENT', 900),
       (3000, 'HOUSE', 300000, 4, 3, 'SOLD', 1800, '2005-01-01', 5000, 'SALE', 1000),
       (3100, 'APARTMENT', 1100, 1, 1, 'RENTED', 700, '2018-01-01', 6000, 'RENT', 1100),
       (3200, 'CONDO', 250000, 2, 2, 'PENDING', 1000, '2016-01-01', 7000, 'SALE', 1200),
       (3300, 'TOWNHOUSE', 140000, 2, 2, 'AVAILABLE', 900, '2010-01-01', 8000, 'RENT', 1300),
       (3400, 'HOUSE', 180000, 3, 2, 'SOLD', 1200, '2015-01-01', 9000, 'SALE', 1400),
       (3500, 'APARTMENT', 900, 1, 1, 'RENTED', 600, '2012-01-01', 10000, 'RENT', 1500),
       (3600, 'CONDO', 200000, 2, 2, 'CONTINGENT', 1000, '2008-01-01', 11000, 'SALE', 1600),
       (3700, 'TOWNHOUSE', 120000, 2, 2, 'AVAILABLE', 800, '2005-01-01', 12000, 'RENT', 1700),
       (3800, 'HOUSE', 280000, 4, 3, 'SOLD', 1600, '2010-01-01', 13000, 'SALE', 1800),
       (3900, 'APARTMENT', 950, 1, 1, 'RENTED', 650, '2015-01-01', 14000, 'RENT', 1900),
       (4000, 'CONDO', 220000, 2, 2, 'PENDING', 1100, '2012-01-01', 15000, 'SALE', 2000);

-- Insert dummy data for owner_properties
INSERT INTO owner_properties (owner_id, properties_id)
VALUES (2600, 2600),
       (2700, 2700),
       (2800, 2800),
       (2900, 2900),
       (3000, 3000),
       (3100, 3100),
       (3200, 3200),
       (3300, 3300),
       (3400, 3400),
       (3500, 3500),
       (3600, 3600),
       (3700, 3700),
       (3800, 3800),
       (3900, 3900),
       (4000, 4000);



INSERT INTO offer (id, price, status, submitted_at, customer_id, property_id)
VALUES (100, 300000, 'WAITING', '2023-04-27T10:09:30', 100, 2600),
       (200, 250000, 'WAITING', '2023-04-27T10:09:30', 100, 2800),
       (300, 300000, 'WAITING', '2023-04-27T10:09:30', 100, 3000),
       (400, 200000, 'WAITING', '2023-04-27T10:09:30', 100, 3100),
       (500, 400000, 'WAITING', '2023-04-27T10:09:30', 100, 3200),
       (600, 320000, 'WAITING', '2023-04-27T10:09:30', 200, 2600),
       (700, 350000, 'WAITING', '2023-04-27T10:09:30', 200, 2800);

INSERT INTO photos (id, link, property_id)
VALUES (1000, 'https://picsum.photos/200/300', 2600),
       (2000, 'https://picsum.photos/200/300', 2700),
       (3000, 'https://picsum.photos/200/300', 2800),
       (4000, 'https://picsum.photos/200/300', 2900),
       (5000, 'https://picsum.photos/200/300', 3000),
       (6000, 'https://picsum.photos/200/300', 3100),
       (7000, 'https://picsum.photos/200/300', 3200),
       (8000, 'https://picsum.photos/200/300', 3300),
       (9000, 'https://picsum.photos/200/300', 3400),
       (10000, 'https://picsum.photos/200/300', 3500),
       (11000, 'https://picsum.photos/200/300', 3600),
       (12000, 'https://picsum.photos/200/300', 3700),
       (13000, 'https://picsum.photos/200/300', 3800),
       (14000, 'https://picsum.photos/200/300', 3900),
       (15000, 'https://picsum.photos/200/300', 4000);


