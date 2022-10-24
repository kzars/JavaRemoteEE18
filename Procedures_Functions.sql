

DELIMITER //

CREATE PROCEDURE GetAllCountriesAndState()
BEGIN
	SELECT * FROM country LEFT JOIN states ON country.id = states.countryID
	UNION
	SELECT * FROM country RIGHT JOIN states ON country.id = states.countryID;
END
 
//DELIMITER ;

CALL GetAllCountriesAndState();

-- Function

DELIMITER //

CREATE FUNCTION GradeExplained(grade INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE studentGrade VARCHAR(20);
	IF grade > 9 THEN
		SET studentGrade = 'Super';
    ELSEIF (grade >= 8 AND grade <= 9) THEN
		SET studentGrade = 'Very good';
    ELSEIF grade >= 5 THEN
		SET studentGrade = 'Good';
    ELSEIF grade < 5 THEN
		SET studentGrade = 'Not that good';
    END IF;    
	
    -- Returning value
    RETURN (studentGrade);
END
// DELIMITER ;

SELECT grade,  GradeExplained(grade) FROM grades WHERE subjectID = 1 AND studentID = 1;





-- TABLES

-- 1. Rooms (7)

	-- ID
    -- Type of room (string)
    -- Size in m2 (float)
    -- Floor (int)
    -- Renovated (boolean)
    -- Optimal furniture count (int)

-- 2. Furniture(15)

	-- ID
	-- Type of furniture (string)
    -- Cost (float)
    -- Brand (string)
    -- New (new/used) (Boolean) new -> true and used -> false
    -- Material (string)

-- 3. Location Of Furniture (REFERENCES)

	-- RoomID
    -- Furniture ID

-- Queries

-- 1. Rooms total cost searching by room name (type)
-- 2. Show all furniture info (Type,Brand and Cost) in particular room searching by room name;
-- 3. How many new furniture is in the room searching by room name;
-- 4. Average room size in the house
-- 5. List all renovated rooms where there is atleast 3 furniture units
-- 6. List room where sum of furniture cost is more that 1000, so the robbers know where to go
-- 7. Show all unique furniture in the room (there could be multiple units of the same furniture in the room)
-- 8. Most popular material for furniture in room seaching by room name
-- 9. List all rooms where there is more than optimal furniture count



























