public class TestForeach {
    public static void main(String[] args) {
        int[] a = new int[4];
        //初始化数组元素的值
        for(int i=0;i<a.length;i++){
            a[i] = 100*i;
        }
        //读取元素的值
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
	System.out.println("#########");
	for(int m:a){     //foreach循环，只用于读取数组元素的值，不能修改元素的值。
		System.out.println(m);
	}
	System.out.println("#########");
	String[] ss = { "aa", "bbb", "ccc", "ddd" };
        for (String temp : ss) {
            System.out.println(temp);
        }
    }
}