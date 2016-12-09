/*
 * Display the total customer's rentals per month as percentage of customer's yearly rentals
 */
 
-- Per month rentals of each customer
CREATE OR REPLACE VIEW monthly_rentals AS
SELECT customer_id, MONTH(rental_date) AS `month`, COUNT(rental_id) AS `rental_times`
FROM rental
WHERE YEAR(rental_date) = 2005
GROUP BY customer_id, MONTH(rental_date);

-- Total rentals of each customer
CREATE OR REPLACE VIEW yearly_rentals AS
SELECT customer_id, YEAR(rental_date) AS `year`, COUNT(rental_id) AS `rental_times`
FROM rental
WHERE YEAR(rental_date) = 2005
GROUP BY customer_id, YEAR(rental_date);

-- Per month rentals as percentage of each customer
SELECT m.customer_id, m.month, m.rental_times/y.rental_times AS `rentals_per_month_%`
FROM monthly_rentals AS m, yearly_rentals AS y
WHERE m.customer_id = y.customer_id;

# SELECT * FROM monthly_rentals;
# SELECT * FROM yearly_rentals;