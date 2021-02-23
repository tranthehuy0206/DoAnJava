package Modules;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    private ArrayList<Room> rooms;
    private ArrayList<Customer> customers;
    private Connection connection;

    public DBUtils() {
        //create arraylist
        rooms = new ArrayList<>();
        customers = new ArrayList<>();

        //setup database
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;database=HotelManagementt";
        String username = "huy";
        String password = "123456";

        //connection
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadRoom() {
        try {
            Statement statement = connection.createStatement();
            String str = "SELECT * FROM Room";
            ResultSet resultSet = statement.executeQuery(str);
            while(resultSet.next()) {
                Room room = new Room(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5), Double.valueOf(resultSet.getString(6)));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadCustomer() {
        try {
            Statement statement = connection.createStatement();
            String str = "SELECT * FROM Customer";
            ResultSet resultSet = statement.executeQuery(str);
            while(resultSet.next()) {
                Customer customer = new Customer(resultSet.getString(1),resultSet.getString(2),
                        Integer.valueOf(resultSet.getString(3)),resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DBUtils(ArrayList<Room> rooms, ArrayList<Customer> customers) {
        this.rooms = rooms;
        this.customers = customers;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
