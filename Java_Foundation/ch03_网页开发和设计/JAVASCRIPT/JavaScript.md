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












