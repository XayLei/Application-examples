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