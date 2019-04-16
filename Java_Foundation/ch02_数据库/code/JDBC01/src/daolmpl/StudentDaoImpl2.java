package daolmpl;


import pojo.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * 对开发需求的直观映射是SQL语句.
 * 开发步骤:
 * 		业务需求分析
 * 		数据库设计
 * 		sql语句设计
 * 		数据库操作功能类实现
 * 		业务逻辑代码实现
 * 		联合测试
 * 		上线测试
 * 		维护
 * ----------------------------------
 * 对于增加删除和修改除了Sql语句的声明不一致以外,其他声明基本一致.
 * 封装的思想:
 * 		相同的保留,不同的传参.
 *
 * ----------------------------------
 * 使用Statement对象完成增加删除修改
 * @author MyPC
 *
 */
public class StudentDaoImpl2 {

    //增加
    public int insStu(String sname,int sage,double money) throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //创建sql命令对象
        Statement stmt=conn.createStatement();
        //创建sql命令
        String sql="insert into student values(stu_seq.nextval,'"+sname+"','"+sage+"','"+money+"')";
        //执行sql命令
        int i=stmt.executeUpdate(sql);
        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }
    //删除
    public int delStu(int snum) throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //获取sql命令对象
        Statement stmt=conn.createStatement();
        //创建sql命令
        String sql="delete from student where snum="+snum;
        //执行sql命令
        int i=stmt.executeUpdate(sql);
        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }
    //修改
    public int upStu(int snum,String newName) throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //获取sql命令对象
        Statement stmt=conn.createStatement();
        //创建sql命令
        String sql="update student set sname='"+newName+"' where snum="+snum;
        //执行sql命令
        int i=stmt.executeUpdate(sql);
        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }
    //查询
    public ArrayList<Student> getStudentInfo() throws ClassNotFoundException, SQLException{
        //声明集合对象
        ArrayList<Student> ls=new ArrayList<>();
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //获取sql命令对象
        Statement stmt=conn.createStatement();
        //创建sql命令
        String sql="select * from student";
        //执行sql命令
        ResultSet rs=stmt.executeQuery(sql);
        //遍历结果
        while(rs.next()){
            Student s=new Student();
            s.setSnum(rs.getInt("snum"));
            s.setSname(rs.getString("sname"));
            s.setSage(rs.getInt("sage"));
            s.setMoney(rs.getDouble("money"));
            ls.add(s);
        }
        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
        return ls;
    }


}
