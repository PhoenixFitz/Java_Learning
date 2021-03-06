# jQuery
## 1.概念
jquery 全称 javaScript Query.是js的一个框架。本质上仍然是js，基本语法和js一致，将常用的js操作封装了起来。  

特点：
- 支持各种主流的浏览器。
- 使用特别简单
- 拥有便捷的插件扩展机制和丰富的插件

## 2.jQuery的封装原理
- js的全局代码区只有一个，这样就会造成同名变量的值会被覆盖。
- 使用对象封装，将代码封装到对象中.但是对象如果被覆盖，则全部失效，风险极高。
- 使用工厂模式,将代码进行封装，但是并没有解决问题
- 将封装的函数名字去除，避免覆盖。但是函数没有办法调用了。
- 匿名自调用，可以在页面加载的时候调用一次。但是不能重复调用，并且数据没有办法获取
- 使用闭包,将数据一次性挂载到window对象下

## 3.jquery的选择器
- 基本选择器：id选择器，标签选择器，类选择器，组合选择器
- 层级选择器
- 简单选择器
- 内容选择器
- 可见性选择器
- 属性选择器
- 子元素选择器
- 表单选择器

## 4.jQuery操作元素属性
### （1）获取
- 对象名.attr("属性名") //返回当前属性值
- 注意此种方式**不能获取value属性的实时数据**，使用对象名.val()进行获取。
            
### （2）修改
对象名.attr("属性名","属性值");

## 5.jQuery操作元素的内容
### （1）获取
- 对象名.html()//返回当前对象的所有内容，包括HTML标签。
- 对象名.text()//返回当前对象的文本内容，不包括HTML标签
### （2）修改
- 对象名.html("新的内容")//新的内容会将原有内容覆盖，HTML标签会被解析执行
- 对象名.text("新的内容")//新的内容会将原有内容覆盖，HTML标签不会被解析

## 6.jQuery操作元素的样式
### （1）使用css()
- 对象名.css("属性名")//返回当前属性的样式值
- 对象名.css("属性名","属性值")//增加、修改元素的样式
- 对象名.css({"样式名":"样式值","样式名":"样式值"……})//使用json传参，提升代码书写效率。
### （2）使用addClass()
- 对象名.addClass("类选则器名")//追加一个类样式
- 对象名.removeClass("类选择器 名")//删除一个指定的类样式

## 7.jQuery操作文档结构
### （1）内部插入
- append("内容")	 将指定的内容追加到对象的内部
- appendTo(元素对象或者选择器) 将制定的元素对象追加到指定的对象内容
- prepend() 将指定的内容追加到对象的内部的前面
- prependTo() 将制定的元素对象追加到指定的对象内容前面
### （2）外部插入
- after	，将指定的内容追加到指定的元素后面
- before，将指定的内容追加到指定的元素前面
- insertAfter，把所有匹配的元素插入到另一个、指定的元素元素集合的后面
- insertBefore  ，把所有匹配的元素插入到另一个、指定的元素元素集合的前面。
### （3）包裹
wrap()
### （4）替换
replaceWith()  , replaceAll()
### （5）删除
empty()

## 8.jQuery操作事件
- 元素对象.bind("事件名",fn)//动态的给指定的元素对象追加指定的事件及其监听的函数。 **注意**：js中的是一次添加，多次添加时**覆盖**的效果；jQuery是**追加**的效果，可以实现给**一个事件添加不同**的监听函数。
- 元素对象.unBind("事件名")//移除指定的元素对象的指定事件。 **注意**：js方式添加的事件不能移除。
- 元素对象.one("事件名",fn)//给指定的元素对象添加一次性事件，事件被**触发执行一次即失效**。 **注意**：可以给事件添加多个一次函数，unBind可以用来解绑
- 页面载入事件：$(document).ready(fn);页面载入成功后会调用传入的函数对象。 **注意**：此方式可以给页面载入动态的增加多个函数对象，不会被覆盖。

## 9.jQuery的动画效果







