# oracle��ҳ��ѯ��mysql
## 1.oracle��ҳ��ѯ
���⣺��һ�����е��������ر���ʱ�����һ����ȫ����ʾ���û��������ҳ������Ӵ����鼫�  
�����ʹ�÷�ҳ��ѯ��  
ʹ�ã�rownum�ؼ��֣�oracle�����ṩ���Զ�����ѯ�����ŵĹؼ��֣���ÿ�е�����û�й�ϵ��**ע��**��rownum�ؼ���ֻ����< <=���жϣ����ܽ���> >=���жϡ�  
- ��ѯԱ����Ϣ��ǰ5������ ��һҳ���ݣ�select rownum r,e.* from emp e where rownum <=5; 
- ��ѯԱ����Ϣ��6-10������ �ڶ�ҳ���ݣ�select rownum r,e.* from emp e where rownum <=10;����ʾ10����Ϣ�� select rownum,t.* from (select rownum r,e.* from emp e where rownum <=10) t where r>5;����ʾ5����Ϣ��
- ��ѯԱ����Ϣ��11-15������ ����ҳ���ݣ�select rownum r,e. * from emp e where rownum<=15;��15���� select * from (select rownum r,e. * from emp e where rownum<=15) t where r>10;��5����  

**��ҳ�����ܽ�**��ÿҳ��ʾm�����ݣ���ѯ��nҳ���ݡ�
- select * from (select rownum r,e. * from Ҫ��ҳ�ı� e where rownum<=m*n) t where r>m*n-m;
- Ҫ��ҳ�ı�ȿ�������ʵ�ı�Ҳ������һ����ѯ��䡣  

������ҳ��ѯԱ����Ϣ���չ�������  
select * from (select rownum r,t.* from (select * from emp  order by sal) t where rownum<=10 ) where r>5

## 2.MySQL���ݿ�
����Դ�룬�����͵����ݿ����ϵͳ��
### ��1����װ
��װ��MySQL�󣬰�װnavicat�������ΪMySQL��ͼ�λ��������
### ��2��ж��
- ���������ж��MySQL
- ���̷��н�mysql�İ�װ�ļ���ɾ���� �磺C:\Program Files\mysql
- ��programData�����ļ����£�ɾ��mysql�ļ���
### ��3����������
���Ӳ������ݿ⣬����Ҫ�������£����ܴ������ݿ�
### ��4���������ݿ�
ʹ�����
- ������һ�����ݿ⣬ѡ��QUERY->NEW QUERY
- ��������create database ���� default character set utf8�� ##ע������
- �л����ݿ⵽�½��⣺ ues ����  

ʹ��ͼ�ν��棺����Ҽ�
### ��5��ɾ�����ݿ�
drop database

### ��6��������
��䣺 create table �������ֶ��� ���� Լ�����ֶ��� ���� Լ����������  
**ע��**��MySQL��û�����еģ��������ڴ������ʱ��ֱ��ָ�������ǵ����ģ��ڴ�������ֶκ�ʹ��auto_increment  
https://blog.csdn.net/a909301740/article/details/62887992

### ��7����������
#### 1�� ��ֵ����
- smallint, 2 �ֽ�
- int, 4 �ֽ� 
- Integer, int ��ͬ���
- bigint, 8 �ֽ�
- float, 4 �ֽ�
- double, 8 �ֽ�
#### 2���ַ�����
- char, ���ɱ䳤��
- varchar, �ɱ䳤��
#### 3������ʱ������
- date, yyyy-mm-dd
- datetime, yyyy-mm-dd hh:mi:ss  8 �ֽ�
- time, hh:mi:ss
- timestamp, ����ȷ��ʱ��  4 �ֽڣ��Զ�����ʱ����ת��
- year, yyyy
#### 4����������
- blob, ��Ŷ������ļ�
- text, ��Ŵ����ı���Ϣ

### ��8������޸�ɾ��
