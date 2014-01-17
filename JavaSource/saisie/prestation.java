package saisie;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.model.SelectItem;

public class prestation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPrestation;
	private String nomPresta;
	private Date datePrix;
	private int idPrix;
	private int idCatPresta;
	private String nomCatPresta;
	private int prix;
	private List<SelectItem> listCatPresta;
	private List<prestation> listPresta;
	private List<SelectItem> listPrix;
	private String message;
	public prestation selected;
	private List<prestation> listPrestaCat;//liste des categories des prestations
	private List<prestation> listPrestaCateg;//liste des prestation par categorie
	private boolean error=false;
	
	
	
	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}


	public prestation() {
		// TODO Auto-generated constructor stub
	}

	
	public int getIdPrestation() {
		return idPrestation;
	}
	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}


	public String getNomPresta() {
		return nomPresta;
	}
	public void setNomPresta(String nomPresta) {
		this.nomPresta = nomPresta;
	}


	public Date getDatePrix() {
		return datePrix;
	}
	public void setDatePrix(Date datePrix) {
		this.datePrix = datePrix;
	}


	public int getIdPrix() {
		return idPrix;
	}
	public void setIdPrix(int idPrix) {
		this.idPrix = idPrix;
	}


	public int getIdCatPresta() {
		return idCatPresta;
	}
	public void setIdCatPresta(int idCatPresta) {
		this.idCatPresta = idCatPresta;
	}


	public String getNomCatPresta() {
		return nomCatPresta;
	}
	public void setNomCatPresta(String nomCatPresta) {
		this.nomCatPresta = nomCatPresta;
	}

	

	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<SelectItem> getListCatPresta() {
		this.listCatPresta=new ArrayList<SelectItem>();
		mysql c=new mysql();
		
		String req="SELECT * FROM categoriepresta WHERE nomCatPresta!='CONSULTATION'";
		ResultSet res=c.selectbd(req);
			try {
				while(res.next()){
			prestation p=new prestation();
			p.idCatPresta=res.getInt("idCatPresta");
			p.nomCatPresta=res.getString("nomCatPresta");
			
			//System.out.println(p.idCatPresta+" "+p.nomCatPresta);
			this.listCatPresta.add(new SelectItem(p.idCatPresta, p.nomCatPresta));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listCatPresta;
	}
	public void setListCatPresta(List<SelectItem> listCatPresta) {
		this.listCatPresta = listCatPresta;
	}
	
	
	public List<prestation> getListPresta() {
		this.listPresta=new ArrayList<prestation>();
		mysql c=new mysql();
		
		String req=" SELECT * FROM prestation p " +
				   " JOIN prix px ON px.idPrix = p.idPrix " +
				   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta " +
				   " WHERE nomCatPresta!='CONSULTATION' GROUP BY p.nomPresta " +
				   " ORDER BY p.idPrestation DESC";
				   
		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				prestation p=new prestation();
				p.idPrestation=res.getInt("idPrestation");
				p.nomPresta=res.getString("nomPresta");
				p.nomCatPresta=res.getString("nomCatPresta");
				p.prix=res.getInt("prix");
				p.idPrix=res.getInt("idPrix");
				p.idCatPresta=res.getInt("idCatPresta");
				
			System.out.println(p.idPrestation+" "+p.nomPresta+" "+p.nomCatPresta+" "+p.prix);
				this.listPresta.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPresta;
	}
	public void setListPresta(List<prestation> listPresta) {
		this.listPresta = listPresta;
	}

	
	public List<SelectItem> getListPrix() {
		this.listPrix=new ArrayList<SelectItem>();
		String req="SELECT * FROM prix";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		try {
			while(res.next()){
				prestation p=new prestation();
				p.idPrix=res.getInt("idPrix");
				p.prix=res.getInt("prix");
				
				this.listPrix.add(new SelectItem(p.idPrix, ""+p.prix));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPrix;
	}
	public void setListPrix(List<SelectItem> listPrix) {
		this.listPrix = listPrix;
	}
	
public String traitementDate(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
				
	}

public String traitementDateTime(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return form.format(data);
				
	}

	public void ajoutPrestation(){
		//Avant d'inserer une prestation, on verifie si la prestation n'existe pas déjà
		mysql c=new mysql();
		String getPrest="SELECT COUNT(*) AS nbre FROM prestation WHERE nomPresta='"+this.nomPresta.toUpperCase().trim()+"'";
			ResultSet res=c.selectbd(getPrest);
				try {
					if(res.next()){
						if(res.getInt("nbre")>0){
							this.error=true;
							this.message="Cette prestation existe déjà";
						}else{
							int i=-1;
							String req="INSERT INTO prestation(nomPresta, idCatPresta, idPrix, datePrix) " +
										" VALUES('"+this.nomPresta.toUpperCase().trim()+"', '"+this.idCatPresta+"', '"+this.idPrix+"', '"+this.traitementDateTime(new Date())+"')";
							
							
							if(this.nomPresta==""){
								this.error=true;
								this.message="Veuillez saisir la prestation";
							}else{
							i=c.updatebd(req);
							if(i!=-1){
								this.message="Prestation "+this.nomPresta.toUpperCase()+" enregistrée";
								this.initialise();
							}else{
								this.message="Echec d'enregistrement";
							}
						}
					}
				} 
		
	     }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public prestation getSelected() {
		return selected;
	}
	public void setSelected(prestation selected) {
		this.selected = selected;
	}


	public void initialise(){
		this.nomPresta="";
		
	}
	public void modifPrestation(){
		System.out.println(this.selected.idPrestation);
		//this.idPrestation=this.selected.idPrestation;
		this.nomPresta=this.selected.nomPresta;
		this.idCatPresta=this.selected.idCatPresta;
		this.idPrix=this.selected.idPrix;
		this.idPrestation=this.selected.idPrestation;
		String reqModifPresta="UPDATE prestation SET nomPresta='"+this.nomPresta+"', idCatPresta='"+this.idCatPresta+"'," +
							  " idPrix='"+this.idPrix+"', datePrix='"+this.traitementDateTime(new Date())+"'" +
							  " WHERE idPrestation="+this.idPrestation+"";
		System.out.println(reqModifPresta);
		mysql c=new mysql();
		int i=-1;
				if(this.nomPresta==""){
					this.message="Veuillez saisir la prestation";
				}else{
					i=c.updatebd(reqModifPresta);
					
					if(i!=-1){
						this.message="Modification effectuée";
						this.error=true;
						this.nomPresta="";
						
					}else{
						this.message="Echec de modification";
						this.error=true;
						this.nomPresta="";
					}
				}
			
			
		System.out.println(reqModifPresta);
		//this.message=reqModifPresta;
		
	}
	
	public void ajoutPrix(){
		
		String req="INSERT INTO prix(prix) VALUES('"+this.prix+"')";
		int i=-1;
		mysql c=new mysql();
		String getPrix="SELECT COUNT(*) AS nombre FROM prix WHERE prix='"+this.prix+"'";
		ResultSet res=c.selectbd(getPrix);
		try {
			if(res.next()){
					if(res.getInt("nombre")>0){
						this.message="Ce prix existe déjà";
					}else{
						 i=c.updatebd(req);
						 if(i!=-1){
							 this.message="Le prix de "+this.prix+" est ajouté";
						 }
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public List<prestation> getListPrestaCat() {
		this.listPrestaCat=new ArrayList<prestation>();
		String reqPrestaCat="SELECT * FROM categoriepresta";
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqPrestaCat);
			try {
				while(res.next()){
					prestation p=new prestation();
				
					p.idCatPresta=res.getInt("idCatPresta");
					p.nomCatPresta=res.getString("nomCatPresta");
				//System.out.println("Categ presta:"+p.idCatPresta+" "+p.nomCatPresta);	
					this.listPrestaCat.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listPrestaCat;
	}
	public void setListPrestaCat(List<prestation> listPrestaCat) {
		this.listPrestaCat = listPrestaCat;
	}
	
	public prestation getSelectedCatPresta(){
		this.idPrestation=this.selected.idPrestation;
		this.idCatPresta=this.selected.idCatPresta;
		this.nomCatPresta=this.selected.nomCatPresta;
		return this;
	}


	public List<prestation> getListPrestaCateg() {
		this.listPrestaCateg=new ArrayList<prestation>();
		String req=" SELECT * FROM prestation p" +
				   " JOIN prix px ON px.idPrix = p.idPrix " +
				   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta " +
				   " WHERE p.idCatPresta ='"+this.idCatPresta+"' " +
				   " GROUP BY p.nomPresta ORDER BY p.idPrestation DESC";
//		String req="SELECT * FROM prestation p" +
//				   " JOIN prix px ON px.idPrix = p.idPrix " +
//				   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta " +
//				   " WHERE p.idCatPresta =2 " +
//				   " GROUP BY p.nomPresta ORDER BY p.idPrestation DESC";
		//this.selected.idCatPresta=2;
		//prestation p1=this.selected;
		//System.out.println("Selected cat:"+this.selected.idCatPresta);
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
			try {
				while(res.next()){
					prestation p=new prestation();
					p.idPrestation=res.getInt("idPrestation");
					p.nomPresta=res.getString("nomPresta");
					p.idPrix=res.getInt("idPrix");
					p.prix=res.getInt("prix");
					p.idCatPresta=res.getInt("idCatPresta");
					p.nomCatPresta=res.getString("nomCatPresta");
					
					this.listPrestaCateg.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listPrestaCateg;
	}


	public void setListPrestaCateg(List<prestation> listPrestaCateg) {
		this.listPrestaCateg = listPrestaCateg;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prestation p=new prestation();
		//p.getListCatPresta();
		//p.getListPresta();
		p.getListPrestaCat();

	}

}
