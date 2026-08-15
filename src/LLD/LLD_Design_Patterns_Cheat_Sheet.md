# LLD Design Patterns — Ultimate Interview Cheat Sheet

# 1. Singleton Pattern

## Intent

Ensure only one object exists.

---

## Use Cases

* Logger
* DB Connection Pool
* Cache
* Config Manager

---

## Best Version in Java

Bill Pugh Singleton

```java
class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

---

## Interview Points

* Thread-safe
* Lazy loading
* Prevent multiple objects

---

## Memory Trick

“One object globally.”

---

# 2. Factory Pattern

## Intent

Create objects without exposing creation logic.

---

## Use Cases

* Notification systems
* Payment gateways
* UI components

---

## Structure

```text
Client → Factory → Object
```

---

## Example

```java
interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() {}
}

class NotificationFactory {
    public Notification create(String type) {
        if(type.equals("EMAIL")) {
            return new EmailNotification();
        }
        return null;
    }
}
```

---

## Interview Points

* Removes if-else from client
* Centralized object creation
* Loose coupling

---

## Memory Trick

“Factory creates objects.”

---

# 3. Abstract Factory Pattern

## Intent

Create families of related objects.

---

## Use Cases

* Cross-platform UI
* Theme systems
* Database families

---

## Example

```text
WindowsFactory
 ├── WindowsButton
 └── WindowsCheckbox
```

---

## Difference from Factory

| Factory            | Abstract Factory                |
| ------------------ | ------------------------------- |
| Creates one object | Creates related object families |

---

## Memory Trick

“Factory of factories.”

---

# 4. Builder Pattern

## Intent

Construct complex objects step-by-step.

---

## Use Cases

* Immutable objects
* Lombok Builder
* HTTP Request builders

---

## Example

```java
User user = User.builder()
        .name("Swati")
        .age(24)
        .build();
```

---

## Interview Points

* Avoid constructor explosion
* Readable object creation
* Immutable support

---

## Memory Trick

“Build object step-by-step.”

---

# 5. Prototype Pattern

## Intent

Clone existing objects.

---

## Use Cases

* Expensive object creation
* Game development
* Template duplication

---

## Example

```java
User copy = original.clone();
```

---

## Interview Points

* Deep copy vs shallow copy
* Improves performance

---

## Memory Trick

“Copy existing object.”

---

# 6. Adapter Pattern

## Intent

Convert incompatible interfaces.

---

## Use Cases

* Legacy systems
* Payment gateway integration
* XML → JSON conversion

---

## Structure

```text
Client → Adapter → Legacy System
```

---

## Interview Points

* Structural pattern
* Composition preferred
* Used heavily in integrations

---

## Memory Trick

“Bridge incompatible systems.”

---

# 7. Decorator Pattern

## Intent

Add behavior dynamically.

---

## Use Cases

* Java IO Streams
* Coffee toppings
* Middleware systems

---

## Example

```text
Coffee
 + Milk
 + Sugar
```

---

## Interview Points

* Alternative to inheritance
* Runtime behavior addition

---

## Memory Trick

“Wrap and enhance.”

---

# 8. Facade Pattern

## Intent

Provide simplified interface to complex subsystem.

---

## Use Cases

* Spring Boot
* Payment workflow
* Home theater system

---

## Example

```text
Client → Facade → Multiple services
```

---

## Interview Points

* Hides complexity
* Simplifies usage

---

## Memory Trick

“One simple entry point.”

---

# 9. Proxy Pattern

## Intent

Control access to object.

---

## Use Cases

* Lazy loading
* Security
* Caching
* API gateways

---

## Types

* Virtual Proxy
* Security Proxy
* Remote Proxy

---

## Memory Trick

“Middleman controls access.”

---

# 10. Bridge Pattern

## Intent

Separate abstraction from implementation.

---

## Use Cases

* Device + Remote
* Payment + Provider

---

## Example

```text
Remote → TV
Remote → AC
```

---

## Interview Points

* Prevents class explosion

---

## Memory Trick

“Separate abstraction and implementation.”

---

# 11. Composite Pattern

## Intent

Treat group of objects same as single object.

---

## Use Cases

* File systems
* Organization hierarchy
* Menu systems

---

## Example

```text
Folder
 ├── File
 └── Folder
```

---

## Memory Trick

“Tree structure pattern.”

---

# 12. Flyweight Pattern

## Intent

Share common objects to save memory.

---

## Use Cases

* String pool
* Game particles
* Character rendering

---

## Interview Points

* Intrinsic vs extrinsic state

---

## Memory Trick

“Reuse shared objects.”

---

# 13. Strategy Pattern

## Intent

Switch algorithms dynamically.

---

## Use Cases

* Payment methods
* Sorting strategies
* Route selection

---

## Example

```text
PaymentStrategy
 ├── UPI
 ├── Card
 └── Wallet
