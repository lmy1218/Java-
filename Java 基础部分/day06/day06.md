## 三人行-Java基础复习第六天



[博客参考](https://blog.csdn.net/qq_42380734/article/details/105374670)

[菜鸟教程参考](https://www.runoob.com/java/java-exceptions.html?_t_t_t=0.5519165988080204)

### 0. 今日目标



> **设计原则**

- ·不要将异常处理用于正常的控制流程
- 可以恢复的情况使用受检异常，对编译错误使用运行时异常
- 避免不必要的异常使用
- 优先使用标准异常
- 每个声明（抛出）的异常，尽量要有文档
- 不要在catch中忽略掉捕获的异常
- 保持异常的原子性，异常发生后对象能恢复到发生之前的状态
- 避免过大的try块
- 不要使用catch（Exception e）捕获所有的异常，异常要有针对性



> **熟悉异常分类**

- Throwable
  - Error
  - Exception
- 自定义**异常**



> **掌握异常中关键字**

- try
- catch
- finally
- throw
- throws



> **Java 7新特性**

- TWR(Try-With-Resource)

- catch(Exception A | Exception B)

  