## 三人行-Java-Web复习-第四天





### 0. 今日目标



#### EL 表达式



> **什么是 EL 表达式， EL 表达式的作用?**
> EL 表达式的全称是： Expression Language。 是表达式语言。
> EL 表达式的什么作用： EL 表达式主要是代替 jsp 页面中的表达式脚本在 jsp 页面中进行数据的输出。
> 因为 EL 表达式在输出数据的时候， 要比 jsp 的表达式脚本要简洁很多。
>
> EL 表达式的格式是： ${表达式}
> EL 表达式在输出 null 值的时候， 输出的是空串。 jsp 表达式脚本输出 null 值的时候， 输出的是 null 字符串。
>
> **EL 表达式搜索域数据的顺序**
>
> EL 表达式主要是在 jsp 页面中输出数据。
> 主要是输出域对象中的数据。
> 当四个域中都有相同的 key 的数据的时候， EL 表达式会按照四个域的从小到大的顺序去进行搜索， 找到就输出。




```java

输出 Person： ${ p }<br/>
输出 Person 的 name 属性： ${p.name} <br>
输出 Person 的 pnones 数组属性值： ${p.phones[2]} <br>
输出 Person 的 cities 集合中的元素值： ${p.cities} <br>
输出 Person 的 List 集合中个别元素值： ${p.cities[2]} <br>
输出 Person 的 Map 集合: ${p.map} <br>
输出 Person 的 Map 集合中某个 key 的值: ${p.map.key3} <br>
输出 Person 的 age 属性： ${p.age} <br>

```



**EL 表达式——运算**  



语法： ${ 运算表达式 } ， EL 表达式支持如下运算符：
1） 关系运算

| 关系运算符 | 说 明    | 范 例                        | 结果  |
| ---------- | -------- | ---------------------------- | ----- |
| == 或 eq   | 等于     | ${ 5 == 5 } 或 ${ 5 eq 5 }   | true  |
| != 或 ne   | 不等于   | ${ 5 !=5 } 或 ${ 5 ne 5 }    | false |
| < 或 lt    | 小于     | ${ 3 < 5 } 或 ${ 3 lt 5 }    | true  |
| > 或 gt    | 大于     | ${ 2 > 10 } 或 ${ 2 gt 10 }  | false |
| <= 或 le   | 小于等于 | ${ 5 <= 12 } 或 ${ 5 le 12 } | true  |
| >= 或 ge   | 大于等于 | ${ 3 >= 5 } 或 ${ 3 ge 5 }   | false |


2） 逻辑运算

| 逻辑运算符 | 说 明    | 范 例                                                  | 结果  |
| ---------- | -------- | ------------------------------------------------------ | ----- |
| && 或 and  | 与运算   | ${ 12 == 12 && 12 < 11 } 或 ${ 12 == 12 and 12 < 11 }  | false |
| \|\| 或 or | 或运算   | ${ 12 == 12 \|\| 12 < 11 } 或 ${ 12 == 12 or 12 < 11 } | true  |
| ! 或 not   | 取反运算 | ${ !true } 或 ${not true }                             | false |


3） 算数运算

| 算数运算符 | 说 明 | 范 例 | 结果 |
| ---------- | ----- | ----- | ---- |
|            |       |       |      |

| +        | 加法 | ${ 12 + 18 }  | 30   |                 |      |
| -------- | ---- | ------------- | ---- | --------------- | ---- |
| -        | 减法 | ${ 18 - 8 }   | 10   |                 |      |
| *        | 乘法 | ${ 12 * 12 }  | 144  |                 |      |
| / 或 div | 除法 | ${ 144 / 12 } | 或   | ${ 144 div 12 } | 12   |
| % 或 mod | 取模 | ${ 144 % 10 } | 或   | ${ 144 mod 10 } | 4    |

4)  empty 运算

empty 运算可以判断一个数据是否为空， 如果为空， 则输出 true,不为空输出 false。
以下几种情况为空：
1、 值为 null 值的时候， 为空
2、 值为空串的时候， 为空
3、 值是 Object 类型数组， 长度为零的时候
4、 list 集合， 元素个数为零
5、 map 集合， 元素个数为零



#### JSTL 标签库  



> JSTL 标签库 全称是指 JSP Standard Tag Library JSP 标准标签库。 是一个不断完善的开放源代码的 JSP 标
> 签库。
> EL 表达式主要是为了替换 jsp 中的表达式脚本， 而标签库则是为了替换代码脚本。 这样使得整个 jsp 页面
> 变得更佳简洁。  

JSTL 由五个不同功能的标签库组成。

| 功能范围         | URI                                    | 前缀 |
| ---------------- | -------------------------------------- | ---- |
| 核心标签库--重点 | http://java.sun.com/jsp/jstl/core      | c    |
| 格式化           | http://java.sun.com/jsp/jstl/fmt       | fmt  |
| 函数             | http://java.sun.com/jsp/jstl/functions | fn   |
| 数据库(不使用)   | http://java.sun.com/jsp/jstl/sql       | sql  |
| XML(不使用)      | http://java.sun.com/jsp/jstl/xml       | x    |


