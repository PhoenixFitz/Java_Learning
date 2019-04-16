package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDel {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1 加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2 创建连接对象
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","oracle");
        //3 创建sql命令对象
        Statement stmt = conn.createStatement();
        //4 创建sql命令
        String sql="delete from student where snum='2'";
        //5 执行sql命令
        int i = stmt.executeUpdate(sql);
        System.out.println("删除数据量:"+i);
        //6 关闭资源
        stmt.close();
        conn.close();
    }
}
