/*
   1、什么是单例？
      单例对象的类必须保证只有一个实例存在
   2、单例的实现方式有两种：
      （1）饿汉式：指全局的单例实例在类装载时就构建
	  （2）懒汉式：指全局的单例实例在第一次被使用时构建
*/

//懒汉式单例
// Version 1
public class Single1 {
    private static Single1 instance;
    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }
}

// Version 1.1
public class Single1 {
    private static Single1 instance;
    private Single1() {}    //再进一步，把构造器改为私有的，这样能够防止被外部的类调用。
    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }
}

//synchronized版本
// Version 2
public class Single2 {
    private static Single2 instance;
    private Single2() {}
	//此版本在这里加了synchronized,这样就可以用于多线程中，但这样的性能不太好
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}

//双重检查（Double-Check）版本
// Version 3
public class Single3 {
    private static Single3 instance;
    private Single3() {}
    public static Single3 getInstance() {
        //第一个if (instance == null)，其实是为了解决Version2中的效率问题，
		//只有instance为null的时候，才进入synchronized的代码段——大大减少了几率。
		if (instance == null) {
            synchronized (Single3.class) {
				//第二个if (instance == null)，则是跟Version2一样，是为了防止可能出现多个实例的情况
                if (instance == null) {
                    instance = new Single3();
                }
            }
        }
        return instance;
    }
}

//终极版本：volatile
// Version 4
public class Single4 {
	/*volatile关键字的一个作用是禁止指令重排，
	把instance声明为volatile之后，
	对它的写操作就会有一个内存屏障（什么是内存屏障？）
	这样，在它的赋值完成之前，就不用会调用读操作*/
    private static volatile Single4 instance;
    private Single4() {}
    public static Single4 getInstance() {
        if (instance == null) {
            synchronized (Single4.class) {
                if (instance == null) {
                    instance = new Single4();
                }
            }
        }
        return instance;
    }
}

//饿汉式单例
public class SingleB {
	//在类加载时就创建了实例
    private static final SingleB INSTANCE = new SingleB();
    private SingleB() {}
    public static SingleB getInstance() {
        return INSTANCE;
    }
}

// Effective Java 第一版推荐写法
//它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。
//从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现。
public class Singleton {
	/*
	对于内部类SingletonHolder，它是一个饿汉式的单例实现，
	在SingletonHolder初始化的时候会由ClassLoader来保证同步
	使INSTANCE是一个真·单例。
	*/
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
	
	/*
	由于SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用
	所以它被加载的时机也就是在getInstance()方法第一次被调用的时候
	*/
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}