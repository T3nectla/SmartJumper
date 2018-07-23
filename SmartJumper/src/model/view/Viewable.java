package model.view;

import javafx.geometry.Point2D;
import model.bounds.Bound;

public interface Viewable{
	
	abstract Point2D getPos();
	abstract Bound getBound();
}