package saisie;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;


public class medecin {
	private boolean patient = true;
	  private boolean rendezVs = false;
	  private boolean ficheMed=false;
	  private boolean soins=false;
	  
	  public List<medecin> listRendezVous;
	  
	  private int idRendezVous;
	  private String codeP;
	  private String nom;
	  private String prenom;
	  private Date dateNaissance;
	  private Date dateRendezVous;
	  private Date dateAttribution;
	  private boolean decision=false;
	  private int decisionHosp;
	  private int idChambre;
	  private int idPatient;
	  private String message;
	public medecin() {
		// TODO Auto-generated constructor stub
	}

	
	public boolean isPatient() {
		return patient;
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
	

	public boolean isFicheMed() {
		return ficheMed;
	}


	public void setFicheMed(boolean ficheMed) {
		this.ficheMed = ficheMed;
	}


	public boolean isSoins() {
		return soins;
	}


	public void setSoins(boolean soins) {
		this.soins = soins;
	}

	public void rendezVousClicked(){
		this.rendezVs=true;
		this.patient=false;
		this.ficheMed=false;
		this.soins=false;
	System.out.println("Rendez-vous:"+this.rendezVs);
	}
	
	public void patientClicked(){
		this.rendezVs=false;
		this.patient=true;
		this.ficheMed=false;
		this.soins=false;
		System.out.println("Patient:"+this.patient);
	}
	
	public void ficheMedClicked(){
		this.rendezVs=false;
		this.patient=false;
		this.ficheMed=true;
		this.soins=false;
		System.out.println("Fiche:"+this.ficheMed);		
	}
	
	public void soinsClicked(){
		this.rendezVs=false;
		this.patient=false;
		this.ficheMed=false;
		this.soins=true;
	System.out.println("Soins:"+this.soins);			
	}


	
	public int getIdRendezVous() {
		return idRendezVous;
	}


	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}


	public String getCodeP() {
		return codeP;
	}


