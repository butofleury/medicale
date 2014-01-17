package saisie;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomService;
	private int idService;
	private String message;
	private boolean error;
	private service selected;
	private String searchValue;
	private String valueSearch;
	private int idMedecin;
	private String categorie;
	private String nom;
	private String prenom;
	private Date dateAffectMed;
	private Date dateAffectInf;
	private String codePerso;
	private int idInfirmier;
	private String userName;
	private List<service> listDesService;
	private List<service> listMedService;
	private List<service> listInfService;
	private List<service> listMedecin;
	private List<service> listInfirmier;
	
	
   
    
	
	
	
	public String getValueSearch() {
		return valueSearch;
	}



	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}



	public Date getDateAffectInf() {
		return dateAffectInf;
	}



	public void setDateAffectInf(Date dateAffectInf) {
		this.dateAffectInf = dateAffectInf;
	}



	public int getIdInfirmier() {
		return idInfirmier;
	}



	public void setIdInfirmier(int idInfirmier) {
		this.idInfirmier = idInfirmier;
	}



	public String getCodePerso() {
		return codePerso;
	}



	public void setCodePerso(String codePerso) {
		this.codePerso = codePerso;
	}



	public int getIdMedecin() {
		return idMedecin;
	}



	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Date getDateAffectMed() {
		return dateAffectMed;
	}



	public void setDateAffectMed(Date dateAffectMed) {
		this.dateAffectMed = dateAffectMed;
	}

	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}



	public int getIdService() {
		return idService;
	}



	public void setIdService(int idService) {
		this.idService = idService;
	}



public service getSelected() {
		return selected;
	}



	public void setSelected(service selected) {
		this.selected = selected;
	}



public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public boolean isError() {
		return error;
	}



	public void setError(boolean error) {
		this.error = error;
	}



