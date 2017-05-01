## IoC 容器 ##
 Spring IoC 容器利用 Java 的 POJO 类和配置元数据来生成完全配置和可执行的系统或应用程序
![](http://wiki.jikexueyuan.com/project/spring/images/ioc1.jpg)

Spring 提供了以下两种不同类型的容器:

1. Spring **BeanFactory** 容器 (不推荐使用)，XmlBeanFactory类已经被弃用

2. Spring **ApplicationContext** 容器  （推荐使用）

最常被使用的 ApplicationContext 接口实现：

1. **FileSystemXmlApplicationContext**：该容器从 XML 文件中加载已被定义的 bean。在这里，你**需要提供给构造器 XML 文件的完整路径**
1. **ClassPathXmlApplicationContext**：该容器从 XML 文件中加载已被定义的 bean。在这里，你**不需要提供 XML 文件的完整路径**，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
1. **WebXmlApplicationContext**：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。

## 依赖注入 ##

假设你有一个包含文本编辑器组件的应用程序，并且你想要提供拼写检查。标准代码看起来是这样的：

    public class TextEditor {
      private SpellChecker spellChecker;  
      public TextEditor() {
         spellChecker = new SpellChecker();
      }
    }

在控制反转的场景中，我们反而会做这样的事情：

    public class TextEditor {
        private SpellChecker spellChecker;
        public TextEditor() {
           spellChecker = new SpellChecker();
        }
    }

### 依赖注入类型 ###

1. （Constructor-based）当容器调用带有多个参数的构造函数类时，实现基于构造函数的 DI，每个代表在其他类中的一个依赖关系
2. （Setter-based）基于 setter 方法的 DI 是通过在调用无参数的构造函数或无参数的静态工厂方法实例化 bean 之后容器调用 beans 的 setter 方法来实现的。

You can mix both, Constructor-based and Setter-based DI but it is a good rule of thumb to use constructor arguments for mandatory dependencies and setters for optional dependencies.

我的翻译：你可以混合使用这两种方法，基于构造函数和基于 setter 方法的 DI，但是在有强制性依赖关系时选用构造函数，在有可选择依赖时选用setter是一个比较明智的做法。