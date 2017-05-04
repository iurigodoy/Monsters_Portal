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

<<<<<<< HEAD

public class CalculoFreteCorreio {
	public static ListaFrete main(
			// Dados pesquisa
			// InformaÁıes da empresa e cliente
			String nCdEmpresa,	//
			String sDsSenha, 	//
			String sCepOrigem,	// CEP Fornecedor
			String sCepDestino,	// CEP Cliente
			
			/*
			 *	ServiÁos do Correio
			 *	-------------------
			 *	40010 SEDEX Varejo
			 *	40045 SEDEX a Cobrar Varejo
			 *	40215 SEDEX 10 Varejo
			 *	40290 SEDEX Hoje Varejo
			 *	41106 PAC Varejo
			 */
			String nCdServico,
			
			//	InformaÁıes do produto
			String nVlPeso,			// Peso do produto
			String nCdFormato,			// 1 ñ Formato caixa/pacote, 2 ñ Formato rolo/prisma, 3 - Envelope
			String nVlComprimento,		// 
			String nVlAltura,			// 
			String nVlLargura,			// 
			String nVlDiametro,			// 
			//	InformaÁıes do fornecedor
			String sCdMaoPropria,		// Indica se a encomenda ser· entregue com o serviÁo adicional m„o prÛpria, S ou N
			String nVlValorDeclarado,	//
			String sCdAvisoRecebimento	// Indica se a encomenda ser· entregue com o serviÁo adicional aviso de recebimento. S ou N
			
			) {
=======
import antlr.collections.List;
public class calculoFreteCorreio {
	public static void main(String[] args) {
	    List teste = (List) new ArrayList<ListaFrete>();
		// Dados pesquisa
		// Informa√ß√µes da empresa e cliente
		String nCdEmpresa = "";				//
		String sDsSenha = ""; 				//
		String sCepOrigem = "09920175";		// CEP Fornecedor
		String sCepDestino = "72151613";	// CEP Cliente
		
		/*
		 *	Servi√ßos do Correio
		 *	-------------------
		 *	40010 SEDEX Varejo
		 *	40045 SEDEX a Cobrar Varejo
		 *	40215 SEDEX 10 Varejo
		 *	40290 SEDEX Hoje Varejo
		 *	41106 PAC Varejo
		 */
		String nCdServico = "41106";
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
		
		String StrRetorno = "xml";  		// formato
		
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
		Iterator<Object> i = parameters.keySet().iterator();
		
		// o contador
		int counter = 0;
		
		// enquanto ainda existir parametros
		while (i.hasNext()) {
			// pega o nome
			String name = (String) i.next();
			// pega o valor
			String value = parameters.getProperty(name);
			// adiciona com um conector (? ou &)
			// o primeiro È ?, depois s„o &
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
			// abre a conex„o pra input
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// le ate o final
			StringBuffer newData = new StringBuffer();
			String s = "";
			while (null != ((s = br.readLine()))) {
				newData.append(s);
			}
			br.close();
			//Prepara o XML que est· em string para executar leitura por nodes
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(newData.toString()));
		    Document doc = db.parse(is);
		    NodeList nodes = doc.getElementsByTagName("cServico");
		    //Faz a leitura dos nodes
<<<<<<< HEAD
		    for (int j = 0; j < nodes.getLength();) {
		      Element element = (Element) nodes.item(j);
		      
		      NodeList codigo = element.getElementsByTagName("Codigo");
		      Element line = (Element) codigo.item(0);
		      listaFrete.setCodigo(getCharacterDataFromElement(line)); // CÛdigo
		      System.out.println("CÛdigo: " + getCharacterDataFromElement(line));
		      
=======
		    for (int j = 0; j < nodes.getLength(); j++) {
		      Element element = (Element) nodes.item(j);
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
		      NodeList valor = element.getElementsByTagName("Valor");
		      line = (Element) valor.item(0);
		      listaFrete.setValor(getCharacterDataFromElement(line)); // Valor
		      System.out.println("Valor: " + getCharacterDataFromElement(line));
<<<<<<< HEAD
		      
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
		      
=======
		      NodeList erro = element.getElementsByTagName("Erro");
		      line = (Element) erro.item(0);
		      System.out.println("Erro: " + getCharacterDataFromElement(line));
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
		    }			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFrete;
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