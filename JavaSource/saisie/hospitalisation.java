package saisie;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
//import java.util.Date;

public class hospitalisation {
	private int idFiche;
	private int idFicheHosp;
	private int idPatient;
	private String code;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String motifHosp;
	private int idChambre;
	private String codeChambre;
	private Date dateArrive;
	private Date dateSortie; 
	private List<hospitalisation> listPatientHosp;
	private List<hospitalisation> listSuiviPatHosp; //Liste de suivi des patients hospitalisés
	private List<hospitalisation> listPatientNonHosp;
	//private List<hospitalisation> listResultat;//Liste des examens ayant des resultats
	private hospitalisation selected;
	
	private String temperature;
	private String tensionArt;
	private  String frequenceCard;
	private  String frequenceResp;
	private String visiteMedGen;
	private String visiteMedSpec;
	private String diurese;
	private Date dateEnregistrement;
	private List<hospitalisation> listPrestation;
	private int idPrestation;
	private int idCatPresta;
	private String nomPresta;
	private String nomCatPresta;
	private int idPrix;
	private int prix;
	
	private String message;
	private String searchValue;
	private List<SelectItem> listPrestaVisite;//Liste des prestation de categorie visite
	private int prixVisite;
	private int idVisite;
	private String nomVisite;
	public hospitalisation() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}


	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public int getIdFicheHosp() {
		return idFicheHosp;
	}

	public void setIdFicheHosp(int idFicheHosp) {
		this.idFicheHosp = idFicheHosp;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMotifHosp() {
		return motifHosp;
	}
	public void setMotifHosp(String motifHosp) {
		this.motifHosp = motifHosp;
	}

	public int getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	

	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
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




	public hospitalisation getSelected() {
		return selected;
	}
	public void setSelected(hospitalisation selected) {
		this.selected = selected;
	}

	public List<hospitalisation> getListPatientHosp() {
		this.listPatientHosp=new ArrayList<hospitalisation>();
		 String req="SELECT * FROM fichehosp fh " +
					" JOIN fichemed fm ON fm.idFiche=fh.idFiche" +
					" JOIN rendezvous rv ON rv.idRendezVous=fm.idRendezVous" +
					" JOIN patient p ON p.idPatient=rv.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN chambre c ON c.idChambre = fh.idChambre" +
					" WHERE fh.status=1 GROUP BY p.idPatient";
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(req);
		 
		 try {
			while(res.next()){
				hospitalisation i=new hospitalisation();
				
				i.idFicheHosp=res.getInt("idHosp");
				i.idFiche=res.getInt("idFiche");
				i.code=res.getString("codePatient");
				i.nom=res.getString("nom");
				i.prenom=res.getString("prenom");
				i.dateNaissance=res.getDate("date_naissance");
				i.motifHosp=res.getString("motif");
				i.idChambre=res.getInt("idChambre");
				i.codeChambre=res.getString("codeChambre");
				i.dateArrive=res.getDate("dateArrive");
				i.dateSortie=res.getDate("dateSortie");
//				i.dateSortieTraite=this.traitementDate(res.getDate("dateSortie"));
//					if(i.dateArriveTraite.equals("0000-00-00"))
//						i.dateSortie=null;
//					else
//				i.dateSortie=res.getDate("dateSortie");
					
				this.listPatientHosp.add(i);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPatientHosp;
	}
	public void setListPatientHosp(List<hospitalisation> listPatientHosp) {
		this.listPatientHosp = listPatientHosp;
	}
	
	public ArrayList<hospitalisation> suggestPatHosp(Object prefix){
		String keyword=((String)prefix).toLowerCase();
		ArrayList<hospitalisation> suggestions=new ArrayList<hospitalisation>();
		List<hospitalisation> tousPatHosp=this.getListPatientHosp();
		
		for(hospitalisation i:tousPatHosp){
			
			if(i.code.startsWith(keyword) || i.nom.toLowerCase().startsWith(keyword) || i.prenom.toLowerCase().startsWith(keyword)){
				suggestions.add(i);
			}
		}
		return suggestions;
		
	}
	
	
	public void selectedPatient(){
		this.code=this.selected.code;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateNaissance=this.selected.dateNaissance;
		this.motifHosp=this.selected.motifHosp;
		this.idFiche=this.selected.idFiche;
		this.idChambre=this.selected.idChambre;
		this.codeChambre=this.selected.codeChambre;
		this.dateArrive=this.selected.dateArrive;
		this.dateSortie=this.selected.dateSortie;
		//System.out.println(this.code+" "+this.nom+" "+this.prenom+" "+this.dateNaissance+" "+this.motifHosp+" "+this.idFiche+" "+this.codeChambre);
	}

	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getTensionArt() {
		return tensionArt;
	}

	public void setTensionArt(String tensionArt) {
		this.tensionArt = tensionArt;
	}

	
	public String getFrequenceCard() {
		return frequenceCard;
	}

	public void setFrequenceCard(String frequenceCard) {
		this.frequenceCard = frequenceCard;
	}


	public String getFrequenceResp() {
		return frequenceResp;
	}

	public void setFrequenceResp(String frequenceResp) {
		this.frequenceResp = frequenceResp;
	}


	public String getVisiteMedGen() {
		return visiteMedGen;
	}

	public void setVisiteMedGen(String visiteMedGen) {
		this.visiteMedGen = visiteMedGen;
	}


	public String getVisiteMedSpec() {
		return visiteMedSpec;
	}

	public void setVisiteMedSpec(String visiteMedSpec) {
		this.visiteMedSpec = visiteMedSpec;
	}

	public String getDiurese() {
		return diurese;
	}
	public void setDiurese(String diurese) {
		this.diurese = diurese;
	}

	
	public int getIdPrestation() {
		return idPrestation;
	}
	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}

	public int getIdCatPresta() {
		return idCatPresta;
	}
	public void setIdCatPresta(int idCatPresta) {
		this.idCatPresta = idCatPresta;
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

	public int getIdPrix() {
		return idPrix;
	}
	public void setIdPrix(int idPrix) {
		this.idPrix = idPrix;
	}

	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}




	public List<hospitalisation> getListPrestation() {
		this.listPrestation=new ArrayList<hospitalisation>();
		String requetePrestation="select pre.idPrestation,pre.nomPresta,cat.nomCatPresta,pri.prix,pri.idPrix from prestation pre" +
		" join categoriepresta cat on pre.idCatPresta=cat.idCatPresta" +
		" join prix pri on pre.idPrix=pri.idPrix" +
		" order by pre.idPrestation desc";
		
		mysql sql=new mysql();
		ResultSet res=sql.selectbd(requetePrestation);
		
		try {
			while(res.next()){
				hospitalisation h=new hospitalisation();
				h.idPrestation=res.getInt("idPrestation");
				h.nomPresta=res.getString("nomPresta");
				h.nomCatPresta=res.getString("nomCatPresta");
				h.prix=res.getInt("prix");
				h.idPrix=res.getInt("idPrix");
				
				this.listPrestation.add(h);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPrestation;
	}

	public void setListPrestation(List<hospitalisation> listPrestation) {
		this.listPrestation = listPrestation;
	}

/*La methode qui recupere la liste des prestations*/
	
	public ArrayList<hospitalisation>suggestionPrestation(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		
		ArrayList<hospitalisation>suggestions=new ArrayList<hospitalisation>();
		
		List<hospitalisation>tous=this.getListPrestation();
		
		for(hospitalisation reponse:tous){
			
			if(reponse.nomCatPresta.toLowerCase().startsWith(keyword)||reponse.nomPresta.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
			
		}
		
		
		return suggestions;
	}

	private String dateSortieTraite;

	public String getDateSortieTraite() {
		return dateSortieTraite;
	}
	public void setDateSortieTraite(String dateSortieTraite) {
		this.dateSortieTraite = dateSortieTraite;
	}

  
	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}
	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
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
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return form.format(data);
	}
    
	private String dateRegisterTraite;
	
	public String getDateRegisterTraite() {
		return dateRegisterTraite;
	}
	public void setDateRegisterTraite(String dateRegisterTraite) {
		this.dateRegisterTraite = dateRegisterTraite;
	}
	public String traitementDateTimeFR(java.util.Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return form.format(data);
	}

	public void prestationSelected(){
		
		this.idPrestation=this.selected.idPrestation;
		this.nomPresta=this.selected.nomPresta;
		this.idCatPresta=this.selected.idCatPresta;
		this.nomCatPresta=this.selected.nomCatPresta;
		this.idPrix=this.selected.idPrix;
		this.prix=this.selected.prix;
	}
	
	public void initialise(){
		this.nomPresta="";   this.temperature="";  this.tensionArt="";  this.frequenceCard="";  this.frequenceResp="";
		this.visiteMedGen="";  this.visiteMedSpec="";  this.diurese=""; 
	}
	//Fonction qui enregistre les parametres du patient hospitalisé
	public void enregistreHosp(){
		int i=-1;
		java.util.Date d=new java.util.Date();
		String req="";
		if(this.idPrestation==0){
			req="INSERT INTO fichehosp(idFiche, idChambre, dateArrive, motif, temperature, " +
			"TA, FC, FR, visite, diurese, dateEnregistre) " +
			" VALUES("+this.idFiche+", "+this.idChambre+", '"+this.dateArrive+"'" +
			", '"+this.motifHosp+"', '"+this.temperature+"', '"+this.tensionArt+"', '"+this.frequenceCard+"', '"+this.frequenceResp+"'" +
			", '"+this.idVisite+"', '"+this.diurese+"', '"+this.traitementDateTime(d)+"')";
		}else{
			req="INSERT INTO fichehosp(idFiche, idChambre, dateArrive, idPrestation, motif, temperature, " +
					"TA, FC, FR, visite, diurese, dateEnregistre) " +
					" VALUES("+this.idFiche+", "+this.idChambre+", '"+this.dateArrive+"'" +
					", "+this.idPrestation+", '"+this.motifHosp+"', '"+this.temperature+"', '"+this.tensionArt+"', '"+this.frequenceCard+"', '"+this.frequenceResp+"'" +
					", '"+this.idVisite+"', '"+this.diurese+"', '"+this.traitementDateTime(d)+"')";
		 }
		System.out.println(req);
		mysql c=new mysql();
		i=c.updatebd(req);
		
		if(i>0){
			this.initialise();
			this.message="Paramètres enregistrés";
			
		}else{
			this.message="Echec d'enregistrement";
		}
		
		System.out.println("Requete hosp:"+req);
	}
	
	
	public List<hospitalisation> getListSuiviPatHosp() {
		System.out.println("Mot clé:"+this.searchValue);
		this.listSuiviPatHosp=new ArrayList<hospitalisation>();
		
		 String req=" SELECT * FROM fichehosp fh JOIN fichemed fi ON fi.idFiche = fh.idFiche " +
		 			" AND fh.status =1 AND fh.dateSortie IS NULL"+
					" JOIN rendezvous re ON re.idRendezVous = fi.idRendezVous" +
					" JOIN patient pa ON pa.idPatient = re.idPatient" +
					" JOIN personne pe ON pe.idPersonne = pa.idPersonne " +
					" JOIN service se ON se.idService = re.idService" +
					" JOIN chambre cha ON cha.idChambre = fh.idChambre" +
					" JOIN servicemed sem ON sem.idService = se.idService" +
					" JOIN medecin me ON me.idMedecin = sem.idMedecin " +
					" WHERE pa.codePatient LIKE '"+this.searchValue+"%' OR pe.nom LIKE '"+this.searchValue+"%' " +
					" OR pe.prenom LIKE '"+this.searchValue+"%' GROUP BY pa.idPatient";
		
		/* String req="SELECT * FROM fichehosp fh " +
					" JOIN fichemed fm ON fm.idFiche=fh.idFiche" +
					" JOIN rendezvous rv ON rv.idRendezVous=fm.idRendezVous" +
					" JOIN patient p ON p.idPatient=rv.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN chambre c ON c.idChambre = fh.idChambre" +
					" WHERE fh.status=1 AND fh.dateSortie IS NULL" +
					" AND p.codePatient LIKE '"+this.searchValue+"%' OR pe.nom LIKE '"+this.searchValue+"%' " +
					" OR pe.prenom LIKE '"+this.searchValue+"%'";*/
		
		//System.out.println(req);
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
			hospitalisation cur=new hospitalisation();
			cur.setCode("");
			
		try {
			while(res.next()){
				hospitalisation h=new hospitalisation();
				h.idFicheHosp=res.getInt("idHosp");
				if(!cur.getCode().equalsIgnoreCase(res.getString("codePatient"))){
					
					h.code=res.getString("codePatient");
					h.nom=res.getString("nom");
					h.prenom=res.getString("prenom");
					h.dateNaissance=res.getDate("date_naissance");
					h.dateArrive=res.getDate("dateArrive");
					h.idChambre=res.getInt("idChambre");
					h.codeChambre=res.getString("codeChambre");
					
					h.motifHosp=res.getString("motif");
				}
				cur.setCode(res.getString("codePatient"));
							if(res.getInt("idPrestation")!=0){
				h.idPrestation=res.getInt("idPrestation");
					String reqPresta="SELECT * FROM prestation WHERE idPrestation="+h.idPrestation+"";
						ResultSet res1=c.selectbd(reqPresta);
							if(res1.next()){
								h.nomPresta=res1.getString("nomPresta");	
							}
							}else{
								h.nomPresta="";	
							}
				
				h.temperature=res.getString("temperature");
				h.tensionArt=res.getString("TA");
				h.frequenceCard=res.getString("FC");
				h.frequenceResp=res.getString("FR");
				h.idVisite=res.getInt("visite");
				if(h.idVisite!=0){
	String reqVisite="SELECT * FROM prestation WHERE idPrestation="+h.idVisite+"";	
	ResultSet res2=c.selectbd(reqVisite);
					if(res2.next()){
				h.nomVisite=res2.getString("nomPresta");		
					}
				}else{
					h.nomVisite="";	
				}
				h.dateEnregistrement=res.getDate("dateEnregistre");
				//h.idVisite=res.get
//				h.visiteMedGen=res.getString("visiteMedGeneraliste");
//				h.visiteMedSpec=res.getString("visiteMedSpecialiste");
				//h.dateRegisterTraite=this.traitementDateTimeFR(res.getDate("dateEnregistre"));
				h.dateRegisterTraite=res.getString("dateEnregistre");
				h.diurese=res.getString("diurese");
				
			//System.out.println(h.code+" "+h.nom+" "+h.dateNaissance+" "+h.dateArrive+" "+h.idChambre+" "+h.codeChambre);
				this.listSuiviPatHosp.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSuiviPatHosp;
	}
	public void setListSuiviPatHosp(List<hospitalisation> listSuiviPatHosp) {
		this.listSuiviPatHosp = listSuiviPatHosp;
	}

	
	public void backPatientInformation(){
		this.getListSuiviPatHosp();
	}
	
	public void getPat(){
		System.out.println("Patient Selectionné:"+this.selected.code+" "+this.selected.nom+" "+this.selected.idFicheHosp);
		String req="SELECT * FROM fichehosp fh " +
					" JOIN fichemed fm ON fm.idFiche=fh.idFiche" +
					" JOIN rendezvous rv ON rv.idRendezVous=fm.idRendezVous" +
					" JOIN patient p ON p.idPatient=rv.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN chambre c ON c.idChambre = fh.idChambre" +
					" JOIN prestation pre ON pre.idPrestation=fh.idPrestation" +
					" WHERE fh.idHosp="+this.selected.idFicheHosp+"";
		//System.out.println(req);
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		try {
			while(res.next()){
				this.code=res.getString("codePatient");
				this.nom=res.getString("nom");
				this.prenom=res.getString("prenom");
				this.dateNaissance=res.getDate("date_naissance");
				this.motifHosp=res.getString("motif");
				this.idChambre=res.getInt("idChambre");
				this.codeChambre=res.getString("codeChambre");
				this.dateArrive=res.getDate("dateArrive");
				this.nomPresta=res.getString("nomPresta");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.temperature=this.selected.temperature;
		this.tensionArt=this.selected.tensionArt;
		this.idPrestation=this.selected.idPrestation;
		this.idVisite=this.selected.idVisite;
		this.nomVisite=this.selected.nomVisite;
		
	}

	public void modifFicheHosp(){
		int i=-1;
		String req="";
					if(this.nomPresta.equals("")){
						this.idPrestation=0;
					}
		
				if(this.selected.idVisite!=0){
		req="UPDATE fichehosp SET idPrestation="+this.idPrestation+", temperature='"+this.selected.temperature+"', TA='"+this.selected.tensionArt+"', FC='"+this.selected.frequenceCard+"', " +
		    " FR='"+this.selected.frequenceResp+"'" +", visite='"+this.selected.idVisite+"', diurese='"+this.selected.diurese+"'" +
	     	" WHERE idHosp="+this.selected.idFicheHosp+"";	
				}else{
		req="UPDATE fichehosp SET idPrestation="+this.idPrestation+", temperature='"+this.selected.temperature+"', TA='"+this.selected.tensionArt+"', FC='"+this.selected.frequenceCard+"', " +
			" FR='"+this.selected.frequenceResp+"'" +", visite=NULL, diurese='"+this.selected.diurese+"'" +
			" WHERE idHosp="+this.selected.idFicheHosp+"";			
				}
				
		
		
		System.out.println(req);
		mysql c=new mysql();
		i=c.updatebd(req);
		
		if(i>0){
			this.message="Modification effectuée";
		}else{
			this.message="Echec de modification";
		}
		
	}
	
	
	




	public int getPrixVisite() {
		return prixVisite;
	}

	public void setPrixVisite(int prixVisite) {
		this.prixVisite = prixVisite;
	}


	public int getIdVisite() {
		return idVisite;
	}




	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

	public String getNomVisite() {
		return nomVisite;
	}

	public void setNomVisite(String nomVisite) {
		this.nomVisite = nomVisite;
	}




	public List<SelectItem> getListPrestaVisite() {
		 String req="SELECT *  FROM prestation p JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
			" JOIN prix pr ON pr.idPrix=p.idPrix WHERE cp.nomCatPresta='VISITE'";
				mysql c=new mysql();
				
				if(listPrestaVisite==null){
							
					this.listPrestaVisite=new ArrayList<SelectItem>();
						}else{
							this.listPrestaVisite.clear();
						}
		
		
		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				hospitalisation h=new hospitalisation();
				
				h.idPrestation=res.getInt("idPrestation");
				h.idVisite=res.getInt("idPrestation");
				h.idCatPresta=res.getInt("idCatPresta");
				h.idPrix=res.getInt("idPrix");
				h.prixVisite=res.getInt("prix");
				h.prix=res.getInt("prix");
				h.nomCatPresta=res.getString("nomCatPresta");
				h.nomPresta=res.getString("nomPresta");
				
				this.listPrestaVisite.add(new SelectItem(h.idPrestation, h.nomPresta));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPrestaVisite;
	}




	public void setListPrestaVisite(List<SelectItem> listPrestaVisite) {
		this.listPrestaVisite = listPrestaVisite;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
