package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        uiManager.addObjects(new UIImageButton(450, 400, 300, 150, Images.BStart, new ClickListlener() {
            @Override
            //handler.getWidth()/2-64
           // handler.getHeight()/2-32
            
            public void onClick() { //click-on images  and do something code it also changes the images when the cursor is on top 
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart(); //restarts game
                State.setState(handler.getGame().gameState);//Change gameState to get another type of state 
            }
            
        }));
        
        uiManager.addObjects(new UIImageButton(450, 560, 300, 150, Images.BExit, () -> {      
			handler.getMouseManager().setUimanager(null);
			System.exit(0);
		}));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.title,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

    }


}
