# JavaScript

## 1.概念
JavaScript是一种可以与HTML标记语言混合使用的脚本语言，其编写的程序可以直接在浏览器中解释执行。Javascript的国际标准是ECMAScript。

## 2.js的声明
### （1）在head标签中使用script标签进行js代码域的声明
```
<script type="text/javascript">
        alert("这是我第一个js")
    </script>
```  

作用：声明js代码域  
特点：js的代码只会作用域当前网页
### （2）在head标签中使用script标签引入外部声明好的js文件
`<script src="相对路径" type="text/javascript" charset="utf-8"></script>`  
作用：引入外部声明好的js文件  
特点：实现js代码的重复使用，避免代码的冗余。  
  
**注意**：因为js在HTML文档中是一门单独的语言，可以声明在文档中的任意位置，**一般情况下声明在head标签中**。

## 3.js的变量声明
格式： var 变量名=初始值；
### （1）js中的所有变量声明**只有var关键字**，可以存储任意类型的数据。
**注意**：
- js的变量名是**严格区分大小写**的。
- js中的字符串可以使用双引号也可以使用单引号。
- js中可以声明同名变量，不会报错，后面的会将前面的声明**覆盖**。(重要)
- js的代码可以不用分号结尾，但是为了提升代码的阅读性，建议使用分号。
### （2）js中的数据类型
数据类型判断关键字：**typeof**  
数据类型：
- number：数字类型
- string：字符串类型
- boolean
- object
- null：空对象赋值，主要是和undefined进行区分
- Undefined：undefined ，变量声明不赋值的情况下，默认值是undefined  

注意：在js代码中尽可能的给声明的变量赋初始值。

## 4.js的变量强转
### （1）其他类型转换为number类型
使用Number（）函数，将其他数据类型转换为数值类型，转换失败返回NaN（not a number）
- string 类型的数字字符:	对应的number数字
- string 非数字字符:		NaN(number类型)
- boolean true:		1
- boolean false:		0
- object 有具体的值:		数字
- object null:		0

### （2）其他类型转换为boolean 类型
使用Boolean（）函数，将其他数据类型转换为布尔类型，有值返回true，无值返回false
- number 正数或者负数：		true
- number 0		:		false
- string  非空字符串 :		true
- string  空字符串 "":		false
- object  具体的对象  :   	true
- object  null    :       false
- 声明不赋值的变量		:       false


## 5.js的运算符
### （1）算术运算符
加法：+ ；减法：- ；乘法：* ；除法：/ ；余数：%
- number类型的和number类型的
- number类型和boolean类型(true--1,false--0)
- number类型和string类型(*,/,%,-)
- string类型和string类型的数字(*,/,%,-)
- string类型数字和boolean类型(*,/,%,-)
- 在算术运算中如果两边的数据类型不是number的话，会使用Number()强转后在进行运算.  

**注意**：在字符串中“+”符合代表的是字符串的**连接符**，不会参与运算
            
### （2）逻辑运算符
!  ；& ；&& ；| ；|| (与java中的一致); 

### （3）关系运算符：返回值为true 或者fasle
!=  ；>=  ；<=  ；>  ；<
### （4）自增运算符：
++:a++ ++a  ；--； +=；  -=


## 6.特殊关系运算符
### （1）等值运算符:==
先判断类型，类型一致则直接比较；类型不一致，则先使用Number()进行强转后再进行比较。
### （2）等同运算符:===
先判断类型，类型一致则再比较内容，内容一致则返回true，内容不一致则返回false。类型不一致则直接false  
**注意**：null和undefined在做==判断时候返回true。

## 7.js的逻辑结构和循环结构
### （1）if结构
- 单分支结构：if(判断条件){执行体}
- 双分支：if(判断条件){执行体}else{执行体}
- 多分支：if(判断条件){执行体}else if(判断条件){执行体}……else{执行体}

### （2）swicth选择结构
```                
switch (a){
     case "1":
     alert("第一项选择");
     break;
     case "2":
     alert("第二项选择");
     break;
     default:
     alert("没有对应的选项");
     break;
           }
```  


