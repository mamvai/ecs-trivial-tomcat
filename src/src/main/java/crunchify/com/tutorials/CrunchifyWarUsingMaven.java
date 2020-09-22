package main.java.crunchify.com.tutorials;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crunchify")
public class CrunchifyWarUsingMaven extends HttpServlet{

	
	@Override 
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws IOException,ServletException{
	    this.doPost(request,response);
	}
	@Override 
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
	                                   throws IOException,ServletException{
		System.out.println("Test.. Test by Crunchify.. \nThis is a simple tutorial  using Maven Plugin..");
		
	}
	public static void main(String[] args) {
		System.out
				.println("Test.. Test by Crunchify.. \nThis is a simple tutorial  using Maven Plugin..");
	}
}
