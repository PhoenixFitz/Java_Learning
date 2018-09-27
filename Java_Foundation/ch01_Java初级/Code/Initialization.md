/*
  数组初始化举例

*/

// 静态初始化数组

int[] a = { 1, 2, 3 };// 静态初始化基本类型数组；  

Man[] mans = { new Man(1, 1), new Man(2, 2) };// 静态初始化引用类型数组；
  
  
  

//动态初始化数组  
int[] a1 = new int[2];//动态初始化数组，先分配空间；  
a1[0]=1;//给数组元素赋值；  
a1[1]=2;//给数组元素赋值；
  
  
//数组的默认初始化  
int a2[] = new int[2]; // 默认值：0,0  
boolean[] b = new boolean[2]; // 默认值：false,false  
String[] s = new String[2]; // 默认值：null, null
