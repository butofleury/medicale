package saisie;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class infirmier {
	private boolean soin=false;
	private boolean patient=false;
	private boolean recherche=false;
	private boolean rendezVous=true;
	
	private String code;
	private int idPatient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String dateConvertNaiss;
	private String sexe;
	private boolean fait;
	private String statusExecute;
	private int idService;
	private String nomService;
	private int idPrestation;
	private String nomPrestation;
	private int idCatPresta;
	private String nomCatPresta;
	private int idFiche;
	private int idFicheHosp;
	private int idRendezVous;
	private infirmier selectedPatient;
	private String codeChambre;
	private Date dateArrive;//Date d'hospitalisation
	private Date dateAttribution;//Date d'attribution de rendez-vous
	private Date dateRendezVous;//Date de rendez-vous
	private Date dateConsultation;
	private Date dateExecution;
	private List<infirmier> listPatientPrest;
	private List<infirmier> listSoinsPatient;//Liste des soins prescrit par le medecin pour un patient
	private List<infirmier> listSoinsPatExecute;//Liste des soins prescrit par le medecin pour un patient mais déjà executé
	private List<infirmier> listRDVToday;//Liste des rendez-vous d'aujourd'hui
	private List<infirmier> listRDVUlterieur;
	private List<infirmier> listRDVHistorique;
	
	private List<infirmier> listPatientHosp;
	private List<infirmier> listPatientNonHosp;
	
	public infirmier() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
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

	public boolean isSoin() {
		return soin;
	}
	public void setSoin(boolean soin) {
		this.soin = soin;
	}

	public boolean isPatient() {
		return patient;
	}
	public void setPatient(boolean patient) {
		this.patient = patient;
	}

	public boolean isRecherche() {
		return recherche;
	}
	public void setRecherche(boolean recherche) {
		this.recherche = recherche;
	}

	public boolean isRendezVous() {
		return rendezVous;
	}
    public void setRendezVous(boolean rendezVous) {
		this.rendezVous = rendezVous;
	}

    public void rendezVousClicked(){
    	this.rendezVous=true;
    	this.patient=false;
    	this.recherche=false; 
    	this.soin=false;
    	System.out.println("Rendez-vous:"+this.rendezVous);
    }
    
    public void patientClicked(){	
    	this.patient=true;
    	this.rendezVous=false;
    	this.recherche=false;
    	this.soin=false;
    	
    	System.out.println("Patient:"+this.patient);
    }
    
    public void rechercheClicked(){
    	this.recherche=true;
    	this.rendezVous=false;
    	this.patient=false;
    	this.soin=false;
    	
    	System.out.println("Recherche:"+this.recherche);
    }
    
    public void soinClicked(){
    	this.soin=true;
    	this.recherche=false;
    	this.rendezVous=false;
    	this.patient=false;
    	
    	System.out.println("Soins:"+this.soin);
    }

    
	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	
	public String getDateConvertNaiss() {
		return dateConvertNaiss;
	}
	public void setDateConvertNaiss(String dateConvertNaiss) {
		this.dateConvertNaiss = dateConvertNaiss;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public boolean isFait() {
		return fait;
	}
	public void setFait(boolean fait) {
		this.fait = fait;
	}

	public String getStatusExecute() {
		return statusExecute;
	}
	public void setStatusExecute(String statusExecute) {
		this.statusExecute = statusExecute;
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
	

	public int getIdPrestation() {
		return idPrestation;
	}
	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}

	public String getNomPrestation() {
		return nomPrestation;
	}
	public void setNomPrestation(String nomPrestation) {
		this.nomPrestation = nomPrestation;
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
	
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public int getIdRendezVous() {
		return idRendezVous;
	}
	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	
	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	public List<infirmier> getListPatientPrest() {
		this.listPatientPrest=new ArrayList<infirmier>();
		 String req="SELECT * FROM fichemed f JOIN prestation p ON p.idPrestation = f.idPrestation " +
					" JOIN rendezvous r ON r.idRendezVous = f.idRendezVous " +
					" JOIN patient pa ON pa.idPatient = r.idPatient" +
					" JOIN personne pe ON pa.idPersonne = pe.idPersonne " +
					" JOIN service s ON s.idService = r.idService" +
					" WHERE f.fait =0" +
					" GROUP BY pa.idPatient";
		mysql c=new mysql();

		ResultSet res=c.selectbd(req);
		 try {
				while(res.next()){
					infirmier i=new  infirmier();
					
					i.idPatient=res.getInt("idPatient");
					i.code=res.getString("codePatient");
					i.nom=res.getString("nom");
					i.prenom=res.getString("prenom");
					i.dateNaissance=res.getDate("date_naissance");
					i.sexe=res.getString("genre");
					i.nomService=res.getString("nomService");
					i.idService=res.getInt("idService");
					
				//System.out.println(i.idPatient+" "+i.code+" "+i.nom+" "+i.prenom+" "+i.dateNaissance+" "+i.sexe+" "+i.nomService+" "+i.idService);
					this.listPatientPrest.add(i);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listPatientPrest;
	}


	public void setListPatientPrest(List<infirmier> listPatientPrest) {
		this.listPatientPrest = listPatientPrest;
	}

	
	public ArrayList<infirmier> suggestPatientSoin(Object prefix){
	String keyword=((String)prefix).toLowerCase();
		
		ArrayList<infirmier>suggestions=new ArrayList<infirmier>();
		
		List<infirmier>tous=this.getListPatientPrest();
		
		for(infirmier reponse:tous){
			
			if(reponse.code.toLowerCase().startsWith(keyword) || reponse.nom.toLowerCase().startsWith(keyword) || reponse.prenom.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
		}
		return suggestions;
		
	}
	
	public infirmier getSelectedPatient() {
		return selectedPatient;
	}
	public void setSelectedPatient(infirmier selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	
	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public List<infirmier> getListPatientNonHosp() {
		return listPatientNonHosp;
	}

	public void setListPatientNonHosp(List<infirmier> listPatientNonHosp) {
		this.listPatientNonHosp = listPatientNonHosp;
	}

	/*La methode qui gere le type date */
    public String traitementDate(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
	}
    
    public String traitementDateTime(java.util.Date data){
		if(data==null)
			return "";
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return form.format(data);	
	}
	
	public Date getDateAttribution() {
		return dateAttribution;
	}
	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}

	public Date getDateRendezVous() {
		return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	public void patientSelected(){
		this.idPatient=this.selectedPatient.idPatient;
		this.code=this.selectedPatient.code;
		this.nom=this.selectedPatient.nom;
		this.prenom=this.selectedPatient.prenom;
		this.dateConvertNaiss=this.traitementDate(this.selectedPatient.dateNaissance);
		//this.dateNaissance=this.selectedPatient.dateNaissance;
		this.sexe=this.selectedPatient.sexe;
		
		//System.out.println(this.idPatient+" "+this.code+" "+this.dateConvertNaiss+" "+this.sexe);
		//this.idService
	}

	
	

	public List<infirmier> getListSoinsPatient() {
		this.listSoinsPatient=new ArrayList<infirmier>();
		 String req="SELECT * FROM fichemed f " +
		 			" JOIN prestation p ON p.idPrestation = f.idPrestation " +
		 			" JOIN  categoriepresta cp ON cp.idCatPresta=p.idCatPresta" +
					" JOIN rendezvous r ON r.idRendezVous = f.idRendezVous " +
					" JOIN patient pa ON pa.idPatient = r.idPatient" +
					" JOIN personne pe ON pa.idPersonne = pe.idPersonne " +
					" JOIN service s ON s.idService = r.idService" +
					" WHERE cp.nomCatPresta='SOINS' AND pa.idPatient="+this.idPatient+" AND f.fait=0" +
					" ORDER BY f.idFiche DESC";
		// System.out.println(req);
		 mysql c=new mysql();

		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				infirmier i=new  infirmier();
				
				i.idPatient=res.getInt("idPatient");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.dateNaissance=res.getDate("date_naissance");
				i.nomPrestation=res.getString("nomPresta");
				i.dateConsultation=res.getDate("dateConsultation");
				i.dateExecution=res.getDate("dateExecution");
				i.idCatPresta=res.getInt("idCatPresta");
				i.nomCatPresta=res.getString("nomCatPresta");
				i.idFiche=res.getInt("idFiche");
				i.idRendezVous=res.getInt("idRendezVous");
				i.sexe=res.getString("genre");
				i.nomService=res.getString("nomService");
				i.idService=res.getInt("idService");
				i.fait=res.getBoolean("fait");
				
				if(i.fait==true){
				i.statusExecute="Annuler";
				}else{
					i.statusExecute="executer";
				}
				//System.out.println(i.fait+" "+i.statusExecute);
				
				this.listSoinsPatient.add(i);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSoinsPatient;
	}
	public void setListSoinsPatient(List<infirmier> listSoinsPatient) {
		this.listSoinsPatient = listSoinsPatient;
	}
	private infirmier selectedFiche;
	
	public infirmier getSelectedFiche() {
		return selectedFiche;
	}
	public void setSelectedFiche(infirmier selectedFiche) {
		this.selectedFiche = selectedFiche;
	}


	

//	private List<infirmier> listSoinsExecute=new ArrayList<infirmier>();
//	
//	public List<infirmier> getListSoinsExecute() {
//		return listSoinsExecute;
//	}
//	public void setListSoinsExecute(List<infirmier> listSoinsExecute) {
//		this.listSoinsExecute = listSoinsExecute;
//	}


	public List<infirmier> getListSoinsPatExecute() {
		this.listSoinsPatExecute=new ArrayList<infirmier>();
		String req="SELECT * FROM fichemed f " +
		 			" JOIN prestation p ON p.idPrestation = f.idPrestation " +
		 			" JOIN  categoriepresta cp ON cp.idCatPresta=p.idCatPresta" +
					" JOIN rendezvous r ON r.idRendezVous = f.idRendezVous " +
					" JOIN patient pa ON pa.idPatient = r.idPatient" +
					" JOIN personne pe ON pa.idPersonne = pe.idPersonne " +
					" JOIN service s ON s.idService = r.idService" +
					" WHERE cp.nomCatPresta='SOINS' AND pa.idPatient="+this.idPatient+" AND f.fait=1" +
					" ORDER BY f.dateExecution DESC";
		 mysql c=new mysql();
		 System.out.println(req);
			ResultSet res=c.selectbd(req);
			
			try {
				while(res.next()){
					infirmier i=new  infirmier();
					
					i.idPatient=res.getInt("idPatient");
					i.code=res.getString("codePatient");
					i.nom=res.getString("nom");
					i.prenom=res.getString("prenom");
					i.dateNaissance=res.getDate("date_naissance");
					i.nomPrestation=res.getString("nomPresta");
					i.idCatPresta=res.getInt("idCatPresta");
					i.nomCatPresta=res.getString("nomCatPresta");
					i.dateConsultation=res.getDate("dateConsultation");
					i.dateExecution=res.getDate("dateExecution");
					i.dateConvertNaiss=res.getString("dateExecution");
					i.idFiche=res.getInt("idFiche");
					i.idRendezVous=res.getInt("idRendezVous");
					i.sexe=res.getString("genre");
					i.nomService=res.getString("nomService");
					i.idService=res.getInt("idService");
					i.fait=res.getBoolean("fait");
					
					if(i.fait==true){
					i.statusExecute="Annuler";
					}else{
						i.statusExecute="executer";
					}
					//System.out.println(i.fait+" "+i.statusExecute);
					
					this.listSoinsPatExecute.add(i);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listSoinsPatExecute;
	}

	public void setListSoinsPatExecute(List<infirmier> listSoinsPatExecute) {
		this.listSoinsPatExecute = listSoinsPatExecute;
	}

	public void executeSoins(){
		
		java.util.Date d=new java.util.Date();
		System.out.println(this.selectedFiche.fait);
		
		String req1="UPDATE fichemed SET fait=1, dateExecution='"+this.traitementDateTime(d)+"' " +
				   " WHERE idFiche='"+this.selectedFiche.idFiche+"'";
		
		String req2="UPDATE fichemed SET fait=0, dateExecution=NULL " +
					" WHERE idFiche='"+this.selectedFiche.idFiche+"'";
		
		mysql c=new mysql();
		int i=-1;
			if(this.selectedFiche.fait==false){
				i=c.updatebd(req1);
				System.out.println(req1);
			}else{
				i=c.updatebd(req2);
				System.out.println(req2);
			}
		if(i!=-1){
			System.out.println("SoinsP:"+this.selectedFiche.idFiche);
			
		}else{
			System.out.println("Echec d'execution");
		}

		
	}

	


	public List<infirmier> getListRDVToday() {
		this.listRDVToday=new ArrayList<infirmier>();
		String req="SELECT * FROM rendezvous r JOIN patient p ON r.idPatient=p.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN service s ON s.idService=r.idService" +
					" WHERE r.dateRendezVous=CURRENT_DATE()";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		
		try {
			while(res.next()){
				infirmier i=new infirmier();
				
				i.idRendezVous=res.getInt("idRendezVous");
				i.idPatient=res.getInt("idPatient");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.sexe=res.getString("genre");
				i.dateNaissance=res.getDate("date_naissance");
				i.idService=res.getInt("idService");
				i.nomService=res.getString("nomService");
				i.dateAttribution=res.getDate("dateAttribution");
				i.dateRendezVous=res.getDate("dateRendezVous");
				
				this.listRDVToday.add(i);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRDVToday;
	}
	public void setListRDVToday(List<infirmier> listRDVToday) {
		this.listRDVToday = listRDVToday;
	}

	public List<infirmier> getListRDVUlterieur() {
		this.listRDVUlterieur=new ArrayList<infirmier>();
		String req="SELECT * FROM rendezvous r JOIN patient p ON r.idPatient=p.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN service s ON s.idService=r.idService" +
					" WHERE r.dateRendezVous>CURRENT_DATE()";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		
		try {
			while(res.next()){
				infirmier i=new infirmier();
				
				i.idRendezVous=res.getInt("idRendezVous");
				i.idPatient=res.getInt("idPatient");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.sexe=res.getString("genre");
				i.dateNaissance=res.getDate("date_naissance");
				i.idService=res.getInt("idService");
				i.nomService=res.getString("nomService");
				i.dateAttribution=res.getDate("dateAttribution");
				i.dateRendezVous=res.getDate("dateRendezVous");
				
				this.listRDVUlterieur.add(i);
							
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRDVUlterieur;
	}
	public void setListRDVUlterieur(List<infirmier> listRDVUlterieur) {
		this.listRDVUlterieur = listRDVUlterieur;
	}

	public List<infirmier> getListRDVHistorique() {
		this.listRDVHistorique=new ArrayList<infirmier>();
		
		String req="SELECT * FROM rendezvous r JOIN patient p ON r.idPatient=p.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN service s ON s.idService=r.idService" +
					" WHERE r.dateRendezVous<CURRENT_DATE()";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		
		try {
			while(res.next()){
				infirmier i=new infirmier();
				
				i.idRendezVous=res.getInt("idRendezVous");
				i.idPatient=res.getInt("idPatient");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.sexe=res.getString("genre");
				i.dateNaissance=res.getDate("date_naissance");
				i.idService=res.getInt("idService");
				i.nomService=res.getString("nomService");
				i.dateAttribution=res.getDate("dateAttribution");
				i.dateRendezVous=res.getDate("dateRendezVous");
				
				this.listRDVHistorique.add(i);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listRDVHistorique;
	}
	public void setListRDVHistorique(List<infirmier> listRDVHistorique) {
		this.listRDVHistorique = listRDVHistorique;
	}

	
	public int getIdFicheHosp() {
		return idFicheHosp;
	}
	public void setIdFicheHosp(int idFicheHosp) {
		this.idFicheHosp = idFicheHosp;
	}

	public String getCodeChambre() {
		return codeChambre;
	}

	public void setCodeChambre(String codeChambre) {
		this.codeChambre = codeChambre;
	}

	public List<infirmier> getListPatientHosp() {
		this.listPatientHosp=new ArrayList<infirmier>();
		 String req="SELECT * FROM fichehosp fh " +
					" JOIN fichemed fm ON fm.idFiche=fh.idFiche" +
					" JOIN chambre cha ON cha.idChambre=fh.idChambre" +
					" JOIN rendezvous rv ON rv.idRendezVous=fm.idRendezVous" +
					" JOIN service se ON se.idService=rv.idService" +
					" JOIN patient p ON p.idPatient=rv.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" WHERE fh.status=1 GROUP BY p.idPatient";
		 
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(req);
		 
		 try {
			while(res.next()){
				infirmier i=new infirmier();
				
				i.idFicheHosp=res.getInt("idHosp");
				i.idFiche=res.getInt("idFiche");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.nomService=res.getString("nomService");
				i.codeChambre=res.getString("codeChambre");
				i.dateArrive=res.getDate("dateArrive");
				this.listPatientHosp.add(i);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPatientHosp;
	}

	public void setListPatientHosp(List<infirmier> listPatientHosp) {
		this.listPatientHosp = listPatientHosp;
	}
	
	public ArrayList<infirmier> suggestPatHosp(Object prefix){
		String keyword=((String)prefix).toLowerCase();
		ArrayList<infirmier> suggestions=new ArrayList<infirmier>();
		List<infirmier> tousPatHosp=this.getListPatientHosp();
		
		for(infirmier i:tousPatHosp){
			
			if(i.code.startsWith(keyword) || i.nom.toLowerCase().startsWith(keyword) || i.prenom.toLowerCase().startsWith(keyword)){
				suggestions.add(i);
			}
		}
		return suggestions;
		
	}

	public void patHospSelected(){
		this.code=this.selectedPatient.code;
		this.nom=this.selectedPatient.nom;
		this.prenom=this.selectedPatient.prenom;
		
		System.out.println(this.code+" "+this.nom+" "+this.prenom);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infirmier i=new infirmier();
		i.getListSoinsPatient();
		//Date d = new Date("", "", "");
		Calendar cal=new java.util.GregorianCalendar();
		
		//Date d=new Date();
		java.util.Date d=new java.util.Date();
		System.out.println(cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
	}

}
