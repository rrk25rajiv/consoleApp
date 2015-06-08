package com.socialnetwork.util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.socialnetwork.domain.Message;

/**
 * utility class represents a console outputs
 * 
 * @author rrk
 */
public class UIUtility {

	// displays initial menu of the app
	public static final String[] displayMainMenuOptions(Scanner input) 
	{
		print("Please follow the following menu commands format to continue...");
		print("[1] posting: <user name> -> <message>");
		print("[2] reading: <user name>");
		print("[3] following: <user name> follows <another user>");
		print("[4] wall: <user name>");
		print("[5] logout: <user name>");
		
		String inputLine = input.nextLine();
		String[] splittedResults = inputLine.split(":");
		return splittedResults;
	}

	public static void print(String value)
	{
		System.out.println(value);
	}

	public static int continueGame(Scanner input) 
	{
		print("Press [1] to continue or [0] to exit");
		boolean prompt = true;
		int value = 0;
		while (prompt) {
			while (value == 0) 
			{
				if (value == 0)
				{
					return value;
				}
				if (value == 1) 
				{
					return value;
				}

				prompt = false;
			}
		}
		return value;
	}

	public static void displayUserWall(String userName, List<Message> userWall) 
	{
		print(userName + " Wall:");
		for (Message message : userWall) 
		{
			print("->"+ message.getPostedBy());
			String time = durationHMSm(message.getDate().getTime() - new Date().getTime());
			print(message.getMessage()+ " ( "+ time+ " ) ");
		}
		print("");
	}

	public static String[] promptLoggingOptions(Scanner input) 
	{
		print("Please Login or Register using the following command formats...");
		print("Login: <user name>");
		print("Register: <user name>");
		
		String inputLine = input.nextLine();
		String[] splittedResult = inputLine.split(":");
		splittedResult[1]= getFormattedUserName(splittedResult[1]);
		
		return splittedResult;
	}
	public static String getFormattedUserName(String unFormattedUserName) {
		String formattedName = unFormattedUserName.substring(
				unFormattedUserName.indexOf("<") + 1,
				unFormattedUserName.indexOf(">"));
		return formattedName;
	}
	public static String getFormattedMessage(String unFormattedMessage) {
		String formattedMessage = unFormattedMessage.substring(
				unFormattedMessage.indexOf("<") + 1,
				unFormattedMessage.indexOf(">"));
		return formattedMessage;
	}
	public static void errorMsg(String string) 
	{
		print(string);
	}
	
	public static String durationHMSm( long i )  
    {  
        int     day = (int)( i / (1000L * 60 * 60 * 24) );  
        i %= 1000L * 60 * 60 * 24;  
        int     hrs = (int)( i / (1000L * 60 * 60) );  
        i %= 1000L * 60 * 60;  
        int     min = (int)( i / (1000L * 60) );  
        i %= 1000L * 60;  
        int     sec = (int)( i / 1000L );  

        if( day > 0 )  
        return String.format( "%dd:%02d days:hours", day, hrs);  
        if(hrs>0){
        return String.format( "%02d:%02d hours:minutes", hrs, min);  
        }
        if(min>0){
        return String.format( "%02d minutes",min);  
        }
        return String.format( "%02d seconds",sec);
    }
}
