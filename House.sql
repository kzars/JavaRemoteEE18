-- 1. Rooms (7)

	-- ID
    -- Type of room (string)
    -- Size in m2 (float)
    -- Floor (int)
    -- Renovated (boolean)
    -- Optimal furniture count (int)
    
    DROP TABLE IF EXISTS rooms;
    

    
    CREATE TABLE rooms(
		id int NOT NULL AUTO_INCREMENT,
        type varchar(55) NOT NULL,
        size float NOT NULL,
        renovated boolean NOT NULL DEFAULT false,
        optimal_furniture_count int NOT NULL DEFAULT 3,
        PRIMARY KEY(id)
    );
    
    INSERT INTO rooms (type, size, renovated) VALUES ('Bathroom 1',8.5,true);
    INSERT INTO rooms (type, size,optimal_furniture_count) VALUES ('Bathroom 2',3.5,2);
    INSERT INTO rooms (type, size, renovated) VALUES ('Bedroom 1',12.3,true);
    INSERT INTO rooms (type, size,optimal_furniture_count) VALUES ('Bedroom 2',7.9,7);
    INSERT INTO rooms (type, size, renovated) VALUES ('Living room',7.5,true);
    INSERT INTO rooms (type, size,optimal_furniture_count) VALUES ('Kitchen',9.0,4);
    INSERT INTO rooms (type, size,optimal_furniture_count) VALUES ('Storage',2.2,2);
    
    
	SELECT * FROM rooms;
    
    
    -- 2. Furniture(15)

	-- ID
	-- Type of furniture (string)
    -- Cost (float)
    -- Brand (string)
    -- New (new/used) (Boolean) new -> true and used -> false
    -- Material (string)
    DROP TABLE IF EXISTS furniture;
    
    CREATE TABLE furniture (
		id int NOT NULL AUTO_INCREMENT,
		type varchar(55) NOT NULL,
        cost float NOT NULL,
        brand varchar(55) NOT NULL,
        new boolean NOT NULL DEFAULT false,
        material varchar(55),
        PRIMARY KEY (id)  
    );
    
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('chair',29.99,'ikea',true,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('sofa',129.99,'ikea',true,'leather, metal');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('table',59.99,'ikea',false,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('small chair',9.99,'ikea',true,'metal');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('closet',229.99,'ikea',true,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('bed',329.99,'ikea',false,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('countertop',89.99,'ikea',true,'acril');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('cabinet',49.99,'ikea',false,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('desk',99.99,'ikea',true,'metal,wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('dinig table',79.99,'ikea',true,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('bookcase',59.99,'ikea',false,'wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('coffy table',29.99,'ikea',true,'glass, metal');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('nightstand',29.99,'ikea',true,'metal');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('storage bench',59.99,'ikea',true,'wood, metal');
	INSERT INTO furniture (type,cost,brand,new,material) VALUES ('relax chair',49.99,'ikea',false,'leather, wood');
    INSERT INTO furniture (type,cost,brand,new,material) VALUES ('bedside table',59.99,'ikea',true,'wood');
    
    SELECT * FROM rooms;
    SELECT * FROM location;
    SELECT * FROM furniture;
    
    
    -- 3. Location Of Furniture (REFERENCES)

	-- RoomID
    -- Furniture ID
    
    DROP TABLE IF EXISTS location;
    
    CREATE TABLE location(
		id int NOT NULL AUTO_INCREMENT,
        roomID int NOT NULL,
        furnitureID int NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY (roomID) REFERENCES rooms(id),
        FOREIGN KEY (furnitureID) REFERENCES furniture(id)
    );
    
    INSERT INTO location (roomID, furnitureID) VALUES (1,1);
    INSERT INTO location (roomID, furnitureID) VALUES (1,4);
    INSERT INTO location (roomID, furnitureID) VALUES (1,4);
    INSERT INTO location (roomID, furnitureID) VALUES (1,14);
    INSERT INTO location (roomID, furnitureID) VALUES (2,4);
    INSERT INTO location (roomID, furnitureID) VALUES (3,5);
    INSERT INTO location (roomID, furnitureID) VALUES (3,13);
    INSERT INTO location (roomID, furnitureID) VALUES (3,6);
    INSERT INTO location (roomID, furnitureID) VALUES (4,1);
    INSERT INTO location (roomID, furnitureID) VALUES (4,1);
    INSERT INTO location (roomID, furnitureID) VALUES (4,15);
    INSERT INTO location (roomID, furnitureID) VALUES (4,9);
    INSERT INTO location (roomID, furnitureID) VALUES (4,12);
    INSERT INTO location (roomID, furnitureID) VALUES (4,10);
    INSERT INTO location (roomID, furnitureID) VALUES (5,15);
    INSERT INTO location (roomID, furnitureID) VALUES (5,15);
    INSERT INTO location (roomID, furnitureID) VALUES (5,12);
    INSERT INTO location (roomID, furnitureID) VALUES (5,3);
    INSERT INTO location (roomID, furnitureID) VALUES (5,3);
    INSERT INTO location (roomID, furnitureID) VALUES (6,8);
    INSERT INTO location (roomID, furnitureID) VALUES (6,7);
    INSERT INTO location (roomID, furnitureID) VALUES (6,3);
    INSERT INTO location (roomID, furnitureID) VALUES (6,3);
    INSERT INTO location (roomID, furnitureID) VALUES (7,11);
    INSERT INTO location (roomID, furnitureID) VALUES (7,4);
    
    SELECT * FROM location;
    
    
    
    -- Queries

SELECT
    m.processid,
    m.`desc`
FROM tmp_ids AS tmp
INNER JOIN main_table AS m
ON tmp.processid = m.processid
ORDER BY tmp.id ASC;


-- 1. Rooms total cost searching by room name (type)

SELECT SUM(cost) FROM furniture WHERE id IN (SELECT furnitureID FROM location WHERE roomID IN (SELECT id FROM rooms WHERE type = 'Bathroom 1'));
-- SELECT f.* FROM furniture AS f INNER JOIN (SELECT furnitureID FROM location WHERE roomID IN (SELECT id FROM rooms WHERE type = 'Bathroom 1')) AS t ON f.id = t.furnitureID;
-- Correct one if there are multiple of the same furniture in the room
SELECT SUM(cost) FROM furniture AS f INNER JOIN (SELECT furnitureID FROM location WHERE roomID IN (SELECT id FROM rooms WHERE type = 'Bathroom 1')) AS t ON f.id = t.furnitureID;


-- 2. Show all furniture info (Type,Brand and Cost) in particular room searching by room name;
-- SOLUTION
SELECT type,brand,cost FROM furniture WHERE id IN (SELECT furnitureID FROM location WHERE roomID IN (SELECT id FROM rooms WHERE type = 'Bathroom 1'));

-- 3. How many new furniture is in the room searching by room name;
-- SOLUTION
SELECT COUNT(*) FROM(
	SELECT * FROM furniture AS f 
		INNER JOIN (
			SELECT furnitureID FROM location WHERE roomID IN (SELECT id FROM rooms WHERE type = 'Bedroom 1')
		) AS t ON f.id = t.furnitureID
) AS q WHERE q.new = true;       

-- 4. Average room size in the house
-- SOLUTION
SELECT AVG(size) FROM rooms;

-- 5. List all renovated rooms where there is atleast 3 furniture units
SELECT * FROM rooms WHERE renovated = true; 
SELECT *, COUNT(1) AS 'count' FROM location  GROUP BY roomID HAVING count >= 3;

SELECT * FROM rooms WHERE renovated = TRUE AND id IN(SELECT roomID FROM location WHERE furnitureID >2 );
-- SOLUTION
SELECT * FROM rooms 
	INNER JOIN (
		SELECT roomID, COUNT(1) AS 'count' FROM location  GROUP BY roomID HAVING count >= 3
    ) 
    as f ON f.roomID = rooms.id 
    WHERE rooms.renovated = true; 

-- 6. List room where sum of furniture cost is more that 1000, so the robbers know where to go

-- All furniture cost
SELECT SUM(cost) FROM furniture AS f INNER JOIN (SELECT furnitureID FROM location) AS t ON f.id = t.furnitureID;

-- List all rooms furniture cost
 SELECT rooms.id, rooms.type, SUM(cost) FROM rooms INNER JOIN (SELECT roomID,furniture.id,type,cost FROM location INNER JOIN furniture ON location.furnitureID = furniture.id) AS z ON z.roomID = rooms.id GROUP BY roomID;

-- SOLUTION
 SELECT rooms.id, rooms.type, SUM(cost) AS 'room_cost' FROM rooms 
	INNER JOIN (
		SELECT roomID,furniture.id,type,cost FROM location INNER JOIN furniture ON location.furnitureID = furniture.id
	) AS z ON z.roomID = rooms.id 
    GROUP BY roomID
    HAVING room_cost > 100;

    
-- 7. Show all unique furniture in the room (there could be multiple units of the same furniture in the room) searching by room name

-- SOLUTION
 SELECT * FROM rooms 
	RIGHT JOIN (
		SELECT roomID,furniture.id,type,cost FROM location INNER JOIN furniture ON location.furnitureID = furniture.id
	) AS z ON z.roomID = rooms.id
    WHERE rooms.type = 'Kitchen'
    GROUP BY furniture.id;

-- 8. Most popular material for furniture in room seaching by room name

SELECT id, material,  COUNT(material) AS `value_occurrence` FROM furniture GROUP BY  material ORDER BY `value_occurrence` DESC ;

-- 9. List all rooms where there is more than optimal furniture count

-- SOLUTION
SELECT * FROM rooms 
	INNER JOIN (
		SELECT roomID, COUNT(*) AS 'count' FROM location  GROUP BY roomID
    ) 
    as f ON f.count > rooms.optimal_furniture_count AND f.roomID = rooms.id; 
    
    
    
    