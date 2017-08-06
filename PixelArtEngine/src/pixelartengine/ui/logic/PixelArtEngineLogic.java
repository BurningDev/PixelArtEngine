package pixelartengine.ui.logic;

import pixelartengine.core.Game;
import pixelartengine.misc.Status;
import pixelartengine.ui.dialog.AboutDialog;
import pixelartengine.ui.dialog.AddObjectDialog;
import pixelartengine.ui.dialog.NewGameDialog;

/**
 * 
 * @author TheBattlepower
 *
 */
public class PixelArtEngineLogic {
	public void openNewGameDialog() {
		NewGameDialog newGameDialog = new NewGameDialog();
		newGameDialog.openDialog();
		
		if(newGameDialog.getStatus() == Status.OK) {
			Game game = new Game();
			game.setTitle(newGameDialog.getTitleProject());
			game.setLocation(newGameDialog.getLocationProject());
		}
	}
	
	public void openAboutDialog() {
		AboutDialog aboutDialog = new AboutDialog();
		aboutDialog.openDialog();
	}
	
	public void openAddObjectDialog() {
		AddObjectDialog addObjectDialog = new AddObjectDialog();
		addObjectDialog.openDialog();
	}
	
	public void exit()  {
		System.exit(0);
	}
}