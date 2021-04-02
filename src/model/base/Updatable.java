package model.base;

import javafx.scene.canvas.GraphicsContext;

public interface Updatable {
	
    public void update();
    public void draw(GraphicsContext gc);
    public boolean isDestroyed();
    
}
