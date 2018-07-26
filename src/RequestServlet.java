import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RequestServlet extends HttpServlet implements HttpSessionListener {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(10);
        try {
            System.out.println("MySession Create :"+session.getId());
            session.setAttribute("foo","bar");
        } catch (Exception e) {
            System.out.println("ErrorMessage : " + e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
