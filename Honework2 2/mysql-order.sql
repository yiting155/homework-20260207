SELECT * FROM homework2.order;

select
gjun2.orders.order_no, /*位置 表示為gjun2中的orders中的orders_no*/
gjun2.product.product_name,
gjun2.orders.amount,
gjun2.orders.amount*gjun2.product.product_price #這邊的*就是數學中的*
from
gjun2.product,gjun2.orders;