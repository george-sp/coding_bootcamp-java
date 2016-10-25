/*
 * List the film id and titles of those films that are not in inventory.
 */
 SELECT sakila.film.film_id, sakila.film.title
 FROM sakila.film
 WHERE sakila.film.film_id 
 NOT IN (SELECT sakila.inventory.film_id 
		 FROM sakila.inventory);