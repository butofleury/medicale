package saisie;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;



public class rendezvous implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codePerso;
	private int idPatient;
	private int idService;
	private String nomService;
	private String nom;
	private String prenom;
	private Date dateRendezVs;
	private Date dateAttribution;
	private int idRendezVous;
	private Date dateNaissance;
	private String telFixe;
	private String telMob;
	private String adresse;
	private String email;
	private String genre;
	private String profession;
	private int idPersonne;
	private rendezvous selected;
	private String message;
	private List<rendezvous>listPatient;
	private List<rendezvous>listRendez;
	private List<rendezvous>listRendezFiltre;
	private List<SelectItem>listService;
	private String dateChoix;
	private boolean choixVarie=false;;
	private boolean choixToday=false;
	private int idRec;
	private List<rendezvous>listPatientToday;
	private boolean rendezPas;
	private Date dateFiltre;
	private boolean rechercheFiltre;
	private boolean cacheHistorique=true;
	private boolean boolnewRendez=true;
	private boolean boolafficheRendez=false;
	private boolean error=false;
	
	
	
	
	
	
	
	
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isBoolnewRendez() {
		return boolnewRendez;
	}

	public void setBoolnewRendez(boolean boolnewRendez) {
		this.boolnewRendez = boolnewRendez;
	}

	public boolean isBoolafficheRendez() {
		return boolafficheRendez;
	}

	public void setBoolafficheRendez(boolean boolafficheRendez) {
		this.boolafficheRendez = boolafficheRendez;
	}

	public boolean isCacheHistorique() {
		return cacheHistorique;
	}

	public void setCacheHistorique(boolean cacheHistorique) {
		this.cacheHistorique = cacheHistorique;
	}

	public boolean isRechercheFiltre() {
		return rechercheFiltre;
	}

	public void setRechercheFiltre(boolean rechercheFiltre) {
		this.rechercheFiltre = rechercheFiltre;
	}

	public int getIdRec() {
		return idRec;
	}

	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getDateChoix() {
		return dateChoix;
	}

	public void setDateChoix(String dateChoix) {
		this.dateChoix = dateChoix;
	}

	public boolean isChoixVarie() {
		return choixVarie;
	}

    public void setChoixVarie(boolean choixVarie) {
		this.choixVarie = choixVarie;
	}





	public boolean isChoixToday() {
		return choixToday;
	}





	public void setChoixToday(boolean choixToday) {
		this.choixToday = choixToday;
	}





	public String getCodePerso() {
		return codePerso;
	}





	public void setCodePerso(String codePerso) {
		this.codePerso = codePerso;
	}





	public int getIdPatient() {
		return idPatient;
	}





	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}





	public int getIdService() {
		return idService;
	}





	public void setIdService(int idService) {
		this.idService = idService;
	}





	public String getNomService() {
		return nomService;
	}





	public void setNomService(String nomService) {
		this.nomService = nomService;
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





	public Date getDateRendezVs() {
		return dateRendezVs;
	}





	public void setDateRendezVs(Date dateRendezVs) {
		this.dateRendezVs = dateRendezVs;
	}





	public Date getDateAttribution() {
		return dateAttribution;
	}





	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}





	public int getIdRendezVous() {
		return idRendezVous;
	}





	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

    



	public rendezvous getSelected() {
		return selected;
	}





	public void setSelected(rendezvous selected) {
		this.selected = selected;
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





	public int getIdPersonne() {
		return idPersonne;
	}





	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}

    
    

	public Date getDateFiltre() {
		return dateFiltre;
	}

	public void setDateFiltre(Date dateFiltre) {
		this.dateFiltre = dateFiltre;
	}

	public boolean isRendezPas() {
		return rendezPas;
	}

	public void setRendezPas(boolean rendezPas) {
		this.rendezPas = rendezPas;
	}
    
	/* La methode qui cache la page historique*/
	public void cachePage(){
		
		this.rechercheFiltre=true;
		this.cacheHistorique=false;
		
	}
	
	/*La methode qui affiche la page historique*/
	
	public void rechargePage(){
		
		this.rechercheFiltre=false;
		this.cacheHistorique=true;
	}

	
    /*La methode qui retourne la liste des patients au rendez-vous a la date x*/
	
	public List<rendezvous> getListPatientToday() {
		//Date today=new Date();
		this.listPatientToday=new ArrayList<rendezvous>();
		
		String requetePatient="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
		" join patient pa on pa.idPatient=re.idPatient" +
		" join personne pe on pe.idPersonne=pa.idPersonne" +
		" join service se on re.idService=se.idService " +
		" where re.dateRendezVous=CURRENT_DATE() OR re.dateRendezVous>CURRENT_DATE()" +
		" order by re.idRendezVous desc";
		
        mysql sql=new mysql();
        
        System.out.println(requetePatient);
		
		ResultSet res=sql.selectbd(requetePatient);
		
		
		
		    
			
		try {
			
			
			while(res.next()){
				rendezvous pa=new rendezvous();
				pa.codePerso=res.getString("codePatient");
				pa.idPatient=res.getInt("idPatient");
				pa.idService=res.getInt("idService");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.dateRendezVs=res.getDate("dateRendezVous");
				pa.dateAttribution=res.getDate("dateAttribution");
				pa.idRendezVous=res.getInt("idRendezVous");
				
				this.listPatientToday.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
           if(res==null){
			
			this.rendezPas=true;
			
			System.out.println("C'est que le res est Null");
			
			this.message="Aucun rendez-vous pour moment";
			
		  }
		
		
		return listPatientToday;
	}

	public void setListPatientToday(List<rendezvous> listPatientToday) {
		this.listPatientToday = listPatientToday;
	}

	/*La methode qui gere le type date */
	public String traitementDate(Date data){
			
			if(data==null)
			  return "";
			java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
			
			return form.format(data);
				
			
		}
    
	


	public List<rendezvous> getListPatient() {
		 listPatient=new ArrayList<rendezvous>();
	     	
	     
	     	
	     	String requetePatient="SELECT pe.idCat, pe.idPersonne, pe.nom, pe.prenom, pe.date_naissance, pe.genre, pe.tel_fixe, pe.tel_mob, pe.adresse, pe.email, pa.profession, pa.idPatient, pa.codePatient "+
	     	"FROM personne pe "+
	     	"JOIN patient pa ON pe.idPersonne = pa.idPersonne "+
	     	"ORDER BY pa.idPatient DESC";
	     	mysql sql=new mysql();
	     	ResultSet res=sql.selectbd(requetePatient);
	     	try {
	 			while(res.next()){
	 				rendezvous pa=new rendezvous();
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





	public void setListPatient(List<rendezvous> listPatient) {
		this.listPatient = listPatient;
	}
    
	
	
	
	
	
	
	
	public List<rendezvous> getListRendezFiltre() {
		
          this.listRendezFiltre=new ArrayList<rendezvous>();
		
		String requeteRendez="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join service se on re.idService=se.idService " +
				" where re.dateRendezVous='"+this.traitementDate(dateFiltre)+"'";
				
		
		
		
		mysql sql=new mysql();
		
		
		System.out.println(requeteRendez);
		ResultSet res=sql.selectbd(requeteRendez);
		
		if(res==null){
			
			this.message="Aucun rendez-vous";
			System.out.println("PAs d'info");
		}
		
		try {
			while(res.next()){
				rendezvous pa=new rendezvous();
				pa.codePerso=res.getString("codePatient");
				pa.idPatient=res.getInt("idPatient");
				pa.idService=res.getInt("idService");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.dateRendezVs=res.getDate("dateRendezVous");
				pa.dateAttribution=res.getDate("dateAttribution");
				pa.idRendezVous=res.getInt("idRendezVous");
				
				this.listRendezFiltre.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listRendezFiltre;
	}

	public void setListRendezFiltre(List<rendezvous> listRendezFiltre) {
		this.listRendezFiltre = listRendezFiltre;
	}

	/*La methode pour recuperer les informations de la liste de suggestion*/
	public void patientSelected(){
		
		this.idPatient=this.selected.idPatient;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.nomService=this.selected.nomService;
		this.codePerso=this.selected.codePerso;
		System.out.println("Le nom:"+nom);
	}
	
	

/* La  methode qui recupere les patients de la boite de suggestions*/
	
	public ArrayList<rendezvous> suggestionPatient(Object prefix){
		String keyword = ((String) prefix).toLowerCase();
		//String cle=(String) prefix;
		ArrayList<rendezvous> suggestions=new ArrayList<rendezvous>();
				List<rendezvous> tous=this.getListPatient();
				
				for(rendezvous reponse: tous){
					if(reponse.nom.toLowerCase().startsWith(keyword) || reponse.prenom.toLowerCase().startsWith(keyword) || reponse.codePerso.startsWith(keyword)) {
						suggestions.add(reponse);
					}}
		return suggestions;
		
	}


	public List<rendezvous> getListRendez() {
		
		listRendez=new ArrayList<rendezvous>();
		
		String requeteRendez="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join service se on re.idService=se.idService order by re.idRendezVous desc";
				
		
		
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteRendez);
		
		try {
			while(res.next()){
				rendezvous pa=new rendezvous();
				pa.codePerso=res.getString("codePatient");
				pa.idPatient=res.getInt("idPatient");
				pa.idService=res.getInt("idService");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.dateRendezVs=res.getDate("dateRendezVous");
				pa.dateAttribution=res.getDate("dateAttribution");
				pa.idRendezVous=res.getInt("idRendezVous");
				
				this.listRendez.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return listRendez;
	}





	public void setListRendez(List<rendezvous> listRendez) {
		this.listRendez = listRendez;
	}

    



	public List<SelectItem> getListService() {
		
		String requeteService="select idService,nomService from service order by idService desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteService);
		  
		if(this.listService==null){
			
			this.listService=new ArrayList<SelectItem>();
		}
		else{
			
			this.listService.clear();
		}
			
		
		try {
			while(res.next()){
				
				this.idService=res.getInt("idService");
				this.nomService=res.getString("nomService");
				
				this.listService.add(new SelectItem(this.idService, this.nomService));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listService;
		
	}





	public void setListService(List<SelectItem> listService) {
		this.listService = listService;
	}



	
	
/*La methode qui enregistre un rendez-vous*/
	
	public void saisiRendez(){
		
		
		if(this.codePerso==""){
			
			this.message="Veuillez selectionner un patient!";
			this.error=true;
			return;
		}
		
		
		if(this.dateChoix==""){
			
			this.message="Veuillez selectionner la date!";
			this.error=true;
			return;
		}
		try{
		System.out.println("Methode appelee");
		
		 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idReception=session.getAttribute("idRec").toString();
		   
		   this.idRec=Integer.parseInt(idReception);
		   
		  System.out.println("L'id du receptionniste"+idReception);
		  
		 
		  
		Date dateAttribution=new Date();
		
		int verifiRendez=-1;
		
		String requeteRendez="insert into rendezvous (idPatient,dateRendezVous,dateAttribution,idService,idRec,status) values " +
		"('"+this.idPatient+"','"+this.traitementDate(dateRendezVs)+"','"+this.traitementDate(dateAttribution)+"','"+this.idService+"','"+this.idRec+"',1)";
		
		 
		mysql sql=new mysql();
	
		
		int compareDate=this.dateRendezVs.compareTo(dateAttribution);
		System.out.println("Comparateur:"+compareDate);
		if(compareDate<0&&this.choixToday==false)
		{
			this.message="La date est invalide,reessayer encore!!!";
			this.error=true;
			
			this.dateRendezVs=null;
			
		     return;
			
			
		}
		
		
       
		verifiRendez=sql.updatebd(requeteRendez);
		
		if(verifiRendez!=-1){
			
			String requeteService="select nomService from service where idService='"+this.idService+"'";
			
			ResultSet resService=sql.selectbd(requeteService);
			
			try {
				if(resService.next()){
					
					this.nomService=resService.getString("nomService");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(requeteRendez);
			this.message=""+this.nom+" "+this.prenom+" "+" a recu un rendez-vous dans le service "+this.nomService+" pour le "+this.traitementDate(dateRendezVs)+" a ete enregistré ";
			this.error=true;
			 this.nom="";
			 this.prenom="";
			 this.choixVarie=false;
			 this.choixToday=false;
			 this.idService=0;
			 
			 this.codePerso="";
			
			

			
		}
		else{
			
			this.message="L'insertion a echoue";
			
			 this.nom="";
			 this.prenom="";
			 this.choixVarie=false;
			 this.choixToday=false;
			 this.idService=0;
			 
			 this.codePerso="";
		}
		
		
		
		
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			this.message="Veuillez completer toutes les champs!!! ou Pas de connexion de l'utilisateur ";
			this.error=true;
			
		}
		
		this.codePerso="";
		this.nom="";
		this.prenom="";
		this.dateRendezVs=null;
		this.choixToday=false;
		this.choixVarie=false;
		
	}
	
	
/*La methode pour modifier un rendez-vous*/
	
	public void modifierRendez(){
		
		int updateRendez=-1;
		Date dateAttribution=new Date();
		
		this.idRendezVous=this.selected.idRendezVous;
		this.idPatient=this.selected.idPatient;
		this.idService=this.selected.idService;
		this.dateRendezVs=this.selected.dateRendezVs;
		this.dateAttribution=this.selected.dateAttribution;
		
		String requeteModifier="update rendezvous set dateRendezVous='"+this.traitementDate(dateRendezVs)+"'," +
				"dateAttribution='"+this.traitementDate(dateAttribution)+"',idService='"+this.idService+"' where idRendezVous='"+this.idRendezVous+"'";
		
		
		mysql sql=new mysql();
		int compareDate=this.dateRendezVs.compareTo(dateAttribution);
		if(compareDate<0){
			
			this.message="La date est invalide,Veuillez la rectifier!!!";
			return;
		}
		
		
		updateRendez=sql.updatebd(requeteModifier);
		if(updateRendez!=-1){
			
			this.message="La modification a reussie";
			System.out.println("Le message"+this.message);
			System.out.println(requeteModifier);
		}
		else
		{
			
			this.message="La modification a échoue";
		}
		
		
	}
	
/*Supprimer le rendez-vous*/
	
	public void supprimerRendez(){
		int deleteRendez=-1;
		
		this.idRendezVous=this.selected.idRendezVous;
		this.idPatient=this.selected.idPatient;
		this.idService=this.selected.idService;
		this.dateRendezVs=this.selected.dateRendezVs;
		this.dateAttribution=this.selected.dateAttribution;
		this.codePerso=this.selected.codePerso;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		
		String requeteSupprimer="delete from rendezvous where idRendezVous='"+this.idRendezVous+"'";
		
		mysql sql=new mysql();
		
		deleteRendez=sql.updatebd(requeteSupprimer);
		if(deleteRendez!=-1){
			
			this.message="Le rendez-vous du patient de code:"+this.codePerso+","+this.nom+","+this.prenom+",du "+this.dateRendezVs+" est annulé";
			System.out.println(this.message);
			System.out.println(deleteRendez);
		}
		else{
			
			this.message="L'annulation du rendez-vous du patient de code:"+this.codePerso+","+this.nom+","+this.prenom+" a echoué";
		}
		
		
	}
	 
	/* La methode qui gere le bouton de la date */
	
	 public void dateClicked(ValueChangeEvent event){
		this.choixVarie=false;
		this.choixToday=false;
		
		String valueReceive=""+event.getNewValue();
		
		System.out.println("La valeur recu:"+valueReceive);
		
		if(valueReceive.equalsIgnoreCase("choixVarie")){ 
			
			this.choixVarie=true;
			this.choixToday=false;
			this.dateRendezVs=null;
		}
		else{
			
			this.choixVarie=false;
			this.choixToday=true;
			this.dateRendezVs=new Date();
		}
		
	}
	
	/*La methode qui initialise les valeurs a inserer*/
	 
	 public void initialiseValue(){
		 this.nom="";
		 this.prenom="";
		 this.choixVarie=false;
		 this.choixToday=false;
		 this.idService=0;
		 this.message="";
		 this.codePerso="";
		 this.error=false;
		 
	 }
	
	 /*La methode qui gere le chargement de la page nouveau */

	 public void nouveauClicked(){
		 
		 this.boolnewRendez=true;
		 this.boolafficheRendez=false;
	 }
	 
     /*La methode qui gere le chargement de la page liste */
	 
	 public void afficheClicked(){
		 
		 this.boolnewRendez=false;
		 this.boolafficheRendez=true;
	 }

	 
	
	public rendezvous(){}

}
