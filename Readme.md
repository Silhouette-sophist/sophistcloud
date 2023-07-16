## 版本依赖
https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

## nacos注册中心
通过本地虚拟机启动

## mysql、消息队列、redis都通过虚拟机启动

### mybatis plus整合
- 配置数据源
- code generate生成代码
- mapper文件要么设置MapperScan注解，或者在mapper接口文件上增加Mapper注解

### 整合redis
https://www.cnblogs.com/phlive/p/13437803.html
redis设置远程登录：https://blog.csdn.net/qq_39552993/article/details/113433319  https://blog.csdn.net/yxzone/article/details/114862063#:~:text=redis%E5%85%81%E8%AE%B8%E8%BF%9C%E7%A8%8B%E8%AE%BF%E9%97%AE%201%201%29%E6%89%93%E5%BC%80%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E6%8A%8A%E4%B8%8B%E9%9D%A2%E5%AF%B9%E5%BA%94%E7%9A%84%E6%B3%A8%E9%87%8A%E6%8E%89%202%202%29Redis%E9%BB%98%E8%AE%A4%E4%B8%8D%E6%98%AF%E4%BB%A5%E5%AE%88%E6%8A%A4%E8%BF%9B%E7%A8%8B%E7%9A%84%E6%96%B9%E5%BC%8F%E8%BF%90%E8%A1%8C%EF%BC%8C%E5%8F%AF%E4%BB%A5%E9%80%9A%E8%BF%87%E8%AF%A5%E9%85%8D%E7%BD%AE%E9%A1%B9%E4%BF%AE%E6%94%B9%EF%BC%8C%E4%BD%BF%E7%94%A8yes%E5%90%AF%E7%94%A8%E5%AE%88%E6%8A%A4%E8%BF%9B%E7%A8%8B%EF%BC%8C%E8%AE%BE%E7%BD%AE%E4%B8%BAno,3%203%29%E4%BF%9D%E6%8A%A4%E6%A8%A1%E5%BC%8F%204%204%29%20%E8%AE%BE%E7%BD%AE%E5%AF%86%E7%A0%81%20%28%E4%B8%8D%E5%BF%85%E9%A1%BB%29

### 整合rabbitmq
https://juejin.cn/s/ubuntu%20%E6%9F%A5%E7%9C%8B%E5%90%AF%E5%8A%A8%E7%9A%84%E6%9C%8D%E5%8A%A1
https://blog.csdn.net/luiluier/article/details/124167341#:~:text=%E5%85%AD%E3%80%81RabbitMQ%E7%9A%84%E5%90%AF%E5%8A%A8%E5%85%B3%E9%97%AD%E5%91%BD%E4%BB%A4%201%20%23%20%E5%85%B3%E9%97%AD%E5%91%BD%E4%BB%A4%202%20systemctl%20stop%20rabbitmq-server.service,rabbitmq-server.service%205%20%23%20%E9%87%8D%E5%90%AF%E5%91%BD%E4%BB%A4%206%20systemctl%20restart%20rabbitmq-server.service
https://blog.csdn.net/qq_39523111/article/details/104674332
https://blog.csdn.net/qq_39523111/article/details/104674332


在 Ubuntu 中，可以通过以下命令查看系统中已经启动的服务：

systemctl list-unit-files --type=service
上述命令会列出所有已经安装的服务，包括已经启动和未启动的服务。如果想要只显示已经启动的服务，可以在命令中添加 --state=running 参数，例如：

systemctl list-unit-files --type=service --state=running
此外，还可以使用以下命令查看系统中所有的服务及其状态：

service --status-all
以上命令列出了所有已安装的服务及其状态，包括启动的服务和未启动的服务。对于已启动的服务，会显示 [+] 符号；而对于未启动的服务，则会显示 [-] 符号。

## 链路追踪
Sleuth、zipkin、Skywalking等
https://repo1.maven.org/maven2/io/zipkin/zipkin-server/


## nginx和gateway职责区分


