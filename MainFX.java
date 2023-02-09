import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainFX extends Application{
	
	public static void main(String[] args) {
		
		try {
			launch(args); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Stage stage = new Stage(); 
		
		
		//miners should be declared here 
		
		
		
		Parent root = FXMLLoader.load(getClass().getResource("IncomeScene.fxml"));
		
		//Group root = new Group(); 
		
		Scene scene = new Scene(root); 
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
		
		stage.setTitle("CommandLine Capitalist");
		
		
		stage.setScene(scene);
		
		stage.show(); //this must stay at the end of the start method
		
	}
}
