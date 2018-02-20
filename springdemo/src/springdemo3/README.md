### 功能：实现 `spring` 的自定义标签
#### 主要步骤：
+ 创建一个组件，即 `pojo` 类
+ 定义 `xsd` 文件，描述组件内容
+ 创建一个 `java` 类，实现 `BeanDefinitionParser` 接口，解析 `xsd` 文件和组件定义
+ 创建一个 `handler` 类，扩展 `NameSpaceHandlerSupport` 类，将组件注册到 `spring` 容器
+ 添加 `spring.handlers` 和 `spring.schemas` 文件

#### 注意点：
+ `spring.handlers` , `spring.schema` 文件在 `classpath` 即 `src` 目录下的 `META-INF` 文件夹中
+ `ApplicationContext` 根据 `spring-customtag.xml` 文件中自定义标签的 `id` 获取 `bean`
+ `xsi:schemaLocation="namespaceUri *.xsd file's mapping` , 其中 `namespaceUri` 对应于自定义的名称空间，即 `targetNamespace` , `xmlns:myns` ,均为 `http://localhost/springdemo/springdemo3`