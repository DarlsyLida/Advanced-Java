import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get session
        HttpSession session =
                request.getSession(false);

        // Check if voter is registered
        if (session == null ||
                session.getAttribute("userId") == null) {

            response.getWriter().println(
                    "Please register before voting."
            );

            return;
        }

        // Get user ID from session
        Integer userId =
                (Integer) session.getAttribute("userId");

        // Get selected candidate
        String candidate =
                request.getParameter("candidate");

        // Check candidate selection
        if (candidate == null ||
                candidate.trim().isEmpty()) {

            response.getWriter().println(
                    "Please select a candidate."
            );

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
            // CHECK IF USER HAS ALREADY VOTED
            // -----------------------------------------

            String checkSql =
                    "SELECT id FROM votes WHERE user_id = ?";

            PreparedStatement checkPs =
                    con.prepareStatement(checkSql);

            checkPs.setInt(1, userId);

            ResultSet rs =
                    checkPs.executeQuery();

            if (rs.next()) {

                rs.close();
                checkPs.close();

                response.getWriter().println(
                        "You have already voted."
                );

                return;
            }

            rs.close();
            checkPs.close();

            // -----------------------------------------
            // INSERT VOTE
            // -----------------------------------------

            String insertSql =
                    "INSERT INTO votes " +
                            "(user_id, candidate) " +
                            "VALUES (?, ?)";

            PreparedStatement insertPs =
                    con.prepareStatement(insertSql);

            insertPs.setInt(1, userId);
            insertPs.setString(2, candidate);

            insertPs.executeUpdate();

            insertPs.close();

            // -----------------------------------------
            // SAVE SELECTED CANDIDATE IN SESSION
            // -----------------------------------------

            session.setAttribute(
                    "candidate",
                    candidate
            );

            // Go to success page
            response.sendRedirect("success.jsp");

        } catch (
                java.sql.SQLIntegrityConstraintViolationException e) {

            // Handles UNIQUE(user_id) constraint
            response.getWriter().println(
                    "You have already voted. " +
                            "A voter can vote only once."
            );

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Voting Error: " + e.getMessage()
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