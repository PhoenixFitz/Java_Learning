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



## 2.Servlet����_ת�����ض���_Cookie
### ��1����������������
#### 1��ʹ��String�����������±���
uname=new String(uname.getBytes("iso8859-1"),"utf-8");
#### 2��ʹ�ù�������
- get��ʽ������һ��req.setCharacterEncoding("utf-8");���������tomcat��Ŀ¼�µ�confĿ¼���޸�server.xml�ļ�����Connector��ǩ���������� useBodyEncodingForURI="true"
- post��ʽ��req.setCharacterEncoding("utf-8");

### ��2��Servlet�����ܽ�
#### 1�� ������������󵽷�����(����)
#### 2�� ��������������������󣬽��н���������request����洢��������
#### 3�� ���������ö�Ӧ��servlet��������������request������Ϊʵ�δ��ݸ�servlet�ķ���
#### 4��servlet�ķ���ִ�н���������
- ������������ʽ
- ������Ӧ�����ʽ
- ��ȡ������Ϣ
- ����������Ϣ������ҵ�����󣬵���ҵ������ķ���
- ��Ӧ������

### ��3������ת��
����:ʵ�ֶ��servlet������������������������������࣬��servlet��ְ�������ȷ��  
ʹ�ã�
- req.getRequestDispatcher("Ҫת���ĵ�ַ").forward(req, resp);
- ��ַ�����·����ֱ����дservlet�ı������ɡ�  

�ص�:һ�������������ַ����Ϣ���ı䡣  
**ע��**������ת����ֱ��return�������ɡ�


### ��4��reuqet������
���ã������һ�������ڵĲ�ͬServlet ������(��������+��������)�������⡣  
ʹ�ã�
- request.setAttribute(object name,Object value);
- request.getAttribute(Object obj);  

�����򣺻�������ת����һ�������е�����Servlet ����  
**ע��**��ʹ��Request �������������ת������ֻ��һ����������Ч��  
�ص㣺������������ÿ�����󶼻ᴴ������������һ������

### ��5���ض���
����˱��ظ��ύ�����⣬�Լ���ǰservlet�޷��������������⡣  
ʹ�ã�resp.sendRedirect(String uri);  
ʾ��:resp.sendRedirect("/login/main");  
�ص㣺**��������**������request�����������ַ����Ϣ�ı䣬������ظ��ύ��  
ʹ��ʱ��������������б����ݣ��������ֱȽ���Ҫ�������ظ��ύ������ʹ���ض����������Servlet���պ��޷����д�������ʹ���ض���λ�����Դ������Դ��

### ��6��Cookie����
����:����˷��͵Ĳ�ͬ��������ݹ�������  
ʹ�ã�
- Cookie�Ĵ����ʹ洢
```
Cookie�Ĵ����ʹ洢
				//����Cookie����
					Cookie c=new Cookie(String name, String value);
				//����cookie(��ѡ)
					//������Ч��
					c.setMaxAge(int seconds);
					//������Ч·��
					c.setPath(String uri)
				//��ӦCookie��Ϣ���ͻ���
					resp.addCookie(c);
```  

- Cookie�Ļ�ȡ
```
//��ȡCookie��Ϣ����
			Cookie[] cks=req.getCookies();
			//���������ȡCookie��Ϣ
				//ʹ��forѭ���������ɣ�ʾ����
	 					if(cks!=null){
							for(Cookie c:cks){
								String name=c.getName();
								String value=c.getValue();
								System.out.println(name+":"+value);
							}
						}
```  

**ע��**��һ��Cookie����洢һ�����ݡ��������ݣ����Զഴ������Cookie������д洢��  
�ص㣺
- ������˵����ݴ洢������
- �洢�����������ڷ������ˣ�
- ��ʱ�洢:�洢��������������ڴ��У�������رռ�ʧЧ��
- ��ʱ�洢:������Cookie����Ч�ڣ��洢�ڿͻ��˵�**Ӳ��**�У�����Ч���ڷ���·��Ҫ������󶼻ḽ������Ϣ��
- Ĭ��cookie��Ϣ�洢��֮��ÿ�����󶼻ḽ��������������Ч·��

