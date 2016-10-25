/*
 * Find the title of 'English' films having category of 'Documentary'
 */
SELECT c.title, a.`name` AS category, d.`name` AS `language`
FROM sakila.category a
INNER JOIN sakila.film_category b
ON a.category_id = b.category_id
INNER JOIN sakila.film c
ON b.film_id = c.film_id
INNER JOIN sakila.language d
ON c.language_id = d.language_id
WHERE a.`name`='Documentary' AND d.`name`='English';