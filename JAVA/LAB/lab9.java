import java.awt.BorderLayout; // Import the BorderLayout class from java.awt
import javax.swing.*;

public class lab9 {
    private JFrame frame;
    private JTextField employeeNameField, salaryField;
    private JTextArea displayArea;
    private JButton calculateButton;

    public lab9() {
        frame = new JFrame("Employee Salary Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel nameLabel = new JLabel("Employee Name:");
        employeeNameField = new JTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();

        panel.add(nameLabel);
        panel.add(employeeNameField);
        panel.add(salaryLabel);
        panel.add(salaryField);

        calculateButton = new JButton("Calculate Salary");
        displayArea = new JTextArea(10, 10);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        calculateButton.addActionListener(e -> calculateSalary());

        panel.add(calculateButton);
        panel.add(scrollPane);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    private void calculateSalary() {
        String employeeName = employeeNameField.getText();
        double salary;

        try {
            salary = Double.parseDouble(salaryField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid salary.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double calculatedSalary = salary * 0.9; // For demonstration, just deducting 20%
        displayArea.setText("");
        displayArea.append("Employee: " + employeeName + "\n");
        displayArea.append("Original Salary: " + salary + "\n");
        displayArea.append("Calculated Salary after cuttings(10%): " + calculatedSalary + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new lab9());
    }
}
