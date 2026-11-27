# Activity 1 Self-Check: Weather Station

1. **Role of the Subject interface.** The Subject interface is the contract every publisher must follow. It declares `registerObserver`, `removeObserver` and `notifyObservers`, so any observer can subscribe to any subject without knowing its concrete class.
2. **Calling `notifyObservers()` with no observers registered.** Nothing happens. The loop runs over an empty list, so no `update()` is called and no error is raised.
3. **`registerObserver()` versus `removeObserver()`.** `registerObserver()` adds an observer to the list so it receives future notifications. `removeObserver()` takes it out, so it stops receiving them. The output shows this: after ForecastDisplay was removed, only Current and Statistics printed.
4. **Why the observers list is an instance variable.** The list must live as long as the subject and be shared by all of its methods. A local variable would disappear when a method returned, and the subject would forget who had registered.
