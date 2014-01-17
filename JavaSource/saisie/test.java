package saisie;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class test {

	private static int DECIMALS = 1;
	private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	private List <test> allCars = null;
	private List<test>listPatientDecisionSortie;
	String make;
	String model;
	String stock;
	String vin;
	String price;
	BigDecimal mileage;
	BigDecimal mileageMarket;
	
	/**/
	
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
	  
	  private String searchValue;
	  private String traitement;
	  private String nomPresta;
	  private boolean fait;
	  private String faitValue;
	  private String etat;
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
	/**/
	  
	  /**/
	public String getPrice() {
		return price;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
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
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	public boolean isViewbool() {
		return viewbool;
	}
	public void setViewbool(boolean viewbool) {
		this.viewbool = viewbool;
	}
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	public List<verification> getListPatient() {
		return listPatient;
	}
	public void setListPatient(List<verification> listPatient) {
		this.listPatient = listPatient;
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
	public verification getSelected() {
		return selected;
	}
	public void setSelected(verification selected) {
		this.selected = selected;
	}
	public List<verification> getListSuiviPatient() {
		return listSuiviPatient;
	}
	public void setListSuiviPatient(List<verification> listSuiviPatient) {
		this.listSuiviPatient = listSuiviPatient;
	}
	public List<verification> getListDetailsPatient() {
		return listDetailsPatient;
	}
	public void setListDetailsPatient(List<verification> listDetailsPatient) {
		this.listDetailsPatient = listDetailsPatient;
	}
	public List<verification> getListDetailsRendez() {
		return listDetailsRendez;
	}
	public void setListDetailsRendez(List<verification> listDetailsRendez) {
		this.listDetailsRendez = listDetailsRendez;
	}
	public List<verification> getListPatientResultat() {
		return listPatientResultat;
	}
	public void setListPatientResultat(List<verification> listPatientResultat) {
		this.listPatientResultat = listPatientResultat;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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
	public String getFaitValue() {
		return faitValue;
	}
	public void setFaitValue(String faitValue) {
		this.faitValue = faitValue;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
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
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
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
	public String getRechercheValue() {
		return rechercheValue;
	}
	public void setRechercheValue(String rechercheValue) {
		this.rechercheValue = rechercheValue;
	}
	public int getIdHosp() {
		return idHosp;
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
	public void setPrice(String price) {
		this.price = price;
	}
	public static int getDECIMALS() {
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
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public BigDecimal getMileage() {
		return mileage;
	}
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}
	public BigDecimal getMileageMarket() {
		return mileageMarket;
	}
	public void setMileageMarket(BigDecimal mileageMarket) {
		this.mileageMarket = mileageMarket;
	}
	public void setAllCars(List<test> allCars) {
		this.allCars = allCars;
	}
	public List <test> getAllCars() {
		synchronized (this) {
		if (allCars == null) {
		allCars = new ArrayList<test>();
		allCars.addAll(createCar("Chevrolet","Corvette", 5));
		allCars.addAll(createCar("Chevrolet","Malibu", 8));
		allCars.addAll(createCar("Chevrolet","S-10", 10));
		allCars.addAll(createCar("Chevrolet","Tahoe", 6));
		allCars.addAll(createCar("Ford","Taurus", 12));
		allCars.addAll(createCar("Ford","Explorer", 11));
		allCars.addAll(createCar("Nissan","Maxima", 9));
		allCars.addAll(createCar("Toyota","4-Runner", 7));
		allCars.addAll(createCar("Toyota","Camry", 15));
		allCars.addAll(createCar("Toyota","Avalon", 13));
		allCars.addAll(createCar("GMC","Sierra", 8));
		allCars.addAll(createCar("GMC","Yukon", 10));
		allCars.addAll(createCar("Infiniti","G35", 6));
		}
		}
		return allCars;
		}
		public int genRand() {
		return rand(1,10000);}
		public List <test> createCar(String make, String model, int count){
			ArrayList <test> iiList = null;
			try{
			int arrayCount = count;
			test[] demoInventoryItemArrays =
			new test[arrayCount];
			for (int j = 0; j < demoInventoryItemArrays.length; j++){
			test ii = new test();
			ii.setMake(make);
			ii.setModel(model);
			//setters for other properties
			demoInventoryItemArrays[j] = ii;
			}
			iiList =
			new ArrayList<test>(Arrays.asList(demoInventoryItemArrays));
			}catch(Exception e){
			e.printStackTrace();
			}
			return iiList;
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
			public List<test> getListPatientDecisionSortie() {
				
				this.listPatientDecisionSortie=new ArrayList<test>();
				
				String requeteDecision="select pe.nom,pe.prenom,pa.codePatient,re.dateRendezVous,se.nomService,re.idRendezVous,fi.dateConsultation," +
								        "fh.motif,fi.etat,fi.idFiche,fh.idHosp,fh.dateArrive,fh.traitement,fh.observation,fh.temperature,fh.TA,fh.FC,fh.FR from fichehosp fh" +
								        " join fichemed fi on fi.idFiche=fh.idFiche" +
								        " join rendezvous re on re.idRendezVous=fi.idRendezVous" +
								        " join patient pa on pa.idPatient=re.idPatient" +
								        " join personne pe on pe.idPersonne=pa.idPersonne" +
								        " join service se on se.idService=re.idService" +
								        " where pa.codePatient like '"+this.rechercheValue+"%'" +
				 			            " or pe.nom like '"+this.rechercheValue+"%'" +
				 			            " or pe.prenom like '"+this.rechercheValue+"%'" +
				 			            " and fi.status=1" +
				 			            " group by pa.idPatient" +
				 						" order by pa.idPatient desc";

								mysql sql=new mysql();
								
								ResultSet res=sql.selectbd(requeteDecision);
								
								try {
								while(res.next()){
								
								test pa=new test();
								
								pa.idFiche=res.getInt("idFiche");
								
								pa.codePerso=res.getString("codePatient");
								pa.nom=res.getString("nom");
								pa.prenom=res.getString("prenom");
								pa.dateRendezVous=res.getDate("dateRendezVous");
								pa.dateConsultation=res.getDate("dateConsultation");
								pa.nomService=res.getString("nomService");
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
								}
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
				return listPatientDecisionSortie;
			}
			public void setListPatientDecisionSortie(List<test> listPatientDecisionSortie) {
				this.listPatientDecisionSortie = listPatientDecisionSortie;
			}
			
			
			/*La methode qui effectue la recherche des patients a sortir*/
			
			public void backPatientSortie(){
				
				this.getListPatientDecisionSortie();
			}
}
