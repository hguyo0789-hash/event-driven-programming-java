import javax.swing.*;
import java.awt.*;

// Code equivalent of the NetBeans "ShowcaseForm": 16+ components, radio buttons in one ButtonGroup.
public class ShowcaseForm extends JFrame {

    public ShowcaseForm() {
        setTitle("Component Showcase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Component Showcase", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        form.add(title, c);
        c.gridwidth = 1;

        int row = 1;
        row = addRow(form, c, row, new JLabel("Username:"), new JTextField(20));
        row = addRow(form, c, row, new JLabel("Password:"), new JPasswordField(20));

        c.gridx = 0; c.gridy = row++; c.gridwidth = 2;
        form.add(new JCheckBox("Remember me"), c);
        c.gridy = row++;
        form.add(new JCheckBox("Subscribe to newsletter"), c);
        c.gridwidth = 1;

        // Radio buttons share one ButtonGroup so only one can be selected.
        JPanel radios = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        ButtonGroup genderGroup = new ButtonGroup();
        for (String g : new String[]{"Male", "Female", "Other"}) {
            JRadioButton rb = new JRadioButton(g);
            genderGroup.add(rb);
            radios.add(rb);
        }
        row = addRow(form, c, row, new JLabel("Gender:"), radios);

        JComboBox<String> country = new JComboBox<>(
                new String[]{"Kenya", "Tanzania", "Uganda", "Rwanda", "Ethiopia"});
        row = addRow(form, c, row, new JLabel("Country:"), country);

        JTextArea comments = new JTextArea(3, 30);
        row = addRow(form, c, row, new JLabel("Comments:"), new JScrollPane(comments));

        JButton submit = new JButton("Submit");
        submit.setBackground(new Color(60, 160, 60));
        submit.setOpaque(true);
        JButton cancel = new JButton("Cancel");
        cancel.setBackground(new Color(200, 60, 60));
        cancel.setOpaque(true);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttons.add(submit);
        buttons.add(cancel);
        c.gridx = 0; c.gridy = row; c.gridwidth = 2;
        form.add(buttons, c);

        add(form);
    }

    private int addRow(JPanel p, GridBagConstraints c, int row, JComponent label, JComponent field) {
        c.gridx = 0; c.gridy = row; c.weightx = 0;
        p.add(label, c);
        c.gridx = 1; c.weightx = 1;
        p.add(field, c);
        return row + 1;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new ShowcaseForm().setVisible(true));
    }
}
