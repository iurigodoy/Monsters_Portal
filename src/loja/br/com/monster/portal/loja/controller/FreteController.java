package br.com.monster.portal.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.frete.CalculoFreteCorreio;
import br.com.monster.portal.frete.ListaFrete;

@Controller
public class FreteController {

	@RequestMapping(value = "/consultarFrete")
	public String consultaFrete(String cep_cli, String cep_forn, String altura, String largura, String comprimento, String peso, String diametro, Model model){

		// Dados pesquisa
		// Informações da empresa e cliente
		String nCdEmpresa = "";				//
		String sDsSenha = ""; 				//
		String sCepOrigem = cep_forn;		// CEP Fornecedor
		String sCepDestino = cep_cli;		// CEP Cliente
		
		/*
		 *	Serviços do Correio
		 *	-------------------
		 *	40010 SEDEX Varejo
		 *	40045 SEDEX a Cobrar Varejo
		 *	40215 SEDEX 10 Varejo
		 *	40290 SEDEX Hoje Varejo
		 *	41106 PAC Varejo
		 */
		String nCdServico = "04014";
		
		//				Informações do produto
		String nVlPeso = peso; //peso
		String nCdFormato = "1";			// 1 – Formato caixa/pacote, 2 – Formato rolo/prisma, 3 - Envelope
		String nVlComprimento = comprimento;
		String nVlAltura = altura;
		String nVlLargura = largura;
		String nVlDiametro = diametro;			// 
		//				Informações do fornecedor
		String sCdMaoPropria = "N";			// Indica se a encomenda será entregue com o serviço adicional mão própria, S ou N
		String nVlValorDeclarado = "0";		//
		String sCdAvisoRecebimento = "N";	// Indica se a encomenda será entregue com o serviço adicional aviso de recebimento. S ou N
		String StrRetorno = "xml"; 			// formato
		
		ListaFrete listafrete = CalculoFreteCorreio.main(nCdEmpresa,sDsSenha,sCepOrigem,sCepDestino,nCdServico,
				nVlPeso,nCdFormato,nVlComprimento,nVlAltura,nVlLargura,nVlDiametro,
				sCdMaoPropria,nVlValorDeclarado,sCdAvisoRecebimento,StrRetorno);
		
		model.addAttribute("frete", listafrete);
		
		return "/frete";
	}
}
