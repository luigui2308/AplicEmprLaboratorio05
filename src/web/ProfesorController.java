package universidad.web;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import universidad.service.ProfesorManager;
import universidad.domain.Profesor;

public class ProfesorController implements Controller
{
	private ProfesorManager ProfesorManager;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switch (request.getParameter("mode"))
		{
			case "new": return newForm(request, response);
			case "detail": return detail(request, response);
			case "edit": return edit(request, response);
			case "insert": return insert(request, response);
			case "delete": return delete(request, response);
			default: return list(request, response);
		}
	}
	
	public ModelAndView newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("profesorNew", "model", null);
	}
	
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("profesorDetail", "model", findProfesor(request.getParameter("id")));
	}
	
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Profesor profesor = findProfesor(request.getParameter("txtProfessorId"));
		profesor.setNombProf(request.getParameter("txtProfessorName"));
		profesor.setTituloProf(request.getParameter("txtProfessorGrade"));
		return list(request, response);
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String txtProfesorId = request.getParameter("txtProfessorId");
		if (findProfesor(txtProfesorId) == null)
		{
			Profesor profesor = new Profesor();
			profesor.setIdProf(txtProfesorId);
			profesor.setNombProf(request.getParameter("txtProfessorName"));
			profesor.setTituloProf(request.getParameter("txtProfessorGrade"));
			this.ProfesorManager.getProfesores().add(profesor);
		}
		return list(request, response);
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.ProfesorManager.getProfesores().remove(findProfesor(request.getParameter("id")));
		return list(request, response);
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("profesores", this.ProfesorManager.getProfesores());
		return new ModelAndView("profesorList", "model", myModel);
	}
	
	public Profesor findProfesor(String id) throws ServletException, IOException
	{
		for (Profesor profesor : this.ProfesorManager.getProfesores())
		{
			if (id.equals(profesor.getIdProf()))
			{
				return profesor;
			}
		}
		return null;
	}
	
	public void setProfesorManager(ProfesorManager ProfesorManager)
	{
		this.ProfesorManager = ProfesorManager;
	}
}