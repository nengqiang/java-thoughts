# java-thoughts
 * Java Hodgepodge（Java大杂烩）

## -- contents --
 
### popular-tech module
 * Contains the latest, latest and hottest technologies
   * blockchain   
   See [blockchain](https://baike.baidu.com/item/区块链)
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
 ![Image text](images/builderMode.jpg)  

---

 **Prototype Pattern(原型模式)**
 * The Prototype Pattern is used to create duplicate objects while maintaining performance. This type of design pattern 
 is a creative model that provides the best way to create objects.  
 This pattern implements a prototype interface that is used to create clones of the current object. This mode is used 
 when the cost of directly creating an object is relatively large. For example, an object needs to be created after a 
 high-cost database operation. We can cache the object, return its clone on the next request, and update the database 
 when needed to reduce database calls.  
 (原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
  这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。例如，一个对象需要在一个高
  代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。)
 * Intent: Use the prototype instance to specify the kind of objects to be created, and create new objects by copying them.  
 (意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。)
 * The main solution: build and delete prototypes at runtime.  
 (主要解决：在运行期建立和删除原型。)
 * When to use: 1.When a system should be created, represented and represented independently of its products. 
 2.When the class to be instantiated is specified at runtime, for example, by dynamic loading. 
 3.To avoid creating a factory class hierarchy that is parallel to the product class hierarchy. 4.When an instance of 
 a class can only have one of several different combinations of states. Creating the appropriate number of prototypes 
 and cloning them may be more convenient than manually instantiating the class with the appropriate state each time.  
 (何时使用： 1、当一个系统应该独立于它的产品创建，构成和表示时。 2、当要实例化的类是在运行时刻指定时，例如，通过动态装载。 3、为了避免
 创建一个与产品类层次平行的工厂类层次时。 4、当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比
 每次用合适的状态手工实例化该类更方便一些。)
 * How to solve: Using an existing prototype object, quickly generate the same instance as the prototype object.  
 (如何解决：利用已有的一个原型对象，快速地生成和原型对象一样的实例。)
 * Key code: 1.Implement the cloning operation, inherit Cloneable in JAVA, override clone(), and use the 
 MemberwiseClone() method of the Object class in .NET to implement a shallow copy of the object or serialize to achieve 
 deep copy. 2.the prototype mode is also used to isolate the coupling between the user of the class object and the 
 specific type (variable class), it also requires these "variable classes" to have a stable interface.  
 (关键代码： 1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()，在 .NET 中可以使用 Object 类的 MemberwiseClone() 方法来实现
 对象的浅拷贝或通过序列化的方式来实现深拷贝。 2、原型模式同样用于隔离类对象的使用者和具体类型（易变类）之间的耦合关系，它同样要求这些
 "易变类"拥有稳定的接口。)
 * Application examples: 1. Cell division. 2. The Object clone() method in JAVA.  
 (应用实例： 1、细胞分裂。 2、JAVA 中的 Object clone() 方法。)
 * Advantages: 1. Performance improvement. 2. Escape the constraints of the constructor.  
 (优点： 1、性能提高。 2、逃避构造函数的约束。)
 * Disadvantages: 1.equipped with a cloning method requires a comprehensive consideration of the function of the class, 
 which is not difficult for a new class, but not necessarily easy for existing classes, especially when a class 
 reference does not support serialized indirect objects, Or when the reference contains a loop structure. 
 2.The Cloneable interface must be implemented.  
 (缺点： 1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的
 间接对象，或者引用含有循环结构的时候。 2、必须实现 Cloneable 接口。)
 * Usage scenarios: 1.Resource optimization scenarios. 2.class initialization needs to digest a lot of resources, 
 this resource includes data, hardware resources and so on. 3.Scenarios for performance and security requirements. 
 4.Prototype mode can be used when generating an object via new requires very tedious data preparation or access. 
 5.A scene of multiple modifiers of an object. 6, an object needs to be provided to other objects to access, and each caller 
 may need to modify its value, you can consider using the prototype mode to copy multiple objects for the caller to use. 
 7.in the actual project, the prototype mode rarely appears alone, usually with the factory method pattern, create an 
 object through the clone method, and then provided to the caller by the factory method. The prototype mode has been 
 integrated with Java and can be used at your fingertips.  
 (使用场景： 1、资源优化场景。 2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。 3、性能和安全要求的场景。 4、通过 new 
 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。 5、一个对象多个修改者的场景。 6、一个对象需要提供给其他对象访问，
 而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。 7、在实际项目中，原型模式很少单独出现，一般是和工厂
 方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与 Java 融为浑然一体， 我们可以随手拿来使用。)
 * Note: Unlike constructing a new object by instantiating a class, the prototype pattern generates a new object by 
 copying an existing object. Shallow copy implementations Cloneable, rewrite, and deep copy are binary streams that are 
 read by implementing Serializable.  
 (注意事项：与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。浅拷贝实现 Cloneable，重写，
 深拷贝是通过实现 Serializable 读取二进制流。)
 * UML Class picture:    
 ![Image text](images/prototypeMode.jpg)  

---

**Adapter Pattern(适配器模式)**
 * The Adapter Pattern is a bridge between two incompatible interfaces. This type of design pattern is a structured 
 model that combines the functionality of two separate interfaces.  
 This pattern involves a single class that is responsible for adding independent or incompatible interface functions. As 
 a real example, the card reader acts as an adapter between the memory card and the notebook. You insert the memory card 
 into the card reader and insert the card reader into the notebook so that the memory card can be read from the notebook.
 We demonstrate the use of adapter mode with the following example. Among them, the audio player device can only play 
 mp3 files and play vlc and mp4 files by using a more advanced audio player.  
 (适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。  
  这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，读卡器是作为内存卡和笔记本之间的适配器。您将内存卡
  插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。  
  我们通过下面的实例来演示适配器模式的使用。其中，音频播放器设备只能播放mp3文件，通过使用一个更高级的音频播放器来播放vlc和mp4文件。)
 * Intent: Convert the interface of one class to another interface that the client wants. The adapter mode allows those 
 classes that would otherwise not work together due to incompatible interfaces to work together.  
 (意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。)
 * The main solution: mainly solve in the software system, often put some "existing objects" into the new environment, 
 and the interface required by the new environment is not satisfied by the current object.  
 (主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。)
 * When to use: 1.The system needs to use existing classes, and such interfaces do not meet the needs of the system.   
 2.You want to create a reusable class for working with classes that don't have much to do with each other, including 
 some that might be introduced in the future. These source classes don't necessarily have a consistent interface.   
 3.Insert a class into another class through interface conversion. (For example, tigers and birds, there is now a 
 flying tiger. Adding an adapter without increasing the physical requirements, and having a tiger object in it, realizes 
 the flying interface.)  
 (何时使用： 1、系统需要使用现有的类，而此类的接口不符合系统的需要。 2、想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的
 一些类，包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。 3、通过接口转换，将一个类插入另一个类系中。（比如老虎和飞禽，
 现在多了一个飞虎，在不增加实体的需求下，增加一个适配器，在里面包容一个虎对象，实现飞的接口。）)
 * How to solve: inheritance or dependency (recommended).  
 (如何解决：继承或依赖（推荐）。)
 * Key code: The adapter inherits or relies on existing objects to implement the desired target interface.  
 (关键代码：适配器继承或依赖已有的对象，实现想要的目标接口。)
 * Application examples: 1. American Electric 110V, China 220V, there must be an adapter to convert 110V to 220V. 
 2.JAVA JDK 1.1 provides the Enumeration interface, and the Iterator interface is provided in 1.2. If you want to use 
 the 1.2 JDK, you need to convert the previous system's Enumeration interface to the Iterator interface. In this case, 
 the adapter mode is required. 3. Run the WINDOWS program on LINUX. 4. jdbc in JAVA.  
 (应用实例： 1、美国电器 110V，中国 220V，就要有一个适配器将 110V 转化为 220V。 2、JAVA JDK 1.1 提供了 Enumeration 接口，
 而在 1.2 中提供了 Iterator 接口，想要使用 1.2 的 JDK，则要将以前系统的 Enumeration 接口转化为 Iterator 接口，这时就需要适配器模式。 
 3、在 LINUX 上运行 WINDOWS 程序。 4、JAVA 中的 jdbc。)
 * Advantages: 1. You can run any two unrelated classes together. 2. Improve the reuse of classes. 3. Increase the 
 transparency of the class. 4. Good flexibility.  
 (优点： 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。)
 * Disadvantages: 1. Excessive use of the adapter will make the system very messy and difficult to grasp. For example, 
 it is obvious that the call to the A interface is actually adapted to the implementation of the B interface. If a 
 system has too many such situations, it is tantamount to a disaster. So if it's not necessary, you can refactor the 
 system without using an adapter. 2. Since JAVA inherits at most one class, at most one adaptor class can be adapted, 
 and the target class must be an abstract class.  
 (缺点： 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，
 一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。 2.由于 JAVA 至多
 继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。)
 * Usage scenario: Motivated to modify the interface of a functioning system, then you should consider using the 
 adapter mode.  
 (使用场景：有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。)
 * Note: Adapters are not added at the time of detailed design, but rather to solve problems in the project being served.
 (注意事项：适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。)
 * UML Class picture:    
 ![Image text](images/adapterMode.png) 
 
 ---
 
 **Bridge Pattern(桥接模式)**
 * Bridge is used to decouple abstraction and implementation so that the two can change independently. This type of 
 design pattern is a structured pattern that provides decoupling between the two by providing a bridge between the 
 abstraction and the implementation.  
 This pattern involves an interface that acts as a bridge, making the functionality of the entity class independent of 
 the interface implementation class. These two types of classes can be structurally changed without affecting each other.  
 We use the following example to demonstrate the use of the Bridge Pattern. Among them, you can use the same abstract 
 class method but different bridge implementation classes to draw circles of different colors.  
 (桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的
 桥接结构，来实现二者的解耦。
  这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。
  我们通过下面的实例来演示桥接模式（Bridge Pattern）的用法。其中，可以使用相同的抽象类方法但是不同的桥接实现类，来画出不同颜色的圆。) 
 * Intent: Separate the abstract part from the implementation part so that they can all change independently.  
 (意图：将抽象部分与实现部分分离，使它们都可以独立的变化。)
 * The main solution: in the case of a variety of possible changes, the use of inheritance will cause class explosion 
 problems, expansion is not flexible.  
 (主要解决：在有多种可能会变化的情况下，用继承会造成类爆炸问题，扩展起来不灵活。)
 * When to use: Implementing a system may have multiple angular classifications, each of which may change.  
 (何时使用：实现系统可能有多个角度分类，每一种角度都可能变化。)
 * How to solve: Separate this multi-angle classification, let them change independently, and reduce the coupling 
 between them.  
 (如何解决：把这种多角度分类分离出来，让它们独立变化，减少它们之间耦合。)
 * Key code: Abstract class dependent implementation class.  
 (关键代码：抽象类依赖实现类。)
 * Application examples: 1. Pig Bajie reincarnation from the captain of the canopy to the pig, the mechanism of 
 reincarnation will divide the world into two levels, namely: the soul and the flesh, the former is equivalent to 
 abstraction, and the latter is equivalent to realization. Through the delegation of functions, the creature calls the 
 function of the physical object so that the creature can dynamically select. 2. the switch on the wall, you can see the 
 switch is abstract, do not care how to achieve inside.  
 (应用实例： 1、猪八戒从天蓬元帅转世投胎到猪，转世投胎的机制将尘世划分为两个等级，即：灵魂和肉体，前者相当于抽象化，后者相当于实现化。
 生灵通过功能的委派，调用肉体对象的功能，使得生灵可以动态地选择。 2、墙上的开关，可以看到的开关是抽象的，不用管里面具体怎么实现的。)
 * Advantages: 1. Separation of abstraction and implementation. 2. Excellent expansion ability. 
 3.the implementation details are transparent to the customer.  
 (优点： 1、抽象和实现的分离。 2、优秀的扩展能力。 3、实现细节对客户透明。)
 * Disadvantages: The introduction of bridging mode will increase the understanding and design difficulty of the system. 
 Since the aggregation relationship is established in the abstraction layer, the developer is required to design and 
 program the abstraction.  
 (缺点：桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。)
 * Usage scenarios: 1. If a system needs to add more flexibility between the abstracted role and the concrete role of 
 the component, avoid establishing a static inheritance relationship between the two layers, and make them in the 
 abstraction layer through the bridge mode. Establish an association. 2. Bridging mode is especially useful for systems 
 that do not want to use inheritance or because the number of system classes increases dramatically because of 
 multi-level inheritance. 3. A class has two independently changing dimensions, and both dimensions need to be extended.  
 (使用场景： 1、如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式
 可以使它们在抽象层建立一个关联关系。 2、对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。 
 3、一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。)
 * Note: For two independently changing dimensions, using bridge mode is a good fit.  
 (注意事项：对于两个独立变化的维度，使用桥接模式再适合不过了。)
  * UML Class picture:    
  ![Image text](images/bridgeMode.png) 

 ---

 **Filter Pattern(过滤器模式)**
 * Filter Pattern or Criteria Pattern is a design pattern that allows developers to filter a set of objects using 
 different criteria and connect them by decoupling through logical operations. This type of design pattern is a 
 structured model that combines multiple standards to achieve a single standard.  
 (过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，通过
 逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。)
  * UML Class picture:    
  ![Image text](images/filterMode.jpg) 
  
 ---
 **Composite Pattern(组合模式)**
 * Composite Pattern, also known as partial ensemble, is used to treat a group of similar objects as a single object. 
 The combination mode combines objects according to a tree structure to represent parts and the overall hierarchy. 
 This type of design pattern is a structured pattern that creates a tree structure of object groups.  
 This pattern creates a class that contains its own set of objects. This class provides a way to modify the same set of 
 objects.  
 We use the following example to demonstrate the use of combined mode. The example demonstrates the hierarchy of 
 employees in an organization.  
 (组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示
 部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。
  这种模式创建了一个包含自己对象组的类。该类提供了修改相同对象组的方式。
  我们通过下面的实例来演示组合模式的用法。实例演示了一个组织中员工的层次结构。)
 * Intent: Combine objects into a tree structure to represent a "partial-total" hierarchy. The combined mode allows the 
 user to have consistency in the use of individual objects and composite objects.  
 (意图：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。)
 * The main solution: it blurs the concept of simple elements and complex elements in our tree structure problem. The 
 client can handle complex elements like simple elements, thus decoupling the internal structure of the client from the 
 complex elements.  
 (主要解决：它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与
 复杂元素的内部结构解耦。)
 * When to use: 1. You want to represent the part of the object - the overall hierarchy (tree structure). 2. You want 
 the user to ignore the difference between a composite object and a single object, and the user will uniformly use all 
 the objects in the composite structure.  
 (何时使用： 1、您想表示对象的部分-整体层次结构（树形结构）。 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。)
 * How to solve: The branches and leaves implement a unified interface, and the interface is combined inside the branches.  
 (如何解决：树枝和叶子实现统一接口，树枝内部组合该接口。)
 * Key code: The interface is combined inside the branch and contains the internal property List, which contains the Component.  
 (关键代码：树枝内部组合该接口，并且含有内部属性 List，里面放 Component。)
 * Application examples: 1. Arithmetic expressions include operands, operators, and another operand, where another 
 operator can also be an operand, an operator, and another operand. 2. In JAVA AWT and SWING, for Button and Checkbox 
 are leaves, and Container is a branch.  
 (应用实例： 1、算术表达式包括操作数、操作符和另一个操作数，其中，另一个操作符也可以是操作数、操作符和另一个操作数。 2、在 JAVA AWT 和 
 SWING 中，对于 Button 和 Checkbox 是树叶，Container 是树枝。)
 * Advantages: 1. High-level module calls are simple. 2. The nodes are free to increase.  
 (优点： 1、高层模块调用简单。 2、节点自由增加。)
 * Disadvantages: When using composite mode, its leaf and container declarations are implementation classes, 
 not interfaces, which violates the dependency inversion principle.  
 (缺点：在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。)
 * Use scenario: Part, overall scene, such as tree menu, file, folder management.  
 (使用场景：部分、整体场景，如树形菜单，文件、文件夹的管理。)
 * Note: The definition is a concrete class.  
 (注意事项：定义时为具体类。)
 * UML Class picture:    
 ![Image text](images/compositeMode.jpg)  



















