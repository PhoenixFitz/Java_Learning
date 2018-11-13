

import java.util.ArrayList;
import java.util.List;

public class TestList02 {
    public static void main(String[] args){
        testindex();
    }


    public static void testindex(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        list.add(2, "Klaus");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2, "Niklaus");
        System.out.println(list);

        System.out.println(list.get(2));

        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);
        System.out.println(list.indexOf("B"));
        System.out.println(list.lastIndexOf("B"));



    }
}
