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
