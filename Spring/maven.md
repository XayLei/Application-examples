# 一、maven有什么用 #
### 1、下载jar包 ###
maven项目会有一个 pom.xml文件， 在这个文件里面，只要你添加相应配置，他就会自动帮你下载相应jar包，不用你铺天盖地的到处搜索你需要的jar包了

< groupId>org.springframework< /groupId> **项目名** 

< artifactId>spring-webmvc< /artifactId> **项目模块** 

< version>3.0.5.RELEASE< /version> **项目版本** 

maven都会通过，**项目名-项目模块-项目版本**来maven在互联网上的代码库中下载相应jar包

### 2、寻找依赖，下载依赖 ###
maven下载spring-core-2.6.jar包
 
而这个jar包里面需要用到commons-logging.jar这个包这叫就依赖

spring-core-2.6.jar依赖于commons-logging.jar
 
这就是maven第二个作用，帮你下载依赖包

### 3、热部署，热编译 ###
意思就是，web项目已经运行的时候，修改的代码能直接被web服务器所接受，不需要重启服务器，或者重新部署代码，而且你可以直接通过maven打包war或者jar项目。