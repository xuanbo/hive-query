# hive-query

> hive可视化web系统

## 宗旨

一切为了好玩（Just For Fun）

## 展示

![展示](./doc/ui.png)

## 功能

* 展示数据库、表
* 查询（`select`、`show`、`desc`等）
* 更新（`insert`、`truncate`等）
* 执行（`create table`等）

## 快速入门

* 编译

```shell
hive-query> cd core
core> mvn package -DskipTests
```

* 执行

```shell
core> java -jar target/core-1.0.jar -Dspring.datasource.url=jdbc:hive2://172.16.242.185:15030/default
```

**注意：**这里`spring.datasource.url`替换为hive的`thrift server`的jdbc连接。

* 浏览器访问：`http://127.0.0.1:8080`

## 原理

基于spring boot2.x，通过jdbc连接hive thrift server，最后进行可视化展示。