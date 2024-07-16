package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import repositorio.RepositorioDeProdutos;
import br.com.casadocodigo.livraria.produtos.Produto;


@SuppressWarnings({"unchecked", "rawtypes"})
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Group group = new Group();
		Scene scene = new Scene(group, 690, 510);

		ObservableList<Produto> produtos = new RepositorioDeProdutos().lista();

		TableView<Produto> tableView = new  TableView<>(produtos);

		TableColumn nomeColumn = new TableColumn("Nome");
		nomeColumn.setMinWidth(180);
		nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));

		TableColumn descColumn = new TableColumn("Descri��o");
		nomeColumn.setMinWidth(230);
		nomeColumn.setCellValueFactory(new PropertyValueFactory("descricao"));

		TableColumn valorColumn = new TableColumn("Valor");
		nomeColumn.setMinWidth(60);
		nomeColumn.setCellValueFactory(new PropertyValueFactory("valor"));

		TableColumn isbnColumn = new TableColumn("ISBN");
		nomeColumn.setMinWidth(180);
		nomeColumn.setCellValueFactory(new PropertyValueFactory("isbn"));

		tableView.getColumns().addAll(nomeColumn, descColumn, valorColumn, isbnColumn);

		final VBox vbox = new VBox(tableView);
		vbox.setPadding(new Insets(70, 0, 0, 10));

		Label label = new Label("Listagem de Livros");

		label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 30));

		label.setPadding(new Insets(20, 0, 10, 10));

		group.getChildren().addAll(label, vbox);

		primaryStage.setTitle("Sistema da livraria com Java FX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
