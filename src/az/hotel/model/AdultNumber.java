package az.hotel.model;

public class AdultNumber {
    private int id;
    private int numberOfAdult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(int numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    @Override
    public String toString() {
        return "AdultNumber{" +
                "id=" + id +
                ", numberOfAdult=" + numberOfAdult +
                '}';
    }
}
