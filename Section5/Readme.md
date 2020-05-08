# Guava工具简介

Guava工程包含了若干被Google的Java项目广泛依赖的核心库

主要有
- 集合
- 缓存
- 原生类型支持
- 并发库
- 通用注解
- 字符串处理
- IO
- 等等

所有这些工具每天都在被Google工程师应用在生产环境中

# Optional的使用方法

Optional的使用

package guava;
Optional.class

# 不可变集合
创建对象不可变拷贝是一项很好的防御性编程技巧
Guava为所有的JDK标准集合类型和Guava新集合类型都提供了简单易用的不可变集合版本

## 不可变集合的优点
1. 当对象被不可信的库调用时,不可变形式是安全的
2. 不可变对象被多个线程进行调用的时候,不存在竞态条件问题.
3. 不可变集合不需要考虑变化,因此可以节省空间和时间
4. 不可变对象因为有固定不变,可以作为常量来安全使用

## JDK为我们提供的unmodifiableXXX方法的缺点
1. 笨重且累赘
2. 不安全
3. 低效

## 不可变集合的三种创建方式
- CopyOf():ImmutableSet.copyOf(set)
- of():ImmutableSet.of()
- Build工具:ImmutableSet.builder().build()

案例:guava.ImmutableTest

# 新集合类型
Guava引入了许多JDK没有的,但明显有用的新集合类型.这些类型是为了和JDK集合框架共存,而没有往JDK集合抽象中硬塞其他概念.

Multiset.png

Multiset可以看成一个没有元素顺序限制的ArrayList.
- add:添加单个给定元素
- iterator:返回一个迭代器,包含Multiset所有元素(包括重复元素)
- size:返回所有元素的个数(包括重复元素)

MultiSet也可以看成一个Map<E,Integer>键为元素,值为计数
- count:返回给定元素的计数
- entrySet:返回Set<MultiSetEntry<E>>和Map的EntrySet类似
- elementSet:返回所有不重复元素的Set<E>和Map的KeySet类似

MultiSet与Map的区别
- MultiSet的元素计数只能是正数
- MultiSet的size()方法返回的是集合大小
- MultiSet的iterator()方法会迭代重复的元素
- MultiSet支持直接设置元素的计数
- 没有元素的时候MultiSet.count(E)会返回0

MultiSet的具体实现
- HashMultiSet
- TreeMultiSet
- LinkedHashMultiSet
- ConcurrentHashMultiSet
- ImmutableMultiSet

MultiSet实战使用

使用MultiSet集合类,统计一篇文章中文字出现次数

guava.MultiSetTest

# 集合工具类实战
- 使用Lists工具类操作List集合
- 使用Sets工具类操作Set集合

案例:guava.SetsTest

# IO工具类
## Guava对字节流和字符流提供的工具方法
- ByteStreams:提供对InputStream/OutputStream的操作
- CharStreams:提供对Reader/Writer的操作

## Guava对源(Source)和汇(Sink)的抽象
- 源是可读的:ByteSource/CharSource
- 汇是可写的:ByteSink/CharSink
案例:guava.IOTest















