public class TestOverride {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Horse();
        Vehicle v3 = new Plane();
        v1.run();
        v2.run();
        v3.run();
        v2.stop();
        v3.stop();
    }
}
 
class Vehicle { // ��ͨ������
    public void run() {
        System.out.println("��....");
    }
    public void stop() {
        System.out.println("ֹͣ����");
    }
}
class Horse extends Vehicle { // ��Ҳ�ǽ�ͨ����
    public void run() { // ��д���෽��
        System.out.println("���㷭�ɣ��N�N�N...");
    }
}
 
class Plane extends Vehicle {
    public void run() { // ��д���෽��
        System.out.println("���Ϸɣ�");
    }
    public void stop() {
        System.out.println("���в���ͣ��׹���ˣ�");
    }
}  