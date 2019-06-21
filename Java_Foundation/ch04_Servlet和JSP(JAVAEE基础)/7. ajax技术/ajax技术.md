#ajax����

## 1.��������
AJAXȫ��Ϊ��Asynchronous JavaScript and XML�����첽JavaScript��XML������һ�ִ�������ʽ��ҳӦ�õ���ҳ����������**�����ڵ�ǰҳ������Ӧ��ͬ����������**��Ajax��������һ��������˵ļ�����  
**����**��ʵ����**��ǰ���ҳ**����ʾ�����������Ӧ���ݡ�  

�����¼��ּ��������Ӧ�ã�
- ����web��׼��standards-based presentation��XHTML+CSS�ı�ʾ��
- ʹ�� DOM��Document Object Model�����ж�̬��ʾ��������
- ʹ�� XML �� XSLT �������ݽ�������ز�����
- ʹ�� XMLHttpRequest �����첽���ݲ�ѯ��������
- ʹ�� JavaScript �����еĶ�������һ��  

### ��1��ԭ��
������ajax��������ͣ���Ӧ���ݣ����������ֱ�ӽ��д���������ת���������ajax��������������ǿ���ͨ������ajax�����������ʵ����ҳ������ʾ�µ���Ӧ��Դ��

### ��2������
js��DOM�����е������ɳ���Ա�Լ�д����������ɴӷ�������̬�Ļ�ȡ��

## 2.ajaxʹ������
```
//����ajax�������
	//��дonreadystatement����
		//�ж�ajax״̬��
			//�ж���Ӧ״̬��
				//��ȡ��Ӧ����(��Ӧ���ݵĸ�ʽ)
					//��ͨ�ַ�����responseText
					//json(�ص�)��responseText
					��ʵ���ǽ������ݰ���json�ĸ�ʽƴ�Ӻõ��ַ���������ʹ��eval����
					�����ܵ��ַ�������ֱ��ת��Ϊjs�Ķ���
									
					json��ʽ��
					var ������={
																		������:����ֵ,
																		������:����ֵ,
																		����
					}
									
					//XML���ݣ�responseXML.����document����
					ͨ��document�������ݴ�xml�л�ȡ����
				//������Ӧ����(js�����ĵ��ṹ)
		//��������
			//get����
				get������ʵ��ƴ����URL���棬����������ֵ��
				ajax.open("get","url");
				ajax.send(null);
			//post����
				�е���������ʵ��
				ajax.open("post", "url");
				ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				ajax.send("name=����&pwd=123");
```  

## 3.ajax��״̬���http״̬��
|readyStateֵ|����|
|:---:|:---:|
|0|��ʾXMLHttpRequest�ѽ���������δ��ʼ������ʱ��δ����open����|
|1|��ʾopen�����Ѿ����ã���δ����send�������Ѵ�����δ���ͣ�|
|2|��ʾsend�����Ѿ����ã���������δ֪|
|3|��ʾ�����Ѿ��ɹ����ͣ����ڽ�������|
|4|��ʾ�����Ѿ��ɹ����ա�|  


|http״̬�루state��|����|
|:---:|:---:|
|200|����ɹ�|
|404|������Դδ�ҵ�|
|500|�ڲ�����������|  


## 4.ajax���첽��ͬ��
ajax.open(method,urL,async)  
async������ͬ������ִ�л����첽����ִ�У�true�����첽��Ĭ�����첽��false����ͬ����

## 5.����ʽ
### ��1��get����
get������ʵ��ƴ����URL���棬����������ֵ��  
ajax.open("get","url");  
ajax.send(null);
### ��2��post����
�е���������ʵ��  
ajax.open("post", "url");  
ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");  
ajax.send("name=����&pwd=123");  

## 6.��Ӧ���ݸ�ʽ