### ��7��Cookie��ϢУ��
- �ж��������Ƿ�Я����ȷ��Cookie��Ϣ
- �������У��Cookie��Ϣ�Ƿ���ȷ�����У����ȷ��ֱ����Ӧ��ҳ����û������У�鲻��ȷ����Ӧ��¼ҳ����û���
- û��������ת������¼ҳ��

## 3.Servlet����_session_Context����

### ��1��session���
ԭ���û���һ�η��ʷ��������������ᴴ��һ��session��������û���������session�����JSESSIONIDʹ��Cookie�����洢��������У���֤�û������������ܹ���ȡ��ͬһ��session����Ҳ��֤�˲�ͬ�����ܹ���ȡ����������ݡ�  
�ص㣺�洢�ڷ������ˣ����������д���������Cookie������һ�λỰ��Ĭ�ϴ洢ʱ����30���ӡ�  
���ã������һ���û���ͬ����������ݹ�������

### ��2��sessionʹ��
#### 1������session����/��ȡsession����
HttpSession hs=req.getSession();  
- ���������ӵ��session�ı�ʶ��Ҳ����JSESSIONID���򷵻����Ӧ��session����
- ���������û��session�ı�ʶ��Ҳ����JSESSIONID���򴴽��µ�session���󣬲�����JSESSIONID��Ϊ��cookie���ݴ洢��������ڴ���
- ���session������ʧЧ�ˣ�Ҳ�����´���һ��session���󣬲�����JSESSIONID�洢��������ڴ��С�  

**ע��**��JSESSIONID�洢����Cookie����ʱ�洢�ռ��У�������رռ�ʧЧ
#### 2������session�洢ʱ��
hs.setMaxInactiveInterval(int seconds);  
**ע��**����ָ����ʱ����session����û�б�ʹ�������٣����ʹ���������¼�ʱ��
#### 3������sessionǿ��ʧЧ
hs.invalidate();
#### 4���洢�ͻ�ȡ����
�洢��hs.setAttribute(String name,Object value);  
��ȡ��hs.getAttribute(String name) ���ص���������ΪObject  
**ע��**���洢�Ķ�����ȡ���Ķ��������ڲ�ͬ�������У����Ǵ洢Ҫ����ȡ��ִ�С�  
ʹ��ʱ��:һ���û��ڵ�½web��Ŀʱ�Ὣ�û��ĸ�����Ϣ�洢��Sesion�У������û�����������ʹ�á�  
#### 5��������
һ�λỰ����JSESSIONID��SESSION����ʧЧ�������Ϊ������Ŀ�ڡ�
#### 6��sessionʧЧ����
���û������е�JSESSIONID�ͺ�̨��ȡ����SESSION�����JSESSIONID���бȶԣ����һ�£���sessionû��ʧЧ�������һ����֤��sessionʧЧ�ˡ��ض��򵽵�¼ҳ�棬���û����µ�¼��
#### 7��С��
session�����һ���û��Ĳ�ͬ��������ݹ������⣬ֻҪ��JSESSIONID��ʧЧ��session����ʧЧ������¡��û������������ڴ���ʱ���ܻ�ȡ��ͬһ��session����

### ��3�������ҳ���û�����ʾΪnull������
ԭ����Ϊ���û���¼�ɹ���ʹ���ض�����ʾ��ҳ�棬�������󣬶��û�����Ϣ�ڵ�һ�������У��ڶ���������û���û����ݣ�������ʾΪnull��  
�����ʹ��session��

