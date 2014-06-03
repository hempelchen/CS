1.Server端，建议采用Eclipse加载，并自建 Tomcat 的web服务来加载 API 等 servlet；
2.Client端，请使用 https://github.com/hempelchen/helloworld 里的 “Get/Post 测试”功能来验证
3.在客户端端，一般通过 http://server:port/webAppPrefix/servletUrl 来访问 servlet，其中
	webAppPrefix: 一般是项目名字，更具体的是： server/Common/.settings/org.eclipse.wst.common.component 里的 "context-root"定义的 value 值；或者通过Eclipse 环境的 Properties->Web Project Settings-> Content root 设置的值
	servlet 是 WebContent->WEB-INF->web.xml里<servlet-mapping> 定义的 <url-pattern> 值
