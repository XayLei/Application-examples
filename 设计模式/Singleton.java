//����ʽ����

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
    private Single1() {}    //�ٽ�һ�����ѹ�������Ϊ˽�еģ������ܹ���ֹ���ⲿ������á�
    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }
}