/*
 * Create a procedure to display everything from table actor with id = 58.
 */
DELIMITER $
CREATE PROCEDURE find_actor_by_id(IN id INT)
BEGIN
	-- Display everything from actor table for this id
    SELECT first_name, last_name 
    FROM actor 
    WHERE actor_id = id;
END $

DELIMITER ;
SET @id_58 = 58;
CALL find_actor_by_id(@id_58);

DROP PROCEDURE first_and_last_actors;