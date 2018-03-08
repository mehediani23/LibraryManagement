import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
class JavaMail{  
    public String Username;
    public String Mail;
    public String Password;
    public String Dept;
    public int    roll;
    public String phn_no;
    public JavaMail(String Username,String Mail,String Password)
    {
        this.Username=Username;
        this.Mail=Mail;
        this.Password=Password;
    }
    public JavaMail(String Username,String Mail,String Password,String Dept,int roll,String Phn_no)
    {
        this.Username=Username;
        this.Mail=Mail;
        this.Password=Password;
        this.roll=roll;
        this.Dept=Dept;
        this.phn_no=phn_no;
    }
    public void ForgotPassword()
    {
        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("libraryappskuet@gmail.com","kuetlibrary");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(Mail));    
           message.setSubject("Your Account Info.");    
           message.setText("Your Account Info:\nUserName:'"+Username+"'\nEmail:'"+Mail+"'\nPassword:'"+Password+"'");    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e)
          {
              throw new RuntimeException(e);
          }    
             
    }  
        
    
    public  void SignUp(){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("libraryappskuet@gmail.com","kuetlibrary");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(Mail));    
           message.setSubject("New Account Created At KUET LIbrary.");    
           message.setText("Your Account Info:\nUserName:'"+Username+"'\nPassword:'"+Password+"'");    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  

