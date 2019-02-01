public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符，结果为e
        System.out.println(s2.length());//字符串的长度，结果为9
        System.out.println(s1.equals(s2));//比较两个字符串是否相等，结果为false
        System.out.println(s1.equalsIgnoreCase(s2));//比较两个字符串（忽略大小写）结果为true
        System.out.println(s1.indexOf("Java"));//字符串s1中是否包含Java,从头开始查找子字符串"Java"在字符串中的索引位置，若未找到返回-1.结果为5。
        System.out.println(s1.indexOf("apple"));//字符串s1中是否包含apple，从头开始查找子字符串"apple"在字符串中的索引位置，若未找到返回-1.结果为-1.
        String s = s1.replace(' ', '&');//将s1中的空格替换成&
        System.out.println("result is :" + s); //结果为 result is ：core&Java
    }
}