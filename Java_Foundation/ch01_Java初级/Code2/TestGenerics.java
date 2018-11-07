
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGenerics {

    public static void main(String[] args) {
        //泛型E像一个占位符一样表示“未知的某个数据类型”，在真正调用的时候传入这个“数据类型”。
        // 这里的”String”就是实际传入的数据类型；
        MyCollection<String> mc = new MyCollection<String>();
        mc.set("aaa", 0);
        mc.set("bbb", 1);
        String str = mc.get(1); //加了泛型，直接返回String类型，不用强制转换;
        System.out.println(str);

        List list =new ArrayList();
        Map map= new HashMap();

    }



}

class MyCollection<E> {// E:表示泛型;
    Object[] objs = new Object[5];

    public E get(int index) {// E:表示泛型;
        return (E) objs[index];
    }
    public void set(E e, int index) {// E:表示泛型;
        objs[index] = e;
    }
}