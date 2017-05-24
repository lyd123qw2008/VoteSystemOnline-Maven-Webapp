# VoteSystemOnline-Maven-Webapp
## 项目说明
* VoteSystemOnline-Maven-Webapp是一个网上投票系统,此项目建设初,正是作者刚学Spring、Spring mvc、mybatis,所以用这项目练习，加强，提升自己。
* 项目搭建从大致能拿出手，大概花了一个月。
* 本项目是一个自己阶段性检验的JavaWeb作品。

## 项目选择
* 后台模块选择了 Jquery EasyUi,它提供了丰富的自定义插件,与用户交互性比较强，界面还是比较优美的，加快开发效率，再加上之前使用过这个框架。
* 考虑到投票系统结果的呈现是关键，比较之下选择了Echarts，原因是上手简单，图表显示效果强大，效果比书本的JFreeChart好很多，入手比d3简单，
  能够满足我关于图表呈现这方面的需求。
* 安全框架的使用是个尝试，参考开源的项目，发现都使用了shiro框架，所以采用这一技术试试，上网搜了蛮多资料，参考开源的代码，入过一些坑，
  花费好些精力把功能实现上。
* maven 对项目jar包进行管理，使用后体验感perfect，感觉进入新纪元，管理jar包啥的再方便不过了，需要新导入包，到pom.xml配置。
* 页面表单使用了SpringMvc的表单标签。
* 后端还用了hibernate validator进行表单的数据校验。
* 图表数据获取使用了jQuery封装的ajax，SpringMvc Controller 通过参数数据库查询，最后将结果封装成json格式，返回视图层。

## 项目结构
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524214401.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524215239.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524215346.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524215932.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524220026.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524220117.png)
![Alt text](https://raw.githubusercontent.com/lyd123qw2008/readme_add_pic/master/images/20170524220318.png)

## 技术选型：
* 核心框架：Spring Framework 4.1
* 安全框架：Apache Shiro 1.2
* 视图框架：Spring MVC 4.1
* 持久层框架：MyBatis 3.3
* 数据库连接池：Druid 1.0

## 软件需求
* JDK1.7+
* MySQL5.5+
* Tomcat7.0+
* Maven3.0+

