## this
this�������һ�����󣬴���������������Ϊ��ָ��������һ��ָ�롣this���÷���java�д�����Է�Ϊ3�֣�
- ��ͨ��ֱ�����ã�this�൱����ָ��ǰ������
- �β����Ա������������this������
- ���ù��캯��

## super
super�������Ϊ��ָ���Լ���������������һ��ָ�룬���������ָ�������Լ������һ�����ࡣsuperҲ�������÷���
- ��ͨ��ֱ�����ã���this���ƣ�super�൱����ָ��ǰ����ĸ��࣬�����Ϳ�����super.xxx�����ø���ĳ�Ա��
- �����еĳ�Ա�����򷽷��븸���еĳ�Ա�����򷽷�ͬ��  
```
class Country {
    String name;
    void value() {
       name = "China";
    }
}
  
class City extends Country {
    String name;
    void value() {
    name = "Shanghai";
    super.value();      //���ø���ķ���
    System.out.println(name);
    System.out.println(super.name);
    }
  
    public static void main(String[] args) {
       City c=new City();
       c.value();
       }
}
```
- ���ù��캯��,super�������������ø����е�ĳһ�����캯��,this�������������ñ�������һ����ʽ�Ĺ��캯����  
```
class Person { 
    public static void prt(String s) { 
       System.out.println(s); 
    } 
   
    Person() { 
       prt("���ࡤ�޲������췽���� "+"A Person."); 
    }//���췽��(1) 
    
    Person(String name) { 
       prt("���ࡤ��һ�������Ĺ��췽���� "+"A person's name is " + name); 
    }//���췽��(2) 
} 
    
public class Chinese extends Person { 
    Chinese() { 
       super(); // ���ø��๹�췽����1�� 
       prt("���ࡤ���ø��ࡱ�޲������췽������ "+"A chinese coder."); 
    } 
    
    Chinese(String name) { 
       super(name);// ���ø��������ͬ�βεĹ��췽����2�� 
       prt("���ࡤ���ø��ࡱ��һ�������Ĺ��췽������ "+"his name is " + name); 
    } 
    
    Chinese(String name, int age) { 
       this(name);// ���þ�����ͬ�βεĹ��췽����3�� 
       prt("���ࣺ�������������ͬ�βεĹ��췽����his age is " + age); 
    } 
    
    public static void main(String[] args) { 
       Chinese cn = new Chinese(); 
       cn = new Chinese("codersai"); 
       cn = new Chinese("codersai", 18); 
    } 
}
```
  
## super��this����ͬ
- super�������������û����е�ĳһ�����캯����Ӧ��Ϊ���캯���еĵ�һ����䣩
- this�������������ñ�������һ���γɵĹ��캯����Ӧ��Ϊ���캯���еĵ�һ����䣩
- super:�������õ�ǰ�����ֱ�Ӹ����еĳ�Ա����������ֱ�Ӹ����б����صĸ����г�Ա���ݻ�����������������������ͬ��Ա����ʱ�磺super.������    super.��Ա����������ʵ�Σ�
- this��������ǰ���������ڳ������ײ���������֮����Ӧʹ��this��ָ����ǰ��������������β������еĳ�Ա����ͬ������ʱ����this��ָ����Ա��������
- ����super()����д�����๹�췽���ĵ�һ�У�������벻ͨ����ÿ�����๹�췽���ĵ�һ����䣬���������ص���super()���������û��������ʽ�Ĺ��캯������ô�ڱ����ʱ��ͻᱨ��
- super()��this()����,�����ǣ�super()�������е��ø���Ĺ��췽����this()��ͬһ���ڵ�������������
- super()��this()������ڹ��췽���ڵ�һ��
- ���ܿ�����this����һ������������ȴ���ܵ���������
- this��super����ͬʱ������һ�����캯�����棬��Ϊthis��Ȼ����������Ĺ��캯���������Ĺ��캯����ȻҲ����super���Ĵ��ڣ�������ͬһ�����캯����������ͬ����䣬��ʧȥ���������壬������Ҳ����ͨ����
- this()��super()��ָ���Ƕ������ԣ�����������static������ʹ�á�������static����,static������static���顣
- �ӱ����Ͻ���this��һ��ָ�򱾶����ָ��, Ȼ��super��һ��Java�ؼ��֡�
