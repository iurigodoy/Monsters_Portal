<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var = "preco_total" scope = "session" value = "${pedido.getPreco_total(pedido.preco_ped, pedido.custo_forma_de_pagamento_ped, pedido.custo_frete_ped)}"/>

<fmt:setLocale value="pt-BR" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Boleto Banc&aacute;rio</title>
	<style type="text/css">
		body { background-color:#FFF; font:8px Verdana, Arial, Helvetica, sans-serif; color:#000; cursor:default; }
		@page { margin-right:0.5cm; margin-left:0.5cm; margin-bottom: 1cm; margin-top: 1cm }
		@media screen { body { margin: 10px } }
		h1 { float:left; font-size:15px; margin:0px; text-align:left; }
		h2 { float:right; font-size:12px; margin:0px; text-align:right; vertical-align:bottom; }
		hr { float:left; clear:left; width:100%; border-width:0; border-top:1px dashed #000; height:1px; margin:10px 0px; }
		hr.solid { border-top:1px solid #000; margin:2px 0; }
		p.aut { width:100%; text-align:right; margin:0; float:right; font-size:10px; }
		table { float:left; width:100%; border-collapse:collapse; }
		table.tab { border:1px solid #000; }
		table.tab td { border:1px solid #000; text-align:left; vertical-align:top; padding:0px 2px 0px 2px; }
		table.rec td { width:25%; }
		table.tab td span, table.infRec td span { display:block; font-size:10px; padding:0px 5px 0px 5px; }
		table.tab td span.vV { text-align:center; font-size:12px; font-weight:bold; }
		table.infRec td { vertical-align:top; border:0 !important; }
		table.infRec td.sacAv { width:60px; }
		table.infRec td.autMecF { text-align: right; }
		table.infRec td.codBaixa { text-align: right; vertical-align:bottom; }
		table.tab table.infRec td { padding-bottom:0px !important; height:auto; }
		table .lD { text-align:right !important; }div.barra { float:left; display:inline; width:600px; margin:5px 0px 15px 20px; }
		div.barra div { float:left; display:block; width:0px; height:50px; }
		div.b0 { border-right:1px solid #FFF; }
		div.b1 { border-right:3px solid #FFF; }
		div.p0 { border-right:1px solid #000; }
		div.p1 { border-right:3px solid #000; }
		div.break { page-break-after:always; }
		div.custom, div.mestre { display:block; clear:left; width:100%; }
		div.custom { font-size:12px; }
		div.mestre { border:1px solid #FFF; }
		div#hearder{display:none;} 
		div#footer{display:none;}
	</style>
	<script type="text/javascript" language="javascript1.2">
		if (typeof(window.print) !='undefined'){
		window.print()
		}
	</script>
</head>










<body>
	<div class="custom">
		<b>Descrição da Compra</b>:<br />
		<ul>
		<li><?= $boleto['nome_produtos'].' '.$boleto['id_produtos'] ?> - 1 Unidade: R$ <?= preco($boleto['valor_total']) ?></li><!--OK-- Produto, ID, Valor	-->
		</ul>
		<b>Total da Fatura: <fmt:formatNumber value="${ preco_total }" type="currency"/></b><!-------------------------------OK---------------------------------------- Valor	-->
		<br /><br /><hr />
	</div>
	<div class="mestre">
	<h1>Bradesco | 237-2 |</h1>
	<h2>Recibo do Pagador</h2>
	<table class="tab rec">
	  <tr>
		<td class="vV">Vencimento<br /><span class="vV"><?= $vencimento ?></span></td><!-------OK---------------------------- Vencimento 5 dias	-->
		<td>Ag&ecirc;ncia/C&oacute;digo do Benefici&aacute;rio<br /><span>0123-6/0004567-5</span></td>
		<td>N&uacute;mero do Documento<br /><span>&nbsp;</span></td>
		<td>Nosso N&uacute;mero<br /><span>06/00000000525-P</span></td>
	  </tr>
	  <tr>
		<td>Valor do Documento<br /><span class="vV"><fmt:formatNumber value="${ preco_total }" type="currency"/></span></td><!--------OK--------------------------------- Valor	-->
		<td>(-) Descontos<br /><span>&nbsp;</span></td>
		<td>(+) Acr&eacute;scimos<br /><span>&nbsp;</span></td>
		<td>(=) Valor Cobrado<br /><span class="vV">&nbsp;</span></td>
	  </tr>
	</table>
	<table class="infRec">
	  <tr>
		<td class="sacAv">Pagador</td>
		<td colspan="3">
			<span>${ pedido.cliente.nome_cli } - CPF ${ pedido.cliente.cpf_cli }<br /><!--------------------------- Nome e CPF do Cliente	-->
			${ pedido.cliente.endereco_cli }, ${ pedido.cliente.numero_cli } - ${ pedido.cliente.complemento_cli } ${ pedido.cliente.cidade_cli } - ${ pedido.cliente.estado_cli }<br />&nbsp;</span><!-------------------- Endereço Número e complemento	-->
		</td>
	  </tr>
	  <tr>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
		<td class="sacAv">Sacador/Avalista</td>
		<td colspan="2"><span>&nbsp;</span></td>
	  </tr>
	  <tr>
		<td colspan="4"><hr class="solid" /></td>
	  </tr>
	  <tr>
		<td class="sacAv">Benefici&aacute;rio</td>
		<td colspan="2"><span>Monsters Portal. - CNPJ 11.222.333/4444-55</span></td>
		<td class="lD autMecF">Autentica&ccedil;&atilde;o Mec&acirc;nica</td>
	  </tr>
	  <tr>
		<td class="sacAv">&nbsp;</td>
		<td colspan="3"><span>Rua Osvaldo Orico, 265 - 09132-190 Santo Andre-SP</span></td>
	  </tr>
	</table>
	<hr /><h1>Bradesco | 237-2 |</h1><h2>${ pedido.numero_ped }</h2>
	<table class="tab ficha">
	  <tr>
		<td colspan="7">Local de Pagamento<br />
		<span>Pag&aacute;vel em qualquer ag&ecirc;ncia banc&aacute;ria at&eacute; o vencimento.</span>
		</td>
		<td>Vencimento<br /><span class="vV lD"><?= $vencimento ?></span></td><!---------------OK------------------------------------- Vencimento 5 dias	-->
	  </tr>
	  <tr>
		<td colspan="5">Benefici&aacute;rio<br /><span>Monsters Portal.</span></td>
		<td colspan="2">CPF/CNPJ do Benefici&aacute;rio<br /><span>11.222.333/4444-55</span></td>
		<td>Ag&ecirc;ncia/C&oacute;digo do Benefici&aacute;rio<br /><span class="lD">0123-6/0004567-5</span></td>
	  </tr>
	  <tr>
		<td colspan="5">Endere&ccedil;o do Benefici&aacute;rio<br />
		<span>Rua Osvaldo Orico, 265 - 09132-190 Santo Andre-SP</span></td>
		<td>Esp&eacute;cie Doc<br /><span>&nbsp;</span></td>
		<td>Aceite<br /><span>N&atilde;o</span></td>
		<td>Nosso N&uacute;mero<br /><span class="lD">06/00000000525-P</span></td>
		</tr><tr><td>Uso do Banco<br /><span>&nbsp;</span></td>
		<td>CIP<br /><span>&nbsp;</span></td>
		<td>Carteira<br /><span>06</span></td>
		<td>Esp&eacute;cie<br /><span>R$</span></td>
		<td>Quantidade<br /><span>&nbsp;</span></td>
		<td colspan="2">(x) Valor<br /><span>&nbsp;</span></td>
		<td>(=) Valor do Documento<br /><span class="vV lD"><fmt:formatNumber value="${ preco_total }" type="currency"/></span></td><!--OK-------------------------- Valor Total	-->
	  </tr>
	  <tr>
		<td rowspan="5" colspan="7">Instru&ccedil;&otilde;es - Texto de Responsabilidade do Benefici&aacute;rio<br/>
		<span>Ap&oacute;s o vencimento, entre em contato com nossa central de atendimento.<br /><br /><br /><br /><br /><br /><br /><br />
		<b>Sr. Caixa: Boleto Demonstrativo. N&atilde;o receber.</b><br /></span></td>
		<td>(-) Desconto/Abatimento<br /><span class="lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td>(-) Outras Dedu&ccedil;&otilde;es<br /><span class="lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td>(+) Mora/Multa<br /><span class="lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td>(+) Outros Acr&eacute;scimos<br />
		<span class="lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td>(=) Valor Cobrado<br /><span class="vV lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td colspan="7" rowspan="3">
		  <table class="infRec">
			<tr>
				<td class="sacAv">Pagador</td>
				<td colspan="3">
			<span>${ pedido.cliente.nome_cli } - CPF ${ pedido.cliente.cpf_cli }<br /><!--------------------------- Nome e CPF do Cliente	-->
			${ pedido.cliente.endereco_cli }, ${ pedido.cliente.numero_cli } - ${ pedido.cliente.complemento_cli } ${ pedido.cliente.cidade_cli } - ${ pedido.cliente.estado_cli }<br />&nbsp;</span><!-------------------- Endereço Número e complemento	-->
		
				&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="sacAv">Sacador/Avalista</td>
				<td colspan="2"><span>&nbsp;</span></td>
				<td class="codBaixa">C&oacute;digo de Baixa &nbsp;</td>
			</tr>
		  </table>
		</td>
		<td>N&uacute;mero do Documento<br />
		<span class="lD">&nbsp;</span></td>
	  </tr>
	  <tr>
		<td>Data do Documento<br /><span class="lD"><fmt:formatDate type = "date" value = "${ pedido.created_at }" /></span></td><!----OK---------------------------------- Data Gerada	-->
	  </tr>
	  <tr>
	    <td>Data do Processamento<br /><span class="lD"><fmt:formatDate type = "date" value = "${ pedido.created_at }" /></span></td><!----OK-------------------------------- Data Gerada	-->
	  </tr>
	</table>
	<p class="aut">Autentica&ccedil;&atilde;o Mec&acirc;nica - Ficha de Compensa&ccedil;&atilde;o</p>
	<div class="barra">
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b1"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p1"></div>
	  <div class="b0"></div>
	  <div class="p0"></div>
	  <div class="b1"></div>
	</div><hr /></div>
</body>

</html>