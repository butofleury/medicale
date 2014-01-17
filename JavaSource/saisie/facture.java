package saisie;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;



public class facture extends HttpServlet implements Servlet{
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
	private String sexe;
	private int idRendezVs;
	private facture selected;
	private Date dateRendezVous;
	private List<facture>listPatient;
	private List<facture>listPrestation;
	private List<facture>factureListener;
	private int idPrestation;
	private int idCatPresta;
	private String nomPresta;
	private String nomCatPresta;
	private int idPrix;
	private int prix;      
	private int prixVisiteSpec;//Prix de la prestation visite du specialiste
	private int prixVisiteGen;//Prix de la prestation visite du generaliste
	private String message;
	private boolean error=false;
	private Date dateHosp;
	private Date dateSortie;
	private int idFiche;
	private int idFicheHosp;
	private String codeChambre;
	private float sommePaye=0;
	private List<facture> listHospSortie;
	private String factureChoice;
	private boolean hospitalise=false;
	private boolean ambulant=true;
	private String messageFact;
	private boolean errorFact;
	private String codeFacture;
	private String searchFact;//Information du patient lors du paiement
	private List<facture> listConsultNonPaye;//Liste des consultation non payé pour un patient
	private List<facture> listDetailNonPaye;//Liste des autres détails non payés pour un patient
	private int idDetail;
	private String messagePaye;
	private boolean errorPaye=false;

	private int idMedecin;
    private boolean statusPaye;
	private String statusValue;
	private boolean validate;
	private List<facture>listPatientDejaPaye;
	private List<facture> listFactAmbulant;
	private float sommeFactureAmbulant;
	private int idFact;//Id de la facture pour le patient ambulant
	private String dateFact;//id de facture pour le patient ambulant
	public String getMessagePaye() {
		return messagePaye;
	}


	public void setMessagePaye(String messagePaye) {
		this.messagePaye = messagePaye;
	}


	public boolean isErrorPaye() {
		return errorPaye;
	}


	public void setErrorPaye(boolean errorPaye) {
		this.errorPaye = errorPaye;
	}


	public boolean isHospitalise() {
		return hospitalise;
	}


	public void setHospitalise(boolean hospitalise) {
		this.hospitalise = hospitalise;
	}






	public boolean isAmbulant() {
		return ambulant;
	}






	public void setAmbulant(boolean ambulant) {
		this.ambulant = ambulant;
	}






	public String getFactureChoice() {
		return factureChoice;
	}






	public void setFactureChoice(String factureChoice) {
		this.factureChoice = factureChoice;
	}






	public boolean isError() {
		return error;
	}






