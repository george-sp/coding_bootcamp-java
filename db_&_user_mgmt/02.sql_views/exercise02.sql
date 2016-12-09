/*
 * Add the `last_update` column to the `actor_sample` view
 */
CREATE OR REPLACE VIEW actor_sample AS
SELECT actor_id, first_name, last_name, last_update
FROM actor;
 
/*
 * Display view's updated content
 */
SELECT * FROM actor_sample;