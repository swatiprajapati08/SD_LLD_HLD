# Adapter Pattern — Interview Notes (Using Your XML → JSON Example)

---

# What is Adapter Pattern?

Adapter Pattern is a **structural design pattern** used to make two incompatible interfaces work together.

It acts as a bridge between:
- Existing system (legacy/third-party)
- New system/client expectations

---

# Real Problem in Your Example

The client expects:

```java
String getJsonData(String data);