	public void setError(boolean error) {
		this.error = error;
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

    




	public String getSexe() {
		return sexe;
	}






	public void setSexe(String sexe) {
		this.sexe = sexe;
	}






	public int getIdRendezVs() {
		return idRendezVs;
	}






	public void setIdRendezVs(int idRendezVs) {
		this.idRendezVs = idRendezVs;
	}

    




	public facture getSelected() {
		return selected;
	}






	public void setSelected(facture selected) {
		this.selected = selected;
	}

    




	public Date getDateRendezVous() {
		return dateRendezVous;
	}






	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
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

	
    



	public int getPrixVisiteSpec() {
		return prixVisiteSpec;
	}


	public void setPrixVisiteSpec(int prixVisiteSpec) {
		this.prixVisiteSpec = prixVisiteSpec;
	}


	public int getPrixVisiteGen() {
		return prixVisiteGen;
	}


	public void setPrixVisiteGen(int prixVisiteGen) {
		this.prixVisiteGen = prixVisiteGen;
	}


	public int getIdCatPresta() {
		return idCatPresta;
	}






	public void setIdCatPresta(int idCatPresta) {
		this.idCatPresta = idCatPresta;
	}
    





	public String getMessage() {
		return message;
	}






	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public String getCodeChambre() {
		return codeChambre;
	}






	public void setCodeChambre(String codeChambre) {
		this.codeChambre = codeChambre;
	}






	public Date getDateHosp() {
		return dateHosp;
	}






	public void setDateHosp(Date dateHosp) {
		this.dateHosp = dateHosp;
	}






	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	
	public int getF(){
		return this.getIdFiche();
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


   



	public String getMessageFact() {
		return messageFact;
	}






	public void setMessageFact(String messageFact) {
		this.messageFact = messageFact;
	}

	




	public boolean isErrorFact() {
		return errorFact;
	}






	public void setErrorFact(boolean errorFact) {
		this.errorFact = errorFact;
	}






	public List<facture> getListPatient() {
		
    listPatient=new ArrayList<facture>();
		
		
		
	    String requeteRendez="select pa.codePatient,pa.idPatient,se.idService,re.idRendezVous,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService from rendezvous re" +
	    " join patient pa on pa.idPatient=re.idPatient" +
	    " join personne pe on pe.idPersonne=pa.idPersonne" +
		" join service se on re.idService=se.idService" +
		" WHERE re.dateRendezvous >=CURRENT_DATE()" +
		" group by pa.idPatient having max(re.idRendezVous)";
	    
	    
	    mysql sql=new mysql();
		 
		ResultSet res=sql.selectbd(requeteRendez);
		System.out.println(requeteRendez);
	    
		try {
			while(res.next()){
				
				facture pa=new facture();
				pa.codePerso=res.getString("codePatient");
				pa.idPatient=res.getInt("idPatient");
				pa.idService=res.getInt("idService");
				pa.nomService=res.getString("nomService");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				//pa.dateRendezVs=res.getDate("dateRendezVous");
				pa.idRendezVs=res.getInt("idRendezVous");
				
				listPatient.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    
		return listPatient;
		
		
	}






	public void setListPatient(List<facture> listPatient) {
		this.listPatient = listPatient;
	}
	
	
	
	/*La methode qui gere le type date */
	
	  
    public String traitementDate(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
	}
	

 /* La methode qui gere la liste de suggestions des patients pour les rendez-vous*/
	
	public ArrayList<facture>suggestionRendez(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		ArrayList<facture>suggestions=new ArrayList<facture>();
		
		List<facture> tous=this.getListPatient();
		
		for(facture reponse:tous){
			
			if(reponse.codePerso.startsWith(keyword)||reponse.nom.toLowerCase().startsWith(keyword)||reponse.prenom.toLowerCase().startsWith(keyword)||reponse.nomService.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
				
			}
		
		}
		
		return suggestions;
	}
    
	/*La methode qui conserve les informations du patient*/
	
	public void patientSelected(){
		
		String dateString;
		dateString=this.traitementDate(dateRendezVous);
		this.idRendezVs=this.selected.idRendezVs;
		this.idPatient=this.selected.idPatient;
		this.codePerso=this.selected.codePerso;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateRendezVous=this.selected.dateRendezVous;
		//this.dateChoice=this.selected.dateChoice;
		this.nomService=this.selected.nomService;
		System.out.println(dateString);
//		this.factureListener=new ArrayList<facture>();
//		this.factureListener.clear();
	}
    
	
	
   
	public List<facture> getListPrestation() {
		
		this.listPrestation=new ArrayList<facture>();
		
		String requetePrestation="select pre.idPrestation,pre.nomPresta,cat.nomCatPresta,pri.prix,pri.idPrix from prestation pre" +
				" join categoriepresta cat on pre.idCatPresta=cat.idCatPresta" +
				" join prix pri on pre.idPrix=pri.idPrix" +
				" order by pre.idPrestation desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requetePrestation);
		
		try {
			while(res.next()){

				
//					for(int i=0; i<this.factureListener.size(); i++){
//						if(this.factureListener.get(i).nomPresta!=res.getString("nomPresta")){
							facture pa=new facture();
							pa.idPrestation=res.getInt("idPrestation");
							pa.nomPresta=res.getString("nomPresta");
							pa.nomCatPresta=res.getString("nomCatPresta");
							pa.prix=res.getInt("prix");
							//System.out.println("Dans le lecteur"+pa.prix);
							pa.idPrix=res.getInt("idPrix");
							
							this.listPrestation.add(pa);
//						}
//					}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPrestation;
	}






	public void setListPrestation(List<facture> listPrestation) {
		this.listPrestation = listPrestation;
	}

/*La methode qui recupere la liste des prestations*/
	
	public ArrayList<facture>suggestionPrestation(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		
		ArrayList<facture>suggestions=new ArrayList<facture>();
		
		List<facture>tous=this.getListPrestation();
		
		for(facture reponse:tous){
			
			if(reponse.nomCatPresta.toLowerCase().startsWith(keyword)||reponse.nomPresta.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
			
		}
		
		
		return suggestions;
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
    

	public List<facture> getFactureListener() {
		return factureListener;
	}



    public void setFactureListener(List<facture> factureListener) {
		this.factureListener = factureListener;
	}

    
    
    public float getSommePaye() {
		return sommePaye;
	}
	public void setSommePaye(float sommePaye) {
		this.sommePaye = sommePaye;
	}

	public void factureReceive(){
    	
    	if(this.codePerso==""){
			
  		  this.message="Veuillez selectionner un patient!";
  			System.out.println(message);
  			this.error=true;
  			
  			return;
  		}
    	
       /*if(this.nomPresta==""){
    		this.message="Veuillez selectionner une prestation";
    		System.out.println(message);
    		this.error=true;
    		return;
    	}*/
    	
    	try{
    	
    		
    	this.nomPresta=this.selected.nomPresta;
    	this.nomCatPresta=this.selected.nomCatPresta;
    	this.prix=this.selected.prix;
    	
    	if(this.factureListener==null)
    		this.factureListener=new ArrayList<facture>();
    		
    		facture f=new facture();
    		
    		
    		f.idPrestation=this.idPrestation;
    		f.idRendezVs=this.idRendezVs;	
    		f.nomPresta=this.nomPresta;
    		f.nomCatPresta=this.nomCatPresta;
        	f.idPrix=this.idPrix;
        	f.prix=this.prix;	
    			
    		this.error=false;
    		
    		
    		//System.out.println("Dans la reception:"+f.prix);
    		
    		System.out.println(f.nomPresta);
    		
    		if(f.nomPresta==null || this.nomPresta.equals("")){
    			
    			this.message="Veuillez selectionner une prestation!!!";
    			System.out.println(this.message);
    			f=new facture();
    			this.error=true;
    			return;
    		}else{
    			//this.message="";
    			System.out.println("Passage a l'objet:"+this.factureListener);
    				if(this.factureListener.isEmpty()){
    					this.factureListener.add(f);
   			
    				}else{
//    					for(int i=0; i<this.factureListener.size();i++){
//        					if(this.factureListener.get(i).nomPresta!=f.nomPresta){
        						 this.factureListener.add(f);
        						
        					//}
//        					else{
//        						this.message="Cette prestation est déjà selectionnée";
//        						System.out.println("Info:"+this.message);
//        					}
//      						   
//        	    			}
    				}
    			
    			this.sommePaye=0;
    			for(int i=0; i<this.factureListener.size();i++){
    				
    		System.out.println("Prestation existant:"+this.factureListener.get(i).idRendezVs+" "+this.factureListener.get(i).idPrestation+" "+this.factureListener.get(i).nomPresta+" "+this.factureListener.get(i).prix);
    				this.sommePaye=this.sommePaye+this.factureListener.get(i).prix;
    				
    				}
    			System.out.println("Somme payée"+this.sommePaye);
    			}

    			f=new facture();
    			this.selected.nomPresta="";
    			f.nomPresta="";
    			
    		
    		nomCatPresta="";
			nomPresta="";
			prix=0;
			this.message="";
    		//f=null;
         }catch(NullPointerException e){
    		
    		// TODO Auto-generated catch block
			e.printStackTrace();
			this.message="Veuillez choisir une prestation!!!";
			this.error=true;
			this.factureListener=null;
			this.sommePaye=0;
    	}
         
    
    }
	
	public void removeFactureLister(){
			facture f=this.selected;
		this.factureListener.remove(f);
		for(int i=0; i<this.factureListener.size(); i++){
			System.out.println(i+":"+this.factureListener.get(i));
		}
		this.sommePaye=0;
		for(int i=0; i<this.factureListener.size();i++){
			
    		System.out.println("Prestation existant:"+this.factureListener.get(i).idRendezVs+" "+this.factureListener.get(i).nomPresta+" "+this.factureListener.get(i).prix);
    				this.sommePaye=this.sommePaye+this.factureListener.get(i).prix;
    			System.out.println("Somme à payer:"+this.sommePaye);	
    				}
		//int i = 0;
			
			
	}
    
    public void initialisePrestation(){
    	
    	this.factureListener=null;
    	this.message="";
    	this.error=false;
    	this.sommePaye=0;
    	this.error=false;
    	this.errorFact=false;
    	this.messageFact="";
    	this.nom="";
    	this.prenom="";
    }
    	private int sommePayeFact;
    	
    	public int getSommePayeFact() {
			return sommePayeFact;
		}

		public void setSommePayeFact(int sommePayeFact) {
			this.sommePayeFact = sommePayeFact;
		}

		public void calculSomme(){
			this.sommePayeFact=0;
				if(this.factureListener==null){
					this.message="Veuillez établir la facture";
				}else
			for(int i=0; i<this.factureListener.size();i++){
				
	    		System.out.println("Prestation existant:"+this.factureListener.get(i).nomPresta+" "+this.factureListener.get(i).prix);
	    				this.sommePayeFact=this.sommePayeFact+this.factureListener.get(i).prix;
	    			System.out.println("Somme à payer:"+this.sommePayeFact);	
	    				}
		}

		



	public String getCodeFacture() {
			return codeFacture;
		}

	public void setCodeFacture(String codeFacture) {
			this.codeFacture = codeFacture;
		}

	public void saisiPrestation(){
		java.util.Date d=new java.util.Date();
		Calendar cal=new java.util.GregorianCalendar();
    	System.out.println("Methode appelee");
    	//int updateValid=-1;
    	int i=-1, u=-1, v=-1;
    	mysql sql=new mysql();
    	
    	if(this.factureListener==null||this.idPrestation==0 ){
    		
    		this.message="Veuillez selectionner une prestation!!!";
    		System.out.println(this.message);
    		this.error=true;
    	}else{
    		for(facture f1:this.factureListener){
    			System.out.println(f1.idRendezVs+" "+f1.nomCatPresta+" "+f1.nomPresta+" "+f1.idPrestation+" "+f1.prix);
    			String req="INSERT INTO detailprestation(idRendezVous, idPrestation, dateDetail, paiement) VALUES("+f1.idRendezVs+", "+f1.idPrestation+", '"+this.traitementDateTime(d)+"', 0)";
    			System.out.println("Req detail:"+req);
    			i=sql.updatebd(req);
    			this.idRendezVs=f1.idRendezVs;
    			if(i>0){
    				this.errorFact=true;
    				this.messageFact="Enregistrement effectué";
    			}else{
    				this.errorFact=true;
    				this.messageFact="Echec d'enregistrement";
    			}
    		}
    		 String reqFacture="INSERT INTO facture(CodeFacture, modePayement, dateF, somme, idRendezVous, montantRestant) " +
    							" VALUES(' ', ' ', '"+this.traitementDateTime(d)+"', "+this.sommePaye+",  "+this.idRendezVs+", "+this.sommePaye+")";
    		System.out.println("Req detail:"+reqFacture);
    		u=sql.updatebd(reqFacture);
    		if(u>0){
    			this.errorFact=true;
    			this.messageFact="Enregistrement effectué";
			}else{
				this.errorFact=true;
				this.messageFact="Echec d'enregistrement";
			}
    		System.out.println("Somme totale:"+this.sommePaye);
    		
    		//Recuperation du dernier Id dans facture pour mettre à jour la colonne CodeFacture	
    		String getId="SELECT * FROM facture ORDER BY idFacture DESC LIMIT 1";
    		ResultSet r=sql.selectbd(getId);
    		try {
				if(r.next()){
					this.codeFacture=""+r.getInt("idFacture")+"/"+cal.get(Calendar.YEAR);
					System.out.println("Coode Facture:"+this.codeFacture);
					String updateFact="UPDATE facture SET CodeFacture='"+this.codeFacture+"' WHERE idFacture="+r.getInt("idFacture")+" AND idRendezVous="+this.idRendezVs+"";
					System.out.println(updateFact);
					v=sql.updatebd(updateFact);
						if(v>0){
							this.message="Facture N° "+this.codeFacture;
								this.factureListener=null;
						}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
  	
    }
	private int countVisiteGen;
	private int countVisiteSpec;
	
    public int getCountVisiteGen() {
		return countVisiteGen;
	}
	public void setCountVisiteGen(int countVisiteGen) {
		this.countVisiteGen = countVisiteGen;
	}

	public int getCountVisiteSpec() {
		return countVisiteSpec;
	}
	public void setCountVisiteSpec(int countVisiteSpec) {
		this.countVisiteSpec = countVisiteSpec;
	}

	public int sommeVisiteGen;
	public int sommeVisiteSpec;

	
	public int getSommeVisiteGen() {
		return sommeVisiteGen;
	}
	public void setSommeVisiteGen(int sommeVisiteGen) {
		this.sommeVisiteGen = sommeVisiteGen;
	}

	public int getSommeVisiteSpec() {
		return sommeVisiteSpec;
	}
	public void setSommeVisiteSpec(int sommeVisiteSpec) {
		this.sommeVisiteSpec = sommeVisiteSpec;
	}

	private List<facture> listPatientSortie;
	
	public List<facture> getListPatientSortie() {
		this.listPatientSortie=new ArrayList<facture>();
		 String req="SELECT * FROM fichehosp fh " +
		 			" JOIN fichemed fm ON fh.idFiche = fm.idFiche " +
		 			" JOIN rendezVous r ON r.idrendezvous = fm.idRendezvous" +
		 			" JOIN patient p ON p.idPatient = r.idPatient" +
		 			" JOIN personne pe ON pe.idPersonne = p.idPersonne" +
		 			" JOIN service s ON s.idService = r.idService" +
		 			" JOIN chambre c ON c.idChambre = fh.idChambre GROUP BY fh.idFiche";
		 
		 mysql c=new mysql();
		 ResultSet res2=c.selectbd(req);
		 try {
			while(res2.next()){
				facture f=new facture();
				
				f.idPatient=res2.getInt("idPatient");
				f.idFiche=res2.getInt("idFiche");
				f.codePerso=res2.getString("codePatient");
				f.nom=res2.getString("nom");
				f.prenom=res2.getString("prenom");
				f.sexe=res2.getString("genre");
				f.dateHosp=res2.getDate("dateArrive");
				f.dateSortie=res2.getDate("dateSortie");
				f.nomService=res2.getString("nomService");
				f.codeChambre=res2.getString("codeChambre");
	System.out.println(f.idPatient+" "+f.codePerso+" "+f.nom+" "+f.prenom+" "+f.sexe+" "+f.dateHosp+" "+f.dateSortie+" "+f.nomService+" "+f.codeChambre);			
				
	String reqVisiteGen="SELECT COUNT(visite) AS nbreVisiteGen" +
						" FROM fichehosp WHERE visiteMedGeneraliste = '11' AND idFiche ="+f.idFiche+"";

		ResultSet res=c.selectbd(reqVisiteGen);
		try {
		if(res.next()){
		f.countVisiteGen=res.getInt("nbreVisiteGen");
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(f.countVisiteGen>0){
		f.sommeVisiteGen=f.countVisiteGen*5000;
		}
		String reqVisiteSpec="SELECT COUNT(visite) AS visiteMedSpec" +
							 " FROM fichehosp WHERE visiteMedGeneraliste = '12' AND idFiche ="+f.idFiche+"";
		ResultSet res1=c.selectbd(reqVisiteSpec);
		try {
		if(res1.next()){
		f.countVisiteSpec=res1.getInt("visiteMedSpec");
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(f.countVisiteSpec!=0){
		f.sommeVisiteSpec=f.countVisiteSpec*8000;
		}

				this.listPatientSortie.add(f);
			}
				 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPatientSortie;
	}

	private String etatSortie;
	
	public String getEtatSortie() {
		return etatSortie;
	}
	public void setEtatSortie(String etatSortie) {
		this.etatSortie = etatSortie;
	}


	public void setListPatientSortie(List<facture> listPatientSortie) {
		this.listPatientSortie = listPatientSortie;
	}

	
	
	public List<facture> getListHospSortie() {
		this.listHospSortie=new ArrayList<facture>();
		 String req="SELECT * FROM fichehosp fh " +
					" JOIN fichemed fi ON fi.idFiche = fh.idFiche" +
					" JOIN rendezvous re ON re.idRendezVous = fi.idRendezVous" +
					" JOIN service se ON se.idService = re.idService" +
					" JOIN patient p ON p.idPatient=re.idPatient" +
					" JOIN personne pe ON pe.idPersonne=p.idPersonne" +
					" JOIN chambre c ON c.idChambre = fh.idChambre" +
					" JOIN chambreprix cp ON cp.idChambre=c.idChambre" +
					" JOIN prix pr ON pr.idPrix = cp.idPrix " +
					" WHERE fh.dateSortie IS NOT NULL GROUP BY fh.idFiche";
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(req);
		 
		 try {
			while(res.next()){
				facture v=new facture();
				
				v.idFiche=res.getInt("idFiche");
				v.idPatient=res.getInt("idPatient");
				v.codePerso=res.getString("codePatient");
				v.nom=res.getString("nom");
				v.prenom=res.getString("prenom");
				v.sexe=res.getString("genre");
				v.etatSortie=res.getString("etat");
				v.codeChambre=res.getString("codeChambre");
				v.idPrix=res.getInt("idPrix");
				v.prix=res.getInt("prix");
				v.nomService=res.getString("nomService");
				v.dateHosp=res.getDate("dateArrive");
				v.dateSortie=res.getDate("dateSortie");
				//v.prix=res.getInt("prix");
				this.listHospSortie.add(v);
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHospSortie;
	}

	public void setListHospSortie(List<facture> listHospSortie) {
		this.listHospSortie = listHospSortie;
	}


	private int nbjourHosp;
	private int montantChambre;
	private String dateEntre;//Date d'entrée en chaine de caractère
	private String dateSort;//Date de sortie en chaine de caractère
	

	public int getNbjourHosp() {
		return nbjourHosp;
	}
	public void setNbjourHosp(int nbjourHosp) {
		this.nbjourHosp = nbjourHosp;
	}

	public int getMontantChambre() {
		return montantChambre;
	}

	public void setMontantChambre(int montantChambre) {
		this.montantChambre = montantChambre;
	}

	
	public String getDateEntre() {
		return dateEntre;
	}
	public void setDateEntre(String dateEntre) {
		this.dateEntre = dateEntre;
	}

	public String getDateSort() {
		return dateSort;
	}
	
	public void setDateSort(String dateSort) {
		this.dateSort = dateSort;
	}


	public void facturePat(int idFiche){
    	String reqVisiteGen="SELECT COUNT(visite) AS nbreVisiteGen" +
    						" FROM fichehosp WHERE visite = '11' AND idFiche ="+idFiche+"";
    	mysql c=new mysql();
    	ResultSet res=c.selectbd(reqVisiteGen);
    	try {
			if(res.next()){
				this.countVisiteGen=res.getInt("nbreVisiteGen");
//				this.dateHosp=res.getDate("dateArrive");
//				this.dateSortie=res.getDate("dateSortie");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.countVisiteGen>0){
			  String reqPrixVisite=" SELECT * FROM prestation p JOIN prix pr ON p.idPrix = pr.idPrix" +
								   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
								   " WHERE p.idPrestation =  '11'";
			ResultSet resPrix1=c.selectbd(reqPrixVisite);
				try {
					if(resPrix1.next()){
						this.prixVisiteGen=resPrix1.getInt("prix");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			this.sommeVisiteGen=this.countVisiteGen*this.prixVisiteGen;
		}
		 String reqVisiteSpec="SELECT COUNT(visite) AS visiteMedSpec" +
							  " FROM fichehosp WHERE visite= '12' AND idFiche ="+idFiche+"";
		ResultSet res1=c.selectbd(reqVisiteSpec);
		try {
			if(res1.next()){
				this.countVisiteSpec=res1.getInt("visiteMedSpec");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.countVisiteSpec!=0){
			String reqPrixVisiteSpec="SELECT * FROM prestation p JOIN prix pr ON p.idPrix = pr.idPrix" +
								   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
								   " WHERE p.idPrestation =  '12'";
			ResultSet resPrix2=c.selectbd(reqPrixVisiteSpec);
			
				try {
					if(resPrix2.next())
						this.prixVisiteSpec=resPrix2.getInt("prix");
						this.sommeVisiteSpec=this.countVisiteSpec*this.prixVisiteSpec;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		 
		
//		fact.add(new Paragraph("Hospitalisation du "+dateEntree+" au "+dateS));
//		fact.add(new Paragraph("  "));   fact.add(new Paragraph("  ")); fact.add(new Paragraph("  "));
		
		 String getChambre="SELECT * FROM fichehosp fh, chambrePrix cp, chambre c, prix p" +
							" WHERE c.idChambre = cp.idChambre AND p.idPrix = cp.idPrix AND cp.idPrix" +
							" IN (SELECT max( idPrix ) AS prixID " +
							" FROM chambrePrix WHERE fh.idFiche ="+idFiche+" GROUP BY idChambre ) ORDER BY c.codeChambre AND fh.idHosp";
		 ResultSet r=c.selectbd(getChambre);
		 	try {
				if(r.next()){
					this.prix=r.getInt("prix");
					this.dateHosp=r.getDate("dateArrive");
					this.dateSortie=r.getDate("dateSortie");
					
					int nbjourHosp=0;
					 int montantChambre=0;
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date date=null, dateSort=null;
					try
					{
					date= df.parse(""+this.dateHosp);
						if(this.dateSortie!=null)
					dateSort=df.parse(""+this.dateSortie);
					int jourEntree=date.getDate();
					int jourSortie=dateSort.getDate()-1;
					String j="", jSortie="";
					
						if(jourEntree<10){
							j="0"+jourEntree;
						}else{
							j=""+jourEntree;
						}
					
					int moisEntree=date.getMonth()+1;
					int anneeEntree=date.getYear()+1900;
					String dateEntree=""+j+"/"+moisEntree+"/"+anneeEntree;
					
					this.dateEntre=dateEntree;
					System.out.println(this.dateEntre);
					if(jourSortie<10){
						jSortie="0"+jourSortie;
					}else{
						jSortie=""+jourSortie;
					}
					int moisSortie=dateSort.getMonth()+1;
					int anneeSortie=dateSort.getYear()+1900;
					String dateS=""+jSortie+"/"+moisSortie+"/"+anneeSortie;	
					this.dateSort=dateS;
				Calendar c1 = new GregorianCalendar();
			    Calendar c2 = new GregorianCalendar();
			    c1.set(anneeEntree, moisEntree, Integer.parseInt(j), 0, 0, 0);
			    c2.set(anneeSortie, moisSortie, Integer.parseInt(jSortie), 0, 0, 0);
			 
			    System.out.println(differenceDate(c1.getTime(), c2.getTime())+" jour(s) Entre les deux Date");
			    nbjourHosp=(int) differenceDate(c1.getTime(), c2.getTime())+1;
			    montantChambre=this.prix*nbjourHosp;
			    
			    this.nbjourHosp=nbjourHosp;
			    this.montantChambre=montantChambre;
			    System.out.println("Nbre Jour hosp:"+this.nbjourHosp+" Prix:"+this.montantChambre);
				} catch (ParseException e){
				e.printStackTrace();
				} 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
    }
	
	
	public void detailPrestaFact(){
		facture f=new facture();
	}
	
	/*public void test(){
		FacesContext pdf=FacesContext.getCurrentInstance();
		
		try {
			pdf.getExternalContext().dispatch("/receptionniste/fact.xhtml?partest=buja&par2=125");
			System.out.println(""+pdf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			pdf.responseComplete();
		}
	}
	
	public void doPost(HttpServletRequest requete,HttpServletResponse reponse) throws ServletException,IOException{
		
		System.out.println(requete.getParameter("partest")+" "+requete.getParameter("par2"));
		
		ByteArrayOutputStream op=printerFact();
		System.out.println("Fact Psss:"+op);
		reponse.setHeader("Cache-control", "max-age=30");
		reponse.setContentType("application/pdf");
		reponse.setHeader("content-disposition", "inline;filename=bj.pdf");
		
		reponse.setContentLength(op.size());
		op.writeTo(reponse.getOutputStream());
		
		op.flush();
		
		if (op != null)
		{
		  op.reset();
		}

	}*/
	
	public ByteArrayOutputStream printerFact(){
		 return this.printFacture();
	}
	
	  public ByteArrayOutputStream printFacture(){
		  	//this.sommeLettre="Soixante  quinze mille francs";
		  String sommeL=this.sommeLettre;
		  //FacesContext pdf=FacesContext.getCurrentInstance();
		  ByteArrayOutputStream op=null;
			//if(pdf!=null)
				try {
					op=new ByteArrayOutputStream();	
					/*try {
						pdf.getExternalContext().dispatch("/receptionniste/fact.xhtml?partest=buja&par2=125");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}*/
				
				
				
				
		  
			Document fact=new Document(PageSize.A4);
			
					facture f=new facture();	
					 System.out.println("Somme:"+sommeL);
					 int nbjourHosp=0;
					 int montantChambre=0;
					try {
						PdfWriter.getInstance(fact, op);
						fact.open();
						Calendar cal=new java.util.GregorianCalendar();
						int dJour=cal.get(Calendar.DAY_OF_MONTH);
						String dateJ="";
						if(dJour<10){
							dateJ="0"+dJour;
						}else dateJ=""+dJour;
						
						int dm=Integer.parseInt(""+cal.get(Calendar.MONTH))+1;
		fact.add(new Paragraph("MAISON MEDICALE DE BUJUMBURA                                Bujumbura, le "+dateJ+"/"+dm+"/"+cal.get(Calendar.YEAR)));
		fact.add(new Paragraph("B.P:3198"));
		fact.add(new Paragraph("Tél:218929"));
		fact.add(new Paragraph("Compte BANCOBU: 301-08395-01-47"));
		fact.add(new Paragraph("NIF:4000088551"));
		fact.add(new Paragraph("       ")); fact.add(new Paragraph("       ")); 
		 mysql c=new mysql();
		
		System.out.println("Date Today:"+cal.get(Calendar.DAY_OF_MONTH)+"/"+dm+"/"+cal.get(Calendar.YEAR));
		
		Paragraph p=new Paragraph("FACTURE N°.........../"+cal.get(Calendar.YEAR));
		p.setAlignment(Element.ALIGN_CENTER);
		
		fact.add(p);
		Paragraph p1=new Paragraph("--------------------------------------");
		p1.setAlignment(Element.ALIGN_CENTER);
		fact.add(p1);
		fact.add(new Paragraph(""));

		System.out.println("Somme en toute lettre:"+this.sommeLettre);
		
//
fact.add(new Paragraph(""+this.nom+" "+this.prenom+" doit à la Maison Médicale de Bujumbura une somme de "+sommeL.toUpperCase()+" pour hospitalisation" +" et soins médicaux. "));		
		fact.add(new Paragraph("       ")); 

		f.facturePat(8);
		fact.add(new Paragraph("Hospitalisation du "+f.dateEntre+" au "+f.dateSort));
			
	    fact.add(new Paragraph("Chambre                                      :  "+f.nbjourHosp+"           "+f.prix+"             "+f.montantChambre));
						
							if(f.countVisiteSpec>0)
						fact.add(new Paragraph("Visite du medecin Specialiste      :  "+f.countVisiteSpec+"      "+f.prixVisiteSpec+"                       "+f.sommeVisiteSpec));
							
							if(f.countVisiteGen>0)
						fact.add(new Paragraph("Visite du medecin Géneraliste     :  "+f.countVisiteGen+"         "+f.prixVisiteGen+"                      "+f.sommeVisiteGen));
					 String req="SELECT * FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
								" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" GROUP BY p.idPrestation ";
					 
					 //System.out.println("Req1:"+req);
						
						ResultSet res2=c.selectbd(req);
						int nbPresta=0;
						int prix=0;
						int sommePaye=0;
						int sommePrest=0;
						try {
							while(res2.next()){
								prix=res2.getInt("prix");
					String req1="SELECT COUNT(nomPresta) AS nbrePresta FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
								" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" AND fh.idPrestation='"+res2.getInt("idPrestation")+"'";
					// System.out.println("Req2:"+req1);
								ResultSet res3=c.selectbd(req1);
						
						if(res3.next()){
							nbPresta=res3.getInt("nbrePresta");
			fact.add(new Paragraph(""+res2.getString("nomPresta")+"                                           :  "+res3.getInt("nbrePresta")+"            "+res2.getInt("prix")+"              "+res2.getInt("prix")*res3.getInt("nbrePresta")));
							sommePrest=prix*nbPresta;
							//System.out.println(" Somme Prest:"+sommePrest);
						}
						sommePaye+=sommePrest;
						//System.out.println(" Somme à Payer:"+sommePaye);
							}
							
							sommePaye=sommePaye+(f.sommeVisiteSpec+f.sommeVisiteGen+f.montantChambre);
					
							fact.add(new Paragraph("Total                                                             "+sommePaye));
							System.out.println("Total="+sommePaye);
							fact.add(new Paragraph("  "));
				fact.add(new Paragraph("Nous disons "+sommeL.toUpperCase()+"."));  fact.add(new Paragraph("  "));fact.add(new Paragraph("  "));
				
				fact.add(new Paragraph("  "));  fact.add(new Paragraph("  "));fact.add(new Paragraph("  "));
				Paragraph fin1=new Paragraph("Pour la Maison Médicale de Bujumbura");
				fin1.setAlignment(Element.ALIGN_RIGHT);
				fact.add(fin1);
				
				Paragraph fin2=new Paragraph("Mme KANYANGE Angelique");
				fin2.setAlignment(Element.ALIGN_RIGHT);
				fact.add(fin2);
				
				Paragraph fin3=new Paragraph("Coordinatrice Administrative et Financière.");
				fin3.setAlignment(Element.ALIGN_RIGHT);
				fact.add(fin3);
				
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} 
						catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						fact.close();
						
								
					  }catch (DocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					 // finally{
//							
//							pdf.responseComplete();
//							
						//} 
//					catch (IOException e) {
//					
//					e.printStackTrace();
					  
					 
			
					
	  }finally{
			
		//pdf.responseComplete();
		
		} 
	  return op;
	  	}
	  public int sommeAPayer(){
		  facture f=new facture();
		  	//this.idFiche=this.selected.idFiche;
		  f.facturePat(this.idFiche);
		  
		  String req="SELECT * FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
			" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" GROUP BY p.idPrestation ";

//System.out.println("Req1:"+req);
	 mysql c=new mysql();
	ResultSet res2=c.selectbd(req);
	int nbPresta=0;
	int prix=0;
	int sommePaye=0;
	int sommePrest=0;
	try {
		while(res2.next()){
			this.prix=res2.getInt("prix");
String req1="SELECT COUNT(nomPresta) AS nbrePresta FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
			" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" AND fh.idPrestation='"+res2.getInt("idPrestation")+"'";
//System.out.println("Req2:"+req1);
			ResultSet res3=c.selectbd(req1);
	
	if(res3.next()){
		nbPresta=res3.getInt("nbrePresta");
//fact.add(new Paragraph(""+res2.getString("nomPresta")+"             "+res3.getInt("nbrePresta")+"       "+res2.getInt("prix")*res3.getInt("nbrePresta")));
		sommePrest=this.prix*nbPresta;
		//System.out.println(" Somme Prest:"+sommePrest);
	}
	sommePaye=sommePaye+sommePrest;
	//System.out.println(" Somme à Payer:"+sommePaye);
		}
		System.out.println("Somme pour prestation="+sommePaye);
		sommePaye=sommePaye+(f.sommeVisiteSpec+f.sommeVisiteGen+f.montantChambre);
		
		//fact.add(new Paragraph("Total                  "+sommePaye));
		System.out.println("Somme="+sommePaye);
		  
	  }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return sommePaye;
	}
	  
	  private int nbreJ;
	  
	  public int getNbreJ() {
		  facture f=new facture();
		  f.facturePat(this.idFiche);
		  this.nbreJ=f.nbjourHosp;
		  System.out.println("IdFichePat:"+this.idFiche);
		return nbreJ;
	}
	  
	public void setNbreJ(int nbreJ) {
		this.nbreJ = nbreJ;
	}
	private int sommeTotal;
	  

	public int getSommeTotal() {
		this.sommeTotal=this.sommeAPayer();
		return sommeTotal;
	}


	public void setSommeTotal(int sommeTotal) {
		this.sommeTotal = sommeTotal;
	}

	public String getSommeL(){
		return this.getSommeLettre();
	}
	
	public String sommeLettre;
	

	public String getSommeLettre() {
		return sommeLettre;
	}


	public void setSommeLettre(String sommeLettre) {
		this.sommeLettre = sommeLettre;
	}


	public void getSommeEnLettre(){
		this.getSommeLettre();
	}



	public facture(){
		
	}
	
public String traitementDate1(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
	}

		public static long differenceDate(Date date1, Date date2)
		{
			long UNE_HEURE = 60 * 60 * 1000L;
		  return ((date2.getTime() - date1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
		}
		
		
	public void factureClicked(ValueChangeEvent event){
		
	    String valueReceive=""+event.getNewValue();
		
		System.out.println("La valeur recu:"+valueReceive);
		
		if(valueReceive.equalsIgnoreCase("ambulant")){ 
			
			this.ambulant=true;
			this.hospitalise=false;
			
			System.out.println("ambulant:"+this.ambulant);
			System.out.println("hospitalisé:"+this.hospitalise);
		}
		else{
			
			this.ambulant=false;
			this.hospitalise=true;
			
		}
	}
	  public String traitementDateTime(java.util.Date data){
			if(data==null)
				return "";
			SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return form.format(data);	
		}
	  
	  
	public String getSearchFact() {
		return searchFact;
	}

	public void setSearchFact(String searchFact) {
		this.searchFact = searchFact;
	}
	
	
	public int getIdDetail() {
		return idDetail;
	}


	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}


	public List<facture> getListConsultNonPaye() {
		this.listConsultNonPaye=new ArrayList<facture>();
		 String req=" SELECT * FROM detailprestation d" +
		 			" JOIN prestation p ON p.idPrestation = d.idPrestation" +
		 			" JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
		 			" JOIN prix pr ON pr.idPrix = p.idPrix" +
		 			" JOIN rendezVous rv ON rv.idRendezvous=d.idRendezVous" +
		 			" JOIN patient pa ON pa.idPatient=rv.idPatient" +
		 			" JOIN personne pe ON pe.idPersonne=pa.idPersonne" +
		 			" Where pa.codePatient LIKE '"+this.searchFact+"%' OR pe.nom LIKE '"+this.searchFact+"%'" +
		 			" OR pe.prenom LIKE '"+this.searchFact+"%' HAVING cp.nomCatPresta='consultation' AND d.paiement=0";
		 
		 //System.out.println("Get Cons"+req);
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(req);
		 
		 try {
			while(res.next()){
				facture f=new facture();
				f.idDetail=res.getInt("idDetail");
				f.idRendezVs=res.getInt("idRendezVous");
				f.codePerso=res.getString("codePatient");
				f.nom=res.getString("nom");
				f.prenom=res.getString("prenom");
				f.nomPresta=res.getString("nomPresta");
				f.prix=res.getInt("prix");
				
				//System.out.println(f.idDetail+" "+f.codePerso+" "+f.nom+" "+f.prenom+" "+f.prix);
				this.listConsultNonPaye.add(f);
			}
				 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listConsultNonPaye;
	}


	public void setListConsultNonPaye(List<facture> listConsultNonPaye) {
		this.listConsultNonPaye = listConsultNonPaye;
	}


	public List<facture> getListDetailNonPaye() {
		this.listDetailNonPaye=new ArrayList<facture>();
		 String req=" SELECT * FROM detailprestation d" +
			" JOIN prestation p ON p.idPrestation = d.idPrestation" +
			" JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
			" JOIN prix pr ON pr.idPrix = p.idPrix" +
			" JOIN rendezVous rv ON rv.idRendezvous=d.idRendezVous" +
			" JOIN patient pa ON pa.idPatient=rv.idPatient" +
			" JOIN personne pe ON pe.idPersonne=pa.idPersonne" +
			" Where pa.codePatient LIKE '"+this.searchFact+"%' OR pe.nom LIKE '"+this.searchFact+"%'" +
			" OR pe.prenom LIKE '"+this.searchFact+"%' HAVING cp.nomCatPresta!='CONSULTATION' AND d.paiement=0";

				//System.out.println("Get Cons"+req);
				mysql c=new mysql();
				ResultSet res=c.selectbd(req);

try {
	while(res.next()){
		facture f=new facture();
		f.idDetail=res.getInt("idDetail");
		f.idRendezVs=res.getInt("idRendezVous");
		f.codePerso=res.getString("codePatient");
		f.nom=res.getString("nom");
		f.prenom=res.getString("prenom");
		f.nomPresta=res.getString("nomPresta");
		f.prix=res.getInt("prix");
		
		//System.out.println(f.idDetail+" "+f.codePerso+" "+f.nom+" "+f.prenom+" "+f.prix);
		this.listDetailNonPaye.add(f);
	}
		 
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return listDetailNonPaye;
	}


	public void setListDetailNonPaye(List<facture> listDetailNonPaye) {
		this.listDetailNonPaye = listDetailNonPaye;
	}

	
	public void backInfoFact(){
		this.getListConsultNonPaye();
		this.getListDetailNonPaye();
	}
	
	
	private float montantRestant;
	
	public float getMontantRestant() {
		return montantRestant;
	}

	public void setMontantRestant(float montantRestant) {
		this.montantRestant = montantRestant;
	}


	public void payeConsultation(){
		System.out.println("IdDetail:"+this.selected.idDetail+" "+this.selected.idRendezVs);
		String req="UPDATE detailPrestation SET paiement=1 WHERE idDetail='"+this.selected.idDetail+"'";
		
		System.out.println("Req update:"+req);
	
		mysql c=new mysql();
		String getDetailPresta="SELECT * FROM facture WHERE idRendezVous='"+this.selected.idRendezVs+"'";
		ResultSet res=c.selectbd(getDetailPresta);
		int idFact=0;
		try {
			if(res.next()){
				this.montantRestant=res.getFloat("montantRestant");
				idFact=res.getInt("idFacture");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float montantR=this.montantRestant-this.selected.prix;
		String updateFact="UPDATE facture SET montantRestant="+montantR+" WHERE idRendezVous='"+this.selected.idRendezVs+"'";
		System.out.println("Montant restant:"+updateFact);
		
		String reqRecu="INSERT INTO recu(idFacture, montantPaye) VALUES("+idFact+", "+this.selected.prix+") ";
		int i=-1, u=-1, v=-1;
		
		i=c.updatebd(req);
		
		if(i>0){
			    u=c.updatebd(updateFact);
				if(u>0){
					
					
					System.out.println("Recu:"+reqRecu);
					v=c.updatebd(reqRecu);
						if(v>0){
							this.errorPaye=true;
							this.messagePaye="Payement de "+this.selected.prix+"F";
							System.out.println(this.messageFact);
						}
				}
		}
	}
	
		
	public int getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}


	public boolean isStatusPaye() {
		return statusPaye;
	}


	public void setStatusPaye(boolean statusPaye) {
		this.statusPaye = statusPaye;
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


	public List<facture> getListPatientDejaPaye() {
		FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		this.idMedecin=Integer.parseInt(idUtilisateur);
		
		this.listPatientDejaPaye=new ArrayList<facture>();
		
		mysql sql=new mysql();
		
		String requetePatient="select * from detailprestation dp" +
				" join rendezvous re on re.idRendezVous=dp.idRendezVous" +
				" join patient pa on pa.idPatient=re.idPatient" +
				" join personne pe on pe.idPersonne=pa.idPersonne" +
				" join prestation pre on pre.idPrestation=dp.idPrestation" +
				" join categoriepresta cp on cp.idCatPresta=pre.idCatPresta" +
				" join service se on se.idService=re.idService" +
				" join servicemed sem on sem.idService=se.idService" +
				" join medecin me on me.idMedecin=sem.idMedecin" +
				" where re.dateRendezVous>=CURRENT_DATE() and me.idMedecin='"+this.idMedecin+"' and cp.nomCatPresta='consultation'";
		
		
		System.out.println("Dooo:"+requetePatient);
		ResultSet res=sql.selectbd(requetePatient);
		
		try {
			while(res.next()){
  facture pa=new facture();
				  
				  pa.codePerso=res.getString("codePatient");
				  pa.nom=res.getString("nom");
				  pa.prenom=res.getString("prenom");
				  pa.nomService=res.getString("nomService");
				  pa.nomCatPresta=res.getString("nomCatPresta");
				  pa.nomPresta=res.getString("nomPresta");
				  pa.dateRendezVous=res.getDate("dateRendezVous");
				  pa.statusPaye=res.getBoolean("paiement");
				  if(pa.statusPaye==true){
					  
					  pa.statusValue="Déjà payé";
					  
					  pa.validate=true;
				  }
				  else{
					  
					  pa.statusValue="Non payé";
					  pa.validate=false;
				  }
				  
				  
				  System.out.println(pa.codePerso+" "+pa.nom+" "+pa.statusPaye+" "+pa.statusValue);
				  this.listPatientDejaPaye.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPatientDejaPaye;
	}


	public void setListPatientDejaPaye(List<facture> listPatientDejaPaye) {
		this.listPatientDejaPaye = listPatientDejaPaye;
	}

	//Fonction générant pdf pour un patient ambulant 
	public void testAmbulat(){
		FacesContext pdf=FacesContext.getCurrentInstance();
		System.out.println("idFacture:"+this.idFact);
		facture f=new facture();
		//f.facturePat(this.idFiche);
		try {
			pdf.getExternalContext().dispatch("/receptionniste/fact.xhtml?partest=ambulant&par2=126&idFacture="+this.idFact+"&codeFacture="+this.codeFacture+"&idRendez="+this.idRendezVs+"&nomP="+this.nom+"&prenomP="+this.prenom+"");
			System.out.println("PDF:"+pdf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			pdf.responseComplete();
		}
		
	}
	
	//Fonction générant pdf pour un patient hospitalisé 
	public void test(){
		FacesContext pdf=FacesContext.getCurrentInstance();
		System.out.println("id Fiche med:"+this.idFiche);
		facture f=new facture();
		f.facturePat(this.idFiche);
		try {
			pdf.getExternalContext().dispatch("/receptionniste/fact.xhtml?partest=buja&par2=125&idF="+this.idFiche+"&nomP="+this.nom+"&prenomP="+this.prenom+"");
			System.out.println("PDF:"+pdf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			pdf.responseComplete();
		}
		
	}
	
	public void doPost(HttpServletRequest requete,HttpServletResponse reponse){
		
		System.out.println(requete.getParameter("partest")+" "+requete.getParameter("par2")+" "+requete.getParameter("idF")+" "+requete.getParameter("nomP")+" "+requete.getParameter("prenomP"));
		System.out.println(requete.getParameter("partest")+" "+requete.getParameter("par2")+" "+requete.getParameter("idFacture")+" "+requete.getParameter("nomP")+" "+requete.getParameter("prenomP"));
		
		this.nom=requete.getParameter("nomP");
		this.prenom=requete.getParameter("prenomP");
		
		ByteArrayOutputStream op=null;
		ByteArrayOutputStream opAmb=null;
			if(requete.getParameter("partest").equals("buja")){
				this.idFiche=Integer.parseInt(""+requete.getParameter("idF"));
				op=creationDocumentPDF(this.idFiche, this.nom, this.prenom);
				
				System.out.println("id Fiche m:"+this.idFiche);
				
				reponse.setHeader("Cache-control", "max-age=30");
				reponse.setContentType("application/pdf");
				reponse.setHeader("content-disposition", "inline;filename=bj.pdf");
				
				reponse.setContentLength(op.size());
				try {
					op.writeTo(reponse.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					op.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (op != null)
				{
				  op.reset();
				}
			}
		
		if(requete.getParameter("partest").equals("ambulant")){
			this.idFact=Integer.parseInt(""+requete.getParameter("idFacture"));
			this.codeFacture=requete.getParameter("codeFacture");
			opAmb=this.creationPDFAmbulant(this.idFact, this.codeFacture);
			
			//System.out.println("id Fiche m:"+this.idFiche);
			
			reponse.setHeader("Cache-control", "max-age=30");
			reponse.setContentType("application/pdf");
			reponse.setHeader("content-disposition", "inline;filename=bj.pdf");
			
			reponse.setContentLength(opAmb.size());
			try {
				opAmb.writeTo(reponse.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				opAmb.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (opAmb != null)
			{
				opAmb.reset();
			}
		}
		
		
	}
	
	//Fonction generant pdf pour un patient ambulant
	private ByteArrayOutputStream creationPDFAmbulant(int idFactu, String codeFac){
		facture f=new facture();
		ByteArrayOutputStream op=null;
		Document doc =new Document(PageSize.A4);
		System.out.println("Id f:"+idFactu);
		op=new ByteArrayOutputStream();
		
		try {
			PdfWriter.getInstance(doc, op);
			doc.addTitle("Test d'une page ");
			doc.addCreationDate();
			doc.addAuthor("Butoyi Fleury");
			doc.addProducer();
			doc.open();
			
			Calendar cal=new java.util.GregorianCalendar();
			int dJour=cal.get(Calendar.DAY_OF_MONTH);
			String dateJ="";
			if(dJour<10){
				dateJ="0"+dJour;
			}else dateJ=""+dJour;
			
			int dm=Integer.parseInt(""+cal.get(Calendar.MONTH))+1;
			//doc.add(new Paragraph("Date: "+dateJ+"/"+dm+"/ "+cal.get(Calendar.YEAR)));
			doc.add(new Paragraph("MAISON MEDICALE DE BUJUMBURA                                Bujumbura, le "+dateJ+"/"+dm+"/ "+cal.get(Calendar.YEAR)));
			doc.add(new Paragraph("B.P:3198"));
			doc.add(new Paragraph("Tél:218929"));
			doc.add(new Paragraph("Compte BANCOBU: 301-08395-01-47"));
			doc.add(new Paragraph("NIF:4000088551"));
			doc.add(new Paragraph("       ")); doc.add(new Paragraph("       ")); 
			
			Paragraph p=new Paragraph("FACTURE N° "+codeFac);
			p.setAlignment(Element.ALIGN_CENTER);
			doc.add(p);
			Paragraph p1=new Paragraph("-------------------------------------");
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			doc.add(new Paragraph(""));
			String sommeL="----------------------------------------------------------------";
			doc.add(new Paragraph(""+this.nom+" "+this.prenom+" doit à la Maison Médicale de Bujumbura une somme de "+sommeL.toUpperCase()+" pour prestations suivantes: "));		
			doc.add(new Paragraph("       ")); 
			//doc.add(new Paragraph("Mr/Mme "+this.nom+" "+this.prenom));
			//doc.add(new Paragraph("FDSDSD"));
			this.sommePaye=0;
			
			 /*String req="SELECT *  FROM facture f JOIN rendezVous rv ON rv.idRendezvous = f.idRendezVous" +
						" JOIN detailPrestation dp ON dp.idRendezvous = f.idRendezVous" +
						" JOIN patient pa ON pa.idPatient = rv.idPatient" +
						" JOIN personne pe ON pe.idPersonne = pa.idPersonne" +
						" GROUP BY f.CodeFacture";*/
			doc.add(new Paragraph(" "));
			 String req1="SELECT * FROM detailprestation dp " +
			 			 " JOIN facture f ON f.idRendezvous = dp.idRendezvous" +
			 			 " JOIN prestation p ON p.idPrestation=dp.idPrestation" +
			 			 " JOIN prix pr ON p.idPrix=pr.idPrix" +
			 			 " GROUP BY dp.idPrestation";
			 mysql sql=new mysql();
			 ResultSet res=sql.selectbd(req1);
			 
			 try {
				while(res.next()){
					//facture f1=new facture();
					//doc.add(new Paragraph("  "));doc.add(new Paragraph("  ")); doc.add(new Paragraph("  "));
					
					//fact.add(new Paragraph("Visite du medecin Specialiste      :  "+f.countVisiteSpec+"      "+f.prixVisiteSpec+"                       "+f.sommeVisiteSpec));
					
					doc.add(new Paragraph(""+res.getString("nomPresta")+"                        "+res.getInt("prix")));
					this.sommePaye+=res.getInt("prix");
				 }
				//this.sommePaye+=this.sommePaye;
				doc.add(new Paragraph("Total                         "+this.sommePaye));
				
				doc.add(new Paragraph("  "));
				doc.add(new Paragraph("Nous disons "+sommeL.toUpperCase()+"."));  doc.add(new Paragraph("  ")); doc.add(new Paragraph("  "));
	
				doc.add(new Paragraph("  "));  doc.add(new Paragraph("  ")); doc.add(new Paragraph("  "));
	Paragraph fin1=new Paragraph("Pour la Maison Médicale de Bujumbura");
	fin1.setAlignment(Element.ALIGN_RIGHT);
	doc.add(fin1);
	
	/*Paragraph fin2=new Paragraph("Mme KANYANGE Angelique");
	fin2.setAlignment(Element.ALIGN_RIGHT);
	doc.add(fin2);
	
	Paragraph fin3=new Paragraph("Coordinatrice Administrative et Financière");
	fin3.setAlignment(Element.ALIGN_RIGHT);
	doc.add(fin3);*/
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			System.out.println("Id fa:"+idFactu);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc.close();
		
		return op;
		
	}
	
	//Fonction generant pdf pour un patient hospitalisé
	private ByteArrayOutputStream creationDocumentPDF(int idF, String nom, String prenom){
		facture f=new facture();	
//		int idFi=f.test();
		 //System.out.println("Somme:"+sommeL);
		 int nbjourHosp=0;
		 int montantChambre=0;
		 String sommeL="----------------------------------------------------------------";
		ByteArrayOutputStream op=null;
		Document doc =new Document(PageSize.A4);
		this.idFiche=idF;
		op=new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(doc, op);
			
			doc.addTitle("Test d'une page ");
			doc.addCreationDate();
			doc.addAuthor("Butoyi Fleury");
			doc.addProducer();
			doc.open();
			doc.add(new Paragraph(this.sommeLettre));
			System.out.println("Somme p:"+this.sommeLettre);
			//doc.add(new Paragraph("Hello word"));
			Calendar cal=new java.util.GregorianCalendar();
			int dJour=cal.get(Calendar.DAY_OF_MONTH);
			String dateJ="";
			if(dJour<10){
				dateJ="0"+dJour;
			}else dateJ=""+dJour;
			
				int dm=Integer.parseInt(""+cal.get(Calendar.MONTH))+1;
				doc.add(new Paragraph("MAISON MEDICALE DE BUJUMBURA                                Bujumbura, le "+dateJ+"/"+dm+"/ "+cal.get(Calendar.YEAR)));
				doc.add(new Paragraph("B.P:3198"));
				doc.add(new Paragraph("Tél:218929"));
				doc.add(new Paragraph("Compte BANCOBU: 301-08395-01-47"));
				doc.add(new Paragraph("NIF:4000088551"));
				doc.add(new Paragraph("       ")); doc.add(new Paragraph("       ")); 
				mysql c=new mysql();
				
				System.out.println("Date Today:"+cal.get(Calendar.DAY_OF_MONTH)+"/"+dm+"/ "+cal.get(Calendar.YEAR));
				
				//Recuperation du code de la facture
				String reqCodeFact="SELECT * FROM facture WHERE idFiche="+idF+"";
				ResultSet rFact=c.selectbd(reqCodeFact);
				String codeFact=null;
				try {
					if(rFact.next()){
						codeFact=rFact.getString("CodeFacture");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Paragraph p=new Paragraph("FACTURE N°.........../"+cal.get(Calendar.YEAR));
				Paragraph p=new Paragraph("FACTURE N° "+codeFact);
				p.setAlignment(Element.ALIGN_CENTER);
				
				doc.add(p);
				Paragraph p1=new Paragraph("-------------------------------------");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.add(new Paragraph(""));
			//doc.add(createTable());
				doc.add(new Paragraph(""+nom+" "+prenom+" doit à la Maison Médicale de Bujumbura une somme de "+sommeL.toUpperCase()+" pour hospitalisation" +" et soins médicaux. "));		
				doc.add(new Paragraph("       ")); 
				f.facturePat(this.idFiche);
				//System.out.print(f.facturePat(idF));
				
				System.out.println("Id fiche med hosp:"+idF);
				doc.add(new Paragraph("Hospitalisation du "+f.dateEntre+" au "+f.dateSort));
					
				doc.add(new Paragraph("Chambre                                      :  "+f.nbjourHosp+"           "+f.prix+"             "+f.montantChambre));
				
				if(f.countVisiteSpec>0)
					doc.add(new Paragraph("Visite du medecin Specialiste      :    "+f.countVisiteSpec+"      "+f.prixVisiteSpec+"                       "+f.sommeVisiteSpec));
				
				if(f.countVisiteGen>0)
					doc.add(new Paragraph("Visite du medecin Géneraliste     :     "+f.countVisiteGen+"         "+f.prixVisiteGen+"                      "+f.sommeVisiteGen));
					
				 String req="SELECT * FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
							" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" GROUP BY p.idPrestation ";
				 ResultSet res2=c.selectbd(req);
					int nbPresta=0;
					int prix=0;
					int sommePaye=0;
					int sommePrest=0;
					
					try {
						while(res2.next()){
							prix=res2.getInt("prix");
				String req1="SELECT COUNT(nomPresta) AS nbrePresta FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
							" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+this.idFiche+" AND fh.idPrestation='"+res2.getInt("idPrestation")+"'";
				// System.out.println("Req2:"+req1);
							ResultSet res3=c.selectbd(req1);
					
					if(res3.next()){
						nbPresta=res3.getInt("nbrePresta");
						doc.add(new Paragraph(""+res2.getString("nomPresta")+"                                           :  "+res3.getInt("nbrePresta")+"            "+res2.getInt("prix")+"              "+res2.getInt("prix")*res3.getInt("nbrePresta")));
						sommePrest=prix*nbPresta;
						//System.out.println(" Somme Prest:"+sommePrest);
					}
					sommePaye+=sommePrest;
					//System.out.println(" Somme à Payer:"+sommePaye);
						}
						
						sommePaye=sommePaye+(f.sommeVisiteSpec+f.sommeVisiteGen+f.montantChambre);
				
						doc.add(new Paragraph("Total                                                             "+sommePaye));
						System.out.println("Total="+sommePaye);
						doc.add(new Paragraph("  "));
						doc.add(new Paragraph("Nous disons "+sommeL.toUpperCase()+"."));  doc.add(new Paragraph("  ")); doc.add(new Paragraph("  "));
			
						doc.add(new Paragraph("  "));  doc.add(new Paragraph("  ")); doc.add(new Paragraph("  "));
			Paragraph fin1=new Paragraph("Pour la Maison Médicale de Bujumbura");
			fin1.setAlignment(Element.ALIGN_RIGHT);
			doc.add(fin1);
			
			Paragraph fin2=new Paragraph("Mme KANYANGE Angelique");
			fin2.setAlignment(Element.ALIGN_RIGHT);
			doc.add(fin2);
			
			Paragraph fin3=new Paragraph("Coordinatrice Administrative et Financière");
			fin3.setAlignment(Element.ALIGN_RIGHT);
			doc.add(fin3);
			
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		doc.close();
		
		return op;
		
	}
	
	
	public int getIdFact() {
		return idFact;
	}


	public void setIdFact(int idFact) {
		this.idFact = idFact;
	}


	public float getSommeFactureAmbulant() {
		return sommeFactureAmbulant;
	}

	
	public void setSommeFactureAmbulant(float sommeFactureAmbulant) {
		this.sommeFactureAmbulant = sommeFactureAmbulant;
	}

	

	public String getDateFact() {
		return dateFact;
	}


	public void setDateFact(String dateFact) {
		this.dateFact = dateFact;
	}

	
	public List<facture> getListFactAmbulant() {
		this.listFactAmbulant=new ArrayList<facture>();
		 String req="SELECT * FROM facture f JOIN rendezVous rv ON rv.idRendezvous=f.idRendezVous" +
					" JOIN detailPrestation dp ON dp.idRendezvous=f.idRendezVous " +
					" JOIN patient pa ON pa.idPatient=rv.idPatient" +
					" JOIN personne pe ON pe.idPersonne=pa.idPersonne" +
					" GROUP BY f.CodeFacture";
		 
		 mysql sql=new mysql();
		 ResultSet res=sql.selectbd(req);
		 
		 try {
			while(res.next()){
				 facture f=new facture();
				 f.idPatient=res.getInt("idPatient");
				 f.idFact=res.getInt("idFacture");
				 f.codePerso=res.getString("codePatient");
				 f.codeFacture=res.getString("CodeFacture");
				 f.nom=res.getString("nom");
				 f.prenom=res.getString("prenom");
				 f.sommeFactureAmbulant=res.getFloat("somme");
				 f.montantRestant=res.getFloat("montantRestant");
				 f.dateFact=res.getString("dateF");
				 this.listFactAmbulant.add(f);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listFactAmbulant;
	}


	public void setListFactAmbulant(List<facture> listFactAmbulant) {
		this.listFactAmbulant = listFactAmbulant;
	}


	public static void main(String[] tab){
		facture f=new facture();
		//f.facturePat();
		
		//f.getListPatientSortie();
	
			//f.printFacture();

//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			Date date=null;
//			
//			try
//			{
//			date= df.parse("2013-11-02");
//			int jour=date.getDate();
//			String j="";
//			
//				if(jour<10){
//					j="0"+jour;
//				}else{
//					j=""+jour;
//				}
//			
//			int mois=date.getMonth();
//			int annee=date.getYear()+1900;
//			System.out.println(j+"/"+mois+"/"+annee);
//			} catch (ParseException e){
//			e.printStackTrace();
//			} 
		Calendar c1 = new GregorianCalendar();
	    Calendar c2 = new GregorianCalendar();
	    c1.set(2011, 11, 02, 0, 0, 0);
	    c2.set(2011, 11, 10, 0, 0, 0);
//	 
	    System.out.println(differenceDate(c1.getTime(), c2.getTime())+" jour(s) Entre les deux Date");

			
	    
	    /** L'heure du départ*/
        Date heure1 = new GregorianCalendar(2011,11,31,10,43).getTime( );

        /** L'heure d'arrivée*/
        Date heure2= new GregorianCalendar(2011,11,31,23,59).getTime();

        // Calcul de différence en nombre d'heures entre les deux heures
        long diff = heure2.getTime( ) - heure1.getTime( );

        // Afficher le résultat sur le console
        System.out.println("Différence en nombre d'heure entre "+heure1+ " et " + heure2+
                " \nest " + (diff / (1000*60*60)) + " Heures.");
       
        
	}
}
