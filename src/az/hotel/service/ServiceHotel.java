package az.hotel.service;

import az.hotel.model.*;
import az.hotel.model.CustomerLogin;

import java.sql.SQLException;
import java.util.List;

public interface ServiceHotel {
    List<Customer> loadCustomerList() throws SQLException;

    List<Workers> loadWorkersList() throws SQLException;

    List<RoomNumber> getRoomNumber() throws SQLException;

    List<AdultNumber> getAdultNumber() throws SQLException;

    List<ChildrenNumber> getChildrenNumber() throws SQLException;

    List<RoomName> getRoomName() throws SQLException;

    void saveCustomerInfo(Customer customer) throws SQLException;

    Customer getCustomerIdInfo(Integer customerId) throws SQLException;

    void updateCustomerInfo(Customer customer) throws SQLException;

    void deleteCustomer(Integer deleteCustomer) throws SQLException;

    List<Customer> getSimpleSearchCustomerList(String searchVal) throws SQLException;

    List<Customer> getAdvSearchCustomer(Filter filter) throws SQLException;


    void addWorker(Workers worker) throws SQLException;

    Workers getWorkersIdInfo(Integer workerId) throws SQLException;

    void updateWorkerInfo(Workers worker) throws SQLException;

    void deleteWorker(Integer deleteWorker) throws SQLException;

    void doSignUp(CustomerLogin login) throws SQLException;


    CustomerLogin doSignIn(String loginUsername, String endCodePassword) throws SQLException;

    boolean checkUsername(String username) throws SQLException;
}
