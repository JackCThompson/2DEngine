package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class Miller extends StaticEntity{

	public Miller(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 32;
		this.height = 32;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(11, 22, 10, 10); 
	}

	@Override
	protected void init() {
		ID = 1006;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.miller);
	}

}
