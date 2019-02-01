public class TestStringEquals {
    public static void main(String[] args) {
        String g1 = "北京尚学堂";
        String g2 = "北京尚学堂";
        String g3 = new String("北京尚学堂");
        System.out.println(g1 == g2); // true  指向同样的字符串常量对象
        System.out.println(g1 == g3); // false  g3是新创建的对象
        System.out.println(g1.equals(g3)); // true  g1和g3里面的字符串内容是一样的
    }
}