package br.com.monster.portal.frete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CalculoFreteCorreio {
	public static ListaFrete main(
		// Dados pesquisa
		// Informações da empresa e cliente
		String nCdEmpresa,				//
		String sDsSenha, 				//
		String sCepOrigem,				// CEP Fornecedor
		String sCepDestino,				// CEP Cliente
		
		/*
		 *	Serviços do Correio
		 *	-------------------
		 *	40010 SEDEX Varejo
		 *	40045 SEDEX a Cobrar Varejo
		 *	40215 SEDEX 10 Varejo
		 *	40290 SEDEX Hoje Varejo
		 *	41106 PAC Varejo
		 */
		String nCdServico,
		
		//				Informações do produto
		String nVlPeso,					// Peso do produto
		String nCdFormato,				// 1 – Formato caixa/pacote, 2 – Formato rolo/prisma, 3 - Envelope
		String nVlComprimento,			// 
		String nVlAltura,				// 
		String nVlLargura,				// 
		String nVlDiametro,				// 
		//				Informações do fornecedor
		String sCdMaoPropria,			// Indica se a encomenda será entregue com o serviço adicional mão própria, S ou N
		String nVlValorDeclarado,		//
		String sCdAvisoRecebimento,		// Indica se a encomenda será entregue com o serviço adicional aviso de recebimento. S ou N
		String StrRetorno	  			// formato
		) {
		
		ListaFrete listaFrete = new ListaFrete();
		
		
		//URL do webservice correio para calculo de frete
		String urlString = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
		// os parametros a serem enviados
		Properties parameters = new Properties();
		parameters.setProperty("nCdEmpresa", nCdEmpresa);
		parameters.setProperty("sDsSenha", sDsSenha);
		parameters.setProperty("nCdServico", nCdServico);
		parameters.setProperty("sCepOrigem", sCepOrigem);
		parameters.setProperty("sCepDestino", sCepDestino);
		parameters.setProperty("nVlPeso", nVlPeso);
		parameters.setProperty("nCdFormato", nCdFormato);
		parameters.setProperty("nVlComprimento", nVlComprimento);
		parameters.setProperty("nVlAltura", nVlAltura);
		parameters.setProperty("nVlLargura", nVlLargura);
		parameters.setProperty("nVlDiametro", nVlDiametro);
		parameters.setProperty("sCdMaoPropria", sCdMaoPropria);
		parameters.setProperty("nVlValorDeclarado", nVlValorDeclarado);
		parameters.setProperty("sCdAvisoRecebimento", sCdAvisoRecebimento);
		parameters.setProperty("StrRetorno", StrRetorno);
		// o iterador, para criar a URL
		Iterator i = parameters.keySet().iterator();
		// o contador
		int counter = 0;
		// enquanto ainda existir parametros
		while (i.hasNext()) {
			// pega o nome
			String name = (String) i.next();
			// pega o valor
			String value = parameters.getProperty(name);
			// adiciona com um conector (? ou &)
			// o primeiro é ?, depois são &
			urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
		}
		try {
			// cria o objeto url
			URL url = new URL(urlString);
			// cria o objeto httpurlconnection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// seta o metodo
			connection.setRequestProperty("Request-Method", "GET");
			// seta a variavel para ler o resultado
			connection.setDoInput(true);
			connection.setDoOutput(false);
			// conecta com a url destino
			connection.connect();
			// abre a conexão pra input
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// le ate o final
			StringBuffer newData = new StringBuffer();
			String s = "";
			while (null != ((s = br.readLine()))) {
				newData.append(s);
			}
			br.close();
			//Prepara o XML que está em string para executar leitura por nodes
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(newData.toString()));
		    Document doc = db.parse(is);
		    NodeList nodes = doc.getElementsByTagName("cServico");
		    //Faz a leitura dos nodes
		    for (int j = 0; j < nodes.getLength(); j++) {
		      // Codigo, Valor, PrazoEntrega, MaoPropria, Recebimento, ValorDeclarado, EntregaDomiciliar, EntregaSabado, Erro, MsgErro
		      Element element = (Element) nodes.item(j);
		      
		      NodeList codigo = element.getElementsByTagName("Codigo");
		      Element line = (Element) codigo.item(0);
		      listaFrete.setCodigo(getCharacterDataFromElement(line)); // Código
		      System.out.println("Código: " + getCharacterDataFromElement(line));
		      
		      NodeList valor = element.getElementsByTagName("Valor");
		      line = (Element) valor.item(0);
		      listaFrete.setValor(getCharacterDataFromElement(line)); // Valor
		      System.out.println("Valor: " + getCharacterDataFromElement(line));
		      
		      NodeList prazoEntrega = element.getElementsByTagName("PrazoEntrega");
		      line = (Element) prazoEntrega.item(0);
		      listaFrete.setPrazoEntrega(getCharacterDataFromElement(line)); // Prazo de entrega
		      System.out.println("Prazo de entrega: " + listaFrete.getPrazoEntrega());
		      
		      NodeList maoPropria = element.getElementsByTagName("ValorMaoPropria");
		      line = (Element) maoPropria.item(0);
		      listaFrete.setMaoPropria(getCharacterDataFromElement(line)); // ValorMaoPropria
		      System.out.println("ValorMaoPropria: " + listaFrete.getMaoPropria());
		      
		      NodeList recebimento = element.getElementsByTagName("ValorAvisoRecebimento");
		      line = (Element) recebimento.item(0);
		      listaFrete.setRecebimento(getCharacterDataFromElement(line)); // ValorAvisoRecebimento
		      System.out.println("ValorAvisoRecebimento: " + listaFrete.getRecebimento());
		      
		      NodeList valorDeclarado = element.getElementsByTagName("ValorValorDeclarado");
		      line = (Element) valorDeclarado.item(0);
		      listaFrete.setValorDeclarado(getCharacterDataFromElement(line)); // ValorValorDeclarado
		      System.out.println("ValorValorDeclarado: " + listaFrete.getValorDeclarado());
		      
		      NodeList entregaDomiciliar = element.getElementsByTagName("EntregaDomiciliar");
		      line = (Element) entregaDomiciliar.item(0);
		      listaFrete.setEntregaDomiciliar(getCharacterDataFromElement(line)); // EntregaDomiciliar
		      System.out.println("EntregaDomiciliar: " + listaFrete.getEntregaDomiciliar());
		      
		      NodeList entregaSabado = element.getElementsByTagName("EntregaSabado");
		      line = (Element) entregaSabado.item(0);
		      listaFrete.setEntregaSabado(getCharacterDataFromElement(line)); // EntregaSabado
		      System.out.println("EntregaSabado: " + listaFrete.getEntregaSabado());
		      
		      NodeList erro = element.getElementsByTagName("Erro");
		      line = (Element) erro.item(0);
		      listaFrete.setErro(getCharacterDataFromElement(line)); // Erro
		      System.out.println("Erro: " + listaFrete.getErro());
		      
		      NodeList msgErro = element.getElementsByTagName("MsgErro");
		      line = (Element) msgErro.item(0);
		      listaFrete.setMsgErro(getCharacterDataFromElement(line)); // MsgErro
		      System.out.println("MsgErro: " + listaFrete.getMsgErro());
		      return listaFrete;
		    }			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	  }
}