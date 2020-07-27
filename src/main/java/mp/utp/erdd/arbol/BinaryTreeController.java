package mp.utp.erdd.arbol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mp.utp.erdd.App;
import mp.utp.erdd.arbol.data.Arbol;

public class BinaryTreeController implements Initializable
{
	@FXML
	private TextField inputField;

	@FXML
	private TextField lastAddedField;

	@FXML
	private TextArea textArea;

	private Arbol arbol;

	private Stage arbolStage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		arbol = new Arbol();
	}

	@FXML
	private void handleAddButton()
	{
		String input = getFieldText(inputField);

		if (input == null)
		{
			return;
		}

		if (arbol.addStart(Integer.parseInt(input)))
		{
			String builder = "Se agrego el valor \"" + input + "\" al Arbol\n";

			lastAddedField.setText(input);
			textArea.appendText(builder);

			if (arbolStage != null && arbolStage.isShowing())
			{
				updateBinaryTreeView();
			}
		}
		else
		{
			textArea.appendText("El numero " + input + " ya existe en el Arbol\n");
		}
	}

	@FXML
	private void handleDelButton()
	{
		String input = getFieldText(inputField);

		if (input == null)
		{
			return;
		}

		if (arbol.deleteStart(Integer.parseInt(input)))
		{
			String builder = "Se elimino el valor \"" + input + "\" del Arbol\n";
			textArea.appendText(builder);

			if (arbolStage != null && arbolStage.isShowing())
			{
				updateBinaryTreeView();
			}
		}
		else
		{
			textArea.appendText("El numero " + input + " no existe en el Arbol\n");
		}
	}

	@FXML
	private void handleClearButton()
	{
		textArea.clear();
	}

	@FXML
	private void handleDrawButton()
	{
		if (arbol.getRoot() == null)
		{
			return;
		}

		if (arbolStage == null)
		{
			arbolStage = new Stage();
			arbolStage.setTitle("Arbol");
			arbolStage.initStyle(StageStyle.UTILITY);
		}

		updateBinaryTreeView();
	}

	@FXML
	private void handleHeightButton()
	{
		textArea.appendText("La altura del arbol es: " + arbol.findHeight(arbol.getRoot()) + "\n");
	}

	private void updateBinaryTreeView()
	{
		DrawingView pane = new DrawingView();

		Scene scene = new Scene(pane, 800, 300);
		arbolStage.setScene(scene);

		pane.getChildren().clear();
		pane.drawArbolStart(arbol.getRoot());

		arbolStage.show();
	}

	private String getFieldText(TextField field)
	{
		String input = field.getText();

		if (input.isEmpty())
		{
			return null;
		}

		field.clear();

		try
		{
			Integer.parseInt(input);
		}
		catch (NumberFormatException e)
		{
			input = null;
			textArea.appendText("Ingrese solo numeros!\n");
		}

		return input;
	}

	/**
	 * Recorridos
	 */

	@FXML
	private void handleInOrdenButton()
	{
		String recorrido = arbol.startInorder();

		if (recorrido == null)
		{
			return;
		}

		textArea.appendText("El recorrido In-Orden es: \n{" + recorrido + "}\n");
	}

	@FXML
	private void handlePreOrdenButton()
	{
		String recorrido = arbol.startPreorden();

		if (recorrido == null)
		{
			return;
		}

		textArea.appendText("El recorrido Pre-Orden es: \n{" + recorrido + "}\n");
	}

	@FXML
	private void handlePostOrdenButton()
	{
		String recorrido = arbol.startPostorden();

		if (recorrido == null)
		{
			return;
		}

		textArea.appendText("El recorrido Post-Orden es: \n{" + recorrido + "}\n");
	}

	@FXML
	private void handleAtrasButton()
	{
		if (arbolStage != null)
		{
			arbolStage.close();
		}
		App.setStage(inputField.getScene().getWindow(), "Main");
	}
}
