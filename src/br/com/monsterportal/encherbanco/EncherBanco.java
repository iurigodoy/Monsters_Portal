package br.com.monsterportal.encherbanco;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.model.Permissao;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;

public class EncherBanco {
	public static void main(String[] args) {
		
		//Pegar a hora
		Calendar cal = new GregorianCalendar();
		
		/*
		 * 
		 * Permissao
		 * 
		 */
		
		Permissao permissao = new Permissao();
		
		permissao.setAtualizarBanner(true);
		permissao.setAtualizarCargo(true);
		permissao.setAtualizarCategoria(true);
		permissao.setAtualizarCliente(true);
		permissao.setAtualizarFornecedor(true);
		permissao.setAtualizarFuncionario(true);
		permissao.setAtualizarPedido(true);
		permissao.setAtualizarProduto(true);
		
		permissao.setCriarBanner(true);
		permissao.setCriarCampanha(true);
		permissao.setCriarCargo(true);
		permissao.setCriarCategoria(true);
		permissao.setCriarCliente(true);
		permissao.setCriarFornecedor(true);
		permissao.setCriarFuncionario(true);
		permissao.setCriarPedido(true);
		permissao.setCriarProduto(true);

		permissao.setLerBanner(true);
		permissao.setLerCampanha(true);
		permissao.setLerCargo(true);
		permissao.setLerCategoria(true);
		permissao.setLerCliente(true);
		permissao.setLerFornecedor(true);
		permissao.setLerFuncionario(true);
		permissao.setLerPedido(true);
		permissao.setLerProduto(true);
		
		permissao.setExcluirBanner(true);
		permissao.setExcluirCampanha(true);
		permissao.setExcluirCargo(true);
		permissao.setExcluirCategoria(true);
		permissao.setExcluirCliente(true);
		permissao.setExcluirFornecedor(true);
		permissao.setExcluirFuncionario(true);
		permissao.setExcluirPedido(true);
		permissao.setExcluirProduto(true);
		
		permissao.setRestaurarBanner(true);
		permissao.setRestaurarCampanha(true);
		permissao.setRestaurarCargo(true);
		permissao.setRestaurarCategoria(true);
		permissao.setRestaurarCliente(true);
		permissao.setRestaurarFornecedor(true);
		permissao.setRestaurarFuncionario(true);
		permissao.setRestaurarPedido(true);
		permissao.setRestaurarProduto(true);
		
		Cargo cargo = new Cargo();

		cargo.setNome_car("Super Usuário");
		cargo.setPadrao_car(false);
	    cargo.setCreated_at(cal.getTime());
		cargo.setUpdated_at(cal.getTime());
	    cargo.setDeleted_at(null);
	    cargo.setDeleted(false);
		
		Cargo cargo1 = new Cargo();

		cargo.setNome_car("Medio Usuário");
		cargo.setPadrao_car(false);
	    cargo.setCreated_at(cal.getTime());
		cargo.setUpdated_at(cal.getTime());
	    cargo.setDeleted_at(null);
	    cargo.setDeleted(false);
		
		Funcionario funcionario = new Funcionario();

		funcionario.setNome_fun("Iuri Godoy");
		funcionario.setFoto_fun("foto6.jpg");
		funcionario.setCpf_fun("435.628.318-03");
		funcionario.setEmail_fun("iurigodoy@hotmail.com");
		funcionario.setCelular_fun("11 968651313");
		funcionario.setResidencial_fun("11 32136636");
		funcionario.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario.getSenha_fun()+"------------------------------------------------------------");
		funcionario.setBloqueado_fun(false);
		
		Funcionario funcionario1 = new Funcionario();

