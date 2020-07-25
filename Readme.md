# 惠闲交易平台

## 平台介绍

此系统为Springboot+vue的前后端分离开源项目，此项目希望能够帮助惠工各同学需要闲置个人物品。

## 系统架构

* 前端采用Vue、Element UI、Axios。
* 后端采用Spring Boot、Mybatis。
* 权限管理：Shiro。
* Api文档：Swagger。
* 数据库使用：MySQL，
* 其它：Druid数据库连接池，Generator，PageHelper，Maven，Git，Gitte。

## 内置功能

一、商品管理

- 商品列表：前台的商品列表。
- 库存：商品的库存。
- 商品分类：各种商品的分类。
- 发布商品
- 下架商品

二、订单管理

- 订单列表：
  - 待发货订单
  - 待收货订单
  - 待付款订单
  - 已完成订单
  - 已取消订单
- 退货管理：订单退货管理。
- 订单进度：查看订单的进度信息。

三、系统配置 **（系统管理员）**

- 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- 权限列表：规定权限控制的功能。

四、用户管理 **（系统管理员）**

- 用户列表：配置系统操作的用户。
- 管理员列表: 管理员的列表。

五、日志管理 **（系统管理员）**

- 系统日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- 登录日志：系统登录日志记录查询包含登录异常。
- 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
- 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。

六、其它功能 **（系统管理员）**

- 通知公告：系统通知公告信息发布维护。
- 学院公告：发布一些学院的公告。
- bug留言。

## 在线体验

- admin/admin
- 欢迎各位小伙伴来体验。

演示地址：http://www.codewhite.cn/huixian/

API文档：http://www.codewhite.cn/huixian/doc.html

## 功能模块

![惠闲二手交易平台（后台）](https://codewhite.cn/img/惠闲二手交易平台（后台）.png)

## 技术架构

![image-20200724133600609](https://codewhite.cn/img/技术架构.png)

## 前台页面

![image-20200724135648106](https://codewhite.cn/img/前台页面.png)

## 后台页面

![后台页面 (1)](https://codewhite.cn/img/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2%20.png)

## 文件目录

```properties
com.huixian 
├── admin                                // 管理员模块
│       └── controller   //控制器
├── common                               // 工具类
│       └── web  
├── center                               // 框架核心
│       └── config     //配置信息
├── system                               // 系统模块
│        └── mapper     //mapper类                         
│        └── service    //服务模块 
```

