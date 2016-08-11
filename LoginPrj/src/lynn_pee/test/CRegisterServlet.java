package lynn_pee.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lynn_pee.SimsDB.CStudentDB;
import lynn_pee.Student.CStudentInfo;

/**
 * Servlet implementation class CRegisterServlet
 */
@WebServlet("/CRegisterServlet")
public class CRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRegisterServlet() {
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
		String userNameStr = request.getParameter("userName");
		String passwdStr = request.getParameter("passwd");
		String phoneNum = request.getParameter("phoneNum");
		CStudentDB stuDB = new CStudentDB();
		CStudentInfo stuInfo = new CStudentInfo();
		stuInfo.setName(userNameStr);
		stuInfo.setPassword(passwdStr);
		stuInfo.setPhone(phoneNum);
		
		int ret = stuDB.addStudent(stuInfo);
		request.setAttribute("userName",userNameStr);
		if (ret >= 0)
		{
			//request.setAttribute("registerMsg", "登录成功");
			//request.getRequestDispatcher("RegisterSuc.jsp").forward(request, response);
			request.setAttribute("studentMsg", stuInfo);
			request.getRequestDispatcher("testJavaBean.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("registerMsg", "用户名已存在");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
