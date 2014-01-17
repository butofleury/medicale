package saisie;

import java.io.IOException;
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



public class consultation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private boolean consultation=true;
    private boolean verification=false;
    private boolean recherche=false;
    private boolean liberation=false;
    private String codePerso;
    private String nom;
    private String prenom;
    private consultation selected;
    private String observation;
    private String traitement;
    private boolean decision;
    private String decisionValue;
    private List<consultation>listRendez;
    private int idPatient;
    private int idService;
    private String nomService;
    private Date dateRendezVous;
    private int idRendezVs;
    private List<SelectItem>listAllRooms;
    private int idChambre;
    private String codeChambre;
    private String motif;
    private String etat;
	private List<consultation>consultationList;
    private String message;
    private Date dateConsultation;
    private boolean error=false;
    private int idMedecin;
    private List<consultation>listConsulte;
    private List<consultation>listPrestation;
    private List<consultation>listHospitalise;
    private int idPrestation;
    private int idCatPresta;
    private String nomPresta;
    private String nomCatPresta;
    private int prix;
    private int idPrix;
    private int idFiche;
    private boolean choixToday=false;
    private boolean choixVarie=false;
    private String rendezChoix;
    private List<consultation>listRendezOther;
    private List<consultation>listPatientSerMed;
    private List<consultation>listPatientSerMedOther;
    private List<consultation>listCompteur;
    private List<consultation>listCompteurOther;
    private List<consultation>listCompteurOtherDate;
    private List<consultation>listChambreLibre;
    private List<consultation>listChambreCompteur;
    private List<consultation>listAntecedentPatient;
    private List<consultation>listDetailsPatient;
    private List<consultation>listDetailsRendez;
    private List<consultation>listRechercheInfo;
    private int compteur;
    private boolean status;
    private boolean validate=false;
    private String statusValue;
    private String rechercheValue;
    private String genre;
    private Date dateNaissance;
    private Date dateAttribution;
    private String telFixe;
    private String telMob;
    private String adresse;
    private String email;
    private String profession;
    private boolean fait;
    private String searchValue;
    private String faitValue;
    private boolean viewbool;
    private Date dateArrive;
    private int idHosp;
    private Date dateNow=new Date();
    private String dateNowString=this.traitementDateConvertie(dateNow);
    private Date dateSearch;
    
    
    
    
    
    
    
    
   





    
	public Date getDateSearch() {
		System.out.println(dateSearch);
		return dateSearch;
	}






	public void setDateSearch(Date dateSearch) {
		this.dateSearch = dateSearch;
	}






	public String getDateNowString() {
		return dateNowString;
	}






	public void setDateNowString(String dateNowString) {
		this.dateNowString = dateNowString;
	}






	public Date getDateNow() {
    	return dateNow;
	}






	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}






	public int getIdHosp() {
		return idHosp;
	}






	public void setIdHosp(int idHosp) {
		this.idHosp = idHosp;
	}






	public Date getDateArrive() {
		return dateArrive;
	}






	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}






	public String getFaitValue() {
		return faitValue;
	}






	public void setFaitValue(String faitValue) {
		this.faitValue = faitValue;
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






	public boolean isFait() {
		return fait;
	}






	public void setFait(boolean fait) {
		this.fait = fait;
	}






	public boolean isRecherche() {
		return recherche;
	}






	public void setRecherche(boolean recherche) {
		this.recherche = recherche;
	}






	public boolean isLiberation() {
		return liberation;
	}






	public void setLiberation(boolean liberation) {
		this.liberation = liberation;
	}






	public Date getDateAttribution() {
		return dateAttribution;
	}






	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}






	public String getProfession() {
		return profession;
	}






	public void setProfession(String profession) {
		this.profession = profession;
	}






	public String getGenre() {
		return genre;
	}






	public void setGenre(String genre) {
		this.genre = genre;
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






	public String getRechercheValue() {
		return rechercheValue;
	}






	public void setRechercheValue(String rechercheValue) {
		this.rechercheValue = rechercheValue;
	}






	public String getStatusValue() {
		return statusValue;
	}






	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}






	public boolean isValidate() {
		return validate;
	}






	public void setValidate(boolean validate) {
		this.validate = validate;
	}






	public boolean isStatus() {
		return status;
	}






	public void setStatus(boolean status) {
		this.status = status;
	}






	public int getCompteur() {
		return compteur;
	}






	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}






	public boolean isChoixToday() {
		return choixToday;
	}






	public void setChoixToday(boolean choixToday) {
		this.choixToday = choixToday;
	}






	public boolean isChoixVarie() {
		return choixVarie;
	}






	public void setChoixVarie(boolean choixVarie) {
		this.choixVarie = choixVarie;
	}



    


	public String getRendezChoix() {
		return rendezChoix;
	}






	public void setRendezChoix(String rendezChoix) {
		this.rendezChoix = rendezChoix;
	}






	public int getIdFiche() {
		return idFiche;
	}






	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}






	public boolean isError() {
		return error;
	}






	public void setError(boolean error) {
		this.error = error;
	}






	public Date getDateConsultation() {
		return dateConsultation;
	}






	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}






	public String getMessage() {
		return message;
	}






	public void setMessage(String message) {
		this.message = message;
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






	public Date getDateRendezVous() {
		return dateRendezVous;
	}






	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}






	public int getIdRendezVs() {
		return idRendezVs;
	}






	public void setIdRendezVs(int idRendezVs) {
		this.idRendezVs = idRendezVs;
	}






	public boolean isConsultation() {
		return consultation;
	}






	public void setConsultation(boolean consultation) {
		this.consultation = consultation;
	}






	public boolean isVerification() {
		return verification;
	}






	public void setVerification(boolean verification) {
		this.verification = verification;
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




   

	public String getMotif() {
		return motif;
	}






	public void setMotif(String motif) {
		this.motif = motif;
	}






	public String getEtat() {
		return etat;
	}






	public void setEtat(String etat) {
		this.etat = etat;
	}






	public consultation getSelected() {
		return selected;
	}






	public void setSelected(consultation selected) {
		this.selected = selected;
	}






	public String getObservation() {
		return observation;
	}






	public void setObservation(String observation) {
		this.observation = observation;
	}






	public String getTraitement() {
		return traitement;
	}






	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}






	
    



    
	public int getIdChambre() {
		return idChambre;
	}






	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}






	public String getCodeChambre() {
		return codeChambre;
	}






	public void setCodeChambre(String codeChambre) {
		this.codeChambre = codeChambre;
	}


    



	public List<consultation> getConsultationList() {
		return consultationList;
	}






	public void setConsultationList(List<consultation> consultationList) {
		this.consultationList = consultationList;
	}


   



	public int getIdMedecin() {
		return idMedecin;
	}






	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
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






	public List<SelectItem> getListAllRooms() {
		listAllRooms=new ArrayList<SelectItem>();
		String requeteChambre="select * from chambre where status=1";
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteChambre);
		
		try {
			while(res.next()){
				
				this.idChambre=res.getInt("idChambre");
				this.codeChambre=res.getString("codeChambre");
				
				listAllRooms.add(new SelectItem(idChambre,codeChambre));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAllRooms;
	}






	public void setListAllRooms(List<SelectItem> listAllRooms) {
		this.listAllRooms = listAllRooms;
	}


    



	public List<consultation> getListChambreLibre() {
		
		this.listChambreLibre=new ArrayList<consultation>();
		
		String requeteChambre="select * from chambre";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteChambre);
		
		try {
			while(res.next()){
				
				consultation pa=new consultation();
				
				pa.idChambre=res.getInt("idChambre");
				pa.codeChambre=res.getString("codeChambre");
				pa.status=res.getBoolean("status");
				
				if(pa.status==true){
					
					pa.validate=true;
					pa.statusValue="Pas occupé";
				}
				
				else{
					
					pa.validate=false;
					pa.statusValue="Deja occupé";
				}
				
				
				this.listChambreLibre.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChambreLibre;
	}






	public void setListChambreLibre(List<consultation> listChambreLibre) {
		this.listChambreLibre = listChambreLibre;
	}



    


	public List<consultation> getListChambreCompteur() {
		
		this.listChambreCompteur=new ArrayList<consultation>();
		
		String requeteCompteur="select count(*) as compteur from chambre where status=1";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteCompteur);
		
		try {
			while(res.next()){
				
				consultation pa=new consultation();
				
				pa.compteur=res.getInt("compteur");
				
				this.listChambreCompteur.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChambreCompteur;
	}






	public void setListChambreCompteur(List<consultation> listChambreCompteur) {
		this.listChambreCompteur = listChambreCompteur;
	}






	public boolean isDecision() {
		return decision;
	}






	public void setDecision(boolean decision) {
		this.decision = decision;
	}

    


    
    /*La liste des patients consultes*/
	public List<consultation> getListConsulte() {
		
		this.listConsulte=new ArrayList<consultation>();
		
		try{
		 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		 
		 
		 this.idMedecin=Integer.parseInt(idUtilisateur);
		 
		
        }catch(NullPointerException e){
			
			e.printStackTrace();
		}
		String requeteConsulte="select pe.nom,pe.prenom,fi.idFiche,fi.dateConsultation,fi.observation,fi.traitement,fi.motif,fi.etat,pa.codePatient,pre.nomPresta,catP.nomCatPresta,se.nomService from fichemed fi" +
		        " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
		        " join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join prestation pre on pre.idPrestation=fi.idPrestation" +
				" join categoriepresta catP on catP.idCatPresta=pre.idCatPresta" +
				" join medecin me on me.idMedecin=fi.idMedecin" +
				" join servicemed sem on sem.idMedecin=me.idMedecin" +
				" join service se on se.idService=sem.idService" +
				" where fi.dateConsultation=CURRENT_DATE() and fi.idMedecin='"+this.idMedecin+"' and fi.status=0" +
				" order by fi.idFiche desc";
		
		System.out.println("la requete sur la listeConsulte:"+requeteConsulte);
		
		      mysql sql=new mysql();
		      
		      ResultSet res=sql.selectbd(requeteConsulte);
		      
		      try {
				while(res.next()){
					
					consultation pa=new consultation();
					
					pa.idFiche=res.getInt("idFiche");
					pa.codePerso=res.getString("codePatient");
					System.out.println("Le code du patient:"+pa.codePerso);
					pa.nom=res.getString("nom");
					System.out.println("Le nom:"+pa.nom);
					pa.prenom=res.getString("prenom");
					pa.dateConsultation=res.getDate("dateConsultation");
					//pa.codeChambre=res.getString("codeChambre");
					pa.nomPresta=res.getString("nomPresta");
					pa.nomCatPresta=res.getString("nomCatPresta");
					pa.observation=res.getString("observation");
					pa.traitement=res.getString("traitement");
					pa.motif=res.getString("motif");
					pa.etat=res.getString("etat");
					pa.nomService=res.getString("nomService");
					
					
					this.listConsulte.add(pa);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
			System.out.println("La selection:"+this.selected);
		
		return listConsulte;
	}






	public void setListConsulte(List<consultation> listConsulte) {
		this.listConsulte = listConsulte;
	}

    



	/*La liste des patients hospitalises*/
	public List<consultation> getListHospitalise() {
		
		this.listHospitalise=new ArrayList<consultation>();
		
		try {
		 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		 
		 
		 this.idMedecin=Integer.parseInt(idUtilisateur);
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String requeteConsulte="select pe.nom,pe.prenom,fi.idFiche,fh.idHosp,fi.dateConsultation,fh.observation,fh.traitement,cha.codeChambre,fh.motif,fi.etat,pa.codePatient,pre.nomPresta,catP.nomCatPresta,se.nomService from fichehosp fh" +
		        " join fichemed fi on fi.idFiche=fh.idFiche" +
		        " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join prestation pre on pre.idPrestation=fi.idPrestation" +
				" join categoriepresta catP on catP.idCatPresta=pre.idCatPresta" +
				" join medecin me on me.idMedecin=fi.idMedecin" +
				" join servicemed sem on sem.idMedecin=me.idMedecin" +
				" join service se on se.idService=sem.idService" +
				" join chambre cha on cha.idChambre=fh.idChambre" +
				" where fi.dateConsultation=CURRENT_DATE() and fi.idMedecin='"+this.idMedecin+"' and fh.status=1" +
				" order by fi.idFiche desc";
		
		System.out.println("la requete sur la listeConsulte:"+requeteConsulte);
		
		      mysql sql=new mysql();
		      
		      ResultSet res=sql.selectbd(requeteConsulte);
		      
		      try {
				while(res.next()){
					
					consultation pa=new consultation();
					
					pa.idHosp=res.getInt("idHosp");
					pa.idFiche=res.getInt("idFiche");
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					pa.dateConsultation=res.getDate("dateConsultation");
					pa.codeChambre=res.getString("codeChambre");
					pa.nomPresta=res.getString("nomPresta");
					pa.nomCatPresta=res.getString("nomCatPresta");
					pa.observation=res.getString("observation");
					pa.traitement=res.getString("traitement");
					pa.motif=res.getString("motif");
					pa.etat=res.getString("etat");
					pa.nomService=res.getString("nomService");
					
					
					this.listHospitalise.add(pa);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		return listHospitalise;
	}






	public void setListHospitalise(List<consultation> listHospitalise) {
		this.listHospitalise = listHospitalise;
	}





     /*Liste des patients au rendez-vous*/
	public List<consultation> getListRendez() {
		
		listRendez=new ArrayList<consultation>();
		
		String requeteRendez="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
		" join patient pa on pa.idPatient=re.idPatient" +
		" join personne pe on pe.idPersonne=pa.idPersonne" +
		" join service se on re.idService=se.idService" +
		" where re.dateRendezVous=CURRENT_DATE() and re.status=1";
		
	 mysql sql=new mysql();
	 
	 ResultSet res=sql.selectbd(requeteRendez);
	 
	 try {
		while(res.next()){
			
			consultation pa=new consultation();
			pa.codePerso=res.getString("codePatient");
			pa.idPatient=res.getInt("idPatient");
			pa.idService=res.getInt("idRendezVous");
			pa.nomService=res.getString("nomService");
			pa.nom=res.getString("nom");
			pa.prenom=res.getString("prenom");
			pa.dateRendezVous=res.getDate("dateRendezVous");
			pa.idRendezVs=res.getInt("idRendezVous");
			
			listRendez.add(pa);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return listRendez;
	}






	public void setListRendez(List<consultation> listRendez) {
		this.listRendez = listRendez;
	}

    
    


      /*Liste des patients au rendez-vous a une date ulterieure*/
	public List<consultation> getListRendezOther() {
		this.listRendezOther=new ArrayList<consultation>();
		
		mysql sql=new mysql();
		
		String requeteRendez="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
		" join patient pa on pa.idPatient=re.idPatient" +
		" join personne pe on pe.idPersonne=pa.idPersonne" +
		" join service se on re.idService=se.idService" +
		" where re.dateRendezVous>CURRENT_DATE() and re.status=1";
		
		ResultSet res=sql.selectbd(requeteRendez);
		
		try {
			while(res.next()){
				
				consultation pa=new consultation();
				pa.codePerso=res.getString("codePatient");
				pa.idPatient=res.getInt("idPatient");
				pa.idService=res.getInt("idRendezVous");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.dateRendezVous=res.getDate("dateRendezVous");
				pa.idRendezVs=res.getInt("idRendezVous");
				
				this.listRendezOther.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listRendezOther;
	}






	public void setListRendezOther(List<consultation> listRendezOther) {
		this.listRendezOther = listRendezOther;
	}





     /*Liste des prestations*/
	public List<consultation> getListPrestation() {
		
      this.listPrestation=new ArrayList<consultation>();
		
		String requetePrestation="select pre.idPrestation,pre.nomPresta,cat.nomCatPresta,pri.prix,pri.idPrix from prestation pre" +
				" join categoriepresta cat on pre.idCatPresta=cat.idCatPresta" +
				" join prix pri on pre.idPrix=pri.idPrix" +
				" where cat.nomCatPresta!='consultation'" +
				" order by pre.idPrestation desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requetePrestation);
		
		try {
			while(res.next()){
				
				consultation pa=new consultation();
				
				pa.idPrestation=res.getInt("idPrestation");
				pa.nomPresta=res.getString("nomPresta");
				pa.nomCatPresta=res.getString("nomCatPresta");
				pa.prix=res.getInt("prix");
				pa.idPrix=res.getInt("idPrix");
				
				this.listPrestation.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPrestation;
	}






	public void setListPrestation(List<consultation> listPrestation) {
		this.listPrestation = listPrestation;
	}

    
	
	
	 /*Liste des patients au rendez-vous dans le service du medecin*/
	
	public List<consultation> getListPatientSerMed() {
		
		this.listPatientSerMed=new ArrayList<consultation>();
		
		try {
		 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		this.idMedecin=Integer.parseInt(idUtilisateur);
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		String requetePatient="select pe.nom,pe.prenom,pa.idPatient,pa.codePatient,me.idMedecin,se.nomService,re.idRendezVous,re.dateRendezVous,re.status from rendezvous re" +
				              " join patient pa on pa.idPatient=re.idPatient" +
				              " join personne pe on pe.idPersonne=pa.idPersonne" +
				              " join service se on se.idService=re.idService" +
				              " join servicemed sem on sem.idService=se.idService" +
				              " join medecin me on me.idMedecin=sem.idMedecin" +
				              " where re.dateRendezVous=CURRENT_DATE() and me.idMedecin='"+this.idMedecin+"'" +
				              " order by re.idRendezVous desc";
				             
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requetePatient);
		
		try {
			while(res.next()){
				
				
				consultation pa=new consultation();
				
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.idPatient=res.getInt("idPatient");
				pa.codePerso=res.getString("codePatient");
				pa.nomService=res.getString("nomService");
				pa.idRendezVs=res.getInt("idRendezVous");
				pa.dateRendezVous=res.getDate("dateRendezVous");
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
				
				this.listPatientSerMed.add(pa);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPatientSerMed;
	}






	public void setListPatientSerMed(List<consultation> listPatientSerMed) {
		
		this.listPatientSerMed = listPatientSerMed;
	}
	
	
	
	
	
	
	
	
	/*Liste des patients au rendez-vous dans le service du medecin a une date ulterieure*/
	public List<consultation> getListPatientSerMedOther() {
		
		this.listPatientSerMedOther=new ArrayList<consultation>();
		   
		try {
		
				FacesContext context = FacesContext.getCurrentInstance();
				 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
				 
				 String idUtilisateur=session.getAttribute("idMedecin").toString();
				  
				this.idMedecin=Integer.parseInt(idUtilisateur);
				
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		String requetePatient="select pe.nom,pe.prenom,pa.idPatient,pa.codePatient,me.idMedecin,se.nomService,re.idRendezVous,re.dateRendezVous,re.status from rendezvous re" +
					        " join patient pa on pa.idPatient=re.idPatient" +
					        " join personne pe on pe.idPersonne=pa.idPersonne" +
					        " join service se on se.idService=re.idService" +
					        " join servicemed sem on sem.idService=se.idService" +
					        " join medecin me on me.idMedecin=sem.idMedecin" +
					        " where re.dateRendezVous>CURRENT_DATE() and me.idMedecin='"+this.idMedecin+"'" +
					        " order by re.idRendezVous desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requetePatient);
		
		try {
			while(res.next()){
				
                consultation pa=new consultation();
				
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.idPatient=res.getInt("idPatient");
				pa.codePerso=res.getString("codePatient");
				pa.nomService=res.getString("nomService");
				pa.idRendezVs=res.getInt("idRendezVous");
				pa.dateRendezVous=res.getDate("dateRendezVous");
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
				
				this.listPatientSerMedOther.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPatientSerMedOther;
	}






	public void setListPatientSerMedOther(List<consultation> listPatientSerMedOther) {
		this.listPatientSerMedOther = listPatientSerMedOther;
	}





     /*Liste du nombre des patients a une date d'aujourd'hui*/
	public List<consultation> getListCompteur() {
		

		try {
			
			FacesContext context = FacesContext.getCurrentInstance();
			 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
			 
			 String idUtilisateur=session.getAttribute("idMedecin").toString();
			  
			this.idMedecin=Integer.parseInt(idUtilisateur);
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		this.listCompteur=new ArrayList<consultation>();
		
		String requeteCompteur="select count(*)as compteur from rendezvous re" +
					        " join patient pa on pa.idPatient=re.idPatient" +
					        " join personne pe on pe.idPersonne=pa.idPersonne" +
					        " join service se on se.idService=re.idService" +
					        " join servicemed sem on sem.idService=se.idService" +
					        " join medecin me on me.idMedecin=sem.idMedecin" +
					        " where re.dateRendezVous=CURRENT_DATE() and me.idMedecin='"+this.idMedecin+"' and re.status=1" +
					        " order by re.idRendezVous desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteCompteur);
		
		try {
			while(res.next()){
				consultation pa=new consultation();
				
				pa.compteur=res.getInt("compteur");
				
				
				this.listCompteur.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCompteur;
	}






	public void setListCompteur(List<consultation> listCompteur) {
		this.listCompteur = listCompteur;
	}
	
	
	
	public List<consultation> getListCompteurOther() {
		
		this.listCompteurOther=new ArrayList<consultation>();
		
		try {
		FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		this.idMedecin=Integer.parseInt(idUtilisateur);
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		String requeteCompteur="select count(*)as compteur from rendezvous re" +
        " join patient pa on pa.idPatient=re.idPatient" +
        " join personne pe on pe.idPersonne=pa.idPersonne" +
        " join service se on se.idService=re.idService" +
        " join servicemed sem on sem.idService=se.idService" +
        " join medecin me on me.idMedecin=sem.idMedecin" +
        " where re.dateRendezVous>CURRENT_DATE() and me.idMedecin='"+this.idMedecin+"' and re.status=1 " +
        " order by re.idRendezVous desc";
		
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteCompteur);
		
		try {
			while(res.next()){
				consultation pa=new consultation();
				
				pa.compteur=res.getInt("compteur");
				
				this.listCompteurOther.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCompteurOther;
	}






	public void setListCompteurOther(List<consultation> listCompteurOther) {
		this.listCompteurOther = listCompteurOther;
	}

	
	
	 public List<consultation> getListCompteurOtherDate() {
		 
		 this.listCompteurOtherDate=new ArrayList<consultation>();
		 
		 String requeteOther="select count(*)as compteur from rendezvous re" +
	        " join patient pa on pa.idPatient=re.idPatient" +
	        " join personne pe on pe.idPersonne=pa.idPersonne" +
	        " join service se on se.idService=re.idService" +
	        " join servicemed sem on sem.idService=se.idService" +
	        " join medecin me on me.idMedecin=sem.idMedecin" +
	        " where re.dateRendezVous like '"+this.traitementDate(this.dateSearch)+"%' and re.dateRendezVous>CURRENT_DATE()  and me.idMedecin='"+this.idMedecin+"' and re.status=1 " +
	        " order by re.idRendezVous desc";
		 
		 
		 mysql sql=new mysql();
		 
		 ResultSet res=sql.selectbd(requeteOther);
		 
		 System.out.println(requeteOther);
		 try {
			while(res.next()){
				 
				consultation pa=new consultation();
				
				pa.compteur=res.getInt("compteur");
				
				this.listCompteurOtherDate.add(pa);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			return listCompteurOtherDate;
		}






    public void setListCompteurOtherDate(List<consultation> listCompteurOtherDate) {
			this.listCompteurOtherDate = listCompteurOtherDate;
		}
	
	
	 /*La liste des antecedents des patients*/
	public List<consultation> getListAntecedentPatient() {
		 
		 this.listAntecedentPatient=new ArrayList<consultation>();
		  String requeteAntecedent="select pe.nom,pe.prenom,pe.genre,pe.date_Naissance,pe.tel_fixe,pe.tel_mob,pe.adresse,pe.email,pa.idPatient,re.idRendezVous,pa.codePatient,pre.nomPresta," +
		  		                   "fi.observation,fi.traitement,fi.motif,fi.etat,fi.dateconsultation from fichemed fi" +
		  		                   " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
		  		                   " join patient pa on pa.idPatient=re.idPatient" +
		  		                   " join personne pe on pe.idPersonne=pa.idPersonne" +
		  		                   " join prestation pre on pre.idPrestation=fi.idPrestation" +
		  		                   " where pe.nom like '"+this.rechercheValue+"%'" +
		  		                   " or pe.prenom like '"+this.rechercheValue+"%'" +
		  		                   " or pa.codePatient like '"+this.rechercheValue+"%'";
		  
		  mysql sql=new mysql();
		  consultation cur=new consultation();
		  ResultSet res=sql.selectbd(requeteAntecedent);
		  cur.setCodePerso("");
		  try {
			while(res.next()){
				
				consultation pa=new consultation();
				
				
				
				if(!cur.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
					
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					pa.genre=res.getString("genre");
					pa.dateNaissance=res.getDate("date_Naissance");
				
				}	
				cur.setCodePerso(res.getString("codePatient"));
				pa.telFixe=res.getString("tel_fixe");
				pa.telMob=res.getString("tel_mob");
				pa.adresse=res.getString("adresse");
				pa.email=res.getString("email");
				pa.nomPresta=res.getString("nomPresta");
				pa.observation=res.getString("observation");
				pa.traitement=res.getString("traitement");
				pa.motif=res.getString("motif");
				pa.etat=res.getString("etat");
				pa.dateConsultation=res.getDate("dateConsultation");
				pa.idRendezVs=res.getInt("idRendezVous");
				pa.idPatient=res.getInt("idPatient");
				
				this.listAntecedentPatient.add(pa);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  		                   
			return listAntecedentPatient;
		}






	 public void setListAntecedentPatient(List<consultation> listAntecedentPatient) {
			this.listAntecedentPatient = listAntecedentPatient;
		}
	
	
	
	
	 /*La liste des details sur les informations sur le patient*/
	 
	 public List<consultation> getListDetailsPatient() {
		 
		 try{
			 
			 this.idPatient=this.selected.idPatient;
			 
		 }catch(NullPointerException e){
			 
			 //e.printStackTrace();
		 }
		 
		 
		 
		 System.out.println("L'idPatient"+idPatient);
		 this.listDetailsPatient=new ArrayList<consultation>();
		 
		 String requetePatient="select pe.nom,pe.prenom,pa.profession,pe.email,pe.date_naissance,pe.tel_fixe,pe.tel_mob,pe.adresse,pa.codePatient from patient pa" +
		 		               " join personne pe on pe.idPersonne=pa.idPersonne" +
		 		               " where pa.idPatient='"+this.idPatient+"'";
		 
		   mysql sql=new mysql();
		   
		   ResultSet res=sql.selectbd(requetePatient);
		   
		   
		   
		   try {
			while(res.next()){
				
				consultation pa=new consultation();
				
                 
                 
				pa.codePerso=res.getString("codePatient");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.profession=res.getString("profession");
				pa.email=res.getString("email");
				pa.telFixe=res.getString("tel_fixe");
				pa.telMob=res.getString("tel_mob");
				pa.adresse=res.getString("adresse");
				pa.dateNaissance=res.getDate("date_naissance");
				
				this.listDetailsPatient.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listDetailsPatient;
		}






		public void setListDetailsPatient(List<consultation> listDetailsPatient) {
			this.listDetailsPatient = listDetailsPatient;
		}






		public List<consultation> getListDetailsRendez() {
			
			 try{
				 
				 this.idPatient=this.selected.idPatient;
				 
			 }catch(NullPointerException e){
				 
				// e.printStackTrace();
			 }
			 
			this.listDetailsRendez=new ArrayList<consultation>();
			
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
					
					consultation pa=new consultation();
					
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






		public void setListDetailsRendez(List<consultation> listDetailsRendez) {
			this.listDetailsRendez = listDetailsRendez;
		}



		public List<consultation> getListRechercheInfo() {
			this.listRechercheInfo=new ArrayList<consultation>();
			
			String requeteRecherche="select pe.nom,pe.prenom,pe.date_naissance,pe.adresse,pe.email,pa.profession," +
				                    " pa.codePatient,pa.idPatient,re.dateRendezVous,se.nomService,re.status,fi.dateConsultation,fi.traitement,pre.nomPresta,fi.fait,fi.etat from patient pa" +
				                    " join personne pe on pe.idPersonne=pa.idPersonne" +
				                    " join rendezvous re on re.idPatient=pa.idPatient" +
				                    " join service se on se.idService=re.idService" +
				                    " join fichemed fi on fi.idRendezVous=re.idRendezVous" +
				                    " join prestation pre on pre.idPrestation=fi.idPrestation" +
				                    " where pe.nom like '"+this.searchValue+"%'" +
			  		                " or pe.prenom like '"+this.searchValue+"%'" +
			  		                " or pa.codePatient like '"+this.searchValue+"%'"+
				                    " order by pa.idPatient desc";
			
			
			mysql sql=new mysql();
			
			ResultSet res=sql.selectbd(requeteRecherche);
			
			consultation cur=new consultation();
			cur.setCodePerso("");
			try {
				while(res.next()){
					
					consultation pa=new consultation();
					
                    if(!cur.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
						
						pa.codePerso=res.getString("codePatient");
						pa.nom=res.getString("nom");
						pa.prenom=res.getString("prenom");
						pa.dateNaissance=res.getDate("date_naissance");
						pa.adresse=res.getString("adresse");
						pa.email=res.getString("email");
						pa.profession=res.getString("profession");
					
					}
                    
                    cur.setCodePerso(res.getString("codePatient"));
                    
                    pa.idPatient=res.getInt("idPatient");
					pa.dateRendezVous=res.getDate("dateRendezVous");
					pa.nomService=res.getString("nomService");
					pa.status=res.getBoolean("status");
					pa.traitement=res.getString("traitement");
					pa.nomPresta=res.getString("nomPresta");
					pa.fait=res.getBoolean("fait");
					pa.etat=res.getString("etat");
					pa.dateConsultation=res.getDate("dateConsultation");
					
					
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
                    
                    if(pa.fait==true){
                        
                    	pa.viewbool=true;
                    	pa.faitValue="Déjà executé";
                    }
                    else{
                    	
                    	pa.viewbool=false;
                    	pa.faitValue="Non executé";
                    }
					this.listRechercheInfo.add(pa);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listRechercheInfo;
		}






	    public void setListRechercheInfo(List<consultation> listRechercheInfo) {
			this.listRechercheInfo = listRechercheInfo;
		}


		
	 
	
	/*La methode qui recupere les informations sur le patient*/
	   
	    public ArrayList<consultation>suggestionPatientInfo(Object prefix){
			
			String keyword=((String)prefix).toLowerCase();
			
			
			ArrayList<consultation>suggestions=new ArrayList<consultation>();
			
			List<consultation>tous=this.getListRechercheInfo();
			
			try{
				
			for(consultation reponse:tous){
				
				if(reponse.codePerso.toLowerCase().startsWith(keyword)||reponse.nom.toLowerCase().startsWith(keyword)||reponse.prenom.toLowerCase().startsWith(keyword)){
					
					suggestions.add(reponse);
				}
				
			}
			
           }catch(NullPointerException e){
				
				e.printStackTrace();
			}
			return suggestions;
		}
	 
	 
	 /*La methode qui recupere la liste des prestations*/
	
	
     public ArrayList<consultation>suggestionPrestation(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		
		ArrayList<consultation>suggestions=new ArrayList<consultation>();
		
		List<consultation>tous=this.getListPrestation();
		
		for(consultation reponse:tous){
			
			if(reponse.nomCatPresta.toLowerCase().startsWith(keyword)||reponse.nomPresta.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
			
		}
		
		
		return suggestions;
	}


	public String getDecisionValue() {
		return decisionValue;
	}






	public void setDecisionValue(String decisionValue) {
		this.decisionValue = decisionValue;
	}



   /* La methode qui gere la liste de suggestions des patients pour les rendez-vous d'aujourd'hui*/
			
	public ArrayList<consultation>suggestionRendez(Object prefix){
				
		String keyword=((String)prefix).toLowerCase();
				
		ArrayList<consultation>suggestions=new ArrayList<consultation>();
				
		List<consultation> tous=this.getListRendez();
				
		for(consultation reponse:tous){
					
			if(reponse.codePerso.startsWith(keyword)||reponse.nom.toLowerCase().startsWith(keyword)||reponse.prenom.toLowerCase().startsWith(keyword)||reponse.nomService.toLowerCase().startsWith(keyword)){
						
				suggestions.add(reponse);
			}
				
		}
				
		return suggestions;
	}
	

 /*La methode qui retourne la liste de suggestions des patients pour les rendez-vous d'autres jour*/
	
	public ArrayList<consultation>suggestionRendezOther(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		ArrayList<consultation>suggestions=new ArrayList<consultation>();
		
		List <consultation> tous=this.getListRendezOther();
		
		for(consultation reponse:tous){
			
			if(reponse.codePerso.startsWith(keyword)||reponse.nom.toLowerCase().startsWith(keyword)||reponse.prenom.toLowerCase().startsWith(keyword)||reponse.nomService.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
			
		}
		
		return suggestions;
	}
			
			
	/*La methode pour gerer la partie consultation*/
	public void consultationClicked(){
    	
    	this.consultation=true;
    	this.verification=false;
    	this.recherche=false;
    	this.liberation=false;
    }
     /*La methode pour gerer la partie verification*/
    
    public void verificationClicked(){
    	
    	this.consultation=false;
    	this.verification=true;
    	this.recherche=false;
    	this.liberation=false;
    }
    
    public void rechercheClicked(){
    	
    	this.recherche=true;
    	this.verification=false;
    	this.consultation=false;
    	this.liberation=false;
    	
    }
    
    public void liberationCLicked(){
    	
    	this.liberation=true;
    	this.consultation=false;
    	this.verification=false;
    	this.recherche=false;
    }
    
/*La methode qui ecoute les evenements des boutons radio non hospitalisation et hospitalisation*/
	
	public void decisionClicked(ValueChangeEvent event){
		
		String valueReceive=""+event.getNewValue();
		this.decision=false;
		
		if(valueReceive.equalsIgnoreCase("1")){
			
			this.decision=true;
		}
		else{
			
			this.decision=false;
		}
		
	}
	
/* La methode qui gere l'insertion les travaux et prestations des medecins  */
	
	


	public void consultationReceive(){
		
		
		
		
		
		if(this.codePerso==""){
			this.message="Veuillez selectionner un patient!";
			System.out.println(this.message);
			this.error=true;
			return;
		}
		
		if(this.observation==""){
			
			this.message="Veuillez completer le champ observation!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.traitement==""){
			this.message="Veuillez completer le champ traitement!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.nomPresta==""){
			
			this.message="Veuillez choisir une prestation!";
			this.error=true;
			return;
		}
		if(this.decisionValue==""){
			
			this.message="Veuillez prendre une decision!";
			System.out.println();
			this.error=true;
			
			
			
			return;
			
		}
		
		if(this.motif==""&& this.decision==true){
			
			this.message="Veuillez mettre le motif d'hospitalisation!";
			this.error=true;
			return;
		}
		
		if(this.etat=="" && this.decision==true){
			
			this.message="Veuillez mettre l'etat du patient!";
			this.error=true;
			return;
		}
		if(this.idChambre==0 && this.decision==true){
			
			this.message="Aucune chambre n'est libre!";
			this.error=true;
			return;
		}
	try{
		
		this.nomPresta=this.selected.nomPresta;
		this.idPrestation=this.selected.idPrestation;
		
		if(this.consultationList==null)
			this.consultationList=new ArrayList<consultation>();
			
		
		
		consultation f=new consultation();
		
		f.observation=this.observation;
		f.traitement=this.traitement;
		f.nomPresta=this.nomPresta;
		f.idPrestation=this.idPrestation;
		f.motif=this.motif;
		f.etat=this.etat;
		if(this.decision==true){
			
			f.codeChambre=this.codeChambre;
		}
		else{
			
			f.codeChambre="";	
		}
			
				
		this.consultationList.add(f);
		
		System.out.println(this.observation+" "+this.traitement);
		System.out.println("La prestation:"+f.nomPresta);
		
		this.message="Information bien transmise!";
		this.error=true;
		
		
		
		this.observation="";
		this.traitement="";
		this.nomPresta="";
		this.nomCatPresta="";
		this.motif="";
		this.etat="";
		this.prix=0;
		
		
		  } catch(NullPointerException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println("Erreur");
		  }
		
		
	}
    
	
		/*La methode qui gere le type date */
			
		    public String traitementDate(Date data){
				
				if(data==null)
				  return "";
				java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
				
				return form.format(data);
			}
		
      /*La methode qui gere le type date */
			
		    public String traitementDateConvertie(Date data){
				
				if(data==null)
				  return "";
				java.text.SimpleDateFormat form= new SimpleDateFormat("dd-MM-yyyy");
				
				return form.format(data);
			}
		    
	
   /*La methode qui enregistre les consultations*/
	
	public void saisiConsultation(){
		
		System.out.println("Methode appele");
		
		
        
 /* try{*/	
		
	  
	  FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		 
		 
		 this.idMedecin=Integer.parseInt(idUtilisateur);
		  
		 
		/* if(this.idMedecin==0){
			this.message="Pas de session!";
			System.out.println("Pas de session!");
			this.error=true;
			return;
		}*/
		  System.out.println("L'id du medecin: "+idUtilisateur);
		
		

			this.dateConsultation=new Date();
			this.dateArrive=new Date();
			int updateValid=-1;
			int updateRendez=-1;
			int updateChambre=-1;
			int updateHosp=-1;
			
			
			mysql sql=new mysql();
		
		
		
		if(this.codePerso==""){
			this.message="Veuillez selectionner un patient!";
			System.out.println(this.message);
			this.error=true;
			return;
		}
		
		if(this.consultationList==null){
			
			this.message="Vous  n'avez pas fait la consultation";
			System.out.println(this.message);
			this.error=true;
			return;
		}
		String requeteUpdateRendez="update rendezvous set status=0 where idRendezVous='"+this.idRendezVs+"'";
		
		updateRendez=sql.updatebd(requeteUpdateRendez);
		
		
		System.out.println(requeteUpdateRendez);
		
		
		if(updateRendez!=-1){
			
			System.out.println("Status changé");
		}
		else
		{
			
			System.out.println("Status inchangé");
		}
	
		System.out.println("La liste:"+this.consultationList);
		  
		for(consultation f1:this.consultationList){
			
			if(f1==null){
				
				this.message="Vous  n'avez pas fait la consultation";
				System.out.println(this.message);
				this.error=true;
				return;
			}
			
			if(this.decisionValue.equalsIgnoreCase("0")){
				
				String requeteConsultation="insert into  fichemed(idRendezVous,idMedecin,observation,traitement,idPrestation,fait,dateConsultation,status) " +
				" values('"+this.idRendezVs+"','"+this.idMedecin+"','"+f1.observation.toUpperCase()+"','"+f1.traitement.toUpperCase()+"','"+f1.idPrestation+"',0,'"+this.traitementDate(dateConsultation)+"',0)";
			
				
				
				
			
			updateValid=sql.updatebd(requeteConsultation);
			
			if(updateValid!=-1){
				
				System.out.println(requeteConsultation);
				this.message="Le patient "+this.nom+" "+this.prenom+"  a ete consulte";
				System.out.println(this.message);
				this.error=true;
				
			}
			
			
			}
			else{
				
				String requeteUpdateChambre="update chambre set status=0 where idChambre='"+this.idChambre+"'";
				
				updateChambre=sql.updatebd(requeteUpdateChambre);
				
				if(updateChambre!=-1){
					
					System.out.println("La chambre est occupé");
				}
				
				String requeteHospitalisation="insert into  fichemed(idRendezVous,idMedecin,observation,traitement,idPrestation,fait,motif,etat,dateConsultation,status) " +
					" values('"+this.idRendezVs+"','"+this.idMedecin+"','"+f1.observation.toUpperCase()+"','"+f1.traitement.toUpperCase()+"','"+f1.idPrestation+"',0,'"+f1.motif.toUpperCase()+"','"+f1.etat.toUpperCase()+"','"+this.traitementDate(dateConsultation)+"',1)";
			   
				
				
				
				System.out.println("la requete:"+requeteHospitalisation);
				updateValid=sql.updatebd(requeteHospitalisation);
				
				if(updateValid!=-1){
					
					String requeteFiche="select idFiche from fichemed order by idFiche desc limit 1";
					
					ResultSet resFiche=sql.selectbd(requeteFiche);
					
					try {
						if(resFiche.next()){
							
							this.idFiche=resFiche.getInt("idFiche");
							System.out.println("Le dernier idFiche:"+idFiche);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String requeteFicheH="insert into fichehosp(idFiche,idChambre,dateArrive,observation,traitement,idPrestation,motif,status) " +
							"values ('"+this.idFiche+"','"+this.idChambre+"','"+this.traitementDate(dateArrive)+"','"+f1.observation.toUpperCase()+"','"+f1.traitement.toUpperCase()+"','"+f1.idPrestation+"','"+f1.motif.toUpperCase()+"',1)";
					
					updateHosp=sql.updatebd(requeteFicheH);
					if(updateHosp!=-1){
						
						
						System.out.println(requeteHospitalisation);
						this.message="Le patient "+this.nom+" "+this.prenom+" a ete consulte et hospitalise";
						this.error=true;
						
						System.out.println(this.message);
						
					}
					
					
					
					
				}
			
			}
		}
		
		
		 
		 
		 
	   /*}catch(NullPointerException e){
		
	 	 e.printStackTrace();
	 	 System.out.println("NullPointerException");
	 	 this.message="Pas de session,Veuillez vous connecter!";
	 	 System.out.println(this.message);
	 	 this.error=true;
	  }	*/	
		
	   this.consultationList=new ArrayList<consultation>();
	}
	
	
	
	
	/*La methode qui permet de modifier la consultation*/
	
	public void modifierConsultation(){
		int updateValid=-1;
		
		mysql sql=new mysql();
		
		
        
		
		System.out.println("Methode de modification appelee");
		
		this.idFiche=this.selected.idFiche;
		this.codePerso=this.selected.codePerso;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.observation=this.selected.observation;
		this.traitement=this.selected.traitement;
		this.idPrestation=this.selected.idPrestation;
		this.nomPresta=this.selected.nomPresta;
		System.out.println("Le nom de la prestation:"+this.nomPresta);
		
		System.out.println("Le code du patient:"+this.codePerso);
		System.out.println("Le nom du patient:"+this.nom);
		
		
		
		
        if(this.observation==""){
			
			this.message="Veuillez completer le champ observation!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.traitement==""){
			this.message="Veuillez completer le champ traitement!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.nomPresta==""){
			
			this.message="Veuillez choisir une prestation!";
			this.error=true;
			return;
		}
		String requetePrestation="select idPrestation from prestation where nomPresta='"+this.nomPresta+"'";
		
		ResultSet res=sql.selectbd(requetePrestation);
		
		try {
			if(res.next()){
				
				this.idPrestation=res.getInt("idPrestation");
				System.out.println("L'idPrestation:"+this.idPrestation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String requeteModifier="update fichemed set observation='"+this.observation+"',traitement='"+this.traitement+"',idPrestation='"+this.idPrestation+"' where idFiche='"+this.idFiche+"' ";
		
		System.out.println("la requete de modifier:"+requeteModifier);
		
		
		updateValid=sql.updatebd(requeteModifier);
		
		if(updateValid!=-1){
			
			this.message="La modification est reussie!";
			this.error=true;
		}
		else{
			
			this.message="La modification a echoue";
		}
		
		
		this.idFiche=0;
		this.codePerso="";
		this.nom="";
		this.prenom="";
		this.observation="";
		this.traitement="";
		this.idPrestation=0;
		this.nomPresta="";
		
	}
	
	
	/*La methode qui modifie la formulaire hospitalisation*/
	public void modifierHospitalisation(){
		
    int updateValid=-1;
		
		mysql sql=new mysql();
		
		
        
		
		System.out.println("Methode de modification appelee");
		
		this.idHosp=this.selected.idHosp;
		this.idFiche=this.selected.idFiche;
		this.codePerso=this.selected.codePerso;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.observation=this.selected.observation;
		this.traitement=this.selected.traitement;
		this.idPrestation=this.selected.idPrestation;
		this.nomPresta=this.selected.nomPresta;
		this.idChambre=this.selected.idChambre;
		this.motif=this.selected.motif;
		this.etat=this.selected.etat;
		System.out.println("Le nom de la prestation:"+this.nomPresta);
		
		System.out.println("Le code du patient:"+this.codePerso);
		System.out.println("Le nom du patient:"+this.nom);
		
		
		
		
        if(this.observation==""){
			
			this.message="Veuillez completer le champ observation!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.traitement==""){
			this.message="Veuillez completer le champ traitement!";
			System.out.println();
			this.error=true;
			return;
		}
		
		if(this.nomPresta==""){
			
			this.message="Veuillez choisir une prestation!";
			this.error=true;
			return;
		}
		
		
        if(this.motif==""){
			
			this.message="Veuillez mettre le motif d'hospitalisation!";
			this.error=true;
			return;
		}
		
		if(this.etat==""){
			
			this.message="Veuillez mettre l'etat du patient!";
			this.error=true;
			return;
		}  
		String requetePrestation="select idPrestation from prestation where nomPresta='"+this.nomPresta+"'";
		
		ResultSet res=sql.selectbd(requetePrestation);
		
		try {
			if(res.next()){
				
				this.idPrestation=res.getInt("idPrestation");
				System.out.println("L'idPrestation:"+this.idPrestation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String requeteModifier="update fichehosp set observation='"+this.observation+"',traitement='"+this.traitement+"',idPrestation='"+this.idPrestation+"',motif='"+this.motif+"' where idHosp='"+this.idHosp+"' ";
		
		System.out.println("la requete de modifier:"+requeteModifier);
		
		
		updateValid=sql.updatebd(requeteModifier);
		
		if(updateValid!=-1){
			
			this.message="La modification est reussie!";
			this.error=true;
		}
		else{
			
			this.message="La modification a echoue";
			
		}
		
		this.idFiche=0;
		this.codePerso="";
		this.nom="";
		this.prenom="";
		this.observation="";
		this.traitement="";
		this.idPrestation=0;
		this.nomPresta="";
		this.idChambre=0;
		this.motif="";
		this.etat="";
	}
	
	/* La methode pour recuperer les informations de la table des rendez-vous*/
	   public void rendezSelected(){
			
			
				this.idRendezVs=this.selected.idRendezVs;
				this.idPatient=this.selected.idPatient;
				this.codePerso=this.selected.codePerso;
				this.nom=this.selected.nom;
				this.prenom=this.selected.prenom;
				this.idService=this.selected.idService;
				this.nomService=this.selected.nomService;
				this.dateRendezVous=this.selected.dateRendezVous;
				
			
		}
	   
	   
	   /*La methode pour garder les informations de la prestation*/
		
		public void prestationSelected(){
			
			this.idPrestation=this.selected.idPrestation;
			this.nomPresta=this.selected.nomPresta;
			this.idCatPresta=this.selected.idCatPresta;
			this.nomCatPresta=this.selected.nomCatPresta;
			this.idPrix=this.selected.idPrix;
			this.prix=this.selected.prix;
		}
	    
		
		 /*La methode qui initialise le composant consultation*/
		 
	     public void initialiseValue(){
		   
		        this.consultationList=null;
		        this.message="";
		    	this.error=false;
		    	this.nomPresta="";
		    	this.nomCatPresta="";
		    	this.prix=0;
		    	this.nom="";
		    	this.prenom="";
		    	this.codePerso="";
		   
	   }
	     
	     /* La methode qui initialise la page modifierConsultation*/
	     
	    public void initiliseModifier(){
	    	
	    	this.message="";
	    	this.error=false;
	    	
	    }
	    
	    
	    /*La methode qui gere les boutons radios rendez-vous*/
	    
	    public void rendezRadioClicked(ValueChangeEvent event){
	    	
	    	this.choixToday=false;
	    	this.choixVarie=false;
	    	this.codePerso="";
	    	String valueReceive=""+event.getNewValue();
	    	
	    	System.out.println("La valeur recue: "+valueReceive);
	    	
	    	if(valueReceive.equalsIgnoreCase("choixToday")){
	    		
	    		this.choixToday=true;
	    		this.choixVarie=false;
	    		
	    		
	    		this.nom="";
	    		this.prenom="";
	    	}
	    	
	    	else{
	    		
	    		this.choixToday=false;
	    		this.choixVarie=true;
	    		
	    		
	    		this.nom="";
	    		this.prenom="";
	    	}
	    	
	    }
	    
	    
	    public void initiliseSuggestion(){
	    	this.codePerso="";
	    	this.nom="";
	    	this.prenom="";
	    	
	    }
	    
	    
	    /*La methode qui retourne la liste des antecedents des patients*/
	    public void backAntecedentPatient(){
	    	
	    	this.getListAntecedentPatient();
	    }
	    
	   /* La methode qui retourne la liste des patients lors de la recherche*/ 
	   public void backRechercheinfo(){
		   
		   this.getListRechercheInfo();
	   }
	   
	   
	   /* La methode qui retourne le nombre des patients a une date x*/
	   
	   public void backPatientDate(){
		   
		   this.getListCompteurOtherDate();
	   }
	   
	    
	    /*La methode qui garde les informations*/
	    public void patientSelected(){
		 
		 this.idPatient=this.selected.idPatient;
		 this.idRendezVs=this.selected.idRendezVs;
		 this.nom=this.selected.prenom;
		 this.prenom=this.selected.prenom;
		 this.dateNaissance=this.selected.dateNaissance;
		 this.adresse=this.selected.adresse;
		 this.email=this.selected.email;
		 this.profession=this.selected.profession;
		 this.codePerso=this.selected.codePerso;
		 this.dateRendezVous=this.selected.dateRendezVous;
		 this.nomService=this.selected.nomService;
		 this.status=this.selected.status;
		 this.traitement=this.selected.traitement;
		 this.nomPresta=this.selected.nomPresta;
		 this.fait=this.selected.fait;
		 this.etat=this.selected.etat;
		 
		 
		 
	 }
	/*Le constructeur de la classe */
	public consultation(){
		
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
	
	public static void main(String[]args){
		
		Date date=new Date();
		
		consultation con=new consultation();
		
        con.traitementDateConvertie(date);
        
        System.out.println(con.traitementDateConvertie(date));
	}
}
