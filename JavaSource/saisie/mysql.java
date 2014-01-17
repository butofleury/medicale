package saisie;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql {
	private Connection con;
    private String state;
    
	public mysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicale","root","");
			
			this.state="successfully";
		} catch (InstantiationException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			this.state="unsuccessfully";
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} catch (SQLException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} 
	}
	public mysql(String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			 con=DriverManager.getConnection(url,"root","");
			this.state="successfully";
		} catch (InstantiationException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		} catch (SQLException e) {
			this.state="unsuccessfully";
			
			e.printStackTrace();
		}

}
	//selection
	public ResultSet selectbd(String requete){
		ResultSet res=null;
		if(con!=null){
			try {
				res=con.createStatement().executeQuery(requete);
				this.state="successfully";
			} catch (SQLException e) {
				this.state="unsuccessfully";
				
				e.printStackTrace();
			}
		}
		return res;
	}
	//insertion,suppression,ajout
	public int updatebd(String requete){
		int val=-1;
		if(con!=null){
			try {
				val=con.createStatement().executeUpdate(requete);
				this.state="successfully";
			} catch (SQLException e) {
				this.state="unsuccessfully";
				
				e.printStackTrace();
			}
		}
		return val;
	}
	public String getState() {
		return state;
	}
	public void closebd(){
		if(con!=null){
			try {
				con.close();
				this.state="successfully";
			} catch (SQLException e) {
				this.state="unsuccessfully";
				
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				

		
		mysql c1=new mysql();
		System.out.println(c1.state);
	}
}
