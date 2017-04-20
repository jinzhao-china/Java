
# Life Cycle of a Servlet
servlet生命周期的核心就是3个方法:init()，service() 和 destroy()。它们由每个servlet实现，并在特定时间被服务器调用。
* servlet的生命周期的初始阶段，Web容器通过调用init()方法创建一个servlet实例，然后传入一个实现了javax.servlet.servletconfig接口的对象,此对象允许servlet访问web.xml中的初始参数。
* 初始化后，servlet实例开始等待客户端请求。每个请求都在其单独的线程中运行。Web容器调用servlet的service()方法。service()会判断请求的类型并调用适当的方法来处理请求。servlet的开发人员必须为这些方法提供一个实现。如果请求一个servlet未实现的方法，则调用父类的方法，但这通常会导致返回错误给请求者。
* 最后，当Servlet的服务结束后，Web容器调用destroy()方法来中止。destroy()方法 跟init()，在一个servlet的生命周期中，只会被调用一次。
以下是这些方法的典型用户场景。
假设用户请求访问URL。
浏览器然后为该URL生成HTTP请求。
然后将此请求发送到相应的服务器。
HTTP请求由web服务器接收并转发到servlet容器。
容器将此请求映射到特定servlet。
servlet被动态检索并加载到容器的地址空间中。
容器调用servlet的（）方法。
只有当servlet首次加载到内存中时才会调用此方法。
可以将初始化参数传递给servlet，以便它可以配置自身。
容器调用servlet的service()方法。
调用此方法处理HTTP请求。
servlet可以读取HTTP请求中提供的数据。
servlet还可以为客户端制定HTTP响应。
servlet保持在容器的地址空间中，可以处理来自客户端的任何其他HTTP请求。
的service()方法为每个HTTP请求。
容器可能在某一时刻决定从其内存中卸载servlet。
这个决定的算法是具体到每个容器。
容器调用servlet的destroy()法放弃任何资源如被分配为Servlet文件句柄；重要的数据可以被保存到持久性存储。
分配给servlet及其对象的内存可以被垃圾回收。
