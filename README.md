# nbsaas-boot

[![maven](https://img.shields.io/maven-central/v/com.niubaite.boot/nbsaas-boot.svg)](https://central.sonatype.com/artifact/com.niubaite.boot/nbsaas-boot)
[![QQ](https://img.shields.io/badge/chat-on%20QQ-ff69b4.svg?style=flat-square)](//shang.qq.com/wpa/qunwpa?idkey=d1a308945e4b2ff8aeb1711c2c7914342dae15e9ce7041e94756ab355430dc78)
[![Apache-2.0](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![使用IntelliJ IDEA开发维护](https://img.shields.io/badge/IntelliJ%20IDEA-提供支持-blue.svg)](https://www.jetbrains.com/idea/)
[![GitHub forks](https://img.shields.io/github/stars/nbsaas/nbsaas-boot.svg?style=social&logo=github&label=Stars)](https://github.com/nbsaas/nbsaas-boot)
#### 架构图
![架构图](https://foruda.gitee.com/images/1692714554881768744/cdda40bc_1029.png "架构图.png")

#### 介绍

nbsaas-boot是一个企业级快速开发框架，具有以下特点：

1. 自动建表：nbsaas-boot提供了自动建表功能，根据用户定义的数据模型自动生成数据库表结构，减少手动操作，提高开发效率。

2. 开发规范：nbsaas-boot提供一套开发规范，包括代码风格、命名规范、注释规范等，使团队开发更加规范化和高效化。

3. 数据搜索：nbsaas-boot提供一种新的数据搜索，基于搜索引擎技术，快速搜索海量数据，提供精确和高效的搜索结果。

4. 代码生成器：nbsaas-boot提供代码生成器，根据数据模型自动生成前端和后端代码，提高开发效率和代码质量。

5. 多租户支持：nbsaas-boot支持多租户，为不同客户提供独立的数据存储空间和访问权限，保证数据安全性和隔离性。

6. 云原生架构：nbsaas-boot基于云原生架构设计，支持容器化部署和自动化运维，具有高可用、高性能、弹性伸缩等优点。

7. 数据安全：nbsaas-boot采用多重数据安全保障措施，包括数据加密、访问控制、备份与恢复等，保护用户数据的安全性和可靠性。

8. 用户友好性：nbsaas-boot提供友好的用户界面和操作体验，快速上手和使用，减少学习成本和使用难度。

9. 可扩展性：nbsaas-boot具有良好的可扩展性，支持模块化开发和插件机制，方便扩展功能和定制化需求。

10. 通用数据查询功能，查询修改实时生效，权限，缓存，限流，预处理，后处理，无需重新部署。

综上所述，nbsaas-boot是一个全面、高效、安全、可扩展、易用的SaaS平台，适用于各种企业级应用的开发和部署。

### 技术选型：

* **服务端**
* Spring、SpringMVC、spring data jpa
* Spring boot,Spring cloud,Spring alibaba
* 安全权限 Shiro
* 缓存 Ehcache
* 视图模板 freemarker
* 其它 Jsoup、gson
* 核心采用Request-Response模式，Chain模型。

## 编码规范

### 1.项目结构规范

```
- 主工程（Main Project）
  - apis  // 包含各种API接口的模块
    - business-api  // 处理业务逻辑的API接口
    - statistics-api  // 提供统计数据的API接口
  - code-generator  // 代码生成器，用于生成特定模块的代码或配置文件
  - gates  // 网关模块，用于管理和转发请求
    - gateway  // 主网关模块，负责整个系统的流量管理
    - admins  // 管理员模块
      - admin  // 管理员信息管理功能
      - tenant  // 租户信息管理功能
    - fronts  // 前台模块
      - tenant  // 租户前台页面管理功能
      - front  // 前台页面管理功能
    - apps  // 应用程序模块
      - db-app  // 数据库管理应用程序
      - tenant-app  // 租户管理应用程序
    - saas  // SaaS模块
      - front-saas  // 前台SaaS功能
      - admin-saas  // 后台SaaS功能
  - resources  // 资源管理模块，用于管理系统的各种资源
    - adapters  // 适配器模块，处理不同资源之间的适配问题
    - db-resources  // 数据库资源管理模块
      - tenant-resources  // 租户相关的数据库资源管理
      - business-resources  // 业务相关的数据库资源管理

```

```
{主工程}
{主工程}.apis
{主工程}.apis.business-api
{主工程}.apis.statistics-api
{主工程}.code-generator
{主工程}.gates
{主工程}.gates.gateway
{主工程}.gates.admins
{主工程}.gates.admins.admin
{主工程}.gates.admins.tenant
{主工程}.gates.fronts
{主工程}.gates.fronts.tenant
{主工程}.gates.fronts.front
{主工程}.gates.apps
{主工程}.gates.apps.db-app
{主工程}.gates.apps.tenant-app
{主工程}.gates.saas
{主工程}.gates.saas.front-saas
{主工程}.gates.saas.admin-saas
{主工程}.resources
{主工程}.resources.adapters
{主工程}.resources.db-resources
{主工程}.resources.db-resources.tenant-resources
{主工程}.resources.db-resources.business-resources

```

### 2.Api模块结构规范


```
com.{公司域名}.{主工程}.{子工程}
com.{公司域名}.{主工程}.{子工程}.api.apis
com.{公司域名}.{主工程}.{子工程}.api.domain.enums
com.{公司域名}.{主工程}.{子工程}.api.domain.request
com.{公司域名}.{主工程}.{子工程}.api.domain.response
com.{公司域名}.{主工程}.{子工程}.api.domain.simple
com.{公司域名}.{主工程}.{子工程}.ext.apis
com.{公司域名}.{主工程}.{子工程}.ext.domain.enums
com.{公司域名}.{主工程}.{子工程}.ext.domain.request
com.{公司域名}.{主工程}.{子工程}.ext.domain.response
com.{公司域名}.{主工程}.{子工程}.ext.domain.simple
```

### 3.Resource模块结构规范

```
com.{公司域名}.{主工程}.{子工程}
com.{公司域名}.{主工程}.{子工程}.data.entity
com.{公司域名}.{主工程}.{子工程}.data.repository
com.{公司域名}.{主工程}.{子工程}.rest.conver
com.{公司域名}.{主工程}.{子工程}.rest.resource
com.{公司域名}.{主工程}.{子工程}.ext.conver
com.{公司域名}.{主工程}.{子工程}.ext.resource
```

### 4.api接口

```
/**
 * 响应接口
 *
 * @param <Response> 详情对象
 * @param <Simple>   列表对象
 * @param <Request>     表单对象
 */
public interface ResponseApi<Response, Simple, Request extends RequestId> {

    /**
     * 分页查询
     *
     * @param request
     * @return 分页数据信息
     */
    PageResponse<Simple> search(PageRequest request);

    /**
     * 根据条件查询集合，不分页
     *
     * @param request
     * @return 数据集合数据
     */
    ListResponse<Simple> list(PageRequest request);

    /**
     * 创建
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> create(Request request);

    /**
     * 更新
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> update(RequestId request);

    /**
     * 删除
     *
     * @param request
     * @return 删除状态
     */
    ResponseObject<?> delete(RequestId request);

    /**
     * 根据ID查询详情
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> view(RequestId request);

}
```

### 5.搜索对象

```
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfoSearchRequest   extends PageRequest implements Serializable {


      
      @Search(name = "phone",operator = Operator.like)
      private String phone;

     @Search(name = "catalog",operator = Operator.eq)
      private Integer catalog;

    
     @Search(name = "note",operator = Operator.like)
      private String note;
     
     @Search(name = "loginSize",operator = Operator.eq)
      private Integer loginSize;
     
     @Search(name = "name",operator = Operator.like)
      private String name;


}
```

## nbsaas-boot业务生态

| 项目名称                        | git地址                                        | 
|:----------------------------|--------------------------------------------------|
| nbsaas-boot-starter         | https://gitee.com/cng1985/nbsaas-boot-starter    | 
| nbsaas-product-starter      | https://gitee.com/cng1985/nbsaas-product-starter | 
| nbsaas-sample-starter       | https://gitee.com/cng1985/nbsaas-sample-starter  | 
| nbsaas-app-starter          | https://gitee.com/cng1985/nbsaas-app-starter     | 
| nbsaas-article-starter      | https://gitee.com/cng1985/nbsaas-article-starter | 
| nbsaas-no-starter           | https://gitee.com/cng1985/nbsaas-no-starter      | 
| nbsaas-data-starter         | https://gitee.com/cng1985/nbsaas-data-starter    | 
| nbsaas-store-starter        | https://gitee.com/cng1985/nbsaas-store-starter   | 
| nbsaas-quartz-starter        | https://gitee.com/cng1985/nbsaas-quartz-starter   | 



## 通用查询
### 批量查询
#### /data/batch
```
{
    "model": "batchTest",
    "page": 1,
    "size": 1,
    "filters": {
        "beginDate": "2024-01-03",
        "endDate": "2024-05-09",
        "warehouseCodeList": "000,SD002"
    }
}

```


### 列表查询
#### /data/list
```
{
    "model": "pageForUserLoginLog",
    "page": 1,
    "size": 1,
    "filters": {
        "beginDate": "2024-01-03",
        "endDate": "2024-05-09",
        "warehouseCodeList": "000,SD002"
    }
}

```


### 分页查询
#### /data/search
```
{
    "model": "pageForUserLoginLog",
    "page": 1,
    "size": 1,
    "filters": {
        "beginDate": "2024-01-03",
        "endDate": "2024-05-09",
        "warehouseCodeList": "000,SD002"
    }
}

```

### 列表无条件查询
#### /data/data/{model}
例如 http://152.136.236.93:8100/data/data/org


已经发布到maven中央仓库了

```
    <parent>
        <groupId>com.niubaite.boot</groupId>
        <artifactId>nbsaas-boot</artifactId>
        <version>1.1.15-2024</version>
    </parent>
```

### 使用nbsaas-boot的项目
[nbsaas-mall2](https://gitee.com/quhaodian/nbsaas-mall2)
[nbsaas-admin](https://gitee.com/cng1985/nbsaas-admin)
[nbsaas-boot-starter](https://gitee.com/cng1985/nbsaas-boot-starter)


