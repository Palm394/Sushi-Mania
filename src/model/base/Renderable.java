package model.base;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	
    public void update();
    public void draw(GraphicsContext gc);
    public boolean isDestroyed();
    
}
