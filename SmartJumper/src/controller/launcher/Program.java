package controller.launcher;

import controller.manager.SmartJumperManager;
import javafx.stage.Stage;
import model.constants.Root;
import model.constants.Title;

public class Program {
	
	private static final Program program = new Program();
	private Program() {}
	public static Program getInstance() {
		return program;
	}

	public void init() {
		//Empty for now
	}
	
	public void start(Stage primaryStage) {
		SmartJumperManager smartJumperManager = SmartJumperManager.getInstance();
		smartJumperManager.initialize(Root.MENU);
		primaryStage.setScene(smartJumperManager.getScene());
		primaryStage.setTitle(Title.MENU);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		smartJumperManager.setStage(primaryStage);
	}
	
	public void stop() {
		//Empty for now
	}
}