package saisie;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class laborantin {
	
	private String codePerso;
	private String nom;
	private String prenom;
	private String genre;
	private Date dateRendezVous;
	private String nomService;
	private String traitement;
	private String prestation;
	private String etat;
	private boolean verification=true;
	private boolean resultatExamen=false;
	private List<laborantin>listSuiviPatient;
	private List<laborantin>listPatientResultat;
	private List<laborantin>listDetailsPatient;
	private List<laborantin>listDetailsRendez;
	private List<laborantin> listResultat;//Liste des examens ayant des resultats
	private String searchValue;
	private int idPatient;
	private boolean status;
	private String nomPresta;
	private boolean fait;
	private boolean validate;
	private String statusValue;
	private String faitValue;
	private String message;
	private boolean viewbool;
	private boolean error;
	public laborantin selected;
	private String resultat;
	private int idRendezVous;
	private int idFiche;
	private String profession;
	private String email;
	private String telFixe;
	private String telMob;
	private String adresse;
	private Date dateNaissance;
	private Date dateAttribution;
	private Date dateExecution;
	private String dateResultat;
	private String messageAnnulation;
    
	public String getProfession() {
		return profession;
	}




	public void setProfession(String profession) {
		this.profession = profession;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTelFixe() {
		return telFixe;
	}




	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}




	public String getTelMob() {
		return telMob;
	}




	public void setTelMob(String telMob) {
		this.telMob = telMob;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public Date getDateNaissance() {
		return dateNaissance;
	}




	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}




	public Date getDateAttribution() {
		return dateAttribution;
	}




	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}




	public String getResultat() {
		return resultat;
	}




	public void setResultat(String resultat) {
		this.resultat = resultat;
	}




	public int getIdRendezVous() {
		return idRendezVous;
	}




	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}




	public int getIdFiche() {
		return idFiche;
	}




	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}




	public laborantin getSelected() {
		return selected;
	}




	public void setSelected(laborantin selected) {
		this.selected = selected;
	}




	public boolean isError() {
		return error;
	}




	public void setError(boolean error) {
		this.error = error;
	}




	public boolean isViewbool() {
		return viewbool;
	}




	public void setViewbool(boolean viewbool) {
		this.viewbool = viewbool;
	}




	public String getSearchValue() {
		return searchValue;
	}




	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}




	public int getIdPatient() {
		return idPatient;
	}




	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public String getNomPresta() {
		return nomPresta;
	}




	public void setNomPresta(String nomPresta) {
		this.nomPresta = nomPresta;
	}




	public boolean isFait() {
		return fait;
	}




	public void setFait(boolean fait) {
		this.fait = fait;
	}




	public boolean isValidate() {
		return validate;
	}




	public void setValidate(boolean validate) {
		this.validate = validate;
	}




	public String getStatusValue() {
		return statusValue;
	}




	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}




	public String getFaitValue() {
		return faitValue;
	}




	public void setFaitValue(String faitValue) {
		this.faitValue = faitValue;
	}




	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




	public void setVerification(boolean verification) {
		this.verification = verification;
	}


	

	public String getMessageAnnulation() {
		return messageAnnulation;
	}




	public void setMessageAnnulation(String messageAnnulation) {
		this.messageAnnulation = messageAnnulation;
	}




	public String getCodePerso() {
		return codePerso;
	}




	public void setCodePerso(String codePerso) {
		this.codePerso = codePerso;
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




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public Date getDateRendezVous() {
		return dateRendezVous;
	}




	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	


	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	


	public String getDateResultat() {
		return dateResultat;
	}




	public void setDateResultat(String dateResultat) {
		this.dateResultat = dateResultat;
	}




	public String getNomService() {
		return nomService;
	}




	public void setNomService(String nomService) {
		this.nomService = nomService;
	}




	public String getTraitement() {
		return traitement;
	}




	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}




	public String getPrestation() {
		return prestation;
	}




	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}




	public String getEtat() {
		return etat;
	}




	public void setEtat(String etat) {
		this.etat = etat;
	}




	public Boolean getVerification() {
		return verification;
	}




	public void setVerification(Boolean verification) {
		this.verification = verification;
	}

	
    

	public boolean isResultatExamen() {
		return resultatExamen;
	}

	public void setResultatExamen(boolean resultatExamen) {
		this.resultatExamen = resultatExamen;
	}




	public List<laborantin> getListSuiviPatient() {
		
    this.listSuiviPatient=new ArrayList<laborantin>();
		
		String requeteSuivi="select pe.nom,pe.prenom,pe.genre,pa.codePatient,pa.idPatient," +
				"re.dateRendezVous,se.nomService,re.status,fi.traitement,se.nomService,pre.nomPresta,fi.fait,fi.etat, " +
				" fi.resultat from patient pa" +
				" join rendezvous re on re.idPatient=pa.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join fichemed fi on fi.idRendezVous=re.idRendezVous" +
				" join service se on se.idService=re.idService" +
				" join prestation pre on pre.idPrestation=fi.idPrestation" +
				" where pa.codePatient like '"+this.searchValue+"%'" +
	            " or pe.nom like '"+this.searchValue+"%'" +
	            " or pe.prenom like '"+this.searchValue+"%'" +
				" order by pa.idPatient desc";
		
		System.out.println("Req suivi:"+requeteSuivi);
		 mysql sql=new mysql();
		 
		 ResultSet res=sql.selectbd(requeteSuivi);
		 
		 verification fil=new verification();
		 fil.setCodePerso("");
		 
		 
		 
		 try {
			 
			 
			while(res.next()){
				
				laborantin pa=new laborantin();
				pa.idPatient=res.getInt("idPatient");
                if(!fil.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
					
                	pa.idPatient=res.getInt("idPatient");
                	
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					pa.genre=res.getString("genre");
					
				
				}	
                
				fil.setCodePerso(res.getString("codePatient"));
				
				pa.idPatient=res.getInt("idPatient");
			    pa.dateRendezVous=res.getDate("dateRendezVous");
				pa.nomService=res.getString("nomService");
				pa.status=res.getBoolean("status");
				pa.traitement=res.getString("traitement");
				pa.nomPresta=res.getString("nomPresta");
				pa.fait=res.getBoolean("fait");
				pa.etat=res.getString("etat");
				
                if(pa.status==false){
					
					pa.validate=true;
					pa.statusValue="Deja consulté";
				}
                else{
					
					pa.validate=false;
					pa.statusValue="Non consulté";
				}
                
                if(pa.fait==true || res.getString("resultat")!=null){
                
                	pa.viewbool=true;
                	pa.faitValue="Déjà executé";
                }
                else{
                	
                	pa.viewbool=false;
                	pa.faitValue="Non executé";
                }
				
				this.listSuiviPatient.add(pa);
				
				if(this.listSuiviPatient==null){
					 
					 this.message="Aucun élément pour la recherche!";
					 System.out.println(this.message);
					 this.error=true;
				 }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSuiviPatient;
	}




	public void setListSuiviPatient(List<laborantin> listSuiviPatient) {
		this.listSuiviPatient = listSuiviPatient;
	}

    
	
	public List<laborantin> getListPatientResultat() {
		
		this.listPatientResultat=new ArrayList<laborantin>();
		 System.out.println(this.searchValue);
		 String requeteResultat="select pe.nom,pe.prenom,pa.codePatient,se.nomService,pa.idPatient,pre.nomPresta,fi.resultat,re.idRendezVous,fi.idFiche from fichemed fi" +
		 		                " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
		 		                " join patient pa on pa.idPatient=re.idPatient" +
		 		                " join service se on se.idService=re.idService" +
		 		                " join personne pe on pe.idPersonne=pa.idPersonne" +
		 		                " join prestation pre on pre.idPrestation=fi.idPrestation" +
		 		                " where pa.codePatient like '"+this.searchValue+"%'" +
		 			            " or pe.nom like '"+this.searchValue+"%'" +
		 			            " or pe.prenom like '"+this.searchValue+"%' HAVING fi.resultat IS NULL" +
		 						" order by pa.idPatient desc";
		 
		 
		 mysql sql=new mysql();
		 
		 ResultSet res=sql.selectbd(requeteResultat);
		 
		 verification cur=new verification();
	     cur.setCodePerso("");
		 try {
			while(res.next()){
				
				laborantin pa=new laborantin();
				
               if(!cur.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
					
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					
				
				}
				cur.setCodePerso(res.getString("codePatient"));
				
		
				pa.idPatient=res.getInt("idPatient");
				pa.nomPresta=res.getString("nomPresta");
				pa.resultat=res.getString("resultat");
				pa.idRendezVous=res.getInt("idRendezVous");
				pa.nomService=res.getString("nomService");
				pa.idFiche=res.getInt("idFiche");
				
	
				
				this.listPatientResultat.add(pa);
                
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return listPatientResultat;
	}




	public void setListPatientResultat(List<laborantin> listPatientResultat) {
		this.listPatientResultat = listPatientResultat;
	}
	
	
	
	
	/*Les listes pour les details sur les patients*/
	
	
	public List<laborantin> getListDetailsPatient() {
		this.listDetailsPatient=new ArrayList<laborantin>();
		try{
			 
			//this.idPatient=this.selected.idPatient;
			 //System.out.println("L'idPatient"+idPatient);
			 
			 
			 String requetePatient="SELECT * FROM patient pa" +
			 		               " JOIN personne pe on pe.idPersonne=pa.idPersonne " +
			 		               " WHERE pa.idPatient='"+this.selected.idPatient+"'";
			 
			 System.out.println("Req:"+requetePatient);
			   mysql sql=new mysql();
			   
			   ResultSet res=sql.selectbd(requetePatient);
			   
			   
			   
			   try {
				while(res.next()){
					
					laborantin pa=new laborantin();
					
	                
	                pa.idPatient=res.getInt("idPatient");
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					pa.profession=res.getString("profession");
					pa.email=res.getString("email");
					pa.telFixe=res.getString("tel_fixe");
					pa.telMob=res.getString("tel_mob");
					pa.adresse=res.getString("adresse");
					pa.dateNaissance=res.getDate("date_naissance");
					
					System.out.println("pat:"+pa.codePerso+" "+pa.nom+" "+pa.prenom+" "+pa.profession);
					this.listDetailsPatient.add(pa);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 //this.idPatient=0;
		 }catch(NullPointerException e){
			 //this.idPatient=0;
			 System.out.println("Pas de patient");
			 e.printStackTrace();
		 }
		 
		 return listDetailsPatient;
		 
		
	}




	public void setListDetailsPatient(List<laborantin> listDetailsPatient) {
		this.listDetailsPatient = listDetailsPatient;
	}

	
	
	
	public List<laborantin> getListDetailsRendez() {
		
		try{
			 
			 //this.idPatient=this.selected.idPatient;
			 
		 }catch(NullPointerException e){
			 
			 e.printStackTrace();
		 }
		 
		this.listDetailsRendez=new ArrayList<laborantin>();
		
		String requeteRendez="select pa.codePatient,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService,re.status from rendezvous re" +
				             " join patient pa on pa.idPatient=re.idPatient" +
				             " join personne pe on pe.idPersonne=pa.idPersonne" +
				             " join service se on se.idService=re.idService" +
				             " where pa.idPatient='"+this.idPatient+"'";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteRendez);
		consultation cur=new consultation();
		cur.setCodePerso("");
		try {
			while(res.next()){
				
				laborantin pa=new laborantin();
				
				if(!cur.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
					
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					
				
				}
				cur.setCodePerso(res.getString("codePatient"));
				
			    pa.dateRendezVous=res.getDate("dateRendezVous");
			    pa.dateAttribution=res.getDate("dateAttribution");
			    pa.nomService=res.getString("nomService");
			    pa.status=res.getBoolean("status");
			    
			    if(pa.status==false){
					
					pa.validate=true;
					System.out.println(""+pa.status);
					pa.statusValue="Deja consulté";
				}
				
				else{
					
					pa.validate=false;
					System.out.println(""+pa.status);
					pa.statusValue="Non consulté";
				}
				
			    this.listDetailsRendez.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDetailsRendez;
	}




	public void setListDetailsRendez(List<laborantin> listDetailsRendez) {
		this.listDetailsRendez = listDetailsRendez;
	}


	
   /*La methode qui effectue la recherche des informations concernant les patients*/
	
	public void backPatientInformation(){
		
		this.getListSuiviPatient();
	}
	
	public void backPatientExamen(){
		
		this.getListResultat();
	}
 /*La methode pour gerer la partie verification*/
    
    public void verificationClicked(){
    	this.verification=true;
    	this.resultatExamen=false;
    }
    
    public void resultatClicked(){
    	this.resultatExamen=true;
    	this.verification=false;
    }
    
    /*La methode qui effectue la recherche dans la liste des resultats*/
	public void backPatientResultat(){
		
		this.getListPatientResultat();
	}
	
	public String traitementDateTime(java.util.Date data){
		if(data==null)
			return "";
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return form.format(data);	
	}
/*La methode pour enregister et modifier les resultats des examens*/
	
	public void saisiResultat(){
		java.util.Date d=new java.util.Date();
		
		int updateValid=-1;
		
		this.idFiche=this.selected.idFiche;
		this.nomPresta=this.selected.nomPresta;
		this.resultat=this.selected.resultat;
		
		String requeteResultat="update fichemed set resultat='"+this.resultat+"', dateResultat='"+this.traitementDateTime(d)+"' where idFiche='"+this.idFiche+"'";
		
		mysql sql=new mysql();
		
		updateValid=sql.updatebd(requeteResultat);
		
		if(updateValid!=-1){
			
			this.message="La modification est reussie";
			this.error=true;
			System.out.println(this.message);
		}
		
		else{
			
			this.message="La modification a échoué";
			this.error=true;
			System.out.println(this.message);
		}
		
	}
	
	/*La methode pour initiliser le formulaire resultat*/
	
	 public void initialiseResultat(){
		 
		 this.message="";
		 this.error=false;
		 this.resultat="";
		 
	 }
	 
	
	public List<laborantin> getListResultat() {
		this.listResultat=new ArrayList<laborantin>();
		  String req="SELECT *  FROM patient pa " +
		  			 " JOIN rendezvous re ON re.idPatient = pa.idPatient" +
		  			 " JOIN personne pe ON pe.idPersonne = pa.idPersonne " +
		  			 " JOIN fichemed fi ON fi.idRendezVous = re.idRendezVous AND fi.resultat IS NOT NULL " +
		  			 " JOIN service se ON se.idService = re.idService" +
		  			 " JOIN prestation pre ON pre.idPrestation = fi.idPrestation " +
		  			 " JOIN categoriePresta cp ON pre.idCatPresta = cp.idCatPresta" +
		  			 " WHERE pa.codePatient LIKE '"+this.searchValue+"%' OR pe.nom LIKE '"+this.searchValue+"%' OR pe.prenom LIKE '"+this.searchValue+"%'" +
		  			 " HAVING cp.nomCatPresta =  'EXAMEN' ORDER BY pa.idPatient DESC ";
		  
		 System.out.println("Reqp:"+req);
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(req);
		 
		 try {
			while(res.next()){
				 laborantin l=new laborantin();
				 l.idPatient=res.getInt("idPatient");
				 l.codePerso=res.getString("codePatient");
				 l.idFiche=res.getInt("idFiche");
				 l.nom=res.getString("nom");
				 l.prenom=res.getString("prenom");
				 l.genre=res.getString("genre");
				 l.resultat=res.getString("resultat");
				 l.nomPresta=res.getString("nomPresta");
				 l.dateExecution=res.getDate("dateResultat");
				 l.dateResultat=res.getString("dateResultat");
				 this.listResultat.add(l);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return listResultat;
	}




	public void setListResultat(List<laborantin> listResultat) {
		this.listResultat = listResultat;
	}

	public void annulerResultat(){
		int i=-1;
		String req="UPDATE fichemed SET resultat=NULL, dateResultat=NULL WHERE idFiche='"+this.selected.idFiche+"'";
		System.out.println("Req:"+req);
		mysql c=new mysql();
		i=c.updatebd(req);
		if(i>0){
			this.messageAnnulation="Resultat annulé";
		}else{
			this.messageAnnulation="Echec d'annulation";
		}
	}


	public laborantin(){
		
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
