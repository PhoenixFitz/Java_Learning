package insert;
/**
 * 代码优化，捕获异常,以该示例写代码
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc新增学习:
 * 		1	导入jdbc驱动包
 *		        声明JDBC变量
 *		        声明JDBC参数
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
public class TestInsert02 {
    public static void main(String[] args){
        //声明jdbc变量
        Connection conn=null;
        Statement stmt=null;
        //声明JDBC参数
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="scott";
        String password="oracle";
        //1 加载驱动类
        try {
            Class.forName(driver);
            //2 获取数据库连接对象(连接指定的数据库)
            conn=DriverManager.getConnection(url,username,password);
            //3 获取sql命令对象(编译和发送sql命令给数据库)
            stmt=conn.createStatement();
            //4 创建sql命令
            String sql="insert into dept values(97,'吃鸡学院','北京')";
            //5 执行sql命令
            int i=stmt.executeUpdate(sql);
            System.out.println("执行结果:"+i);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //6 关闭资源
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}






