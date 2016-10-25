/*
 * Display the film category id that contain more than 50 films.
 * Then return the results, sorted by the number of the films that belong to each category.
 */
 SELECT sakila.film_category.category_id, sakila.category.`name`, COUNT(sakila.film_category.film_id) AS `number of films`
 FROM sakila.film_category
 INNER JOIN sakila.category
 ON sakila.film_category.category_id = sakila.category.category_id
 GROUP BY sakila.film_category.category_id
 HAVING `number of films` > 50
 ORDER BY `number of films`;