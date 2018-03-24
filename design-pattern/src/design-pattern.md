# 设计模式

***Design Patterns - Elements of Reusable Object-Oriented Software*** （中文译名：设计模式 - 可复用的面向对象软件元素），总共有23种设计模式，分为3类， **创建型模式（Creational Patterns）**  ， **结构型模式（Structural Patterns）** ， **行为型模式（Behavioral Patterns）** 。还有一种 **J2EE** 设计模式。

### 创建型模式

> 在创建对象的同时隐藏创建逻辑的方式，不是使用 new 运算符直接实例化对象。
>
> - 工厂模式（Factory Pattern）
> - 抽象工厂模式（Abstract Factory Pattern）
> - 单例模式（Singleton Pattern）
> - 建造者模式（Builder Pattern）
> - 原型模式（Prototype Pattern）

### 结构型模式

>关注类和对象的组合。
>
>- 适配器模式（Adapter Pattern）
>- 桥接模式（Bridge Pattern）
>- ~~过滤器模式（Filter, Criteria Pattern）~~
>- 组合模式（Composite Pattern）
>- 装饰器模式（Decorator Pattern）
>- 外观模式（Facade Pattern）
>- 享元模式（Flyweight Pattern）
>- 代理模式（Proxy Pattern）

### 行为型模式

>关注对象之间的通信。
>
>- 责任链模式（Chain of Responsibility Pattern）
>- 命令模式（Command Pattern）
>- 解释器模式（Interpreter Pattern）
>- 迭代器模式（Iterator Pattern）
>- 中介者模式（Mediator Pattern）
>- 备忘录模式（Memento Pattern）
>- 观察者模式（Observer Pattern）
>- 状态模式（State Pattern）
>- ~~空对象模式（Null Object Pattern）~~
>- 策略模式（Strategy Pattern）
>- 模板模式（Template Pattern）
>- 访问者模式（Visitor Pattern）

### ~~J2EE模式~~

> 关注表示层。
>
> - MVC模式（MVC Pattern）
> - 业务代表模式（Business Delegate Pattern）
> - 组合实体模式（Composite Entity Pattern）
> - 数据访问对象模式（Data Access Object Pattern）
> - 前端控制器模式（Front Controller Pattern）
> - 拦截过滤器模式（Intercepting Filter Pattern）
> - 服务定位器模式（Service Locator Pattern）
> - 传输对象模式（Transfer Object Pattern）

---

### 设计模式的六大原则

> - 单一职责原则（Single Responsibility Principle，SRP）：一个类负责一个功能领域的职责。
>
> - 里氏替换原则（Liskov Substitution Principle，LSP）：子类替换父类时，父类功能不受影响。
>
> - 依赖倒置原则（Dependency Inversion  Principle，DIP）：抽象不应依赖于细节，细节依赖于抽象，即针对接口编程，这是开放-封闭原则的基础。
>
>   依赖注入（Dependency Injection，DI）：一个对象与其他对象发生依赖时，通过抽象注入所依赖的对象，即在接口方法中定义时使用抽象类型，在运行使用时传入具体类型，由子类对象覆盖父类对象。
>
> - 接口隔离原则（Interface  Segregation Principle，ISP）：使用多个隔离的接口，而不是单一的总接口，降低类间的耦合度，即客户端不依赖于它不需要的接口。
>
> - 迪米特法则（Law of  Demeter，LoD）：又称最少知识原则（Least Knowledge Principle，LKP），一个实体应该尽可能少地与其他实体发生相互作用，使得系统功能模块相对独立。
>
> - 开放封闭原则（Open Closed Principle，OCP）：一个软件实体应对扩展开放，对修改封闭。