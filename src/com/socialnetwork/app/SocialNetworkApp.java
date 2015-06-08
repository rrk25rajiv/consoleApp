package com.socialnetwork.app;

import java.util.Scanner;

import com.socialnetwork.context.ConsoleAppContext;
import com.socialnetwork.service.ActionService;
import com.socialnetwork.service.ActionServiceImpl;
import com.socialnetwork.util.UIUtility;

/**
 * @author rrk
 */
public class SocialNetworkApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SocialNetworkApp snApp = new SocialNetworkApp();
		snApp.start();
	}

	private void start() 
	{
		// Create reader representing user inputs.
		Scanner scanUserInput = new Scanner(System.in);

		// Initialize application context
		ConsoleAppContext context = ConsoleAppContext.getConsoleAppContext();

		// service providing managing actions
		ActionService service = new ActionServiceImpl();

		// default users
		service.registerUser("Alice");
		service.registerUser("Bob");
		service.registerUser("Charlie");

		String userName=null;
		String loggingOption=null;
		String[] splittedResults;
		String targetUserName=null;

		while (true) 
		{
			if (context.getLoggedUser() == null) 
			{
				// Prompt logging options: log or register
				boolean login = true;
				while (login) 
				{
					splittedResults = UIUtility.promptLoggingOptions(scanUserInput);
					loggingOption = splittedResults[0];
					userName = splittedResults[1];

					// logging
					if (loggingOption.equals("Login")) 
					{
						service.logUser(userName);
						login = false;
						UIUtility.print("Welcome "+userName+"!");
					}
					// register
					else if (loggingOption.equals("Register")) 
					{
						service.registerUser(userName);
						UIUtility.print("Welcome "+userName+"!"+" Thank you for registering with us...");
					}
				}
			}
	
			//Now display the menus and proceed with the our social network app
			splittedResults = UIUtility.displayMainMenuOptions(scanUserInput);
			String menuOption =splittedResults[0];

			if(!menuOption.equals("logout"))
			{
				// process posting request
				if (menuOption.equals("posting")) 
				{
					splittedResults = splittedResults[1].split("->");
					targetUserName = UIUtility.getFormattedUserName(splittedResults[0]);
					String message = UIUtility.getFormattedMessage(splittedResults[1]);
					service.post(context.getLoggedUser().getName(),targetUserName,message);
				}
	
				// process reading request
				else if (menuOption.equals("reading")) 
				{
					targetUserName = UIUtility.getFormattedUserName(splittedResults[1]);
					UIUtility.displayUserWall(targetUserName,service.getUserWall(targetUserName));
				}
	
				// process following request
				else if (menuOption.equals("following")) 
				{
					splittedResults = splittedResults[1].split("follows");
					String sourceUserName = UIUtility.getFormattedUserName(splittedResults[0]);
					targetUserName = UIUtility.getFormattedUserName(splittedResults[1]);
					service.setFollow(sourceUserName, targetUserName);
				}
				
				// process reading request over the personal wall
				else if (menuOption.equals("wall")) 
				{
					targetUserName = UIUtility.getFormattedUserName(splittedResults[1]);
					UIUtility.displayUserWall(targetUserName,service.getUserPersonalWall(targetUserName));
				}
	
			}
			else
			{
				context.setLoggedUser(null);
				UIUtility.print(userName+"-you have successfully logout!");
			}
		}
	}
}
