package Modules;

public class Room {

    private String idroom;
    private String type;
    private String idcustomer;
    private String datein;
    private String dateout;
    private double cost;

    public Room() {

    }

    public Room(String idroom, String type, String idcustomer, String datein, String dateout, double cost) {
        this.idroom = idroom;
        this.type = type;
        this.idcustomer = idcustomer;
        this.datein = datein;
        this.dateout = dateout;
        this.cost = cost;
    }

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
        return idroom + type + idcustomer + datein + dateout + cost;
    }
}
