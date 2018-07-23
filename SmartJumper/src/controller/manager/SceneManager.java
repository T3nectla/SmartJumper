package controller.manager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class SceneManager {

	private Scene scene;
	private Stage stage;
	private Canvas canvas;
	
	private static final SceneManager sceneManager = new SceneManager();
	private SceneManager() {}
	public static SceneManager getInstance() {
		return sceneManager;
	}
	
	public void initialize(Parent root) {
		if (scene == null) {
			scene = new Scene(root);
		}
	}
	
	public void setScene(Parent root) {
		scene.setRoot(root);
	}
	public Scene getScene() {
		return scene;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Stage getStage() {
		return stage;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public Canvas getCanvas() {
		return canvas;
	}
}