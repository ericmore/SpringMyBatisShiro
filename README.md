# SpringMyBatisShiro
* [spring-boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [mybatis](https://github.com/mybatis/spring-boot-starter)
* [druid](https://github.com/alibaba/druid)
* [shiro](http://shiro.apache.org/)
* [redis](http://redis.io/)

> * 项目启动后输入：http://localhost/
> * 该项目中, 增加了对url的拦截[URLPermissionsFilter](https://github.com/leelance/spring-boot-all/blob/master/spring-boot-shiro/src/main/java/com/lance/shiro/config/URLPermissionsFilter.java)，
> * 用admin/123456,拥有index权限reports未任何权限, lance/123456尚未分配任何权限.
> * 参考[schema.sql](https://github.com/leelance/spring-boot-all/blob/master/spring-boot-shiro/src/main/resources/init-sql/schema.sql)
> * shiro Cache交于Redis进行管理
> * SpringBoot整合A.CTable [配置](https://www.jianshu.com/p/25db002b0367) [源代码](https://gitee.com/sunchenbin/mybatis-enhance
)
> * 本项目配合Angular 2+ ，实现SPA(single page applications)的CROS认证控制

 
## 启动环境
### 安装mysql 5.7.x community server
```jshelllanguage

cd C:\software\mysql-5.7.22-winx64\
mysqld --initialize
mysqld -install 
开启MySQL服务：net start mysql 
root用户登录MySQL：mysql -u root -p 
登录密码：（输入临时密码）

修改mysql root密码为1234
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('1234');

CREATE DATABASE ipan

```
### 安装redis
下载链接,windows版本，无需设置密码 [download](https://github.com/MicrosoftArchive/redis/releases)

### Web端使用Angular 2 [源代码链接](https://github.com/ericmore/admin-angular)

### MyBatis自动生成表结构参考代码
```java
Sample Entity
@Table(name = "test")
public class Test extends BaseModel{

   private static final long serialVersionUID = 5199200306752426433L;

   @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
   private Integer    id;

   @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
   private String name;

   @Column(name = "description",type = MySqlTypeConstant.TEXT)
   private String description;

   @Column(name = "create_time",type = MySqlTypeConstant.DATETIME)
   private Date   create_time;

   @Column(name = "update_time",type = MySqlTypeConstant.DATETIME)
   private Date   update_time;

   @Column(name = "number",type = MySqlTypeConstant.BIGINT,length = 5)
   private Long   number;

   @Column(name = "lifecycle",type = MySqlTypeConstant.CHAR,length = 1)
   private String lifecycle;

   @Column(name = "dekes",type = MySqlTypeConstant.DOUBLE,length = 5,decimalLength = 2)
   private Double dekes;
}
```
