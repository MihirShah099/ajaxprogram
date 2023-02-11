package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.countridao;
import dao.statedao;
import vo.countryvo;
import vo.statevo1;
import vo.cityvo;
import dao.citydao;

/**
 * Servlet implementation class citycon
 */
@WebServlet("/citycon")
public class citycon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public citycon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		if (flag.equals("search1")) {
			try {
				search1(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (flag.equals("citysearch")) {
			try {
				citysearch(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String s1 = request.getParameter("cname");

		cityvo v1 = new cityvo();
		v1.setCname(s1);
		citydao d1 = new citydao();
		d1.insert(v1);
		response.sendRedirect("menu.jsp");

	}

	void search1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		countryvo v1 = new countryvo();

		countridao v2 = new countridao();

		List ls = v2.search(v1);

		System.out.println("list size:" + ls.size());

		HttpSession u = request.getSession();

		u.setAttribute("ls", ls);

		response.sendRedirect("city.jsp");
	}

	void statesearch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String countryId = request.getParameter("countryId");

		countryvo v3 = new countryvo();
		v3.setId(Integer.parseInt(countryId));

		statevo1 v1 = new statevo1();
		v1.setCid(v3);

		statedao v2 = new statedao();
		List list = v2.search(v1);

		HttpSession u = request.getSession();
		u.setAttribute("list", list);

		System.out.println("list size:" + list.size());
		response.sendRedirect("json1.jsp");
	}

	void citysearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String stateId = request.getParameter("stateId");

		statevo1 v1 = new statevo1();
		v1.setId(Integer.parseInt(stateId));

		cityvo v5 = new cityvo();
		v5.setSid(v1);
		citydao v6 = new citydao();
		List ls = v6.search(v5);
		HttpSession r = request.getSession();
		r.setAttribute("ls", ls);
		System.out.println("list size:" + ls.size());
		response.sendRedirect("json2.jsp");
	}
}
