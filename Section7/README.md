# Lombok简介

ProjectLombok是一个Java库,可以自动插入编辑器并构建工具,为您的Java增添色彩.

永远不要再写另一个Getter/Setter方法,使用一个注释,您的类具有一个功能齐全的构建器,自动化您的日志记录变量等等.

# Lombok注解的解析时机
注解的两种解析方式
- 运行时解析
- 编译时解析(Lombok)

# Lombok编译时的解析机制
编译时解析的两种机制
- Annotation Processing Tool(注解处理器)
- Pluggable Annotation Processing(JSR269插入式注解处理器)

# Lombok注解处理器的处理流程图

Lombok注解处理器的处理流程图.png

# Lombok常用注解
Lombok常用注解.png

# IDEA中安装Lombok
在IDEA中使用Lombok的时候,需要安装Lombok插件,如果不安装插件IDEA不识别Lombok的注解

# 引入LombokJar包

"""

    <!--Lombok Provided表示代码运行在编译时期-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.18</version>
            <scope>provided</scope>
        </dependency>
        
"""

# Lombok案例

案例:package:lombok

# Lombok优缺点
优点
- 通过注解自动生成样板代码,提升开发效率
- 代码简洁,只需要关注相关属性
- 新增属性之后,无需刻意修改相关的方法

缺点
- 降低了源代码的可读性和完整性
- 加大对问题排查的难度
- 需要IDE相关插件的支持












