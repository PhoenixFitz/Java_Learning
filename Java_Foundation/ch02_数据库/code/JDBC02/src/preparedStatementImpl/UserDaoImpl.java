package preparedStatementImpl;



import pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * 完成用户登录功能:
 * 		分析:
 * 			根据用户名和密码查询用户信息
 *
 * ----------
 * 	使用preparedStatement对象完成增删改查
 *
 * @author MyPC
 *
 */
public class UserDaoImpl {


    //查询用户信息
    public User getUserInfo(String uname, String upwd) throws ClassNotFoundException, SQLException{
        //声明User对象
        User u=null;
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //创建sql命令
        String sql="select * from t_user where uname=? and upwd=?";
        //创建sql命令对象
        PreparedStatement ps=conn.prepareStatement(sql);
        //给占位符赋值(占位符从左到右角标从1开始)
        ps.setString(1, uname);
        ps.setString(2, upwd);

        //执行sql命令
        ResultSet rs=ps.executeQuery();
        //遍历查询结果
        while(rs.next()){
            u=new User();
            u.setUnum(rs.getInt("unum"));
            u.setUname(rs.getString("uname"));
            u.setUpwd(rs.getString("upwd"));
            return u;
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        //返回执行结果
        return u;
    }
    //新增--preparedStatement
    public int insUser2() throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //创建sql命令
        String sql="insert into t_user values(?,?,?)";
        //创建sql命令对象
        PreparedStatement ps=conn.prepareStatement(sql);
        //给占位符赋值
        ps.setInt(1, 7);
        ps.setString(2,"赵六");
        ps.setString(3,"666");
        //执行sql命令
        int i=ps.executeUpdate();
        //关闭资源
        ps.close();
        conn.close();
        //返回结果
        return i;
    }
    //更新
    public int upUser(String uname,int unum) throws ClassNotFoundException, SQLException{
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //创建sql命令
        String sql="update t_user set uname=? where unum=?";
        //获取sql命令对象
        PreparedStatement ps=conn.prepareStatement(sql);
        //给占位符赋值
        ps.setString(1, uname);
        ps.setInt(2, unum);
        //执行sql命令
        int i=ps.executeUpdate();
        //关闭资源
        ps.close();
        conn.close();
        //返回结果
        return i;
    }
    //删除
    public int delUser(int unum) throws ClassNotFoundException, SQLException{

        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接对象
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");
        //创建sql命令
        String sql="delete from t_user where unum=?";
        //获取sql命令对象
        PreparedStatement ps=conn.prepareStatement(sql);
        //给占位符赋值
        ps.setObject(1, unum);
        //执行sql命令
        int i=ps.executeUpdate();
        //关闭资源
        ps.close();
        conn.close();
        //返回结果
        return i;

    }



	/*//插入
	public int insUser() throws ClassNotFoundException, SQLException{
		//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接对象
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "oracle");

		//创建sql命令对象
			Statement stmt=conn.createStatement();
		//创建sql命令
			String sql="insert into t_user values(3,'王五','999')";
			String sql1="insert into t_user values(4,'王五1','999')";
			String sql2="insert into t_user values(5,'王五2','999')";
			String sql3="insert into t_user values(6,'王五3','999')";
		//执行sql命令
			int i=stmt.executeUpdate(sql);
			i+=stmt.executeUpdate(sql1);
			i+=stmt.executeUpdate(sql2);
			i+=stmt.executeUpdate(sql3);
		//关闭资源
			stmt.close();
			conn.close();
			return i;
	}
	*/
}

