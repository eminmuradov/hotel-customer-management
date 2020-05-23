package az.hotel.model;

public class RoomNumber {
    private int id;
    private int numberOfRoom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberofRoom() {
        return numberOfRoom;
    }

    public void setNumberofRoom(int numberofRoom) {
        this.numberOfRoom = numberofRoom;
    }

    @Override
    public String toString() {
        return "RoomNumber{" +
                "id=" + id +
                ", numberofRoom=" + numberOfRoom +
                '}';
    }
}
