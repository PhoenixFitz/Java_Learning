# JDBC
## 1.java���ݵĻ�ȡ��ʽ
- ֱ��������������ֵ
- Scanner�����̨����
- IO������Ӳ�̴洢�е����ݶ�ȡ��java�У�
- scoket+io
- �����ݿ��л�ȡ
## 2.JDBC�ĸ���
- ���⣺ java�����ݿ�֮��Ĺ�ͨ��һ��  
- ����� ���ݿ⳧�̶����ṩjava֧�ֵĽӿ�
- ʹ�ã� ������ʵ�ֽӿ�(�������ݿ�)�� ���ݿ⳧�̶����ṩ�����ݿ������������.(�����)
- ���ۣ� JDBC��ʵ�������ݳ��̶����ṩ���ܹ����Լ������ݽ��в�����������Ҳ����jar�ļ�.

## 3.JDBC�Ļ���ʹ�����̣���������eclipse�У�
### ��1������jar��:
����ojdbc6.jar,����Ŀ���Ҽ� builder path-->add to builder path.
### ��2����������
`Class.forName("oracle.jdbc.driver.OracleDriver");`  
���ã���ʼ������jdbc�ൽjava�����  
ע�⣺ojdbc6.jarʹ�ô˰��þ����ʡ�Բ�д��
### ��3����ȡ���ݿ����Ӷ���
`Connection conn =DriverMananger.getConnection("url","username","password");`  
���ã�  ���ӵ�ָ�������ݿⲢ�������Ӷ���.  
��������:
- url:��ʾҪ���ӵ����ݵ�ַ
- username:���ݿ���û���
- password:���ݿ������ 
### ��4������sql�������
`Statement stmt=conn.createStatement();  `
����:����,����SQL����
### ��5������sql����
`String sql="insert into dept values(92,'','')";`
### ��6��ִ��sql����
����sql����:`int i=stmt.executeUpdate(sql);`  
����ֵ:����ֵ���С��0,��ʾδִ�гɹ�;����ֵ�������0,��ʾ�ɹ��޸ĵ�������.
### ��7���ر���Դ  
```
stmt.close();
connection.close();
```  
[TestInsert01.java](code/JDBC01/src/insert/TestInsert01.java)  
[TestInsert02.java](code/JDBC01/src/insert/TestInsert02.java)  

### ��8�����¡�ɾ������
���£�ɾ�������̺������Ƚϳ���SQL��䲻ͬ����,�������һ�£�[TestUpdate.java](code/JDBC01/src/update/TestUpdate.java)  
[TestDel.java](code/JDBC01/src/delete/TestDel.java)

## 4.JDBC���������
����:һ���¼��������Ҫ�����Ӳ������������,ֻҪ��һ���Ӳ���ִ��ʧ��,�����ݻع���ԭʼ״̬,���ɹ����ύ����.  
ע��:JDBC�е��������Զ��ύ��.
����:�����ҵ��Ĵ��������,ĳ��Sql���ִ��ʧ��,���������Ѿ���������.  
���:����JDBC������Ϊ�ֶ��ύ��sql��䶼ִ�гɹ�����ͳһ�ύ,ֻҪ��ʧ�ܵľͻع�.
ʹ��:[TestTran.java](code/JDBC01/src/translation/TestTran.java)
```
conn.setAutoCommit(false)//����Ϊ�ֶ��ύ
ʹ��try catch����SQL����ִ�е��쳣����
try����ʹ��conn.commit() �ύ����
catch��ʹ��conn.rollback()�ع�����
```  
[UpdateName.java](code/JDBC01/src/practice/UpdateName.java)  
[StudentDaoImpl.java](code/JDBC01/src/daolmpl/StudentDaoImpl.java)  
[StudentDaoImpl2.java](code/JDBC01/src/daolmpl/StudentDaoImpl2.java)
## 5.��ѯ
JDBC�Ĳ�ѯ:
- ��������
- �������Ӷ���
- ����sql�������
- ����sql����
- ִ��sql����
- ���ش洢�˲�ѯ�������ݵĶ���(ResultSet)
- ResultSet�����ǻ���ָ��������ݴ洢��,����ö��.
- �ر���Դ  

����:��ѯ�ķ���ֵ������ResultSet,�ǻ���ָ�뾡�����ݴ洢��,���������ݵ�����ԵĻ�ȡ.  
���:������ת����ArrayList�н��д洢.  
ʹ��:�����ͱ�ṹ��ͬ��ʵ������е������ݵĴ洢(һ�����ݾ���һ��ʵ��������),������洢��ArrayList��.  
���ٻ�ȡ����ֵ:alt+shift+L  
[TestSelect.java](code/JDBC01/src/select/TestSelect.java)
[Student.java](code/JDBC01/src/pojo/Student.java)

## 6.SQLע��
```
String sql="select * from t_user where userno='"
+userno+"' and password='"+upwd+"'";
```  
��������������Ϊ String userno = "5 or 1 = 1";�ᵼ�����ݿ������쳣�����ݱ���գ� 

## 7.����Statement����������
Statement�������ڽ� SQL ��䷢�͵����ݿ��У��������Ϊִ��sql��䡣  
����Statement����
- Statement������ִ�в��������ļ�SQL��䣻
- PreparedStatement���� Statement �̳У�������ִ�д��򲻴�������Ԥ����SQL��䣬PreparedStatement�����Statement�����Ч�ʸ��ߣ�����**���Է�ֹSQLע�룬һ��ʹ��PreparedStatement**��
- CallableStatement����PreparedStatement �̳У�������**ִ�����ݿ�洢���̵ĵ���**��  

����|����
|:---:|:---:|
ResultSet executeQuery(String sql)|����ִ�в��롢ɾ�������µȲ���������ֵ��ִ�иò�����Ӱ�������
boolean execute(String sql) |����ִ������SQL��䣬Ȼ����һ������ֵ����ʾ�Ƿ񷵻�ResultSet
int executeUpdate(String sql) |ִ��SQL��ѯ����ȡ��ResultSet����  

## 8.preparedStatement�����������ɾ���޸Ĳ���
[JDBC02](code/JDBC02/src)




