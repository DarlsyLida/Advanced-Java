import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from registration form
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");

        int age;

        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Please enter a valid age.");
            return;
        }

        // Check age eligibility
        if (age < 18) {
            response.sendRedirect("notEligible.jsp");
            return;
        }

        Connection con = null;

        try {

            // Connect to database
            con = DBConnection.getConnection();

            if (con == null) {
                response.getWriter().println(
                        "Database connection failed."
                );
                return;
            }

            // -----------------------------------------
            // CHECK IF MOBILE NUMBER ALREADY EXISTS
            // -----------------------------------------

            String checkSql =
                    "SELECT id, name FROM users WHERE mobile = ?";

            PreparedStatement checkPs =
                    con.prepareStatement(checkSql);

            checkPs.setString(1, mobile);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                String existingName = rs.getString("name");

                rs.close();
                checkPs.close();

                response.getWriter().println(
                        "This mobile number is already registered."
                );

                response.getWriter().println(
                        "<br>Registered voter: " + existingName
                );

                return;
            }

            rs.close();
            checkPs.close();

            // -----------------------------------------
            // INSERT NEW VOTER
            // -----------------------------------------

            String sql =
                    "INSERT INTO users " +
                            "(name, city, mobile, gender, age) " +
                            "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS
                    );

            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, mobile);
            ps.setString(4, gender);
            ps.setInt(5, age);

            ps.executeUpdate();

            // -----------------------------------------
            // GET GENERATED USER ID
            // -----------------------------------------

            ResultSet generatedKeys =
                    ps.getGeneratedKeys();

            int userId = 0;

            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
            }

            generatedKeys.close();
            ps.close();

            // -----------------------------------------
            // SAVE USER INFORMATION IN SESSION
            // -----------------------------------------

            HttpSession session =
                    request.getSession();

            session.setAttribute("userId", userId);
            session.setAttribute("userName", name);
            session.setAttribute("mobile", mobile);

            // Go to voting page
            response.sendRedirect("vote.jsp");

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {

            // Handles UNIQUE mobile constraint
            response.getWriter().println(
                    "This mobile number is already registered."
            );

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Registration Error: " + e.getMessage()
            );

        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}