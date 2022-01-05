# Write your MySQL query statement below

SELECT DISTINCT a.id, c.name
FROM   (SELECT DISTINCT id, login_date,
        DENSE_RANK() OVER(PARTITION BY id ORDER BY login_date) as rnk
        FROM Logins) a
JOIN Accounts c ON a.id = c.id 
GROUP BY a.id, DATE_ADD(a.login_date, INTERVAL -rnk DAY)
HAVING COUNT(a.id) >= 5
ORDER BY a.id

