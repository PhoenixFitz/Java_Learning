# EL和JSTL标签库

## 1.EL概述
全称：Expression Language，一种写法非常简介的表达式。语法简单易懂，便于使用。表达式语言的灵感来自于ECMAScript和XPath 表达式语言。  

作用：让jsp 书写起来更加的方便。简化在jsp 中获取作用域或者请求数据的写法。也会搭配Jstl 来进行使用。


## 2.传统方式获取作用域数据
- 缺点一:导入包
- 缺点二:需要强转
- 缺点三:获取数据的代码过于麻烦。

## 3.使用El表达式获取作用域数据
**注意**：获取的是pageContext、request、session、application**四个对象**中的数据，其他数据一概不理会。找到了则获取返回，找不到则什么都不做，也不报错。

## 4.EI表达式获取作用域数据的语法
${表达式}
表达式写法：
### （1）获取请求数据
request对象存储了请求数据--->param.键名	   	返回值  
request对象存储了请求数据--->paramvalues.键名 	返回的是数组。

### （2）通过setAttribute方法存储到作用域对象中的数据
${键名} 返回键名所对应的值。  
**注意**：如果存储的是普通字符串则直接返回；如果存储的是对象，则返回的是对象

### （3）获取对象中的数据：
普通对象：${键名.属性名.属性名....}  
集合对象：list集合--->${键名[角标]}  ， 集合--->${键名.map集合存储的键名}

## 5.作用域查找顺序：
默认查找顺序：pageConext-->request--->session--->application  
**注意**：每次查找都是从小到大进行查找，找到了则获取，不再继续找了。  
指定查找：${pageScope.键名}---${requestScope.键名}--${sessionScope.键名}--${applicationScope.键名}

## 6.El表达式的逻辑运算
${逻辑表达式}：&& || !  
${算术表达式}：+，-，*，/  
${关系表达式}：>,<,>=,==,!=,%  
特殊:三目运算  
**注意**：+表示加法运算，不表示字符链接。使用EL表达式进行字符链接会报错。  

## 7.EL的空值判断
${empty 键名}  
作用:判断键名对象的值是否存有数据。

## 8.EL获取请求头数据和Cookie数据（了解）
### （1）请求头数据
- ${header}-->返回所有的请求头数据
- ${header["键名"]}--->返回指定的键名的请求头数据
- ${hedaerValues["键名"]}--->返回指定的键名(同键不同值)的值的数组。
### （2）获取Cookie数据
- ${cookie}--->返回存储了所有的cookie对象的map集合
- ${cookie.键名}---->返回指定的cookie对象
- ${cookie.键名.name}--->返回指定的cookie对象存储的数据的键名。
- ${cookie.键名.value}--->返回指定的cookie对象存储的数据的值。

## 9.JSTL标签库概述
- 导入jar包
- 声明jstl标签库的引入(核心标签库)：<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
内容：
### （1）基本标签
`<c:out value="数据" default="默认值"></c:out>`  
数据可以为常量值也可以是EL表达式。  
作用：将数据输出给客户端。  

`<c:set var="hello" value="hello pageContext" scope="page"></c:set>`  
`作用：存储数据到作用域对象中  
- var：表示存储的键名
- value：表示存储的数据
- scope：表示要存储的作用域对象 page request session application  

`<c:remove var="hello" scope="page"/>`  
`作用：删除作用域中的指定键的数据。  
- var：表示要删除的键的名字
- scope：表示要删除的作用域（可选）  

**注意**：如果在不指定作用域的情况使用该标签删除数据，会将四个作用域对象中的符合要求的数据全部删除。

### （2）逻辑标签
`<c:if test="${表达式}">`  
前端代码  

`</c:if>`  
作用：进行逻辑判断，相当于java代码的单分支判断。  
注意：逻辑判断标签需要依赖于EL的逻辑运算，也就是表达式中涉及到的数据必须从作用域中获取。  
```
<c:choose>
	<c:when test="">执行内容</c:when>
	<c:when test="">执行内容</c:when>
	...
	<c:otherwise>执行内容</c:otherwise>
</c:choose>
```  

作用：用来进行多条件的逻辑判断，类似java中的多分支语句  
注意：条件成立只会执行一次，都不成立则执行otherwise

### （3）循环标签
```
<c:forEach begin="1" end="4" step="2">
	循环体
</c:forEach>
```  

作用：循环内容进行处理  
使用:
- begin:声明循环开始位置
- end:声明循环结束位置
- step：设置步长
- varStatus:声明变量记录每次循环的数据(角标，次数，是否是第一次循环，是否是最后一次循环)  

注意:数据存储在作用域中，需要使用EL表达式获取。例如：${vs.index}--${vs.count}--${vs.first}--${vs.last}	
- items:声明要遍历的对象。结合EL表达式获取对象
- var:声明变量记录每次循环的结果。存储在作用域中，需要使用EL表达式获取。	


## 10.JSTL标签库的作用

## 11.JSTL的核心标签库


学习网址：http://www.runoob.com/jsp/jsp-jstl.html
		












