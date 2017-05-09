package br.com.monster.portal.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	  @Override
	  public boolean preHandle(HttpServletRequest request, 
	      HttpServletResponse response,
	      Object controller) throws Exception {

	      String uri = request.getRequestURI();
	      if(uri.endsWith("index")				||
	    	 uri.endsWith("Contato")			||
	    	 uri.contains("Categoria")			||
	    	 uri.contains("Produtos")			||
	    	 
	    	 uri.endsWith("carrinho")			||
	    	 uri.endsWith("AdicionaItemCarrinho")	||
	    	 uri.endsWith("RemoveItemCarrinho")	||

	    	 uri.endsWith("checarIdentificacao")||
	    	 uri.endsWith("identificacao")		||
	    	 uri.endsWith("Cadastro")			||
	    	 uri.endsWith("CreateCliente")		||
	    	 uri.endsWith("CreateIdentificacaoCliente")	||
	    	 uri.endsWith("Login")				||
	    	 uri.endsWith("efetuaLogin")		||
	    	 uri.endsWith("LoginIdentificacao")	||
	    	 
	    	 uri.endsWith("consultarFrete")		||
	    	 
	    	 uri.endsWith("comprar_agora")		||
	    	 uri.endsWith("forma_de_pagamento")	||
	    	 uri.endsWith("FinalizarCompraSegura")	||
	    	 uri.endsWith("Boleto")				||
	    	 
	    	 uri.endsWith("Login")				||
	         uri.endsWith("efetuaLogin")		|| 
	         uri.endsWith("Admin/LoginAdmin")	|| 
	         uri.endsWith("efetuaLoginAdmin")	|| 
	                   uri.contains("resources")){
	        return true;
	      }

	      if(request.getSession()
	          .getAttribute("clienteLogado") != null) {
	        return true;
	      }
	      
	      /*
	       * ---------------------------
	       * 			Admin			
	       * ---------------------------
	       */
	      
	      if(request.getSession()
	 	     .getAttribute("administradorLogado") == null 
	 	     && (uri.contains("Admin")) ){
		      response.sendRedirect("/Monsters_Portal/Admin/LoginAdmin");
		      return false;
	 	  }

	      if(request.getSession()
	          .getAttribute("administradorLogado") != null) {
	        return true;
	      }

	      response.sendRedirect("/Monsters_Portal/Login");
	      return false;
	  }
	}
