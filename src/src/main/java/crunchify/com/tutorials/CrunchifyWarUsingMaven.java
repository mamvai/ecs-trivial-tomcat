package main.java.crunchify.com.tutorials;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crunchify")
public class CrunchifyWarUsingMaven extends HttpServlet{

	public static void main(String[] args) {
		System.out
				.println("Test.. Test by Crunchify.. \nThis is a simple tutorial  using Maven Plugin..");
	}
}
