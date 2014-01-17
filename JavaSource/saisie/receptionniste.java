package saisie;


import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.ViewExpiredException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;




public class receptionniste implements Serializable {
   
  
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private boolean patient = true;
   private boolean rendezVs = false;
   private boolean facture = false;
   private boolean recherche=false;
   private boolean affichePatient=true;
   private String nom;
   private String prenom;
   private Date dateNaissance;
   private String telFixe;
   private String telMob;
   private String adresse;
   private String email;
   private String genre;
   private String profession;
   private int idPatient;
   private int idPersonne;
   private String codePerso;
   private receptionniste selected;
   private int idCat;
   private String message;
   private String searchValue;
   private int idRendezVous;
   private Date dateRendezVous;
   private Date dateAttribution;
   private String nomService;
   private List<receptionniste>listPatient;
   private List<receptionniste>listRecherche;
   
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
		
		public Date getDateNaissance() {
			return dateNaissance;
		}
		
		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
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
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getGenre() {
			return genre;
		}
		
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		public String getProfession() {
			return profession;
		}
		
		public void setProfession(String profession) {
			this.profession = profession;
		}
		
		public int getIdPatient() {
			return idPatient;
		}
		
		public void setIdPatient(int idPatient) {
			this.idPatient = idPatient;
		}
		
		public int getIdPersonne() {
			return idPersonne;
		}
		
		public void setIdPersonne(int idPersonne) {
			this.idPersonne = idPersonne;
		}
		
		public String getCodePerso() {
			return codePerso;
		}
		
		public void setCodePerso(String codePerso) {
			this.codePerso = codePerso;
		}
		
		public void patientClicked() {
			   this.patient = true;
			   this.rendezVs = false;
			   this.facture = false;
			   this.recherche=false;
		   }
		   
		   public void rendezvousclicked() {
			   this.patient = false;
			   this.rendezVs = true;
			   this.facture = false;
			   this.recherche=false;
		   }
		   
		   public void factureClicked() {
			   this.patient = false;
			   this.rendezVs = false;
			   this.facture = true;
			   this.recherche=false;
		   }
		   
		   public void rechercheClicked() {
			   this.patient = false;
			   this.rendezVs = false;
			   this.facture = false;
			   this.recherche=true;
		   }
		   
			public boolean isPatient() {
			return patient;
		}
		
		
		
		
		public int getIdCat() {
				return idCat;
			}
		
			public void setIdCat(int idCat) {
				this.idCat = idCat;
			}
		
		public void setPatient(boolean patient) {
			this.patient = patient;
		}
		
		
		
		
		public boolean isRendezVs() {
			return rendezVs;
		}
		
		
		
		
		    public void setRendezVs(boolean rendezVs) {
			this.rendezVs = rendezVs;
		}
		
		
		
		
		   public boolean isFacture() {
			return facture;
		   }
		
		
		   public void setFacture(boolean facture) {
			this.facture = facture;
		   }
		    
		   
		   
		  
		
		   public boolean isAffichePatient() {
			return affichePatient;
		   }
		
		   public void setAffichePatient(boolean affichePatient) {
			this.affichePatient = affichePatient;
		}
		   
		   
		   
		   public receptionniste getSelected() {
			return selected;
		}
		
		public void setSelected(receptionniste selected) {
			this.selected = selected;
		}
		
		public boolean isRecherche() {
			return recherche;
		}
		
		public void setRecherche(boolean recherche) {
			this.recherche = recherche;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}
		 
		
		  
		
		
		
		   public int getIdRendezVous() {
			return idRendezVous;
		}
		
		public void setIdRendezVous(int idRendezVous) {
			this.idRendezVous = idRendezVous;
		}
		
		public Date getDateRendezVous() {
			return dateRendezVous;
		}
		
		public void setDateRendezVous(Date dateRendezVous) {
			this.dateRendezVous = dateRendezVous;
		}
		
		public Date getDateAttribution() {
			return dateAttribution;
		}
		
		public void setDateAttribution(Date dateAttribution) {
			this.dateAttribution = dateAttribution;
		}
		
		public String getNomService() {
			return nomService;
		}
		
		public void setNomService(String nomService) {
			this.nomService = nomService;
		}
		
		public String getSearchValue() {
			return searchValue;
		}
		
		public void setSearchValue(String searchValue) {
			this.searchValue = searchValue;
		}
		
		
		   
