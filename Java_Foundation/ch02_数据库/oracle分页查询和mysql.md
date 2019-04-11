# oracle分页查询和mysql
## 1.oracle分页查询
问题：当一个表中的数据量特别大的时候，如果一次性全部显示给用户，则造成页面过于庞大，体验极差。  
解决：使用分页查询。  
使用：rownum关键字：oracle对外提供的自动给查询结果编号的关键字，与每行的数据没有关系。**注意**：rownum关键字只能做< <=的判断，不能进行> >=的判断。  
- 查询员工信息的前5条数据 第一页数据：select rownum r,e.* from emp e where rownum <=5; 
- 查询员工信息的6-10条数据 第二页数据：select rownum r,e.* from emp e where rownum <=10;（显示10条信息） select rownum,t.* from (select rownum r,e.* from emp e where rownum <=10) t where r>5;（显示5条信息）
- 查询员工信息的11-15条数据 第三页数据：select rownum r,e. * from emp e where rownum<=15;（15条） select * from (select rownum r,e. * from emp e where rownum<=15) t where r>10;（5条）  

**分页规律总结**：每页显示m条数据，查询第n页数据。
- select * from (select rownum r,e. * from 要分页的表 e where rownum<=m*n) t where r>m*n-m;
- 要分页的表既可以是真实的表，也可以是一个查询语句。  

例：分页查询员工信息按照工资排序  
select * from (select rownum r,t.* from (select * from emp  order by sal) t where rownum<=10 ) where r>5

## 2.MySQL数据库
开放源码，轻量型的数据库管理系统。
### （1）安装
安装好MySQL后，安装navicat，此软件为MySQL的图形化操作软件
### （2）卸载
- 控制面板中卸载MySQL
- 在盘符中将mysql的安装文件夹删除， 如：C:\Program Files\mysql
- 在programData隐藏文件夹下，删除mysql文件夹
### （3）创建连接
连接不是数据库，是需要在连接下，才能创建数据库
### （4）创建数据库
使用命令：
- 打开任意一个数据库，选择QUERY->NEW QUERY
- 创建命令create database 库名 default character set utf8； ##注释内容
- 切换数据库到新建库： ues 库名  

使用图形界面：鼠标右键
### （5）删除数据库
drop database

### （6）创建表
语句： create table 表名（字段名 类型 约束，字段名 类型 约束，……）  
**注意**：MySQL是没有序列的，但可以在创建表的时候直接指定主键是递增的，在创建表的字段后使用**auto_increment**  
https://blog.csdn.net/a909301740/article/details/62887992

### （7）数据类型
#### 1） 数值类型
- smallint, 2 字节
- int, 4 字节 
- Integer, int 的同义词
- bigint, 8 字节
- float, 4 字节
- double, 8 字节
#### 2）字符类型
- char, 不可变长度
- varchar, 可变长度
#### 3）日期时间类型
- date, yyyy-mm-dd
- datetime, yyyy-mm-dd hh:mi:ss  8 字节
- time, hh:mi:ss
- timestamp, 更精确的时间  4 字节，自动进行时区的转换
- year, yyyy
#### 4）其他类型
- blob, 存放二进制文件
- text, 存放大量文本信息

### （8）约束（跟Oracle创建约束类似）
#### 1）主键约束
在创建表时，字段后使用 primary key  
创建表语句最后面 使用constraint 约束名 primary key（主键字段名）
#### 2）非空约束
在创建表时，字段后使用 not null， **注意**：mysql的非空约束中空字符是可以存储进去的，Oracle不可以  
在创建表完成后， 使用alter table 表名 modify 字段名 类型 not null 
#### 3）检查约束
问题：在mysql中是没有检查约束，但是使用check关键字不会报错。  
解决：使用代码逻辑进行无效数据的过滤（常用）；使用mysql的存储过程
#### 4）唯一约束
字段名后使用unique
#### 5）外键约束
字段名后直接使用 references 父表名（字段名）  
创建语句后：constraint 外键约束名 foreign key(字段名) references 父表名（字段名）  
在创建表之后： alter table 表名 add  constraint 外键约束名 foreign key (字段名) references 父表名（字段名） on delete set null on update cascade;

### （9）表的修改删除
#### 1）添加字段
alter table 表名 add 字段名 类型
#### 2）删除字段
alter table 表名 drop 字段名
#### 3）修改字段类型
alter table 表名 modify 字段名 字段类型
#### 4）修改字段名
alter table 表名 change 字段名 新字段名 类型
#### 5）修改表名
alter table 表名 rename as 新表名
#### 6）删除表
drop table 表名

### （10）其他操作
- 显示表信息 show tables
- 显示创建表语句 守望 create table 表名
- 显示库 show databases

### （11）数据操作
#### 1）查询
单表查询：
- 别名：直接空格在后面使用
- 去除重复： distinct关键字
- 连接符：使用concat（字段名，字段名）
- where子句：跟oracle一样  
- 函数：max,min,avg,sum,count
- 分组：group by 关键字 ，**注意**分组可以和字段一起使用
- having ：分组后筛选
- 排序： order by 字段名  
 
多表查询：SQL92和SQL99:和oracle一样，
#### 2）增加
insert into 表名 values（值1，值2，值3....）；全字段插入
insert into 表名（主键字段名，字段名，字段名....） values（值1，值2，值3....）； 部分字段插入
#### 3）删除
delete from 表名 where 条件
#### 4）修改
update 表名 set 字段名= 值， 字段名=值....where 条件

### （12）分页
MySQL分页需要使用** limit **关键字, limit 后需要跟两个数字, 第一个数字表示查询的起始位置, 第二个数字表示查
询的记录数. limit 要写在 order by 之后.
- 当前页数page， 每页显示的记录数size，select * from clazz limit (page-1)*size, size;

### （13）数据备份
命令方式：
- 导出：mysqldump -u root -p 数据库名 > dbname.sql（整个库）；mysqldump -u root -p 数据库名 表名> dbname.sql（只导出一个表）
- 导入：mysql>source d:\dbname.sql； 或者mysql -u root -p 数据库名 < dbname.sql  
工具方式：
- 导出：直接在库上右键选择导出数据库
- 导入：在库上右键选择导入数据库
