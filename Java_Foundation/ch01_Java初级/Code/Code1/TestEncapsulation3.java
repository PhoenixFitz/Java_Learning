/* 测试封装细节 */


public class TestEncapsulation3{
    // 属性一般使用private修饰
    private String name;
    private int age;
    private boolean flag;
    // 为属性提供public修饰的set/get方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isFlag() {// 注意：boolean类型的属性get方法是is开头的
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
/* 快捷建立set和get的方法： 右键选择“Source”，选择“Generate Getters and Setters” 就可以快速建立set和get方法了。 */