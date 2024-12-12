# 蓝兔支付SDK测试工程

## 1.测试工程启动



1. 配置docs/natapp/文件夹下的文件 

- 配置.ini文件, 到natapp网站,复制自己的auth_token
- window电脑需要把natapp.exe启动文件,粘贴到natpp文件夹下

![image-20241212165942958](https://hahaha310.oss-cn-qingdao.aliyuncs.com/image-20241212165942958.png)

![image-20241212170229940](https://hahaha310.oss-cn-qingdao.aliyuncs.com/image-20241212170229940.png)

2. 启动Application类
   - @RestMapping() 也在启动类里(图方便)

3. 启动Test类

4. 观察Applicaiton类返回的接口

   ## 2. 项目解析

   在该SDK中是通过 Default工厂 返回一个 NativePayService 类

   然后调用 NativePayService. prePay()来实现

   注意: prePay方法里面是调用的payapi接口 来发送网络请求 ,不过已经被封装在依赖里面

   ![image-20241212171457216](https://hahaha310.oss-cn-qingdao.aliyuncs.com/image-20241212171457216.png)

   ## 3. 亮点

   通过config类来配置Bean类

   让我直接更好的理解了为什么之前要使用的很多第三方的依赖,要现在Configuration类里面先配置成各种Bean的形式,然后被调用

   原来这个就是SDK

   ```java
   @Configuration
   @EnableConfigurationProperties(类名.class)
   ```

   

   ![image-20241212172622093](https://hahaha310.oss-cn-qingdao.aliyuncs.com/image-20241212172622093.png)

   ![image-20241212172628624](C:/Users/yangz/AppData/Roaming/Typora/typora-user-images/image-20241212172628624.png)

   