**注意**：判断的变量可以是number类型也可以是string类型，但是不要混用。
### （3）循环结构
- for(变量;条件;迭代条件){循环体}循环
- while(循环条件){循环体}
- do{循环体}while(循环条件)

## 8.js的数组
### （1）数组的声明
- var arr=new Array();//声明一个空数组对象
- var arr=new Array(length)//声明一个指定长度的数组
- var arr=[元素]//声明数组(最常用);  

**注意**：js中的数组声明不用指定长度，js的数组长度是不固定的，会随着元素的数量改变而改变。

### （2）数组的赋值和取值
- 数组可以存储任意类型的数据。数组名[角标]=值;//角标可以是任意的正整数或者是0
- 数组的取出：数组名[角标]//返回当前角标对应存储的值。如果角标不存在，返回undefined;
            
### （3）数组的length属性
- 作用1：数组名.length//返回当前数组的长度。
- 作用2：数组名.length=新的值//动态的改变数组的长度  

注意：length>原有长度，则使用空进行填充；length<原有长度，则从后面进行截取，最后的数据会被删除。

### （4）数组的遍历
普通for循环：
```
for(var i=0;i<arr.length;i++){
      alert(arr[i]);
 }
```  

for-in：
```
for(var i in arr){
   alert(i);//获取的是角标
}
```  

## 9.数组的操作
- 数组的合并：arr.concat(b,c);//数组的合并
- 数组指定间隔符转换字符串:var b=arr.join("-");
- 数组移除最后一个元素并返回:var ele=arr.pop();
- 数组的追加，返回新的长度：var ln=arr.push("lol");//追加的元素可以是一个数组，但是会作为一个角标值存在
- 数组的移除第一个元素:var ele=arr.shift();
- 数组的在开始位置插入指定元素:var a=arr.unshift("又是周五了");
- 数组删除指定位置元素：var arr2=arr.splice(1,3,"a");arrayObj.splice(start,deleteCount,[item...])从一个数组中移除一个或多个元素，如果必要，在所移除元素的位置上插入新元素，返回所移除的元素

## 10.函数
作用:功能代码块的封装。减少代码的冗余。
### （1）函数的声明：
- 方式一:function 函数名(形参名1,形参名2……){执行体}
- 方式二:var 函数名=new Function("形参1","形参2"……,"函数执行体");**注意**：此声明表明在js中函数是作为对象存在的。
- 方式三:var 变量名=function(形参名1,形参名2……){函数执行体}
           
### （2）函数的参数
- js中的函数在调用时，形参可以不赋值，不会报错
- js中的函数在调用时，形参赋值可以不全部赋值，不会报错，但是实参会依次进行赋值。
### （3）函数的返回值
在js中如果函数有返回值则直接返回，没有返回值默认返回undefined。  
**注意**：js的代码声明区域和执行区域是一起的，都是在js代码的代码域中。

### （4）函数的执行符:
在js中函数的执行符值()，没有小括号则函数名其实就是一个变量；加上小括号则会函数会被执行。

### （5）函数作为实参传递
在js中函数是可以作为实参进行传递的。
```
function testobj(a){
    alert(a());
}
var testParam=function(){
     alert("我是函数参数");
}
testobj(testParam);
```  
## 11.自定义类
### （1）类的声明
```
function 类名(形参1，形参2……){
    this.属性名1=形参1;
    this.属性名2=形参2;
    ……
    this.属性名=fn
}
```  

### （2）类的使用
var 对象名=new 类名(实参1，实参2……);  
**注意**：js中类的内容只是对象的公共部分，每个对象还可以**自定义的进行扩充**。

### （3）类的“继承”
**prototype**关键字. 通过prototype关键字实现了不同对象之间的数据共享。`Person.prototype.test=function(){alert("嘿嘿")};`
- 作用1:实现某个类的所有子对象的方法区对象的共享，节省内存
- 作用2：实现链条结构，调用其他类对象，`User.prototype.student=new Student(); var p1 = new User(); p1.student.testS();`

