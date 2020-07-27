package mp.utp.erdd;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainController
{
	@FXML
	AnchorPane mainPane;

	@FXML
	void handleQueue()
	{
		App.setStage(mainPane.getScene().getWindow(), "cola/Queue");
	}

	@FXML
	void handleTree()
	{
		App.setStage(mainPane.getScene().getWindow(), "arbol/BinaryTree");
	}
}
