package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operacoes
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Matheus Henrique
 * @date 23/03/2000 
 */
public class GerenciadoraClientesTest_Ex8 {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {
	
		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	
		// a) Abriu conexao com o BD? Entao...
		// b) Criou arquivos e pastas aqui? Entao...
		// c) Inseriu clientes ficticios na base de dados especificamente para os testes desta classe? Entao...
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
		
		// a) Fecha aqui!!!
		// b) Apaga todos eles aqui!!!
		// c) Apaga eles aqui!!!
	}
	
	/**
	 * Teste basico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Matheus Henrique
	 * @date 23/03/2000
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Execucao ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verificacoes ========== */
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste basico da remocao de um cliente a partir do seu ID.
	 * 
	 * @author Matheus Henrique
	 * @date 23/03/2000
	 */
	@Test
	public void testRemoveCliente() {
		
		/* ========== Execucao ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verificacoes ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
}
// A Independencia do Teste