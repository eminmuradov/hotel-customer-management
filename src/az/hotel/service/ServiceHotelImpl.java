package az.hotel.service;

import az.hotel.dao.DaoHotel;
import az.hotel.model.*;
import az.hotel.model.CustomerLogin;

import java.sql.SQLException;
import java.util.List;



public class ServiceHotelImpl implements ServiceHotel {

    private DaoHotel daoHotel;

    public ServiceHotelImpl(DaoHotel daoHotel) {
        this.daoHotel = daoHotel;
    }

    @Override
    public List<Customer> loadCustomerList() throws SQLException {
        return daoHotel.loadCustomerList();
    }

    @Override
    public List<Workers> loadWorkersList() throws SQLException {
        return daoHotel.loadWorkersList();
    }

    @Override
    public List<RoomNumber> getRoomNumber() throws SQLException {
        return daoHotel.getRoomNumber();
    }

    @Override
    public List<AdultNumber> getAdultNumber() throws SQLException {
        return daoHotel.getAdultNumber();
    }

    @Override
    public List<ChildrenNumber> getChildrenNumber() throws SQLException {
        return daoHotel.getChildrenNumber();
    }

    @Override
    public List<RoomName> getRoomName() throws SQLException {
        return daoHotel.getRoomName();
    }

    @Override
    public void saveCustomerInfo(Customer customer) throws SQLException {
        daoHotel.saveCustomerInfo(customer);
    }

    @Override
    public Customer getCustomerIdInfo(Integer customerId) throws SQLException {
        return daoHotel.getCustomerIdInfo(customerId);
    }

    @Override
    public void updateCustomerInfo(Customer customer) throws SQLException {
        daoHotel.updateCustomerInfo(customer);
    }

    @Override
    public void deleteCustomer(Integer deleteCustomer) throws SQLException {
        daoHotel.deleteCustomer(deleteCustomer);
    }

    @Override
    public List<Customer> getSimpleSearchCustomerList(String searchVal) throws SQLException {
        return daoHotel.getSimpleSearchCustomerList(searchVal);
    }

    @Override
    public List<Customer> getAdvSearchCustomer(Filter filter) throws SQLException {
        return daoHotel.getAdvSearchCustomer(filter);
    }

    @Override
    public void addWorker(Workers worker) throws SQLException {
        daoHotel.addWorker(worker);
    }

    @Override
    public Workers getWorkersIdInfo(Integer workerId) throws SQLException {
        return daoHotel.getWorkersIdInfo(workerId);
    }

    @Override
    public void updateWorkerInfo(Workers worker) throws SQLException {
        daoHotel.updateWorkerInfo(worker);
    }

    @Override
    public void deleteWorker(Integer deleteWorker) throws SQLException {
        daoHotel.deletWorker(deleteWorker);
    }

    @Override
    public void doSignUp(CustomerLogin login) throws SQLException {
        daoHotel.doSignUp(login);
    }



    @Override
    public CustomerLogin doSignIn(String loginUsername, String endCodePassword) throws SQLException {
        return daoHotel.doSignIn(loginUsername,endCodePassword);

    }

    @Override
    public boolean checkUsername(String username) throws SQLException {

        return daoHotel.checkUsername(username);
    }


}
