package daolmpl;

import pojo.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class StudentDaoImpl {

    //查询所有学生信息
    public ArrayList<Student> getStudentInfo() throws ClassNotFoundException, SQLException{
        //声明List集合
        ArrayList<Student> list=new ArrayList<>();
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","oracle");
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
        return list;
    }

    //根据新的昵称修改用户昵称
    public int updateSname(String newName) throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //设置事务手动提交
        conn.setAutoCommit(false);
        //创建sql命令对象
        Statement stmt=conn.createStatement();
        //创建sql命令
        String sql="update student set sname='"+newName+"' where snum=6";
        //执行sql命令
        int i=-1;
        try {
            i=stmt.executeUpdate(sql);
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
        }
        //关闭资源
        stmt.close();
        conn.close();
        return i;

    }
}
