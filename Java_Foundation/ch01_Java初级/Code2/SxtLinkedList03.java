package klaus.mycollection;

/**
 * 增加remove
 */
public class SxtLinkedList03 {

    private Node first;
    private Node last;

    private int size;

    public void remove(int index){
        Node temp=getNode(index);   //找到需要删除的节点

        if(temp!=null){
            Node up=temp.previous;
            Node down = temp.next;
            if(up!=null){
                up.next=down;
            }
            if(down!=null) {
                down.previous=up;
            }
            if(index==0){   //被删除的元素是第一个时
                first=down;
            }
            if(index==size-1){  //被删除的元素是最后一个时
                last=up;
            }
            size--;
        }


    }

    public Node getNode(int index){
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合法："+index);
        }
        Node temp=null;
        if(index<(size>>1)) {  //size>>1相当于size除以2
            temp=first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else{
            temp=last;
            for(int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }
        return temp;
    }

    //["a","b","c","d","e","f"]
    public Object get(int index){
        Node temp=getNode(index);
        return  temp!=null?temp.element:null;
    }

    //[]
    //["a","b","c"]
    public void add(Object obj){
        Node node =new Node(obj);

        if(first==null){
          //  node.previous=null;
          //  node.next=null;
            first=node;
            last=node;
        }else{

            node.previous=last;
            node.next=null;
            last.next=node;
            last=node;
        }
        size++;
    }

    @Override
    public String toString() {
        //[a,b,c] first=a last=c
        StringBuilder sb=new StringBuilder("[");
        Node temp =first;
        while(temp!=null){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        SxtLinkedList03 list=new SxtLinkedList03();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list);
        System.out.println(list.get(5));
        list.remove(0);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
    }

}

