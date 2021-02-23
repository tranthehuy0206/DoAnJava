package Views;

import javax.swing.*;

public class ListRoomView extends JFrame{
    private JPanel mainPanel;
    private JTable table;
    private JPanel buttonPanel;
    private JButton selectButton;
    private JScrollPane tablePanel;

    public ListRoomView() {
        this.setSize(300,600);
        this.setTitle("List Room");
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public void setSelectButton(JButton selectButton) {
        this.selectButton = selectButton;
    }

    public JScrollPane getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JScrollPane tablePanel) {
        this.tablePanel = tablePanel;
    }
}
