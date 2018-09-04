import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Test extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Map cookieMap = new HashMap();
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0 ; i < cookies.length ; i++) {
                cookieMap.put(cookies[i].getName(), cookies[i]);

            }
        }

        System.out.println(cookies);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("id","music4u");
        httpSession.setMaxInactiveInterval(10*1);
        System.out.println(httpSession.getId());
//        PrintWriter out = resp.getWriter();
//        if (httpSession.getAttribute("id") == null) {
////            out.println("<br>");
////            out.println("돌아가요");
//            out.println("<script>");
//            out.println("alert('로그인 유효시간이 만료되었습니다.');");
//            out.println("window.location.href = \"/index.jsp\";");
//            out.println("</script>");
//            httpSession.removeAttribute("id");
////            resp.sendRedirect("/index.jsp");
//        } else {
////            PrintWriter out = resp.getWriter();
//            out.println(httpSession.getAttribute("id"));
//            System.out.println(req);
//        }
    }
}
