package Views;

import javax.swing.*;

public class RoomView extends JFrame{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton searchButton;
    private JButton customerSInformationButton;
    private JScrollPane tablePanel;
    private JPanel buttonPanel;

    public RoomView() {
        this.setSize(700,300);
        this.setTitle("Hotel Management");
        this.setLocation(400,100);
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

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getCustomerSInformationButton() {
        return customerSInformationButton;
    }

    public void setCustomerSInformationButton(JButton customerSInformationButton) {
        this.customerSInformationButton = customerSInformationButton;
    }

    public JScrollPane getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JScrollPane tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
}
