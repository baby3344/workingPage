package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = upload.parseRequest(request);
				
				for (FileItem item : items) {
					
					if(item.isFormField()){ //判断是否为普通字段
						String fieldName = item.getFieldName(); //表单字段元素的name属性值
						if (fieldName.equals("user")) {
							out.print(item.getString("utf-8")+"上传了文件。<br/>");
						}
						
					} else {
						//文件字段，需要上传处理
						String fileName = item.getName();
						if (fileName!=null && !fileName.equals("")) {
							
							File saveFile = new File(uploadFilePath, fileName);
							
							item.write(saveFile);
							
							out.print("上传成功后的文件名是："+fileName);
						}
					}
					
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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