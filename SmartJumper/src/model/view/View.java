package model.view;

public abstract class View {

	private Viewable viewableObject;
	
	public View(Viewable viewableObject) {
		this.viewableObject = viewableObject;
	}
	
	public abstract void show();
	
	public Viewable getViewableObject() {
		return viewableObject;
	}
}