###集成Mybatis Plus步骤
1.在pom. xm1文件引入相关的jar包依赖
2.实现XxxMapper接口。通过此接口来操作数据持久化
3.对XxxDO实体进行注解的定义，如:数据库表名，字段的定义
4.如需修改P1us默认配置，需实现MybatisPlusConfig类
5.如需要自定义一个方法，需实现XxxMapper.xml,来定义自定义sQI
###自动更新系统级字段
1.公共元数据处理器
2.为XxxDO配置注解
