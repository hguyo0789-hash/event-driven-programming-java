# Limitations of java.util.Observer and java.util.Observable

## Limitation 1: Single Inheritance
Observable is a class, not an interface. Java allows a class to extend only one parent, so a class that already extends something else, such as JFrame or a domain base class, cannot also become an Observable. Developers are forced into awkward workarounds like wrapping an Observable inside another object. An interface would have let any class opt in.

## Limitation 2: Cannot Change the Notification Order
Observers are held in an internal collection and notified in an unspecified order. The documentation does not promise registration order, and the class gives no way to set priorities. If one observer depends on another having run first, the code can break without warning.

## Limitation 3: setChanged() is Confusing
`notifyObservers()` only does anything if `setChanged()` was called first. The idea was to let a subject batch several modifications and notify once, but in practice it is an extra step that is easy to forget. When it is forgotten, observers silently receive nothing and there is no error to point to the cause.

## Limitation 4: Pull Model by Default
The basic `notifyObservers()` sends no data. Each observer must call getter methods on the Observable to find out what changed. That requires a cast from the `Observable` argument to the concrete type and extra method calls, and the observer cannot tell which property changed. A push model that carries the new values is simpler and more efficient.

## Limitation 5: Deprecated Since Java 9
Java deprecated both classes in Java 9. The design is not type safe, because the update argument is a plain Object. The classes are not thread safe or extensible, the notification order is unspecified, and the setChanged() mechanism is error prone. Better alternatives exist: PropertyChangeListener, JavaFX properties and bindings, and custom observer interfaces.

---

## Self-Check
1. **Why can't you extend another class if you already extend Observable?** Java supports single class inheritance, and Observable occupies the one superclass slot.
2. **Push model versus pull model.** In the push model the subject sends the changed data along with the notification, as in `update(temp, humidity, pressure)`. In the pull model the notification carries little or nothing and the observer must ask the subject for the data it needs.
3. **Why did Java deprecate these classes?** They are inflexible and easy to misuse: the class-based design blocks inheritance, the notification order is undefined, setChanged() is easy to forget, the data is untyped and the API is not thread safe.
