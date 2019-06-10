# Servlet��JSP

## 1.Servlet����_request��response����
### ��1��Servlet����������
- �ӵ�һ�ε��õ��������رա�
- ���Servlet��web.xml��������load-on-startup����������Ϊ�ӷ������������������رա�  

**ע��**��init�����Ƕ�Servlet���г�ʼ����һ������������Servlet��һ�μ��ؽ��д洢ʱִ�У�destory��������servlet������ʱִ�У�Ҳ�ͷ������ر�ʱ��

### ��2��Service������doGet������doPost����������
- Service���������Դ���get/post��ʽ���������servlet����Service�����������ȵ���service������������д���
- doGet����������get��ʽ������
- doPost����������post��ʽ������  

**ע��**������ڸ�д��service�����е����˸����service����(super.service(arg0, arg1)),��service����������󣬻��ٴθ�������ʽ��Ӧ��doGet��doPost����ִ�С����ԣ�һ��������ǲ��ڸ�д��service�е��ø����service�����ģ��������405����

### ��3��Servlet�ĳ�������
#### 1��404����:��Դδ�ҵ�
- ԭ��һ���������ַ�е�servlet�ı�����д����
- ԭ�����������Ŀ����ƴд����
#### 2��500�����ڲ�����������
- ����һ��java.lang.ClassNotFoundException: com.bjsxt.servlet.ServletMothod
���������web.xml��У��servlet���ȫ�޶�·���Ƿ�ƴд����
- ���������Ϊservice������Ĵ���ִ�д����¡���������ݴ�����ʾ��service�������еĴ�����д�����ġ�
#### 3��405����:����ʽ��֧��
ԭ������ʽ��servlet�еķ�����ƥ������ɵġ�  
���������ʹ��service�����������������Ҳ�Ҫ��service�����е��ø����service��

### ��4��request����
���ã�request�����з���˵�ǰ���������������Ϣ
#### 1����ȡ����ͷ����
- req.getMethod();//��ȡ����ʽ
- req.getRequestURL();//��ȡ����URL��Ϣ
- req.getRequestURI();//��ȡ����URI��Ϣ
- req.getScheme();//��ȡЭ��
#### 2����ȡ����������
- req.getHeader("����");//����ָ��������ͷ��Ϣ
- req.getHeaderNames();//��������ͷ�ļ�����ö�ټ���
#### 3����ȡ�û�����
- req.getParameter("����");//����ָ�����û�����
- req.getParameterValues("����");//����ͬ����ֵͬ����������(��ѡ)�����ص����顣
- req.getParameterNames()//���������û��������ݵ�ö�ټ��ϡ�  

**ע��**�����Ҫ��ȡ���������ݲ����ڣ����ᱨ������null��request������tomcat����������������Ϊʵ�δ��ݸ����������servlet��service������

### ��5��Respone����
���ã�������Ӧ���ݵ��������һ������
#### 1��������Ӧͷ
- setHeader(String name,String value);//����Ӧͷ�������Ӧ��Ϣ������ͬ���Ḳ��
- addHeader(String name,String value);//����Ӧͷ�������Ӧ��Ϣ�����ǲ��Ḳ�ǡ�
#### 2��������Ӧ״̬
sendError(int num,String msg);//�Զ�����Ӧ״̬�롣
#### 3��������Ӧʵ��
resp.getWrite().write(String str);//��Ӧ��������ݸ������
#### 4��������Ӧ�����ʽ��
resp.setContentType("text/html;charset=utf-8");

### ��6��service�������������
- ������Ӧ�����ʽ
- ��ȡ��������
- ������������
- ���ݿ������MVC˼�룩	
- ��Ӧ������

## 2.3.Servlet����_ת�����ض���_Cookie







