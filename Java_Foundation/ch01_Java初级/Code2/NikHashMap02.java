package klaus.mycollection;

/**
 * 实现toString方法，方便查看Map中的键值对信息
 */
public class NikHashMap02 {

    Node2[] table;  //位桶数组，bucket array
    int size;//存放的键值对个数

    public NikHashMap02(){
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
        if(!keyRepeat) {
            size++;
        }
    }

    @Override
    public String toString() {
        //{10：aa，20：bb}
        StringBuilder sb =new StringBuilder("{");
        for(int i=0;i<table.length;i++){ //遍历bucket数组
            Node2 temp=table[i];
            //遍历链表
            while(temp!=null){
                sb.append(temp.key+":"+temp.value+",");
                temp=temp.next;
            }
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();

    }

    public  int myHash(int v, int length){
        System.out.println("hash in myHash"+(v&(length-1))); //直接位运算，效率更高
        System.out.println("hash in myHash"+(v%length));  //取模运算，效率低
        return v&(length-1);
    }

    public static void main(String[] args){
        NikHashMap02 m = new NikHashMap02();
        m.put(10, "aa");
        m.put(20, "bb");
        m.put(30, "cc");
        m.put(20, "klaus");
        m.put(36, "Fitz");
        m.put(52, "Snow");
        System.out.println(m);
    }
}
