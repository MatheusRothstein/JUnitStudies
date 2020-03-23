package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operacoes
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}.
 * 
 * @author Matheus Henrique 
 * @date 23/03/2000
 */
public class GerenciadoraContasTest_Ex4 {

	private GerenciadoraContas gerContas;
	
	/**
	 * Teste basico da transferencia de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transferencia
	 * ocorrer com sucesso.
	 * 
	 * @author Matheus Henrique
	 * @date 23/03/2000
	 */
	@Test
	public void testTransfereValor() {

		/* ========== Montagem do cenario ========== */
		
		// criando alguns clientes
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execucao ========== */
		boolean sucesso = gerContas.transfereValor(1, 100, 2);
		
		/* ========== Verificacoes ========== */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
	}

}

// Documentacao e comentarios