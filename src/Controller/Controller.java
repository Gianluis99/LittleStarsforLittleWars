package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Game;

public class Controller implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Game.getGame().play();
	}

}
