/*
 * Create a list of actors (id, first, last name) and the number of movies by each actor,
 * that have played in movies that had a duration more than 183 minutes.
 * Display the results sorted by the number of films each actor has paricipated.
 */
 # 1st way
 SELECT sakila.actor.actor_id, sakila.actor.first_name, sakila.actor.last_name, COUNT(sakila.film_actor.film_id) AS `number of films`
 FROM sakila.actor
 INNER JOIN sakila.film_actor
 ON sakila.actor.actor_id = sakila.film_actor.actor_id
 INNER JOIN sakila.film
 ON sakila.film.film_id = sakila.film_actor.film_id
 WHERE sakila.film.length > 183
 GROUP BY sakila.actor.actor_id, sakila.actor.first_name, sakila.actor.last_name
 ORDER BY `number of films` DESC;
# 2nd way (aliases)
select  a.actor_id, a.first_name, a.last_name, count(b.film_id) NumberOfFilms
from sakila.actor AS a
inner join sakila.film_actor AS b 
on a.actor_id=b.actor_id
inner join sakila.film AS c 
on  c.film_id=b.film_id
where c.length>183
group by a.actor_id, a.first_name, a.last_name
order by NumberOfFilms 