	public void setCodeP(String codeP) {
		this.codeP = codeP;
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

	

	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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


	public List<medecin> getListRendezVous() {
		 FacesContext context = FacesContext.getCurrentInstance();
		  HttpSession session =(HttpSession)context.getExternalContext().getSession(true);  
		  
		  String idService=session.getAttribute("idS").toString();
		  int idSer=Integer.parseInt(idService);
		  System.out.println("Id Service: "+idSer+"\n");
		this.listRendezVous=new ArrayList<medecin>();
		String getRendezV="SELECT * FROM rendezVous r JOIN patient p ON p.idPatient = r.idPatient " +
						  " JOIN personne pe ON pe.idPersonne = p.idPersonne " +
						  " JOIN service s ON r.idService = s.idService WHERE s.idService='"+idSer+"'" +
						  " ORDER BY r.dateRendezVous DESC";
		mysql c=new mysql();
		ResultSet res=c.selectbd(getRendezV);
			try {
				
				while(res.next()){
					medecin m=new medecin();
					m.idRendezVous=res.getInt("idRendezVous");
					m.codeP=res.getString("codePatient");
					m.nom=res.getString("nom");
					m.prenom=res.getString("prenom");
					m.dateNaissance=res.getDate("date_naissance");
					m.dateAttribution=res.getDate("dateAttribution");
					m.dateRendezVous=res.getDate("dateRendezVous");
		System.out.println(m.idRendezVous+" "+m.codeP+" "+m.nom+" "+m.prenom+" "+m.dateAttribution+" "+m.dateRendezVous);
					this.listRendezVous.add(m);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listRendezVous;
	}


	public void setListRendezVous(List<medecin> listRendezVous) {
		this.listRendezVous = listRendezVous;
	}

	
	
	
	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}
	
	
	public int getDecisionHosp() {
		return decisionHosp;
	}


	public void setDecisionHosp(int decisionHosp) {
		this.decisionHosp = decisionHosp;
	}


	public void decisionChanged(ValueChangeEvent evnt){
		String newDecision=""+evnt.getNewValue();
		System.out.println("Décison:"+newDecision);
		
		if(newDecision.equalsIgnoreCase("1")){
			this.decision=true;
		}else{
			this.decision=false;
		}
}
	

	public int getIdChambre() {
		return idChambre;
	}
	
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	

	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	

	public List<medecin> listRDVtoday;
	
	public List<medecin> getListRDVtoday(){
		FacesContext context = FacesContext.getCurrentInstance();
		  HttpSession session =(HttpSession)context.getExternalContext().getSession(true);  
		  
		  String idService=session.getAttribute("idS").toString();
		  //String idService="2";
		  int idSer=Integer.parseInt(idService);
		  System.out.println("Id Service: "+idSer+"\n");
		  
		this.listRDVtoday=new ArrayList<medecin>();

		String getRendezV="SELECT * FROM rendezVous r " +
						   " JOIN patient p ON p.idPatient = r.idPatient " +
						   " JOIN personne pe ON pe.idPersonne = p.idPersonne" +
						   " JOIN service s ON r.idService = s.idService" +
						   " WHERE s.idService ='"+idSer+"' " +
						   " AND r.dateRendezVous = CURDATE( ) ORDER BY r.dateRendezVous DESC";
		mysql c=new mysql();
		ResultSet res=c.selectbd(getRendezV);
		System.out.println("Rendez-vous:");
		try {
			while(res.next()){
				medecin m=new medecin();
				
				m.idRendezVous=res.getInt("idRendezVous");
				m.idPatient=res.getInt("idPatient");
				m.codeP=res.getString("codePatient");
				m.nom=res.getString("nom");
				m.prenom=res.getString("prenom");
				m.dateNaissance=res.getDate("date_naissance");
				m.dateRendezVous=res.getDate("dateRendezVous");
				
			System.out.println(m.idRendezVous+"-"+m.idPatient+"-"+m.codeP+"-"+m.nom+"-"+m.prenom+"-"+m.dateRendezVous);
				this.listRDVtoday.add(m);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRDVtoday;
	}


	public void setListRDVtoday(List<medecin> listRDVtoday) {
		this.listRDVtoday = listRDVtoday;
	}

	public ArrayList<medecin> suggestRendezVous(Object cle){
		String motCle=((String) cle).toLowerCase();
		ArrayList<medecin> suggest=new ArrayList<medecin>();
		List<medecin> all=this.getListRDVtoday();
		
			for(medecin m:all){
				if(m.codeP.toLowerCase().startsWith(motCle) || m.nom.toLowerCase().startsWith(motCle) || m.prenom.toLowerCase().startsWith(motCle)){
					suggest.add(m);
				}
			}
		return suggest;	
	} 
	
	private medecin selectRdv;
	
	public medecin getSelectRdv() {
		return selectRdv;
	}


	public void setSelectRdv(medecin selectRdv) {
		this.selectRdv = selectRdv;
	}

	public medecin rendezVSelected(){
		this.idPatient=this.selectRdv.idPatient;
		this.codeP=this.selectRdv.codeP;
		this.nom=this.selectRdv.nom;
		this.prenom=this.selectRdv.prenom;
		this.dateNaissance=this.selectRdv.dateNaissance;
		this.consultation=new ArrayList<medecin>();
		System.out.println("Selected rendez-vous:"+this.codeP+" "+this.nom+" "+this.prenom+" "+this.dateNaissance);
		return this;
	}

	private List<medecin> consultation;
	
	
	public List<medecin> getConsultation() {
		return consultation;
	}


	public void setConsultation(List<medecin> consultation) {
		this.consultation = consultation;
	}
	
	private String observation;
	private String traitement;
	private String soinFiche;
	private String etat;
	private String motif;
	
	
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


	public String getSoinFiche() {
		return soinFiche;
	}


	public void setSoinFiche(String soinFiche) {
		this.soinFiche = soinFiche;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public void getConsultationPatient(){
		if(this.consultation==null){
			this.consultation=new ArrayList<medecin>();
		}
		medecin m=new medecin();
		m.idPatient=this.idPatient;
		m.observation=this.observation;
		m.traitement=this.traitement;
		m.soinFiche=this.soinFiche;
		//m.motif=this.motif;
		this.consultation.add(m);
		
		this.observation="";
		this.traitement="";
		this.soinFiche="";
	}
	

	public String traitementDate(Date data){
		if(data==null)
			return "";
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
		
	}
	
	public String traitementDateTime(java.util.Date data){
		if(data==null)
			return "";
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return form.format(data);
		
	}
	
	private java.util.Date dateCons=new java.util.Date();
	
	
	public Date getDateCons() {
		return (java.sql.Date) dateCons;
	}


	public void setDateCons(Date dateCons) {
		this.dateCons = dateCons;
	}

		
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	private int idPCh; //id chambre prix
	private int idCh;
	private int idPrix;
	private String codeCh;
	private int prix;
	private List<medecin> listChambre;
	
	public List<medecin> getListChambre() {
		this.listChambre=new ArrayList<medecin>();
		String req="SELECT * FROM chambrePrix cp, chambre c, prix p " +
				   " WHERE c.idChambre = cp.idChambre AND p.idPrix = cp.idPrix AND cp.idPrix " +
				   " IN (SELECT max( idPrix ) AS prixID FROM chambrePrix GROUP BY idChambre) ORDER BY cp.datePrixChambre DESC LIMIT 0 , 30";
		mysql m=new mysql();
		ResultSet res=m.selectbd(req);
		
			try {
				while(res.next()){
					medecin m1=new medecin();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listChambre;
	}


	public void setListChambre(List<medecin> listChambre) {
		this.listChambre = listChambre;
	}


	public void enregistreCons(){
		int i=-1;
		if(this.consultation!=null){
			 		
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) context.getExternalContext().getSession(true);
		String idMedecin=session.getAttribute("idM").toString();
		int idMed=Integer.parseInt(idMedecin);
		System.out.println("Id Medecin: "+idMed+"\n");
			for(medecin m:this.consultation){
		//this.dateCons=new Date();
				System.out.println("Observation:"+m.observation+" Traitement:"+m.traitement+" Soin:"+m.soinFiche);
		String req="INSERT INTO fichemed(idPatient, idMedecin, observation, traitement, soin, fait, dateConsultation) " +
					" VALUES('"+m.idPatient+"', '"+idMed+"', '"+m.observation+"', '"+m.traitement+"', '"+m.soinFiche+"', '0', '"+this.traitementDateTime(this.dateCons)+"')";
			
		System.out.println(req);
		mysql m1=new mysql();
		 i=m1.updatebd(req);
		 	if(i!=-1){
		 		this.message="Enregistrement effectué";
		 		System.out.println(this.message);
		 	}
		
			}
			this.consultation=new ArrayList<medecin>();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		medecin e=new medecin();
		
		//System.out.println(traitementDate(e.dateCons));
		//e.getListRendezVous();
		//e.getListRDVtoday();
		
	}

}
