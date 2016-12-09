/*
 * Create a View in `sakila` 
 * that contains the values from columns `actor_id`, `first_name`, `last_name` 
 * from table `actor`
 */
CREATE OR REPLACE VIEW actor_sample AS
SELECT actor_id, first_name, last_name
FROM actor;
 
/*
 * Display view's content
 */
SELECT * FROM actor_sample;