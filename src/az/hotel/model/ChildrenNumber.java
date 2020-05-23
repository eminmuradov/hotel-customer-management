package az.hotel.model;

public class ChildrenNumber {
    private int id;
    private int numberOfChildren;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public String toString() {
        return "ChildrenNumber{" +
                "id=" + id +
                ", numberOfChildren=" + numberOfChildren +
                '}';
    }
}
