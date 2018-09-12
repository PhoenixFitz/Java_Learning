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
- 表示类名的标识符：每个单词的首字母大写，如Man，GoodMan
- 表示方法和变量的标识符：第一个单词小写，从第二个单词开始首字母大写如eatFood（）
### （7）变量
**变量的本质**：代表一个“可操作的存储空间”，可通过访问变量名来操纵这个“存储空间”存储的值。
- 局部变量：生命周期从声明位置开始到方法或语句块执行完毕为止，**必须在使用前先声明、初始化再使用**。
- 成员变量：方法外部、类的内部定义的变量。从属于对象，生命周期伴随对象始终。若不初始化，它会自动初始化成该类型的默认初始值。  
- 静态变量：使用static定义，从属于类，生命周期伴随类始终，从类加载到卸载。如果不初始化，与成员变量相同会自动初始化成该类型的默认初始值。

数据类型|初始值
---|---
int|0
double|0.0
char|'\u0000'
boolean|false
