import javax.swing.*;
import java.awt.*;

// Code equivalent of the NetBeans "FirstWindow" form: a 500x400 window titled
// "My First Swing App" with a blue "Click Me!" button, centred on screen.
public class FirstWindow extends JFrame {

    private JButton jButton1;

    public FirstWindow() {
        initComponents();
    }

    private void initComponents() {
        jButton1 = new JButton("Click Me!");
        jButton1.setFont(new Font("Arial", Font.BOLD, 16));
        jButton1.setBackground(new Color(0, 90, 200));
        jButton1.setForeground(Color.WHITE);
        jButton1.setOpaque(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My First Swing App");
        setLayout(new GridBagLayout());
        add(jButton1);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // NetBeans generates the same pattern: create the GUI on the EDT.
        EventQueue.invokeLater(() -> new FirstWindow().setVisible(true));
    }
}
