package model.constants;

import controller.manager.FXLoader;
import javafx.scene.Parent;

public final class Root {

	private Root() {}
	
	public static final Parent MENU = FXLoader.getInstance().load("/view/window/MenuWindow.fxml");
	public static final Parent GAME = FXLoader.getInstance().load("/view/window/GameWindow.fxml");
	public static final Parent INSTALLATION = FXLoader.getInstance().load("/view/window/InstallationWindow.fxml");
}