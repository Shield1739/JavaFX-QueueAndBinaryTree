package mp.utp.erdd;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		Parent root = getRoot("Main");
		Scene scene = new Scene(root);
		primaryStage.setTitle("ERDD");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static Parent getRoot(String fxml)
	{
		try
		{
			return FXMLLoader.load(App.class.getResource(fxml + ".fxml"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void setStage(Window window, String fxml)
	{
		Stage stage = (Stage) window;
		Parent root = getRoot(fxml);
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	public static void main(String[] args)
	{
		launch();
	}

}