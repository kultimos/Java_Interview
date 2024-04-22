# leetCode 626 换座位

表: Seat
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| student     | varchar |
+-------------+---------+
id 是该表的主键（唯一值）列。
该表的每一行都表示学生的姓名和 ID。
id 是一个连续的增量。
编写解决方案来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换。
按 id 升序 返回结果表。

查询结果格式如下所示。
示例 1:

输入:
Seat 表:
+----+---------+
| id | student |
+----+---------+
| 1  | Abbot   |
| 2  | Doris   |
| 3  | Emerson |
| 4  | Green   |
| 5  | Jeames  |
+----+---------+
输出:
+----+---------+
| id | student |
+----+---------+
| 1  | Doris   |
| 2  | Abbot   |
| 3  | Green   |
| 4  | Emerson |
| 5  | Jeames  |
+----+---------+
解释:
请注意，如果学生人数为奇数，则不需要更换最后一名学生的座位;


# Answer
select
  case
    when mod(id, 2) != 0 and counts != id then id + 1
    when mod(id, 2) != 0 and counts = id then id
    else id - 1
  end as id, student
from seat,(select count(*) as counts from seat) seat_count_list
order by id asc