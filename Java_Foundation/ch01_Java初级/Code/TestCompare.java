package array;
import java.util.Arrays;
/**
 * 数组元素是引用类型的排序(Comparable接口的应用)
 * 如果是自己定义的类要排序的话，则需要用到Comparable接口
 * @author kl
 *
 */
public class TestCompare {
	    public static void main(String[] args) {
	        Man[] msMans = { new Man(3, "a"), new Man(60, "b"), new Man(2, "c") };
	        Arrays.sort(msMans);
	        System.out.println(Arrays.toString(msMans));
	    }
	}
	 
	class Man implements Comparable {
	    int age;
	    int id;
	    String name;
	 
	    public Man(int age, String name) {
	        super();
	        this.age = age;
	        this.name = name;
	    }
	 
	    public String toString() {
	        return this.name;
	    }
	 
	    public int compareTo(Object o) {
	        Man man = (Man) o;
	        if (this.age < man.age) {
	            return -1;
	        }
	        if (this.age > man.age) {
	            return 1;
	        }
	        return 0;
	    }
	}