public String getNomService() {
		return nomService;
	}



	public void setNomService(String nomService) {
		this.nomService = nomService;
	}



	public List<service> getListDesService() {
    this.listDesService=new ArrayList<service>();
		
		mysql sql=new mysql();
		
		String requeteService="select distinct nomService,idService from service";
		
		ResultSet res=sql.selectbd(requeteService);
		
		try {
			while(res.next()){
				
				service pa =new service();
				
				pa.nomService=res.getString("nomService");
				pa.idService=res.getInt("idService");
				this.listDesService.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDesService;
	}



	public void setListDesService(List<service> listDesService) {
		this.listDesService = listDesService;
	}

	
public void saisieService(){
		
		int updateValid=-1;
		int validateur=0;
		String reqSelect="SELECT COUNT(nomService) AS nombre FROM service WHERE nomService='"+this.nomService+"'";
		String requeteUpdate="INSERT INTO service(nomService) VALUES('"+this.nomService.toUpperCase()+"')";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(reqSelect);
		
		try {
			if(res.next()){
				
				validateur=res.getInt("nombre");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.nomService.equals("")){
			
			this.message="Le champ service est vide!!";
			this.error=true;
			return;
		}
		else{
			
			if(this.nomService.startsWith("1")||this.nomService.startsWith("2")||this.nomService.startsWith("3")||this.nomService.startsWith("4")||this.nomService.startsWith("5")||this.nomService.startsWith("6")||this.nomService.startsWith("7")||this.nomService.startsWith("8")||this.nomService.startsWith("9")||this.nomService.startsWith("0")){
			
			  
			   this.message="Le nom du service contient des chiffres!!";
			   this.error=true;
			   return;
			}
			else{
				
				if(validateur>0){
					
					   this.message="Ce service existe deja!!";
					   this.error=true;
					   return;
				}
			
				else{
					
					updateValid=sql.updatebd(requeteUpdate);
					
					if(updateValid!=-1){
						
						this.message="Le service "+this.nomService+" est bien enregistré";
						this.error=true;
						return;
					}
					else
					{
						
						this.message="L'enregistrement du service "+this.nomService+" a echoué";
						this.error=true;
						return;
					}
				}
			}
			
			
		}
		
	
		
	}


	public void initialiseValue(){
		
		this.nomService="";
		this.message="";
		this.error=false;
		System.out.println("Service:"+this.nomService);
	}
	
	
	public void modifierService(){
		
		this.idService=this.selected.idService;
		this.nomService=this.selected.nomService;
		
		int updateValid=-1;
		int validateur=0;
		String requeteUpdate="update service set nomService='"+this.nomService.toUpperCase()+"' where idService='"+this.idService+"'";
		String reqSelect="SELECT COUNT(nomService) AS nombre FROM service WHERE nomService='"+this.nomService+"'";
		
		mysql sql=new mysql();
		
        ResultSet res=sql.selectbd(reqSelect);
		
		try {
			if(res.next()){
				
				validateur=res.getInt("nombre");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(validateur>0){
			
			   this.message="Ce service existe deja!!";
			   this.error=true;
			   return;
		}
		
		updateValid=sql.updatebd(requeteUpdate);
		
		if(updateValid!=-1){
			
			this.message="Le service "+this.nomService+" a été modifié avec succes";
			this.error=true;
			return;
		}
		else{
			
			this.message="La modification a échoué";
			this.error=true;
			return;
			
		}
	}

	
   public List<service> getListMedService() {
	   this.listMedService=new ArrayList<service>();
	   
	   mysql sql=new mysql();
	   
	   String requeteMedecin="select me.idMedecin,me.codeMedecin,me.categorie,pe.nom,pe.prenom, pe.userName, se.nomService,sem.dateAffectMed from servicemed sem" +
	   		" join medecin me on me.idMedecin=sem.idMedecin" +
	   		" join personne pe on pe.idPersonne=me.idPersonne" +
	   		" join service se on se.idService=sem.idService" +
	   		" where pe.nom like '"+this.searchValue+"%'" +
	   		" or pe.prenom like '"+this.searchValue+"%'" +
	   		" or se.nomService like '"+this.searchValue+"%'" +
	   		" or me.codeMedecin like '"+this.searchValue+"%'" +
	   		" order by me.idMedecin desc";
	   
	   System.out.println(requeteMedecin);
	   
	   ResultSet res=sql.selectbd(requeteMedecin);
	   
	   try {
		while(res.next()){
			
			service pa=new service();
		
			pa.codePerso=res.getString("codeMedecin");
			pa.idMedecin=res.getInt("idMedecin");
			pa.categorie=res.getString("categorie");
			pa.nom=res.getString("nom");
			pa.prenom=res.getString("prenom");
			pa.nomService=res.getString("nomService");
			pa.dateAffectMed=res.getDate("dateAffectMed");
			pa.userName=res.getString("userName");
			this.listMedService.add(pa);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return listMedService;
	}



	public void setListMedService(List<service> listMedService) {
		this.listMedService = listMedService;
	}

    public void backListMedecin(){
    	
    	this.getListMedService();
    }

	public List<service> getListInfService() {
		this.listInfService=new ArrayList<service>();
		
		mysql sql=new mysql();
		
		String requeteInfirmier="select inf.idInf,inf.codeInfirmier,pe.nom,pe.prenom, pe.userName, se.nomService,sei.dateAffectInf from serviceinf sei" +
   		" join infirmier inf on inf.idInf=sei.idInf" +
   		" join personne pe on pe.idPersonne=inf.idPersonne" +
   		" join service se on se.idService=sei.idService" +
   		" where pe.nom like '"+this.valueSearch+"%'" +
   		" or pe.prenom like '"+this.valueSearch+"%'" +
   		" or se.nomService like '"+this.valueSearch+"%'" +
   		" or inf.codeInfirmier like '"+this.valueSearch+"%'" +
   		" order by inf.idInf desc";
		
		ResultSet res=sql.selectbd(requeteInfirmier);
		
		try {
			while(res.next()){

				service pa=new service();
				
				pa.codePerso=res.getString("codeInfirmier");
				pa.idInfirmier=res.getInt("idInf");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.nomService=res.getString("nomService");
				pa.dateAffectInf=res.getDate("dateAffectInf");
				pa.userName=res.getString("userName");
				this.listInfService.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listInfService;
	}



	public void setListInfService(List<service> listInfService) {
		this.listInfService = listInfService;
	}

   public void backListInfirmier(){
	   
	   this.getIdInfirmier();
   }

   
   public List<service> getListMedecin() {
	   
	  this.listMedecin=new ArrayList<service>();
	  
	  mysql sql=new mysql();
	  
	  String requeteMedecin="select me.idMedecin,me.codeMedecin,se.idService,se.nomService,sem.dateAffectMed from servicemed sem" +
	  		" join medecin me on me.idMedecin=sem.idMedecin" +
	  		" join personne pe on pe.idPersonne=me.idPersonne" +
	  		" join service se on se.idService=sem.idService" +
	  		" order by me.idMedecin desc";
	  
	  ResultSet res=sql.selectbd(requeteMedecin);
	  
	  try {
		while(res.next()){
			
			service pa=new service();
			
			pa.idMedecin=res.getInt("idMedecin");
			pa.codePerso=res.getString("codeMedecin");
			pa.nomService=res.getString("nomService");
			pa.idService=res.getInt("idService");
			pa.dateAffectMed=res.getDate("dateAffectMed");
			
			this.listMedecin.add(pa);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return listMedecin;
  }



   public void setListMedecin(List<service> listMedecin) {
	this.listMedecin = listMedecin;
  }



   public List<service> getListInfirmier() {
	return listInfirmier;
  }



  public void setListInfirmier(List<service> listInfirmier) {
	this.listInfirmier = listInfirmier;
  }


  /*La methode qui fait la */
  public ArrayList<service> suggestionPatient(Object prefix){
		
		String keyword = (String) prefix;
		  String cle=keyword.toLowerCase();
		
		  ArrayList<service> suggestions=new ArrayList<service>();
				List<service> tous=this.getListMedecin();
				
				for(service reponse: tous){
					if(reponse.nom.toLowerCase().startsWith(cle) || reponse.prenom.toLowerCase().startsWith(cle) || reponse.codePerso.startsWith(cle)) {
						suggestions.add(reponse);
					}}
				System.out.println("La suggestion:"+suggestions);
				System.out.println("La cle de la suggestion:"+cle);
		
		return suggestions;
		
 }
  
   
  public service(){
	
	
	 FacesContext context = FacesContext.getCurrentInstance();
	 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);  
	 
	 String dataConnect=(String)session.getAttribute("ident");
	 
	 if(dataConnect==null){
		 try {
			context.getExternalContext().redirect("/maisonMedicale/index.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
}
