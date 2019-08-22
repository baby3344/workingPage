package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Working;
import service.WorkingService;

public class SaveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		WorkingService service = new WorkingService();
		
		Working w = new Working();
		
		w.setContent(request.getParameter("content"));
		w.setTitle(request.getParameter("title"));
		w.setType(Integer.parseInt(request.getParameter("type")));
		
		int result = service.save(w);
		
		if (result<0) {
			out.print("<script>alert('��ӳɹ�');location.href='listServlet';</script>");
		} else {
			out.print("<script>alert('���ʧ��');history.back();</script>");
		}
		
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
