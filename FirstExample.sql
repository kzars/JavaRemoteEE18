/* Multi line 
	comment */
    
 -- Single line comment
 
 -- Creating table
 
 CREATE TABLE Presidents(
	PersonID int,
    Country varchar(50),
    LastName varchar(100),
    FirstName varchar(100),
    Address varchar(255),
    City varchar(50),
    PRIMARY KEY(PersonID)
 );
 
 -- Inserting records into table
 
 INSERT INTO Presidents (PersonID, Country, LastName, FirstName, Address, City)
 VALUES (1000, 'USA', 'Trump', 'Donald', 'House is 515 North County Road, Palm Beach, Florida 33480','Florida');
 
 INSERT INTO Presidents VALUES (1001, 'USA', 'Obama', 'Barack', '2500 W. Golf Road Hoffman Estates, IL 60169-1114', 'Florida');
 
 INSERT INTO Presidents (PersonID, Country, LastName, FirstName) VALUES (1002, 'USA', 'Biden','Joe');
 
 INSERT INTO Presidents (PersonID, Country, LastName, FirstName) VALUES (1003, 'USA', 'Georg W.','Bush');
 
 -- View table records
 
 SELECT * FROM presidents;
 
 SELECT LastName, City FROM presidents;
 
 -- WHERE 
 
 SELECT LastName, City FROM presidents WHERE City = 'Florida';
 
 -- AND
 
 SELECT FirstName, Country, City FROM presidents WHERE City = 'Florida' AND LastName = 'Trump';
 
 -- OR
 
 SELECT * FROM presidents WHERE LastName = 'Obama' OR FirstName = 'Joe';
 
 -- NOT 
 
 SELECT * FROM presidents WHERE NOT LastName = 'Obama'; 
 
 -- ORDER
 
 SELECT * FROM presidents ORDER BY LastName;
 
 -- ORDER desc
 
 SELECT * FROM presidents ORDER BY LastName DESC;
 
 
 -- ORDER by more that one column
 
 SELECT * FROM presidents ORDER BY City, LastName;
 
 -- DISTINCT return only unique values
 
 SELECT DISTINCT Country FROM presidents;
 
 -- Count how many records are in the table
 
SELECT COUNT(*) FROM presidents; 

-- Count how many unique countries is there in the table

SELECT COUNT(DISTINCT Country) FROM presidents;

-- Update data
UPDATE Presidents SET City = 'New York' WHERE PersonID = 1002;

-- UPDATE Presidents SET City = 'New Florida' WHERE City = 'Florida';


-- DELETE RECORDS
DELETE FROM presidents WHERE PersonID = 1003;


-- DELETE TABLE
DROP TABLE presidents;
