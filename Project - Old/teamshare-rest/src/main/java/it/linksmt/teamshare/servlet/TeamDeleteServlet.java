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

import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.services.TeamService;

/**
 * Servlet implementation class TeamDeleteServlet
 */
@WebServlet("/TeamDeleteServlet")
public class TeamDeleteServlet extends HttpServlet {
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
	public TeamDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TeamDto dto = new TeamDto();

			dto.setId(Integer.parseInt(request.getParameter("idDelete")));
			service.deleteTeam(Integer.parseInt(request.getParameter("idDelete")));

			request.setAttribute("teamDeleted", dto);
			RequestDispatcher rd = request.getRequestDispatcher("TeamDeleted.jsp");
			rd.forward(request, response);

		
	}

}
