package Controllers;

import Modules.Customer;
import Modules.DBUtils;
import Modules.Room;
import Views.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;


public class MainController {

    private RoomView roomView;
    private DefaultTableModel model;
    private String[] columns = {"ID Room","Type","ID Customer","Date in","Date out","Cost per day"};
    private String[][] rows = {};
    private DBUtils db;

    public MainController() {
        //Call Room view
        roomView = new RoomView();

        //Load data to arraylist
        db = new DBUtils();
        db.loadRoom();
        db.loadCustomer();

        //Load data to table
        loadTable();

        //Finish program
        roomView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Set enable false
        roomView.getDeleteButton().setEnabled(false);
        roomView.getEditButton().setEnabled(false);
        roomView.getCustomerSInformationButton().setEnabled(false);

        //Set enable true
        roomView.getTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),2) != null) {
                    roomView.getDeleteButton().setEnabled(true);
                    roomView.getEditButton().setEnabled(true);
                    roomView.getCustomerSInformationButton().setEnabled(true);
                }
                else {
                    roomView.getDeleteButton().setEnabled(false);
                    roomView.getEditButton().setEnabled(false);
                    roomView.getCustomerSInformationButton().setEnabled(false);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //Add button
        roomView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Call add view
                AddView addView = new AddView();

                //Set enable id room textfield
                addView.getIdroomTextField().setEnabled(false);

                //Check button
                addView.getCheckButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get type
                        String type = addView.getTypeTextField().getText();

                        //Call list room view
                        ListRoomView listRoomView = new ListRoomView();

                        //Load data to table list room
                        String[] column = {"ID Room"};
                        String[][] row = {};
                        DefaultTableModel modell = new DefaultTableModel(row,column);
                        for(Room r : db.getRooms()) {
                            if(type.equalsIgnoreCase(r.getType()) && r.getIdcustomer()==null ) {
                                String[] rowadd = {r.getIdroom()};
                                modell.addRow(rowadd);
                            }
                        }
                        listRoomView.getTable().setModel(modell);

                        //Select button
                        listRoomView.getSelectButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String idroom = listRoomView.getTable().getValueAt(listRoomView.getTable().getSelectedRow(),0).toString();
                                addView.getIdroomTextField().setText(idroom);
                                listRoomView.setVisible(false);
                            }
                        });
                    }
                });

                //Apply button
                addView.getApplyButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            //Get text
                            String idroom = addView.getIdroomTextField().getText();
                            String type = addView.getTypeTextField().getText();
                            String idcustomer = addView.getIdcustomerTextField().getText();
                            String datein = addView.getDateinTextField().getText();
                            String dateout = addView.getDateoutTextField().getText();
                            String name = addView.getNameTextField().getText();
                            int age = Integer.valueOf(addView.getAgeTextField().getText());
                            String dob = addView.getDobTextField().getText();
                            String gender = addView.getGenderTextField().getText();
                            String address = addView.getAddressTextField().getText();

                            if(idroom.equalsIgnoreCase("")) {
                                JOptionPane.showMessageDialog(addView,"ID Room can not be empty !");
                                return;
                            }

                            if(idcustomer.equalsIgnoreCase("")) {
                                JOptionPane.showMessageDialog(addView,"ID Customer can not be empty !");
                                return;
                            }

                            //Add row to table customer
                            Statement statement = db.getConnection().createStatement();
                            String addcustomer = "INSERT INTO Customer VALUES (" + "'" + idcustomer + "','" + name + "'," +
                                                String.valueOf(age) + ",'" + dob + "','" + gender + "','" + address + "');";
                            statement.execute(addcustomer);

                            //Update row to table room
                            String setroom = "UPDATE Room SET IDCustomer = '"+ idcustomer + "', [Date in] = '" + datein + "', [Date out] = '" + dateout + "'" +
                                                "WHERE IDRoom = '" + idroom + "';";
                            statement.execute(setroom);

                            //Update list rooms
                            for(Room r : db.getRooms()) {
                                if(idroom.equalsIgnoreCase(r.getIdroom())) {
                                    r.setIdcustomer(idcustomer);
                                    r.setDatein(datein);
                                    r.setDateout(dateout);
                                }
                            }

                            //Add list customers
                            db.getCustomers().add(new Customer(idcustomer,name,age,dob,gender,address));

                            //Update table
                            roomView.getTable().removeAll();
                            loadTable();

                            JOptionPane.showMessageDialog(addView,"Successful !");

                            //Exit add view
                            addView.setVisible(false);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(addView,"ID Customer can not be duplicated !");
                        } catch (NullPointerException ex) {
                            JOptionPane.showMessageDialog(addView,"Can not insert null !");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(addView,"Age is wrong !");
                        }
                    }
                });
            }
        });

        //Delete button
        roomView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Delele on list customer
                String idcustomer = roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),2).toString();
                for(Customer c : db.getCustomers()) {
                    if(idcustomer.equalsIgnoreCase(c.getIdcustomer())) {
                        db.getCustomers().remove(c);
                        break;
                    }
                }

                //Delete on list room
                for(Room r : db.getRooms()) {
                    if(idcustomer.equalsIgnoreCase(r.getIdcustomer())) {
                        r.setIdcustomer(null);
                        r.setDatein(null);
                        r.setDateout(null);
                        break;
                    }
                }

                //Delete on table
                roomView.getTable().setValueAt(null,roomView.getTable().getSelectedRow(),2);
                roomView.getTable().setValueAt(null,roomView.getTable().getSelectedRow(),3);
                roomView.getTable().setValueAt(null,roomView.getTable().getSelectedRow(),4);

                //Delete on sql server
                try {
                    Statement statement = db.getConnection().createStatement();
                    String removecustomer = "DELETE FROM Customer WHERE IDCustomer = '" + idcustomer + "';";
                    statement.execute(removecustomer);
                    String removeroom = "UPDATE Room SET IDCustomer =  NULL , [Date in] = NULL , [Date out] = NULL WHERE IDCustomer = '" + idcustomer + "';";
                    statement.execute(removeroom);
                    JOptionPane.showMessageDialog(roomView,"Successfull !");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        //Edit button
        roomView.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Call edit view
                EditView editView = new EditView();

                //Set enable id room textfield
                editView.getIdroomTextField().setEnabled(false);

                //Check button
                editView.getCheckButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get type
                        String type = editView.getTypeTextField().getText();

                        //Call list room view
                        ListRoomView listRoomView = new ListRoomView();

                        //Load data to table list room
                        String[] column = {"ID Room"};
                        String[][] row = {};
                        DefaultTableModel modell = new DefaultTableModel(row,column);
                        for(Room r : db.getRooms()) {
                            if(type.equalsIgnoreCase(r.getType()) && r.getIdcustomer()==null ) {
                                String[] rowadd = {r.getIdroom()};
                                modell.addRow(rowadd);
                            }
                        }
                        listRoomView.getTable().setModel(modell);

                        //Select button
                        listRoomView.getSelectButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String idroom = listRoomView.getTable().getValueAt(listRoomView.getTable().getSelectedRow(),0).toString();
                                editView.getIdroomTextField().setText(idroom);
                                listRoomView.setVisible(false);
                            }
                        });
                    }
                });

                //Get id room, id customer
                String idroomm = roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),0).toString();
                String idcustomerr = roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),2).toString();

                //Set text
                editView.getIdroomTextField().setText(idroomm);
                editView.getTypeTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),1).toString());
                editView.getIdcustomerTextField().setText(idcustomerr);
                editView.getDateinTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),3).toString());
                editView.getDateoutTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),4).toString());
                for(Customer r : db.getCustomers()) {
                    if(idcustomerr.equalsIgnoreCase(r.getIdcustomer())) {
                        editView.getNameTextField().setText(r.getName());
                        editView.getAgeTextField().setText(String.valueOf(r.getAge()));
                        editView.getDobTextField().setText(r.getDob());
                        editView.getGenderTextField().setText(r.getGender());
                        editView.getAddressTextField().setText(r.getAddress());
                    }
                }

                //Apply button
                editView.getApplyButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get text
                        String idroom = editView.getIdroomTextField().getText();
                        String type = editView.getTypeTextField().getText();
                        String idcustomer = editView.getIdcustomerTextField().getText();
                        String datein = editView.getDateinTextField().getText();
                        String dateout = editView.getDateoutTextField().getText();
                        String name = editView.getNameTextField().getText();
                        int age = Integer.valueOf(editView.getAgeTextField().getText());
                        String dob = editView.getDobTextField().getText();
                        String gender = editView.getGenderTextField().getText();
                        String address = editView.getAddressTextField().getText();

                        if(idcustomer.equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(editView,"ID Customer can not be empty !");
                            return;
                        }

                        //Edit on list customer
                        for(Customer c : db.getCustomers()) {
                            if(idcustomerr.equalsIgnoreCase(c.getIdcustomer())) {
                                c.setIdcustomer(idcustomer);
                                c.setName(name);
                                c.setAge(age);
                                c.setDob(dob);
                                c.setGender(gender);
                                c.setAddress(address);
                                break;
                            }
                        }

                        //Edit on list Room
                        for(Room r : db.getRooms()) {
                            if(idroomm.equalsIgnoreCase(r.getIdroom())) {
                                r.setIdcustomer(null);
                                r.setDatein(null);
                                r.setDateout(null);
                                break;
                            }
                        }
                        for(Room r : db.getRooms()) {
                            if(idroom.equalsIgnoreCase(r.getIdroom())) {
                                r.setIdcustomer(idcustomer);
                                r.setDatein(datein);
                                r.setDateout(dateout);
                                break;
                            }
                        }

                        //Edit on table
                        roomView.getTable().removeAll();
                        loadTable();

                        //Edit on database
                        try {
                            Statement statement = db.getConnection().createStatement();

                            //Edit on table customer
                            String setcustomer = "UPDATE Customer SET IDCustomer = '" + idcustomer + "', Name = '" + name + "', Age =" + String.valueOf(age) +
                                                ", [Date of birth] = '" + dob + "', Gender = '" + gender + "', Address = '" + address + "' WHERE IDCustomer = '" + idcustomerr + "';";
                            statement.execute(setcustomer);
                            String setroom1 = "UPDATE Room SET IDCustomer = NULL , [Date in] = NULL, [Date out] = NULL WHERE IDRoom = '" + idroomm + "';";
                            statement.execute(setroom1);
                            String setroom2 = "UPDATE Room SET IDCustomer = '" + idcustomer + "', [Date in] = '" + datein + "', [Date out] = '" + dateout +
                                                "' WHERE IDRoom = '" + idroom + "';";
                            statement.execute(setroom2);
                            JOptionPane.showMessageDialog(editView,"Successful !");
                            editView.setVisible(false);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });

        //Search Button
        roomView.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Get id customer
                    String idcustomer = JOptionPane.showInputDialog(roomView,"ID Customer ");
                    if(idcustomer.equalsIgnoreCase("")) {
                        return;
                    }

                    //Check
                    for(Customer c : db.getCustomers()) {
                        if(idcustomer.equalsIgnoreCase(c.getIdcustomer())) {
                            //Show information
                            CustomerView customerView = new CustomerView();

                            //Set textfield
                            customerView.getIdcustomerTextField().setText(idcustomer);
                            customerView.getNameTextField().setText(c.getName());
                            customerView.getAgeTextField().setText(String.valueOf(c.getAge()));
                            customerView.getDobTextField().setText(c.getDob());
                            customerView.getGenderTextField().setText(c.getGender());
                            customerView.getAddressTextField().setText(c.getAddress());

                            for(Room r : db.getRooms()) {
                                if(idcustomer.equalsIgnoreCase(r.getIdcustomer())) {
                                    customerView.getIdroomTextField().setText(r.getIdroom());
                                    customerView.getTypeTextField().setText(r.getType());
                                    customerView.getDateinTextField().setText(r.getDatein());
                                    customerView.getDateoutTextField().setText(r.getDateout());
                                }
                            }
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(roomView,"Customer is not exist !");
                } catch (NullPointerException ex) {
                    return;
                }
            }
        });

        //Customer Information button
        roomView.getCustomerSInformationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerView customerView = new CustomerView();

                //Set textfield
                customerView.getIdroomTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),0).toString());
                customerView.getTypeTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),1).toString());
                customerView.getIdcustomerTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),2).toString());
                customerView.getDateinTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),3).toString());
                customerView.getDateoutTextField().setText(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),4).toString());
                for(Customer c : db.getCustomers()) {
                    if(roomView.getTable().getValueAt(roomView.getTable().getSelectedRow(),2).toString().equalsIgnoreCase(c.getIdcustomer())) {
                        customerView.getNameTextField().setText(c.getName());
                        customerView.getAgeTextField().setText(String.valueOf(c.getAge()));
                        customerView.getDobTextField().setText(c.getDob());
                        customerView.getGenderTextField().setText(c.getGender());
                        customerView.getAddressTextField().setText(c.getAddress());
                        break;
                    }
                }
            }
        });
    }

    public void loadTable() {
        model = new DefaultTableModel(rows,columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for(Room r : db.getRooms()) {
            String[] row = {r.getIdroom(),r.getType(),r.getIdcustomer(),r.getDatein(), r.getDateout(),
                    String.valueOf(r.getCost())};
            model.addRow(row);
        }
        roomView.getTable().setModel(model);
    }

    public RoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[][] getRows() {
        return rows;
    }

    public void setRows(String[][] rows) {
        this.rows = rows;
    }

    public DBUtils getDb() {
        return db;
    }

    public void setDb(DBUtils db) {
        this.db = db;
    }
}
