package it.linksmt.teamshare.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import it.linksmt.teamshare.business.dto.request.TeamRequestDto;
import it.linksmt.teamshare.business.services.TeamService;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TeamService service;

	private WebApplicationContext springContext;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!(request.getParameter("id").isEmpty())) {
			request.setAttribute("team", service.getTeam(Integer.parseInt(request.getParameter("id"))));

			RequestDispatcher rd = request.getRequestDispatcher("OneTeam.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("team", service.getTeams());

			RequestDispatcher rd = request.getRequestDispatcher("teamResponse.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TeamRequestDto dto = new TeamRequestDto();

		
		if (!(request.getParameter("name").isEmpty())) {

			dto.setName(request.getParameter("name"));

			service.addTeam(dto);

			request.setAttribute("teamAdded", dto);
			RequestDispatcher rd = request.getRequestDispatcher("TeamAdded.jsp");
			rd.forward(request, response);
		}
	}

}
