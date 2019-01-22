package it.linksmt.teamshare.servlet;

import java.io.IOException;
import java.util.Date;

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

import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.services.ActivityService;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet("/Activity")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ActivityService service;	
	
	private WebApplicationContext springContext;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	// private ActivityServiceImpl activityServiceImpl = new ActivityServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!(request.getParameter("id").isEmpty())) {
			request.setAttribute("act", service.getActivity(Integer.parseInt(request.getParameter("id"))));

			RequestDispatcher rd = request.getRequestDispatcher("OneActivity.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("act", service.getActivities());

			RequestDispatcher rd = request.getRequestDispatcher("activityResponce.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActivityRequestDto dto = new ActivityRequestDto();

		if (!(request.getParameter("title").isEmpty())) {
			dto.setTitle(request.getParameter("title"));
		}

		if (!(request.getParameter("description").isEmpty())) {
			dto.setDescription(request.getParameter("description"));
		}
		
		if (!(request.getParameter("priority").isEmpty())) {
			dto.setPriority(request.getParameter("priority"));
		}

//			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			dto.setDateTakenIntoCharge(date);

		if (!(request.getParameter("type").isEmpty())) {
			dto.setType(request.getParameter("type"));
		}

		if (!(request.getParameter("userAssignee").isEmpty())) {
			dto.setIdUserAssignee(Integer.parseInt(request.getParameter("userAssignee")));
		}

		if (!(request.getParameter("userCreator").isEmpty())) {
			dto.setIdUserCreator(Integer.parseInt(request.getParameter("userCreator")));
		}
		
		service.addActivity(dto);

//		try {
//			service.addActivity(dto);
//		} catch (Exception e) {
//			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
//			rd.forward(request, response);
//		}

		request.setAttribute("actAdded", dto);
		RequestDispatcher rd = request.getRequestDispatcher("ActivityAdded.jsp");
		rd.forward(request, response);
	}

}