在 jsp 标签库中使用 taglib 指令引入标签库



```jsp
CORE 标签库
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
XML 标签库<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
FMT 标签库
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
SQL 标签库
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
FUNCTIONS 标签库
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
```



> JSTL 标签库的使用步骤
> 1、 先导入 jstl 标签库的 jar 包。
> taglibs-standard-impl-1.2.1.jar
> taglibs-standard-spec-1.2.1.jar
> 2、 第二步， 使用 taglib 指令引入标签库。
>
> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
> g)core 核心库使用

-  <c:set />（使用很少）
  作用： set 标签可以往域中保存数据  

```jsp
<%--
i.<c:set />
作用： set 标签可以往域中保存数据
域对象.setAttribute(key,value);
scope 属性设置保存到哪个域
page 表示 PageContext 域（默认值）
request 表示 Request 域
session 表示 Session 域
application 表示 ServletContext 域
var 属性设置 key 是多少
value 属性设置值
--%>
保存之前： ${ sessionScope.abc } <br>
<c:set scope="session" var="abc" value="abcValue"/>
保存之后： ${ sessionScope.abc } <br>
```

- <c:if />  

  ```jsp
  <%--
  ii.<c:if />
  if 标签用来做 if 判断。
  test 属性表示判断的条件（使用 EL 表达式输出）
  --%>
  <c:if test="${ 12 == 12 }">
  <h1>12 等于 12</h1>
  </c:if>
  <c:if test="${ 12 != 12 }">
  <h1>12 不等于 12</h1>
  </c:if>
  ```

- \<c:choose> \<c:when> \<c:otherwise>标签  

  

```jsp
<%--
iii.<c:choose> <c:when> <c:otherwise>标签
作用： 多路判断。 跟 switch ... case .... default 非常接近
choose 标签开始选择判断
when 标签表示每一种判断情况
test 属性表示当前这种判断情况的值
otherwise 标签表示剩下的情况
<c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
1、 标签里不能使用 html 注释， 要使用 jsp 注释
2、 when 标签的父标签一定要是 choose 标签
--%>
<%
request.setAttribute("height", 180);
%>
<c:choose>
<%-- 这是 html 注释 --%>
<c:when test="${ requestScope.height > 190 }">
<h2>小巨人</h2>
</c:when>
<c:when test="${ requestScope.height > 180 }">
<h2>很高</h2>
</c:when>
<c:when test="${ requestScope.height > 170 }">
<h2>还可以</h2>
</c:when><c:otherwise>
<c:choose>
<c:when test="${requestScope.height > 160}">
<h3>大于 160</h3>
</c:when>
<c:when test="${requestScope.height > 150}">
<h3>大于 150</h3>
</c:when>
<c:when test="${requestScope.height > 140}">
<h3>大于 140</h3>
</c:when>
<c:otherwise>
其他小于 140
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
```

- <c:forEach />  

  ```jsp
  <%--1.遍历 1 到 10， 输出
  begin 属性设置开始的索引
  end 属性设置结束的索引
  var 属性表示循环的变量(也是当前正在遍历到的数据)
  for (int i = 1; i < 10; i++)
  --%>
  <table border="1">
  <c:forEach begin="1" end="10" var="i">
  <tr>
  <td>第${i}行</td>
  </tr>
  </c:forEach>
  </table>
  
  
  <%-- 2.遍历 Object 数组
  for (Object item: arr)
  items 表示遍历的数据源（遍历的集合）
  var 表示当前遍历到的数据
  --%>
  <%
  request.setAttribute("arr", new String[]{"18610541354","18688886666","18699998888"});
  %>
  <c:forEach items="${ requestScope.arr }" var="item">
  ${ item } <br>
  </c:forEach>
  
  
  <%
  Map<String,Object> map = new HashMap<String, Object>();
  map.put("key1", "value1");
  map.put("key2", "value2");
  map.put("key3", "value3");
  // for ( Map.Entry<String,Object> entry : map.entrySet()) {
  // }
  request.setAttribute("map", map);
  %>
  <c:forEach items="${ requestScope.map }" var="entry">
  <h1>${entry.key} = ${entry.value}</h1>
  </c:forEach>
  
  
  <%--4.遍历 List 集合---list 中存放 Student 类， 有属性： 编号， 用户名， 密码， 年龄， 电话信息--%>
  <%
  List<Student> studentList = new ArrayList<Student>();
  for (int i = 1; i <= 10; i++) {
  studentList.add(new Student(i,"username"+i ,"pass"+i,18+i,"phone"+i));
  } 
  request.setAttribute("stus", studentList);
  %>
  <table>
  <tr>
  <th>编号</th>
  <th>用户名</th>
  <th>密码</th>
  <th>年龄</th>
  <th>电话</th>
  <th>操作</th>
  </tr>
  <%--
  items 表示遍历的集合
  var 表示遍历到的数据
  begin 表示遍历的开始索引值
  end 表示结束的索引值
  step 属性表示遍历的步长值
  varStatus 属性表示当前遍历到的数据的状态
  for（int i = 1; i < 10; i+=2）
  --%>
  <c:forEach begin="2" end="7" step="2" varStatus="status" items="${requestScope.stus}" var="stu">
  <tr>
  <td>${stu.id}</td>
  <td>${stu.username}</td>
  <td>${stu.password}</td>
  <td>${stu.age}</td>
  <td>${stu.phone}</td>
  <td>${status.step}</td>
  </tr>
  </c:forEach>
  </table>
  ```

  





