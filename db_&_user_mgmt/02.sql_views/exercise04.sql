/*
 * Display the total customer's payments per month as percentage of customer's yearly payments
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

-- Per month payments as percentage for each customer
SELECT m.customer_id, m.payment_month, m.total_amount/y.total_amount AS `payments_per_month_%`
FROM monthly_payments AS m, yearly_payments AS y
WHERE m.customer_id = y.customer_id;

# SELECT * FROM monthly_payments;
# SELECT * FROM yearly_payments;