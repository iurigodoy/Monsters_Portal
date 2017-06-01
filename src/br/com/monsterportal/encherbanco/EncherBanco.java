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
		
		Permissao permissao1 = new Permissao();
		
		permissao1.setAtualizarBanner(true);
		permissao1.setAtualizarCargo(true);
		permissao1.setAtualizarCategoria(true);
		permissao1.setAtualizarCliente(true);
		permissao1.setAtualizarFornecedor(true);
		permissao1.setAtualizarFuncionario(true);
		permissao1.setAtualizarPedido(true);
		permissao1.setAtualizarProduto(true);
		
		permissao1.setCriarBanner(true);
		permissao1.setCriarCampanha(true);
		permissao1.setCriarCargo(true);
		permissao1.setCriarCategoria(true);
		permissao1.setCriarCliente(true);
		permissao1.setCriarFornecedor(true);
		permissao1.setCriarFuncionario(true);
		permissao1.setCriarPedido(true);
		permissao1.setCriarProduto(true);

		permissao1.setLerBanner(true);
		permissao1.setLerCampanha(true);
		permissao1.setLerCargo(true);
		permissao1.setLerCategoria(true);
		permissao1.setLerCliente(true);
		permissao1.setLerFornecedor(true);
		permissao1.setLerFuncionario(true);
		permissao1.setLerPedido(true);
		permissao1.setLerProduto(true);
		
		permissao1.setExcluirBanner(true);
		permissao1.setExcluirCampanha(true);
		permissao1.setExcluirCargo(true);
		permissao1.setExcluirCategoria(true);
		permissao1.setExcluirCliente(true);
		permissao1.setExcluirFornecedor(true);
		permissao1.setExcluirFuncionario(true);
		permissao1.setExcluirPedido(true);
		permissao1.setExcluirProduto(true);
		
		permissao1.setRestaurarBanner(true);
		permissao1.setRestaurarCampanha(true);
		permissao1.setRestaurarCargo(true);
		permissao1.setRestaurarCategoria(true);
		permissao1.setRestaurarCliente(true);
		permissao1.setRestaurarFornecedor(true);
		permissao1.setRestaurarFuncionario(true);
		permissao1.setRestaurarPedido(true);
		permissao1.setRestaurarProduto(true);
		
		Cargo cargo = new Cargo();

		cargo.setNome_car("Super Usuário");
		cargo.setPadrao_car(false);
	    cargo.setCreated_at(cal.getTime());
		cargo.setUpdated_at(cal.getTime());
	    cargo.setDeleted_at(null);
	    cargo.setDeleted(false);
		
		Cargo cargo1 = new Cargo();

		cargo1.setNome_car("Medio Usuário");
		cargo1.setPadrao_car(false);
	    cargo1.setCreated_at(cal.getTime());
		cargo1.setUpdated_at(cal.getTime());
	    cargo1.setDeleted_at(null);
	    cargo1.setDeleted(false);
		
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

		funcionario1.setNome_fun("Caue Silva");
		funcionario1.setFoto_fun("foto3.jpg");
		funcionario1.setCpf_fun("408.750.798-06");
		funcionario1.setEmail_fun("cauueh@hotmail.com");
		funcionario1.setCelular_fun("11 953200491");
		funcionario1.setResidencial_fun("11 28564221");
		funcionario1.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario1.getSenha_fun()+"------------------------------------------------------------");
		funcionario1.setBloqueado_fun(false);
		
		Funcionario funcionario2 = new Funcionario();

		funcionario2.setNome_fun("Iam Carvalho");
		funcionario2.setFoto_fun("foto2.jpg");
		funcionario2.setCpf_fun("405.751.797-06");
		funcionario2.setEmail_fun("iam@hotmail.com");
		funcionario2.setCelular_fun("11 983200991");
		funcionario2.setResidencial_fun("11 26548796");
		funcionario2.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario2.getSenha_fun()+"------------------------------------------------------------");
		funcionario2.setBloqueado_fun(false);
		
		Funcionario funcionario3 = new Funcionario();

		funcionario3.setNome_fun("Leandro Domiciano");
		funcionario3.setFoto_fun("foto4.jpg");
		funcionario3.setCpf_fun("409.771.585-01");
		funcionario3.setEmail_fun("leandro.domi@hotmail.com");
		funcionario3.setCelular_fun("11 993204981");
		funcionario3.setResidencial_fun("11 29588796");
		funcionario3.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario3.getSenha_fun()+"------------------------------------------------------------");
		funcionario3.setBloqueado_fun(false);
		
		
	    // Histórico
	    funcionario.setCreated_at(cal.getTime());
		funcionario.setUpdated_at(cal.getTime());
	    funcionario.setDeleted_at(null);
	    funcionario.setDeleted(false);
		
	    // Histórico
	    funcionario1.setCreated_at(cal.getTime());
		funcionario1.setUpdated_at(cal.getTime());
	    funcionario1.setDeleted_at(null);
	    funcionario1.setDeleted(false);
		
	    // Histórico
	    funcionario2.setCreated_at(cal.getTime());
		funcionario2.setUpdated_at(cal.getTime());
	    funcionario2.setDeleted_at(null);
	    funcionario2.setDeleted(false);
		
	    // Histórico
	    funcionario3.setCreated_at(cal.getTime());
		funcionario3.setUpdated_at(cal.getTime());
	    funcionario3.setDeleted_at(null);
	    funcionario3.setDeleted(false);

		/*
		 * 
		 * Categoria
		 * 
		 */
		
		Categoria celular = new Categoria();
		celular.setNome_cat("celular");
		celular.setHierarquia_cat(0);
	    // Histórico
	    celular.setCreated_at(cal.getTime());
		celular.setUpdated_at(cal.getTime());
	    celular.setDeleted_at(null);
	    celular.setDeleted(false);
		
		Categoria eletronico = new Categoria();
		eletronico.setNome_cat("eletronico");
		eletronico.setHierarquia_cat(0);
	    // Histórico
	    eletronico.setCreated_at(cal.getTime());
		eletronico.setUpdated_at(cal.getTime());
	    eletronico.setDeleted_at(null);
	    eletronico.setDeleted(false);
		
		Categoria acessorio = new Categoria();
		acessorio.setNome_cat("acessorios");
		acessorio.setHierarquia_cat(0);
	    // Histórico
	    acessorio.setCreated_at(cal.getTime());
		acessorio.setUpdated_at(cal.getTime());
	    acessorio.setDeleted_at(null);
	    acessorio.setDeleted(false);
		
		Categoria games = new Categoria();
		games.setNome_cat("games");
		games.setHierarquia_cat(0);
		
	    // Histórico
	    games.setCreated_at(cal.getTime());
		games.setUpdated_at(cal.getTime());
	    games.setDeleted_at(null);
	    games.setDeleted(false);

		/*
		 * 
		 * Produto
		 * 
		 */
	    
	    Produto produto = new Produto();
	    
	    produto.setNome_pro("Smartphone Samsung Galaxy S7 Edge Android 6.0 Tela 5.5 32GB 4G Câmera 12MP - Preto");
	    produto.setDescricao_pro("Pense o que um smartphone pode fazer.<br> Agora, repense. O Galaxy S7 Edge veio para inovarO Galaxy S7 Edge traz hoje funcionalidades que você nunca imaginou antes em um smartphone, mas que amanhã não vai conseguir imaginar ficar sem elas."
+"<br>A beleza do Galaxy S7 Edge está na combinação sofisticada entre visual e usabilidade. Tudo elegantemente integrado para você ter em suas mãos as mais avançadas funcionalidades com um design inigualável, uma tela Super AMOLED de 5.5 com resolução Quad HD."

+"<br><br>Resistente à água e ao pó"
+"<br>O que dá para fazer com o seu celular é o que você deve repensar. Com o Galaxy S7 Edge, você pode curtir a piscina com eles, tirar selfies na praia sem risco e até chamar um táxi na chuva. Eles possuem a classificação IP68 (proteção contra elementos exteriores) o que faz deles mais resistentes e irresistíveis.");
	    // MKT
	    produto.setPromocao_pro(true);
	    produto.setPublicado_pro(true);
	    produto.setDesconto_pro(0.10);
	    produto.setDestaque_pro(true);
	    // Logistica
	    produto.setPeso_pro(0.100);
	    produto.setAltura_pro(20.000);
	    produto.setLargura_pro(20.000);
	    produto.setComprimento_pro(20.000);
	    produto.setDiametro_pro(20.000);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
	    
	    Produto produto1 = new Produto();
	    
	    produto1.setNome_pro("Kit Pneu Aro 14 Dunlop 175/65r14 Sptrgt1 82t 4 Unidades");
	    produto1.setDescricao_pro("Dunlop Sp Touring T1 foi concebido para durar, e dispõe de quatro ranhuras retas com ranhuras anti-aqua planagem dentro da banda de rodagem para reduzir aqua planagem e excelente aderência em condições molhadas. O uso de um composto de sílica banda de rodagem nos pneus Dunlop Sp Touring T1 melhora as acelerações, frenagem e dirigibilidade durante as condições de estrada molhada. A melhoria da aderência e tração ajuda o desempenho nas estradas em tempo de chuva. O Dunlop Sp Touring T1 é um pneu projetado com enfoque na durabilidade para pequenas e veículos de médio porte. O Dunlop Sp Touring T1 é projetado com um polímero especializado para resistência ao desgaste, sem comprometer a aderência do polímero existente, para fazer controle superior na estrada.");
	    // MKT
	    produto1.setPromocao_pro(true);
	    produto1.setPublicado_pro(true);
	    produto1.setDesconto_pro(0.10);
	    produto1.setDestaque_pro(true);
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
	    
	    produto2.setNome_pro("Smartphone LG K10 Novo Dual Chip Android 7.0 Tela 5,3 32GB 4G 13MP - Preto");
	    produto2.setDescricao_pro("Toda experiência da internet rápida no seu celular com o 4G da LG para você! Acesse as redes sociais, compartilhe fotos, jogue, assista vídeos e muito mais com o Smartphone LG K10, Performance de respeito! O LG K10 vem com processador Octa Core, muito mais velocidade e fluidez para tornar seu dia a dia mais produtivo. Tudo isso em uma tela de 5.3 polegadas de alta qualidade com tecnologia In-Cell touch para melhor visualização em ambientes externos. Domine as suas fotos com uma super câmera principal de 13MP e câmera de selfie de 8MP com Quick Selfie 2.0 e Virtual Flash.");
	    // MKT
	    produto2.setPromocao_pro(true);
	    produto2.setPublicado_pro(true);
	    produto2.setDesconto_pro(0.10);
	    produto2.setDestaque_pro(true);
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
	    produto4.setDeleted(true);
		
		
		Produto produto5 = new Produto();
	    
	    produto5.setNome_pro("Mouse Wireless WM126 Preto - Dell");
	    produto5.setDescricao_pro("O mouse óptico wireless WM126 da Dell oferece performance wireless para uso diário com excelente duração da bateria. Ele foi projetado para criar um espaço de trabalho organizado com uma conexão RF wireless e plug-and-play confiável.");
	    // MKT
	    produto5.setPromocao_pro(true);
	    produto5.setPublicado_pro(true);
	    produto5.setDesconto_pro(0.10);
	    produto5.setDestaque_pro(true);
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
	    // MKT
	    produto6.setPromocao_pro(true);
	    produto6.setPublicado_pro(true);
	    produto6.setDesconto_pro(0.10);
	    produto6.setDestaque_pro(true);
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
	    // MKT
	    produto7.setPromocao_pro(true);
	    produto7.setPublicado_pro(true);
	    produto7.setDesconto_pro(0.10);
	    produto7.setDestaque_pro(true);
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
	    
	    produto9.setNome_pro("Kit Portão Eletrônico Deslizante Rossi Dz Nano Turbo 1/4 Hp");
	    produto9.setDescricao_pro("Os Portões Deslizantes, Mais Conhecidos Como Portões De Correr, Abrem Por Deslizamentos Sobre Trilhos E Trabalham Com Trilho Inferiores Ou Superiores, Bem Aceitos No Mercado, Usados Em Residências, Prédios, Condomínios E Fábricas, Por Serem Mais Práticos E Rápidos");
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
	    // MKT
	    produto11.setPromocao_pro(true);
	    produto11.setPublicado_pro(true);
	    produto11.setDesconto_pro(0.10);
	    produto11.setDestaque_pro(true);
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
	    produto13.setDeleted(true);
		
		
		Produto produto14 = new Produto();
	    
	    produto14.setNome_pro("Capa Estepe Nproduto12sport 2013 2014 2015 Bepo Prata Enseada");
	    produto14.setDescricao_pro("Capa de Estepe Nova Ecosport 2013 2014 2015 Bepo Prata Enseada em ABS Rígido Desenvolvida pela Bepo, fabricante nacionalmente conhecida pela excelência em acessórios automotivos de alto padrão, a capa de estepe é uma peça instalada sobre o estepe traseiro da sua Nova Ecosport e um acessório ideal para quem procura proteção e estilo, com seu design moderno e sofisticado a mesma garante ao estepe alta segurança, pois acompanha trava anti-furto");
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
	    Imagem imagem7 = new Imagem();
	    imagem7.setArquivo_ima("07.jpg");
	    imagem7.setOrdem_ima(7);
	    
	    Imagem imagem_1 = new Imagem();
	    imagem_1.setArquivo_ima("produto1.jpeg");
	    imagem_1.setOrdem_ima(1);
	    Imagem imagem1_2 = new Imagem();
	    imagem1_2.setArquivo_ima("produto1_2.jpeg");
	    imagem1_2.setOrdem_ima(2);
	    Imagem imagem1_3 = new Imagem();
	    imagem1_3.setArquivo_ima("produto1_3.jpeg");
	    imagem1_3.setOrdem_ima(3);

	    Imagem imagem_2 = new Imagem();
	    imagem_2.setArquivo_ima("produto2.jpeg");
	    imagem_2.setOrdem_ima(1);
	    Imagem imagem2_1 = new Imagem();
	    imagem2_1.setArquivo_ima("produto2_1.jpeg");
	    imagem2_1.setOrdem_ima(2);

	    Imagem imagem_3 = new Imagem();
	    imagem_3.setArquivo_ima("produto3.jpeg");
	    imagem_3.setOrdem_ima(1);
	    Imagem imagem3_1 = new Imagem();
	    imagem3_1.setArquivo_ima("produto3_1.jpeg");
	    imagem3_1.setOrdem_ima(2);
	    Imagem imagem3_2 = new Imagem();
	    imagem3_2.setArquivo_ima("produto3_2.jpeg");
	    imagem3_2.setOrdem_ima(3);

	    Imagem imagem_4 = new Imagem();
	    imagem_4.setArquivo_ima("produto4.jpeg");
	    imagem_4.setOrdem_ima(1);
	    Imagem imagem4_1 = new Imagem();
	    imagem4_1.setArquivo_ima("produto4_1.jpeg");
	    imagem4_1.setOrdem_ima(2);
	    Imagem imagem4_2 = new Imagem();
	    imagem4_2.setArquivo_ima("produto4_2.jpeg");
	    imagem4_2.setOrdem_ima(3);

	    Imagem imagem_5 = new Imagem();
	    imagem_5.setArquivo_ima("produto5.jpeg");
	    imagem_5.setOrdem_ima(1);
	    Imagem imagem5_1 = new Imagem();
	    imagem5_1.setArquivo_ima("produto5_1.jpeg");
	    imagem5_1.setOrdem_ima(2);
	    Imagem imagem5_2 = new Imagem();
	    imagem5_2.setArquivo_ima("produto5_2.jpeg");
	    imagem5_2.setOrdem_ima(3);

	    Imagem imagem_6 = new Imagem();
	    imagem_6.setArquivo_ima("produto6.jpeg");
	    imagem_6.setOrdem_ima(1);
	    Imagem imagem6_1 = new Imagem();
	    imagem6_1.setArquivo_ima("produto6_1.jpeg");
	    imagem6_1.setOrdem_ima(2);

	    Imagem imagem_7 = new Imagem();
	    imagem_7.setArquivo_ima("produto7.jpeg");
	    imagem_7.setOrdem_ima(1);
	    Imagem imagem7_1 = new Imagem();
	    imagem7_1.setArquivo_ima("produto7_1.jpeg");
	    imagem7_1.setOrdem_ima(2);

	    Imagem imagem8 = new Imagem();
	    imagem8.setArquivo_ima("produto8.jpeg");
	    imagem8.setOrdem_ima(1);

	    Imagem imagem9 = new Imagem();
	    imagem9.setArquivo_ima("produto9.jpeg");
	    imagem9.setOrdem_ima(1);
	    Imagem imagem9_1 = new Imagem();
	    imagem9_1.setArquivo_ima("produto9_1.jpeg");
	    imagem9_1.setOrdem_ima(2);
	    Imagem imagem9_2 = new Imagem();
	    imagem9_2.setArquivo_ima("produto9_2.jpeg");
	    imagem9_2.setOrdem_ima(3);

	    Imagem imagem10 = new Imagem();
	    imagem10.setArquivo_ima("produto10.jpeg");
	    imagem10.setOrdem_ima(1);
	    Imagem imagem10_1 = new Imagem();
	    imagem10_1.setArquivo_ima("produto10_1.jpeg");
	    imagem10_1.setOrdem_ima(2);

	    Imagem imagem11 = new Imagem();
	    imagem11.setArquivo_ima("produto11.jpeg");
	    imagem11.setOrdem_ima(1);

	    Imagem imagem12 = new Imagem();
	    imagem12.setArquivo_ima("produto12.jpeg");
	    imagem12.setOrdem_ima(1);
	    Imagem imagem12_1 = new Imagem();
	    imagem12_1.setArquivo_ima("produto12_1.jpeg");
	    imagem12_1.setOrdem_ima(2);
	    Imagem imagem12_2 = new Imagem();
	    imagem12_2.setArquivo_ima("produto12_2.jpeg");
	    imagem12_2.setOrdem_ima(3);

	    Imagem imagem13 = new Imagem();
	    imagem13.setArquivo_ima("produto13.jpeg");
	    imagem13.setOrdem_ima(1);
	    Imagem imagem13_1 = new Imagem();
	    imagem13_1.setArquivo_ima("produto13_1.jpeg");
	    imagem13_1.setOrdem_ima(2);

	    Imagem imagem14 = new Imagem();
	    imagem14.setArquivo_ima("produto14.jpeg");
	    imagem14.setOrdem_ima(1);
	    Imagem imagem14_1 = new Imagem();
	    imagem14_1.setArquivo_ima("produto14_1.jpeg");
	    imagem14_1.setOrdem_ima(2);
	    Imagem imagem14_2 = new Imagem();
	    imagem14_2.setArquivo_ima("produto14_2.jpeg");
	    imagem14_2.setOrdem_ima(3);

	    Imagem imagem15 = new Imagem();
	    imagem15.setArquivo_ima("produto15.jpeg");
	    imagem15.setOrdem_ima(1);
	    Imagem imagem15_1 = new Imagem();
	    imagem15_1.setArquivo_ima("produto15_1.jpeg");
	    imagem15_1.setOrdem_ima(2);
	    Imagem imagem15_2 = new Imagem();
	    imagem15_2.setArquivo_ima("produto15_2.jpeg");
	    imagem15_2.setOrdem_ima(3);

	    Imagem imagem16 = new Imagem();
	    imagem16.setArquivo_ima("produto16.jpeg");
	    imagem16.setOrdem_ima(1);
	    
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
	    
	    banner1.setArquivo_ban("banner5.jpg");
	    banner1.setAtivo_ban(true);
	    // Histórico
	    banner1.setCreated_at(cal.getTime());
		banner1.setUpdated_at(cal.getTime());
	    banner1.setDeleted_at(null);
	    banner1.setDeleted(false);
		
		Banner banner2 = new Banner();
	    
	    banner2.setArquivo_ban("banner1.jpg");
	    banner2.setAtivo_ban(true);
	    // Histórico
	    banner2.setCreated_at(cal.getTime());
		banner2.setUpdated_at(cal.getTime());
	    banner2.setDeleted_at(null);
	    banner2.setDeleted(false);
		
		Banner banner3 = new Banner();
	    
	    banner3.setArquivo_ban("banner2.jpg");
	    banner3.setAtivo_ban(true);
	    // Histó
	    banner3.setCreated_at(cal.getTime());
		banner3.setUpdated_at(cal.getTime());
	    banner3.setDeleted_at(null);
	    banner3.setDeleted(false);
		
		Banner banner4 = new Banner();
	    
	    banner4.setArquivo_ban("banner3.jpg");
	    banner4.setAtivo_ban(true);
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

	    fornecedor1.setNome_for("Armazem do vidro");
	    fornecedor1.setLogo_for("logo2.jpg");
	    fornecedor1.setEmail_for("armazemdovidro@hotmail.com");
	    fornecedor1.setCnpj_for("37.886.872/0001-86");
	    fornecedor1.setCep_for("09534-290");
	    fornecedor1.setEstado_for("SP");
	    fornecedor1.setCidade_for("São Paulo");
	    fornecedor1.setEndereco_for("Rua Cruz e Souza");
	    fornecedor1.setComplemento_for("");
	    fornecedor1.setComercial_for("11 48136586");
		
		Fornecedor fornecedor2 = new Fornecedor();

	    fornecedor2.setNome_for("Fedex");
	    fornecedor2.setLogo_for("logo3.jpg");
	    fornecedor2.setEmail_for("fedex@fedex.com");
	    fornecedor2.setCnpj_for("39.996.856/0001-56");
	    fornecedor2.setCep_for("09658-250");
	    fornecedor2.setEstado_for("SP");
	    fornecedor2.setCidade_for("São Paulo");
	    fornecedor2.setEndereco_for("Rua Francisco");
	    fornecedor2.setComplemento_for("");
	    fornecedor2.setComercial_for("11 25687563");
		
		Fornecedor fornecedor3 = new Fornecedor();

	    fornecedor3.setNome_for("Padaria União");
	    fornecedor3.setLogo_for("logo4.jpg");
	    fornecedor3.setEmail_for("padariauniao@gmail.com");
	    fornecedor3.setCnpj_for("45.789.772/0002-86");
	    fornecedor3.setCep_for("09584-510");
	    fornecedor3.setEstado_for("SP");
	    fornecedor3.setCidade_for("São Paulo");
	    fornecedor3.setEndereco_for("Rua Teotonio Vilela");
	    fornecedor3.setComplemento_for("");
	    fornecedor3.setComercial_for("11 24516328");
		
		Fornecedor fornecedor4 = new Fornecedor();

	    fornecedor4.setNome_for("Franklin");
	    fornecedor4.setLogo_for("logo5.jpg");
	    fornecedor4.setEmail_for("Flanklin@hotmail.com");
	    fornecedor4.setCnpj_for("46.985.564/0001-96");
	    fornecedor4.setCep_for("09132-190");
	    fornecedor4.setEstado_for("SP");
	    fornecedor4.setCidade_for("São Paulo");
	    fornecedor4.setEndereco_for("Rua Matarazo");
	    fornecedor4.setComplemento_for("");
	    fornecedor4.setComercial_for("11 446156596");
		
		Fornecedor fornecedor5 = new Fornecedor();

	    fornecedor5.setNome_for("Remodeling");
	    fornecedor5.setLogo_for("logo1.jpg");
	    fornecedor5.setEmail_for("remodeling@gmail.com");
	    fornecedor5.setCnpj_for("56.554.254/0001-24");
	    fornecedor5.setCep_for("08541-250");
	    fornecedor5.setEstado_for("SP");
	    fornecedor5.setCidade_for("São Paulo");
	    fornecedor5.setEndereco_for("Rua Epitacio Pessoa");
	    fornecedor5.setComplemento_for("");
	    fornecedor5.setComercial_for("11 42589635");
		
		
	    // Histórico
	    fornecedor.setCreated_at(cal.getTime());
		fornecedor.setUpdated_at(cal.getTime());
	    fornecedor.setDeleted_at(null);
	    fornecedor.setDeleted(false);
	    // Histórico
	    fornecedor1.setCreated_at(cal.getTime());
		fornecedor1.setUpdated_at(cal.getTime());
	    fornecedor1.setDeleted_at(null);
	    fornecedor1.setDeleted(false);
	    // Histórico
	    fornecedor2.setCreated_at(cal.getTime());
		fornecedor2.setUpdated_at(cal.getTime());
	    fornecedor2.setDeleted_at(null);
	    fornecedor2.setDeleted(false);
	    // Histórico
	    fornecedor3.setCreated_at(cal.getTime());
		fornecedor3.setUpdated_at(cal.getTime());
	    fornecedor3.setDeleted_at(null);
	    fornecedor3.setDeleted(false);
	    // Histórico
	    fornecedor4.setCreated_at(cal.getTime());
		fornecedor4.setUpdated_at(cal.getTime());
	    fornecedor4.setDeleted_at(null);
	    fornecedor4.setDeleted(false);
	    // Histórico
	    fornecedor5.setCreated_at(cal.getTime());
		fornecedor5.setUpdated_at(cal.getTime());
	    fornecedor5.setDeleted_at(null);
	    fornecedor5.setDeleted(false);
	    
	    /*
	     * 
	     * Produto do Fornecedor
	     * 
	     */
	    
	    Produto_has_fornecedor prod_forn = new Produto_has_fornecedor();
	    prod_forn.setPreco_prod(100.00);
	    prod_forn.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn1 = new Produto_has_fornecedor();
	    prod_forn1.setPreco_prod(100.00);
	    prod_forn1.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn2 = new Produto_has_fornecedor();
	    prod_forn2.setPreco_prod(100.00);
	    prod_forn2.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn3 = new Produto_has_fornecedor();
	    prod_forn3.setPreco_prod(100.00);
	    prod_forn3.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn4 = new Produto_has_fornecedor();
	    prod_forn4.setPreco_prod(100.00);
	    prod_forn4.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn5 = new Produto_has_fornecedor();
	    prod_forn5.setPreco_prod(100.00);
	    prod_forn5.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn6 = new Produto_has_fornecedor();
	    prod_forn6.setPreco_prod(100.00);
	    prod_forn6.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn7 = new Produto_has_fornecedor();
	    prod_forn7.setPreco_prod(100.00);
	    prod_forn7.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn8 = new Produto_has_fornecedor();
	    prod_forn8.setPreco_prod(100.00);
	    prod_forn8.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn9 = new Produto_has_fornecedor();
	    prod_forn9.setPreco_prod(100.00);
	    prod_forn9.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn10 = new Produto_has_fornecedor();
	    prod_forn10.setPreco_prod(100.00);
	    prod_forn10.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn11 = new Produto_has_fornecedor();
	    prod_forn11.setPreco_prod(100.00);
	    prod_forn11.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn12 = new Produto_has_fornecedor();
	    prod_forn12.setPreco_prod(100.00);
	    prod_forn12.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn13 = new Produto_has_fornecedor();
	    prod_forn13.setPreco_prod(100.00);
	    prod_forn13.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn14 = new Produto_has_fornecedor();
	    prod_forn14.setPreco_prod(100.00);
	    prod_forn14.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn15 = new Produto_has_fornecedor();
	    prod_forn15.setPreco_prod(100.00);
	    prod_forn15.setQuantidade_prod(10);
	    
	    Produto_has_fornecedor prod_forn16 = new Produto_has_fornecedor();
	    prod_forn16.setPreco_prod(100.00);
	    prod_forn16.setQuantidade_prod(10);

	    /*
	     * Injetar
	     */
	    
	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("produtos");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();   

	    manager.persist(cargo);
	    manager.flush();
	    manager.persist(cargo1);
	    manager.flush();
	    permissao.setCargo(cargo);
	    manager.persist(permissao);
	    manager.flush();
	    permissao1.setCargo(cargo1);
	    manager.persist(permissao1);
	    manager.flush();
	    
	    funcionario.setCargo(cargo);
	    manager.persist(funcionario);
	    funcionario1.setCargo(cargo);
	    manager.persist(funcionario1);
	    funcionario2.setCargo(cargo1);
	    manager.persist(funcionario2);
	    funcionario3.setCargo(cargo1);
	    manager.persist(funcionario3);
	    
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da permissao: " + permissao.getId_permissao());
	    System.out.println("ID do cargo: " + cargo.getId_cargo());
	    System.out.println("ID do funcionario: " + funcionario.getId_funcionario());
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("-------------------------------------------------"+funcionario.getSenha_fun());
	    
	    manager.persist(celular);
	    manager.flush();
	    manager.persist(acessorio);
	    manager.flush();
	    manager.persist(games);
	    manager.flush();
	    manager.persist(eletronico);
	    manager.flush();

	    produto.setCategoria(celular);
	    manager.persist(produto);
	    manager.flush();
	    produto1.setCategoria(acessorio);
	    manager.persist(produto1);
	    manager.flush();
	    produto2.setCategoria(celular);
	    manager.persist(produto2);
	    manager.flush();
	    produto3.setCategoria(celular);
	    manager.persist(produto3);
	    manager.flush();
	    produto4.setCategoria(games);
	    manager.persist(produto4);
	    manager.flush();
	    produto5.setCategoria(acessorio);
	    manager.persist(produto5);
	    manager.flush();
	    produto6.setCategoria(acessorio);
	    manager.persist(produto6);
	    manager.flush();
	    produto7.setCategoria(games);
	    manager.persist(produto7);
	    manager.flush();
	    produto8.setCategoria(acessorio);
	    manager.persist(produto8);
	    manager.flush();
	    produto9.setCategoria(eletronico);
	    manager.persist(produto9);
	    manager.flush();
	    produto10.setCategoria(eletronico);
	    manager.persist(produto10);
	    manager.flush();
	    produto11.setCategoria(acessorio);
	    manager.persist(produto11);
	    manager.flush();
	    produto12.setCategoria(acessorio);
	    manager.persist(produto12);
	    manager.flush();
	    produto13.setCategoria(acessorio);
	    manager.persist(produto13);
	    manager.flush();
	    produto14.setCategoria(acessorio);
	    manager.persist(produto14);
	    manager.flush();
	    produto15.setCategoria(acessorio);
	    manager.persist(produto15);
	    manager.flush();
	    produto16.setCategoria(acessorio);
	    manager.persist(produto16);
	    manager.flush();
	    
	    imagem1.setProduto(produto);
	    imagem2.setProduto(produto);
	    imagem3.setProduto(produto);
	    imagem4.setProduto(produto);
	    imagem5.setProduto(produto);
	    imagem6.setProduto(produto);
	    imagem7.setProduto(produto);
	    
	    imagem_1.setProduto(produto16);
	    imagem1_2.setProduto(produto16);
	    imagem1_3.setProduto(produto16);
	    
	    imagem_2.setProduto(produto15);
	    imagem2_1.setProduto(produto15);
	    
	    imagem_3.setProduto(produto14);
	    imagem3_1.setProduto(produto14);
	    imagem3_2.setProduto(produto14);
	    
	    imagem_4.setProduto(produto13);
	    imagem4_1.setProduto(produto13);
	    imagem4_2.setProduto(produto13);
	    
	    imagem_5.setProduto(produto12);
	    imagem5_1.setProduto(produto12);
	    imagem5_2.setProduto(produto12);
	    
	    imagem_6.setProduto(produto11);
	    imagem6_1.setProduto(produto11);
	    
	    imagem_7.setProduto(produto10);
	    imagem7_1.setProduto(produto10);
	    
	    imagem8.setProduto(produto9);
	    
	    imagem9.setProduto(produto8);
	    imagem9_1.setProduto(produto8);
	    imagem9_2.setProduto(produto8);
	    
	    imagem10.setProduto(produto7);
	    imagem10_1.setProduto(produto7);
	    
	    imagem11.setProduto(produto6);
	    
	    imagem12.setProduto(produto5);
	    imagem12_1.setProduto(produto5);
	    imagem12_2.setProduto(produto5);
	    
	    imagem13.setProduto(produto4);
	    imagem13_1.setProduto(produto4);
	    
	    imagem14.setProduto(produto3);
	    imagem14_1.setProduto(produto3);
	    imagem14_2.setProduto(produto3);
	    
	    imagem15.setProduto(produto2);
	    imagem15_1.setProduto(produto2);
	    imagem15_2.setProduto(produto2);
	    
	    imagem16.setProduto(produto1);

	    manager.persist(imagem1);
	    manager.persist(imagem2);
	    manager.persist(imagem3);
	    manager.persist(imagem4);
	    manager.persist(imagem5);
	    manager.persist(imagem6);
	    manager.persist(imagem7);
	    System.out.println("------------------------------------Imagem "+imagem1.getId_imagem()+"------------------");
	    manager.persist(imagem_1);
	    manager.persist(imagem1_2);
	    manager.persist(imagem1_3);
	    System.out.println("------------------------------------Imagem_1 "+imagem_1.getId_imagem()+"---------------");
	    manager.persist(imagem_2);
	    manager.persist(imagem2_1);
	    System.out.println("------------------------------------Imagem_2 "+imagem_2.getId_imagem()+"---------------");
	    manager.persist(imagem_3);
	    manager.persist(imagem3_1);
	    manager.persist(imagem3_2);
	    System.out.println("------------------------------------Imagem_3 "+imagem_3.getId_imagem()+"---------------");
	    manager.persist(imagem_4);
	    manager.persist(imagem4_1);
	    manager.persist(imagem4_2);
	    System.out.println("------------------------------------Imagem_4 "+imagem_4.getId_imagem()+"---------------");
	    manager.persist(imagem_5);
	    manager.persist(imagem5_1);
	    manager.persist(imagem5_2);
	    System.out.println("------------------------------------Imagem_5 "+imagem_5.getId_imagem()+"---------------");
	    manager.persist(imagem_6);
	    manager.persist(imagem6_1);
	    System.out.println("------------------------------------Imagem_6 "+imagem_6.getId_imagem()+"---------------");
	    manager.persist(imagem_7);
	    manager.persist(imagem7_1);
	    System.out.println("------------------------------------Imagem_7 "+imagem_7.getId_imagem()+"---------------");
	    manager.persist(imagem8);
	    System.out.println("------------------------------------Imagem_8 "+imagem8.getId_imagem()+"---------------");
	    manager.persist(imagem9);
	    manager.persist(imagem9_1);
	    manager.persist(imagem9_2);
	    System.out.println("------------------------------------Imagem_9 "+imagem9.getId_imagem()+"---------------");
	    manager.persist(imagem10);
	    manager.persist(imagem10_1);
	    System.out.println("------------------------------------Imagem_10 "+imagem10.getId_imagem()+"---------------");
	    manager.persist(imagem11);
	    System.out.println("------------------------------------Imagem_11 "+imagem11.getId_imagem()+"---------------");
	    manager.persist(imagem12);
	    manager.persist(imagem12_1);
	    manager.persist(imagem12_2);
	    System.out.println("------------------------------------Imagem_12 "+imagem12.getId_imagem()+"---------------");
	    manager.persist(imagem13);
	    manager.persist(imagem13_1);
	    System.out.println("------------------------------------Imagem_13 "+imagem13.getId_imagem()+"---------------");
	    manager.persist(imagem14);
	    manager.persist(imagem14_1);
	    manager.persist(imagem14_2);
	    System.out.println("------------------------------------Imagem_14 "+imagem14.getId_imagem()+"---------------");
	    manager.persist(imagem15);
	    manager.persist(imagem15_1);
	    manager.persist(imagem15_2);
	    System.out.println("------------------------------------Imagem_15 "+imagem15.getId_imagem()+"---------------");
	    manager.persist(imagem16);
	    System.out.println("------------------------------------Imagem_16 "+imagem16.getId_imagem()+"---------------");
	    
	    banner.setProduto(produto);
	    manager.persist(banner);
	    manager.persist(banner1);
	    manager.persist(banner2);
	    manager.persist(banner3);
	    manager.persist(banner4);

	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da categoria: " + acessorio.getId_categoria());
	    System.out.println("ID do produto: " + produto1.getId_produto());
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
	    manager.persist(fornecedor1);
	    manager.flush();
	    manager.persist(fornecedor2);
	    manager.flush();
	    manager.persist(fornecedor3);
	    manager.flush();
	    manager.persist(fornecedor4);
	    manager.flush();
	    manager.persist(fornecedor5);
	    manager.flush();

	    prod_forn.setFornecedor(fornecedor);
	    prod_forn.setProduto(produto);
	    manager.persist(prod_forn);
	    
	    prod_forn1.setFornecedor(fornecedor);
	    prod_forn1.setProduto(produto1);
	    manager.persist(prod_forn1);
	    
	    prod_forn2.setFornecedor(fornecedor);
	    prod_forn2.setProduto(produto2);
	    manager.persist(prod_forn2);
	    
	    prod_forn3.setFornecedor(fornecedor);
	    prod_forn3.setProduto(produto3);
	    manager.persist(prod_forn3);
	    
	    prod_forn4.setFornecedor(fornecedor);
	    prod_forn4.setProduto(produto4);
	    manager.persist(prod_forn4);
	    
	    prod_forn5.setFornecedor(fornecedor1);
	    prod_forn5.setProduto(produto5);
	    manager.persist(prod_forn5);
	    
	    prod_forn6.setFornecedor(fornecedor1);
	    prod_forn6.setProduto(produto6);
	    manager.persist(prod_forn6);

	    prod_forn7.setFornecedor(fornecedor1);
	    prod_forn7.setProduto(produto7);
	    manager.persist(prod_forn7);

	    prod_forn8.setFornecedor(fornecedor5);
	    prod_forn8.setProduto(produto8);
	    manager.persist(prod_forn8);

	    prod_forn9.setFornecedor(fornecedor2);
	    prod_forn9.setProduto(produto9);
	    manager.persist(prod_forn9);

	    prod_forn10.setFornecedor(fornecedor2);
	    prod_forn10.setProduto(produto10);
	    manager.persist(prod_forn10);

	    prod_forn11.setFornecedor(fornecedor2);
	    prod_forn11.setProduto(produto11);
	    manager.persist(prod_forn11);

	    prod_forn12.setFornecedor(fornecedor5);
	    prod_forn12.setProduto(produto12);
	    manager.persist(prod_forn12);

	    prod_forn13.setFornecedor(fornecedor3);
	    prod_forn13.setProduto(produto13);
	    manager.persist(prod_forn13);

	    prod_forn14.setFornecedor(fornecedor3);
	    prod_forn14.setProduto(produto14);
	    manager.persist(prod_forn14);

	    prod_forn15.setFornecedor(fornecedor4);
	    prod_forn15.setProduto(produto15);
	    manager.persist(prod_forn15);

	    prod_forn16.setFornecedor(fornecedor4);
	    prod_forn16.setProduto(produto16);
	    manager.persist(prod_forn16);
	    
	    manager.getTransaction().commit();  

	    manager.close();
	  }
}