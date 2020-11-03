package crunchify.com.tutorials;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crunchifymaven")
public class CrunchifyWarUsingMaven extends HttpServlet{

	
	@Override 
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws IOException,ServletException{
	    this.doPost(request,response);
	}
	@Override 
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
	                                   throws IOException,ServletException{
		ServletOutputStream out=response.getOutputStream();
		out.print("Hello from Crunchify servlet !!!");
		System.out.println("Test.. Test by CrunchifyMaven.. \nThis is a simple tutorial  using Maven Plugin..");
		
		//runCLICmd("aws ecs list-container-instances",out);
		String yourCliCommandWithArgs = "curl http://169.254.169.254/latest/meta-data/local-ipv4";
		runCLICmd(yourCliCommandWithArgs,out);
		
		
		
	}
	private void runCLICmd(String yourCliCommandWithArgs, ServletOutputStream out) {
		// ProcessBuilder pb = new ProcessBuilder ("sh", "-c","curl", "http://169.254.169.254/latest/meta-data/local-ipv4");
		ProcessBuilder pb = new ProcessBuilder ("aws", "ecs", "list-container-instances");
		Process process = null;
		try {
			out.println("step 1\n");
			process = pb.start();
			out.println("step 2\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		
		try {
			out.println("step 3" + br.toString());
			while ((line = br.readLine()) != null) {
				out.println("step 3a line=" + line);
			    out.println(line);
			    
			}
			out.print("step 4" + br.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out
				.println("In Main Test.. Test by CrunchifyMaven.. This is a simple tutorial  using Maven Plugin..");
		
		String yourCliCommandWithArgs = "curl http://169.254.169.254/latest/meta-data/local-ipv4";
				ProcessBuilder pb = new ProcessBuilder( yourCliCommandWithArgs );
				Process process = null;
				try {
					process = pb.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;

        try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
