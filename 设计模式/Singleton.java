/*
   1��ʲô�ǵ�����
      �������������뱣ֻ֤��һ��ʵ������
   2��������ʵ�ַ�ʽ�����֣�
      ��1������ʽ��ָȫ�ֵĵ���ʵ������װ��ʱ�͹���
	  ��2������ʽ��ָȫ�ֵĵ���ʵ���ڵ�һ�α�ʹ��ʱ����
*/

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

//synchronized�汾
// Version 2
public class Single2 {
    private static Single2 instance;
    private Single2() {}
	//�˰汾���������synchronized,�����Ϳ������ڶ��߳��У������������ܲ�̫��
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}

//˫�ؼ�飨Double-Check���汾
// Version 3
public class Single3 {
    private static Single3 instance;
    private Single3() {}
    public static Single3 getInstance() {
        //��һ��if (instance == null)����ʵ��Ϊ�˽��Version2�е�Ч�����⣬
		//ֻ��instanceΪnull��ʱ�򣬲Ž���synchronized�Ĵ���Ρ����������˼��ʡ�
		if (instance == null) {
            synchronized (Single3.class) {
				//�ڶ���if (instance == null)�����Ǹ�Version2һ������Ϊ�˷�ֹ���ܳ��ֶ��ʵ�������
                if (instance == null) {
                    instance = new Single3();
                }
            }
        }
        return instance;
    }
}

//�ռ��汾��volatile
// Version 4
public class Single4 {
	/*volatile�ؼ��ֵ�һ�������ǽ�ָֹ�����ţ�
	��instance����Ϊvolatile֮��
	������д�����ͻ���һ���ڴ����ϣ�ʲô���ڴ����ϣ���
	�����������ĸ�ֵ���֮ǰ���Ͳ��û���ö�����*/
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

//����ʽ����
public class SingleB {
	//�������ʱ�ʹ�����ʵ��
    private static final SingleB INSTANCE = new SingleB();
    private SingleB() {}
    public static SingleB getInstance() {
        return INSTANCE;
    }
}

// Effective Java ��һ���Ƽ�д��
//��������ClassLoader����֤��ͬ����ͬʱ�����ÿ����߿�������ص�ʱ����
//���ڲ�����һ������ʽ�ĵ��������Ǵ��ⲿ�������ֵ�ȷ������ʽ��ʵ�֡�
public class Singleton {
	/*
	�����ڲ���SingletonHolder������һ������ʽ�ĵ���ʵ�֣�
	��SingletonHolder��ʼ����ʱ�����ClassLoader����֤ͬ��
	ʹINSTANCE��һ���桤������
	*/
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
	
	/*
	����SingletonHolder��һ���ڲ��ֻ࣬���ⲿ���Singleton��getInstance()�б�ʹ��
	�����������ص�ʱ��Ҳ������getInstance()������һ�α����õ�ʱ��
	*/
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}