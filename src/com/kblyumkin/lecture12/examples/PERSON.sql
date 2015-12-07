SELECT *
FROM person p
WHERE gender IN ('male', 'female');
SELECT *
FROM person
ORDER BY gender;

SELECT
  count(name) AS 'count',
  gender
FROM person
GROUP BY gender;

INSERT INTO person (name, gender) VALUES ('Peter', 'male');
DELETE FROM person
WHERE name NOT IN ('John', 'Sara', 'Mike');
UPDATE Person
SET name = 'Mike'
WHERE name = 'Peter';


	
