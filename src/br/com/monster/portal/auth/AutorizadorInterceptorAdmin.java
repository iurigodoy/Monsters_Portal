package br.com.monster.portal.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptorAdmin extends HandlerInterceptorAdapter {

	  @Override
	  public boolean preHandle(HttpServletRequest request, 
	      HttpServletResponse response,
	      Object controller) throws Exception {

	      String uri = request.getRequestURI();
	      if(uri.endsWith("Admin/LoginAdmin") ||
	    	 uri.endsWith("Admin/LoginEsqueciSenhaAdmin") ||
	         uri.endsWith("Admin/efetuaLoginAdmin") || 
	                   uri.contains("resources")){
	        return true;
	      }

	      if(request.getSession()
	          .getAttribute("administradorLogado") != null) {
	        return true;
	      }

	      response.sendRedirect("LoginAdmin");
	      return false;
	  }
	}
