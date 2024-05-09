package Controller;

import Model.Book;
import Model.Students;
import service.BookDAO;
import service.StudentsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (name="BookServlet", urlPatterns = "/book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BookServlet extends HttpServlet {
        private BookDAO bookDAO;
        public void init() {
            BookDAO BookDAO = new BookDAO();
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "borrow":
                try {
                    showFormBorrow(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showAllListBook(req,resp);
                break;
        }
    }

        private void showFormBorrow(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            BookDAO bookDAO = new BookDAO();
            StudentsDAO studentsDAO = new StudentsDAO();
            Book book = bookDAO.findBookByID(id);
            StudentsDAO studentsDAO1 = new StudentsDAO();
            List<Students> students =studentsDAO1.showstudent();
            req.setAttribute("stu",students );
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/borrow.jsp");
            req.setAttribute("bookbr", book);
            dispatcher.forward(req, resp);

        }


    private void showAllListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
        List<Book> listbook = bookDAO.showAllBook();
        req.setAttribute("listBook", listbook);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/bookview.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
//            case:
            default:
                showAllListBook(req,resp);
                break;
        }
    }
}
