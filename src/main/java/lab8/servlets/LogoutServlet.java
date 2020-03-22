package lab8.servlets;

import lab8.classes.ChatMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chat/logout")
public class LogoutServlet extends ChatServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Cookie sess = new Cookie("SessionIdCook", null);
		sess.setMaxAge(0);
		resp.addCookie(sess);
	
		ActiveUsers.remove(req.getSession().getAttribute("username"));
		req.getSession().setAttribute("username", null);
		resp.sendRedirect("/chat/login");
	}
}
