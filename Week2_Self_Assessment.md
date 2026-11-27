# Week 2: Final Self-Assessment (Observer Pattern)

**Student:** Halkano Guyo, 25ZAD110789

## Learning Outcome 1: Design and Implement the Observer Pattern
1. **UML diagram.**
```
 <<interface>>                      <<interface>>
   Subject      ---------------->     Observer
 registerObserver()   observers     update(t, h, p)
 removeObserver()                          ^
 notifyObservers()                         |
        ^                       ---------------------------
        |                       |            |            |
   WeatherData        CurrentConditions  Statistics   Forecast
 (ConcreteSubject)    Display            Display      Display
                      (ConcreteObserver instances)
```
2. **Subject interface from memory.**
```java
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
```
3. The Subject needs a list so it knows every observer that must be told about a change, and so observers can be added and removed at run time.

## Learning Outcome 2: Evaluate Legacy java.util.Observer
4. Three problems: Observable is a class and blocks inheritance, the notification order is unspecified, and setChanged() is easy to forget, so notifications silently fail.
5. It was deprecated because the design is inflexible, untyped and not thread safe, and better options exist.
6. The pull model means the notification carries no data and observers must call getters on the subject. It is harder because it needs casts and extra calls, and the observer cannot tell what changed.

## Learning Outcome 3: Create a Custom Event Notification System
7. A custom Subject interface must provide a method to register an observer, one to remove an observer and one to notify all observers.
8. The subject loops through its observer list and calls each observer's update method.
9. To prevent memory leaks, remove observers with `removeObserver()` when they are no longer needed, since the subject's list holds a strong reference to each.

## Learning Outcome 4: Compare Different Mechanisms
10. Custom Observer, java.util.Observer/Observable, PropertyChangeListener and JavaFX bindings.
11. JavaFX bindings are the best fit for JavaFX.
12. java.util.Observer/Observable is deprecated.

**Self-score:** 12 of 12, mastered the Observer pattern.

## One-page summary of the Observer pattern
The Observer pattern lets one object, the subject, tell many other objects, the observers, when its state changes, without the subject knowing anything about them except that they implement an interface. The subject keeps a list of observers and offers methods to register and remove them. When its data changes it loops through the list and calls each observer's update method. In the weather station, WeatherData pushed temperature, humidity and pressure to three displays, and removing one display needed no change to WeatherData. This is loose coupling, and the refactoring exercise showed its benefit: the tightly coupled DataModel had to be edited to add or remove a display, while the observer version accepted a new TextLogger with no modification. Java's own java.util.Observable was an early attempt at the pattern but is deprecated because it is a class, notifies in an undefined order, depends on setChanged() and cannot say what changed. Today a custom interface, PropertyChangeSupport for JavaBeans, or JavaFX bindings are preferred. One thing I want to practise is using bindings, since they will replace much of the manual registration code in the JavaFX weeks.
