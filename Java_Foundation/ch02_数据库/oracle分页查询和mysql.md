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
**ע��**��MySQL��û�����еģ��������ڴ������ʱ��ֱ��ָ�������ǵ����ģ��ڴ�������ֶκ�ʹ��**auto_increment**  
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

### ��8��Լ������Oracle����Լ�����ƣ�
#### 1������Լ��
�ڴ�����ʱ���ֶκ�ʹ�� primary key  
�������������� ʹ��constraint Լ���� primary key�������ֶ�����
#### 2���ǿ�Լ��
�ڴ�����ʱ���ֶκ�ʹ�� not null�� **ע��**��mysql�ķǿ�Լ���п��ַ��ǿ��Դ洢��ȥ�ģ�Oracle������  
�ڴ�������ɺ� ʹ��alter table ���� modify �ֶ��� ���� not null 
#### 3�����Լ��
���⣺��mysql����û�м��Լ��������ʹ��check�ؼ��ֲ��ᱨ��  
�����ʹ�ô����߼�������Ч���ݵĹ��ˣ����ã���ʹ��mysql�Ĵ洢����
#### 4��ΨһԼ��
�ֶ�����ʹ��unique
#### 5�����Լ��
�ֶ�����ֱ��ʹ�� references ���������ֶ�����  
��������constraint ���Լ���� foreign key(�ֶ���) references ���������ֶ�����  
�ڴ�����֮�� alter table ���� add  constraint ���Լ���� foreign key (�ֶ���) references ���������ֶ����� on delete set null on update cascade;

### ��9������޸�ɾ��
#### 1������ֶ�
alter table ���� add �ֶ��� ����
#### 2��ɾ���ֶ�
alter table ���� drop �ֶ���
#### 3���޸��ֶ�����
alter table ���� modify �ֶ��� �ֶ�����
#### 4���޸��ֶ���
alter table ���� change �ֶ��� ���ֶ��� ����
#### 5���޸ı���
alter table ���� rename as �±���
#### 6��ɾ����
drop table ����

### ��10����������
- ��ʾ����Ϣ show tables
- ��ʾ��������� ���� create table ����
- ��ʾ�� show databases

### ��11�����ݲ���
#### 1����ѯ
�����ѯ��
- ������ֱ�ӿո��ں���ʹ��
- ȥ���ظ��� distinct�ؼ���
- ���ӷ���ʹ��concat���ֶ������ֶ�����
- where�Ӿ䣺��oracleһ��  
- ������max,min,avg,sum,count
- ���飺group by �ؼ��� ��**ע��**������Ժ��ֶ�һ��ʹ��
- having �������ɸѡ
- ���� order by �ֶ���  
 
����ѯ��SQL92��SQL99:��oracleһ����
#### 2������
insert into ���� values��ֵ1��ֵ2��ֵ3....����ȫ�ֶβ���
insert into �����������ֶ������ֶ������ֶ���....�� values��ֵ1��ֵ2��ֵ3....���� �����ֶβ���
#### 3��ɾ��
delete from ���� where ����
#### 4���޸�
update ���� set �ֶ���= ֵ�� �ֶ���=ֵ....where ����

### ��12����ҳ
MySQL��ҳ��Ҫʹ��** limit **�ؼ���, limit ����Ҫ����������, ��һ�����ֱ�ʾ��ѯ����ʼλ��, �ڶ������ֱ�ʾ��
ѯ�ļ�¼��. limit Ҫд�� order by ֮��.
- ��ǰҳ��page�� ÿҳ��ʾ�ļ�¼��size��select * from clazz limit (page-1)*size, size;

### ��13�����ݱ���
���ʽ��
- ������mysqldump -u root -p ���ݿ��� > dbname.sql�������⣩��mysqldump -u root -p ���ݿ��� ����> dbname.sql��ֻ����һ����
- ���룺mysql>source d:\dbname.sql�� ����mysql -u root -p ���ݿ��� < dbname.sql  
���߷�ʽ��
- ������ֱ���ڿ����Ҽ�ѡ�񵼳����ݿ�
- ���룺�ڿ����Ҽ�ѡ�������ݿ�
