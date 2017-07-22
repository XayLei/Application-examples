import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Ray:
 * @version 2017年7月22日 下午10:37:23 
 * 类说明 :通过串行化实现深克隆
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
	String name;// 常量对象
	int age;
	Teacher t;// 学生1和学生2的引用值都是一样的。

	public DeepCloneBySerialiable(String name, int age, Teacher t) {
		this.name = name;
		this.age = age;
		this.t = t;
	}

	/**
	虽然Java的序列化非常简单、强大，但是要用好，还有很多地方需要注意。比如曾经序列化了一个对象，
	可由于某种原因，该类做了一点点改动，然后重新被编译，那么这时反序列化刚才的对象，将会出现异常。
	*/
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// 从流里读出来
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
		// 学生1的老师不改变
		System.out.println("name=" + s1.t.name + "," + "age=" + s1.t.age);
	}
}