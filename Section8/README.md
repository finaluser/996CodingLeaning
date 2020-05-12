# 分层验证和JavaBean验证s
分层验证模型
分层验证模型.png

JavaBean验证模型
JavaBean验证模型.png


# BeanValidation简介
BeanValidation为JavaBean验证定义了相应的元数据模型和API.

# JCP,JSR简介

JCP(Java Community Process)成立于1998年,是使有兴趣的各方参与与定义Java的特征和未来版本的正式过程.

JCP使用JSR(Java规范请求)作为正式规范文档,描述被提议加入到Java体系中的规范和技术.

# 有关数据校验的JSR
- JSR303(Bean Validation1.0)
- JSR349(Bean Validation1.1)
- JSR380(Bean Validation2.0)

# BeanValidation和HibernateValidation的关系

- BeanValidation1.0参考实现:Hibernate Validator 4.3.1.Final
- BeanValidation1.1参考实现:Hibernate Validator 5.1.1.Final
- BeanValidation2.0参考实现:Hibernate Validator 6.0.1.Final

# Hibernate Validator与Spring Validation的区别
SpringValidation在HibernateValidation的基础上对其进行了二次封装,以满足在Spring环境中更简单,高效的对数据进行验证.

# 常用约束注解
1. 空值校验类
    - @Null
    - @NotNull
    - @NotEmpty
    - @NotBlank
    - 等
2. 范围校验类
    - @Min
    - @Size
    - @Digits
    - @Future
    - @Negative
    - 等
3. 其他校验类
    - @Email
    - @URL
    - @AssertTrue
    - @Pattern
    - 等 
# 案例
## 引入依赖
"""

      <!--ValidationAPI-->
        <dependency>
            <groupId>javax.validation</groupId>
            <artifactId>validation-api</artifactId>
            <version>2.0.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.16.Final</version>
        </dependency>
        
"""

## 初级约束注解的使用
- validation.UserInfo
- validation.ValidationTest

## 中级约束注解的使用
- 级联验证
    - @Valid
    
- 分组验证
- 组序列

案例:
- validation.UserInfo
- validation.ValidationTest

## 高级约束注解使用
- 校验参数
- 校验返回值
- 校验构造方法









