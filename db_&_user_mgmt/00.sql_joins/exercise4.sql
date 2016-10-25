/*
 * Display the film title and the film category it belongs to.
 * Return the names of these categories and the name of the film, sorted by the name of the film alphabetically.
 */
SELECT a.title, c.`name`
FROM sakila.film AS a
INNER JOIN sakila.film_category AS b
ON a.film_id = b.film_id
INNER JOIN sakila.category AS c
ON b.category_id = c.category_id
ORDER BY a.title ASC;