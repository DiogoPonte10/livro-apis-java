package application;

import java.io.IOException;

import br.com.casadocodigo.livraria.produtos.Produto;
import dao.ProdutoDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author DIOGO
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {

		Group group = new Group();
		Scene scene = new Scene(group, 690, 510);

		scene.getStylesheets().add(getClass().getResource("application.css")
				.toExternalForm());

		ObservableList<Produto> produtos = new ProdutoDAO().lista();

		TableView<Produto> tableView = new  TableView<>(produtos);

		TableColumn nomeColumn = criaColuna("Nome",	180, "nome");
		TableColumn descColumn = criaColuna("Descrição", 230, "descricao");
		TableColumn valorColumn = criaColuna("Valor", 60, "valor");
		TableColumn isbnColumn = criaColuna("ISBN", 180, "isbn");

		tableView.getColumns().addAll(nomeColumn, descColumn, valorColumn, isbnColumn);

		final VBox vbox = new VBox(tableView);
		vbox.setId("vbox");

		Label label = new Label("Listagem de Livros");
		label.setId("label-listagem");

		Label progresso = new Label();
		progresso.setId("label-progresso");

		Button button = new Button("Exportar CVS");

		button.setOnAction(event -> {

			Task<Void> task = new Task<Void>() {
				@Override
				protected Void call() throws Exception {
				dormePorDezSegundos();
				exportaEmCSV(produtos);
				return null;
				}
			};

			task.setOnRunning(e -> progresso.setText("Exportando..."));

			task.setOnSucceeded(e -> progresso.setText("Concluído!"));

			new Thread(task).start();
		});

		double valorTotal = produtos.stream().mapToDouble(Produto::getValor).sum();

		Label labelFooter = new Label(String.format("Você tem R$%.2f em estoque, "
				+ "com um total de %d produtos. ", valorTotal, produtos.size()));
		labelFooter.setId("label-footer");

		group.getChildren().addAll(label, vbox, button, progresso, labelFooter);

		primaryStage.setTitle("Sistema da livraria com Java FX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private TableColumn criaColuna(String titulo, int largura, String atributo) {
		TableColumn column = new TableColumn<>(titulo);
		column.setMinWidth(largura);
		column.setCellValueFactory(new PropertyValueFactory(atributo));

		return column;
	}

	private void exportaEmCSV(ObservableList<Produto> produtos) {
		try {
			new Exportador().paraCSV(produtos);
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
	}

	private void dormePorDezSegundos() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
