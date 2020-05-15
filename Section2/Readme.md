# Lambda表达式
Lambda 可以理解为一种匿名函数的代替
通过行为参数化传递代码,就是将方法作为入数进行传递.

lambda 的两种构成
- (参数) -> 表达式
- (参数) -> {语句}

Lambda表达式的重要特征:
- 可选的类型声明(不需要声明参数类型,编译器可以统一识别)
- 可选的参数圆括号,一个参数无需定义圆括号,多个参数需要定义圆括号
- 可选的大括号,如果主体包含了一个表达式,就不需要使用大括号
- 可选的返回关键字,如果主体只有一个表达式返回值,则编译器自动返回值

## Lambda表达式的各种形式

- 形式一:没有参数

    () -> System.out.println("Hello Lambda");

- 形式二:只有一个参数(括号可以省略)

name -> System.out.println("Hello" + name);

- 形式三:没有参数,逻辑复杂

() -> {
    System.out.println("Hello World");
    System.out.println("Hello Lambda");
}

- 形式四:包含两个参数的方法

BinaryOperator<Long> functionAdd = (x,y) -> x+y;
Long result = functionAdd.apply(1L,2L);

- 形式五:对参数进行显示的声明

BinaryOperator<Long> functionAdd = (Long x,Long y) -> x+y;
Long result = functionAdd.apply(1L,2L);

## 函数式接口

- 符合函数式接口的Lambda的方法,严格来说接口中只有一个抽象方法
- Java8函数式接口注解:@FunctionInterface(该注解只是用来帮助校验接口是否符合函数式接口定义,也就是是否只有一个抽象方法)
- 函数式接口的抽象方法签名:函数描述符

案例:lambda.file

## 常用函数式接口的使用

文件:常用函数接口

Jdk8提供的函数式接口位置:package java.util.function;


## 方法引用

方法引用.png

方法引用:调用特定方法的Lambda表达式的一种**快捷写法**,可以让你重复使用现有的方法定义,并像Lambda表达式一样传递他们

Sku :: getSkuPrice
目标引用 双冒号分隔符 方法名

### 方法引用的三种方式
- 指向静态方法的方法引用
指向静态方法的方法引用.png

- 指向任意类型实例方法的方法引用
指向任意类型实例方法的方法引用.png

- 指向现有对象的实例方法的方法引用
指向现有对象的实例方法的方法引用.png













