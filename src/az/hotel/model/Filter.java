package az.hotel.model;

import java.util.Date;

public class Filter {
    private String advSearchRoomNumber;
    private String advSearchRoomName;
    private Date advSearchInDate;
    private Date advSearchOutDate;

    public String getAdvSearchRoomNumber() {
        return advSearchRoomNumber;
    }

    public void setAdvSearchRoomNumber(String advSearchRoomNumber) {
        this.advSearchRoomNumber = advSearchRoomNumber;
    }

    public String getAdvSearchRoomName() {
        return advSearchRoomName;
    }

    public void setAdvSearchRoomName(String advSearchRoomName) {
        this.advSearchRoomName = advSearchRoomName;
    }

    public Date getAdvSearchInDate() {
        return advSearchInDate;
    }

    public void setAdvSearchInDate(Date advSearchInDate) {
        this.advSearchInDate = advSearchInDate;
    }

    public Date getAdvSearchOutDate() {
        return advSearchOutDate;
    }

    public void setAdvSearchOutDate(Date advSearchOutDate) {
        this.advSearchOutDate = advSearchOutDate;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "advSearchRoomNumber=" + advSearchRoomNumber +
                ", advSearchRoomName=" + advSearchRoomName +
                ", advSearchInDate=" + advSearchInDate +
                ", advSearchOutDate=" + advSearchOutDate +
                '}';
    }
}
