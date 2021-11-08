package com.stock.controller;

import java.io.IOException;
import java.net.URI;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.stock.entity.UserEntity;
import com.stock.repo.userrepo;
import com.stock.service.IuserService;

 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@Transactional
public class UserController {
	
	@Autowired
	IuserService service;
	
	@Autowired 
	userrepo repo;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerUser( @RequestBody UserEntity user){
		service.registeruser(user);
		return new ResponseEntity<>("Registered user", HttpStatus.OK);	
	}
	
	@GetMapping(value="/login/{username}/{password}")
	public ResponseEntity<String> login(@PathVariable String username , @PathVariable String password)
	{
		
		if(service.loginuser(username, password)!=null)
		return new ResponseEntity<>("Logged in" ,HttpStatus.OK);
		return new ResponseEntity<>( "Not confirmed",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/delete")
	public String deleteByStock(@RequestBody UserEntity user) {
		 service.deleteUser(user);
		 return "deleted";
}
	
	@PutMapping(value="/updatepwd/{username}/{oldpwd}/{newpwd}")
	public String updatepwd(@PathVariable String username, @PathVariable String oldpwd, @PathVariable String newpwd)
	{
		service.updatePassword(username, oldpwd, newpwd);
		return "Updated";
	}
	
	
	
	//**************************************************************************************************************
	//@RequestMapping(value = "/setuserapi",method=RequestMethod.GET)
	 @GetMapping(value="/getuser")
	 public String Stringreactuserapi(@RequestParam Map<String, String> userobj) throws AddressException, MessagingException {
	        UserEntity usr = new UserEntity();
	        
	        usr.setUsername(userobj.get("name")+"from api1");
	        usr.setPassword(userobj.get("password"));
	        usr.setEmail(userobj.get("email"));

	        repo.save(usr);
	        HttpHeaders headers = new HttpHeaders(null);
	        headers.add("Responded", "UserController");
	        headers.add("Access-Control-Allow-Origin", "*");
	        sendemail(usr.getId()) ;
	        return userobj.toString();
	        }

	 


	    @CrossOrigin(origins ="http://localhost:4200")
	    @RequestMapping(value = "/setuserapi2",method=RequestMethod.POST, headers="Accept=application/json")
	   // @PostMapping(value="/setuserapi2")
	    public ResponseEntity<Object> reactuserapi2(@RequestBody UserEntity user) throws AddressException, MessagingException, ClassNotFoundException, IOException {

	        UserEntity usrsaved = repo.save(user);
	        // make sure your entity class properties of user are in lower case and match the json,to avoid errors
	        System.out.println(user +"check this " +usrsaved.getUsername());
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usrsaved.getId()).toUri();
	        sendemail(usrsaved.getId()) ;
	        return ResponseEntity.created(location).build();
	        }

	

	    @RequestMapping(value = "/settestuser",method=RequestMethod.POST)
	    public ResponseEntity<UserEntity> getUser(@RequestBody UserEntity usr) throws AddressException, MessagingException {

	    	repo.save(usr);
	        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	        headers.add("Responded", "UserController");
	        sendemail(usr.getId()) ;
	        return ResponseEntity.accepted().headers(headers).body(usr);
	        }

	 

	    public void sendemail(Long userid) throws AddressException, MessagingException {

	        final String username = "meghab476@gmail.com";
	        final String password = "9844291687";

	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS

	 


	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                return new javax.mail.PasswordAuthentication(username, password);
	                }
	            });


	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("meghab476@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("meghab476@gmail.com")
	                    );
	            message.setSubject("User confirmation email");
	            //     message.setText("Dear Mail Crawler,"
	            //           + "\n\n Please do not spam my email!");
	            message.setContent(
	                    "<h1><a href =\"http://127.0.0.1:8032/confirmuser/"+userid+"/\"> Click to confirm </a></h1>",
	                    "text/html");
	            Transport.send(message);
	            
	            Optional<UserEntity> userlist = repo.findById(userid);
		        //do a null check for home work
		        UserEntity usr = new UserEntity();
		        usr = repo.getById(userid);
		        usr.setConfirmed(true);
		        repo.save(usr);
		        
		        
	            System.out.println("Done");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }


	    @RequestMapping(value="/confirmuser/{userid}", method=RequestMethod.GET)
	    public String welcomepage(@PathVariable Long userid) {
	        Optional<UserEntity> userlist = repo.findById(userid);
	        //do a null check for home work
	        UserEntity usr = new UserEntity();
	        usr = repo.getById(userid);
	        usr.setConfirmed(true);
	        usr.setUserType("user");
	        repo.save(usr);
	        return "User confirmed" +usr.getUsername();
	        }

	 
	

}
