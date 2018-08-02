package controller.manager;

import java.util.ArrayList;
import java.util.List;

import model.view.View;

public class ViewManager {

	private List<View> views = new ArrayList<>();
	
	private static final ViewManager viewManager = new ViewManager();
	private ViewManager() {}
	public static ViewManager getInstance() {
		return viewManager;
	}
	
	public void addView(View view) {
		views.add(view);
	}
	public void addViews(List<View> views) {
		this.views.addAll(views);
	}
	
	public void removeView(View view) {
		views.remove(view);
	}
	public void removeViews(List<View> views) {
		this.views.removeAll(views);
	}
	
	public void updateView(View view) {
		views.remove(view);
		views.add(view);
	}
	
	public void clear() {
		views.clear();
	}
	
	public List<View> getViews() {
		return views;
	}
}