		funcionario.setNome_fun("Caue Silva");
		funcionario.setFoto_fun("foto3.jpg");
		funcionario.setCpf_fun("408.750.798-06");
		funcionario.setEmail_fun("cauueh@hotmail.com");
		funcionario.setCelular_fun("11 953200491");
		funcionario.setResidencial_fun("11 28564221");
		funcionario.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario.getSenha_fun()+"------------------------------------------------------------");
		funcionario.setBloqueado_fun(false);
		
		Funcionario funcionario2 = new Funcionario();

		funcionario.setNome_fun("Iam Carvalho");
		funcionario.setFoto_fun("foto2.jpg");
		funcionario.setCpf_fun("405.751.797-06");
		funcionario.setEmail_fun("iam@hotmail.com");
		funcionario.setCelular_fun("11 983200991");
		funcionario.setResidencial_fun("11 26548796");
		funcionario.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario.getSenha_fun()+"------------------------------------------------------------");
		funcionario.setBloqueado_fun(false);
		
		Funcionario funcionario3 = new Funcionario();

		funcionario.setNome_fun("Leandro Domiciano");
		funcionario.setFoto_fun("foto4.jpg");
		funcionario.setCpf_fun("409.771.585-01");
		funcionario.setEmail_fun("leandro.domi@hotmail.com");
		funcionario.setCelular_fun("11 993204981");
		funcionario.setResidencial_fun("11 29588796");
		funcionario.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario.getSenha_fun()+"------------------------------------------------------------");
		funcionario.setBloqueado_fun(false);
		
		
	    // Histórico
	    funcionario.setCreated_at(cal.getTime());
		funcionario.setUpdated_at(cal.getTime());
	    funcionario.setDeleted_at(null);
	    funcionario.setDeleted(false);

		/*
		 * 
		 * Categoria
		 * 
		 */
		
		Categoria categoria = new Categoria();
		categoria.setNome_cat("celular");
		categoria.setHierarquia_cat(0);
	    // Histórico
	    categoria.setCreated_at(cal.getTime());
		categoria.setUpdated_at(cal.getTime());
	    categoria.setDeleted_at(null);
	    categoria.setDeleted(false);
		
		Categoria categoria1 = new Categoria();
		categoria.setNome_cat("eletronico");
		categoria.setHierarquia_cat(0);
	    // Histórico
	    categoria.setCreated_at(cal.getTime());
		categoria.setUpdated_at(cal.getTime());
	    categoria.setDeleted_at(null);
	    categoria.setDeleted(false);
		
		Categoria categoria2 = new Categoria();
		categoria.setNome_cat("acessorios");
		categoria.setHierarquia_cat(0);
	    // Histórico
	    categoria.setCreated_at(cal.getTime());
		categoria.setUpdated_at(cal.getTime());
	    categoria.setDeleted_at(null);
	    categoria.setDeleted(false);
		
		Categoria categoria3 = new Categoria();
		categoria.setNome_cat("games");
		categoria.setHierarquia_cat(0);
		
	    // Histórico
	    categoria.setCreated_at(cal.getTime());
		categoria.setUpdated_at(cal.getTime());
	    categoria.setDeleted_at(null);
	    categoria.setDeleted(false);

		/*
		 * 
		 * Produto
		 * 
		 */
	    
	    Produto produto1 = new Produto();
	    
	    produto1.setNome_pro("Kit Pneu Aro 14 Dunlop 175/65r14 Sptrgt1 82t 4 Unidades");
	    produto1.setDescricao_pro("Dunlop Sp Touring T1 foi concebido para durar, e dispõe de quatro ranhuras retas com ranhuras anti-aqua planagem dentro da banda de rodagem para reduzir aqua planagem e excelente aderência em condições molhadas. O uso de um composto de sílica banda de rodagem nos pneus Dunlop Sp Touring T1 melhora as acelerações, frenagem e dirigibilidade durante as condições de estrada molhada. A melhoria da aderência e tração ajuda o desempenho nas estradas em tempo de chuva. O Dunlop Sp Touring T1 é um pneu projetado com enfoque na durabilidade para pequenas e veículos de médio porte. O Dunlop Sp Touring T1 é projetado com um polímero especializado para resistência ao desgaste, sem comprometer a aderência do polímero existente, para fazer controle superior na estrada.");
	    produto1.setCategoria(acessorios);
	    // MKT
	    produto1.setPromocao_pro(true);
	    produto1.setPublicado_pro(true);
	    produto1.setDesconto_pro(0.10);
	    produto1.setDestaque_pro(false);
	    // Logistica
	    produto1.setPeso_pro(0.100);
	    produto1.setAltura_pro(20.000);
	    produto1.setLargura_pro(20.000);
	    produto1.setComprimento_pro(20.000);
	    produto1.setDiametro_pro(20.000);
	    // Histórico
	    produto1.setCreated_at(cal.getTime());
		produto1.setUpdated_at(cal.getTime());
	    produto1.setDeleted_at(null);
	    produto1.setDeleted(false);
		
		
		Produto produto2 = new Produto();
	    
	    produto2.setNome_pro("martphone LG K10 Novo Dual Chip Android 7.0 Tela 5,3 32GB 4G 13MP - Preto");
	    produto2.setDescricao_pro("Toda experiência da internet rápida no seu celular com o 4G da LG para você! Acesse as redes sociais, compartilhe fotos, jogue, assista vídeos e muito mais com o Smartphone LG K10, Performance de respeito! O LG K10 vem com processador Octa Core, muito mais velocidade e fluidez para tornar seu dia a dia mais produtivo. Tudo isso em uma tela de 5.3 polegadas de alta qualidade com tecnologia In-Cell touch para melhor visualização em ambientes externos. Domine as suas fotos com uma super câmera principal de 13MP e câmera de selfie de 8MP com Quick Selfie 2.0 e Virtual Flash.");
	    produto2.setCategoria(celular);
	    // MKT
	    produto2.setPromocao_pro(true);
	    produto2.setPublicado_pro(true);
	    produto2.setDesconto_pro(0.10);
	    produto2.setDestaque_pro(false);
	    // Logistica
	    produto2.setPeso_pro(0.100);
	    produto2.setAltura_pro(20.000);
	    produto2.setLargura_pro(20.000);
	    produto2.setComprimento_pro(20.000);
	    produto2.setDiametro_pro(20.000);
	    // Histórico
	    produto2.setCreated_at(cal.getTime());
		produto2.setUpdated_at(cal.getTime());
	    produto2.setDeleted_at(null);
	    produto2.setDeleted(false);
		
		Produto produto3 = new Produto();
	    
	    produto3.setNome_pro("Apple iPhone 6s Plus 16 GB Unlocked Brand New Rose Gold");
	    produto3.setDescricao_pro("É só começar a usar o iPhone 6s para perceber como ele é diferente de tudo o que você já experimentou. Com o 3D Touch, você faz muito mais em um só toque. Com as Live Photos, suas memórias ganham vida e movimento. E essas são só algumas das novidades. Quando você explora o iPhone 6s a fundo, encontra camadas e camadas de inovação. O iPhone 6s vem com o chip A9 de 64 bits. Ele oferece um desempenho que antes só era possível em computadores. Você vai notar um aumento de até 70% no desempenho da CPU e de até 90% na GPU para todos os seus jogos e apps com gráficos mais exigentes.");
	    produto3.setCategoria(celular);
	    // MKT
	    produto3.setPromocao_pro(true);
	    produto3.setPublicado_pro(true);
	    produto3.setDesconto_pro(0.10);
	    produto3.setDestaque_pro(false);
	    // Logistica
	    produto3.setPeso_pro(0.100);
	    produto3.setAltura_pro(20.000);
	    produto3.setLargura_pro(20.000);
	    produto3.setComprimento_pro(20.000);
	    produto3.setDiametro_pro(20.000);
	    // Histórico
	    produto3.setCreated_at(cal.getTime());
		produto3.setUpdated_at(cal.getTime());
	    produto3.setDeleted_at(null);
	    produto3.setDeleted(false);
		
		
		Produto produto4 = new Produto();
	    
	    produto4.setNome_pro("Console PlayStation 4 500GB");
	    produto4.setDescricao_pro("O PlayStation 4 é o melhor lugar para jogar jogos dinâmicos e conectados, com gráfico rico e alta velocidade, personalização inteligente, funcionalidades sociais altamente integradas e recursos de segunda tela inovadores. Combinando conteúdo sem igual, experiências de jogo envolventes, todos os seus aplicativos favoritos de entretenimento digital e as exclusividades do PlayStation, o PS4 é centrado nos jogadores, permitindo-lhes que joguem quando, onde e como quiserem. O PS4 permite que os melhores desenvolvedores de jogos do mundo liberem sua criatividade e estendam os limites do jogo por meio de um sistema que está sintonizado especificamente com suas necessidades");
	    produto4.setCategoria(games);
	    // MKT
	    produto4.setPromocao_pro(true);
	    produto4.setPublicado_pro(true);
	    produto4.setDesconto_pro(0.10);
	    produto4.setDestaque_pro(false);
	    // Logistica
	    produto4.setPeso_pro(0.100);
	    produto4.setAltura_pro(20.000);
	    produto4.setLargura_pro(20.000);
	    produto4.setComprimento_pro(20.000);
	    produto4.setDiametro_pro(20.000);
	    // Histórico
	    produto4.setCreated_at(cal.getTime());
		produto4.setUpdated_at(cal.getTime());
	    produto4.setDeleted_at(null);
	    produto4.setDeleted(false);
		
		
		Produto produto5 = new Produto();
	    
	    produto5.setNome_pro("Mouse Wireless WM126 Preto - Dell");
	    produto5.setDescricao_pro("O mouse óptico wireless WM126 da Dell oferece performance wireless para uso diário com excelente duração da bateria. Ele foi projetado para criar um espaço de trabalho organizado com uma conexão RF wireless e plug-and-play confiável.");
	    produto5.setCategoria(acessorios);
	    // MKT
	    produto5.setPromocao_pro(true);
	    produto5.setPublicado_pro(true);
	    produto5.setDesconto_pro(0.10);
	    produto5.setDestaque_pro(false);
	    // Logistica
	    produto5.setPeso_pro(0.100);
	    produto5.setAltura_pro(20.000);
	    produto5.setLargura_pro(20.000);
	    produto5.setComprimento_pro(20.000);
	    produto5.setDiametro_pro(20.000);
	    // Histórico
	    produto5.setCreated_at(cal.getTime());
		produto5.setUpdated_at(cal.getTime());
	    produto5.setDeleted_at(null);
	    produto5.setDeleted(false);
		
	    
		Produto produto6 = new Produto();
	    
	    produto6.setNome_pro("Mouse Sem Fio 2.4 Ghz Vermelho - Multilaser");
	    produto6.setDescricao_pro("Ideal para facilitar seu trabalho e te ajudar na praticidade, chegou o Mouse Sem Fio, da Multilaser. Ele tem design compacto, facilitando seu armazenamento e transporte. Cheio de estilo com acabamento brilhante. Confira esta oportunidade! ");
	    produto6.setCategoria(acessorios);
	    // MKT
	    produto6.setPromocao_pro(true);
	    produto6.setPublicado_pro(true);
	    produto6.setDesconto_pro(0.10);
	    produto6.setDestaque_pro(false);
	    // Logistica
	    produto6.setPeso_pro(0.100);
	    produto6.setAltura_pro(20.000);
	    produto6.setLargura_pro(20.000);
	    produto6.setComprimento_pro(20.000);
	    produto6.setDiametro_pro(20.000);
	    // Histórico
	    produto6.setCreated_at(cal.getTime());
		produto6.setUpdated_at(cal.getTime());
	    produto6.setDeleted_at(null);
	    produto6.setDeleted(false);
		
		
		Produto produto7 = new Produto();
	    
	    produto7.setNome_pro("Game FIFA 17 - PS4");
	    produto7.setDescricao_pro("Com a tecnologia Frostbite, o FIFA 17 transforma a maneira de jogar, competir e se conectar emocionalmente ao jogo. O game insere você em experiências de futebol autênticas, trazendo jogadores de futebol cheios de profundidade e emoção e levando você a mundos novos e exclusivos do jogo. Você domina cada momento em campo com inovação total na maneira com que os jogadores pensam, se movimentam, interagem fisicamente com os adversários e executam ataques.");
	    produto7.setCategoria(games);
	    // MKT
	    produto7.setPromocao_pro(true);
	    produto7.setPublicado_pro(true);
	    produto7.setDesconto_pro(0.10);
	    produto7.setDestaque_pro(false);
	    // Logistica
	    produto7.setPeso_pro(0.100);
	    produto7.setAltura_pro(20.000);
	    produto7.setLargura_pro(20.000);
	    produto7.setComprimento_pro(20.000);
	    produto7.setDiametro_pro(20.000);
	    // Histórico
	    produto7.setCreated_at(cal.getTime());
		produto7.setUpdated_at(cal.getTime());
	    produto7.setDeleted_at(null);
	    produto7.setDeleted(false);
		
		
		Produto produto8 = new Produto();
	    
	    produto8.setNome_pro("Alto Falante Eros E-18 Target Bass 4.5k 18 Polegadas 2250 W Rms 8r");
	    produto8.setDescricao_pro("Resposta De Frequência: 30 ~ 1.000 Hz Sensibilidade (@ 1 W, 1 M) - Free-Air: 94.4 Db/Spl Potência Máxima (Rms): 2.250 W Potência Musical: 4.500 W Impedância Nominal:4 Ou 8 Ohms Resistência, Re: 3.0 Ou 6.0 Ohms / Vcc Área Do Cone: 0,120 Sq.M Freqüência De Ressonância: 34.5 Hz Volume Equivalente: 166.3 L Q Mecânico 8.948 (Qms) Q Elétrico: 0.412 (Qes) Q ");
	    produto8.setCategoria(acessorios);
	    // MKT
	    produto8.setPromocao_pro(true);
	    produto8.setPublicado_pro(true);
	    produto8.setDesconto_pro(0.10);
	    produto8.setDestaque_pro(false);
	    // Logistica
	    produto8.setPeso_pro(0.100);
	    produto8.setAltura_pro(20.000);
	    produto8.setLargura_pro(20.000);
	    produto8.setComprimento_pro(20.000);
	    produto8.setDiametro_pro(20.000);
	    // Histórico
	    produto8.setCreated_at(cal.getTime());
		produto8.setUpdated_at(cal.getTime());
	    produto8.setDeleted_at(null);
	    produto8.setDeleted(false);
		
		
		Produto produto9 = new Produto();
	    
	    produto.setNome_pro("Kit Portão Eletrônico Deslizante Rossi Dz Nano Turbo 1/4 Hp");
	    produto9.setDescricao_pro("Os Portões Deslizantes, Mais Conhecidos Como Portões De Correr, Abrem Por Deslizamentos Sobre Trilhos E Trabalham Com Trilho Inferiores Ou Superiores, Bem Aceitos No Mercado, Usados Em Residências, Prédios, Condomínios E Fábricas, Por Serem Mais Práticos E Rápidos");
	    produto9.setCategoria(eletronico);
	    // MKT
	    produto9.setPromocao_pro(true);
	    produto9.setPublicado_pro(true);
	    produto9.setDesconto_pro(0.10);
	    produto9.setDestaque_pro(false);
	    // Logistica
	    produto9.setPeso_pro(0.100);
	    produto9.setAltura_pro(20.000);
	    produto9.setLargura_pro(20.000);
	    produto9.setComprimento_pro(20.000);
	    produto9.setDiametro_pro(20.000);
	    // Histórico
	    produto9.setCreated_at(cal.getTime());
		produto9.setUpdated_at(cal.getTime());
	    produto9.setDeleted_at(null);
	    produto9.setDeleted(false);
		
		
		Produto produto10 = new Produto();
	    
	    produto10.setNome_pro("Eletrônico Teclado Com Senha + Chave Sos Modelo Osd170");
	    produto10.setDescricao_pro("Cofre Digital, Senha Alterável De 3 Até 8 Dígitos, Teclado Com Beep Sonoro E Led Indicador Da Operação, Bloqueio Do Teclado Ao Erro De Senha Em Três Tentativas, Estrutura Sólida Em Aço, Abastecimento De Pilhas Internamente, Travamento Com Dois Pinos (Ferrolhos) Horizontais, Excelente Acabamento Com Revestimento,Funciona Com 4 Pilhas 34aa34, Pintura Epoxi, Espessura Da Porta: 3mm, Espessura Do Corpo: 1mm");
	    produto10.setCategoria(eletronico);
	    // MKT
	    produto10.setPromocao_pro(true);
	    produto10.setPublicado_pro(true);
	    produto10.setDesconto_pro(0.10);
	    produto10.setDestaque_pro(false);
	    // Logistica
	    produto10.setPeso_pro(0.100);
	    produto10.setAltura_pro(20.000);
	    produto10.setLargura_pro(20.000);
	    produto10.setComprimento_pro(20.000);
	    produto10.setDiametro_pro(20.000);
	    // Histórico
	    produto10.setCreated_at(cal.getTime());
		produto10.setUpdated_at(cal.getTime());
	    produto10.setDeleted_at(null);
	    produto10.setDeleted(false);
		
		
		Produto produto11 = new Produto();
	    
	    produto11.setNome_pro("Bateria Moura Estacionaria Vrla 12v 7a Para Nobreak Estabilizadores Alarmes Dispositivos Eletronico");
	    produto11.setDescricao_pro("Bateria Moura Estacionaria VRLA 12V 7A para No-break Estabilizadores Alarmes Dispositivos Eletronicos Produzida sob rigoroso padrão internacional de qualidade de processo e com plataforma tecnologica de classe mundial, a Moura VRLA para aplicações estacionarias e a bateria ideal para equipamentos que demandem alta segurança, confiabilidade e autonomia. Capaz de suportar picos de descarga e com excelente disposição para aceitação de carga, a bateria regulada por valvulas da Moura e a melhor opção para clientes exigentes e que se preocupam com a relação custo-beneficio.");
	    produto11.setCategoria(acessorios);
	    // MKT
	    produto11.setPromocao_pro(true);
	    produto11.setPublicado_pro(true);
	    produto11.setDesconto_pro(0.10);
	    produto11.setDestaque_pro(false);
	    // Logistica
	    produto11.setPeso_pro(0.100);
	    produto11.setAltura_pro(20.000);
	    produto11.setLargura_pro(20.000);
	    produto11.setComprimento_pro(20.000);
	    produto11.setDiametro_pro(20.000);
	    // Histórico
	    produto11.setCreated_at(cal.getTime());
		produto11.setUpdated_at(cal.getTime());
	    produto11.setDeleted_at(null);
	    produto11.setDeleted(false);
		
		
		Produto produto12 = new Produto();
	    
	    produto12.setNome_pro("Capa Estepe Ecosport 03 A 17 Global Preta");
	    produto12.setDescricao_pro("Capa De Estepe Ecosport 03 04 05 06 07 08 09 10 11 12 12 14 15 16 17 Global Branca Os Veículos Que Possuem Modelo Off Road Contam Com O Estepe Do Lado Externo, E Por Este Motivo Ficam Expostos As Chuvas E Outros Fatores Que Podem Ocasionar Corrosões E Prejudicar O Seu Futuro Desempenho.");
	    produto12.setCategoria(acessorios);
	    // MKT
	    produto12.setPromocao_pro(true);
	    produto12.setPublicado_pro(true);
	    produto12.setDesconto_pro(0.10);
	    produto12.setDestaque_pro(false);
	    // Logistica
	    produto12.setPeso_pro(0.100);
	    produto12.setAltura_pro(20.000);
	    produto12.setLargura_pro(20.000);
	    produto12.setComprimento_pro(20.000);
	    produto12.setDiametro_pro(20.000);
	    // Histórico
	    produto12.setCreated_at(cal.getTime());
		produto12.setUpdated_at(cal.getTime());
	    produto12.setDeleted_at(null);
	    produto12.setDeleted(false);
		
		
		Produto produto13 = new Produto();
	    
	    produto13.setNome_pro("Capa Estepe Ecosport 03 A 17 Global Branca + Cadeado");
	    produto13.setDescricao_pro("Capa De Estepe Ecosport 03 04 05 06 07 08 09 10 11 12 12 14 15 16 17 Global Branca Os Veículos Que Possuem Modelo Off Road Contam Com O Estepe Do Lado Externo, E Por Este Motivo Ficam Expostos As Chuvas E Outros Fatores Que Podem Ocasionar Corrosões E Prejudicar O Seu Futuro Desempenho.");
	    produto13.setCategoria(acessorios);
	    // MKT
	    produto13.setPromocao_pro(true);
	    produto13.setPublicado_pro(true);
	    produto13.setDesconto_pro(0.10);
	    produto13.setDestaque_pro(false);
	    // Logistica
	    produto13.setPeso_pro(0.100);
	    produto13.setAltura_pro(20.000);
	    produto13.setLargura_pro(20.000);
	    produto13.setComprimento_pro(20.000);
	    produto13.setDiametro_pro(20.000);
	    // Histórico
	    produto13.setCreated_at(cal.getTime());
		produto13.setUpdated_at(cal.getTime());
	    produto13.setDeleted_at(null);
	    produto13.setDeleted(false);
		
		
		Produto produto14 = new Produto();
	    
	    produto14.setNome_pro("Capa Estepe Nproduto12sport 2013 2014 2015 Bepo Prata Enseada");
	    produto14.setDescricao_pro("Capa de Estepe Nova Ecosport 2013 2014 2015 Bepo Prata Enseada em ABS Rígido Desenvolvida pela Bepo, fabricante nacionalmente conhecida pela excelência em acessórios automotivos de alto padrão, a capa de estepe é uma peça instalada sobre o estepe traseiro da sua Nova Ecosport e um acessório ideal para quem procura proteção e estilo, com seu design moderno e sofisticado a mesma garante ao estepe alta segurança, pois acompanha trava anti-furto");
	    produto14.categoria(acessorios);
	    // MKT
	    produto14.setPromocao_pro(true);
	    produto14.setPublicado_pro(true);
	    produto14.setDesconto_pro(0.10);
	    produto14.setDestaque_pro(false);
	    // Logistica
	    produto14.setPeso_pro(0.100);
	    produto14.setAltura_pro(20.000);
	    produto14.setLargura_pro(20.000);
	    produto14.setComprimento_pro(20.000);
	    produto14.setDiametro_pro(20.000);
	    // Histórico
	    produto14.setCreated_at(cal.getTime());
		produto14.setUpdated_at(cal.getTime());
	    produto14.setDeleted_at(null);
	    produto14.setDeleted(false);
		
		
		Produto produto15 = new Produto();
	    
	    produto15.setNome_pro("Capota Maritima Montana 2011 A 2016 C/Trek Covertech");
	    produto15.setDescricao_pro("Características Capota Com Trek De Nylon, Modelo Classic Da Covertech. Trek É O Sistema De Fechamento Da Capota, Com Trava Interna. O Que Dá Durabilidade, Estiramento E Segurança À Capota.");
	    produto15.setCategoria(acessorios);
	    // MKT
	    produto15.setPromocao_pro(true);
	    produto15.setPublicado_pro(true);
	    produto15.setDesconto_pro(0.10);
	    produto15.setDestaque_pro(false);
	    // Logistica
	    produto15.setPeso_pro(0.100);
	    produto15.setAltura_pro(20.000);
	    produto15.setLargura_pro(20.000);
	    produto15.setComprimento_pro(20.000);
	    produto15.setDiametro_pro(20.000);
	    // Histórico
	    produto15.setCreated_at(cal.getTime());
		produto15.setUpdated_at(cal.getTime());
	    produto15.setDeleted_at(null);
	    produto15.setDeleted(false);
		
		
		Produto produto16 = new Produto();
	    
	    produto16.setNome_pro("Jogo De Tapete Carpete Nova Montana 11 A 16 Bordado Preto 2 Peças");
	    produto16.setDescricao_pro("Tapete Carpete Com Logo Bordado Para Montana 11 12 13 14 15 16. Deixe O Interior Do Seu Carro Mais Moderno E Sofisticado Garantindo Proteção, Segurança, Beleza E Durabilidade Com Nosso Jogo De Tapetes Personalizados.");
	    produto16.setCategoria(acessorios);
	    // MKT
	    produto16.setPromocao_pro(true);
	    produto16.setPublicado_pro(true);
	    produto16.setDesconto_pro(0.10);
	    produto16.setDestaque_pro(false);
	    // Logistica
	    produto16.setPeso_pro(0.100);
	    produto16.setAltura_pro(20.000);
	    produto16.setLargura_pro(20.000);
	    produto16.setComprimento_pro(20.000);
	    produto16.setDiametro_pro(20.000);
	    // Histórico
	    produto16.setCreated_at(cal.getTime());
		produto16.setUpdated_at(cal.getTime());
	    produto16.setDeleted_at(null);
	    produto16.setDeleted(false);
		
		
		
	    /*
	     * 
	     * Imagem
	     * 
	     */
	    
	    Imagem imagem1 = new Imagem();
	    imagem1.setArquivo_ima("01.jpg");
	    imagem1.setOrdem_ima(1);
	    Imagem imagem2 = new Imagem();
	    imagem2.setArquivo_ima("02.jpg");
	    imagem2.setOrdem_ima(2);
	    Imagem imagem3 = new Imagem();
	    imagem3.setArquivo_ima("03.jpg");
	    imagem3.setOrdem_ima(3);
	    Imagem imagem4 = new Imagem();
	    imagem4.setArquivo_ima("04.jpg");
	    imagem4.setOrdem_ima(4);
	    Imagem imagem5 = new Imagem();
	    imagem5.setArquivo_ima("05.jpg");
	    imagem5.setOrdem_ima(5);
	    Imagem imagem6 = new Imagem();
	    imagem6.setArquivo_ima("06.jpg");
	    imagem6.setOrdem_ima(6);
	    
		/*
		 * 
		 * Banner
		 * 
		 */
	    
	    Banner banner = new Banner();
	    
	    banner.setArquivo_ban("banner7.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    banner.setCreated_at(cal.getTime());
		banner.setUpdated_at(cal.getTime());
	    banner.setDeleted_at(null);
	    banner.setDeleted(false);
		
	    Banner banner1 = new Banner();
	    
	    banner.setArquivo_ban("banner5.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    banner1.setCreated_at(cal.getTime());
		banner1.setUpdated_at(cal.getTime());
	    banner1.setDeleted_at(null);
	    banner1.setDeleted(false);
		
		Banner banner2 = new Banner();
	    
	    banner.setArquivo_ban("banner1.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    banner2.setCreated_at(cal.getTime());
		banner2.setUpdated_at(cal.getTime());
	    banner2.setDeleted_at(null);
	    banner2.setDeleted(false);
		
		Banner banner3 = new Banner();
	    
	    banner.setArquivo_ban("banner2.jpg");
	    banner.setAtivo_ban(true);
	    // Histó
	    banner3.setCreated_at(cal.getTime());
		banner3.setUpdated_at(cal.getTime());
	    banner3.setDeleted_at(null);
	    banner3.setDeleted(false);
		
		Banner banner4 = new Banner();
	    
	    banner.setArquivo_ban("banner3.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    banner4.setCreated_at(cal.getTime());
		banner4.setUpdated_at(cal.getTime());
	    banner4.setDeleted_at(null);
	    banner4.setDeleted(false);
		
		
		
	    /*
	     * 
	     * Fornecedor
	     * 
	     */
	    
	    Fornecedor fornecedor = new Fornecedor();

	    fornecedor.setNome_for("Pentágono");
	    fornecedor.setLogo_for("01.jpg");
	    fornecedor.setEmail_for("pentagono.edu@gmail.com");
	    fornecedor.setCnpj_for("36.686.772/0001-76");
	    fornecedor.setCep_for("09132-190");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Osvaldo Orico");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 32136636");
		
		Fornecedor fornecedor1 = new Fornecedor();

	    fornecedor.setNome_for("Armazem do vidro");
	    fornecedor.setLogo_for("logo2.jpg");
	    fornecedor.setEmail_for("armazemdovidro@hotmail.com");
	    fornecedor.setCnpj_for("37.886.872/0001-86");
	    fornecedor.setCep_for("09534-290");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Cruz e Souza");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 48136586");
		
		Fornecedor fornecedor2 = new Fornecedor();

	    fornecedor.setNome_for("Fedex");
	    fornecedor.setLogo_for("logo3.jpg");
	    fornecedor.setEmail_for("fedex@fedex.com");
	    fornecedor.setCnpj_for("39.996.856/0001-56");
	    fornecedor.setCep_for("09658-250");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Francisco");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 25687563");
		
		Fornecedor fornecedor3 = new Fornecedor();

	    fornecedor.setNome_for("Padaria União");
	    fornecedor.setLogo_for("logo4.jpg");
	    fornecedor.setEmail_for("padariauniao@gmail.com");
	    fornecedor.setCnpj_for("45.789.772/0002-86");
	    fornecedor.setCep_for("09584-510");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Teotonio Vilela");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 24516328");
		
		Fornecedor fornecedor4 = new Fornecedor();

	    fornecedor.setNome_for("Franklin");
	    fornecedor.setLogo_for("logo5.jpg");
	    fornecedor.setEmail_for("Flanklin@hotmail.com");
	    fornecedor.setCnpj_for("46.985.564/0001-96");
	    fornecedor.setCep_for("09132-190");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Matarazo");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 446156596");
		
		Fornecedor fornecedor5 = new Fornecedor();

	    fornecedor.setNome_for("Remodeling");
	    fornecedor.setLogo_for("logo1.jpg");
	    fornecedor.setEmail_for("remodeling@gmail.com");
	    fornecedor.setCnpj_for("56.554.254/0001-24");
	    fornecedor.setCep_for("08541-250");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Epitacio Pessoa");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 42589635");
		
		
	    // Histórico
	    fornecedor.setCreated_at(cal.getTime());
		fornecedor.setUpdated_at(cal.getTime());
	    fornecedor.setDeleted_at(null);
	    fornecedor.setDeleted(false);
	    
	    /*
	     * 
	     * Produto do Fornecedor
	     * 
	     */
	    
	    Produto_has_fornecedor prod_forn = new Produto_has_fornecedor();
	    prod_forn.setPreco_prod(100.00);
	    prod_forn.setQuantidade_prod(100);

	    /*
	     * Injetar
	     */
	    
	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("produtos");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();   

	    manager.persist(cargo);
	    manager.flush();
	    permissao.setCargo(cargo);
	    manager.persist(permissao);
	    manager.flush();
	    funcionario.setCargo(cargo);
	    manager.persist(funcionario);
	    
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da permissao: " + permissao.getId_permissao());
	    System.out.println("ID do cargo: " + cargo.getId_cargo());
	    System.out.println("ID do funcionario: " + funcionario.getId_funcionario());
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("-------------------------------------------------"+funcionario.getSenha_fun());
	    
	    manager.persist(categoria);
	    manager.flush();
	    produto.setCategoria(categoria);
	    manager.persist(produto);
	    manager.flush();
	    imagem1.setProduto(produto);
	    imagem2.setProduto(produto);
	    imagem3.setProduto(produto);
	    imagem4.setProduto(produto);
	    imagem5.setProduto(produto);
	    imagem6.setProduto(produto);
	    manager.persist(imagem1);
	    manager.persist(imagem2);
	    manager.persist(imagem3);
	    manager.persist(imagem4);
	    manager.persist(imagem5);
	    manager.persist(imagem6);
	    manager.persist(banner);

	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da categoria: " + categoria.getId_categoria());
	    System.out.println("ID do produto: " + produto.getId_produto());
	    System.out.println("ID da imagem: " + imagem1.getId_imagem());
	    System.out.println("ID da imagem: " + imagem2.getId_imagem());
	    System.out.println("ID da imagem: " + imagem3.getId_imagem());
	    System.out.println("ID da imagem: " + imagem4.getId_imagem());
	    System.out.println("ID da imagem: " + imagem5.getId_imagem());
	    System.out.println("ID da imagem: " + imagem6.getId_imagem());
	    System.out.println("ID do banner: " + banner.getId_banner());
	    System.out.println("--------------------------------------------------------------------------");
	    
	    manager.persist(fornecedor);
	    manager.flush();
	    prod_forn.setFornecedor(fornecedor);
	    prod_forn.setProduto(produto);
	    manager.persist(prod_forn);
	    manager.getTransaction().commit();  

	    manager.close();
	  }
}