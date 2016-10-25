/*
 * Create a list of films and their corresponding category names.
 */
 SELECT f.title, c.`name`
 FROM sakila.film AS f
 INNER JOIN sakila.film_category AS fc
 ON f.film_id = fc.film_id
 INNER JOIN sakila.category AS c
 ON c.category_id = fc.category_id;