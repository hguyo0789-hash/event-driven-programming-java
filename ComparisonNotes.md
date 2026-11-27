# Activity 3 Notes: Tight Coupling vs the Observer Pattern

## Step 2: The coupling problem
1. **Adding a third display class.** Yes. `DataModel.setValue()` creates each display directly, so a third display needs a new line inside DataModel.
2. **LabelDisplay deleted or renamed.** DataModel would no longer compile. Every class the model names directly becomes a dependency, and a change in a display breaks the model.
3. **Testing DataModel in isolation.** Not easily. The model cannot be exercised without the display classes it creates, and its output goes straight to the console.

## Step 4: Comparison

| Aspect | Tightly Coupled | Observer Pattern |
|---|---|---|
| Adding a new display | Modify DataModel | Register a new observer, with no change to DataModel (TextLogger was added in RefactoredMain only) |
| Testing DataModel in isolation | Hard, because it needs display classes | Easy, because no display classes are required |
| Removing a display | Modify DataModel | Call `removeObserver` or simply do not register it |

The run confirms it: in `RefactoredMain` the TextLogger was added without touching DataModel, and it logged every change after it joined.
