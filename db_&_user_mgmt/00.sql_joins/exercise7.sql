/*
 * Display the film categories (film_category_id) where the average difference between the film replacement cost
 * and the rental rate larger than 17.
 */
 SELECT sakila.film_category.category_id, AVG(sakila.film.replacement_cost - sakila.film.rental_rate) `average difference`
 FROM sakila.film_category
 INNER JOIN sakila.film
 ON sakila.film_category.film_id = sakila.film.film_id
 GROUP BY sakila.film_category.category_id
 HAVING `average difference` > 17
 ORDER BY sakila.film_category.category_id DESC;