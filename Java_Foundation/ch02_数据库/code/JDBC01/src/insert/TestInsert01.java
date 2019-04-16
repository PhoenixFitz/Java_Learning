package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc新增学习:
 * 		1	导入jdbc驱动包
 * 		2 	加载驱动
 * 		3 	常见数据库连接
 * 		4 	创建数据库命令对象
 * 		5	创建sql命令
 * 		6	执行sql
 * 		7 	关闭资源
 * 常见的jdbc错误:
 * 		a ClassNotFoundException:
 * 				驱动类未找到.
 * 		b   java.sql.SQLException: No suitable driver found for :thin:@localhost:1521:orcl
 * 				URL错误
 * 		c	java.sql.SQLException: ORA-01017: invalid username/password; logon denied
 * 				用户 名或密码错误
 * 		d	java.sql.SQLSyntaxErrorException: ORA-00900: 无效 SQL 语句
 * 				Sql语句错误
 * 		e	java.sql.SQLIntegrityConstraintViolationException: ORA-00001: 违反唯一约束条件 (SCOTT.PK_DEPT)
 * 				主键冲突
 *
 */
public class TestInsert01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2 获取数据库连接对象(连接指定的数据库)
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","oracle");
        //3 获取sql命令对象(编译和发送sql命令给数据库)
        Statement stmt = connection.createStatement();
        //4 创建sql命令
        String sql = "insert into dept value(92,'overwatch','北京')";
        // 5 执行sql命令
        int i = stmt.executeUpdate(sql);  //返回 执行成功的语句数， 若不成功，返回-1
        System.out.println("执行结果：" + i);
        // 6关闭资源
        stmt.close();
        connection.close();

    }
}
