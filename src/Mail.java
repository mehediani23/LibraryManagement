

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;  
import java.util.Hashtable;  
   
import javax.naming.*;  
import javax.naming.directory.*;



import java.io.*;
import java.net.*;


public class Mail {
         public static boolean isAddressValid( String address )
     {
    	// Find the separator for the domain name
         int pos = address.indexOf( '@' );

         // If the address does not contain an '@', it's not valid
         if ( pos == -1 ) return false;

         // Isolate the domain/machine name and get a list of mail exchangers
         String domain = address.substring( ++pos );
         System.out.println("Name of the Domain:"+domain);
         ArrayList mxList = null;
         try {
            mxList = getMX( domain );
         } 
         catch (NamingException ex) {
            return false;
         }
         System.out.println(mxList.size());
         
         if ( mxList.size() == 0 )
         {
        	 return false;
         }
         //System.out.println("HI");
         for ( int mx = 0 ; mx < mxList.size() ; mx++ ) {
             boolean valid = false;
             try {
            	 //System.out.println("HI");
                 int res;
                 
                 Socket skt = new Socket( (String) mxList.get( mx ), 25 );
                 //System.out.println("HI");
                 BufferedReader rdr = new BufferedReader
                    ( new InputStreamReader( skt.getInputStream() ) );
                 BufferedWriter wtr = new BufferedWriter
                    ( new OutputStreamWriter( skt.getOutputStream() ) );

                 res = hear( rdr );
                
                 if ( res != 220 ) throw new Exception( "Invalid header" );
                 say( wtr, "EHLO hotmail.com" );

                 res = hear( rdr );
                 if ( res != 250 ) throw new Exception( "Not ESMTP" );

                 // validate the sender address  
                 say( wtr, "MAIL FROM: <libraryappskuet@gmail.com>" );
                 res = hear( rdr ); 
                 System.out.println("respose id:"+res);
                 if(res==550)
                 {
                	 valid=true;
                 }
                 else if ( res != 250 ) throw new Exception( "Sender rejected" );

                 say( wtr, "RCPT TO: <" + address + ">" );
                 res = hear( rdr );

                 // be polite
                 say( wtr, "RSET" ); 
                 hear( rdr );
                 say( wtr, "QUIT" );
                 hear( rdr );
                 
                 if ( res != 250 ) 
                    throw new Exception( "Address is not valid!" );

                 valid = true;
                 rdr.close();
                 wtr.close();
                 skt.close();
             } 
             catch (Exception ex) {
               System.out.println(ex.toString());
             } 
             finally {
               if ( valid ) return true;
             }
         }
         return false;
	}

	private static int hear(BufferedReader in) throws IOException {
		String line = null;
	      int res = 0;

	      while ( (line = in.readLine()) != null ) {
	          String pfx = line.substring( 0, 3 );
	          System.out.println(pfx);
	          try {
	             res = Integer.parseInt( pfx );
	          } 
	          catch (Exception ex) {
	             res = -1;
	          }
	          if ( line.charAt( 3 ) != '-' ) break;
	      }

	      return res;
	}
	private static void say( BufferedWriter wr, String text ) throws IOException {
		      wr.write( text + "\r\n" );
		      wr.flush();

		      return;
		      }
	  public  String call_this_to_validate( String email ) {
	        String testData[] = {email};

	        String return_string="";
	        
	        for ( int ctr = 0 ; ctr < testData.length ; ctr++ ) {
	        	return_string=( testData[ ctr ] + " is valid? " + 
	                 isAddressValid( testData[ ctr ] ) );
	        }
	        return return_string;
	        }
	  
	public static ArrayList getMX( String hostName ) throws NamingException  
    {  
        // Perform a DNS lookup for NS records in the domain  
        Hashtable env = new Hashtable();  
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");  
        DirContext ictx = new InitialDirContext(env);  
        Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });  
        Attribute attr = attrs.get("MX"); 
        System.out.println(attr);
   
        ArrayList res = new ArrayList();  
        NamingEnumeration en = attr.getAll();  
   
        while (en.hasMore())  
        {  
            String x = (String) en.next();
            String f[] = x.split( " " );
            //System.out.println(f[1]);
            if ( f[1].endsWith( "." ) ) 
                f[1] = f[1].substring( 0, (f[1].length() - 1));
            res.add( f[1] );  
        }  
        return res;  
    }  
}  

