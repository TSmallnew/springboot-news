# pb-cms
### 瀑布内容管理系统，采用SpringBoot + Apache Shiro + Mybatis Plus + Thymeleaf 实现的内容管理系统(附带权限管理)，是搭建博客、网站的不二之选。

#### 项目介绍
pb-cms,致力于开发最精简、实用的CMS管理系统，适合搭建博客、企业网站等，完美自适应。<br/>
#### 技术栈
Spring Boot、Shiro、MyBatis-Plus、Druid、Redis、MySQL、thymeleaf<br/>

![JDK](https://img.shields.io/badge/JDK-1.8-green.svg)
![Maven](https://img.shields.io/badge/Maven-3.3.9-green.svg)
![MySQL](https://img.shields.io/badge/MySQL-5.7-green.svg)
![Redis](https://img.shields.io/badge/Redis-3.0.503-green.svg)
![license](https://img.shields.io/badge/license-MIT-yellow.svg)

#### 特点

1. 项目采用前沿技术，及时跟进各项依赖技术的新版本，保持项目的技术先进性。
2. 程序员的编辑器：markdown编辑器**_simplemde_**，无压力编写markdown格式文章。
3. 精简的评论模块（基于cookie实现的用户信息记忆功能）。
4. 简单配置，即可运行。（见下文使用说明）。
5. 完备的后台权限管理模块。



#### 使用说明

1. 使用IDE导入本项目，IDE需要安装[lombok](https://projectlombok.org/)插件
2. 新建数据库`CREATE DATABASE pb_cms_base;`
3. 导入数据库,数据库文件目录:`docs/db/pb_cms_base.sql`
4. 修改(`resources/application.yml`)配置文件
   1. 修改数据库链接相关连接串、用户名和密码(可搜索`datasource`)
   2. redis配置(可搜索`redis`)
5. 运行项目(三种方式)
   1. 项目根目录下执行`mvn -X clean package -Dmaven.test.skip=true`编译打包，然后执行`java -jar pb-cms/target/pb-cms.jar`
   2. 项目根目录下执行`mvn springboot:run`
   3. 直接运行`ShiroBootApplication.java`
6. 前台首页，浏览器访问`http://localhost:8080`
7. 后台首页，浏览器访问`http://localhost:8080/admin`使用账号密码admin,123456登录系统后台。(可选项:进行七牛云存储配置)



#### 参与贡献

1. Fork 本项目
2. 新建 feature_xxx 分支
3. 提交代码
4. 提交 Pull Request



