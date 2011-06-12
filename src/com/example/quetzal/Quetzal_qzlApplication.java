package com.example.quetzal;

import java.util.Date;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.vaadin.Application;
import com.vaadin.ui.*;

public class Quetzal_qzlApplication extends Application {
	@Override
	public void init() {
		
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String content = "content";
        Date date = new Date();
		Greeting greeting = new Greeting(user, content, date);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(greeting);
        } finally {
            pm.close();
        }
		
		Window mainWindow = new Window("Quetzal_qzl Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