## 12.自定义对象
对象的作用：用来存储整体数据。  
原因：很多时候我们没有办法预先知道一个对象应该有哪些属性，所以只能临时的创建一个对象来自定义属性存储数据。来保证数据的完成性。  
应用：Ajax中会使用。  
使用：
- 创建自定义对象  
```
var 对象名=new Object();
 对象名.属性名1=属性值1;
对象名.属性名2=属性值2;
对象名.属性名3=属性值3;
……
                    
var 对象名={};
对象名.属性名1=属性值1;
对象名.属性名2=属性值2;
对象名.属性名3=属性值3;
……
```  

- 一般用来存储数据，不会再自定义对象中存储函数对象。
- js中的对象属性和内容是可以自定义的扩充的，不是依赖于类的声明的，类只是对象公共部分的一种声明，是为了节省代码的冗余的。	

## 13.事件机制
解释：当我们的行为动作满足了一定的条件后，会触发某类事务的执行。  
作用：主要是结合js的函数来使用。  
### （1)单双击事件
- 单击：onclick    		当鼠标单击的时候会触发
- 双击：ondblclick		当鼠标双击的时候会被触发
### （2）鼠标事件
- onmouseover			当鼠标悬停在某个HTML元素上的时候触发
- onmousemove			当鼠标在某个HTML元素上移动的时候触发
- onmouseout			当鼠标在某个HTML元素上移出的时候触发
### （3）键盘事件
- onkeyup			当键盘在某个HTML元素上弹起的时候触发
- onkeydown			当键盘在某个HTML元素上下压的时候触发
### （4）焦点事件
- onfocus			当某个HTML元素获取焦点的时候触发
- onblur			当某个HTML元素失去焦点的时候触发
### （5）页面加载事件
onload				当页面加载成功后触发。  

**注意**:js中添加事件的第一种方式：在HTML上直接使用事件属性进行添加，属性值为所监听执行的函数。**js中的事件只有在当前HTML元素上有效**。一个HTML元素可以添加**多个不同的事件**。一个事件可以监听触发多个函数的执行,但是不同的函数要使用**分号**间隔。

### （6）给合适的HTML标签添加合适的事件
- onchange----select下拉框
- onload------body标签
- 单双击-------用户会进行点击动作的HTML元素
- 鼠标事件------用户会进行鼠标移动操作的。
- 键盘事件------用户会进行键盘操作的HTML元素。

### （7）给HTML元素添加多个事件时，注意事件之间的冲突
例子：单击和双击，当事件的触发条件包含相同部分的时候，会产生事件之间的冲突。
### （8）事件的阻断
当事件所监听的函数的将返回值返回给事件时：
- false：则会阻断当前事件所在的HTML标签的功能
- true:则继续执行当前事件所在的HTML标签的功能
### （9）超链接调用js函数
<a href="javascript:函数名()">调用js函数</a>		

## 14.window对象
BOM浏览器对象模型：是规范浏览器对js语言的支持(js调用浏览器本身的功能)。BOM的具体实现是window对象。  
window对象使用：window对象不用new，直接进行使用即可，类似Math的使用方式，window关键字可以省略不写。 
 
### （1）框体方法
- alert:警告框	提示一个警告信息，没有返回
- confirm:确认框  提示用户选择一项操作（确定/取消），点击确定 返回true；点击取消  返回false
- prompt:提示框， 提示用某个信息的录入或者说收集，点击确定，返回当前用书录入的数据，默认返回空字符串；点击取消,返回null。

### （2）定时和间隔执行方法
- setTimeout:指定的时间后执行指定的函数，参数1：函数对象，参数2：时间，单位毫秒，返回值：返回当前定时器的id。
- setInterval:每间隔指定的时间执行指定的函数，参数1：函数对象，参数2：时间，单位毫秒，返回值：返回当前间隔器的id。
- clearTimeout:用来停止指定的定时器，参数：定时器的id
- clearInterval:用来停止指定的间隔器，参数：间隔器的id

### （3）子窗口方法
window.open('子页面的资源(相对路径)','打卡方式','配置');
```
window.open('son.html','newwindow','height=400, width=600, top=100px,left=320px, toolbar=yes, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes');
```  
**注意**:关闭子页面的方法window.close(),但是此方法只能关闭open方法打开的子页面。
### （4）子页面调用父页面的函数
window.opener.父页面的函数


