# Factory Patterns - Quick Interview Revision

## Simple Factory

* **One Factory → One Product**
* Uses **`if-else` / `switch`**
* ❌ Violates **OCP**
* Best for small/fixed applications

```text
NotificationFactory
    ├── SMS
    ├── Email
    └── Push
```

---

## Factory Method

* **One Factory → One Product**
* One factory per product
* ✔ No `if-else`
* ✔ Follows **OCP**

```text
SMSFactory   → SMSNotification
EmailFactory → EmailNotification
PushFactory  → PushNotification
```

**Use:** When object creation varies.

---

## Abstract Factory

* **One Factory → Family of Related Products**
* Factory creates multiple compatible objects
* ✔ OCP
* ✔ Easy to switch entire product family

```text
AWSFactory
 ├── Storage
 ├── Queue
 └── Database

AzureFactory
 ├── Storage
 ├── Queue
 └── Database
```

**Use:** SDKs, GUI, Themes, Cloud Providers.

---

# Comparison

| Pattern          | Creates            | `if-else` | OCP |
| ---------------- | ------------------ | --------- | --- |
| Simple Factory   | One Product        | ✅         | ❌   |
| Factory Method   | One Product        | ❌         | ✅   |
| Abstract Factory | Family of Products | ❌         | ✅   |

---

# Memory Trick 🧠

* **Simple Factory** → **One Factory → One Product → `if-else`**
* **Factory Method** → **Many Factories → One Product each**
* **Abstract Factory** → **Many Factories → Family of Products**

---

# Golden Interview Lines ⭐

* **Simple Factory:** *One factory decides which object to create.*
* **Factory Method:** *Each product has its own factory.*
* **Abstract Factory:** *One factory creates a family of related objects.*

> **Abstract Factory = Collection of related Factory Methods.**
