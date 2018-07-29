package controller.launcher;

import controller.manager.SceneManager;
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
		SceneManager sceneManager = SceneManager.getInstance();
		sceneManager.initialize(Root.MENU);
		primaryStage.setScene(sceneManager.getScene());
		primaryStage.setTitle(Title.MENU);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		sceneManager.setStage(primaryStage);
	}
	
	public void stop() {
		//Empty for now
	}
}