/*
 * Display the film category id and the number of films that belong to each category.
 * Then return the results, sorted by the number of the films that belong to each category.
 */ 
 SELECT sakila.film_category.category_id, COUNT(sakila.film_category.film_id) AS `number of films`
 FROM sakila.film_category
 GROUP BY sakila.film_category.category_id
 ORDER BY `number of films`;