## 三人行-Java-Web复习-第一天





### 0. 今日目标



#### JavaScript的基础知识



- **JavaScript 用法**

> HTML 中的脚本必须位于 <script> 与 </script> 标签之间，脚本可被放置在 HTML 页面的 <body> 和 <head> 部分中
>
> 脚本代码也可以写在外部文件，通过 <script src="myScript.js"></script> 引入。



- **JavaScript 输出**
  - 使用 **window.alert()** 弹出警告框。
  - 使用 **document.write()** 方法将内容写到 HTML 文档中。
  - 使用 **innerHTML** 写入到 HTML 元素。
  - 使用 **console.log()** 写入到浏览器的控制台。



- **操作HTML元素**

  > 如需从 JavaScript 访问某个 HTML 元素，您可以使用 document.getElementById(*id*) 方法。
  >
  > 请使用 "id" 属性来标识 HTML 元素，并 innerHTML 来获取或插入元素内容.



- **JavaScript  语法**

  - 变量

    > JavaScript 使用关键字 **var** 来定义变量， 使用等号来为变量赋值.

    定义

    > 变量必须以字母开头
    > 变量也能以 $ 和 _ 符号开头（不过我们不推荐这么做）
    > 变量名称对大小写敏感（y 和 Y 是不同的变量）

    

  - 数据类型

    > **值类型(基本类型)**：字符串（String）、数字(Number)、布尔(Boolean)、对空（Null）、未定义（Undefined）、Symbol。
    >
    > **引用数据类型**：对象(Object)、数组(Array)、函数(Function)。
    >
    > **但都是通过 var 来定义的**
    >
    > **JavaScript 拥有动态类型:** JavaScript 拥有动态类型。这意味着相同的变量可用作不同的类型：
    ```js
    var length = 16;                  // Number 通过数字字面量赋值
    var points = x * 10;               // Number 通过表达式字面量赋值
    var lastName = "Johnson";             // String 通过字符串字面量赋值
    var cars = ["Saab", "Volvo", "BMW"];       // Array 通过数组字面量赋值
    var person = {firstName:"John", lastName:"Doe"}; // Object 通过对象字面量赋值
    ```
    
    **Undefined 和 Null:**
    
    > Undefined 这个值表示变量不含有值。
    >
    > 可以通过将变量的值设置为 null 来清空变量。
    
  - 字符串

    **字符串属性：**

    | 属性        | 描述                       |
    | :---------- | :------------------------- |
    | constructor | 返回创建字符串属性的函数   |
    | length      | 返回字符串的长度           |
    | prototype   | 允许您向对象添加属性和方法 |

    

    ------

    

    **字符串方法：**

    | 方法                | 描述                                                         |
    | :------------------ | :----------------------------------------------------------- |
    | charAt()            | 返回指定索引位置的字符                                       |
    | charCodeAt()        | 返回指定索引位置字符的 Unicode 值                            |
    | concat()            | 连接两个或多个字符串，返回连接后的字符串                     |
    | fromCharCode()      | 将 Unicode 转换为字符串                                      |
    | indexOf()           | 返回字符串中检索指定字符第一次出现的位置                     |
    | lastIndexOf()       | 返回字符串中检索指定字符最后一次出现的位置                   |
    | localeCompare()     | 用本地特定的顺序来比较两个字符串                             |
    | match()             | 找到一个或多个正则表达式的匹配                               |
    | replace()           | 替换与正则表达式匹配的子串                                   |
    | search()            | 检索与正则表达式相匹配的值                                   |
    | slice()             | 提取字符串的片断，并在新的字符串中返回被提取的部分           |
    | split()             | 把字符串分割为子字符串数组                                   |
    | substr()            | 从起始索引号提取字符串中指定数目的字符                       |
    | substring()         | 提取字符串中两个指定的索引号之间的字符                       |
    | toLocaleLowerCase() | 根据主机的语言环境把字符串转换为小写，只有几种语言（如土耳其语）具有地方特有的大小写映射 |
    | toLocaleUpperCase() | 根据主机的语言环境把字符串转换为大写，只有几种语言（如土耳其语）具有地方特有的大小写映射 |
    | toLowerCase()       | 把字符串转换为小写                                           |
    | toString()          | 返回字符串对象值                                             |
    | toUpperCase()       | 把字符串转换为大写                                           |
    | trim()              | 移除字符串首尾空白                                           |
    | valueOf()           | 返回某个字符串对象的原始值                                   |

    

  

  

  ​	**JavaScript 对象:**

  > **对象定义**: var person = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};

  

  ​	**对象方法**

  > *methodName : function() { code lines }*

  

  - 操作符

    > JavaScript的操作符和Java中的差不多。

    | 类型                   | 实例      | 描述                   |
    | :--------------------- | :-------- | :--------------------- |
    | 赋值，算术和位运算符   | = + - * / | 在 JS 运算符中描述     |
    | 条件，比较及逻辑运算符 | == != < > | 在 JS 比较运算符中描述 |

  

  ​	JavaScript 算术运算符

  

  | 运算符 | 描述         | 例子  | x 运算结果                                                   | y 运算结果 | 在线实例                                                     |
  | :----- | :----------- | :---- | :----------------------------------------------------------- | :--------- | :----------------------------------------------------------- |
  | +      | 加法         | x=y+2 | 7                                                            | 5          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_add) |
  | -      | 减法         | x=y-2 | 3                                                            | 5          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_sub) |
  | *      | 乘法         | x=y*2 | 10                                                           | 5          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_mult) |
  | /      | 除法         | x=y/2 | 2.5                                                          | 5          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_div) |
  | %      | 取模（余数） | x=y%2 | 1                                                            | 5          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_mod) |
  | ++     | 自增         | x=++y | 6                                                            | 6          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_incr) |
  | x=y++  | 5            | 6     | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_incr2) |            |                                                              |
  | --     | 自减         | x=--y | 4                                                            | 4          | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_decr) |
  | x=y--  | 5            | 4     | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_decr2) |            |                                                              |

  

  ------

  >  **JavaScript 赋值运算符：**
  >
  > 赋值运算符用于给 JavaScript 变量赋值。
  >
  > 给定 **x=10** 和 **y=5**，下面的表格解释了赋值运算符：

  

  | 运算符 | 例子 | 等同于 | 运算结果 | 在线实例                                                     |
  | :----- | :--- | :----- | :------- | :----------------------------------------------------------- |
  | =      | x=y  |        | x=5      | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_equal) |
  | +=     | x+=y | x=x+y  | x=15     | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_plusequal) |
  | -=     | x-=y | x=x-y  | x=5      | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_minequal) |
  | *=     | x*=y | x=x*y  | x=50     | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_multequal) |
  | /=     | x/=y | x=x/y  | x=2      | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_divequal) |
  | %=     | x%=y | x=x%y  | x=0      | [实例 »](https://www.runoob.com/try/try.php?filename=tryjs_oper_modequal) |

  

  ------

  

  

  - 注释

    > '//' 双斜杠可以用于单行注释
    >
    > ‘/*  */’ 用于多行注释




  - 函数

    > 这里函数的概念和Java中的方法概念一样。

    ```js
    function myFunction(a, b) {
        return a * b;                                // 返回 a 乘以 b 的结果
    }
    // 带有返回值的函数
    function myFunction()
    {
        var x=5;
        return x;
    }
    
    
    ```
    
    





- **JavaScript 事件**



- 常见的HTML事件

  

下面是一些常见的HTML事件的列表:

| 事件        | 描述                         |
| :---------- | :--------------------------- |
| onchange    | HTML 元素改变                |
| onclick     | 用户点击 HTML 元素           |
| onmouseover | 用户在一个HTML元素上移动鼠标 |
| onmouseout  | 用户从一个HTML元素上移开鼠标 |
| onkeydown   | 用户按下键盘按键             |
| onload      | 浏览器已完成页面的加载       |







#### DOM



- 改变 HTML 

  > document.write() 可用于直接向 HTML 输出流写内容。
  >
  > document.getElementById(*id*).innerHTML=*新的 HTML*
  >
  > document.getElementById(*id*).*attribute=新属性值*



- 改变CSS

  > document.getElementById(*id*).style.*property*=*新样式*
  >
  > 使用事件： <button type="button" onclick="document.getElementById('id1').style.color='red'">



- 事件

  > 对事件做出反应
  >
  > 例如：
  >
  > - 当用户点击鼠标时
  > - 当网页已加载时
  > - 当图像已加载时
  > - 当鼠标移动到元素上时
  > - 当输入字段被改变时
  > - 当提交 HTML 表单时
  > - 当用户触发按键时
  >
  > HTML 事件属性：<button **onclick**="**displayDate()**">点这里</button>
  >
  > 使用 HTML DOM 来分配事件： <script>document.getElementById("myBtn").onclick=function(){displayDate()};</script>
  >
  > onload 和 onunload 事件：onload 和 onunload 事件会在用户进入或离开页面时被触发。
  >
  > onchange 事件： <input type="text" id="fname" **onchange**="upperCase()">
  >
  > onmouseover 和 onmouseout 事件：onmouseover 和 onmouseout 事件可用于在用户的鼠标移至 HTML 元素上方或移出元素时触发函数。
  >
  > onmousedown、onmouseup 以及 onclick 事件：onmousedown, onmouseup 以及 onclick 构成了鼠标点击事件的所有部分。首先当点击鼠标按钮时，会触发 onmousedown 事件，当释放鼠标按钮时，会触发 onmouseup 事件，最后，当完成鼠标点击时，会触发 onclick 事件。



- 监听

  > addEventListener() 方法:： document.getElementById("myBtn").addEventListener("click", displayDate);



- DOM 元素 (节点)

  - appendChild()

  ```html
  <div id="div1">
  <p id="p1">这是一个段落。</p>
  <p id="p2">这是另外一个段落。</p>
  </div>
   
  <script>
  var para = document.createElement("p"); //用于创建 <p> 元素
  var node = document.createTextNode("这是一个新的段落。"); // 为 <p> 元素创建一个新的文本节点
  para.appendChild(node); // 将文本节点添加到 <p> 元素中
   
  var element = document.getElementById("div1"); // 查找已存在的元素
  element.appendChild(para); //添加到已存在的元素中
  </script>
  ```

  - insertBefore()

    ```html
    <div id="div1">
    <p id="p1">这是一个段落。</p>
    <p id="p2">这是另外一个段落。</p>
    </div>
     
    <script>
    var para = document.createElement("p");
    var node = document.createTextNode("这是一个新的段落。");
    para.appendChild(node);
     
    var element = document.getElementById("div1");
    var child = document.getElementById("p1");
    element.insertBefore(para, child);
    </script>
    ```

  - removeChild(child);

    > 移除已存在的元素

  - replaceChild()

    > 使用 replaceChild() 方法来替换 HTML DOM 中的元素。









#### JQuery 框架



- 选择器

  > jQuery 中所有选择器都以美元符号开头：$()。

  - 元素选择器

    > jQuery 元素选择器基于元素名选取元素。
    >
    > 在页面中选取所有 <p> 元素:   $("p")

  

  - #id 选择器

    > jQuery #id 选择器通过 HTML 元素的 id 属性选取指定的元素。
    >
    > 页面中元素的 id 应该是唯一的，所以您要在页面中选取唯一的元素需要通过 #id 选择器。
    >
    > 通过 id 选取元素语法如下：  $("#test")

    

  - .class 选择器

    > jQuery 类选择器可以通过指定的 class 查找元素。
    >
    > 语法如下： $(".test")

    

- 事件

  常见 DOM 事件：

  | 鼠标事件                                                     | 键盘事件                                                     | 表单事件                                                  | 文档/窗口事件                                             |
  | :----------------------------------------------------------- | :----------------------------------------------------------- | :-------------------------------------------------------- | :-------------------------------------------------------- |
  | [click](https://www.runoob.com/jquery/event-click.html)      | [keypress](https://www.runoob.com/jquery/event-keypress.html) | [submit](https://www.runoob.com/jquery/event-submit.html) | [load](https://www.runoob.com/jquery/event-load.html)     |
  | [dblclick](https://www.runoob.com/jquery/event-dblclick.html) | [keydown](https://www.runoob.com/jquery/event-keydown.html)  | [change](https://www.runoob.com/jquery/event-change.html) | [resize](https://www.runoob.com/jquery/event-resize.html) |
  | [mouseenter](https://www.runoob.com/jquery/event-mouseenter.html) | [keyup](https://www.runoob.com/jquery/event-keyup.html)      | [focus](https://www.runoob.com/jquery/event-focus.html)   | [scroll](https://www.runoob.com/jquery/event-scroll.html) |
  | [mouseleave](https://www.runoob.com/jquery/event-mouseleave.html) |                                                              | [blur](https://www.runoob.com/jquery/event-blur.html)     | [unload](https://www.runoob.com/jquery/event-unload.html) |
  | [hover](https://www.runoob.com/jquery/event-hover.html)      |                                                              |                                                           |                                                           |

- $(document).ready()

  > $(document).ready() 方法允许我们在文档完全加载完后执行函数。该事件方法在 [jQuery 语法](https://www.runoob.com/jquery/jquery-syntax.html) 章节中已经提到过。

- click()

  > click() 方法是当按钮点击事件被触发时会调用一个函数。
  >
  > 实例:
  >
  > $("p").click(function(){  $(this).hide(); });

- dblclick()

  > 当双击元素时，会发生 dblclick 事件。
  >
  > 实例:
  >
  > $("p").dblclick(function(){  $(this).hide(); });

- mouseenter()

  > 当鼠标指针穿过元素时，会发生 mouseenter 事件。
  >
  > 实例:
  >
  > $("#p1").mouseenter(function(){    alert('您的鼠标移到了 id="p1" 的元素上!'); });

- mouseleave()

  > 当鼠标指针离开元素时，会发生 mouseleave 事件。
  >
  > 实例
  >
  > $("#p1").mouseleave(function(){    alert("再见，您的鼠标离开了该段落。"); });

- mousedown()

  > 当鼠标指针移动到元素上方，并按下鼠标按键时，会发生 mousedown 事件。
  >
  > 实例
  >
  > $("#p1").mousedown(function(){    alert("鼠标在该段落上按下！"); });

- mouseup()

  > 当在元素上松开鼠标按钮时，会发生 mouseup 事件。
  >
  > 实例
  >
  > $("#p1").mouseup(function(){    alert("鼠标在段落上松开。"); });

- hover()

  > hover()方法用于模拟光标悬停事件。
  >
  > 实例
  >
  > $("#p1").hover(    function(){        alert("你进入了 p1!");    },    function(){        alert("拜拜! 现在你离开了 p1!");    } );

- focus()

  > 当元素获得焦点时，发生 focus 事件。
  >
  > 当通过鼠标点击选中元素或通过 tab 键定位到元素时，该元素就会获得焦点。
  >
  > 实例
  >
  > $("input").focus(function(){  $(this).css("background-color","#cccccc"); });

- blur()

  > 当元素失去焦点时，发生 blur 事件。
  >
  > 实例
  >
  > $("input").blur(function(){  $(this).css("background-color","#ffffff"); });



- 设置内容和属性

获得内容 - text()、html() 以及 val():

三个简单实用的用于 DOM 操作的 jQuery 方法：

- text() - 设置或返回所选元素的文本内容
- html() - 设置或返回所选元素的内容（包括 HTML 标记）
- val() - 设置或返回表单字段的值



**设置属性:**

> 设置属性 - attr():
>
> jQuery attr() 方法也用于设置/改变属性值。
>
> 下面的例子演示如何改变（设置）链接中 href 属性的值：
>
> $("button").click(function(){  $("#runoob").attr("href","http://www.runoob.com/jquery"); });







*<u>JQuery 其它语法可以查看文档，这里就不一一列举了！</u>*

