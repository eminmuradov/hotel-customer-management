package az.hotel.model;

public class RoomName {
    private int id;
    private String roomName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "RoomName{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
