#ajax技术

## 1.基本概念
AJAX全称为“Asynchronous JavaScript and XML”（异步JavaScript和XML），是一种创建交互式网页应用的网页开发技术，**用来在当前页面内响应不同的请求内容**，Ajax本质上是一个浏览器端的技术。  
**作用**：实现在**当前结果页**中显示其他请求的响应内容。  

是如下几种技术的组合应用：
- 基于web标准（standards-based presentation）XHTML+CSS的表示；
- 使用 DOM（Document Object Model）进行动态显示及交互；
- 使用 XML 和 XSLT 进行数据交换及相关操作；
- 使用 XMLHttpRequest 进行异步数据查询、检索；
- 使用 JavaScript 将所有的东西绑定在一起。  

### （1）原理
请求由ajax引擎对象发送，响应数据，浏览器不会直接进行处理，而是流转给发请求的ajax引擎对象。这样我们可以通过操作ajax引擎对象变相的实现在页面中显示新的响应资源。

### （2）本质
js的DOM操作中的数据由程序员自己写死声明，变成从服务器动态的获取。

## 2.ajax使用流程
```
//创建ajax引擎对象
	//复写onreadystatement函数
		//判断ajax状态码
			//判断响应状态码
				//获取响应内容(响应内容的格式)
					//普通字符串：responseText
					//json(重点)：responseText
					其实就是讲述数据按照json的格式拼接好的字符串，方便使用eval方法
					将接受的字符串数据直接转换为js的对象
									
					json格式：
					var 对象名={
																		属性名:属性值,
																		属性名:属性值,
																		……
					}
									
					//XML数据：responseXML.返回document对象
					通过document对象将数据从xml中获取出来
				//处理响应内容(js操作文档结构)
		//发送请求
			//get请求
				get的请求实体拼接在URL后面，？隔开，键值对
				ajax.open("get","url");
				ajax.send(null);
			//post请求
				有单独的请求实体
				ajax.open("post", "url");
				ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				ajax.send("name=张三&pwd=123");
```  

## 3.ajax的状态码和http状态码
|readyState值|含义|
|:---:|:---:|
|0|表示XMLHttpRequest已建立，但还未初始化，这时尚未调用open方法|
|1|表示open方法已经调用，但未调用send方法（已创建，未发送）|
|2|表示send方法已经调用，其他数据未知|
|3|表示请求已经成功发送，正在接受数据|
|4|表示数据已经成功接收。|  


|http状态码（state）|含义|
|:---:|:---:|
|200|请求成功|
|404|请求资源未找到|
|500|内部服务器错误|  


## 4.ajax的异步和同步
ajax.open(method,urL,async)  
async：设置同步代码执行还是异步代码执行，true代表异步，默认是异步，false代表同步。

## 5.请求方式
### （1）get请求
get的请求实体拼接在URL后面，？隔开，键值对  
ajax.open("get","url");  
ajax.send(null);
### （2）post请求
有单独的请求实体  
ajax.open("post", "url");  
ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");  
ajax.send("name=张三&pwd=123");  

## 6.相应数据格式