#### 文件的上传



- 概述

  > 1、 要有一个 form 标签， method=post 请求
  > 2、 form 标签的 encType 属性值必须为 multipart/form-data 值
  > 3、 在 form 标签中使用 input type=file 添加上传的文件
  > 4、 编写服务器代码（Servlet 程序） 接收， 处理上传的数据。
  > encType=multipart/form-data 表示提交的数据， 以多段（每一个表单项一个数据段） 的形式进行拼
  > 接， 然后以二进制流的形式发送给服务器  



- commons-fileupload.jar 常用 API 介绍说明  

  ```java
  commons-fileupload.jar 需要依赖 commons-io.jar 这个包， 所以两个包我们都要引入。
  第一步， 就是需要导入两个 jar 包：
  commons-fileupload-1.2.1.jar
  commons-io-1.4.jar
  commons-fileupload.jar 和 commons-io.jar 包中， 我们常用的类有哪些？
  ServletFileUpload 类， 用于解析上传的数据。
  FileItem 类， 表示每一个表单项。
  boolean ServletFileUpload.isMultipartContent(HttpServletRequest request);
  判断当前上传的数据格式是否是多段的格式。
  public List<FileItem> parseRequest(HttpServletRequest request)
  解析上传的数据
  boolean FileItem.isFormField()
  判断当前这个表单项， 是否是普通的表单项。 还是上传的文件类型。
  true 表示普通类型的表单项
  false 表示上传的文件类型
  String FileItem.getFieldName()
  获取表单项的 name 属性值String FileItem.getString()
  获取当前表单项的值。
  String FileItem.getName();
  获取上传的文件名
  void FileItem.write( file );
  将上传的文件写到 参数 file 所指向抽硬盘位置 。
  ```

  

- fileupload 类库的使用

  ```java
  上传文件的表单：
  <form action="http://192.168.31.74:8080/09_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
  用户名： <input type="text" name="username" /> <br>
  头像： <input type="file" name="photo" > <br>
  	<input type="submit" value="上传">
  </form>
      
  解析上传的数据的代码
      
   @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          // 先判断上传的数据是否是多段上传
          if (ServletFileUpload.isMultipartContent(req)) {
              // 创建FileItemFactory工厂
              FileItemFactory itemFactory = new DiskFileItemFactory();
              // 创建解析上传数据的工具类
              ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
              try {
                  // 解析上传的数据
                  List<FileItem> list = fileUpload.parseRequest(req);
                  // 循环判断是否是普通类型
                  for (FileItem item : list) {
                      if (item.isFormField()) {
                          // 普通类型
                          System.out.println("上传用户为： " + item.getString("UTF-8"));
                      } else {
                          // 文件类型
                          //动态获取服务器的路径
                          String serverpath = "D:\\学习笔记\\web-demo\\JQuery01\\jsp_demo\\src\\upload";
                          item.write(new File(serverpath + "\\" + item.getName()));
                          System.out.println("文件: " + item.getName()  + " 上传成功");
                      }
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
  
  
          }
  
  
      }
      
  ```

  



#### 文件下载



> 下载的常用 API 说明：
> response.getOutputStream();
> servletContext.getResourceAsStream();
> servletContext.getMimeType();
> response.setContentType();
> response.setHeader("Content-Disposition", "attachment; fileName=1.jpg");
> 这个响应头告诉浏览器。 这是需要下载的。 而 attachment 表示附件， 也就是下载的一个文件。 fileName=后面，
> 表示下载的文件名。
> 完成上面的两个步骤， 下载文件是没问题了。 但是如果我们要下载的文件是中文名的话。 你会发现， 下载无法正确
> 显示出正确的中文名。
> 原因是在响应头中， 不能包含有中文字符， 只能包含 ASCII 码。  



```java
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始文件下载");
        // 获取下载名称
        String downName = "abc.jpg";
        // 读取下载的文件
        ServletContext context = this.getServletContext();
        // 设置返回类型
        String type = context.getMimeType("/upload/" + downName);
        resp.setContentType(type);
        resp.setHeader("Content-Disposition", "attachment; filename=" + downName);
        InputStream inputStream = context.getResourceAsStream("/upload/" + downName);

        // 获取响应流
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(inputStream, outputStream);

    }
```



