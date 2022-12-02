# Write your MySQL query statement below
with ordered as (select distinct sell_date, product from Activities
                    order by sell_date desc)

select  sell_date, 
        count(*) as num_sold,
        group_concat(distinct product separator ',') as products
from ordered
group by sell_date
order by sell_date



