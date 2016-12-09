/*
 * Display the total customer's payments per month as percentage of customer's yearly payments
 * (from customer display: first_name & last_name)
 */
 
-- Per month payments for each customer
CREATE OR REPLACE VIEW monthly_payments AS
SELECT customer_id, MONTH(payment_date) AS `payment_month`, SUM(amount) AS `total_amount`
FROM payment
WHERE YEAR(payment_date) = 2005
GROUP BY customer_id, MONTH(payment_date);

-- Total payments for each customer
CREATE OR REPLACE VIEW yearly_payments AS
SELECT customer_id, YEAR(payment_date) AS `payment_year`, SUM(amount) AS `total_amount`
FROM payment
WHERE YEAR(payment_date) = 2005
GROUP BY customer_id, YEAR(payment_date);

-- id, first_name, last_name from the customer table
CREATE OR REPLACE VIEW customer_name AS
SELECT customer_id, first_name, last_name
FROM customer;

-- Per month payments as percentage for each customer
/*
SELECT m.customer_id, c.first_name, c.last_name, m.payment_month, m.total_amount/y.total_amount AS `payments_per_month_%`
FROM monthly_payments AS m
INNER JOIN yearly_payments AS y
ON m.customer_id = y.customer_id
INNER JOIN customer_name AS c
ON c.customer_id = m.customer_id;
*/
SELECT c.first_name, c.last_name, m.payment_month, m.total_amount/y.total_amount AS `payments_per_month_%`
FROM monthly_payments AS m, yearly_payments AS y, customer_name AS c
WHERE c.customer_id = m.customer_id AND m.customer_id = y.customer_id;

# SELECT * FROM monthly_payments;
# SELECT * FROM yearly_payments;