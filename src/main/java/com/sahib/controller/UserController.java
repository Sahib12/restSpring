package com.sahib.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahib.returnFormat.RequestFormat;
import com.sahib.returnFormat.ReturnFormat;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public ReturnFormat[] getUsers() {
		
		try
        { 
			ArrayList<ReturnFormat> arr = new ArrayList<ReturnFormat>();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sahib_database?" +
				                                   "user=root&password=sahib4sahib");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()) {
				arr.add(new ReturnFormat(rs.getString("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password")));
				System.out.println(rs.getString("firstname"));
			}
			ReturnFormat[] toReturnArray = new ReturnFormat[arr.size()];
			
			for(int i = 0; i < toReturnArray.length; i++) {
				toReturnArray[i] = arr.get(i);
			}
			
			System.out.println(Arrays.toString(toReturnArray));
			conn.close();
			return toReturnArray;
        } 
        catch(Exception e) 
        { 
        	System.out.println(e);
            return null;
        } 
		
	}
	
	@PostMapping
	public String postUsers(@RequestBody RequestFormat req) {
		System.out.println(req);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sahib_database?" +
	                "user=root&password=sahib4sahib");
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into users values('" + req.id + "','" + req.firstname
					+ "','" + req.lastname + "','" + req.email + "','" + req.password + "');");
			return "Inserted data successfully";
			
		}
		catch(Exception e) {
			return e.toString();
		}
		
	}
	
	@PutMapping
	public String updateUsers(@RequestBody RequestFormat req) {
		System.out.println(req);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sahib_database?" +
	                "user=root&password=sahib4sahib");
			
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("update users set firstname = '" + req.firstname + "'," +
			"lastname = " + "'" + req.lastname + "' where email = '" + req.email +
			"' and password = '" + req.password + "';");
			
			return "Data Updated successfully";
			
		}
		catch(Exception e) {
			return e.toString();
		}
		
	}
	
	
	@DeleteMapping
	public String deleteUsers(@RequestBody RequestFormat req) {
		System.out.println(req);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sahib_database?" +
	                "user=root&password=sahib4sahib");
			
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("delete from users where id = " + req.id);
			
			return "Data Deleted successfully";
			
		}
		catch(Exception e) {
			return e.toString();
		}
		
	}
	
	
	
	
}
