# 垃圾回收的特点
- 垃圾回收机制只负责回收堆内的内存资源,不会回收任何物理资源
- 程序无法精确的控制垃圾回收动作具体发生的时间
- 在垃圾回收之前,总会先调用资源的finalize方法

# 常见需手动释放的物理资源
- 文件/流资源
- Socket资源
- 数据库连接资源


## 如果物理资源不手动释放会引起的问题
- 资源被长时间无效占用
- 超过最大限制后,将无资源可用
- 正常的程序无法获取资源,导致系统无法运行

# 文件拷贝案例

## 初始版

## Try-With-Resource版

# Try-With-Resource简介

- JDK7之后的新特性
- 优雅的关闭资源
- 一种新型的语法糖

# Try-With-Resource源码解析

try-with-resource只是在语法上帮助开发者简化资源关闭的写法,并没有从Java语法上帮我们优化资源关闭.

## Try-With-Resource的使用

- 多资源自动关闭
- 所有需要JDK自动关闭的资源必须实现AutoCloseable接口
- 使用Try-With-Resource进行资源关闭的时候,JDK帮我们生成的异常跟我们自己写的异常不一样,需要谨慎处理

## 资源关闭的特殊情况
1. 资源对象被Return的情况下,由调用方关闭
2. ByteArrayInputStream等不需要检查关闭资源对象
3. 使用Socket(套接字)获取的InputStream和OutputStream对象不需要关闭资源







 
