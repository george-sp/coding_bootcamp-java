/*
 * Create and execute a procedure that displays the first and the last name from table actors.
 */
DELIMITER $
CREATE PROCEDURE first_and_last_actors()
BEGIN
	-- Get first actor_id
	SET @first = (SELECT actor_id FROM actor ORDER BY actor_id ASC LIMIT 1);
	-- Get last actor id
	SET @last = (SELECT actor_id FROM actor ORDER BY actor_id DESC LIMIT 1);
	-- Display the first and the last actor
    SELECT first_name, last_name 
    FROM actor 
    WHERE actor_id = @first 
    OR actor_id = @last;
END $

CALL first_and_last_actors();

-- DROP PROCEDURE first_and_last_actors;