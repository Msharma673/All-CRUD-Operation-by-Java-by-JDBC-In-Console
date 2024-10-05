package com.demo.CrudOperation;

public class QueryClassConstant {
	
	//Insert
	
	public static String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";
	
	//delete 
	public static	 String deleteByIdQuery = "DELETE FROM faculty WHERE id = ?";
	public static  String deleteByNameQuery = "DELETE FROM faculty WHERE fac_name = ?";
	public static String fetchDetailsByIdQuery = "SELECT * FROM faculty WHERE id = ?";
	public static String fetchDetailsByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
     
     
//select
	public static String selectAllQuery = "SELECT * FROM faculty";
	public static String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
	public static String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
     
     // Update
//     String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
//     String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
	public static String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ? OR fac_name = ?";
     

}
