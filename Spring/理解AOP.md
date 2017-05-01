## AOP 为Aspect Oriented Programming的缩写，意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术

AOP的本质是在一系列纵向的控制流程中，把那些相同的子流程提取成一个横向的面，这句话应该好理解吧

![](http://img.blog.csdn.net/20140223215225406?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveWFucXVhbjM0NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)![](http://img.blog.csdn.net/20140223215240359?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveWFucXVhbjM0NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

我们把纵向流程画成一条直线，然把相同的部分以绿色突出，如下图左，而AOP相当于把相同的地方连一条横线(如上图)

## Spring是什么 ##
Spring是一个库，它的功能是提供了一个软件框架，这个框架目的是使软件之间的逻辑更加清晰，配置更灵活，实现这个目的的手段使用AOP和IoC，而AOP和IoC是一种思想

> http://blog.csdn.net/yanquan345/article/details/19760027
> https://my.oschina.net/lisn/blog/472994