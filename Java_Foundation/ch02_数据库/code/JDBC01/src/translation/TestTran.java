package translation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的事务管理:
 * 		转账业务
 * 示例:
 * 		张三给李四转账1000元.
 *
 * 注意:
 * 		JDBC中的事务是自动提交的.
 * 问题:
 * 		如果在业务的处理过程中,某条Sql语句执行失败,但是数据已经被更改了.
 * 解决:
 * 		设置JDBC的事务为手动提交.
 * 		sql语句都执行成功后再统一提交,只要有失败的就回滚.
 * 使用:
 * 		conn.setAutoCommit(false)//设置为手动提交
 * 		使用try catch进行SQL命令执行的异常处理
 * 			try中是使用conn.commit() 提交数据
 * 			catch中使用conn.rollback()回滚数据
 *
 */
public class TestTran {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //加载启动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","oracle");
        //设置事务为手动提交
        conn.setAutoCommit(false);
        //创建sql命令对象
        Statement stmt = conn.createStatement();
        //创建sql命令
        String sql1="update student set money=money-1000 where snum=6";//转账
        String sql2="update student set money=money2+1000 where snum=7";//入账
        //执行sql命令
        try {
            int i1=stmt.executeUpdate(sql1);
            int i2=stmt.executeUpdate(sql2);
            System.out.println(i1+"----"+i2);
            conn.commit();  //数据提交
        } catch (Exception e) {
            conn.rollback();//数据回滚
        }
        //关闭资源
        stmt.close();
        conn.close();
    }
}
