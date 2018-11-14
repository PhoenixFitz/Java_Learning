

/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加数组扩容
 */
public class SxtArrayList02<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY= 10;

    public SxtArrayList02(){
        elementData = new Object[DEFALT_CAPACITY];

    }
    public SxtArrayList02(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        //扩容操作
        if(size==elementData.length){
            Object[] newArray =new Object[elementData.length+(elementData.length>>1)];  //原容量加上原容量的一半
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);//将原数组的元素拷贝到新数组里
            elementData = newArray;
        }

        elementData[size++]=element;
    }

    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();
        //[a,b,c]
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

     public static void main(String[] args){
        SxtArrayList02 s1 = new SxtArrayList02(30);
        s1.add("aa");
        s1.add("bb");

        for(int j=0;j<40;j++){
            s1.add("Klaus0"+j);
        }

         System.out.println(s1);


     }

}
