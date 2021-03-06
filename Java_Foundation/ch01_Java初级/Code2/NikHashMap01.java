package klaus.mycollection;

/**
 * 自定义一个HashMap,实现put方法增加键值对，并解决了键重复的时候覆盖相应的节点
 */
public class NikHashMap01 {

    Node2[] table;  //位桶数组，bucket array
    int size;//存放的键值对个数

    public NikHashMap01(){
        table= new Node2[16];  //长度一般定义为2的整数幂
    }

    public void put(Object key,Object value){
        Node2  newNode=new Node2();
        newNode.hash=myHash(key.hashCode(), table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;

        Node2 temp=table[newNode.hash];
        Node2 iterLast=null;  //保存前一个结点
        boolean keyRepeat=false;
        if(temp==null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash]=newNode;
            size++;
        }else{
            //此处数组元素不为空，则便利对应链表
            while(temp!=null){
                //判断key，如果重复，则覆盖，
                if(temp.key.equals(key)){
                    keyRepeat=true;
                    temp.value=value; //只覆盖value，其他值不变
                    break;
                }else {
                    //key不重复,则便利下一个
                    iterLast=temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat) {
                iterLast.next = newNode;
                size++;
            }
        }
    }

    public  int myHash(int v, int length){
        System.out.println("hash in myHash"+(v&(length-1))); //直接位运算，效率更高
        System.out.println("hash in myHash"+(v%length));  //取模运算，效率低
        return v&(length-1);
    }

    public static void main(String[] args){
        NikHashMap01 m = new NikHashMap01();
        m.put(10, "aa");
        m.put(20, "bb");
        m.put(30, "cc");
        m.put(20, "klaus");
        m.put(36, "Fitz");
        m.put(52, "Snow");
        System.out.println(m);
    }
}
