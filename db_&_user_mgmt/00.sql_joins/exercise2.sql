/*
 * Return the full names(first and last) of actors with "SON" in their last name,
 * ordered by their first name.
 */
SELECT sakila.actor.first_name, sakila.actor.last_name
FROM sakila.actor
WHERE sakila.actor.last_name LIKE '%son%'
ORDER BY sakila.actor.first_name;