```

---

## Interview Points

* Behavioral pattern
* Removes giant if-else

---

## Memory Trick

“Change behavior at runtime.”

---

# 14. Observer Pattern

## Intent

Notify multiple objects automatically.

---

## Use Cases

* Kafka consumers
* Event systems
* Stock price updates
* YouTube subscriptions

---

## Structure

```text
Subject → Observers
```

---

## Interview Points

* One-to-many dependency
* Event-driven systems

---

## Memory Trick

“Publish-subscribe model.”

---

# 15. Command Pattern

## Intent

Encapsulate request as object.

---

## Use Cases

* Undo/Redo
* Remote controls
* Queue systems

---

## Example

```text
Invoker → Command → Receiver
```

---

## Interview Points

* Decouples sender and receiver
* Supports undo operations

---

## Memory Trick

“Action wrapped as object.”

---

# 16. State Pattern

## Intent

Change behavior based on internal state.

---

## Use Cases

* ATM machine
* Order status
* Traffic lights

---

## Example

```text
Order:
Created → Paid → Shipped → Delivered
```

---

## Memory Trick

“Object changes behavior with state.”

---

# 17. Template Method Pattern

## Intent

Define algorithm skeleton.

---

## Use Cases

* Frameworks
* Game engines
* Spring lifecycle

---

## Example

```java
final void process() {
   step1();
   step2();
}
```

---

## Memory Trick

“Fixed flow, customizable steps.”

---

# 18. Chain of Responsibility

## Intent

Pass request through chain of handlers.

---

## Use Cases

* Logging
* Spring Security filters
* Approval systems

---

## Example

```text
Auth → Validation → Business Logic
```

---

## Memory Trick

“Pass request along chain.”

---

# 19. Mediator Pattern

## Intent

Centralize communication.

---

## Use Cases

* Chat room
* Air traffic control
* Event coordinators

---

## Memory Trick

“One central coordinator.”

---

# 20. Iterator Pattern

## Intent

Traverse collection without exposing internals.

---

## Use Cases

* Java Iterator
* Tree traversal

---

## Memory Trick

“Sequential traversal.”

---

# 21. Visitor Pattern

## Intent

Add operations without modifying classes.

---

## Use Cases

* Compiler design
* AST traversal
* Reporting systems

---

## Memory Trick

“Add operation externally.”

---

# MOST IMPORTANT INTERVIEW DIFFERENCES

# Strategy vs State

| Strategy                 | State                        |
| ------------------------ | ---------------------------- |
| Client changes behavior  | Object changes automatically |
| Runtime algorithm switch | State-driven behavior        |

---

# Adapter vs Facade

| Adapter            | Facade               |
| ------------------ | -------------------- |
| Converts interface | Simplifies subsystem |
| Compatibility      | Simplicity           |

---

# Decorator vs Proxy

| Decorator     | Proxy           |
| ------------- | --------------- |
| Adds behavior | Controls access |

---

# Factory vs Builder

| Factory                 | Builder             |
| ----------------------- | ------------------- |
| Creates object directly | Builds step-by-step |

---

# MUST-REMEMBER HIGH-FREQUENCY PATTERNS

## VERY IMPORTANT

* Singleton
* Factory
* Strategy
* Observer
* Builder
* Adapter
* Decorator
* Command
* State

---

# COMMONLY ASKED REAL EXAMPLES

| Pattern   | Real Example                |
| --------- | --------------------------- |
| Singleton | Logger                      |
| Factory   | Notification service        |
| Strategy  | Payment methods             |
| Observer  | Kafka subscribers           |
| Adapter   | Payment gateway integration |
| Decorator | Java IO streams             |
| Proxy     | API gateway                 |
| Command   | Undo/Redo                   |
| State     | Order lifecycle             |
| Builder   | Lombok Builder              |

---

# MASTER MEMORY TRICKS

| Pattern   | Cheat Code            |
| --------- | --------------------- |
| Singleton | One object            |
| Factory   | Create object         |
| Builder   | Step-by-step creation |
| Adapter   | Convert interface     |
| Decorator | Add behavior          |
| Facade    | Simplify system       |
| Proxy     | Control access        |
| Strategy  | Change algorithm      |
| Observer  | Notify subscribers    |
| Command   | Wrap action           |
| State     | Behavior by state     |
| Composite | Tree hierarchy        |
| Flyweight | Save memory           |
| Bridge    | Separate abstraction  |
| Chain     | Pass request          |

---

# Final Interview Advice

When explaining ANY design pattern:

Always say:

1. Problem
2. Why existing solution fails
3. How pattern solves it
4. Real-world example
5. Advantages
6. Tradeoffs

This structure alone makes answers sound senior-level.
