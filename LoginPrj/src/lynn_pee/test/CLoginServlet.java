package lynn_pee.test;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lynn_pee.SimsDB.CStudentDB;
import lynn_pee.Student.CStudentInfo;

/**
 * Servlet implementation class CLoginServlet
 */
@WebServlet("/CLoginServlet")
public class CLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		/*Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("pishuli", "123");
		userMap.put("liuhui", "1234");
		userMap.put("hanye", "1234");
		
		for (Map.Entry<String, String>  entry: userMap.entrySet())
		{
			System.out.println(entry.getKey()+":"+entry.getValue());
		}*/
		boolean isLoginSuc = false;
		CStudentDB stuDB = new CStudentDB();
		CStudentInfo stuInfo = new CStudentInfo();
		int ret = stuDB.findStudent(userName, stuInfo);
		
		if(ret < 0)
		{
			request.setAttribute("loginMessage", "用户名不存在！");
		}
		else
		{
			if (stuInfo.getPassword().equals(passwd))
			{
				isLoginSuc = true;
			}
			else
			{
				request.setAttribute("loginMessage", "密码错误！");
			}
		}
		if (isLoginSuc)
		{
			request.getRequestDispatcher("/LoginSuc.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
