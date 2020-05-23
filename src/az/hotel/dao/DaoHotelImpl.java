package az.hotel.dao;

import az.hotel.config.DBHelper;
import az.hotel.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoHotelImpl implements DaoHotel {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public List<Customer> loadCustomerList() throws SQLException {
        String sql = "select*from customer where active=1 ";
        return getCustomer(sql);
    }

    @Override
    public List<Workers> loadWorkersList() throws SQLException {
        List<Workers> workers = new ArrayList<>();
        String sql = "select *from workers where active=1";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    Workers worker = new Workers();
                    worker.setId(resultSet.getInt("id"));
                    worker.setName(resultSet.getString("name"));
                    worker.setSurname(resultSet.getString("surname"));
                    worker.setAddress(resultSet.getString("address"));
                    worker.setEmail(resultSet.getString("email"));
                    worker.setTelephone(resultSet.getString("telephone"));
                    worker.setDob(resultSet.getDate("dob"));
                    worker.setPosition(resultSet.getString("position"));
                    workers.add(worker);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }

        return workers;
    }

    @Override
    public void addWorker(Workers worker) throws SQLException {
        String sql = "insert into workers values(SEQ_WORKERS.nextval,?,?,?,?,?,?,?,1)";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            if (connection != null) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setString(2, worker.getSurname());
                preparedStatement.setString(3, worker.getAddress());
                preparedStatement.setDate(4, new Date(worker.getDob().getTime()));
                preparedStatement.setString(5, worker.getEmail());
                preparedStatement.setString(6, worker.getTelephone());
                preparedStatement.setString(7, worker.getPosition());
                preparedStatement.execute();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public Workers getWorkersIdInfo(Integer workerId) throws SQLException {
        String sql = "select *from workers where id=?";
        Workers worker = new Workers();

        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, workerId);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                if (resultSet.next()) {
                    worker.setId(resultSet.getInt("id"));
                    worker.setName(resultSet.getString("name"));
                    worker.setSurname(resultSet.getString("surname"));
                    worker.setAddress(resultSet.getString("address"));
                    worker.setEmail(resultSet.getString("email"));
                    worker.setTelephone(resultSet.getString("telephone"));
                    worker.setDob(resultSet.getDate("dob"));
                    worker.setPosition(resultSet.getString("position"));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return worker;
    }

    @Override
    public void updateWorkerInfo(Workers worker) throws SQLException {
        String sql = "update workers set name=?,surname=?,address=?,dob=?,email=?,telephone=?,position=?,active=1 where id=?";

        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            if (connection != null) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setString(2, worker.getSurname());
                preparedStatement.setString(3, worker.getAddress());
                preparedStatement.setDate(4, new Date(worker.getDob().getTime()));
                preparedStatement.setString(5, worker.getEmail());
                preparedStatement.setString(6, worker.getTelephone());
                preparedStatement.setString(7, worker.getPosition());
                preparedStatement.setInt(8, worker.getId());
                preparedStatement.execute();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void deletWorker(Integer deleteWorker) throws SQLException {
        String sql = "update workers set active=0 where id=?";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            if (connection != null) {
                preparedStatement.setInt(1, deleteWorker);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<RoomNumber> getRoomNumber() throws SQLException {
        List<RoomNumber> roomNumbers = new ArrayList<>();
        String sql = "select*from roomnumber";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    RoomNumber roomNumber = new RoomNumber();
                    roomNumber.setId(resultSet.getInt("id"));
                    roomNumber.setNumberofRoom(resultSet.getInt("Number_of_Room"));
                    roomNumbers.add(roomNumber);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return roomNumbers;
    }

    @Override
    public List<AdultNumber> getAdultNumber() throws SQLException {
        List<AdultNumber> adultNumbers = new ArrayList<>();
        String sql = "select*from adultnumber";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    AdultNumber adultNumber = new AdultNumber();
                    adultNumber.setId(resultSet.getInt("id"));
                    adultNumber.setNumberOfAdult(resultSet.getInt("Number_of_Adults"));
                    adultNumbers.add(adultNumber);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return adultNumbers;
    }

    @Override
    public List<ChildrenNumber> getChildrenNumber() throws SQLException {
        List<ChildrenNumber> childrenNumbers = new ArrayList<>();
        String sql = "select*from childrennumber";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    ChildrenNumber childrenNumber = new ChildrenNumber();
                    childrenNumber.setId(resultSet.getInt("id"));
                    childrenNumber.setNumberOfChildren(resultSet.getInt("Number_of_Children"));
                    childrenNumbers.add(childrenNumber);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return childrenNumbers;
    }

    @Override
    public List<RoomName> getRoomName() throws SQLException {
        List<RoomName> roomNames = new ArrayList<>();
        String sql = "select*from roomnames";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    RoomName roomName = new RoomName();
                    roomName.setId(resultSet.getInt("id"));
                    roomName.setRoomName(resultSet.getString("roomName"));
                    roomNames.add(roomName);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return roomNames;
    }

    @Override
    public void saveCustomerInfo(Customer customer) throws SQLException {
        String sql = "insert into customer values(SEQ_CUSTOMER.nextval,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        try {
            connection = DBHelper.connect();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getAddress());
                preparedStatement.setString(4, customer.getEmail());
                preparedStatement.setString(5, customer.getTelephone());
                preparedStatement.setDate(6, new Date(customer.getInDate().getTime()));
                preparedStatement.setDate(7, new Date(customer.getOutDate().getTime()));
                preparedStatement.setString(8, customer.getNumberOfRoom());
                preparedStatement.setString(9, customer.getAdults());
                preparedStatement.setString(10, customer.getChildren());
                preparedStatement.setString(11, customer.getTypeofRoom());
                preparedStatement.setString(12, customer.getPrice());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public Customer getCustomerIdInfo(Integer customerId) throws SQLException {
        Customer customer = new Customer();
        String sql = "select*from customer where id=?";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            resultSet = preparedStatement.executeQuery();

            if (connection != null) {
                if (resultSet.next()) {
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setTelephone(resultSet.getString("telephone"));
                    customer.setInDate(resultSet.getDate("inDate"));
                    customer.setOutDate(resultSet.getDate("outDate"));
                    customer.setNumberOfRoom(resultSet.getString("number_of_room"));
                    customer.setAdults(resultSet.getString("adults"));
                    customer.setChildren(resultSet.getString("children"));
                    customer.setTypeofRoom(resultSet.getString("type_of_room"));
                    customer.setPrice(resultSet.getString("price"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return customer;
    }

    @Override
    public void updateCustomerInfo(Customer customer) throws SQLException {
        String updateSql = "update customer set name=?,  surname=?,  address=?, email=?, telephone=?, indate=?,  outdate=?, number_of_room=?, adults=?,  children=? , type_of_room=?, price=?,active=1  where id=?  ";
        try {
            connection = DBHelper.connect();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(updateSql);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getAddress());
                preparedStatement.setString(4, customer.getEmail());
                preparedStatement.setString(5, customer.getTelephone());
                preparedStatement.setDate(6, new Date(customer.getInDate().getTime()));
                preparedStatement.setDate(7, new Date(customer.getOutDate().getTime()));
                preparedStatement.setString(8, customer.getNumberOfRoom());
                preparedStatement.setString(9, customer.getAdults());
                preparedStatement.setString(10, customer.getChildren());
                preparedStatement.setString(11, customer.getTypeofRoom());
                preparedStatement.setString(12, customer.getPrice());
                preparedStatement.setInt(13, customer.getId());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void deleteCustomer(Integer deleteCustomer) throws SQLException {
        String sql = "update customer set active=0 where id=?";
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            if (connection != null) {
                preparedStatement.setInt(1, deleteCustomer);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Customer> getSimpleSearchCustomerList(String searchVal) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "select*from customer  where  name like '" + searchVal + "%' or surname like '" + searchVal + "%' ";
        return getCustomer(sql);
    }

    @Override
    public List<Customer> getAdvSearchCustomer(Filter filter) throws SQLException {
        StringBuilder sql = new StringBuilder("select*from customer where ");
        if (Objects.nonNull(filter.getAdvSearchRoomNumber())) {
            sql.append(" number_of_room=")
                    .append(filter.getAdvSearchRoomNumber());
        }
        if (filter.getAdvSearchRoomNumber().equalsIgnoreCase("0") && filter.getAdvSearchRoomName().equalsIgnoreCase("King-Room")) {
            sql.append("type_of_room=")
                    .append(filter.getAdvSearchRoomName());
        }

//        } else if (Objects.nonNull(filter.getAdvSearchInDate()) && Objects.nonNull(filter.getAdvSearchOutDate())) {
//            sql.append("INDATE between to_date('")
//                    .append(new Date(filter.getAdvSearchInDate().getTime()))
//                    .append("','yyyy-MM-dd') and")
//                    .append("to_date('")
//                    .append(new Date(filter.getAdvSearchOutDate().getTime()))
//                    .append("','yyyy-MM-dd')");
//        }

        return getCustomer(sql.toString());
    }


    @Override
    public void doSignUp(CustomerLogin login) throws SQLException {
        String sql = "insert into customerlogin values(SEQ_LOGIN.nextval,?,?,?,?,?,1)";
        try {
            connection = DBHelper.connect();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, login.getName());
                preparedStatement.setString(2, login.getSurname());
                preparedStatement.setDate(3, new Date(login.getDob().getTime()));
                preparedStatement.setString(4, login.getUsername());
                preparedStatement.setString(5, login.getPassword());
                preparedStatement.execute();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
    }


    @Override
    public CustomerLogin doSignIn(String loginUsername, String endCodePassword) throws SQLException {
        String sql = "select*from customerlogin c where C.USERNAME=? and C.PASSWORD=? and c.active=1";

        CustomerLogin login = null;

        try {
            connection = DBHelper.connect();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, loginUsername);
                preparedStatement.setString(2, endCodePassword);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    login = new CustomerLogin();
                    login.setId(resultSet.getInt("id"));
                    login.setName(resultSet.getString("name"));
                    login.setSurname(resultSet.getString("surname"));
                    login.setDob(resultSet.getDate("dob"));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }


        return login;
    }

    @Override
    public boolean checkUsername(String username) throws SQLException {

        String sql = "select count(*) count from customerlogin where username=?";
        try {
            connection = DBHelper.connect();
            if (connection!=null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    if (count > 0) {
                        return true;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }

        return false;
    }


    //UTIL METHODS
    private List<Customer> getCustomer(String sql) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (connection != null) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setTelephone(resultSet.getString("telephone"));
                    customer.setInDate(resultSet.getDate("inDate"));
                    customer.setOutDate(resultSet.getDate("outDate"));
                    customer.setNumberOfRoom(resultSet.getString("number_of_room"));
                    customer.setAdults(resultSet.getString("adults"));
                    customer.setChildren(resultSet.getString("children"));
                    customer.setTypeofRoom(resultSet.getString("type_of_room"));
                    customer.setPrice(resultSet.getString("price"));
                    customers.add(customer);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }

        return customers;
    }


}

