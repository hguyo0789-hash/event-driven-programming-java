import javax.swing.*;
import java.awt.*;

// Code equivalent of the NetBeans "CombinedDemo" app shell:
// toolbar (north), sidebar (west), 3x3 card grid (centre), status bar (south).
public class CombinedDemo extends JFrame {

    public CombinedDemo() {
        setTitle("Combined Layout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel toolbar = new JPanel(new FlowLayout());
        toolbar.setBackground(Color.LIGHT_GRAY);
        for (String t : new String[]{"New", "Open", "Save", "Exit"}) toolbar.add(new JButton(t));
        add(toolbar, BorderLayout.NORTH);

        JPanel sidebar = new JPanel(new GridLayout(5, 1));
        sidebar.setPreferredSize(new Dimension(150, 0));
        for (String t : new String[]{"Home", "Profile", "Messages", "Settings", "Logout"}) sidebar.add(new JButton(t));
        add(sidebar, BorderLayout.WEST);

        JPanel content = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) content.add(new JButton("Card " + i));
        add(content, BorderLayout.CENTER);

        JLabel status = new JLabel("Ready");
        status.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(status, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new CombinedDemo().setVisible(true));
    }
}
