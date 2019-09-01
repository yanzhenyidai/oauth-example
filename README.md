# oauth-example
Oauth2简单的例子,本项目实现了授权和资源分离

#oauth-example-auth
如要运行需首先在application.yml中修改redis地址,Mysql地址可以为我提供的云数据库；

sys_user表主要做了一个用户名的校验,如需要实现更多功能,需要在impl下的UserServiceImpl中增加

运行AuthApplication后，在Postman中输入地址localhost:8081/oauth/token,输入信息可以在工程中的resouces下见截图

#oauth-example-resource
这个工程是为了实现资源分离做的示例,使用oauth-example-oauth中生成的token可以在这个工程下的请求路径中使用

运行AuthResourceConfig后,可以在浏览器地址栏中输入localhost:8082/test?access_token=oauth-example-auth工程中生成的token

如有问题可以联系我,邮箱：frank-tan@outlook.com