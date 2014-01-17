package saisie;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class recherche implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valRecherche;
	private int idPersonne;
	private int idPatient;
	private String codeP;
	private boolean status;
	private boolean medecin;
	private boolean infirmier;
	private boolean receptionnniste;
	private boolean laborantin;
	private int idMedecin;
	private String codeMedecin;
	private String categorie;
	private int idServiceMed;
	private int idInf;
	private int idServiceInf;
	private String codeInf;
	private int idRec;
	private String codeRec;
	private int idLab;
	private String codeLab;
	private String nom;
	private String prenom;
	private String sexe;
	private Date dateNaiss;
	private String adresse;
	private String telFixe;
	private String telMob;
	private String email;
	private String profession;
	private List<recherche> listPat;
	private List<recherche> listDetailPatient;
	private int idService;
	private String nomService;
	private Date dateRendezVous;
	private Date dateAttribution;
	private int montantPayer;
	private int montantRestant;
	private String dateTraite;
	private int idCatPersonne;
	private String userName;
	private String passWord;
	private String confPassWord;
	private recherche selected;
	private String info;
	private List<SelectItem> listServiceItem;
	private List<recherche>listInfoRendez;
	private List<recherche>listInfoConsul;
	private List<recherche>listInfoHospitalise;
	private List<recherche>listInfoSortie;
	private String searchValue;
	private String codePerso;
	private Date dateConsultation;
	private String nomRec;
	private String prenomRec;
	private String nomMed;
	private String prenomMed;
	private String codeChambre;
	private String motif;
	private Date dateArrive;
	private Date dateSortie;
	
	
	public recherche() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Date getDateSortie() {
		return dateSortie;
	}



	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}



	public String getCodeChambre() {
		return codeChambre;
	}



	public void setCodeChambre(String codeChambre) {
		this.codeChambre = codeChambre;
	}



	public String getMotif() {
		return motif;
	}



	public void setMotif(String motif) {
		this.motif = motif;
	}



	public Date getDateArrive() {
		return dateArrive;
	}



	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}



	public String getNomRec() {
		return nomRec;
	}



	public void setNomRec(String nomRec) {
		this.nomRec = nomRec;
	}



	public String getPrenomRec() {
		return prenomRec;
	}



	public void setPrenomRec(String prenomRec) {
		this.prenomRec = prenomRec;
	}



	public String getNomMed() {
		return nomMed;
	}



	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}



	public String getPrenomMed() {
		return prenomMed;
	}



	public void setPrenomMed(String prenomMed) {
		this.prenomMed = prenomMed;
	}



	public Date getDateConsultation() {
		return dateConsultation;
	}



	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}



	public String getCodePerso() {
		return codePerso;
	}



	public void setCodePerso(String codePerso) {
		this.codePerso = codePerso;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}



	public boolean isMedecin() {
		return medecin;
	}
	public void setMedecin(boolean medecin) {
		this.medecin = medecin;
	}



	public boolean isInfirmier() {
		return infirmier;
	}
	public void setInfirmier(boolean infirmier) {
		this.infirmier = infirmier;
	}



	public boolean isReceptionnniste() {
		return receptionnniste;
	}
	public void setReceptionnniste(boolean receptionnniste) {
		this.receptionnniste = receptionnniste;
	}

	public boolean isLaborantin() {
		return laborantin;
	}
	public void setLaborantin(boolean laborantin) {
		this.laborantin = laborantin;
	}

	

	public String getValRecherche() {
		return valRecherche;
	}
	public void setValRecherche(String valRecherche) {
		this.valRecherche = valRecherche;
	}

	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
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

	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getDateTraite() {
		return dateTraite;
	}
	public void setDateTraite(String dateTraite) {
		this.dateTraite = dateTraite;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
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

	public int getIdCatPersonne() {
		return idCatPersonne;
	}
	public void setIdCatPersonne(int idCatPersonne) {
		this.idCatPersonne = idCatPersonne;
	}

	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public int getIdServiceMed() {
		return idServiceMed;
	}
	public void setIdServiceMed(int idServiceMed) {
		this.idServiceMed = idServiceMed;
	}

	

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	private String etat;
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getConfPassWord() {
		return confPassWord;
	}
	public void setConfPassWord(String confPassWord) {
		this.confPassWord = confPassWord;
	}

	

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public recherche getSelected() {
		return selected;
	}
	public void setSelected(recherche selected) {
		this.selected = selected;
	}

	public List<recherche> getListPat() {
		this.listPat=new ArrayList<recherche>();
		//this.valRecherche=this.codeP;
		//this.valRecherche="Masculin";
//		String req="SELECT * FROM personne p JOIN patient pa ON pa.idPersonne=p.idPersonne" +
//				   " WHERE pa.codePatient LIKE '"+this.valRecherche+"%' " +
//				   " OR pa.profession  LIKE '"+this.valRecherche+"%' OR p.nom LIKE '"+this.valRecherche+"%' " +
//				   " OR p.prenom LIKE '"+this.valRecherche+"%' OR p.genre LIKE '"+this.valRecherche+"%' " +
//				   " OR p.date_naissance LIKE '"+this.valRecherche+"%' OR p.tel_fixe LIKE '"+this.valRecherche+"%' " +
//				   " OR p.tel_mob LIKE '"+this.valRecherche+"%' OR p.adresse LIKE '"+this.valRecherche+"%'" +
//				   " OR p.email LIKE '"+this.valRecherche+"%'";
		String req="SELECT * FROM personne p JOIN patient pa ON pa.idPersonne=p.idPersonne";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		try {
			while(res.next()){
				recherche r=new recherche();
				r.idPersonne=res.getInt("idPersonne");
				r.idPatient=res.getInt("idPatient");
				r.codeP=res.getString("codePatient");
				r.nom=res.getString("nom");
				r.prenom=res.getString("prenom");
				r.sexe=res.getString("genre");
				r.dateNaiss=res.getDate("date_naissance");
				r.adresse=res.getString("adresse");
				r.telFixe=res.getString("tel_fixe");
				r.telMob=res.getString("tel_mob");
		System.out.println("Personne:"+r.idPersonne+" "+r.idPatient+" "+r.codeP+" "+r.nom+" "+r.prenom+" "+r.sexe);
				listPat.add(r);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPat;
	}
	public void setListPat(List<recherche> listPat) {
		this.listPat = listPat;
	}
	
	public ArrayList<recherche> suggestPatient(Object cle){
		String motCle=((String) cle).toLowerCase();
		ArrayList<recherche> suggest=new ArrayList<recherche>();
		List<recherche> patTrouve=this.getListPat();
		
		for(recherche s:patTrouve){
			
			if(s.codeP.toLowerCase().startsWith(motCle.toLowerCase()) || s.nom.toLowerCase().startsWith(motCle.toLowerCase()) || s.prenom.toLowerCase().startsWith(motCle.toLowerCase())
			|| s.dateNaiss.toString().toLowerCase().startsWith(motCle.toLowerCase()) || s.sexe.toLowerCase().startsWith(motCle.toLowerCase())){
				suggest.add(s);
			}
			
		}
		return suggest;
	}
	
	public String traitementDate(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);	
	}

	private recherche patientSelected;
	
	public recherche getPatientSelected() {
		return patientSelected;
	}
	public void setPatientSelected(recherche patientSelected) {
		this.patientSelected = patientSelected;
	}
	
	public recherche getPatSelected(){
		this.idPersonne=this.patientSelected.idPersonne;
		this.idPatient=this.patientSelected.idPatient;
		this.codeP=this.patientSelected.codeP;
		this.nom=this.patientSelected.nom;
		this.prenom=this.patientSelected.prenom;
		this.dateNaiss=this.patientSelected.dateNaiss;
		this.dateTraite=this.traitementDate(this.patientSelected.dateNaiss);
		this.adresse=this.patientSelected.adresse;
		this.telFixe=this.patientSelected.telFixe;
		//this.dateNaiss=this.patientSelected.dateNaiss;
		
		System.out.println("Patient selected:"+this.idPersonne+" "+this.idPatient+" "+this.codeP+" "+this.nom+" "+this.prenom+" "+this.adresse);
		return this;
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

	public int getMontantPayer() {
		return montantPayer;
	}
	public void setMontantPayer(int montantPayer) {
		this.montantPayer = montantPayer;
	}

	public int getMontantRestant() {
		return montantRestant;
	}
	public void setMontantRestant(int montantRestant) {
		this.montantRestant = montantRestant;
	}

	public List<recherche> getListDetailPatient() {
		this.listDetailPatient=new ArrayList<recherche>();
		 String req="SELECT * FROM rendezVous r " +
					" JOIN patient p ON p.idPatient=r.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN service s ON s.idService=r.idService" +
					" WHERE p.idPatient='"+this.idPatient+"'" +
					" ORDER BY r.dateRendezVous DESC";
		 mysql m=new mysql();
		 ResultSet res=m.selectbd(req);
		 try {
			while(res.next()){
				 recherche r=new recherche();
				 r.idPersonne=res.getInt("idPersonne");
				 r.idPatient=res.getInt("idPatient");
				 r.nom=res.getString("nom");
				 r.prenom=res.getString("prenom");
				 r.dateNaiss=res.getDate("date_naissance");
				 r.adresse=res.getString("adresse");
				 r.telFixe=res.getString("tel_fixe");
				 r.telMob=res.getString("tel_mob");
				 r.idService=res.getInt("idService");
				 r.nomService=res.getString("nomService");
				 r.dateAttribution=res.getDate("dateAttribution");
				 r.dateRendezVous=res.getDate("dateRendezVous");
				 r.montantPayer=res.getInt("montantPaye");
				 r.montantRestant=res.getInt("montantRestant");
				 this.listDetailPatient.add(r);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDetailPatient;
	}
	public void setListDetailPatient(List<recherche> listDetailPatient) {
		this.listDetailPatient = listDetailPatient;
	}

	public int getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getCodeMedecin() {
		return codeMedecin;
	}
	public void setCodeMedecin(String codeMedecin) {
		this.codeMedecin = codeMedecin;
	}


	public int getIdInf() {
		return idInf;
	}
	public void setIdInf(int idInf) {
		this.idInf = idInf;
	}



	public String getCodeInf() {
		return codeInf;
	}
	public void setCodeInf(String codeInf) {
		this.codeInf = codeInf;
	}

	public int getIdRec() {
		return idRec;
	}
	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getCodeRec() {
		return codeRec;
	}
	public void setCodeRec(String codeRec) {
		this.codeRec = codeRec;
	}

	public int getIdLab() {
		return idLab;
	}
	public void setIdLab(int idLab) {
		this.idLab = idLab;
	}

	public String getCodeLab() {
		return codeLab;
	}
	public void setCodeLab(String codeLab) {
		this.codeLab = codeLab;
	}

	
	public List<SelectItem> getListServiceItem() {
		mysql m=new mysql();
		String req="SELECT * FROM service";
		ResultSet res=m.selectbd(req);
		
		if(this.listServiceItem==null){
			this.listServiceItem=new ArrayList<SelectItem>();
		}else{
			this.listServiceItem.clear();
		}
		try {
			while(res.next()){
				this.idService=res.getInt("idService");
				this.nomService=res.getString("nomService");
				this.listServiceItem.add(new SelectItem(this.idService, this.nomService));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listServiceItem;
	}
	public void setListServiceItem(List<SelectItem> listServiceItem) {
		this.listServiceItem = listServiceItem;
	}

	public void catPersoChanged(ValueChangeEvent evnt){
		String newCat=""+evnt.getNewValue();
		System.out.println("Nouvelle categorie:"+newCat);
		
		if(newCat.equalsIgnoreCase("1")){
			this.medecin=true;
			this.infirmier=false;
			this.laborantin=false;
			this.receptionnniste=false;
		}else{
			if(newCat.equalsIgnoreCase("2")){
				this.infirmier=true;
				this.medecin=false;
				this.laborantin=false;
				this.receptionnniste=false;
		}else{
			if(newCat.equalsIgnoreCase("3")){
				this.receptionnniste=true;
				this.medecin=false;
				this.laborantin=false;
				this.infirmier=false;
		}else{
			this.laborantin=true;
			this.medecin=false;
			this.receptionnniste=false;
			this.infirmier=false;
		}
		  }
			}
	}
	
	public void getUserFound(){
		if(this.idCatPersonne==1){
			this.getListMedTrouve();
		}else{
			if(this.idCatPersonne==2){
				this.getListInfTrouve();
			}else{
				if(this.idCatPersonne==3){
					this.getListRecTrouve();
				}else{
					if(this.idCatPersonne==4){
						this.getListLabTrouve();
						
					}
				}
			}
		}
	}
	//private List<recherche> listPatTrouve;
	private List<recherche> listMedTrouve;
	private List<recherche> listInfTrouve;
	private List<recherche> listRecTrouve;
	private List<recherche> listLabTrouve;
	
//	public void rechercheMed(){
//		
//		this.getListMedTrouve();
//	}
	
	public List<recherche> getListMedTrouve() {
		this.listMedTrouve=new ArrayList<recherche>();
 String req="SELECT * FROM personne p JOIN medecin m ON m.idPersonne=p.idPersonne" +
		    " JOIN serviceMed sm ON sm.idMedecin=m.idMedecin" +
			" JOIN service s ON s.idService=sm.idService" +
			" WHERE m.codeMedecin LIKE '"+this.valRecherche+"%' " +
			" OR p.nom LIKE '"+this.valRecherche+"%' " +
			" OR p.prenom LIKE '"+this.valRecherche+"%' OR p.genre LIKE '"+this.valRecherche+"%' " +
			" OR p.date_naissance LIKE '"+this.valRecherche+"%' OR p.tel_fixe LIKE '"+this.valRecherche+"%' " +
			" OR p.tel_mob LIKE '"+this.valRecherche+"%' OR p.adresse LIKE '"+this.valRecherche+"%'" +
			" OR p.email LIKE '"+this.valRecherche+"%' OR m.categorie LIKE '"+this.valRecherche+"%'" +
			" OR s.nomService LIKE '"+this.valRecherche+"%'" +
			" GROUP BY sm.idMedecin";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		try {
			while(res.next()){
				recherche r=new recherche();
				r.idPersonne=res.getInt("idPersonne");
				r.idMedecin=res.getInt("idMedecin");
				r.codeMedecin=res.getString("codeMedecin");
				r.idService=res.getInt("idService");
				r.nomService=res.getString("nomService");
				r.idServiceMed=res.getInt("idServiceMed");
				r.nom=res.getString("nom");
				r.prenom=res.getString("prenom");
				r.sexe=res.getString("genre");
				r.adresse=res.getString("adresse");
				r.dateNaiss=res.getDate("date_naissance");
				r.categorie=res.getString("categorie");
				r.userName=res.getString("userName");
				r.email=res.getString("email");
				r.telFixe=res.getString("tel_fixe");
				r.telMob=res.getString("tel_mob");
				r.status=res.getBoolean("status");
				
				if(res.getBoolean("status")){
					r.etat="Désactiver";
				}else{
					r.etat="Activer";
				}
				
				this.listMedTrouve.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedTrouve;
	}
	public void setListMedTrouve(List<recherche> listMedTrouve) {
		this.listMedTrouve = listMedTrouve;
	}

	
	public int getIdServiceInf() {
		return idServiceInf;
	}
	public void setIdServiceInf(int idServiceInf) {
		this.idServiceInf = idServiceInf;
	}



	public List<recherche> getListInfTrouve() {
		this.listInfTrouve=new ArrayList<recherche>();
	String req="SELECT * FROM personne p JOIN infirmier i ON i.idPersonne=p.idpersonne" +
			   " JOIN serviceinf si ON si.idInf=i.idInf JOIN service s ON s.idService=si.idService" +
			   " WHERE i.codeInfirmier LIKE '"+this.valRecherche+"%'"+
			   " OR p.nom LIKE '"+this.valRecherche+"%' " +
			   " OR p.prenom LIKE '"+this.valRecherche+"%' OR p.genre LIKE '"+this.valRecherche+"%' " +
				" OR p.date_naissance LIKE '"+this.valRecherche+"%' OR p.tel_fixe LIKE '"+this.valRecherche+"%' " +
				" OR p.tel_mob LIKE '"+this.valRecherche+"%' OR p.adresse LIKE '"+this.valRecherche+"%'" +
				" OR p.email LIKE '"+this.valRecherche+"%' OR p.userName LIKE '"+this.valRecherche+"%'" +
				" OR s.nomService LIKE '"+this.valRecherche+"%'" +
				" GROUP BY si.idInf";
	mysql c=new mysql();
	ResultSet res=c.selectbd(req);
	try {
		while(res.next()){
			recherche r=new recherche();
	r.idPersonne=res.getInt("idPersonne");
	r.idInf=res.getInt("idInf");
	r.idServiceInf=res.getInt("idServiceInf");
	r.idService=res.getInt("idService");
	r.nomService=res.getString("nomService");
	r.codeInf=res.getString("codeInfirmier");
	r.nom=res.getString("nom");
	r.prenom=res.getString("prenom");
	r.sexe=res.getString("genre");
	r.dateNaiss=res.getDate("date_naissance");
	r.telFixe=res.getString("tel_fixe");
	r.telMob=res.getString("tel_mob");
	r.adresse=res.getString("adresse");
	r.userName=res.getString("userName");
	r.email=res.getString("email");
	
	r.status=res.getBoolean("status");
	
	if(res.getBoolean("status")){
		r.etat="Désactiver";
	}else{
		r.etat="Activer";
	}
	
	this.listInfTrouve.add(r);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return listInfTrouve;
	}
	public void setListInfTrouve(List<recherche> listInfTrouve) {
		this.listInfTrouve = listInfTrouve;
	}

	
	public List<recherche> getListRecTrouve() {
		//this.valRecherche="nuko";
		this.listRecTrouve=new ArrayList<recherche>();
		String req="SELECT * FROM personne p JOIN receptionniste r  ON r.idPersonne=p.idPersonne " +
				   " WHERE r.codeRec LIKE '"+this.valRecherche+"%' OR p.nom LIKE '"+this.valRecherche+"%'" +
				   " OR p.prenom LIKE '"+this.valRecherche+"%' OR p.genre LIKE '"+this.valRecherche+"%'" +
				   " OR p.date_naissance LIKE '"+this.valRecherche+"%' OR p.tel_fixe LIKE '"+this.valRecherche+"%' " +
				   " OR p.tel_mob LIKE '"+this.valRecherche+"%' OR p.adresse LIKE '"+this.valRecherche+"%'" +
				   " OR p.email LIKE '"+this.valRecherche+"%' OR p.userName LIKE '"+this.valRecherche+"%'";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				recherche r=new recherche();
				r.idPersonne=res.getInt("idPersonne");
				r.idRec=res.getInt("idRec");
				r.codeRec=res.getString("codeRec");
				r.nom=res.getString("nom");
				r.prenom=res.getString("prenom");
				r.sexe=res.getString("genre");
				r.dateNaiss=res.getDate("date_naissance");
				r.telFixe=res.getString("tel_fixe");
				r.telMob=res.getString("tel_mob");
				r.adresse=res.getString("adresse");
				r.userName=res.getString("userName");
				r.email=res.getString("email");
	
				r.status=res.getBoolean("status");
				
				if(res.getBoolean("status")){
					r.etat="Désactiver";
				}else{
					r.etat="Activer";
				}
				
				this.listRecTrouve.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
;
		return listRecTrouve;
	}
	public void setListRecTrouve(List<recherche> listRecTrouve) {
		this.listRecTrouve = listRecTrouve;
	}
	
	
	public List<recherche> getListLabTrouve() {
		this.listLabTrouve=new ArrayList<recherche>();
String req="SELECT * FROM personne p JOIN laborantin l  ON l.idPersonne=p.idPersonne " +
		   " WHERE l.codeLabo LIKE '"+this.valRecherche+"%' OR p.nom LIKE '"+this.valRecherche+"%'" +
		   " OR p.prenom LIKE '"+this.valRecherche+"%' OR p.genre LIKE '"+this.valRecherche+"%'" +
		   " OR p.date_naissance LIKE '"+this.valRecherche+"%' OR p.tel_fixe LIKE '"+this.valRecherche+"%' " +
		   " OR p.tel_mob LIKE '"+this.valRecherche+"%' OR p.adresse LIKE '"+this.valRecherche+"%'" +
		   " OR p.email LIKE '"+this.valRecherche+"%' OR p.userName LIKE '"+this.valRecherche+"%'";
	mysql c=new mysql();
	ResultSet res=c.selectbd(req);
		if(res==null){
			this.info="Pas de resultat";
		}else{
	try {
		while(res.next()){
			recherche r=new recherche();
			r.idPersonne=res.getInt("idPersonne");
			r.idLab=res.getInt("idLaborantin");
			r.codeLab=res.getString("codeLabo");
			r.nom=res.getString("nom");
			r.prenom=res.getString("prenom");
			r.sexe=res.getString("genre");
			r.dateNaiss=res.getDate("date_naissance");
			r.telFixe=res.getString("tel_fixe");
			r.telMob=res.getString("tel_mob");
			r.adresse=res.getString("adresse");
			r.userName=res.getString("userName");
			r.email=res.getString("email");
			
			r.status=res.getBoolean("status");
			
			if(res.getBoolean("status")){
				r.etat="Désactiver";
			}else{
				r.etat="Activer";
			}
			
			this.listLabTrouve.add(r);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 }
		return listLabTrouve;
	}
	public void setListLabTrouve(List<recherche> listLabTrouve) {
		this.listLabTrouve = listLabTrouve;
	}

	public void modifMedTrouve(){
		this.idPersonne=this.selected.idPersonne;
		this.nom=this.selected.nom;								this.adresse=this.selected.adresse;
		this.prenom=this.selected.prenom;						this.email=this.selected.email;
		this.dateNaiss=this.selected.dateNaiss;			        this.userName=this.selected.userName;
		this.sexe=this.selected.sexe;							//this.passWord=this.selected.passWord;
		this.categorie=this.selected.categorie;					//this.confPassWord=this.selected.confPassWord;
		this.idService=this.selected.idService;					this.idServiceMed=this.selected.idServiceMed;
		this.telFixe=this.selected.telFixe;						this.idMedecin=this.selected.idMedecin;
		this.telMob=this.selected.telMob;
		
		System.out.println("Adresse:"+this.adresse);
		int i=-1, j=-1, k=-1;
		String req1="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"', date_naissance='"+this.traitementDate(this.dateNaiss)+"'," +
				   " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'" +
				   " WHERE idPersonne='"+this.idPersonne+"'";
		
		String req2="UPDATE medecin SET categorie='"+this.categorie+"' WHERE idMedecin='"+this.idMedecin+"'";
		String req3="UPDATE servicemed SET idService='"+this.idService+"', idMedecin='"+this.idMedecin+"'" +
				    " WHERE idServiceMed='"+this.idServiceMed+"'";
		
		String req4="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"', date_naissance='"+this.traitementDate(this.dateNaiss)+"'," +
				    " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'," +
				    " passWord='"+this.passWord+"' WHERE idPersonne='"+this.idPersonne+"'";
		
		//String req5="SELECT COUNT(*) FROM personne WHERE userName='"+this.userName+"'";
//		System.out.println("Req1:"+req1);
//		System.out.println("Req2:"+req2);
//		System.out.println("Req3:"+req3);
//		System.out.println("Req4:"+req4);
//		System.out.println("Req5:"+req5);
		/*Requette qui compte le nombre de fois le userName saisie apparait dans la base de données */
		
		mysql c=new mysql();
		
		if(this.passWord.equals("")){
			if(this.passWord.equals(this.confPassWord)){
		i=c.updatebd(req1);
				System.out.println(req1);
				}else {
					this.info="Veuillez saisir le même mot de passe.";
					System.out.println(req1);
		}
		if(i!=-1){
				if(this.categorie!=""){
					j=c.updatebd(req2);
					System.out.println(req2);
					if(j!=-1){
						this.info="Modification effectuée";
						System.out.println("Ligne 742:"+this.info);
					}
				}
				if(this.idService!=0){
					k=c.updatebd(req3);
					System.out.println(req3);
					if(k!=-1){
						this.info="Modification effectuée";
						System.out.println("Ligne 742:"+this.info);
					}
				}
						}else{
			this.info="Echec de modification";
			System.out.println("Ligne 745:"+this.info);
		}
	}else{
		if(!(this.passWord.equals(this.confPassWord))){
			this.info="Veuillez saisir le même mot de passe.";
			System.out.println("Ligne 750:"+this.info);
		}else{
			i=c.updatebd(req4);
			
			if(i!=-1){
				this.info="Modification effectuée";
				System.out.println("Ligne 756:"+this.info);
				
				if(this.categorie!=""){
					j=c.updatebd(req2);
					
					if(j!=-1){
						this.info="Modification effectuée";
						System.out.println("Ligne 742:"+this.info);
					}
				}
				if(this.idService!=0){
				k=c.updatebd(req3);
					
					if(k!=-1){
						this.info="Modification effectuée";
						System.out.println("Ligne 742:"+this.info);
					}
				}
			}
		}
	}
		
	}

	public void modifInfTrouve(){
		this.idPersonne=this.selected.idPersonne;				this.adresse=this.selected.adresse;
		this.idInf=this.selected.idInf;							this.email=this.selected.email;
		this.idServiceInf=this.selected.idServiceInf;			this.userName=this.selected.userName;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateNaiss=this.selected.dateNaiss;
		this.sexe=this.selected.sexe;
		this.idService=this.selected.idService;
		this.telFixe=this.selected.telFixe;
		this.telMob=this.selected.telMob;
		
		System.out.println("IdPerso:"+this.idPersonne+" IdInf:"+this.idInf+" idServInf:"+this.idServiceInf+" nom:"+this.nom+" prenom:"+this.prenom);
		System.out.println("Date de naissance:"+this.dateNaiss+" Sexe:"+this.sexe+" idService: "+this.idService+" telFixe:"+this.telFixe+" telMob:"+this.telMob);
		System.out.println("Adresse:"+this.adresse+" email:"+this.email+" UserName:"+this.userName);
		
		this.info="";
		int i=-1, j=-1, k=-1;
		System.out.println("IdPerso:"+this.idPersonne+" idInf:"+this.idInf+" idServiceInf:"+this.idServiceInf+" \n Nom:"+this.nom+" " +
				" Prénom:"+this.selected.prenom+" Date de naissance:"+this.traitementDate(this.dateNaiss)+" Sexe:"+this.sexe+" IDService:"+this.idService+"\n" +
						" tel Fixe:"+this.telFixe+" Tel Mob:"+this.telMob+" adresse:"+this.adresse+" Email:"+this.email+" Identifiant:"+this.userName);
		
		String req1="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"', date_naissance='"+this.traitementDate(this.dateNaiss)+"'," +
		   " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'" +
		   " WHERE idPersonne='"+this.idPersonne+"'";
		
		String req2="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"', date_naissance='"+this.traitementDate(this.dateNaiss)+"'," +
	    " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'," +
	    " passWord='"+this.passWord+"' WHERE idPersonne='"+this.idPersonne+"'";
				
		String req3="UPDATE serviceinf SET idService='"+this.idService+"', idInf='"+this.idInf+"'" +
	    			" WHERE idServiceInf='"+this.idServiceInf+"'";
		
			mysql c=new mysql();
			if(this.passWord.equals("")){
				if(this.passWord.equals(this.confPassWord)){
			i=c.updatebd(req1);
					System.out.println(req1);
					}else {
						this.info="Veuillez saisir le même mot de passe.";
						System.out.println(req1);
			}
			if(i!=-1){
				j=c.updatebd(req3);
					if(j!=-1){
						this.info="Modification effectuée";
					}

			}else{
				this.info="Ligne 944 Echec de modification";
				System.out.println("Ligne 944:"+this.info);
			}
		}else{
			if(!(this.passWord.equals(this.confPassWord))){
				this.info="Veuillez saisir le même mot de passe.";
				System.out.println("Ligne 949:"+this.info);
			}else{
				i=c.updatebd(req2);
				
				if(i!=-1){
					j=c.updatebd(req3);
					if(j!=-1){
						this.info="Modification effectuée";
						System.out.println("Ligne 957:"+this.info);
					}
					
				}
			}
		}
				
	}
	
	public void modifReceptTrouve(){
		this.idPersonne=this.selected.idPersonne;						this.adresse=this.selected.adresse;
		this.idRec=this.selected.idRec;									this.email=this.selected.email;
		this.nom=this.selected.nom;										this.userName=this.selected.userName;
		this.prenom=this.selected.prenom;								this.telFixe=this.selected.telFixe;
		this.dateNaiss=this.selected.dateNaiss;							this.telMob=this.selected.telMob;
		this.sexe=this.selected.sexe;
	
		int i=-1, j=-1;
		
		mysql c=new mysql();
		String req1="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"'," +
					"\n date_naissance='"+this.traitementDate(this.dateNaiss)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
					"\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"', passWord='"+this.passWord+"' " +
					" WHERE idPersonne='"+this.idPersonne+"'";
		
		String req2="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"'," +
					"\n date_naissance='"+this.traitementDate(this.dateNaiss)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
					"\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"' WHERE idPersonne='"+this.idPersonne+"'";

		if(!(this.passWord.equals(""))){
			if(this.passWord.equals(this.confPassWord)){
				i=c.updatebd(req1);
				if(i!=-1){
					System.out.println(req1);
					this.info="Modification du rceptionniste avec  mot de passe";
					System.out.println(this.info);
					}
				}else{ 
					this.info="Veuillez saisir le même mot de passe";
				  }
			}else{
					if(this.passWord.equals(this.confPassWord)){
				i=c.updatebd(req2);
				}else{
					this.info="Veuillez saisir le même mot de passe";
				}
				if(i!=-1){
					System.out.println(req2);
					this.info="Modification du rceptionniste sans mot de passe";
					System.out.println(this.info);
				}
			}
			
			
		}
	
	public void modifLabTrouve(){
		this.idPersonne=this.selected.idPersonne;					this.adresse=this.selected.adresse;
		this.idLab=this.selected.idLab;								this.email=this.selected.email;
		this.nom=this.selected.nom;									this.userName=this.selected.userName;
		this.prenom=this.selected.prenom;							this.telFixe=this.selected.telFixe;
		this.dateNaiss=this.selected.dateNaiss;						this.telMob=this.selected.telMob;
		this.sexe=this.selected.sexe;
		
		int i=-1, j=-1;
		
		mysql c=new mysql();
		String req1="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"'," +
					"\n date_naissance='"+this.traitementDate(this.dateNaiss)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
					"\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"', passWord='"+this.passWord+"' " +
					" WHERE idPersonne='"+this.idPersonne+"'";
		
		String req2="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.sexe+"'," +
					"\n date_naissance='"+this.traitementDate(this.dateNaiss)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
					"\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"' WHERE idPersonne='"+this.idPersonne+"'";

		if(!(this.passWord.equals(""))){
			if(this.passWord.equals(this.confPassWord)){
				i=c.updatebd(req1);
				if(i!=-1){
					System.out.println(req1);
					this.info="Modification du rceptionniste avec  mot de passe";
					System.out.println(this.info);
					}
				}else{ 
					this.info="Veuillez saisir le même mot de passe";
				  }
			}else{
					if(this.passWord.equals(this.confPassWord)){
				i=c.updatebd(req2);
				}else{
					this.info="Veuillez saisir le même mot de passe";
				}
				if(i!=-1){
					System.out.println(req2);
					this.info="Modification du laborantin sans mot de passe";
					System.out.println(this.info);
				}
			}	
	}
	//Fonction qui permet de désactiver ou d'activer le medecin trouvé.
	public void changeStatusMedTrouve(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE medecin SET status='"+option+"' WHERE idMedecin="+this.selected.idMedecin+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.info="Désactivation effectuée";
				else 
					this.info="Activation effectuée";
		}else{
			this.info="Operation échouée";
		}
		
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.etat);
	}
	
	//Fonction qui permet de désactiver ou d'activer l'infirmier.
	public void changeStatusInfTrouve(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE infirmier SET status='"+option+"' WHERE idInf="+this.selected.idInf+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.info="Désactivation effectuée";
				else 
					this.info="Activation effectuée";
		}else{
			this.info="Operation échouée";
		}
		
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.etat);
	}
	
	//Fonction qui permet de désactiver ou d'activer le receptionniste.
	public void changeStatusReceptTrouve(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE receptionniste SET status='"+option+"' WHERE idRec="+this.selected.idRec+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.info="Désactivation effectuée";
				else 
					this.info="Activation effectuée";
		}else{
			this.info="Operation échouée";
		}
		
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.etat);
	}
	
	//Fonction qui permet de désactiver ou d'activer le laborantin.
	public void changeStatusLabTrouve(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE laborantin SET status='"+option+"' WHERE idLaborantin="+this.selected.idLab+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.info="Désactivation effectuée";
				else 
					this.info="Activation effectuée";
		}else{
			this.info="Operation échouée";
		}
		
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.etat);
	}
	
	public List<recherche> getListInfoRendez() {
		this.listInfoRendez=new ArrayList<recherche>();
		
		mysql sql=new mysql();
		
		String requeteRendez="select per.nom as nomRec,per.prenom as prenomRec,pe.nom,pe.prenom,pe.genre,pa.profession,pa.codePatient,re.dateRendezVous,se.nomService,re.status from rendezvous re" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join receptionniste rec on rec.idRec=re.idRec" +
				" join personne per on per.idPersonne=rec.idPersonne" +
				" join service se on se.idService=re.idService" +
				" where pe.nom like '"+this.searchValue+"%'" +
				" or pe.prenom like '"+this.searchValue+"%'" +
				" or se.nomService like '"+this.searchValue+"%'" +
				" or pa.codePatient like '"+this.searchValue+"%'";
		
		ResultSet res=sql.selectbd(requeteRendez);
		
		System.out.println(requeteRendez);
		try {
			while(res.next()){
				
				recherche pa=new recherche();
				
				pa.codePerso=res.getString("codePatient");
				pa.nomRec=res.getString("nomRec");
				pa.prenomRec=res.getString("prenomRec");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				//pa.genre=res.getString("genre");
				pa.profession=res.getString("profession");
				pa.dateRendezVous=res.getDate("dateRendezVous");
				pa.nomService=res.getString("nomService");
				
				this.listInfoRendez.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listInfoRendez;
	}



	public void setListInfoRendez(List<recherche> listInfoRendez) {
		this.listInfoRendez = listInfoRendez;
	}



	public List<recherche> getListInfoConsul() {
		this.listInfoConsul=new ArrayList<recherche>();
		
		mysql sql=new mysql();
		
		String requeteConsultation="select per.nom as nomMed,per.prenom as prenomMed,fi.idMedecin,pe.nom,pe.prenom,pa.codePatient,se.nomService,fi.dateConsultation from fichemed fi" +
				" join rendezvous re on re.idRendezVous=fi.idRendezVous" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join medecin me on me.idMedecin=fi.idMedecin" +
				" join personne per on per.idPersonne=me.idPersonne" +
				" join service se on se.idService=re.idService" +
				" where pe.nom like '"+this.searchValue+"%'" +
				" or pe.prenom like '"+this.searchValue+"%'" +
				" or se.nomService like '"+this.searchValue+"%'" +
				" or pa.codePatient like '"+this.searchValue+"%'";
		
		 ResultSet res=sql.selectbd(requeteConsultation);
		 
		 try {
			while(res.next()){
				
				recherche pa=new recherche();
				
				pa.idMedecin=res.getInt("idMedecin");
				System.out.println(pa.idMedecin);
				pa.codePerso=res.getString("codePatient");
				pa.nomMed=res.getString("nomMed");
				System.out.println(pa.nomMed);
				pa.prenomMed=res.getString("prenomMed");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.dateConsultation=res.getDate("dateConsultation");
				
				this.listInfoConsul.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listInfoConsul;
	}



	public void setListInfoConsul(List<recherche> listInfoConsul) {
		this.listInfoConsul = listInfoConsul;
	}


    
	
	public List<recherche> getListInfoHospitalise() {
		this.listInfoHospitalise=new ArrayList<recherche>();
		
		mysql sql=new mysql();
		
		String requeteHospitalise="select pa.codePatient,per.nom as nomMed,per.prenom as prenomMed,pe.nom,pe.prenom,cha.codeChambre,fi.etat,fh.dateArrive,fh.motif from fichehosp fh" +
				" join fichemed fi on fi.idFiche=fh.idFiche" +
				" join rendezvous re on re.idRendezVous=fi.idRendezVous" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join medecin me on me.idMedecin=fi.idMedecin" +
				" join personne per on per.idPersonne=me.idPersonne" +
				" join chambre cha on cha.idChambre=fh.idChambre" +
				" join service se on se.idService=re.idService" +
				" where pe.nom like '"+this.searchValue+"%'" +
				" or pe.prenom like '"+this.searchValue+"%'" +
				" or se.nomService like '"+this.searchValue+"%'" +
				" or pa.codePatient like '"+this.searchValue+"%'";
		
		
		ResultSet res=sql.selectbd(requeteHospitalise);
		try {
			while(res.next()){
				
				recherche pa=new recherche();
				
				pa.codePerso=res.getString("codePatient");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.nomMed=res.getString("nomMed");
				pa.prenomMed=res.getString("prenomMed");
				pa.codeChambre=res.getString("codeChambre");
				pa.dateArrive=res.getDate("dateArrive");
				pa.motif=res.getString("motif");
				pa.etat=res.getString("etat");
				System.out.println(pa.motif);
				this.listInfoHospitalise.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listInfoHospitalise;
	}



	public void setListInfoHospitalise(List<recherche> listInfoHospitalise) {
		this.listInfoHospitalise = listInfoHospitalise;
	}



	public List<recherche> getListInfoSortie() {
		this.listInfoSortie=new ArrayList<recherche>();
		
		mysql sql=new mysql();
		
		String requeteSortie="select pa.codePatient,per.nom as nomMed,per.prenom as prenomMed,pe.nom,pe.prenom,cha.codeChambre,fh.dateArrive,fh.dateSortie,fh.etat,fh.motif,fi.idFiche, fh.idHosp from fichehosp fh" +
		" join fichemed fi on fi.idFiche=fh.idFiche" +
		" join rendezvous re on re.idRendezVous=fi.idRendezVous" +
		" join patient pa on pa.idPatient=re.idPatient" +
		" join personne pe on pe.idPersonne=pa.idPersonne" +
		" join medecin me on me.idMedecin=fi.idMedecin" +
		" join personne per on per.idPersonne=me.idPersonne" +
		" join chambre cha on cha.idChambre=fh.idChambre" +
		" join service se on se.idService=re.idService" +
		" where pe.nom like '"+this.searchValue+"%'" +
		" or pe.prenom like '"+this.searchValue+"%'" +
		" or se.nomService like '"+this.searchValue+"%'" +
		" or pa.codePatient like '"+this.searchValue+"%'" +
		" GROUP BY pa.codePatient" +
		" having fh.dateSortie is not NULL";
		
		ResultSet res=sql.selectbd(requeteSortie);
		
		try {
			while(res.next()){
				
				recherche pa=new recherche();
				
				pa.codePerso=res.getString("codePatient");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.nomMed=res.getString("nomMed");
				pa.prenomMed=res.getString("prenomMed");
				pa.codeChambre=res.getString("codeChambre");
				pa.dateArrive=res.getDate("dateArrive");
				pa.dateSortie=res.getDate("dateSortie");
				pa.motif=res.getString("motif");
				pa.etat=res.getString("etat");
				
				
				this.listInfoSortie.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listInfoSortie;
	}



	public void setListInfoSortie(List<recherche> listInfoSortie) {
		this.listInfoSortie = listInfoSortie;
	}

    public void backInformation(){
    	
    	this.getListInfoRendez();
    	this.getListInfoConsul();
    	this.getListInfoHospitalise();
    	this.getListInfoSortie();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		recherche r=new recherche();
		//r.getListPat();
		r.getListRecTrouve();
	}
}
