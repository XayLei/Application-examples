import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Ray:
 * @version 2017��7��22�� ����10:37:23 
 * ��˵�� :ͨ�����л�ʵ�����¡
 */
class Teacher implements Serializable {
	String name;
	int age;

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class DeepCloneBySerialiable implements Serializable {
	String name;// ��������
	int age;
	Teacher t;// ѧ��1��ѧ��2������ֵ����һ���ġ�

	public DeepCloneBySerialiable(String name, int age, Teacher t) {
		this.name = name;
		this.age = age;
		this.t = t;
	}

	/**
	��ȻJava�����л��ǳ��򵥡�ǿ�󣬵���Ҫ�úã����кܶ�ط���Ҫע�⡣�����������л���һ������
	������ĳ��ԭ�򣬸�������һ���Ķ���Ȼ�����±����룬��ô��ʱ�����л��ղŵĶ��󣬽�������쳣��
	*/
	public Object deepClone() throws IOException, ClassNotFoundException {
		// ������д������
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// �����������
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Teacher t = new Teacher("tangliang", 30);
		DeepCloneBySerialiable s1 = new DeepCloneBySerialiable("zhangsan", 18, t);
		DeepCloneBySerialiable s2 = (DeepCloneBySerialiable) s1.deepClone();
		s2.t.name = "tony";
		s2.t.age = 40;
		// ѧ��1����ʦ���ı�
		System.out.println("name=" + s1.t.name + "," + "age=" + s1.t.age);
	}
}