package az.hotel.model;

import java.util.Date;

public class Customer {

    private RoomName roomName;
    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String telephone;
    private Date inDate;
    private Date outDate;
    private String numberOfRoom;
    private String adults;
    private String children;
    private String typeofRoom;
    private String price;
    private int active;

    public RoomName getRoomName() {
        return roomName;
    }

    public void setRoomName(RoomName roomName) {
        this.roomName = roomName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getTypeofRoom() {
        return typeofRoom;
    }

    public void setTypeofRoom(String typeofRoom) {
        this.typeofRoom = typeofRoom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "roomName=" + roomName +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", numberOfRoom='" + numberOfRoom + '\'' +
                ", adults='" + adults + '\'' +
                ", children='" + children + '\'' +
                ", typeofRoom='" + typeofRoom + '\'' +
                ", price='" + price + '\'' +
                ", active=" + active +
                '}';
    }
}
