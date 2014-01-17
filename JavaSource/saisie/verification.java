package saisie;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.richfaces.component.UIScrollableDataTable;
import org.richfaces.model.selection.SimpleSelection;

import com.lowagie.text.Paragraph;

  public class verification implements Serializable{
	    
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	  private String codePerso;
	  private String nom;
	  private String prenom;
	  private String genre;
	  private Date dateNaissance;
	  private String adresse;
	  private Date dateAttribution;
	  private Date dateRendezVous;
	  private Date dateConsultation;
	  private String statusValue;
	  private boolean status;
	  private boolean validate;
	  private boolean viewbool;
	  private String nomService;
	  private List<verification>listPatient;
	  private int idPatient;
	  private int idRendezVous;
	  private verification selected;
	  private List<verification>listSuiviPatient;
	  private List<verification>listDetailsPatient;
	  private List<verification>listDetailsRendez;
	  private List<verification>listPatientResultat;
	  private List<verification>listPatientDecisionSortie;
	  private List<verification>listHospiCompteur;
	  private List<verification>listHospiRentreCompteur;
	  private String searchValue;
	  private String traitement;
	  private String nomPresta;
	  private boolean fait;
	  private String faitValue;
	  private String etat;
	  private String etatSortie;
	  private String message;
	  private boolean error=false;
	  private String profession;
	  private String email;
	  private String telFixe;
	  private String telMob;
	  private String resultat;
	  private int idFiche;
	  private String codeChambre;
	  private String motif;
	  private Date dateArrive;
	  private String rechercheValue;
	  private int idHosp;
	  private String observation;
	  private String temperature;
	  private String TA;
	  private String FC;
	  private String FR;
	  private int idMedecin;
	  private Date dateSortie;
	  private int idChambre;
	  private int tailleListe;
	  private int compteur;
	  
	  /*Objet for scrollable list*/
	  
	  //private static int DECIMALS = 1;
	  //private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	  private SimpleSelection selection = new SimpleSelection();
	  private UIScrollableDataTable table;
	  private ArrayList<verification> selectedPatient;
	  
	  /*public static int getDECIMALS() {
		return DECIMALS;
	}
	  public static void setDECIMALS(int decimals) {
			DECIMALS = decimals;
		}
     public static int getROUNDING_MODE() {
			return ROUNDING_MODE;
		}
	 public static void setROUNDING_MODE(int rounding_mode) {
			ROUNDING_MODE = rounding_mode;
		}
	 
	
	
	
	public static int rand(int lo, int hi)
		{
		Random rn2 = new Random();
		int n = hi - lo + 1;
		int i = rn2.nextInt() % n;
		if (i < 0)
		i = -i;
		return lo + i;
		}
		public static String randomstring(int lo, int hi)
		{
		int n = rand(lo, hi);
		byte b[] = new byte[n];
		for (int i = 0; i < n; i++)
		b[i] = (byte)rand('A', 'Z');
		return new String(b);
		}
		
		public int genRand() {
			return rand(1,10000);
			
		}*/
		
	    
	   public SimpleSelection getSelection() {
			return selection;
		}
		public void setSelection(SimpleSelection selection) {
			this.selection = selection;
		}
		public UIScrollableDataTable getTable() {
			return table;
		}
		public void setTable(UIScrollableDataTable table) {
			this.table = table;
		}
	    public ArrayList<verification> getSelectedPatient() {
			return selectedPatient;
		}
		public void setSelectedPatient(ArrayList<verification> selectedPatient) {
			this.selectedPatient = selectedPatient;
		}
		public String takeSelection() {
			selectedPatient = new ArrayList<verification>();
			Iterator<Object> iterator = getSelection().getKeys();
			while (iterator.hasNext()){
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
			this.getSelectedPatient().add((verification) table.getRowData());
			}
			}
			return null;
			}
	  /**/
	  
	  
	  
	
	
	
		
	public int getIdHosp() {
		return idHosp;
	}

    public int getCompteur() {
		return compteur;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	public int getTailleListe() {
		return tailleListe;
	}
	public void setTailleListe(int tailleListe) {
		this.tailleListe = tailleListe;
	}
	public int getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public int getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}
	public void setIdHosp(int idHosp) {
		this.idHosp = idHosp;
	}




	public String getObservation() {
		return observation;
	}




	public void setObservation(String observation) {
		this.observation = observation;
	}




	public String getTemperature() {
		return temperature;
	}




	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}




	public String getTA() {
		return TA;
	}




	public void setTA(String ta) {
		TA = ta;
	}




	public String getFC() {
		return FC;
	}




	public void setFC(String fc) {
		FC = fc;
	}




	public String getFR() {
		return FR;
	}




	public void setFR(String fr) {
		FR = fr;
	}




	public Date getDateConsultation() {
		return dateConsultation;
	}




	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}




	public String getRechercheValue() {
		return rechercheValue;
	}




	public void setRechercheValue(String rechercheValue) {
		this.rechercheValue = rechercheValue;
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




	public int getIdFiche() {
		return idFiche;
	}




	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}




	public String getResultat() {
		return resultat;
	}




	public void setResultat(String resultat) {
		this.resultat = resultat;
	}




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




	public boolean isError() {
		return error;
	}




	public void setError(boolean error) {
		this.error = error;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public boolean isViewbool() {
		return viewbool;
	}




	public void setViewbool(boolean viewbool) {
		this.viewbool = viewbool;
	}




	public String getFaitValue() {
		return faitValue;
	}




	public void setFaitValue(String faitValue) {
		this.faitValue = faitValue;
	}




	public String getTraitement() {
		return traitement;
	}




	public void setTraitement(String traitement) {
		this.traitement = traitement;
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




	public String getEtat() {
		return etat;
	}




	public void setEtat(String etat) {
		this.etat = etat;
	}

	


	public String getEtatSortie() {
		return etatSortie;
	}
	public void setEtatSortie(String etatSortie) {
		this.etatSortie = etatSortie;
	}
	public boolean isValidate() {
		return validate;
	}




	public void setValidate(boolean validate) {
		this.validate = validate;
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




	public verification getSelected() {
		return selected;
	}




	public void setSelected(verification selected) {
		this.selected = selected;
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




	public Date getDateRendezVous() {
		return dateRendezVous;
	}




	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}




	



	

    


	public String getStatusValue() {
		return statusValue;
	}




	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public int getIdPatient() {
		return idPatient;
	}




	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}




	public int getIdRendezVous() {
		return idRendezVous;
	}




	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

    


	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public List<verification> getListPatient() {
		
		this.listPatient=new ArrayList<verification>();
		
		String requetePatient="select distinct pe.nom,pe.prenom,pa.codePatient,pa.idPatient from patient pa" +
				              " join personne pe on pe.idPersonne=pa.idPersonne" +
				              " join rendezvous re on re.idPatient=pa.idPatient" +
				              " order by pa.idPatient desc";
		
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requetePatient);
		
		try {
			while(res.next()){
				
				verification pa=new verification();
				
				pa.idPatient=res.getInt("idPatient");
				pa.nom=res.getString("nom");
				pa.prenom=res.getString("prenom");
				pa.codePerso=res.getString("codePatient");
				
				
				this.listPatient.add(pa);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPatient;
	}




	public void setListPatient(List<verification> listPatient) {
		this.listPatient = listPatient;
	}


/*La methode qui recupere la liste des prestations*/
	
	public ArrayList<verification>suggestionPatientSuivi(Object prefix){
		
		String keyword=((String)prefix).toLowerCase();
		
		
		ArrayList<verification>suggestions=new ArrayList<verification>();
		
		List<verification>tous=this.getListPatient();
		
		for(verification reponse:tous){
			
			if(reponse.codePerso.toLowerCase().startsWith(keyword)||reponse.nom.toLowerCase().startsWith(keyword)||reponse.prenom.toLowerCase().startsWith(keyword)){
				
				suggestions.add(reponse);
			}
			
		}
		
		
		return suggestions;
	}
    
	
	
	
	  
	
	public List<verification> getListSuiviPatient() {
		
		this.listSuiviPatient=new ArrayList<verification>();
		
	String requeteSuivi="select pe.nom,pe.prenom,pe.genre,pa.codePatient, pa.idPatient," +
						" re.dateRendezVous,se.nomService,re.status,fi.traitement," +
						" se.nomService,pre.nomPresta,fi.fait,fi.etat, fi.resultat from patient pa" +
						" join rendezvous re on re.idPatient=pa.idPatient" +
						" join personne pe on pe.idPersonne=pa.idPersonne" +
						" join fichemed fi on fi.idRendezVous=re.idRendezVous" +
						" join service se on se.idService=re.idService" +
						" join prestation pre on pre.idPrestation=fi.idPrestation" +
						" where pa.codePatient like '"+this.searchValue+"%'" +
				        " or pe.nom like '"+this.searchValue+"%'" +
				        " or pe.prenom like '"+this.searchValue+"%'" +
				        " order by pa.idPatient desc";
		
	System.out.println("Suivi patient:"+requeteSuivi);
		 mysql sql=new mysql();
		 
		 ResultSet res=sql.selectbd(requeteSuivi);
		 
		 verification fil=new verification();
		 fil.setCodePerso("");
		 
		 
		 
		 try {
			 
			 
			while(res.next()){
				
				verification pa=new verification();
					pa.idPatient=res.getInt("idPatient");
                if(!fil.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
                	
					pa.codePerso=res.getString("codePatient");
					pa.nom=res.getString("nom");
					pa.prenom=res.getString("prenom");
					pa.genre=res.getString("genre");
					
				
				}	
                
				fil.setCodePerso(res.getString("codePatient"));
				
				//pa.idPatient=res.getInt("idPatient");
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




	public void setListSuiviPatient(List<verification> listSuiviPatient) {
		this.listSuiviPatient = listSuiviPatient;
	}
	
	public void getDetailPat(){
		this.getListDetailsPatient();
	}
	public List<verification> getListDetailsPatient() {
		
		
     try{
			 
			 this.idPatient=this.selected.idPatient;
			 
		 }catch(NullPointerException e){
			 this.idPatient=0;
			 e.printStackTrace();
		 }
		 
		 
		 
		 System.out.println("L'idPatient"+idPatient);
		 this.listDetailsPatient=new ArrayList<verification>();
		 
		 String requetePatient="select pa.idPatient, pe.nom,pe.prenom,pa.profession,pe.email,pe.date_naissance,pe.tel_fixe,pe.tel_mob,pe.adresse,pa.codePatient from patient pa" +
		 		               " join personne pe on pe.idPersonne=pa.idPersonne" +
		 		               " where pa.idPatient='"+this.idPatient+"'";
		 
		   mysql sql=new mysql();
		   
		   ResultSet res=sql.selectbd(requetePatient);
		   
		   
		   
		   try {
			while(res.next()){
				
				verification pa=new verification();
				
                 
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
				
				this.listDetailsPatient.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listDetailsPatient;
	}




	public void setListDetailsPatient(List<verification> listDetailsPatient) {
		this.listDetailsPatient = listDetailsPatient;
	}




	public List<verification> getListDetailsRendez() {
		try{
			 
			 this.idPatient=this.selected.idPatient;
			 
		 }catch(NullPointerException e){
			 
			 e.printStackTrace();
		 }
		 
		this.listDetailsRendez=new ArrayList<verification>();
		
		String requeteRendez="select pa.idPatient, pa.codePatient,pe.nom,pe.prenom,re.dateRendezVous,re.dateAttribution,se.nomService,re.status from rendezvous re" +
				             " join patient pa on pa.idPatient=re.idPatient" +
				             " join personne pe on pe.idPersonne=pa.idPersonne" +
				             " join service se on se.idService=re.idService" +
				             " where pa.idPatient='"+this.idPatient+"'";
		System.out.println("Req rendez-vous:"+requeteRendez);
		mysql sql=new mysql();
		
		ResultSet res=sql.selectbd(requeteRendez);
		consultation cur=new consultation();
		cur.setCodePerso("");
		try {
			while(res.next()){
				
				verification pa=new verification();
					pa.idPatient=res.getInt("idPatient");
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




	public void setListDetailsRendez(List<verification> listDetailsRendez) {
		this.listDetailsRendez = listDetailsRendez;
	}

	
	/*La liste des prestations et leurs resultats*/
	
	 public List<verification> getListPatientResultat() {
		 
		 this.listPatientResultat=new ArrayList<verification>();
		 
		 String requeteResultat="select pe.nom,pe.prenom,pa.codePatient,se.nomService,pa.idPatient,pre.nomPresta,fi.resultat,re.idRendezVous,fi.idFiche from fichemed fi" +
		 		                " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
		 		                " join patient pa on pa.idPatient=re.idPatient" +
		 		                " join service se on se.idService=re.idService" +
		 		                " join personne pe on pe.idPersonne=pa.idPersonne" +
		 		                " join prestation pre on pre.idPrestation=fi.idPrestation" +
		 		                " where pa.codePatient like '"+this.searchValue+"%'" +
		 			            " or pe.nom like '"+this.searchValue+"%'" +
		 			            " or pe.prenom like '"+this.searchValue+"%'" +
		 						" order by pa.idPatient desc";
		 
		 
		 mysql sql=new mysql();
		 
		 ResultSet res=sql.selectbd(requeteResultat);
		 
		 verification cur=new verification();
	     cur.setCodePerso("");
		 try {
			while(res.next()){
				
				verification pa=new verification();
				
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




	public void setListPatientResultat(List<verification> listPatientResultat) {
			this.listPatientResultat = listPatientResultat;
		}

	
	
	
	/*La liste des patients hospitalisees*/
	
	
	public List<verification> getListPatientDecisionSortie() {
		
		this.listPatientDecisionSortie=new ArrayList<verification>();
		
		FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		 
		 
		 this.idMedecin=Integer.parseInt(idUtilisateur);
		
		String requeteDecision="select pe.nom,pe.prenom,pa.codePatient,re.dateRendezVous,se.nomService,re.idRendezVous,fi.dateConsultation," +
						        " fh.motif,fi.etat,fh.idFiche,cha.codeChambre,fh.idChambre,fh.idHosp,fh.dateArrive,fh.traitement,fh.observation,fh.temperature,fh.TA,fh.FC,fh.FR from fichehosp fh" +
						        " join fichemed fi on fi.idFiche=fh.idFiche" +
						        " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
						        " join patient pa on pa.idPatient=re.idPatient" +
						        " join personne pe on pe.idPersonne=pa.idPersonne" +
						        " join service se on se.idService=re.idService" +
						        " join chambre cha on cha.idChambre=fh.idChambre" +
						        " join servicemed sem on sem.idService=se.idService" +
						        " join medecin me on me.idMedecin=sem.idMedecin" +
						        " where me.idMedecin='"+this.idMedecin+"' and fh.status=1 and fh.dateSortie is null" +
		 			            " group by pa.idPatient"; 
		
						mysql sql=new mysql();
						
						ResultSet res=sql.selectbd(requeteDecision);
						
						System.out.println(requeteDecision);
						verification cur=new verification();
					    cur.setCodePerso("");
						try {
						while(res.next()){
						
						verification pa=new verification();
						
						if(!cur.getCodePerso().equalsIgnoreCase(res.getString("codePatient"))){
							
							pa.codePerso=res.getString("codePatient");
							pa.nom=res.getString("nom");
							pa.prenom=res.getString("prenom");
							
						
						}
						
						
						cur.setCodePerso(res.getString("codePatient"));
						pa.idFiche=res.getInt("idFiche");
						pa.idRendezVous=res.getInt("idRendezVous");
						pa.idHosp=res.getInt("idHosp");
						pa.idChambre=res.getInt("idChambre");
						pa.dateRendezVous=res.getDate("dateRendezVous");
						pa.dateConsultation=res.getDate("dateConsultation");
						pa.nomService=res.getString("nomService");
						pa.codeChambre=res.getString("codeChambre");
						pa.motif=res.getString("motif");
						pa.etat=res.getString("etat");
						pa.traitement=res.getString("traitement");
						pa.dateArrive=res.getDate("dateArrive");
						pa.observation=res.getString("observation");
						pa.temperature=res.getString("temperature");
						pa.TA=res.getString("TA");
						pa.FC=res.getString("FC");
						pa.FR=res.getString("FR");
						
						
						
						
						this.listPatientDecisionSortie.add(pa);
						
						this.tailleListe=this.listPatientDecisionSortie.size();
						if(tailleListe==0){
							
							this.message="Aucun patient hospitalisé pour le moment!";
							this.error=true;
							
							System.out.println(this.message);
						}
						else{
							
							this.message="Il y a "+this.tailleListe+" patient(s) hospitalisé pour le moment!";
							this.error=true;
							
							System.out.println(this.message);
							
						}
						}
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
				
		return listPatientDecisionSortie;
	}




	public void setListPatientDecisionSortie(
			List<verification> listPatientDecisionSortie) {
		this.listPatientDecisionSortie = listPatientDecisionSortie;
	}

	
   public List<verification> getListHospiCompteur() {
    	 
    	 this.listHospiCompteur=new ArrayList<verification>();
    	 
    	 
    	 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		 String idUtilisateur=session.getAttribute("idMedecin").toString();
		  
		 
		 
		 this.idMedecin=Integer.parseInt(idUtilisateur);
    	 
//    	 String requeteHospi="select count(*) as compteur from fichehosp fh" +
//    	 		             " join fichemed fi on fi.idFiche=fh.idFiche" +
//    	 		             " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
//    	 		             " join service se on se.idService=re.idService" +
//    	 		             " join servicemed sem on sem.idService=se.idService" +
//    	 		             " join medecin me on me.idMedecin=sem.idMedecin" +
//    	 		             " where me.idMedecin='"+this.idMedecin+"' and fh.status=1 and fh.dateSortie is null" +
//    	 		             " group by re.idPatient";
		 String requeteHospi="select count(*) as compteur from fichehosp fh" +
					         " join fichemed fi on fi.idFiche=fh.idFiche" +
					         " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
					         " join service se on se.idService=re.idService" +
					         " join servicemed sem on sem.idService=se.idService" +
					         " join medecin me on me.idMedecin=sem.idMedecin" +
					         " JOIN patient p ON p.idPatient=re.idPatient" +
					         " where me.idMedecin='"+this.idMedecin+"' and fh.status=1" +
					         " GROUP BY p.idPatient";
    	 
    	 mysql sql=new mysql();
    	 
    	 ResultSet res=sql.selectbd(requeteHospi);
    	 List<verification> listTailleHosp=new ArrayList<verification>();
    	 verification pat=new verification();
    	 try {
			while(res.next()){
				
				verification pa=new verification();
				
				pa.compteur=res.getInt("compteur");
				
				System.out.println("Le compteur:"+pa.compteur);
				
				listTailleHosp.add(pa);
				
			}
			pat.compteur=listTailleHosp.size();
			this.listHospiCompteur.add(pat);
			System.out.println("Taille liste:"+this.listHospiCompteur.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
 		return listHospiCompteur;
 		
 	}
 	public void setListHospiCompteur(List<verification> listHospiCompteur) {
 		this.listHospiCompteur = listHospiCompteur;
 		
 	}
 	
 	
 	public List<verification> getListHospiRentreCompteur() {
 		
 		this.listHospiRentreCompteur=new ArrayList<verification>();
 		
 		String requeteHRentre="select count(*) as compteur from fichehosp fh" +
					          " join fichemed fi on fi.idFiche=fh.idFiche" +
					          " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
					          " join service se on se.idService=re.idService" +
					          " join servicemed sem on sem.idService=se.idService" +
					          " join medecin me on me.idMedecin=sem.idMedecin" +
					          " JOIN patient p ON p.idPatient=re.idPatient" +
					          " where me.idMedecin='"+this.idMedecin+"' and fh.status=0" +
					          " GROUP BY p.idPatient";
 		
 		mysql sql=new mysql();
 		
 		ResultSet res=sql.selectbd(requeteHRentre);
 		List<verification> listTailleHospSortie=new ArrayList<verification>();
 		verification pat=new verification();
 		try {
			while(res.next()){
				
				verification pa=new verification();
				
				pa.compteur=res.getInt("compteur");
				listTailleHospSortie.add(pa);
			}
			pat.compteur=listTailleHospSortie.size();
			this.listHospiRentreCompteur.add(pat);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
 		
 		
 		return listHospiRentreCompteur;
 	}
 	public void setListHospiRentreCompteur(
 			List<verification> listHospiRentreCompteur) {
 		this.listHospiRentreCompteur = listHospiRentreCompteur;
 	}
	
	/*La methode qui gere le type date */
	
    public String traitementDate(Date data){
		
		if(data==null)
		  return "";
		java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
		
		return form.format(data);
	}
	
	
	
	
	
	/*La methode qui effectue la recherche*/
	
	
	public void backPatientInformation(){
		
		this.getListSuiviPatient();
	}
	
	
	/*La methode qui effectue la recherche dans la liste des resultats*/
	public void backPatientResultat(){
		
		this.getListPatientResultat();
	}
	
	/*La methode qui effectue la recherche des patients a sortir*/
	
	public void backPatientSortie(){
		
		this.getListPatientDecisionSortie();
	}
	/*La methode pour enregister et modifier les resultats des examens*/
	
	public void saisiResultat(){
		
		int updateValid=-1;
		
		this.idFiche=this.selected.idFiche;
		this.nomPresta=this.selected.nomPresta;
		this.resultat=this.selected.resultat;
		
		String requeteResultat="update fichemed set resultat='"+this.resultat+"' where idFiche='"+this.idFiche+"'";
		
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
	
	 public String traitementDateTime(java.util.Date data){
			if(data==null)
				return "";
			SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return form.format(data);	
		}
	 
	/*La methode pour sortir un patient*/
	
	public void sortirPatient(){
		
		verification v=new verification();
		this.dateSortie=new Date();
		int updateValid=-1;
		int updateChambre=-1;
		int updateEtatSortie=-1;
		int insertFact=-1;//Variable qui verifie si facture est enregistrer
		int modifCodeFact=-1;//Variable qui verifie si la modification du CodeFact de la facture est effectuée
		this.idHosp=this.selected.idHosp;
		this.idFiche=this.selected.idFiche;
		this.idRendezVous=this.selected.idRendezVous;
		this.idChambre=this.selected.idChambre;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.codeChambre=this.selected.codeChambre;
		Calendar cal=new java.util.GregorianCalendar();
		mysql sql=new mysql();
		String requeteSortie="update fichehosp set dateSortie='"+this.traitementDate(dateSortie)+"',status=0 where idFiche='"+this.idFiche+"'";
		String reqEtatSortie="UPDATE fichehosp SET etat='"+this.etatSortie+"' WHERE idHosp='"+this.idHosp+"'";
		
		
		java.util.Date d=new java.util.Date();
		
//	 String insertFacture=" INSERT INTO facture(modePayement, dateF, somme, idFiche, idRendezVous, montantRestant) " +
//							  " VALUES('', '"+this.traitementDateTime(d)+"', "+v.factTotal(this.idFiche)+", "+this.idFiche+"," +
//						  		" "+this.idRendezVous+", "+v.factTotal(this.idFiche)+")";
		
		
		
		//String insertFacture=""+this.idFiche+" "+this.traitementDateTime(d)+" "+this.idRendezVous;
	
		System.out.println(this.idRendezVous);
		System.out.println(requeteSortie);
		
		
		updateValid=sql.updatebd(requeteSortie);
		
		if(updateValid!=-1){
			updateEtatSortie=sql.updatebd(reqEtatSortie);
				if(updateEtatSortie>0){
					System.out.println(reqEtatSortie);
				}
		System.out.println("Somme total à payer pour sortie:"+this.factTotal(this.idFiche));	
			String requeteChambre="update chambre set status=1 where idChambre='"+this.idChambre+"'";
			
			float factureSomme=factTotal(this.idFiche);
			//Requete d'insertion dans facture si un patient hospitalisé est autorisé à sortir de l'hopital
			String insertFacture=" INSERT INTO facture(modePayement, dateF, somme, idFiche, idRendezVous, montantRestant) " +
			  " VALUES('', '"+this.traitementDateTime(d)+"', "+factureSomme+"" +
			  ", "+this.idFiche+", "+this.idRendezVous+"" +
			  ", "+factureSomme+")";
			 System.out.println("Création facture:"+insertFacture);
			 insertFact=sql.updatebd(insertFacture);
			 if(insertFact!=-1){
				 //Si la facture est enregistrée, on recuperere la dernière facture pour modifier son code
				 String getLastFact="SELECT * FROM facture ORDER BY idFacture DESC LIMIT 1";
				 ResultSet rFact=sql.selectbd(getLastFact);
				 String codeFacture=null;
				try {
					if(rFact.next())
					codeFacture = ""+rFact.getInt("idFacture")+"/"+cal.get(Calendar.YEAR);
					//System.out.println(rFact.getInt("idFacture"));
					System.out.println("Cod fff:"+codeFacture);
					String updateFact="UPDATE facture SET CodeFacture='"+codeFacture+"' WHERE idFacture="+rFact.getInt("idFacture")+" AND idRendezVous="+this.idRendezVous+"";
					modifCodeFact=sql.updatebd(updateFact);
					System.out.println("Modification code facture:"+updateFact);
					if(modifCodeFact!=-1){
						System.out.println("Modification code facture:"+updateFact);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 	
			 }
			 
			updateChambre=sql.updatebd(requeteChambre);
			 
			if(updateChambre!=-1){
				
				this.message="Le patient "+this.nom+" "+this.prenom+" peut sortir de l'hôpital\n et la chambre "+this.codeChambre+" est liberée";
				this.error=true;
				System.out.println(this.message);
				
			}
			
			
			
		}
		else{
			
			this.message="L'action a échouée";
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
	
	/*La methode pour garder les informations du patients*/
     public void patientSelected(){
		  
		  this.idPatient=this.selected.idPatient;
		  this.codePerso=this.selected.codePerso;
		  this.nom=this.selected.nom;
		  this.prenom=this.selected.prenom;
		  
	  }
     
     public static long differenceDate(Date date1, Date date2)
		{
			long UNE_HEURE = 60 * 60 * 1000L;
		  return ((date2.getTime() - date1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
		}
     
    public float factHosp(int idF){
    	float sommeTotale=0, sommeVisiteGen=0, sommeVisiteSpec=0;
    	int countVisiteGen=0;//Compteur du nombre de visite du medecin generaliste
    	int countVisiteSpec=0;//Compteur du nombre de visite du medecin specialiste
    	int prixVisiteGen=0;//prix de la prestation de visite du medecin generaliste
    	int prixVisiteSpec=0;//prix de la prestation de visite du medecin specialiste
    	String dateEntre;//Date d'entrée en chaine de caractère
    	String dateSortieH;//Date de sortie en chaine de caractère
    	Date dateHosp;
    	Date dateSortie;
    	int prix;
    	String reqVisiteGen="SELECT COUNT(visite) AS nbreVisiteGen" +
							" FROM fichehosp WHERE visite = '11' AND idFiche ="+idF+"";
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqVisiteGen);
		
		try {
			if(res.next()){
				countVisiteGen=res.getInt("nbreVisiteGen");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(countVisiteGen>0){
			String reqPrixVisite=" SELECT * FROM prestation p JOIN prix pr ON p.idPrix = pr.idPrix" +
			   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
			   " WHERE p.idPrestation =  '11'";
					ResultSet resPrix1=c.selectbd(reqPrixVisite);
					try {
						if(resPrix1.next()){
							prixVisiteGen=resPrix1.getInt("prix");
						}
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					sommeVisiteGen=countVisiteGen*prixVisiteGen;	
		}
		
		String reqVisiteSpec="SELECT COUNT(visite) AS visiteMedSpec" +
		  					 " FROM fichehosp WHERE visite= '12' AND idFiche ="+idF+"";
				ResultSet res1=c.selectbd(reqVisiteSpec);
				try {
					if(res1.next()){
					countVisiteSpec=res1.getInt("visiteMedSpec");
					}
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
				if(countVisiteSpec!=0){
					String reqPrixVisiteSpec="SELECT * FROM prestation p JOIN prix pr ON p.idPrix = pr.idPrix" +
										   " JOIN categoriepresta cp ON cp.idCatPresta = p.idCatPresta" +
										   " WHERE p.idPrestation =  '12'";
					ResultSet resPrix2=c.selectbd(reqPrixVisiteSpec);
					
						try {
							if(resPrix2.next())
								prixVisiteSpec=resPrix2.getInt("prix");
								sommeVisiteSpec=countVisiteSpec*prixVisiteSpec;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		  String getChambre="SELECT * FROM fichehosp fh, chambrePrix cp, chambre c, prix p" +
							" WHERE c.idChambre = cp.idChambre AND p.idPrix = cp.idPrix AND cp.idPrix" +
							" IN (SELECT max( idPrix ) AS prixID " +
							" FROM chambrePrix WHERE fh.idFiche ="+idF+" GROUP BY idChambre ) ORDER BY c.codeChambre AND fh.idHosp";
		  ResultSet r=c.selectbd(getChambre);
		 	try {
				if(r.next()){
					prix=r.getInt("prix");
					dateHosp=r.getDate("dateArrive");
					dateSortie=r.getDate("dateSortie");
					
					int nbjourHosp=0;
					 int montantChambre=0;
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date date=null, dateSort=null;
					try
					{
					date= df.parse(""+dateHosp);
						if(dateSortie!=null)
					dateSort=df.parse(""+dateSortie);
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
					
					dateEntre=dateEntree;
					System.out.println(dateEntre);
					if(jourSortie<10){
						jSortie="0"+jourSortie;
					}else{
						jSortie=""+jourSortie;
					}
					int moisSortie=dateSort.getMonth()+1;
					int anneeSortie=dateSort.getYear()+1900;
					String dateS=""+jSortie+"/"+moisSortie+"/"+anneeSortie;	
					dateSortieH=dateS;
				Calendar c1 = new GregorianCalendar();
			    Calendar c2 = new GregorianCalendar();
			    c1.set(anneeEntree, moisEntree, Integer.parseInt(j), 0, 0, 0);
			    c2.set(anneeSortie, moisSortie, Integer.parseInt(jSortie), 0, 0, 0);
			 
			    System.out.println(differenceDate(c1.getTime(), c2.getTime())+" jour(s) Entre les deux Date");
			    //nbjourHosp=(int) differenceDate(c1.getTime(), c2.getTime())+1;
			    nbjourHosp=(int) differenceDate(c1.getTime(), c2.getTime())+1;
			    montantChambre=prix*nbjourHosp;
			    
			    /*nbjourHosp=nbjourHosp;
			    montantChambre=montantChambre;*/
			    System.out.println("Nbre Jour hosp:"+nbjourHosp+" Prix:"+montantChambre);
			    
			    sommeTotale=montantChambre+sommeVisiteSpec+sommeVisiteGen;
			    System.out.println("Somme totale à payer:"+sommeTotale);
				} catch (ParseException e){
				e.printStackTrace();
				} 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return sommeTotale;
    	
    }
     public float factTotal(int idFic){
    	 
     float sommeVisiteChambre=this.factHosp(idFic); //Variable qui recupere le montant total à payer pour un chambre et des visites médicales
    	 float sommeFactTotal=0;
    	 mysql c=new mysql();
    	 String req="SELECT * FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
					" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+idFic+" GROUP BY p.idPrestation ";
    	 ResultSet res2=c.selectbd(req);
			int nbPresta=0;
			int prix=0;
			int sommePaye=0;
			int sommePrest=0;
			
			try {
				while(res2.next()){
					prix=res2.getInt("prix");
					String req1="SELECT COUNT(nomPresta) AS nbrePresta FROM fichehosp fh JOIN prestation p ON p.idPrestation=fh.idPrestation" +
								" JOIN prix pr ON pr.idPrix=p.idPrix WHERE idFiche ="+idFic+" AND fh.idPrestation='"+res2.getInt("idPrestation")+"'";
					// System.out.println("Req2:"+req1);
								ResultSet res3=c.selectbd(req1);
								if(res3.next()){
									nbPresta=res3.getInt("nbrePresta");
									sommePrest=prix*nbPresta;
									//System.out.println(" Somme Prest:"+sommePrest);
								}
								sommePaye+=sommePrest;		
				}
				sommeFactTotal=sommePaye+sommeVisiteChambre;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return sommeFactTotal;
    	 
     }
	/*Le constructeur de la classe*/
	  public verification(){
		  
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
	  
//	  public int compteurHosp=this.getListHospiCompteur().size();
//	  public int compteurSortie=this.getListHospiRentreCompteur().size();
//	  
//	  public int getCompteurHosp() {
//		return compteurHosp;
//	}
//	public void setCompteurHosp(int compteurHosp) {
//		this.compteurHosp = compteurHosp;
//	}
//	public int getCompteurSortie() {
//		return compteurSortie;
//	}
//	public void setCompteurSortie(int compteurSortie) {
//		this.compteurSortie = compteurSortie;
//	}
	public static void main(String []args){
		  verification v=new verification();
		  System.out.println(v.factTotal(9));
	  }

  }
