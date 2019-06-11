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



## 2.Servlet深入_转发和重定向_Cookie
### （1）请求中文乱码解决
#### 1）使用String进行数据重新编码
uname=new String(uname.getBytes("iso8859-1"),"utf-8");
#### 2）使用公共配置
- get方式：步骤一：req.setCharacterEncoding("utf-8");步骤二：在tomcat的目录下的conf目录中修改server.xml文件：在Connector标签中增加属性 useBodyEncodingForURI="true"
- post方式：req.setCharacterEncoding("utf-8");

### （2）Servlet流程总结
#### 1） 浏览器发起请求到服务器(请求)
#### 2） 服务器接受浏览器的请求，进行解析，创建request对象存储请求数据
#### 3） 服务器调用对应的servlet进行请求处理，并将request对象作为实参传递给servlet的方法
#### 4）servlet的方法执行进行请求处理
- 设置请求编码格式
- 设置响应编码格式
- 获取请求信息
- 处理请求信息：创建业务层对象，调用业务层对象的方法
- 响应处理结果

### （3）请求转发
作用:实现多个servlet联动操作处理请求，这样避免代码冗余，让servlet的职责更加明确。  
使用：
- req.getRequestDispatcher("要转发的地址").forward(req, resp);
- 地址：相对路径，直接书写servlet的别名即可。  

特点:一次请求，浏览器地址栏信息不改变。  
**注意**：请求转发后直接return结束即可。


### （4）reuqet作用域
作用：解决了一次请求内的不同Servlet 的数据(请求数据+其他数据)共享问题。  
使用：
- request.setAttribute(object name,Object value);
- request.getAttribute(Object obj);  

作用域：基于请求转发，一次请求中的所有Servlet 共享。  
**注意**：使用Request 对象进行数据流转，数据只在一次请求内有效。  
特点：服务器创建；每次请求都会创建；生命周期一次请求

### （5）重定向
解决了表单重复提交的问题，以及当前servlet无法处理的请求的问题。  
使用：resp.sendRedirect(String uri);  
示例:resp.sendRedirect("/login/main");  
特点：**两次请求**，两个request对象。浏览器地址栏信息改变，避免表单重复提交。  
使用时机：如果请求中有表单数据，而数据又比较重要，不能重复提交，建议使用重定向。如果请求被Servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源。

### （6）Cookie技术
作用:解决了发送的不同请求的数据共享问题  
使用：
- Cookie的创建和存储
```
Cookie的创建和存储
				//创建Cookie对象
					Cookie c=new Cookie(String name, String value);
				//设置cookie(可选)
					//设置有效期
					c.setMaxAge(int seconds);
					//设置有效路径
					c.setPath(String uri)
				//响应Cookie信息给客户端
					resp.addCookie(c);
```  

- Cookie的获取
```
//获取Cookie信息数组
			Cookie[] cks=req.getCookies();
			//遍历数组获取Cookie信息
				//使用for循环遍历即可，示例：
	 					if(cks!=null){
							for(Cookie c:cks){
								String name=c.getName();
								String value=c.getValue();
								System.out.println(name+":"+value);
							}
						}
```  

**注意**：一个Cookie对象存储一条数据。多条数据，可以多创建几个Cookie对象进行存储。  
特点：
- 浏览器端的数据存储技术；
- 存储的数据声明在服务器端；
- 临时存储:存储在浏览器的运行内存中，浏览器关闭即失效。
- 定时存储:设置了Cookie的有效期，存储在客户端的**硬盘**中，在有效期内符合路径要求的请求都会附带该信息。
- 默认cookie信息存储好之后，每次请求都会附带，除非设置有效路径

### （7）Cookie信息校验
- 判断请求中是否携带正确的Cookie信息
- 如果有则校验Cookie信息是否正确：如果校验正确则直接响应主页面给用户；如果校验不正确则响应登录页面给用户。
- 没有则请求转发给登录页面

## 3.Servlet深入_session_Context对象

### （1）session简介
原理：用户第一次访问服务器，服务器会创建一个session对象给此用户，并将该session对象的JSESSIONID使用Cookie技术存储到浏览器中，保证用户的其他请求能够获取到同一个session对象，也保证了不同请求能够获取到共享的数据。  
特点：存储在服务器端；服务器进行创建；依赖Cookie技术；一次会话；默认存储时间是30分钟。  
作用：解决了一个用户不同请求处理的数据共享问题

### （2）session使用
#### 1）创建session对象/获取session对象
HttpSession hs=req.getSession();  
- 如果请求中拥有session的标识符也就是JSESSIONID，则返回其对应的session队形
- 如果请求中没有session的标识符也就是JSESSIONID，则创建新的session对象，并将其JSESSIONID作为从cookie数据存储到浏览器内存中
- 如果session对象是失效了，也会重新创建一个session对象，并将其JSESSIONID存储在浏览器内存中。  

**注意**：JSESSIONID存储在了Cookie的临时存储空间中，浏览器关闭即失效
#### 2）设置session存储时间
hs.setMaxInactiveInterval(int seconds);  
**注意**：在指定的时间内session对象没有被使用则销毁，如果使用了则重新计时。
#### 3）设置session强制失效
hs.invalidate();
#### 4）存储和获取数据
存储：hs.setAttribute(String name,Object value);  
获取：hs.getAttribute(String name) 返回的数据类型为Object  
**注意**：存储的动作和取出的动作发生在不同的请求中，但是存储要先于取出执行。  
使用时机:一般用户在登陆web项目时会将用户的个人信息存储到Sesion中，供该用户的其他请求使用。  
#### 5）作用域
一次会话，在JSESSIONID和SESSION对象不失效的情况下为整个项目内。
#### 6）session失效处理
将用户请求中的JSESSIONID和后台获取到的SESSION对象的JSESSIONID进行比对，如果一致，则session没有失效，如果不一致则证明session失效了。重定向到登录页面，让用户重新登录。
#### 7）小结
session解决了一个用户的不同请求的数据共享问题，只要在JSESSIONID不失效和session对象不失效的情况下。用户的任意请求在处理时都能获取到同一个session对象。

### （3）