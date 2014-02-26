package br.edu.ifpb.pos.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main{
	
	public static void main(String[] args) throws Exception {
	  //server
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 9191);
		component.getDefaultHost().attach("/xml/upload", ImageResource.class);
		component.start();
		//gui
		View v = new View();
		ViewSubject.setObserver(v);
		v.setSize(600, 480);
		v.setVisible(true);
	}

}
