# JDBC
## 1.java数据的获取方式
- 直接声明变量并赋值
- Scanner类控制台输入
- IO流（将硬盘存储中的数据读取到java中）
- scoket+io
- 从数据库中获取
## 2.JDBC的概念
- 问题： java和数据库之间的沟通不一致  
- 解决： 数据库厂商对外提供java支持的接口
- 使用： 创建类实现接口(操作数据库)； 数据库厂商对外提供了数据库操作的驱动包.(翻译官)
- 结论： JDBC其实就是数据厂商对外提供的能够对自己的数据进行操作的驱动包也就是jar文件.

## 3.JDBC的基本使用流程（新增）（eclipse中）
### （1）导入jar包:
导入ojdbc6.jar,在项目上右键 builder path-->add to builder path.
### （2）加载驱动
`Class.forName("oracle.jdbc.driver.OracleDriver");`  
作用：初始化加载jdbc类到java虚拟机  
注意：ojdbc6.jar使用此包该句可以省略不写。
### （3）获取数据库连接对象
`Connection conn =DriverMananger.getConnection("url","username","password");`  
作用：  连接到指定的数据库并返回连接对象.  
参数含义:
- url:表示要连接的数据地址
- username:数据库的用户名
- password:数据库的密码 
### （4）创建sql命令对象
`Statement stmt=conn.createStatement();  `
作用:编译,发送SQL命令
### （5）创建sql命令
`String sql="insert into dept values(92,'','')";`
### （6）执行sql命令
新增sql命令:`int i=stmt.executeUpdate(sql);`  
返回值:返回值如果小于0,表示未执行成功;返回值如果大于0,表示成功修改的数据量.
### （7）关闭资源  
```
stmt.close();
connection.close();
```  
[TestInsert01.java](code/JDBC01/src/insert/TestInsert01.java)  
[TestInsert02.java](code/JDBC01/src/insert/TestInsert02.java)  

### （8）更新、删除流程
更新（删除）流程和新增比较除了SQL语句不同以外,代码基本一致；[TestUpdate.java](code/JDBC01/src/update/TestUpdate.java)  
[TestDel.java](code/JDBC01/src/delete/TestDel.java)

## 4.JDBC的事物管理
事务:一个事件的完成需要几个子操作的联合完成,只要有一个子操作执行失败,则数据回滚到原始状态,都成功则提交数据.  
注意:JDBC中的事务是自动提交的.
问题:如果在业务的处理过程中,某条Sql语句执行失败,但是数据已经被更改了.  
解决:设置JDBC的事务为手动提交；sql语句都执行成功后再统一提交,只要有失败的就回滚.
使用:[TestTran.java](code/JDBC01/src/translation/TestTran.java)
```
conn.setAutoCommit(false)//设置为手动提交
使用try catch进行SQL命令执行的异常处理
try中是使用conn.commit() 提交数据
catch中使用conn.rollback()回滚数据
```  
[UpdateName.java](code/JDBC01/src/practice/UpdateName.java)  
[StudentDaoImpl.java](code/JDBC01/src/daolmpl/StudentDaoImpl.java)  
[StudentDaoImpl2.java](code/JDBC01/src/daolmpl/StudentDaoImpl2.java)
## 5.查询
JDBC的查询:
- 加载驱动
- 创建连接对象
- 创建sql命令对象
- 创建sql命令
- 执行sql命令
- 返回存储了查询到的数据的对象(ResultSet)
- ResultSet对象是基于指针进行数据存储的,类似枚举.
- 关闭资源  

问题:查询的返回值类型是ResultSet,是基于指针尽心数据存储的,不便于数据的针对性的获取.  
解决:将数据转换到ArrayList中进行存储.  
使用:创建和表结构相同的实体类进行单条数据的存储(一条数据就是一个实例化对象),将对象存储到ArrayList中.  
快速获取返回值:alt+shift+L  
[TestSelect.java](code/JDBC01/src/select/TestSelect.java)
[Student.java](code/JDBC01/src/pojo/Student.java)

## 6.SQL注入
```
String sql="select * from t_user where userno='"
+userno+"' and password='"+upwd+"'";
```  
若变量输入类似为 String userno = "5 or 1 = 1";会导致数据库数据异常（数据被清空） 

## 7.创建Statement并发送命令
Statement对象用于将 SQL 语句发送到数据库中，或者理解为执行sql语句。  
三种Statement对象：
- Statement：用于执行不带参数的简单SQL语句；
- PreparedStatement（从 Statement 继承）：用于执行带或不带参数的预编译SQL语句，PreparedStatement对象比Statement对象的效率更高，并且**可以防止SQL注入，一般使用PreparedStatement**；
- CallableStatement（从PreparedStatement 继承）：用于**执行数据库存储过程的调用**。  

方法|作用
|:---:|:---:|
ResultSet executeQuery(String sql)|可以执行插入、删除、更新等操作，返回值是执行该操作所影响的行数
boolean execute(String sql) |可以执行任意SQL语句，然后获得一个布尔值，表示是否返回ResultSet
int executeUpdate(String sql) |执行SQL查询并获取到ResultSet对象  

## 8.preparedStatement对象完成增加删除修改查找
[JDBC02](code/JDBC02/src)




