package az.hotel.controller;

import az.hotel.dao.DaoHotel;
import az.hotel.dao.DaoHotelImpl;
import az.hotel.model.*;
import az.hotel.service.ServiceHotel;
import az.hotel.service.ServiceHotelImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/controller")
public class CustomerServlet extends HttpServlet {
    Logger logger = Logger.getLogger(CustomerServlet.class);

    @Override
    public void destroy() {
        logger.info("init~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void init() throws ServletException {
        logger.info("destroy~~~~~~~~~~~~~~~~~~~~~~~~~~`");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = "";
        String address = "";
        DaoHotel daoHotel = new DaoHotelImpl();
        ServiceHotel serviceHotel = new ServiceHotelImpl(daoHotel);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }
            if (action.equalsIgnoreCase("loadCustomerList")) {
                List<Customer> customers = serviceHotel.loadCustomerList();
                request.setAttribute("customers", customers);
                address = "WEB-INF/parts/part-customer-list.jsp";

            } else if (action.equalsIgnoreCase("loadWorkersList")) {
                List<Workers> workers = serviceHotel.loadWorkersList();
                request.setAttribute("workers", workers);
                address = "WEB-INF/parts/part-workers-list.jsp";

            } else if (action.equalsIgnoreCase("addWorker")) {
                String workerName = request.getParameter("workerName");
                String workerSurname = request.getParameter("workerSurname");
                String workerAddress = request.getParameter("workerAddress");
                String workerDob = request.getParameter("workerDob");
                String workerEmail = request.getParameter("workerEmail");
                String workerTel = request.getParameter("workerTel");
                String workerPosition = request.getParameter("workerPosition");

                Workers worker = new Workers();
                worker.setName(workerName);
                worker.setSurname(workerSurname);
                worker.setAddress(workerAddress);
                worker.setDob(dateFormat.parse(workerDob));
                worker.setEmail(workerEmail);
                worker.setTelephone(workerTel);
                worker.setPosition(workerPosition);

                serviceHotel.addWorker(worker);

            } else if (action.equalsIgnoreCase("getWorkersIdInfo")) {
                Integer workerId = Integer.parseInt(request.getParameter("workerId"));
                Workers worker = serviceHotel.getWorkersIdInfo(workerId);
                request.setAttribute("worker", worker);
                address = "WEB-INF/parts/part-edit-workers.jsp";

            } else if (action.equalsIgnoreCase("updateWorkerInfo")) {
                Integer globalWorkerId = Integer.parseInt(request.getParameter("globalWorkerId"));
                String editWorkerName = request.getParameter("editWorkerName");
                String editWorkerSurname = request.getParameter("editWorkerSurname");
                String editWorkerAddress = request.getParameter("editWorkerAddress");
                String editWorkerDob = request.getParameter("editWorkerDob");
                String editWorkerEmail = request.getParameter("editWorkerEmail");
                String editWorkerTel = request.getParameter("editWorkerTel");
                String editWorkerPosition = request.getParameter("editWorkerPosition");

                Workers worker = new Workers();
                worker.setName(editWorkerName);
                worker.setSurname(editWorkerSurname);
                worker.setAddress(editWorkerAddress);
                worker.setDob(dateFormat.parse(editWorkerDob));
                worker.setEmail(editWorkerEmail);
                worker.setTelephone(editWorkerTel);
                worker.setPosition(editWorkerPosition);
                worker.setId(globalWorkerId);
                serviceHotel.updateWorkerInfo(worker);

            } else if (action.equalsIgnoreCase("deleteWorker")) {
                Integer deleteWorker = Integer.parseInt(request.getParameter("globalWorkerId"));
                serviceHotel.deleteWorker(deleteWorker);

            } else if (action.equalsIgnoreCase("getRoomNumber")) {
                List<RoomNumber> roomNumbers = serviceHotel.getRoomNumber();
                request.setAttribute("roomNumbers", roomNumbers);
                address = "WEB-INF/combo/room-number-combo.jsp";

            } else if (action.equalsIgnoreCase("getAdultNumber")) {
                List<AdultNumber> adultNumbers = serviceHotel.getAdultNumber();
                request.setAttribute("adultNumbers", adultNumbers);
                address = "WEB-INF/combo/adult-number-combo.jsp";

            } else if (action.equalsIgnoreCase("getChildrenNumber")) {
                List<ChildrenNumber> childrenNumbers = serviceHotel.getChildrenNumber();
                request.setAttribute("childrenNumbers", childrenNumbers);
                address = "WEB-INF/combo/children-number-combo.jsp";

            } else if (action.equalsIgnoreCase("getRoomName")) {
                List<RoomName> roomNames = serviceHotel.getRoomName();
                request.setAttribute("roomNames", roomNames);
                address = "WEB-INF/combo/room-name-combo.jsp";

            } else if (action.equalsIgnoreCase("saveCustomerInfo")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String customerAddress = request.getParameter("customerAddress");
                String email = request.getParameter("email");
                String telephone = request.getParameter("telephone");
                String inDate = request.getParameter("inDate");
                String outDate = request.getParameter("outDate");
                String numberOfRoom = request.getParameter("numberOfRoom");
                String numberOfAdults = request.getParameter("numberOfAdults");
                String numberOfChildren = request.getParameter("numberOfChildren");
                String roomType = request.getParameter("roomType");
                String price = request.getParameter("price");

                Customer customer = new Customer();
                customer.setName(name);
                customer.setSurname(surname);
                customer.setAddress(customerAddress);
                customer.setEmail(email);
                customer.setTelephone(telephone);
                customer.setInDate(dateFormat.parse(inDate));
                customer.setOutDate(dateFormat.parse(outDate));
                customer.setNumberOfRoom(numberOfRoom);
                customer.setAdults(numberOfAdults);
                customer.setChildren(numberOfChildren);
                customer.setTypeofRoom(roomType);
                customer.setPrice(price);
                serviceHotel.saveCustomerInfo(customer);

            } else if (action.equalsIgnoreCase("getCustomerIdInfo")) {
                Integer customerId = Integer.parseInt(request.getParameter("customerId"));
                Customer customer = serviceHotel.getCustomerIdInfo(customerId);
                request.setAttribute("customer", customer);
                address = "WEB-INF/parts/part-edit-customer.jsp";

            } else if (action.equalsIgnoreCase("updateCustomerInfo")) {
                Integer globalCustomerId = Integer.parseInt(request.getParameter("globalCustomerId"));
                String editName = request.getParameter("editName");
                String editSurname = request.getParameter("editSurname");
                String editAddress = request.getParameter("editAddress");
                String editEmail = request.getParameter("editEmail");
                String editTelephone = request.getParameter("editTelephone");
                String editInDate = request.getParameter("editInDate");
                String editOutDate = request.getParameter("editOutDate");
                String editNumberOfRoom = request.getParameter("editNumberOfRoom");
                String editNumberOfAdults = request.getParameter("editNumberOfAdults");
                String editNumberOfChildren = request.getParameter("editNumberOfChildren");
                String editRoomType = request.getParameter("editRoomType");
                String editPrice = request.getParameter("editPrice");

                Customer customer = new Customer();
                customer.setName(editName);
                customer.setSurname(editSurname);
                customer.setAddress(editAddress);
                customer.setEmail(editEmail);
                customer.setTelephone(editTelephone);
                customer.setInDate(dateFormat.parse(editInDate));
                customer.setOutDate(dateFormat.parse(editOutDate));
                customer.setNumberOfRoom(editNumberOfRoom);
                customer.setAdults(editNumberOfAdults);
                customer.setChildren(editNumberOfChildren);
                customer.setTypeofRoom(editRoomType);
                customer.setPrice(editPrice);
                customer.setId(globalCustomerId);
                serviceHotel.updateCustomerInfo(customer);

            } else if (action.equalsIgnoreCase("deleteCustomer")) {
                Integer deleteCustomer = Integer.parseInt(request.getParameter("globalCustomerId"));
                serviceHotel.deleteCustomer(deleteCustomer);

            } else if (action.equalsIgnoreCase("getSimpleSearchCustomerList")) {
                String searchVal = request.getParameter("searchVal");
                List<Customer> customers = serviceHotel.getSimpleSearchCustomerList(searchVal);
                address = "WEB-INF/parts/part-customer-list.jsp";
                request.setAttribute("customers", customers);

            } else if (action.equalsIgnoreCase("getAdvSearchCustomer")) {
                String advSearchInDate = request.getParameter("advSearchInDate");
                String advSearchOutDate = request.getParameter("advSearchOutDate");
                String advSearchRoomNumber = request.getParameter("advSearchRoomNumber");
                String advSearchRoomName = request.getParameter("advSearchRoomName");
                Filter filter = new Filter();
                filter.setAdvSearchInDate(!advSearchInDate.equals("") ? dateFormat.parse(advSearchInDate) : null);
                filter.setAdvSearchOutDate(!advSearchOutDate.equals("") ? dateFormat.parse(advSearchOutDate) : null);
                filter.setAdvSearchRoomNumber(advSearchRoomNumber);
                filter.setAdvSearchRoomName(advSearchRoomName);
                List<Customer> customers = serviceHotel.getAdvSearchCustomer(filter);
                request.setAttribute("customers", customers);
                address = "WEB-INF/parts/part-customer-list.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
