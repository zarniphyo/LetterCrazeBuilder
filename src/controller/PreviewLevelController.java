package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundary.Application;
import boundary.PreviewWindowPanel;
import model.Model;

public class PreviewLevelController extends MouseAdapter{
	Application app;
	Model model;

	public PreviewLevelController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		PreviewWindowPanel pwp = new PreviewWindowPanel(this.app, this.model);
		
		app.modifyFrameSize(100, 100, 750, 575);
		this.app.switchPanel(pwp);
		
	}
}
