/*
 * Find all the addresses where the district is empty, and return these addresses sorted by city_id in ascending order.
 */
 SELECT sakila.address.address
 FROM sakila.address
 WHERE sakila.address.district = ''
 ORDER BY sakila.address.city_id ASC;