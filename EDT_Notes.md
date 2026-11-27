# Activity 4 Notes: Freezing vs Not Freezing

## FreezeDemo.java
The button's listener calls `Thread.sleep(5000)` directly. Listeners run on the Event Dispatch Thread, so the EDT sleeps for five seconds. During that time the window cannot repaint, the other buttons cannot be clicked, the window cannot be moved cleanly and the "Working..." label never gets drawn. The interface only comes back to life after the sleep ends and the label changes to "Done!". This is the freeze users see in an application that is "Not Responding".

## FixedDemo.java
The long task runs inside `new Thread(...)`, so the EDT is free while it waits. The window keeps repainting and stays responsive during the five seconds. When the work finishes, the background thread does not touch the label itself; it calls `SwingUtilities.invokeLater(...)` so that the label update and the re-enabling of the button happen on the EDT.

## Conclusion
Slow work belongs on a background thread, and every change to a Swing component belongs on the EDT. FixedDemo follows both rules, FreezeDemo breaks the first one.
