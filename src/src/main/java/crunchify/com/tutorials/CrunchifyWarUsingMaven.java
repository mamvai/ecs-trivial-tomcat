package crunchify.com.tutorials;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

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
		String yourCliCommandWithArgs = "export NO_PROXY=169.254.169.254,169.254.170.2 ; curl http://169.254.169.254/latest/meta-data/local-ipv4";
		
		ProcessBuilder pb = new ProcessBuilder ("sh", "-c", "curl http://169.254.169.254/latest/meta-data/local-ipv4");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		
		pb = new ProcessBuilder ("sh", "-c", "whoami ; pwd ; cd /usr/local/tomcat ; ls -lrt ");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		
		pb = new ProcessBuilder ("sh", "-c", "yum install net-tools -y ; /sbin/ifconfig");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		
		//pb = new ProcessBuilder ("sh", "-c", "curl http://localhost:51678/v1/metadata");
		pb = new ProcessBuilder ("sh", "-c", "curl 169.254.170.2/v2/metadata");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
		    NetworkInterface n = (NetworkInterface) e.nextElement();
		    Enumeration ee = n.getInetAddresses();
		    while (ee.hasMoreElements())
		    {
		        InetAddress i = (InetAddress) ee.nextElement();
		        System.out.println(i.getHostAddress());
		        out.print(i.getHostAddress());
		    }
		}
		
		//pb = new ProcessBuilder ("sh", "-c", "curl http://172.17.0.1:51678/v1/metadata");
		//runCLICmd(yourCliCommandWithArgs,out,pb);
		
		pb = new ProcessBuilder ("sh", "-c", "yum install python-setuptools -y ; pip install awscli --upgrade --user ; aws --version ");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		
		//pb = new ProcessBuilder ("sh", "-c", "curl https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip  ; unzip awscliv2.zip ; sudo ./aws/install ;aws --version ");
		// runCLICmd(yourCliCommandWithArgs,out,pb);
		
	}
	private void runCLICmd(String yourCliCommandWithArgs, ServletOutputStream out, ProcessBuilder pb) {
	//	ProcessBuilder pb = new ProcessBuilder ("sh", "-c","curl http://169.254.169.254/latest/meta-data/local-ipv4");
	//	ProcessBuilder pb = new ProcessBuilder ("sh", "-c","aws", "ecs", "list-container-instances");
	// 	ProcessBuilder pb = new ProcessBuilder ("sh", "-c", "whoami");
		Process process = null;
		try {
			out.println("step 1\n");
			process = pb.start();
			out.println("step 2\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = process.getInputStream();
		int i;
		try {
			while (-1 != (i = in.read())){
			    System.out.write(i);
				out.print(i);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InputStream err = process.getErrorStream();
		int k;
		try {
			while (-1 != (k = err.read())){
			    System.out.write(k);
			    out.print(k);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
