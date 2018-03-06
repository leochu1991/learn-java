### 功能：`aop` 创建自定义注解实现日志打印
#### `aop` 基本概念
+ 切面(`Aspect`) ：由切入点(`Pointcut`)和通知(`Advice`)组成，表示何地(切入点)、何时发生何事(通知) 
+ 切入点(`Pointcut`) ：表示切面“故事”的发生地点，例如作用于某个类或方法
+ 通知(`Advice`) ：表示切面执行的“故事”以及何时执行(`Before` , `After` , `AfterReturning` , `Around` , `AfterThrowing`)
+ 连接点(`JoinPoint`) ：程序执行通知的“时机”，即切入点表达式的具体位置，切入点由一系列连接点构成
+ 织入(`Weaving`) ：把切面“故事”应用到目标对象生成代理对象的过程，一般发生在编译时，类加载时，运行时三种阶段
#### `aop` 通知类型
+ `@Before` 前置通知(Before advice) ：在连接点(`JoinPoint`)之前执行的通知
+ `@After` 后置通知(After advice) ：在连接点退出时执行（正常返回或异常退出）
+ `@AfterReturning` 返回通知(After return advice) ：在连接点正常返回后执行
+ `@Around` 环绕通知(Around advice) ：包围连接点的通知，类似Filter的doFilter方法，在目标方法的调用前后完成自定义的行为，如打印日志，查询缓存
+ `@AfterThrowing` 异常通知(After throwing advice) ：在方法抛出异常后执行