		   public void afficheClicked(){
			   
			   
			   this.affichePatient=true;
		   }
		
		   
		   
		
		public List<receptionniste> getListRecherche() {
			
			this.listRecherche=new ArrayList<receptionniste>();
			
			String requeteRecherche="select pe.idPersonne,pe.nom,pe.prenom,pe.date_naissance,pe.genre,pe.tel_fixe,pe.tel_mob,pe.adresse,pe.email," +
					"pa.idPatient,pa.profession,pa.codePatient,re.idRendezVous,re.dateRendezVous,re.dateAttribution,se.nomService from personne pe" +
					" join patient pa on pa.idPersonne=pe.idPersonne" +
					" join rendezvous re on re.idPatient=pa.idPatient" +
					" join service se on se.idService=re.idService" +
					" group by pa.idPatient having max(re.idRendezVous)" +
					" order by pa.idPatient desc";
			
			 mysql sql=new mysql();
			 
			 
			 ResultSet res=sql.selectbd(requeteRecherche);
			 
			         try {
						while(res.next()){
							
							receptionniste pa=new receptionniste();
							
							pa.codePerso=res.getString("codePatient");
							//System.out.println(this.codePerso);
							pa.idPersonne=res.getInt("idPersonne");
							pa.nom=res.getString("nom");
							pa.prenom=res.getString("prenom");
							pa.dateNaissance=res.getDate("date_naissance");
							pa.genre=res.getString("genre");
							pa.telFixe=res.getString("tel_fixe");
							pa.telMob=res.getString("tel_mob");
							pa.adresse=res.getString("adresse");
							pa.email=res.getString("email");
							pa.idPatient=res.getInt("idPatient");
							pa.profession=res.getString("profession");
							pa.idRendezVous=res.getInt("idRendezVous");
							pa.dateRendezVous=res.getDate("dateRendezVous");
							pa.dateAttribution=res.getDate("dateAttribution");
							pa.nomService=res.getString("nomService");
							
							//System.out.println("Dans get:"+dateAttribution);
							
							this.listRecherche.add(pa);
							
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			return listRecherche;
		}
		
		public void setListRecherche(List<receptionniste> listRecherche) {
			this.listRecherche = listRecherche;
		}
		
		
		
		
		/* La  methode qui recupere les patients de la boite de suggestions*/
		
		public ArrayList<receptionniste> suggestionPatient(Object prefix){
			
			
			
			
			String keyword = (String) prefix;
			  String cle=keyword.toLowerCase();
			
			  ArrayList<receptionniste> suggestions=new ArrayList<receptionniste>();
					List<receptionniste> tous=this.getListRecherche();
					
					for(receptionniste reponse: tous){
						if(reponse.nom.toLowerCase().startsWith(cle) || reponse.prenom.toLowerCase().startsWith(cle) || reponse.codePerso.startsWith(cle)) {
							suggestions.add(reponse);
						}}
					System.out.println("La suggestion:"+suggestions);
					System.out.println("La cle de la suggestion:"+cle);
			
			return suggestions;
			
		}
		
		
		/*La methode pour recuperer les informations de la liste de suggestion*/
		
		public void patientSelected(){
			
				
			
			this.nom=this.selected.nom;
			this.prenom=this.selected.prenom;
			this.dateNaissance=this.selected.dateNaissance;
			this.genre=this.selected.genre;
			this.telFixe=this.selected.telFixe;
			this.telMob=this.selected.telMob;
			this.adresse=this.selected.adresse;
			this.email=this.selected.email;
			this.profession=this.selected.profession;
			this.dateRendezVous=this.selected.dateRendezVous;
			this.dateAttribution=this.selected.dateAttribution;
			this.nomService=this.selected.nomService;
			
			this.idRendezVous=this.selected.idRendezVous;
			this.idPersonne=this.selected.idPersonne;
			this.idPatient=this.selected.idPatient;
			this.codePerso=this.selected.codePerso;
			this.idPatient=this.selected.idPatient;
			System.out.println(this.selected.dateRendezVous);
			System.out.println("IdRendezVs:"+this.idRendezVous);
			
			
			
			
		}
		public List<receptionniste> getListPatient() {
			   
			   listPatient=new ArrayList<receptionniste>();
			   
			   
		    	
		    	String requetePatient="SELECT pe.idCat,pe.idPersonne,pe.nom,pe.prenom,pe.date_naissance,pe.genre," +
				"pe.tel_fixe,pe.tel_mob,pe.adresse,pe.email,pa.profession,pa.idPatient,pa.codePatient " +
				"FROM personne pe JOIN patient pa " +
				"ON pe.idPersonne=pa.idPersonne ORDER BY pa.idPersonne DESC";
		    	
		    	mysql sql=new mysql();
		    	ResultSet res=sql.selectbd(requetePatient);
		    	try {
					while(res.next()){
						
						receptionniste pa=new receptionniste();
		 				pa.codePerso=res.getString("codePatient");
		 				pa.idPatient=res.getInt("idPatient");
		 				pa.nom=res.getString("nom");
		 				pa.idPersonne=res.getInt("idPersonne");
		 				pa.prenom=res.getString("prenom");
		 				pa.dateNaissance=res.getDate("date_naissance");
		 			    pa.genre=res.getString("genre");
		 				pa.telFixe=res.getString("tel_fixe");
		 				pa.telMob=res.getString("tel_mob");
		 			    pa.adresse=res.getString("adresse");
		 				pa.email=res.getString("email");
		 				pa.profession=res.getString("profession");
		 				
		 				listPatient.add(pa);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return listPatient;
		}
		
		  public void setListPatient(List<receptionniste> listPatient) {
			this.listPatient = listPatient;
		  }
		
		  
		  
		  /*La methode qui gere le type date */
			
		  public String traitementDate(Date data){
				
				if(data==null)
				  return "";
				java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
				
				return form.format(data);
					
				
			}
		public void boutonCLicked(){
			   
			   FacesContext context = FacesContext.getCurrentInstance();
			   HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
			 
			   String idReception=session.getAttribute("idRec").toString();
			   
			   int  idRec=Integer.parseInt(idReception);
			   
			   System.out.println("IdRec:"+idRec);
			 
			 
		  }
		
		/* la methode qui modifie un patient*/
		
		public void modifierPatient(){
			int updateValid=-1;
			
			this.idPersonne=this.selected.idPersonne;
			this.nom=this.selected.nom;
			System.out.println(this.nom);
			this.prenom=this.selected.prenom;
			this.genre=this.selected.genre;
			this.dateNaissance=this.selected.dateNaissance;
			this.telFixe=this.selected.telFixe;
			this.telMob=this.selected.telMob;
			this.adresse=this.selected.adresse;
			this.email=this.selected.email;
			this.profession=this.selected.profession;
			this.idCat=this.selected.idCat;
			this.idPatient=this.selected.idPatient;
			System.out.println("Id de la personne:"+this.idPersonne);
			System.out.println("Id du patient:"+this.idPatient);
			
			if(this.selected.nom==null){
				
				System.out.println(this.selected.nom);
			}
			int compareDate=this.dateNaissance.compareTo(new Date());
			System.out.println("Date compare:"+compareDate);
				if(compareDate>0){
					 this.message="Date de naissance invalide";
				}else{
			String requeteModifier="update personne set nom='"+this.nom.toUpperCase()+"',prenom='"+this.prenom.toUpperCase()+"',genre='"+this.genre+"', " +
			"date_naissance='"+this.traitementDate(dateNaissance)+"',tel_fixe='"+this.telFixe+"',tel_mob='"+this.telMob+"'," +
					"adresse='"+this.adresse.toUpperCase()+"',email='"+this.email+"' where idPersonne='"+this.idPersonne+"'";
			
			   mysql sql=new mysql();
			   updateValid=sql.updatebd(requeteModifier);
		       if(updateValid!=-1){
		    	   int updatePatient=-1;
		    	   
		    	   String requetePatientModifier="update patient set profession='"+this.profession.toUpperCase()+"' where idPatient='"+this.idPatient+"'";
		    	   updatePatient=sql.updatebd(requetePatientModifier);
		    	   
		    	   if(updatePatient!=-1){
		    		   this.message="La modification est reussie";
		   			   System.out.println(requeteModifier);
		   			   System.out.println(requetePatientModifier);
		   			   
		   			   
		   			   System.out.println(this.selected);
		    		   
		    	   }
		    	   
				
				
			}
		
			else{
				this.message="La modification a echoue";
				
			}
				}
			this.nom="";
			this.prenom="";
			this.genre="";
			this.dateNaissance=null;
			this.telFixe="";
			this.telMob="";
			this.adresse="";
			this.email="";
			this.profession="";
			
		}
		
		public String genererCode(){
			String code="";
			String req="SELECT * FROM personne ORDER BY idPersonne DESC LIMIT 1";
			Calendar cal=new java.util.GregorianCalendar();
			int year = cal.get(Calendar.YEAR);
			System.out.println("Année:"+year);
			mysql c=new mysql();
			ResultSet res=c.selectbd(req);
				try {
					if(res.next()){
						code=""+year+"/"+res.getInt("idPersonne");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.closebd();
			return code;
		}
		  
		
		   /*La methode qui enregistre les patients */
		
		   public void saisiPatient(){
			   int verifiPatient=-1,verifiPersonne=-1;
			   int idPersonne=0;
			   int idCatPerso=0;
			   
			   String requeteCatPerso="select idCat from categorieperso where nomCat='patient'";
			   mysql sql=new mysql();
			   
			   ResultSet res=sql.selectbd(requeteCatPerso);
			   
			     try {
					if(res.next()){
						
						idCatPerso=res.getInt("idCat");
						
					}
					int compareDate=this.dateNaissance.compareTo(new Date());
					System.out.println("Date compare:"+compareDate);
					if(compareDate>0){
						 this.message="Date de naissance invalide";
					}else{
					
					String insertPersonne="insert into personne(nom, prenom, date_naissance,genre, tel_fixe, tel_mob, adresse, email,idCat)" +
					" values('"+this.nom.toUpperCase()+"', '"+this.prenom.toUpperCase()+"', '"+traitementDate(this.dateNaissance)+"','"+this.genre+"','"+this.telFixe+"'," +
					"'"+this.telMob+"', '"+this.adresse.toUpperCase()+"', '"+this.email+"','"+idCatPerso+"')";
					
					verifiPersonne=sql.updatebd(insertPersonne);
					
					if(verifiPersonne!=-1){
						System.out.println(insertPersonne);
						this.message="Insertion d'un patient "+this.nom+" "+this.prenom;
						System.out.println("Insertion reussie personne");
						
						String getIdPersonne="select * from personne order by idPersonne desc limit 1 ";
			    		ResultSet resPersonne=sql.selectbd(getIdPersonne);
			    		
			    		if(resPersonne.next()){
			    			
			    			idPersonne=resPersonne.getInt("idPersonne");
			    			
			    		}
			    		this.codePerso=this.genererCode();
			    		System.out.println(idPersonne);
			    		
			    		if(this.nom==""|| this.prenom==""|| this.genre==""||this.dateNaissance.equals("")){
			    			
			    			this.message="Veuillez completer toutes les champs!!!";
			    		}
			    		String insertPatient="INSERT into patient(codePatient,profession, idPersonne) values('"+this.codePerso+"','"+this.profession.toUpperCase()+"', '"+idPersonne+"')";
			    		 verifiPatient=sql.updatebd(insertPatient);
			    		 
			    		 if(verifiPatient!=-1){
			    			 
			    			 System.out.println(insertPatient);
				            	
								this.message="Insertion d'un(e) patient(e) denomme(e) "+this.nom+" "+this.prenom;
								this.codePerso="";
								this.nom="";
								this.prenom="";
								this.genre="";
								this.dateNaissance=null;
								this.telFixe="";
								this.telMob="";
								this.adresse="";
								this.email="";
								this.profession="";
			    		 }
					}
					else
					{
						this.message="Insertion echoue";
						System.out.println("Insertion echoue");
						this.codePerso="";
						this.nom="";
						this.prenom="";
						this.genre="";
						this.dateNaissance=null;
						this.telFixe="";
						this.telMob="";
						this.adresse="";
						this.email="";
						this.profession="";
					}
				}	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   
			   
		   }
		   
		   
		  
			
		   /*La methode pour initialiser les champs*/
			
			public void initialiseValue(){
				this.codePerso="";
				this.nom="";
				this.prenom="";
				this.genre="";
				this.dateNaissance=null;
				this.telFixe="";
				this.telMob="";
				this.adresse="";
				this.email="";
				this.profession="";
				this.dateAttribution=null;
				this.dateRendezVous=null;
				this.nomService="";
				
			}
		   
			
			
			public receptionniste(){
				
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
