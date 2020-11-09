package crunchify.com.tutorials;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import crunchify.com.tutorials.pojo.SessionInfo;
*/
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.StringTokenizer;

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
		System.out.println("Test.. Test by Redis CrunchifyMaven.. \nThis is a simple tutorial  using Maven Plugin..");
		
		// Connecting to Redis server on localhost 
	    // Jedis jedis = new Jedis("192.168.86.47",7001); 
		
		Jedis jedis = new Jedis("epacache-cluster-0001-001.50fbfo.0001.use2.cache.amazonaws.com",6379);
								 
	    
	    out.println("Connection to redis server sucessfully"); 
	    //check whether server is running or not 
	    try {
	    	out.println("Testing if Redis Server is running: " ); 
	    	out.println("Redis Server is running: "+jedis.ping()); 
	    }catch(Exception e ) {
	    	e.printStackTrace();
	    	out.println("error from jedis:" + e.getMessage());
	    }
	    /*
	    

	    SessionInfo info = new SessionInfo();
	    // Sync and Async API
	    try{
	        Config conf = new Config();
	        conf.useSingleServer().setTimeout(3600000);
	        conf.useSingleServer().setRetryInterval(3600000);
	        conf.useSingleServer().setAddress("redis://192.168.86.47:7001");
	        
	        RedissonClient redisson = Redisson.create(conf);
	        RMap<String,Object> map = redisson.getMap("myCache");
	        map.put("key", info);
	        
	       
	        redisson.shutdown();
	        
	        
	        redisson = Redisson.create(conf);
	        RMap<String,Object> getmap = redisson.getMap("myCache");
	        SessionInfo obj = (SessionInfo) getmap.get("key");
	        out.println("\nredis object = " + obj.getSessionID());
	        out.println("redis user object = " + obj.getUserObject().getName());
	        out.println("redis user object = " + obj.getUserObject().getFullName());
	        out.println("redis calendar object = " + obj.getLastAccess().getTime().getTime());
	        
	    }catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    */
		
		 //runCLICmd("aws ecs list-container-instances",out);
		 String yourCliCommandWithArgs = "export NO_PROXY=169.254.169.254,169.254.170.2 ; curl http://169.254.169.254/latest/meta-data/local-ipv4";
		
		ProcessBuilder pb = new ProcessBuilder ("sh", "-c", "export NO_PROXY=169.254.169.254,169.254.170.2 ; curl http://169.254.169.254/latest/meta-data/local-ipv4");
		//working -  runCLICmd(yourCliCommandWithArgs,out,pb);
		
		pb = new ProcessBuilder ("sh", "-c", "whoami ; pwd ; cd /usr/local/tomcat ; ls -lrt ");
		//working  - runCLICmd(yourCliCommandWithArgs,out,pb);
		
		//pb = new ProcessBuilder ("sh", "-c", "yum install net-tools -y ; /sbin/ifconfig");
		//runCLICmd(yourCliCommandWithArgs,out,pb);
		
		//pb = new ProcessBuilder ("sh", "-c", "curl http://localhost:51678/v1/metadata");
		pb = new ProcessBuilder ("sh", "-c", "curl 169.254.170.2/v2/metadata");
		//working - runCLICmd(yourCliCommandWithArgs,out,pb);
		
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
		        if (i.getHostAddress().startsWith("10.")) {
		        	System.out.println("Found 10. address: " + i.getHostAddress() + " : " + i.getHostName() + " : " + i.getLocalHost());
		        }
		    }
		}
		
		//pb = new ProcessBuilder ("sh", "-c", "curl http://172.17.0.1:51678/v1/metadata");
		//runCLICmd(yourCliCommandWithArgs,out,pb);
		/*
		pb = new ProcessBuilder ("sh", "-c", "yum install python-setuptools -y ; easy_install pip; pip install awscli --upgrade --user ; cd / ; find . -name aws -print ; "
				+ "export PATH= ./root/.local/bin:$PATH ; ./root/.local/bin/aws --version ; ls -a ~ ; "
				+ "./root/.local/bin/aws configure set aws_access_key_id ASIARIWBPPCD27BBQQH2 ; ./root/.local/bin/aws configure set aws_secret_access_key BB+PGA7ExQeITIqDB8/rDShVfdT2QHR+YSH8OYaC ; "
				+ "./root/.local/bin/aws configure set default.region us-east-2"
				+ "./root/.local/bin/aws ecs list-container-instances");
				// + "./root/.local/bin/aws ecs describe-tasks --cluster ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj --tasks arn:aws:ecs:us-east-2:087378851975:task/ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj/6677aff562c64881877cc88fd9280334");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		*/
		
		//ecs-cli configure -region us-east-2 -cluster ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj
		//ecs-cli configure profile --access-key ASIARIWBPPCD4WAZPFO7 --secret-key eeaoKHcXk1I41Opf+jIO3y1BdSNv9/1dGGu4kK8X
		//ecs-cli ps --aws-profile default --cluster ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj --desired-status RUNNING | grep Ports
		
		/* working
		 * pb = new ProcessBuilder ("sh", "-c", "curl -Lo /usr/local/bin/ecs-cli https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-linux-amd64-latest ; find . -name ecs-cli -print ; "
				+ "export PATH=$PATH:/usr/local/bin ; echo $PATH ;  chmod +x /usr/local/bin/ecs-cli ; /usr/local/bin/ecs-cli --version ; ecs-cli --version ; "
				+ "ecs-cli configure -region us-east-2 -cluster ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj ;"
				+ "ecs-cli configure profile --access-key ASIARIWBPPCD4WAZPFO7 --secret-key eeaoKHcXk1I41Opf+jIO3y1BdSNv9/1dGGu4kK8X --session-token IQoJb3JpZ2luX2VjEIH//////////wEaCXVzLWVhc3QtMSJIMEYCIQCIiB/c4oT9pzjJiAW6fH3yM8MrpAMX0Tjt2RLYKzb/VwIhAIpw92M9gt5jzhEb6h6ZpWWPrRJIQfEmpWS1eJ2GkynEKqYCCNr//////////wEQABoMMDg3Mzc4ODUxOTc1IgwekXiB0QnmI0mAFdcq+gG27ns2k1Oc24NevXsM2RSYZwSVWilVbonK63GlTBT16p0/XT65yAE1YTCkQpfsp4V56RV56ej8vu2UfY4gnNxGZZBIpx8aVPP+4NbiSaj2P+Lr+KL3ogp0EofTA9lnD2v+2//ONJ5khec3TKu4YRzZ7HqYr4gzJmGVGBV5tWvmLXSzazkcBpAFrisAEl5Jdlr5W43YMobc3xquEIrJHOAWKI4ZVtlEykxCxNF6r9RVTMFhC9KI8OcmS1Vj23+iB5hEnMau7taFbIsoWTQclCO1D1dTXm1M7r/dZ6FeM9h9UNh8T/Gji9aBxTJ8re21MWySq7Az6Z8c17fGMJ6ri/0FOpwBBjkqhS5U9mKwzZfN+Ll+zlsf4YG5ejVqwYV4rjaMnfqsUcE8swLFMThczfs4ba6wfa2PawHBJjvKlI6unJAm6rKpH1dlXQDx0ksZNvERKDasNfCW4ROLIEYr6wRCj7PKzYMYuo0X9XfAwbQRE02xOw3cdCXCuq6k406rDI0uX0RO1gX5Z1QUGQ+PNGOGzWhAlrP/XEBt+jjFalTT; "
				+ "ecs-cli ps ; /usr/local/bin/ecs-cli ps --desired-status RUNNING");
		runCLICmd(yourCliCommandWithArgs,out,pb);
		*/
		//pb = new ProcessBuilder ("sh", "-c", "curl https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip  ; yum install unzip; unzip awscliv2.zip ;  ./aws/install ; export PATH=~/bin:$PATH ; aws --version ");
		//runCLICmd(yourCliCommandWithArgs,out,pb);
		
		//pb = new ProcessBuilder ("sh", "-c" , "./root/.local/bin/aws ecs describe-tasks --cluster ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj --tasks arn:aws:ecs:us-east-2:087378851975:task/ecs-trivial-cluster-ECSCluster-2COG3zXz2iAj/6677aff562c64881877cc88fd9280334");
		//runCLICmd(yourCliCommandWithArgs,out,pb);
		
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
		/*
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
*/		
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
			String publicIP = null; 
			while ((line = br.readLine()) != null) {
				// out.println("\n step 3a line=" + line);
			    out.println(line);
			    StringTokenizer st = new StringTokenizer(line," ");
			    while (st.hasMoreTokens()) {
			    	if ( st.nextToken().equals("RUNNING")) {
			    		publicIP = st.nextToken();
			    		StringTokenizer stip = new StringTokenizer(publicIP,":");
			    		out.println("publicIP with port =" + publicIP);
			    		while(stip.hasMoreTokens()) {
			    			String IP =stip.nextToken();
			    			out.println("PUBLIC IP = " + IP);
			    			break ;
			    		}
			    		break;
			    	}
			    }
			    
			}
			out.println("step 4" + br.toString());
			
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
