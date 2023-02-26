# boot-nbsaas

[![maven](https://img.shields.io/maven-central/v/com.nbsaas.boot/boot-nbsaas.svg)](http://mvnrepository.com/artifact/com.nbsaas.boot/boot-nbsaas)
[![QQ](https://img.shields.io/badge/chat-on%20QQ-ff69b4.svg?style=flat-square)](//shang.qq.com/wpa/qunwpa?idkey=d1a308945e4b2ff8aeb1711c2c7914342dae15e9ce7041e94756ab355430dc78)
[![Apache-2.0](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![使用IntelliJ IDEA开发维护](https://img.shields.io/badge/IntelliJ%20IDEA-提供支持-blue.svg)](https://www.jetbrains.com/idea/)
[![GitHub forks](https://img.shields.io/github/stars/nbsaas/boot-nbsaas.svg?style=social&logo=github&label=Stars)](https://github.com/nbsaas/boot-nbsaas)

#### 介绍

{**nbsaas**}
nbsaas一个快速代码开发框架

### 技术选型：

* **服务端**

* SSH (Spring、SpringMVC、Hibernate）
* Spring boot,Spring cloud,Spring alibaba
* 安全权限 Shiro
* 缓存 Ehcache
* 视图模板 freemarker
* 其它 Jsoup、gson

### 编码规范
1.项目结构规范
```
com.{公司域名}.{主工程}
com.{公司域名}.{主工程}.{子工程}


```
2.包结构规范
```
//主包结构
com.{公司域名}.{主工程}.{子工程}
com.{公司域名}.{主工程}.{子工程}.controller
com.{公司域名}.{主工程}.{子工程}.data
com.{公司域名}.{主工程}.{子工程}.freemaker
com.{公司域名}.{主工程}.{子工程}.web
com.{公司域名}.{主工程}.{子工程}.utils
com.{公司域名}.{主工程}.{子工程}.rest
com.{公司域名}.{主工程}.{子工程}.plugins
com.{公司域名}.{主工程}.{子工程}.web
com.{公司域名}.{主工程}.{子工程}.exception

//controller包子结构
com.{公司域名}.{主工程}.{子工程}.controller.admin
com.{公司域名}.{主工程}.{子工程}.controller.front
com.{公司域名}.{主工程}.{子工程}.controller.rest

//rest包子结构
com.{公司域名}.{主工程}.{子工程}.rest.conver
com.{公司域名}.{主工程}.{子工程}.data.resources

```


### 使用访问
已经发布到maven中央仓库了
```
    <parent>
        <groupId>com.nbsaas.boot</groupId>
        <artifactId>boot-nbsaas</artifactId>
        <version>1.0.2-2023-02-26</version>
    </parent>
```
