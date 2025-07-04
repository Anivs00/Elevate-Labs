import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToDoApp extends JFrame implements ActionListener {

    private JTextField taskField;
    private JButton addButton, deleteButton;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoApp() {
        // Set up frame
        setTitle("To-Do List App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Task input field
        taskField = new JTextField(20);
        add(taskField);

        // Add button
        addButton = new JButton("Add Task");
        addButton.addActionListener(this);
        add(addButton);

        // Delete button
        deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(this);
        add(deleteButton);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        add(scrollPane);

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
