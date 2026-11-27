# Comparison of Event Notification Mechanisms in Java

| Feature | Custom Observer | java.util.Observer | PropertyChangeListener | JavaFX Bindings |
|---------|-----------------|--------------------|-----------------------|-----------------|
| **Push or Pull?** | Both possible | Pull | Push (carries old + new) | Push |
| **Is it deprecated?** | No | Yes (Java 9+) | No | No |
| **Requires inheritance?** | No (interface) | Yes (class) | No | No |
| **Thread-safe?** | Depends on you | No | Yes (with the right setup) | Yes |
| **Auto-generates boilerplate?** | No | No | Yes (via PropertyChangeSupport) | Yes |
| **Best for...** | Custom systems | Legacy code | JavaBeans / Swing | JavaFX apps |
| **Can have multiple listeners?** | Yes | Yes | Yes | Yes |
| **Can be typed to send any data?** | Yes | No (Object) | Yes (via generics not typical) | Yes |
| **Recommended today?** | Yes | No | Only for legacy | Yes |

## Which One Should You Use?
- For a **plain Java project with custom needs** → Custom Observer
- For a **JavaFX application** → JavaFX Bindings
- For **legacy code using JavaBeans** → PropertyChangeListener
- **Never** → java.util.Observer

## Self-Check Answers
1. The mechanism that carries both the old and new value of a property is **PropertyChangeListener**.
2. The mechanism that needs a helper class to manage the listener list is **PropertyChangeListener**, through PropertyChangeSupport.
3. The two recommended for modern Java are **Custom Observer** and **JavaFX Bindings**.
4. The deprecated mechanism that should be avoided is **java.util.Observer/Observable**.

## Demo output (PropertyChangeDemo)
```
Listener A: name changed from null to Alice
Listener B: noticed name is now Alice
Listener A: name changed from Alice to Bob
Listener B: noticed name is now Bob
```
