package model.view;

import javafx.geometry.Point2D;
import model.bound.Bound;

public interface Viewable{
	abstract Point2D getPos();
	abstract Bound getBound();
}