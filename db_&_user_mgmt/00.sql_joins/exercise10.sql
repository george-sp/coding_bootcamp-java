/*
 * Create a list of actors (id, first, last name) and the number of films by each actor, that have played.
 * Display the results sorted by the number of films each actor has participated.
 */
 SELECT sakila.actor.actor_id, sakila.actor.first_name, sakila.actor.last_name, COUNT(sakila.film_actor.film_id) AS `number of films`
 FROM sakila.actor
 INNER JOIN sakila.film_actor
 ON sakila.actor.actor_id = sakila.film_actor.actor_id
 GROUP BY sakila.actor.actor_id, sakila.actor.first_name, sakila.actor.last_name 
 ORDER BY `number of films`;