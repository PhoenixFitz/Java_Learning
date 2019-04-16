package select;


import daolmpl.StudentDaoImpl;
import pojo.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * JDBC的查询:
 * 		加载驱动
 * 		创建连接对象
 * 		创建sql命令对象
 * 		创建sql命令
 * 		执行sql命令
 * 			返回存储了查询到的数据的对象(ResultSet)
 * 				ResultSet对象是基于指针进行数据存储的,类似枚举.
 * 		关闭资源
 * 问题:
 * 		查询的返回值类型是ResultSet,是基于指针进行数据存储的,不便于数据的针对性的获取.
 * 解决:
 * 		将数据转换到ArrayList中进行存储.
 * 使用:
 * 		创建和表结构相同的实体类进行单条数据的存储(一条数据就是一个实例化对象)
 * 		将对象存储到ArrayList中.
 * 快速获取返回值:
 * 		alt+shift+L
 *
 * @author MyPC
 *
 */
public class TestSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //声明List集合
        ArrayList<Student> list=new ArrayList<>();
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","oracle");
        //创建sql命令对象
        Statement stmt=conn.createStatement();
        //创建Sql命令
        String sql="select * from student";
        //执行Sql命令
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            //创建学生对象
            Student stu=new Student();
            stu.setSnum(rs.getInt("snum"));
            stu.setSname(rs.getString("sname"));
            stu.setSage(rs.getInt("sage"));
            stu.setMoney(rs.getDouble("money"));
            //将对象存储到ArrayList中
            list.add(stu);
        }
        System.out.println(list.get(2));
        //创建DaoImpl层对象
        StudentDaoImpl sd=new StudentDaoImpl();
        ArrayList<Student> ls=sd.getStudentInfo();
    }
}
