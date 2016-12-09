/*
 * Create a procedure that receives as input a payment amount and a date 
 * and returns those payments (payment table) that exceed this amount for the days after the given day.
 */
DELIMITER $
CREATE PROCEDURE find_exceed_amount_by_date(IN amount DECIMAL(5,2), IN date DATETIME)
BEGIN
	-- Display payments that exceed the given amount and for the days after the given date
    SELECT *
    FROM payment AS p 
    WHERE p.amount > amount AND payment_date > date;
END $

-- Call the procedure for amount = 1, and date = '2004-05-25 11:30:37'
DELIMITER ;
SET @amount = 1;
SET @date = '2004-05-25 11:30:37';
CALL find_exceed_amount_by_date(@amount, @date);

DROP PROCEDURE find_exceed_amount_by_date;