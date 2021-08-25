# impression

#### 📚 项目介绍
impression 是一个基于SpringBoot+SpringData JPA+Thymeleaf+MySql开发的一套个人在线简历网站，主要用于在互联网上展示个人用户的基本信息。另外配套还开发了一套基于ant-design pro of vue的后台管理系统，采用了前后端分离的模式开发，主要用于对前台网站进行CRUD的操作。

#### 🛠️ 软件架构
1. 前台网站
   基于SpringBoot+Thymeleaf模板引擎的单体应用架构，将处理好的数据使用Thymeleaf表达式渲染到HTML中并展示到网页端显示。

2. 后台网站
   后台管理系统使用了前后端分离的开发模式，通过ant-design的后台脚手架工程快速搭建起一套CRUD的页面，用于管理前台网站上显示的数据。[impression-admin] (https://gitee.com/Bear_Girls/impression-admin)

#### 项目启动

1.  准备一个空的数据库`impression`（名称可自定义），随后运行项目即可。
---

#### 🍊 技术栈
##### 前端
[Bootstrap前台网站模板](http://www.bootstrapmb.com/)、HTML/CSS/JS/JQ、[阿里巴巴矢量图标库](https://www.iconfont.cn/)、[内容排版插件](https://github.com/sofish/typo.css)、[代码高亮显示插件](https://github.com/PrismJS/prism)。
##### 后端
Java11、SpringBoot、SpringData JPA、MySql8.0+、Thymeleaf、Lombok、joda-time、阿里云OSS、commonmark（Markdown格式化）

#### 🍺 项目功能
>  该项目分为首页、技能、博客、项目、其它（关于我）五个模块。
1. 首页面分别展示了技能、项目、博客和一些其它的简短内容，方便于快速检索。
2. 技能页面使用了分类加技术标签的样式展示技术栈，并可点击查看详情。
3. 博客模块用于展示个人记录的博客文章，点击并可跳转到详情页，详情页使用了Markdown格式化和代码高亮的显示效果。
4. 项目页面用于展示展示个人的技术项目，通过指定分类的可快速查询指定的项目，并可以点击查看详情页介绍信息。
5. 第五个模块是关于作者的一些其它介绍信息。


