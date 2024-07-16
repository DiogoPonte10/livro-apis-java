package repositorio;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.LivroFisico;
import br.com.casadocodigo.livraria.produtos.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioDeProdutos {

	public ObservableList<Produto> lista() {

		Autor autor = new Autor();
		autor.setNome("Rodrigo	Turini");
		autor.setEmail("rodrigo.turini@caelum.com.br");
		autor.setCpf("123.456.789.10");

		Livro livro = new LivroFisico(autor);
		livro.setNome("Java 8 Prático");
		livro.setDescricao("Novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");

		Livro maisUmLivro = new LivroFisico(autor);
		maisUmLivro.setNome("Desbravando o O.O.");
		livro.setDescricao("Livro de Java e O.O");
		livro.setValor(59.90);
		livro.setIsbn("321-54-67890-11-2");

		Autor outroAutor = new Autor();
		autor.setNome("Paulo Silveira");
		autor.setEmail("paulo.silveira@caelum.com.br");
		autor.setCpf("123.456.789.10");

		Livro outroLivro = new LivroFisico(outroAutor);
		livro.setNome("Lógica de Programação");
		livro.setDescricao("Crie seus primeiros programas");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-22-0");

		return FXCollections.observableArrayList(livro, maisUmLivro, outroLivro);
	}
}
