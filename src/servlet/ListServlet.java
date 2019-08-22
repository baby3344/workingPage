package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Working;
import service.WorkingService;
import util.Page;

import java.io.IOException;
import java.util.List;

/**
 * ��ѯ���й����ʼ���Ϣ��Servlet
 * @author Dylan
 *
 */
public class ListServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		Page<Working> page = new Page<Working>();
		int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page.setCurrPageNo(currPageNo);
		page.setPageSize(pageSize);
		WorkingService service = new WorkingService();
		
		List<Working> list = service.getListPage(page.getCurrPageNo(),page.getPageSize());
		
		page.setList(list);

		int totalCount = service.getTotalCount();
		page.setTotalCount(totalCount);
		
		request.setAttribute("page", page);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

	
}