## 15.js的window对象的常用属性
### （1）地址栏属性:location
- window.location.href="新的资源路径（相对路径/URL）"
- window.location.reload()重新加载页面资源
### （2）历史记录属性
- window.history.forward() 页面资源前进，历史记录的前进。
- window.history.back()    页面资源后退，历史记录后退
- window.history.go(index) 跳转到指定的历史记录资源
- 注意**window.history.go(0)**相当于刷新。
### （3）屏幕属性
- window.srceen.width;//获取屏幕的宽度分辨率
- window.screen.height;//获取屏幕的高度分辨率
### （4）浏览器配置属性
主体面板属性(document)

## 16.document对象
概念：浏览器对外提供的支持js的用来操作HTML文档的一个对象，此对象封存的HTML文档的所有信息。  window.document.getElementByid(), window 可以省略不写。
获取HTML元素对象：
### （1）直接获取方式
- 通过id
- 通过name属性值
- 通过标签名
- 通过class属性值

### （2）间接获取方式
- 父子关系
- 子父关系
- 兄弟关系

## 17.js操作HTML元素属性
获取元素对象，操作元素属性。
### （1）获取
- 固有方式：元素对象名.属性名//返回当前属性的属性值。
- 自定义：元素对象名.getAttribute("属性名");//返回自定义属性的值
### （2）修改
- 元素对象名.属性名=属性值
- 元素对象名.setAttribute("属性名","属性值");//修改自定义属性的值----自定义  


**注意**：尽量的不要去修改元素的**id值和name属性值**。使用**自定义方式**获取固有属性内容，value的值获取的是**默认值**，**不能够获取到实时的用户数据**。

## 18.获取元素对象
### （1）获取
- 元素对象名.innerHTML//返回当前元素对象的所有内容，包括HTML标签
- 元素对象名.innerHTML//返回当前元素对象的文本内容，不包括HTML标签
### （2）修改
- 元素对象名.innerHTML="新的值"//会将原有内容覆盖，并HTML标签会被解析
- 元素对象名.innerHTML=元素对象名.innerHTML+"新的值"//追加效果
- 元素对象名.innerText="新的值"//会将原有内容覆盖，但HTML标签不会被解析，会作为普通文本显示。

## 19.js操作元素样式
获取元素对象
### （1）通过style属性
- 元素对象名.style.样式名="样式值"//添加或者修改
- 元素对象名.style.样式名=""//删除样式  


**注意**:以上操作，操作的是HTML的style属性声明中的样式。而不是其他css代码域中的样式。
### （2）通过className
- 元素对象名.className="新的值"//添加类选择器样式或者修改类选择器样式
- 元素对象名.className=""//删除类样式。

## 20.js操作元素的文档结构
增加节点，删除节点。
第一种方式：
```
div.innerHTML=div.innerHTML+"内容"//增加节点
div.innerHTML=""//删除所有子节点
父节点.removeChild(子节点对象)//删除指定的子节点。
```  
第二种方式：获取元素对象
```
var obj=document.createElement("标签名");
元素对象名.appendChild(obj);
```  

## 21.js操作form表单
### （1）获取form表单对象
- 使用id:var fm=document.getElementById("fm");
- 使用name属性:var frm=document.frm;

### （2）获取form下的所有表单元素对象集合
fm.elements  
### （3）form表单的常用方法
表单对象.submit();//提交表单数据。
### （4）form的属性操作
- 表单对象名.action="新的值"//动态的改变数据的提交路径。
- 表单对象名.method="新的值"//动态的改变提交方式
            
### （5）js表单元素的通用属性
- 只读模式:readonly="readonly"//不可以更改，但是数据可以提交
- 关闭模式：disabled="disabled"//不可以进行任何的操作，数据不会提交。

### （6）js操作多选框、单选框
被选中状态下在js中checked属性值为true,未选中状态为false;

### （7）js操作下拉框：
被选择的option对象在js中selected属性值为true，未选中为false

## 22.js校验form表单


