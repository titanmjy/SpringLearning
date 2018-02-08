##Spring Framework


transaction配置步骤 
1. 配置事务管理器的bean
2. @EnableTransactionManagement，启用注解配置（等效于<tx:annotation-driven transaction-manager="txManager"/>） 
3. @Transactional注解响应dao层代码（等效于xml配置里的aop配置）
