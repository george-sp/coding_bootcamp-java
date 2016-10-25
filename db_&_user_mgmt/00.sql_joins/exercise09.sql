/*
 * Display the film categories (names) where the average difference between the film replacement cost
 * and the rental rate larger than 17.
 */
 
 # 1st
 SELECT sakila.category.`name`
 FROM sakila.film_category
 INNER JOIN sakila.film
 ON sakila.film_category.film_id = sakila.film.film_id
 INNER JOIN sakila.category
 ON sakila.category.category_id = sakila.film_category.category_id
 GROUP BY sakila.film_category.category_id
 HAVING AVG(sakila.film.replacement_cost) - AVG(sakila.film.rental_rate) > 17
 ORDER BY sakila.film_category.category_id DESC;
 
 # 2nd
 SELECT c.`name`, AVG(b.replacement_cost)cost, AVG(b.rental_rate)rate
 FROM sakila.film_category a
 INNER JOIN sakila.film b
 ON a.film_id = b.film_id
 INNER JOIN sakila.category c
 ON c.category_id = a.category_id
 GROUP BY c.`name`
 HAVING cost - rate > 17
 ORDER BY c.`name`