# Week 3: Final Self-Assessment

**Student:** Halkano Guyo, 25ZAD110789

## Learning Outcome 1: Create a functional Swing application with a main window
**Rating:** 5

Minimal code to create a JFrame, from memory:
```java
import javax.swing.*;

public class MyWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
```

## Learning Outcome 2: Add, customize, and arrange components using layouts
**Rating:** 5

| Layout | Use Case |
|---|---|
| FlowLayout | Toolbars and rows of tags or buttons that wrap to the next line |
| BorderLayout | An application shell with header, sidebar, content and status bar |
| GridLayout | A calculator keypad or a photo gallery with equal cells |
| BoxLayout | Stacking form fields or cards in a single vertical or horizontal line |

## Learning Outcome 3: Ensure GUI code runs on the EDT
**Rating:** 5

The two golden rules of Swing threading:
1. Create and update every Swing component on the Event Dispatch Thread, for example by starting the GUI inside `SwingUtilities.invokeLater()`.
2. Never block the EDT with long-running work. Run slow tasks on a background thread and use `SwingUtilities.invokeLater()` to push the result back to the GUI.

## Learning Outcome 4: Build a static, non-interactive UI layout
**Rating:** 5

Did your StudentPortal.java run successfully?
- [x] Yes
- [ ] No

All four ratings are 4 or 5, so all Week 3 outcomes are achieved.
