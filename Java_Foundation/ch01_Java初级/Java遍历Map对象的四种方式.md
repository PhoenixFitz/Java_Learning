# Java����Map��������ַ�ʽ

## ��ʽһ ��������Ĳ����ڴ���������Ҳ�����ȡ�ı�����ʽ���ڼ�ֵ����Ҫʱʹ�á�
```
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
}
```
## ������ ��for-eachѭ���б���keys��values��

���ֻ��Ҫmap�еļ�����ֵ������ͨ��keySet��values��ʵ�ֱ�������������entrySet��
```
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
//����map�еļ� 
for (Integer key : map.keySet()) { 
  System.out.println("Key = " + key); 
} 
//����map�е�ֵ 
for (Integer value : map.values()) { 
  System.out.println("Value = " + value); 
}
```
�÷�����entrySet�������������Ժã�����10%�������Ҵ�����Ӹɾ���

## ������ʹ��Iterator����

ʹ�÷��ͣ�
```
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); 
while (entries.hasNext()) { 
  Map.Entry<Integer, Integer> entry = entries.next(); 
  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
}
```
��ʹ�÷��ͣ�
```
Map map = new HashMap(); 
Iterator entries = map.entrySet().iterator(); 
while (entries.hasNext()) { 
  Map.Entry entry = (Map.Entry) entries.next(); 
  Integer key = (Integer)entry.getKey(); 
  Integer value = (Integer)entry.getValue(); 
  System.out.println("Key = " + key + ", Value = " + value); 
}
```
��Ҳ������keySet��values��Ӧ��ͬ���ķ�����

���ַ�ʽ����������ȴ�����ŵ����ڡ����ȣ����ϰ汾java������Ωһ����map�ķ�ʽ����һ���ô��ǣ�������ڱ���ʱ����iterator.remove()��ɾ��entries���������������ܡ�����javadoc��˵���������for-each�����г���ʹ�ô˷���������ǲ���Ԥ��ġ�

�����ܷ��濴���÷�����ͬ��for-each���������������������ܡ�

## �����ġ�ͨ������ֵ������Ч�ʵͣ�
```
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
for (Integer key : map.keySet()) { 
  Integer value = map.get(key); 
  System.out.println("Key = " + key + ", Value = " + value);
```
��Ϊ����һ�������������뿴��ȥ���Ӹɾ�����ʵ�������൱������Ч�ʡ���Ϊ�Ӽ�ȡֵ�Ǻ�ʱ�Ĳ������뷽��һ��ȣ��ڲ�ͬ��Mapʵ���и÷�������20%~200%��������㰲װ��FindBugs������������鲢�����������Щ�ǵ�Ч�ʵı��������Ծ�������ʹ�á�

�ܽ�

�������Ҫ��(keys)��ֵ(values)ʹ�÷������������ʹ�õ����԰汾����java 5�����Ǵ����ڱ���ʱɾ��entries������ʹ�÷�����������ʹ�÷���һ(��ֵ��Ҫ)��

 

ת�أ�http://www.jb51.net/article/74089.htm