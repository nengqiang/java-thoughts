# java-thoughts
 * Java Hodgepodge（Java大杂烩）

## -- contents --
 
### popular-tech module
 * Contains the latest, latest and hottest technologies
   * blockchain   
   See [blockchain](https://baike.baidu.com/item/区块链/13465666?fr=aladdin)
   * java date new api: The new date api of JDK8
 
### design-patterns module
 * When writing code, there will always be a lot of if...else, or case. If you include more than 
 one conditional statement in a conditional statement, the code will become bloated, the cost of maintenance will increase, 
 and the strategy mode will solve this problem better.    
 
 --- 
 
 **Strategy mode**
 * The strategy pattern defines a set of algorithms and encapsulates each algorithm so that they can be 
 replaced with each other, allowing the algorithm to change independently of the client using it.
 * Analysis of the definition, the strategy pattern defines and encapsulates a series of algorithms, 
 they can be replaced, that is, they have commonality, and their commonality is reflected in the behavior of the 
 policy interface, and in order to achieve the purpose of the last sentence That is, letting the algorithm 
 change independently of the client that uses it, we need to make the client depend on the policy interface.
 * The usage situation of the strategy mode:  
   * 1.A variety of treatments for the same type of problem, only when there are differences in specific behaviors;  
   * 2.Need to safely package multiple operations of the same type;  
   * 3.When the same abstract class has multiple subclasses, you need to use if-else or switch-case 
 to select a specific subclass.  
 * UML Class picture:  
 ![Image text](images/strategyMode.png)  
 * This pattern involves three roles:  
   * Context role: Hold a reference to a Strategy.  
   * Abstract strategy: This is an abstract role, usually implemented by an interface or abstract class. 
 This role gives the interfaces required for all specific policy classes.  
   * ConcreteStrategy role: Wraps related algorithms or behaviors. 
 
 ---
 
 **Factory mode（工厂模式）**
 * Intent: Define an interface to create an object, let its subclasses decide which factory class to instantiate, 
 and the factory mode delays the creation process to subclasses.  
 （意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。）
 * The main solution: mainly solve the problem of interface selection.  
 （主要解决：主要解决接口选择的问题。）
 * When to use: We explicitly plan to create different instances under different conditions.  
 （何时使用：我们明确地计划不同条件下创建不同实例时。）
 * How to solve: Let its subclass implement the factory interface, and return an abstract product.  
 （如何解决：让其子类实现工厂接口，返回的也是一个抽象的产品。）
 * Key code: The creation process is performed in its subclasses.  
 （关键代码：创建过程在其子类执行。）
 * Application examples: 1. You need a car, you can pick up the goods directly from the factory, instead of how to make 
 the car, and the specific implementation of the car. 2, Hibernate to change the database just need to change dialects and drivers.    
 （应用实例： 1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。 2、Hibernate 换数据库只需换方言和驱动就可以。）
 * Advantages: 1. A caller wants to create an object, as long as he knows its name. 2, high scalability, if you want to 
 add a product, just extend a factory class. 3. The specific implementation of the shielded product, 
 the caller only cares about the interface of the product.  
 （优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 3、屏蔽产品的具体实现，调用者只关心产品的接口。）
 * Disadvantages: Each time you add a product, you need to add a concrete class and object to implement the factory, 
 so that the number of classes in the system is multiplied, which increases the complexity of the system to a certain extent, 
 and also increases the system specific class rely. This is not a good thing.  
 （缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。）
 * Usage scenarios: 1. Logger: The record may be recorded to the local hard disk, system events, remote server, etc. 
 The user can choose where to log the log. 2, database access, when the user does not know which type of database the system uses, 
 and the database may change. 3, design a framework to connect to the server, you need three protocols, "POP3", "IMAP", "HTTP",
 you can use these three as a product class to achieve an interface.  
 （使用场景： 1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。 2、数据库访问，当用户不知道
 最后系统采用哪一类数据库，以及数据库可能有变化时。 3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。）
 * Note: As a way to create a class, you can use the factory method mode wherever you need to generate complex objects. 
 One thing to note is that complex objects are suitable for factory mode, while simple objects, especially those that only 
 need to be created by new, do not need to use factory mode. If you use the factory pattern, you need to introduce a factory class, 
 which will increase the complexity of the system.  
 （注意事项：作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，
 而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。）    
 * UML Class picture:  
 ![Image text](images/factoryMode.png)   
  
 ---
  
 **Abstract Factory Pattern(抽象工厂模式)**
 * The Abstract Factory Pattern creates other factories around a super factory. This super factory is also known as the 
 factory of other factories. This type of design pattern is a creative model that provides the best way to create objects.  
 In abstract factory mode, an interface is a factory that is responsible for creating a related object, without explicitly 
 specifying their class. Each generated factory can provide objects in factory mode.   
 （抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，
 它提供了一种创建对象的最佳方式。在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。）  
 * Intent: Provides an interface to create a series of related or interdependent objects without specifying their specific classes.  
 （意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。）  
 * The main solution: mainly solve the problem of interface selection.  
 （主要解决：主要解决接口选择的问题。）
 * When to use: The system's products have more than one product family, and the system consumes only one of the products.  
 （何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。）
 * How to solve: Define multiple products in one product family.  
 （如何解决：在一个产品族里面，定义多个产品。）
 * Key code: Aggregate multiple products in one factory.  
 （关键代码：在一个工厂里聚合多个同类产品。）
 * Application example: Work, in order to participate in some gatherings, there must be two or more sets of clothes, 
 such as business wear (set, a series of specific products), fashion (set, a series of specific products), even for a 
 family In terms of business women's wear, business men's wear, fashion women's wear, fashion men's wear, these are also 
 complete sets, that is, a series of specific products. Suppose a situation (in reality, it doesn't exist, otherwise it 
 can't enter communism, but it helps to illustrate the abstract factory model). In your home, a certain wardrobe 
 (specific factory) can only store one kind of this. The clothes (set, a series of specific products), naturally take 
 out this set of clothes every time from the wardrobe. Understand the idea of ​​OO, all the wardrobes (specific factories) 
 are one of the wardrobe type (abstract factory), and each set of clothes includes a specific top (a specific product), 
 pants (a specific Products), these specific tops are actually tops (abstract products), and the specific pants are also 
 pants (another abstract product).  
 （应用实例：工作了，为了参加一些聚会，肯定有两套或多套衣服吧，比如说有商务装（成套，一系列具体产品）、时尚装（成套，一系列具体产品），
 甚至对于一个家庭来说，可能有商务女装、商务男装、时尚女装、时尚男装，这些也都是成套的，即一系列具体产品。假设一种情况（现实中是不存在的，
 要不然，没法进入共产主义了，但有利于说明抽象工厂模式），在您的家中，某一个衣柜（具体工厂）只能存放某一种这样的衣服（成套，一系列具体产品），
 每次拿这种成套的衣服时也自然要从这个衣柜中取出了。用 OO 的思想去理解，所有的衣柜（具体工厂）都是衣柜类的（抽象工厂）某一个，而每一件成套
 的衣服又包括具体的上衣（某一具体产品），裤子（某一具体产品），这些具体的上衣其实也都是上衣（抽象产品），具体的裤子也都是裤子（另一个抽象产品）。）
 * Advantage: When multiple objects in a product family are designed to work together, it ensures that the client 
 always uses only objects from the same product family.  
 （优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。）
 * Disadvantages: Product family extension is very difficult. To add a product in a series, you need to add code in the 
 abstract Creator and add code in the specific one.  
 （缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。）
 * Usage scenarios: 1, QQ for skin, a whole set together. 2. Generate programs for different operating systems.  
 （使用场景： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。）
 * Note: The product family is difficult to expand, and the product level is easy to expand.  
 （注意事项：产品族难扩展，产品等级易扩展。）
 * UML Class picture:  
 ![Image text](images/abstractFactoryMode.jpg)
 
 ---
 
 **Singleton Pattern(单例模式)**
 * The Singleton Pattern is one of the simplest design patterns in Java. This type of design pattern is a creative model 
 that provides the best way to create objects.  
 This pattern involves a single class that is responsible for creating your own objects while ensuring that only a 
 single object is created. This class provides a way to access its unique object, which can be accessed directly without 
 the need to instantiate an object of that class.  
 (单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
  这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，
  可以直接访问，不需要实例化该类的对象。)
 * note:
   1. A singleton class can only have one instance.
   2. The singleton class must create its own unique instance.
   3. The singleton class must provide this instance to all other objects.  
 (注意： 1、单例类只能有一个实例。2、单例类必须自己创建自己的唯一实例。3、单例类必须给所有其他对象提供这一实例。)
 * Intent: Ensure that a class has only one instance and provides a global access point to access it.  
 (意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。)
 * The main solution: a globally used class is frequently created and destroyed.  
 (主要解决：一个全局使用的类频繁地创建与销毁。)
 * When to use: When you want to control the number of instances and save system resources.  
 (何时使用：当您想控制实例数目，节省系统资源的时候。)
 * How to solve: Determine whether the system already has this singleton, if it is, return it, if not, create it.  
 (如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。)
 * Key code: The constructor is private.  
 (关键代码：构造函数是私有的。)
 * Application examples: 1. A party can only have one secretary. 2, Windows is multi-process multi-threaded, when 
 operating a file, it is inevitable that multiple processes or threads operate a file at the same time, so all files 
 must be processed through a unique instance. 3, some device managers are often designed as a single-case mode, such as 
 a computer with two printers, the output must be processed when two printers can not print the same file.  
 (应用实例： 1、一个党只能有一个书记。 2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个
 文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，
 在输出的时候就要处理不能两台打印机打印同一个文件。)
 * Advantages: 1. There is only one instance in memory, which reduces the memory overhead, especially the frequent 
 creation and destruction of instances (such as the management college home page cache). 2. Avoid multiple occupations 
 of resources (such as writing file operations).  
 (优点： 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 
 2、避免对资源的多重占用（比如写文件操作）。)
 * Disadvantages: No interface, no inheritance, conflict with a single responsibility principle, a class should only 
 care about internal logic, and not care about how to instantiate it outside.  
 (缺点：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。)
 * Usage scenarios: 1. Request to produce a unique serial number. 2, the counter in the WEB, do not need to be added once 
 in the database every time you refresh, use a single case to cache first. 3. An object created needs to consume too 
 many resources, such as the connection of I/O to the database.  
 (使用场景： 1、要求生产唯一序列号。 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 
 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。)
 * Note: The getInstance() method needs to use the synchronous lock synchronized (Singleton.class) to prevent multiple 
 threads from entering at the same time, causing the instance to be instantiated multiple times.  
 (注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。)
 * UML Class picture:    
 ![Image text](images/singletonMode.png)  
 
 ---
 
 **Builder Pattern**(建造者模式)
 * The Builder Pattern uses a number of simple objects to build a complex object step by step. This type of design 
 pattern is a creative model that provides the best way to create objects.  
 A Builder class will construct the final object step by step. The Builder class is independent of other objects.  
 (建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，
 它提供了一种创建对象的最佳方式。一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。)
 * Intent: Separating a complex build from its representation so that the same build process can create 
 different representations.  
 (意图：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。)
 * The main solution: mainly in the software system, sometimes faced with the creation of "a complex object", which is 
 usually composed of sub-objects of various parts with certain algorithms; due to changes in requirements, the various 
 parts of this complex object are often faced Dramatic changes, but the algorithm that combines them is relatively stable.  
 (主要解决：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，
 这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。)
 * When to use: Some basic components do not change, and their combinations often change.  
 (何时使用：一些基本部件不会变，而其组合经常变化的时候。)
 * How to solve: separate the change from the constant.  
 (如何解决：将变与不变分离开。)
 * Key Code: Builder: Create and provide instances, Director: Manage dependencies for built instances.  
 (关键代码：建造者：创建和提供实例，导演：管理建造出来的实例的依赖关系。)
 * Application examples: 1. Going to KFC, hamburger, cola, French fries, fried chicken wings, etc. are unchanged, and the 
 combination is constantly changing, producing a so-called "package". 2. StringBuilder in JAVA.  
 (应用实例： 1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。2、JAVA 中的 StringBuilder。)
 * Advantages: 1. The builder is independent and easy to expand. 2, easy to control the details of the risk.  
 (优点： 1、建造者独立，易扩展。 2、便于控制细节风险。)
 * Disadvantages: 1. products must have in common, the scope is limited. 2. If the internal changes are complicated, 
 there will be many construction classes.  
 (缺点： 1、产品必须有共同点，范围有限制。 2、如内部变化复杂，会有很多的建造类。)
 * Usage scenarios: 1. The objects that need to be generated have a complex internal structure. 2. The internal 
 properties of the objects that need to be generated depend on each other.  
 (使用场景： 1、需要生成的对象具有复杂的内部结构。 2、需要生成的对象内部属性本身相互依赖。)
 * Note: The difference from the factory model is that the builder mode pays more attention to the order of assembly 
 of the parts.  
 (注意事项：与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。)
 * UML Class picture:    
 ![Image text](images/builderPattern.jpg)  