### ��4��ServletContext����
���ã�����˲�ͬ�û������ݹ������⡣  
ԭ��ServletContext �����ɷ��������д�����һ����Ŀֻ��һ�����󡣲�������Ŀ������λ�ý��л�ȡ�õ��Ķ���ͬһ��������ô��ͬ�û�����������ȡ����Ҳ����ͬһ�������ˣ��ö������û���ͬӵ�С�  
�ص㣺���������д������û�����һ����Ŀֻ��һ����  
������������Ŀ�ڡ�  
�������ڣ��������������������رա�  
#### 1����ȡServletContext����
- ��һ�ַ�ʽ ServletContext sc=this.getServletContext();
- �ڶ��ַ�ʽ ServletContext sc2=this.getServletConfig().getServletContext();
- �����ַ�ʽ ServletContext sc3=req.getSession().getServletContext();
#### 2��ʹ��ServletContext����������ݹ���
- ���ݴ洢sc.setAttribute(String name, Object value);
- ���ݻ�ȡsc.getAttribute("str") ���ص���Object����  

**ע��**����ͬ���û����Ը�ServletContext����������ݵĴ�ȡ����ȡ�����ݲ����ڷ���null��
#### 3����ȡ��Ŀ��web.xml�ļ��е�ȫ����������
- sc.getInitParameter(String name); ���ݼ������ַ���web.xml�����õ�ȫ�����ݵ�ֵ������String���͡�������ݲ����ڷ���null��
- sc.getInitParameterNames();���ؼ�����ö��
#### 4�����÷�ʽ
һ��<context-param>��ǩֻ�ܴ洢һ���ֵ�����ݣ��������������� <context-param>���д洢��
```
<context-param>
	<param-name>name</param-name>
	<param-value>zhangsan</param-value>
</context-param>
```  

���ã�����̬���ݺʹ�����н��
#### 5����ȡ��Ŀwebroot�µ���Դ�ľ���·����
String path=sc.getRealPath(String path);   ��ȡ��·��Ϊ��Ŀ��Ŀ¼��path����Ϊ��Ŀ��Ŀ¼�е�·����
#### 6����ȡwebroot�µ���Դ��������
InputStream is = sc.getResourceAsStream(String path);  
ע�⣺���ַ�ʽֻ�ܻ�ȡ��Ŀ��Ŀ¼�µ���Դ������class�ļ�����������Ҫʹ�����������ȡ��path����Ϊ��Ŀ��Ŀ¼�е�·����
#### 7��ʹ��ServletContext���������ҳ������
���û���¼У���д�����������������Ȼ��洢��ServletContext�����У�����ҳ����ȡ��������������ʾ���û����ɡ�

## 4.SerlvetConfig
���ã�ServletConfig ������Servlet ��ר�����ö���ÿ��Servlet ������ӵ��һ��ServletConfig ����������ȡweb.xml �е�������Ϣ��  
ʹ�ã���ȡServletConfig ���󣬻�ȡweb.xml ��servlet ��������Ϣ

## 5.С��
### ��1��Web.xml�ļ�ʹ���ܽ�
���ã��洢��Ŀ��ص�������Ϣ������Servlet������һЩ���ݶԳ����������  
ʹ��λ�ã�
- ÿ��Web ��Ŀ��
- Tomcat ��������(�ڷ�����Ŀ¼conf Ŀ¼��)  

����
- Web ��Ŀ�µ�web.xml �ļ�Ϊ�ֲ����ã���Ա���Ŀ��λ�á�
- Tomcat �µ�web.xml �ļ�Ϊȫ�����ã����ù�����Ϣ��  

����(�������)��
- ȫ������������(ȫ�����ò���)
- Servlet ����
- ����������
- ����������  

����˳��Web �����ᰴServletContext -> context-param -> listener -> filter -> servlet ���˳������������ЩԪ�ؿ�������web.xml�ļ��е�����λ�á�

### ��2��server.xml�ļ�
Server.xml �ļ����������
```
<Server>
<Service>
<Connector />
<Connector />
<Engine>
<Host>
<Context />
</Host>
</Engine>
</Service>
</Server>
```  
�Ȳ���<Context path ="/Pet" reloadable ="true" docBase ="F:/PetWeb" />
