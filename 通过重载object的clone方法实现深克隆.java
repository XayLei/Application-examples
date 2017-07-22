/**
 * @author Ray:
 * @version 2017��7��22�� ����9:51:35 ��˵�� :
 */
public class CloneTest implements Cloneable {// ʵ������ӿ�
	private String name;

	private int age;

	Professor p;// ѧ��1��ѧ��2������ֵ����һ���ġ�

	CloneTest(String name, int age, Professor p) {
		this.name = name;
		this.age = age;
		this.p = p;
	}

	// ����clone������object�е�clone������protect�ģ����ﷶΧpublic����������ܵ���clone���������
	// �̳���java.lang.Object���clone()������ǳ����
	public Object clone() {
		// CloneTest cloneObject = null;
		CloneTest deepClone = null;
		try {
			// Object�е�clone()ʶ�����Ҫ���Ƶ�����һ������
			deepClone = (CloneTest) super.clone();
			// �����õĶ���Ҳ���и���,�����ͱ�������¡
			deepClone.p = (Professor) p.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		return deepClone;
	}

	public static void main(String[] args) {
		Professor p = new Professor("mike", 50);
		CloneTest s1 = new CloneTest("zhangsan", 18, p);
		CloneTest s2 = (CloneTest) s1.clone();
		System.out.println("name=" + s2.name + "," + "age=" + s2.age);// name=zhangsan,age=18

		s2.p.name = "lisi";
		s2.p.age = 20;
		// �޸�ѧ��2��Ӱ����ѧ��1��ֵ��
		System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);// name=mike,age=50
		System.out.println("name=" + s2.p.name + "," + "age=" + s2.p.age);// name=lisi,age=20
	}
}

class Professor implements Cloneable {
	String name;
	int age;

	Professor(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Object clone() {
		Professor o = null;
		try {
			o = (Professor) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		return o;
	}
}