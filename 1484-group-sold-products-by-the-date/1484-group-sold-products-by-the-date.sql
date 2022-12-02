# Write your MySQL query statement below
# with ordered as (
#     select distinct sell_date, product 
#     from Activities
#     order by sell_date
# )

# select  sell_date, 
#         count(*) as num_sold,
#         group_concat(distinct product separator ',') as products
# from ordered
# group by sell_date
# order by sell_date


SELECT
    sell_date,
    COUNT(DISTINCT product) as "num_sold",
    GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') as "products"
FROM Activities
GROUP BY sell_date
ORDER BY sell_date ASC;



