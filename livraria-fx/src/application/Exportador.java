package application;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import br.com.casadocodigo.livraria.produtos.Produto;

/**
 *
 * @author DIOGO
 *
 */
public class Exportador {

	/**
	 *
	 * @param exportar a lista dos produtos.
	 * @throws IOException em caso de erros.
	 */
	public void paraCSV(List<Produto> produtos) throws IOException {

		PrintStream ps = new PrintStream("produtos.csv");
			ps.println("Nome, Descricao, Valor, ISBN");

			for (Produto prod : produtos) {
				ps.println(String.format("%s, %s, %s, %s",
					prod.getNome(),
					prod.getDescricao(),
					prod.getValor(),
					prod.getIsbn()));
			}
			ps.close();
	}
}
