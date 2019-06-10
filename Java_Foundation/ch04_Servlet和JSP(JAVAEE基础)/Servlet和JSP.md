# Servlet和JSP

## 1.Servlet深入_request和response对象
### （1）Servlet的生命周期
- 从第一次调用到服务器关闭。
- 如果Servlet在web.xml中配置了load-on-startup，生命周期为从服务器启动到服务器关闭。  

**注意**：init方法是对Servlet进行初始化的一个方法，会在Servlet第一次加载进行存储时执行；destory方法是在servlet被销毁时执行，也就服务器关闭时。

### （2）Service方法和doGet方法和doPost方法的区别
- Service方法：可以处理get/post方式的请求，如果servlet中有Service方法，会优先调用service方法对请求进行处理。
- doGet方法：处理get方式的请求
- doPost方法：处理post方式的请求。  

**注意**：如果在覆写的service方法中调用了父类的service方法(super.service(arg0, arg1)),则service方法处理完后，会再次根据请求方式响应的doGet和doPost方法执行。所以，一般情况下是不在覆写的service中调用父类的service方法的，避免出现405错误。

### （3）Servlet的常见错误
#### 1）404错误:资源未找到
- 原因一：在请求地址中的servlet的别名书写错误。
- 原因二：虚拟项目名称拼写错误
#### 2）500错误：内部服务器错误
- 错误一：java.lang.ClassNotFoundException: com.bjsxt.servlet.ServletMothod
。解决：在web.xml中校验servlet类的全限定路径是否拼写错误。
- 错误二：因为service方法体的代码执行错误导致。解决：根据错误提示对service方法体中的代码进行错误更改。
#### 3）405错误:请求方式不支持
原因：请求方式和servlet中的方法不匹配所造成的。  
解决：尽量使用service方法进行请求处理，并且不要再service方法中调用父类的service。

### （4）request对象
作用：request对象中封存了当前请求的所有请求信息
#### 1）获取请求头数据
- req.getMethod();//获取请求方式
- req.getRequestURL();//获取请求URL信息
- req.getRequestURI();//获取请求URI信息
- req.getScheme();//获取协议
#### 2）获取请求行数据
- req.getHeader("键名");//返回指定的请求头信息
- req.getHeaderNames();//返回请求头的键名的枚举集合
#### 3）获取用户数据
- req.getParameter("键名");//返回指定的用户数据
- req.getParameterValues("键名");//返回同键不同值的请求数据(多选)，返回的数组。
- req.getParameterNames()//返回所有用户请求数据的枚举集合。  

**注意**：如果要获取的请求数据不存在，不会报错，返回null。request对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。

### （5）Respone对象
作用：用来响应数据到浏览器的一个对象
#### 1）设置响应头
- setHeader(String name,String value);//在响应头中添加响应信息，但是同键会覆盖
- addHeader(String name,String value);//在响应头中添加响应信息，但是不会覆盖。
#### 2）设置响应状态
sendError(int num,String msg);//自定义响应状态码。
#### 3）设置响应实体
resp.getWrite().write(String str);//响应具体的数据给浏览器
#### 4）设置响应编码格式：
resp.setContentType("text/html;charset=utf-8");

### （6）service请求处理代码流程
- 设置响应编码格式
- 获取请求数据
- 处理请求数据
- 数据库操作（MVC思想）	
- 响应处理结果

## 2.3.Servlet深入_转发和重定向_Cookie







