package negocio;

/**
 * Excecao a ser lancada quando a idade de um possivel novo cliente nao for aceita.
 * 
 * @author Matheus Henrique
 */
public class IdadeNaoPermitidaException extends Exception {

	public static String MSG_IDADE_INVALIDA = "A idade do cliente precisa estar entre 18 e 65 anos.";
	
	public IdadeNaoPermitidaException(String msg) {
		super(msg);
	}

}
