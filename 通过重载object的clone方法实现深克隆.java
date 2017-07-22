/**
 * @author Ray:
 * @version 2017年7月22日 下午9:51:35 类说明 :
 */
public class CloneTest implements Cloneable {// 实现这个接口
	private String name;

	private int age;

	Professor p;// 学生1和学生2的引用值都是一样的。

	CloneTest(String name, int age, Professor p) {
		this.name = name;
		this.age = age;
		this.p = p;
	}

	// 重载clone方法，object中的clone方法是protect的，这里范围public，其他类就能调用clone这个方法了
	// 继承自java.lang.Object类的clone()方法是浅复制
	public Object clone() {
		// CloneTest cloneObject = null;
		CloneTest deepClone = null;
		try {
			// Object中的clone()识别出你要复制的是哪一个对象。
			deepClone = (CloneTest) super.clone();
			// 对引用的对象也进行复制,这样就变成了深克隆
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
		// 修改学生2后，影响了学生1的值。
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