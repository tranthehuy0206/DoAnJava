package Views;

import javax.swing.*;

public class AddView extends JFrame{
    private JPanel mainPanel;
    private JButton applyButton;
    private JLabel typeLabel;
    private JLabel idroomLabel;
    private JLabel idcustomerLabel;
    private JLabel dateinLabel;
    private JLabel dateoutLabel;
    private JTextField idcustomerTextField;
    private JTextField dateinTextField;
    private JTextField dateoutTextField;
    private JTextField typeTextField;
    private JTextField idroomTextField;
    private JButton checkButton;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JPanel textfieldPanel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel dobLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField dobTextField;
    private JTextField genderTextField;
    private JTextField addressTextField;

    public AddView() {
        this.setSize(500,400);
        this.setTitle("Add Customer");
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getApplyButton() {
        return applyButton;
    }

    public void setApplyButton(JButton applyButton) {
        this.applyButton = applyButton;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(JLabel typeLabel) {
        this.typeLabel = typeLabel;
    }

    public JLabel getIdroomLabel() {
        return idroomLabel;
    }

    public void setIdroomLabel(JLabel idroomLabel) {
        this.idroomLabel = idroomLabel;
    }

    public JLabel getIdcustomerLabel() {
        return idcustomerLabel;
    }

    public void setIdcustomerLabel(JLabel idcustomerLabel) {
        this.idcustomerLabel = idcustomerLabel;
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

    public JTextField getTextField1() {
        return idcustomerTextField;
    }

    public void setTextField1(JTextField textField1) {
        this.idcustomerTextField = textField1;
    }

    public JTextField getTextField2() {
        return dateinTextField;
    }

    public void setTextField2(JTextField textField2) {
        this.dateinTextField = textField2;
    }

    public JTextField getTextField3() {
        return dateoutTextField;
    }

    public void setTextField3(JTextField textField3) {
        this.dateoutTextField = textField3;
    }

    public JTextField getTextField4() {
        return typeTextField;
    }

    public void setTextField4(JTextField textField4) {
        this.typeTextField = textField4;
    }

    public JTextField getTextField5() {
        return idroomTextField;
    }

    public void setTextField5(JTextField textField5) {
        this.idroomTextField = textField5;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public void setCheckButton(JButton checkButton) {
        this.checkButton = checkButton;
    }

    public JTextField getIdcustomerTextField() {
        return idcustomerTextField;
    }

    public void setIdcustomerTextField(JTextField idcustomerTextField) {
        this.idcustomerTextField = idcustomerTextField;
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

    public JTextField getTypeTextField() {
        return typeTextField;
    }

    public void setTypeTextField(JTextField typeTextField) {
        this.typeTextField = typeTextField;
    }

    public JTextField getIdroomTextField() {
        return idroomTextField;
    }

    public void setIdroomTextField(JTextField idroomTextField) {
        this.idroomTextField = idroomTextField;
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
}
