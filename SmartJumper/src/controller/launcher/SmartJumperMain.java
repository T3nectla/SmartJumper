package controller.launcher;

import javafx.application.Application;
import javafx.stage.Stage;

public class SmartJumperMain extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void init() {
		Program.getInstance().init();
	}
	
	@Override
	public void start(Stage primaryStage) {
		Program.getInstance().start(primaryStage);
	}
	
	@Override
	public void stop() {
		Program.getInstance().stop();
	}
}