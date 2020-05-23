package az.hotel.controller;

import az.hotel.dao.DaoHotel        ;
import az.hotel.dao.DaoHotelImpl;
import az.hotel.model.CustomerLogin;
import az.hotel.service.ServiceHotel;
import az.hotel.service.ServiceHotelImpl;
import az.hotel.util.SecurityUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, NoSuchAlgorithmException, SQLException {
        DaoHotel daoHotel = new DaoHotelImpl();
        ServiceHotel serviceHotel = new ServiceHotelImpl(daoHotel);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String action = "";
        String address = "";

        try {
            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }
            if (action.equalsIgnoreCase("doSignUp")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String dob = request.getParameter("dob");
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                CustomerLogin login = new CustomerLogin();
                login.setName(name);
                login.setSurname(surname);
                login.setDob(dateFormat.parse(dob));
                login.setUsername(username);
                login.setPassword(SecurityUtil.endCodePassword(password));
                serviceHotel.doSignUp(login);


            } else if (action.equalsIgnoreCase("doSignIn")) {
                String loginUsername = request.getParameter("loginUsername");
                String loginPassword = request.getParameter("loginPassword");

                HttpSession session = request.getSession();
                if (Objects.isNull(loginUsername) || loginUsername.trim().equals("")
                        || Objects.isNull(loginPassword) || loginPassword.trim().equals("")) {
                    System.out.println("Must be fill!");
                    request.setAttribute("errorMessage", "Must be fill!");
                    address = "login.jsp";
                } else {
                    CustomerLogin login = serviceHotel.doSignIn(loginUsername, SecurityUtil.endCodePassword(loginPassword));
                    if (Objects.isNull(login)) {
                        System.out.println("Invalid Username and Password");
                        request.setAttribute("errorMessage", "Invalid Username or Password");
                    } else {
                        System.out.println("Success");
                        session.setAttribute("login", login);
                        response.sendRedirect("index.jsp");
                    }
                }
            }else if(action.equalsIgnoreCase("checkUsername")){
                String username=request.getParameter("username");
                boolean exists=serviceHotel.checkUsername(username);
                request.setAttribute("exists",exists);
                address="WEB-INF/parts/part-exists-username.jsp";
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
