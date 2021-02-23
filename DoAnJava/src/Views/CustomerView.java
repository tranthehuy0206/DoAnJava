package Views;

import javax.swing.*;

public class CustomerView extends JFrame{
    private JPanel mainPanel;
    private JLabel idcustomerLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel dobLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;
    private JTextField idcustomerTextField;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField dobTextField;
    private JTextField genderTextField;
    private JTextField addressTextField;
    private JPanel labelPanel;
    private JPanel textfieldPanel;
    private JLabel idroomLabel;
    private JLabel typeLabel;
    private JTextField idroomTextField;
    private JTextField typeTextField;
    private JLabel dateinLabel;
    private JLabel dateoutLabel;
    private JTextField dateinTextField;
    private JTextField dateoutTextField;

    public CustomerView() {
        this.setSize(400,700);
        this.setTitle("Customer's Information");
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public JPanel getPanel1() {
        return mainPanel;
    }

    public void setPanel1(JPanel panel1) {
        this.mainPanel = panel1;
    }

    public JLabel getIdcustomerLabel() {
        return idcustomerLabel;
    }

    public void setIdcustomerLabel(JLabel idcustomerLabel) {
        this.idcustomerLabel = idcustomerLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }

    public JLabel getDobLabel() {
        return dobLabel;
    }

    public void setDobLabel(JLabel dobLabel) {
        this.dobLabel = dobLabel;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(JLabel addressLabel) {
        this.addressLabel = addressLabel;
    }

    public JTextField getIdcustomerTextField() {
        return idcustomerTextField;
    }

    public void setIdcustomerTextField(JTextField idcustomerTextField) {
        this.idcustomerTextField = idcustomerTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public void setAgeTextField(JTextField ageTextField) {
        this.ageTextField = ageTextField;
    }

    public JTextField getDobTextField() {
        return dobTextField;
    }

    public void setDobTextField(JTextField dobTextField) {
        this.dobTextField = dobTextField;
    }

    public JTextField getGenderTextField() {
        return genderTextField;
    }

    public void setGenderTextField(JTextField genderTextField) {
        this.genderTextField = genderTextField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public void setAddressTextField(JTextField addressTextField) {
        this.addressTextField = addressTextField;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getLabelPanel() {
        return labelPanel;
    }

    public void setLabelPanel(JPanel labelPanel) {
        this.labelPanel = labelPanel;
    }

    public JPanel getTextfieldPanel() {
        return textfieldPanel;
    }

    public void setTextfieldPanel(JPanel textfieldPanel) {
        this.textfieldPanel = textfieldPanel;
    }

    public JLabel getIdroomLabel() {
        return idroomLabel;
    }

    public void setIdroomLabel(JLabel idroomLabel) {
        this.idroomLabel = idroomLabel;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(JLabel typeLabel) {
        this.typeLabel = typeLabel;
    }

    public JTextField getIdroomTextField() {
        return idroomTextField;
    }

    public void setIdroomTextField(JTextField idroomTextField) {
        this.idroomTextField = idroomTextField;
    }

    public JTextField getTypeTextField() {
        return typeTextField;
    }

    public void setTypeTextField(JTextField typeTextField) {
        this.typeTextField = typeTextField;
    }

    public JLabel getDateinLabel() {
        return dateinLabel;
    }

    public void setDateinLabel(JLabel dateinLabel) {
        this.dateinLabel = dateinLabel;
    }

    public JLabel getDateoutLabel() {
        return dateoutLabel;
    }

    public void setDateoutLabel(JLabel dateoutLabel) {
        this.dateoutLabel = dateoutLabel;
    }

    public JTextField getDateinTextField() {
        return dateinTextField;
    }

    public void setDateinTextField(JTextField dateinTextField) {
        this.dateinTextField = dateinTextField;
    }

    public JTextField getDateoutTextField() {
        return dateoutTextField;
    }

    public void setDateoutTextField(JTextField dateoutTextField) {
        this.dateoutTextField = dateoutTextField;
    }
}
