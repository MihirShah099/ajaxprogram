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

/**
 * Servlet implementation class statecon1
 */
@WebServlet("/statecon1")
public class statecon1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public statecon1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		if(flag.equals("search1")){
			

			try {
				search1(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		else if(flag.equals("statesearch")){
				try{
					statesearch(request,response);
				}catch(Exception e){
					e.printStackTrace();
				}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}
	

void search1(HttpServletRequest request,HttpServletResponse response)throws Exception{
	countryvo v1=new countryvo();
	countridao v2=new countridao();
	List ls = v2.search(v1);
	System.out.println("list size:"+ls.size());
	HttpSession u=request.getSession();
	u.setAttribute("ls",ls);
	
	
	response.sendRedirect("state1.jsp");
	
}
void statesearch(HttpServletRequest request,HttpServletResponse response)throws Exception{
	
	String countryId = request.getParameter("countryId");
	
	countryvo v3=new countryvo();
	v3.setId(Integer.parseInt(countryId));
	
	statevo1 v1=new statevo1();
	v1.setCid(v3);
	
	statedao v2=new statedao();
	List list = v2.search(v1);
	
	HttpSession u=request.getSession();
	u.setAttribute("list",list);
	
	System.out.println("list size:"+list.size());
	response.sendRedirect("json1.jsp");
}
}


