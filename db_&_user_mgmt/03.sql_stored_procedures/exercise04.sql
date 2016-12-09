/*
 * Create a procedure that receives as input a payment amount and a date 
 * and returns those payments (payment table) that exceed this amount for the days after the given day.
 * Also count the number of distinct dates that satisfy the above restriction.
 */
DELIMITER $
CREATE PROCEDURE count_exceed_payments(IN amount DECIMAL(5,2), IN date DATETIME, OUT distinct_dates INT)
BEGIN
	-- Display payments that exceed the given amount and for the days after the given date
    SELECT *
    FROM payment AS p 
    WHERE p.amount > amount AND p.payment_date > date;

	-- Count the distinct dates that satisfy the above restriction
    SET distinct_dates = (SELECT COUNT(DISTINCT payment_date) FROM payment WHERE payment_date > date);
END $

-- Call the procedure for amount = 1, and date = '2004-05-25 11:30:37'
DELIMITER ;
SET @amount = 1;
SET @date = '2004-05-25 11:30:37';

CALL count_exceed_payments(@amount, @date, @number_of_dates);

-- Display the number of distinct dates
SELECT @number_of_dates;

DROP PROCEDURE count_exceed_payments;