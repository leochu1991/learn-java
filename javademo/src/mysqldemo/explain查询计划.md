### `EXPLAIN` 查询计划

`IN` 与 `EXISTS` 区别：

`IN` 先查询子查询结果，然后 `WHERE` 子句判断，适合子查询结果少的情况。

``` mysql
SELECT * FROM A WHERE id IN (SELECT id FROM B)
```

相当于：

~~~ mysql
FOR SELECT id FROM B
FOR SELECT * FROM A WHERE A.id = B.id(B.id是常量)
~~~



`EXISTS(SUBQUERY)` 返回 `TRUE` 或者 `FALSE` ，将主查询中的数据，与子查询的结果进行条件验证( `WHERE` 子句中判断)，子查询结果不为 `NULL` 则 `EXISTS` 返回 `TRUE` ，主查询数据保留，为 `FALSE` 则不保留。

~~~ mysql
SELECT * FROM A WHERE EXISTS (SELECT 1 FROM B WHERE A.id = B.id)
~~~

相当于：

~~~ mysql
FOR SELECT * FROM A
FOR SELECT 1 FROM B WHERE B.id = A.id(A.id是常量)
~~~





#### 参考文章