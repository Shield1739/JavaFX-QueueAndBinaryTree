package mp.utp.erdd.cola;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mp.utp.erdd.App;
import mp.utp.erdd.cola.data.Queue;

public class QueueController implements Initializable
{
	@FXML
	private TextField inputField;

	@FXML
	private TextField lastAddedField;

	@FXML
	private TextField lastDeletedField;

	@FXML
	private TextArea textArea;

	private Queue q;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		q = new Queue();
	}

	@FXML
	private void handleAddButton()
	{
		String input = inputField.getText();

		if (input.isEmpty())
		{
			return;
		}

		q.add(input);

		String builder = "Se agrego el valor \"" + input + "\" al Queue\n";

		lastAddedField.setText(input);
		textArea.appendText(builder);

		inputField.clear();
	}

	@FXML
	private void handleSeeButton()
	{
		String see = q.see();

		if (see == null)
		{
			textArea.appendText("El Queue esta vacio\n");
			return;
		}

		String builder = "El primer valor en el Queue es: \"" + see + "\"\n";

		textArea.appendText(builder);
	}

	@FXML
	private void handlePopButton()
	{

		String delete = q.remove();

		if (delete == null)
		{
			textArea.appendText("El Queue esta vacio\n");
			return;
		}

		String builder = "\"" + delete + "\" se elimino del Queue\n";

		lastDeletedField.setText(delete);
		textArea.appendText(builder);
	}

	@FXML
	private void handleClearButton()
	{
		textArea.clear();
	}

	@FXML
	private void handleAtrasButton()
	{
		App.setStage(inputField.getScene().getWindow(), "Main");
	}
}