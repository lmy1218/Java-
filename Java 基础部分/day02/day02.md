## 三人行-Java基础复习第二天



### 0. 今日目标



> **面向对象思想** [参考博客](https://blog.csdn.net/qq_42380734/article/details/105351623)



- 了解 类、对象、抽象类、接口、包等概念

类： 类是一个模版，它描述一类对象的行为和状态1

对象： 对象是类的一个实例，有状态和行为

抽象类：没有足够信息描述一个具体的对象，关键字使用Abstract

接口：所有的方法都是抽象类，支持多实现

包：避免重名、将类似或者相关的节后或类放在同一个包下，方便查找





- 面向对象的三大特征： 封装、继承、多态
  - 熟练继承语法和概念
  
    子类继承父类的属性和行为
  
    通过extends关键字来实现
  
    Java中只支持单继承
  
    
  
  - 掌握封装概念及其实现方式
  
  private 私有化属性
  
  提供getter和setter方法
  
  
  
  - 掌握多态：是什么？ 实现方式？ 优点、
  
  多态：同一个行为，具有不同的表现形式
  
  实现方式：重写、接口
  
  优点：
  
  - 消除类型之间的耦合性
  - 可替换性
  - 可扩充性
  - 灵活性
  - 简化性
  
  



- 熟练重写和重载的语法，以及它们之间的区别

  重写（覆盖）：发生在子类和父类之间

  重写的规则：

  - 方法名和参数列表必须相同
  - 返回类型必须相同，也可是子类型
  - 访问修饰符不能比父类的更低
  - final 和 static修饰的方法都不能重写，但static修饰的方法可以再次被声明
  - 子类只能重写服父类中有访问权限的方法
  - 重写方法可以抛出非强制性异常
  - 构造方法不能被重写
  - spuer关键字可以访问父类被重写的方法



​	重载： 在同一类中

​	重载规则：

- 方法名必须相同
- 参数列表必须不同
- 返回值可以不同，但不能成为区分重载的标准
- 可以改变修饰符
- 可以声明新的异常





- 了解深拷贝和浅拷贝及其区别

  **浅拷贝**：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝。

  **深拷贝**：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝。





- 了解方法四种类型






> **类加载** 



- 了解类加载过程

  - 加载

    将 .class文件加载到JVM中

    

  - 验证

    主要确保加载进来的字节流符合JVM规范

    - 文件格式校验
    - 元数据验证
    - 字节码验证
    - 字节码验证
    - 符号引用验证

  

  - 准备

    主要是给静态变量在方法区分配内存，并设置默认初始值

  - 解析

    将常量池中的符号引用替换成直接引用

  - 初始化

    对类成员进行初始化

  - 使用

  - 卸载

    

- 了解有哪些类加载器
  - 启动类加载器
  - 扩展类加载器
  - 应用程序类加载器



- 掌握双亲委派机制加载类的流程



> **对象创建** 



- 熟练掌握实例化内容及其顺序

子类实例化步骤：

- 先初始化父类

  - 执行父类中的静态属性
  - 执行父类中的静态代码块

- 初始化子类

  - 初始化子类静态属性
  - 执行子类静态代码块

- 父类实例化

  - 初始化实例变量
  - 执行非静态代码块
  - 执行父类构造器

- 子类实例化

  - 初始化子类实例变量
  - 执行子类非静态代码块
  - 执行子类构造器

  





- 了解实例化内容在内存中储存的位置，如何去分配内存 [参考博客](https://blog.csdn.net/smithdoudou88/article/details/42076787)

  ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE1LmNuYmxvZ3MuY29tL2Jsb2cvNTkyNzQzLzIwMTYwMy81OTI3NDMtMjAxNjAzMTkyMzU1NTUzMDMtNzY5NjU4MjE5LmpwZw?x-oss-process=image/format,png)



> **反射** [参考博客](https://blog.csdn.net/qq_42380734/article/details/105395719)



- 什么是反射？

  对任意一个类都能知道他的属性和方法，任意一个对象都能调用他的任意方法和属性

- 反射的原理

  在类加载时，反射获取class，然后进行各种操作

- 反射的相关操作
  - 获取类:  一个类在 JVM 中只会有一个 Class 实例

    对象的getClass()方法

    类.class

    Class.forName()

    

  - 获取类中的构造器

    调用getConstructors获取所有public构造器

    调用getDeclaredConstructors获取所有构造器

  - 获取类中的属性

    调用getDeclaredFields()方法，获取所有属性

  

  - 获取类中的构造器方法

    调用c.getMethods()获取所有方法



> **了解Object类中的常用方法**

​		getClass() 返回当前类运行时对象class

​		hashCode() 返回哈希码

​		equals 比较

​		clone() 克隆

​		toString() 默认返回类名和哈希码

​		notify() 唤醒一个在此对象上等待的线程

​		notityAll 唤醒在此对象上等待的所有线程

​		wait() 暂停线程并释放锁

​		finalize() 触发垃圾回收机制

### 1. 常见问题（以下问题要求能够口述出来）



> **面向对象和面向过程的区别**

答：

​	面向过程： 不存在初始化类、实例化对象，性能相对较高

​	面向对象： 易维护、易复用、易扩展



> **构造器是否可以被重写或覆盖？**

答： 构造器可以被重载，但不能被重写



> **你能想到的java中无参构造器的作用**

答：



>  **在调用子类构造方法之前会先调用父类没有参数的构造方法,其目的是?**

答：初始化父类，以帮助子类的初始化



> **接口和抽象类的区别是什么？**

答：

​	接口是抽象方法的集合	

​	抽象类可以有非抽象方法



> **你能想到的java中无参构造器的作用**

答：



> **符号引用和直接引用的区别**

答：



符号引用：

符号引用是一个字符串，它给出了被引用的内容的名字并且可能会包含一些其他关于这个被引用项的信息——这些信息必须足以唯一的识别一个类、字段、方法。这样，对于其他类的符号引用必须给出类的全名。对于其他类的字段，必须给出类名、字段名以及字段描述符。对于其他类的方法的引用必须给出类名、方法名以及方法的描述符。在Class文件中它以CONSTANT_Class_info、CONSTANT_Fieldref_info、CONSTANT_Methodref_info等类型的常量出现。

2.直接引用：

直接引用可以是
 （1）直接指向目标的指针（比如，指向“类型”【Class对象】、类变量、类方法的直接引用可能是指向方法区的指针）
 （2）相对偏移量（比如，指向实例变量、实例方法的直接引用都是偏移量）
 （3）一个能间接定位到目标的句柄
 直接引用是和虚拟机的布局相关的，同一个符号引用在不同的虚拟机实例上翻译出来的直接引用一般不会相同。如果有了直接引用，那引用的目标必定已经被加载入内存中了。

