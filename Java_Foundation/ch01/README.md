# CH 01 Java基础
## 1.Java简介
### （1）Java三个版本
**JavaSE（Java Standard Edition）**：定义在个人计算机应用  
**JavaEE（Java Enterprise Edition）**：企业端，定位在服务器端的应用  
JavaME（Java Micro Edition）：定位在消费性电子产品应用
### （2）Java特性和优势
**跨平台/可移植性**，安全性，面向对象，分布式，多线程，健壮性
### （3）Java应用程序的运行机制
源文件（\*.java）→java编译器→字节码文件（\*.class）→类装载器→字节码校验器→解释器→系统平台
### （4）JDK、JRE和JVM的作用和区别
**JVM（Java Virtual Machine）**：虚拟计算机  
**JRE（Java Runtime Enviroment）**：包含Java虚拟机、库函数、运行Java应用程序所必须的文件  
**JDK（Java Development Kit）**：包含JRE，增加编译器和调试器等用于程序开发的文件
### （5）尝试编写第一个代码
- 使用记事本，编写代码
- 保存为Welcome.java（文件名必须为Welcome，大小写必须一致，即**文件名必须与类名一致**）
- 编译cmd（编译器创建class字节码文件），输入javac welcome.java
- 解释并运行，输入java Welcome  
[Welcome.java](Welcome.java)  
**所有代码必须位于类里面，一个源文件可包含多个类，但至多只能声明一个public类，且源文件名必须和其中定义的public类名相同**  
**main方法： public static void main（String[] args）{...}**  
eg.[桌球小游戏]（桌球小游戏）
### （6）标识符使用规范
- 表示**类名**的标识符：每个单词的首字母大写，如Man，GoodMan
- 表示**方法和变量**的标识符：第一个单词小写，从第二个单词开始首字母大写如eatFood（）
- 表示**常量**的标识符：大写字母和下划线，如MAX_VALUE
### （7）变量
**变量的本质**：代表一个“可操作的存储空间”，可通过访问变量名来操纵这个“存储空间”存储的值。

类型|声明位置|从属于|生命周期|初始化
---|---|---|---|---
局部变量|方法或语句块内部|方法/语句块|从生命位置开始，知道方法或语句块执行完毕，局部变量消失|必须在使用前先声明、初始化再使用
成员变量|类内部，方法外部|对象|对象创建，成员变量也跟着创建。对象消失，成员变量也跟着消失。|若不初始化，它会自动初始化成该类型的默认初始值。
静态变量|类内部，static修饰|类|类被加载，静态变量就有效；类被卸载，静态变量消失|若不初始化，它会自动初始化成该类型的默认初始值。

数据类型|初始值
---|---
int|0
double|0.0
char|'\u0000'
boolean|false

### （8）常量（constant）
通常指的是一个固定的值，在Java中，利用关键字**final**来定义一个常量。常量一旦被初始化后便不能再更改其值。
### （9）基本数据类型
#### 1）整型
类型|占用存储空间|表数范围
---|---|---
byte|1字节|-2^7 ～ 2^7-1
short|2字节|-2^15 ～ 2^15-1
int|4字节|-2^31 ～ 2^31-1
long|8字节|-2^63 ～ 2^63-1

进制类型|表示方法
---|---
八进制|以0开头
十六进制|以0x或0X开头
二进制|以0b或0B开头

**Java语言的整型常数默认为int型，声明long型常量可以在常量后加'L'。**
#### 2）浮点型
类型|占用存储空间
---|---
float|4字节
double|8字节

浮点型默认为double类型  
**浮点类型float，double的数据不适合在不容许舍入误差的金融计算领域，不能用于比较。如果需要进行不产生舍入误差的精确数字计算或比较，需要使用BigDecimal类。**  
java.math包下面的两个有用的类：BigInteger和BigDecimal，这两个类可以处理任意长度的数值。BigInteger实现了任意精度的整数运算。BigDecimal实现了任意精度的浮点运算。
[TestPrimitiveDataType.java](TestPrimitiveDataType.java)