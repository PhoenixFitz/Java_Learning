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
- 编译（编译器船舰class字节码文件）
- 解释并运行
[](Welcome.java)