package saisie;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/*import com.itextpdf.*;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;*/

public class administrateur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean user=true;
	private boolean prestation=false;
	private boolean recherche=false;
	private boolean patient=false;
	private boolean facture=false;
	private boolean service=false;
	private boolean medecin=true;
	private boolean infirmier=false;
	private boolean receptionnniste=false;
	private boolean laborantin=false;
	private List<administrateur> listAllService;
	private List<administrateur> listMedecin;
	private List<administrateur> listInfirmier;
	private List<administrateur> listRecept;
	private List<administrateur> listLab;
	private List<administrateur> listDesService;
	private List<SelectItem> listService;
	private administrateur selected;
	private boolean error=false;
	private List<administrateur>listChambreSansPrix;
	private String chambreStatus;
	private int idPrixChambre;
    
	
	
	public int getIdPrixChambre() {
		return idPrixChambre;
	}

	public void setIdPrixChambre(int idPrixChambre) {
		this.idPrixChambre = idPrixChambre;
	}

	public String getChambreStatus() {
		return chambreStatus;
	}

	public void setChambreStatus(String chambreStatus) {
		this.chambreStatus = chambreStatus;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isService() {
		return service;
	}

	public void setService(boolean service) {
		this.service = service;
	}

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public boolean isPrestation() {
		return prestation;
	}


	public void setPrestation(boolean prestation) {
		this.prestation = prestation;
	}


	public boolean isRecherche() {
		return recherche;
	}


	public void setRecherche(boolean recherche) {
		this.recherche = recherche;
	}

	

	public boolean isPatient() {
		return patient;
	}


	public void setPatient(boolean patient) {
		this.patient = patient;
	}

	
	public boolean isFacture() {
		return facture;
	}

	public void setFacture(boolean facture) {
		this.facture = facture;
	}

	public void userClicked(){
		this.user=true;
		this.patient=false;
		this.prestation=false;
		this.recherche=false;
		this.facture=false;
		this.service=false;
		System.out.println("User clicked:"+this.user);
	}

	public void prestationClicked(){
		this.prestation=true;
		this.user=false;
		this.patient=false;
		this.recherche=false;
		this.facture=false;
		this.service=false;
		System.out.println("Prestation clicked:"+this.prestation);
	}
	
	public void patientClicked(){
		this.patient=true;
		this.user=false;
		this.prestation=false;
		this.recherche=false;
		this.facture=false;
		this.service=false;
		System.out.println("Patient clicked:"+this.patient);
	}
	
	public void rechercheClicked(){
		this.recherche=true;
		this.user=false;
		this.prestation=false;
		this.patient=false;
		this.facture=false;
		this.service=false;
		System.out.println("Recherche clicked:"+this.recherche);
	}
	
	public void factureClicked(){
		this.facture=true;
		this.recherche=false;
		this.user=false;
		this.prestation=false;
		this.patient=false;
		this.service=false;
	}
	
	public void serviceClicked(){
		
		this.service=true;
		this.facture=false;
		this.recherche=false;
		this.user=false;
		this.prestation=false;
		this.patient=false;
	}
	
	
	
	public List<administrateur> getListAllService() {
		this.listAllService=new ArrayList<administrateur>();
		String req="SELECT * FROM service";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				administrateur a=new administrateur();
				a.idService=res.getInt("idService");
				a.nomService=res.getString("nomService");
				
				this.listAllService.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closebd();
		return listAllService;
	}

	public void setListAllService(List<administrateur> listAllService) {
		this.listAllService = listAllService;
	}

	private int categorie;
	
	public int getCategorie() {
		return categorie;
	}


	public void setCategorie(int categorie) {
		this.categorie = categorie;
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

	public void categorieChanged(ValueChangeEvent evnt){
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
	
	private int idPersonne;
	private int id;
	private int idServiceMed;//idServiceMed:Medecin et son service
	private int idServiceInf;//idServiceInf:Infirmier et son service
	private String nom;
	private String prenom;
	private String code;
	private String categ;
	private Date dateNaissance;
	private String email;
	private String userName;
	private String passWord;//Mot de passe de l'utilisateur
	private String confPassWord;//Confirmation du mot de passe de l'utilisateur
	private String genre;
	private int idService;//id du service du medecin;
	private String nomService="";
	private String telFixe;
	private String telMob;
	private String adresse;
	private boolean status;
	private int idCat;
	
	
	public int getIdPersonne() {
		return idPersonne;
	}


	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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


	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
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

	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public int getIdServiceMed() {
		return idServiceMed;
	}
	public void setIdServiceMed(int idServiceMed) {
		this.idServiceMed = idServiceMed;
	}

	public int getIdServiceInf() {
		return idServiceInf;
	}
	public void setIdServiceInf(int idServiceInf) {
		this.idServiceInf = idServiceInf;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	private String stat;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}

	public List<administrateur> getListMedecin() {
		this.listMedecin=new ArrayList<administrateur>();
		
		String req="SELECT * FROM medecin m JOIN personne p ON p.idPersonne=m.idPersonne " +
				   " JOIN servicemed sm ON sm.idMedecin=m.idMedecin " +
				   " JOIN service s ON s.idService=sm.idService";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		try {
			while(res.next()){
				administrateur a=new administrateur();
				
				a.idPersonne=res.getInt("idPersonne");
				a.id=res.getInt("idMedecin");
				a.idServiceMed=res.getInt("idServiceMed");
				a.code=res.getString("codeMedecin");
				a.nom=res.getString("nom");
				a.prenom=res.getString("prenom");
				a.dateNaissance=res.getDate("date_naissance");
				a.categ=res.getString("categorie");
				a.genre=res.getString("genre");
				a.idService=res.getInt("idService");
				a.nomService=res.getString("nomService");
				a.niveau=res.getString("categorie");
				a.userName=res.getString("userName");
				a.passWord=res.getString("passWord");
				a.telFixe=res.getString("tel_fixe");
				a.telMob=res.getString("tel_mob");
				a.email=res.getString("email");
				a.adresse=res.getString("adresse");
				a.status=res.getBoolean("status");
				if(res.getBoolean("status")){
					a.stat="Désactiver";
				}else{
					a.stat="Activer";
				}
			//System.out.println(a.idPersonne+" "+a.id+" "+a.idServiceMed+" "+a.code+" "+a.nom+" "+a.prenom+" "+a.dateNaissance+" "+a.categ+" "+a.genre+" "+a.nomService+" "+a.passWord+" "+a.status);
				this.listMedecin.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closebd();
		return listMedecin;
	}


	public void setListMedecin(List<administrateur> listMedecin) {
		this.listMedecin = listMedecin;
	}


	public List<administrateur> getListInfirmier() {
		this.listInfirmier=new ArrayList<administrateur>();
		String req="SELECT * FROM infirmier i JOIN personne p ON p.idPersonne=i.idPersonne" +
				   " JOIN serviceinf si ON si.idInf=i.idInf" +
				   " JOIN service s ON s.idService=si.idService";
		mysql m=new mysql(); 
		ResultSet res=m.selectbd(req);
		
		try {
			while(res.next()){
				administrateur a=new administrateur();
				a.id=res.getInt("idInf");
				a.idPersonne=res.getInt("idPersonne");
				a.idServiceInf=res.getInt("idServiceInf");
				a.code=res.getString("codeInfirmier");
				a.nom=res.getString("nom");
				a.prenom=res.getString("prenom");
				a.dateNaissance=res.getDate("date_naissance");
				a.genre=res.getString("genre");
				a.nomService=res.getString("nomService");
				a.userName=res.getString("userName");
				a.telFixe=res.getString("tel_fixe");
				a.telMob=res.getString("tel_mob");
				a.adresse=res.getString("adresse");
				a.email=res.getString("email");
				a.status=res.getBoolean("status");
				
				if(a.status){
					a.stat="Désactiver";
				}else{
					a.stat="Activer";
				}
	//System.out.println(a.id+" "+a.code+" "+a.nom+" "+a.prenom+" "+a.dateNaissance+"  "+a.genre+" "+a.nomService+" "+a.userName);
				this.listInfirmier.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.closebd();
		return listInfirmier;
	}


	public void setListInfirmier(List<administrateur> listInfirmier) {
		this.listInfirmier = listInfirmier;
	}


	public List<administrateur> getListRecept() {
		this.listRecept=new ArrayList<administrateur>();
		String req="SELECT * FROM receptionniste r JOIN personne p ON p.idPersonne=r.idPersonne";
		
		mysql m=new mysql();
		ResultSet res=m.selectbd(req);
		try {
			while(res.next()){
				administrateur a=new administrateur();
				a.idPersonne=res.getInt("idPersonne");
				a.id=res.getInt("idRec");
				a.code=res.getString("codeRec");
				a.nom=res.getString("nom");
				a.prenom=res.getString("prenom");
				a.dateNaissance=res.getDate("date_naissance");
				a.genre=res.getString("genre");
				a.telFixe=res.getString("tel_fixe");
				a.telMob=res.getString("tel_mob");
				a.adresse=res.getString("adresse");
				a.email=res.getString("email");
				a.userName=res.getString("userName");
				a.status=res.getBoolean("status");
				
				if(a.status){
					a.stat="Désactiver";
				}else{
					a.stat="Activer";
				}
				//System.out.println(a.id+" "+a.code+" "+a.nom+" "+a.prenom+" "+a.dateNaissance+"  "+a.genre+"  "+a.userName);
				this.listRecept.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.closebd();
		return listRecept;
	}


	public void setListRecept(List<administrateur> listRecept) {
		this.listRecept = listRecept;
	}


	public List<administrateur> getListLab() {
		this.listLab=new ArrayList<administrateur>();
		String req="SELECT * FROM laborantin l JOIN personne p ON p.idPersonne=l.idPersonne";
		
		mysql m=new mysql();
		ResultSet res=m.selectbd(req);
		try {
			while(res.next()){
				administrateur a=new administrateur();
				a.idPersonne=res.getInt("idPersonne");
				a.id=res.getInt("idLaborantin");
				a.code=res.getString("codeLabo");
				a.nom=res.getString("nom");
				a.prenom=res.getString("prenom");
				a.dateNaissance=res.getDate("date_naissance");
				a.genre=res.getString("genre");
				a.telFixe=res.getString("tel_fixe");
				a.telMob=res.getString("tel_mob");
				a.adresse=res.getString("adresse");
				a.email=res.getString("email");
				a.userName=res.getString("userName");
				a.status=res.getBoolean("status");
				
				if(a.status){
					a.stat="Désactiver";
				}else{
					a.stat="Activer";
				}
				//System.out.println(a.id+" "+a.code+" "+a.nom+" "+a.prenom+" "+a.dateNaissance+"  "+a.genre+"  "+a.userName);
				this.listLab.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.closebd();
		return listLab;
	}


	public void setListLab(List<administrateur> listLab) {
		this.listLab = listLab;
	}
	public String traitementDate(Date data){
			
			if(data==null)
			  return "";
			java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");
			
			return form.format(data);	
		}
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	private String niveau;//Niveau du medecin:Generaliste ou Specialiste
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public void ajoutMed(){
			this.idCat=2;
			int i=-1, u=-1, h=-1;
			int idPersonne=0;
		String req="INSERT INTO personne(nom, prenom, date_naissance,genre, tel_fixe, tel_mob, adresse, email, userName, passWord, idCat)" +
				   " VALUES('"+this.nom+"', '"+this.prenom+"', '"+this.traitementDate(dateNaissance)+"', " +
				   " '"+this.genre+"', '"+this.telFixe+"', '"+this.telMob+"', '"+this.adresse+"', '"+this.email+"', '"+this.userName+"', '"+this.passWord+"', '"+this.idCat+"')";
		mysql c=new mysql();
		System.out.println(req);
		System.out.println(this.passWord);
		System.out.println(this.confPassWord);
		if(!(this.passWord.equals(this.confPassWord))){
			this.message="Les deux mots de passe ne sont pas identiques";
		}else{
		i=c.updatebd(req);
		System.out.println(req);
		if(i!=-1){
			this.message="Enregistrement d'une personne du nom de "+this.nom+" "+this.prenom;
		System.out.println(this.message);
		
		String getIdPersonne="select * from personne order by idPersonne desc limit 1 ";
		ResultSet resPersonne=c.selectbd(getIdPersonne);
		
		try {
			if(resPersonne.next()){
				
				idPersonne=resPersonne.getInt("idPersonne");
				
			}
			System.out.println("Dernier idPersonne:"+idPersonne);
			int status=1;
			this.code=this.genererCode();
			String reqInsertMed="INSERT INTO medecin(codeMedecin, categorie, status, idPersonne) " +
								" VALUES('"+this.code+"', '"+this.niveau+"', '"+status+"', '"+idPersonne+"') ";
			u=c.updatebd(reqInsertMed);
			
			if(u!=-1){
				ResultSet res=c.selectbd("SELECT * FROM service WHERE idService='"+this.idService+"'");
				if(res.next()){
					this.nomService=res.getString("nomService");
				System.out.println("Nom du service selectionnée:"+this.nomService);
				//this.message="Enregistrement d'un medecin du nom de "+this.nom+" "+this.prenom+" dans le service de "+this.nomService;
				
				ResultSet res1=c.selectbd("SELECT * FROM medecin ORDER BY idMedecin DESC LIMIT 1");
					int lastIdMedecin=0;
					if(res1.next()){
						lastIdMedecin=res1.getInt("idMedecin");
					String reqMedecin="INSERT INTO servicemed(idService, idMedecin, dateAffectMed) " +
				     " VALUES('"+this.idService+"', '"+lastIdMedecin+"', '"+this.traitementDateTime(new Date())+"')";
						System.out.println(reqMedecin);
					h=c.updatebd(reqMedecin);
					if(h!=-1){
						this.message="Enregistrement d'un medecin du nom de "+this.nom+" "+this.prenom+" \n dans le service de "+this.nomService;
						}
					this.nomService="";
					}
				}
				System.out.println(this.message);
				this.initialise();
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
			}
		c.closebd();
	}
	
	public void initialise(){
		this.nom="";    					this.adresse="";
		this.prenom="";						this.email="";
		this.dateNaissance=null;			this.userName="";
		this.genre="";						this.passWord="";
		this.niveau="";						this.code="";
		this.telFixe="";					
		this.telMob="";									
	} 
	
	
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	
	public administrateur getSelected() {
		return selected;
	}
	public void setSelected(administrateur selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListService() {
		
		mysql m=new mysql();
		String req="SELECT * FROM service";
		ResultSet res=m.selectbd(req);
		
		if(this.listService==null){
			this.listService=new ArrayList<SelectItem>();
		}else{
			this.listService.clear();
		}
		try {
			while(res.next()){
				
				this.idService=res.getInt("idService");
				this.nomService=res.getString("nomService");
				//System.out.println(this.idService+" "+this.nomService);
				this.listService.add(new SelectItem(this.idService, this.nomService));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.closebd();
		return listService;
	}


	public void setListService(List<SelectItem> listService) {
		this.listService = listService;
	}

	public String traitementDateTime(Date data){
			
			if(data==null)
			  return "";
			java.text.SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return form.format(data);
					
		}
	public void modifMed(){
		this.idPersonne=this.selected.idPersonne;
		this.nom=this.selected.nom;								this.adresse=this.selected.adresse;
		this.prenom=this.selected.prenom;						this.email=this.selected.email;
		this.dateNaissance=this.selected.dateNaissance;			this.userName=this.selected.userName;
		this.genre=this.selected.genre;							this.passWord=this.selected.passWord;
		this.niveau=this.selected.niveau;						this.confPassWord=this.selected.confPassWord;
		this.idService=this.selected.idService;					this.idServiceMed=this.selected.idServiceMed;
		this.telFixe=this.selected.telFixe;						this.id=this.selected.id;
		this.telMob=this.selected.telMob;
		
		int i=-1, j=-1, k=-1;
		String req1="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"', date_naissance='"+this.traitementDate(this.dateNaissance)+"'," +
				   " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'" +
				   " WHERE idPersonne='"+this.idPersonne+"'";
		
		String req2="UPDATE medecin SET categorie='"+this.niveau+"' WHERE idMedecin='"+this.id+"'";
		String req3="UPDATE servicemed SET idService='"+this.idService+"', idMedecin='"+this.id+"'" +
				    " WHERE idServiceMed='"+this.idServiceMed+"'";
		
		String req4="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"', date_naissance='"+this.traitementDate(this.dateNaissance)+"'," +
				    " tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"', adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"'," +
				    " passWord='"+this.passWord+"' WHERE idPersonne='"+this.idPersonne+"'";
		
		//String req5="SELECT COUNT(*) FROM personne WHERE userName='"+this.userName+"'";
		/*Requette qui compte le nombre de fois le userName saisie apparait dans la base de données */
		
		mysql c=new mysql();
		
		if(this.passWord.equals("")){
				if(this.passWord.equals(this.confPassWord))
			i=c.updatebd(req1);
				else this.message="Veuillez saisir le même mot de passe.";
			System.out.println(req1);
			if(i!=-1){
					if(this.niveau!=""){
						j=c.updatebd(req2);
						
						if(j!=-1){
							this.message="Modification effectuée";
							System.out.println("Ligne 742:"+this.message);
						}
					}
					if(this.idService!=0){
						k=c.updatebd(req3);
						
						if(k!=-1){
							this.message="Modification effectuée";
							System.out.println("Ligne 742:"+this.message);
						}
					}
							}else{
				this.message="Echec de modification";
				System.out.println("Ligne 745:"+this.message);
			}
		}else{
			if(!(this.passWord.equals(this.confPassWord))){
				this.message="Veuillez saisir le même mot de passe.";
				System.out.println("Ligne 750:"+this.message);
			}else{
				i=c.updatebd(req4);
				
				if(i!=-1){
					this.message="Modification effectuée";
					System.out.println("Ligne 756:"+this.message);
					
					if(this.niveau!=""){
						j=c.updatebd(req2);
						
						if(j!=-1){
							this.message="Modification effectuée";
							System.out.println("Ligne 742:"+this.message);
						}
					}
					if(this.idService!=0){
						k=c.updatebd(req3);
						
						if(k!=-1){
							this.message="Modification effectuée";
							System.out.println("Ligne 742:"+this.message);
						}
					}
				}
			}
		}
		c.closebd();
		
	}
	//Fonction qui permet de désactiver ou d'activer le medecin.
	public void changeStatusMed(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE medecin SET status='"+option+"' WHERE idMedecin="+this.selected.id+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.message="Désactivation effectuée";
				else 
					this.message="Activation effectuée";
		}else{
			this.message="Operation échouée";
		}
			c.closebd();
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.stat);
	}
	
	//Fonction qui permet de désactiver ou d'activer l'infirmier.
	public void changeStatusInf(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE infirmier SET status='"+option+"' WHERE idInf="+this.selected.id+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.message="Désactivation effectuée";
				else 
					this.message="Activation effectuée";
		}else{
			this.message="Operation échouée";
		}
		c.closebd();
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.stat);
	}
	
	//Fonction qui permet de désactiver ou d'activer le receptionniste.
	public void changeStatusRecept(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE receptionniste SET status='"+option+"' WHERE idRec="+this.selected.id+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.message="Désactivation effectuée";
				else 
					this.message="Activation effectuée";
		}else{
			this.message="Operation échouée";
		}
		
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.stat);
	}
	
	//Fonction qui permet de désactiver ou d'activer le receptionniste.
	public void changeStatusLab(){
		int option;
		if(this.selected.status==true){
			option=0;
		}else{
			option=1;
		}
		String req="UPDATE laborantin SET status='"+option+"' WHERE idLaborantin="+this.selected.id+"";
		mysql c=new mysql();
		int i=-1;
		
		i=c.updatebd(req);
		
		if(i!=-1){
				if(option==0)
					this.message="Désactivation effectuée";
				else 
					this.message="Activation effectuée";
		}else{
			this.message="Operation échouée";
		}
			c.closebd();
		System.out.println(req);
		System.out.println(this.selected.status+" "+this.selected.stat);
	}
	
	public void ajoutInfirmier(){
		this.idCat=3;
		int i=-1, j=-1, k=-1;
		String insertInf="INSERT INTO personne(nom, prenom, date_naissance,genre, tel_fixe, tel_mob, adresse, email, userName, passWord, idCat) " +
				         " VALUES('"+this.nom+"', '"+this.prenom+"', '"+this.traitementDate(this.dateNaissance)+"', '"+this.genre+"', '"+this.telFixe+"'," +
				         		" '"+this.telMob+"', '"+this.adresse+"', '"+this.email+"', '"+this.userName.toLowerCase()+"', '"+this.passWord+"', '"+this.idCat+"')";
		String getidPersonne="SELECT * FROM personne ORDER BY idPersonne DESC LIMIT 1";
		String getUserName="SELECT count(userName) as nombre FROM personne WHERE userName='"+this.userName.toLowerCase()+"'";
		mysql c=new mysql();
		//int idPersonne=0;
		
		if(this.passWord!="" && this.confPassWord!=""){
			if(this.passWord.equals(this.confPassWord)){
				ResultSet res=c.selectbd(getUserName);
					try {
						if(res.next()){
						System.out.println("Nombre de fois:"+res.getInt("nombre"));
							if(res.getInt("nombre")>0){
								this.message="Ce nom d'utilisateur est déjà utilisé!\n Veuillez choisir un autre.";
							}else{
								i=c.updatebd(insertInf);
								
								if(i!=-1){
					ResultSet res1=c.selectbd(getidPersonne);
				if(res1.next()){
					this.idPersonne=res1.getInt("idPersonne");
				}
				int status=1;
			this.code=this.genererCode();
			String insertPersoInf="INSERT INTO infirmier(codeInfirmier, idPersonne, status) " +
								  " VALUES('"+this.code+"', '"+this.idPersonne+"', '"+status+"') ";
			j=c.updatebd(insertPersoInf);
				if(j!=-1){
			
			String getLastInf="SELECT * FROM infirmier ORDER BY idInf DESC LIMIT 1";
			ResultSet res2=c.selectbd(getLastInf);
			int idInf=0;
					if(res2.next()){
						idInf=res2.getInt("idInf");
					}
			String insertServInf="INSERT INTO serviceInf(idService, idInf, dateAffectInf) " +
								 " VALUES('"+this.idService+"', '"+idInf+"', '"+this.traitementDate(new Date())+"')";
			k=c.updatebd(insertServInf);
				if(k!=-1){
				String getNomServ="SELECT * FROM service WHERE idService='"+this.idService+"'";
				ResultSet res3=c.selectbd(getNomServ);
					if(res3.next()){
						this.message="Enregistrement de l' infirmier "+this.nom+" "+this.prenom+"\n dans le service "+res3.getString("nomService");
						this.initialise();
					}
					
				}
					}	
								}
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}else{
				this.message="Veuillez saisir le même mot de passe.";
			}
		}
		c.closebd();
	}
	
	public void modifierInfirmier(){
		this.idPersonne=this.selected.idPersonne;				this.adresse=this.selected.adresse;
		this.id=this.selected.id;								this.email=this.selected.email;
		this.idServiceInf=this.selected.idServiceInf;			this.userName=this.selected.userName;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateNaissance=this.selected.dateNaissance;
		this.genre=this.selected.genre;
		this.idService=this.selected.idService;
		this.telFixe=this.selected.telFixe;
		this.telMob=this.selected.telMob;
		
		int i=-1, j=-1;
System.out.println("IdPerso:"+this.idPersonne+" idInf:"+this.id+" idServiceInf:"+this.idServiceInf+" \n Nom:"+this.nom+" " +
		" Prénom:"+this.selected.prenom+" Date de naissance:"+this.traitementDate(this.dateNaissance)+" Sexe:"+this.genre+" IDService:"+this.idService+"\n" +
				" tel Fixe:"+this.telFixe+" Tel Mob:"+this.telMob+" adresse:"+this.adresse+" Email:"+this.email+" Identifiant:"+this.userName);
	
String modifPerso="";
	mysql c=new mysql();
	if(this.passWord!="" || this.confPassWord!=""){
		if(this.passWord.equals(this.confPassWord)){
modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
			  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
			  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"', passWord='"+this.passWord+"' " +
			  " WHERE idPersonne='"+this.idPersonne+"'";
	i=c.updatebd(modifPerso);
		if(i!=-1){
			System.out.println(modifPerso);
			this.message="Modification de l'infirmier avec  mot de passe";
			System.out.println(this.message);
			}
		}else{ 
			this.message="Veuillez saisir le même mot de passe";
		  }
	}else{
		modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
		  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
		  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"' WHERE idPersonne='"+this.idPersonne+"'";

	i=c.updatebd(modifPerso);
		if(i!=-1){
			System.out.println(modifPerso);
			this.message="Modification de l'infirmier sans mot de passe";
			System.out.println(this.message);
		}
			

	}
	
	if(this.idService!=0){
		String modifInf="UPDATE serviceinf SET idService='"+this.idService+"' " +
						" WHERE idServiceInf="+this.idServiceInf+"";
		System.out.println("Modification du service de l'infirmier:"+modifInf);
		j=c.updatebd(modifInf);
			if(j!=-1){
		this.message="Modification effectuée";
		System.out.println(this.message);
			}
				}
		c.closebd();
	}
	
	public void ajoutReceptionniste(){
		int i=-1, j=-1;
		this.idCat=4;
		String insertPerso="INSERT INTO personne(nom, prenom, date_naissance,genre, tel_fixe, tel_mob, adresse, email, userName, passWord, idCat) " +
        " VALUES('"+this.nom+"', '"+this.prenom+"', '"+this.traitementDate(this.dateNaissance)+"', '"+this.genre+"', '"+this.telFixe+"'," +
        		" '"+this.telMob+"', '"+this.adresse+"', '"+this.email+"', '"+this.userName.toLowerCase()+"', '"+this.passWord+"', '"+this.idCat+"')";
		
		String getIPersonne="SELECT * FROM personne ORDER BY idPersonne DESC LIMIT 1";
		String getUserName="SELECT count(userName) as nombre FROM personne WHERE userName='"+this.userName.toLowerCase()+"'";
		mysql c=new mysql();
		
//		if(this.passWord.equals(this.confPassWord)){
//			this.message="Les deux mots de passe ne sont pas identiques";
//		}else{
			ResultSet res1=c.selectbd(getUserName);
				try {
					if(res1.next()){	
					//this.message="Ce nom d'utilisateur est déjà utilisé!\n Veuillez saisir un autre.";
					if(res1.getInt("nombre")>0){
						this.message="Ce nom d'utilisateur est déjà utilisé!\n Veuillez choisir un autre.";
					}else{
						i=c.updatebd(insertPerso);
						}
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		System.out.println(insertPerso);
		if(i!=-1){
			//this.message="Enregistrement d'une personne du nom de "+this.nom+" "+this.prenom;
		//System.out.println(this.message);
		
		
		ResultSet resPersonne=c.selectbd(getIPersonne);
		
		try {
			if(resPersonne.next()){
				
				idPersonne=resPersonne.getInt("idPersonne");
				
			}
			System.out.println("Dernier idPersonne:"+idPersonne);
			int status=1;
			this.code=this.genererCode();
			String reqInsertMed="INSERT INTO receptionniste(codeRec, status, idPersonne) " +
								" VALUES('"+this.code+"', '"+status+"', '"+idPersonne+"') ";
			j=c.updatebd(reqInsertMed);
			
			if(j!=-1){
				this.message="Enregistrement d'un receptionniste du nom de "+this.nom+" "+this.prenom;
				System.out.println(this.message);
				this.confPassWord="";
				this.initialise();	
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
			c.closebd();
	}
	
	public void modifRecept(){
		this.idPersonne=this.selected.idPersonne;				this.adresse=this.selected.adresse;
		this.id=this.selected.id;								this.email=this.selected.email;
		this.idServiceInf=this.selected.idServiceInf;			this.userName=this.selected.userName;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateNaissance=this.selected.dateNaissance;
		this.genre=this.selected.genre;
		this.idService=this.selected.idService;
		this.telFixe=this.selected.telFixe;
		this.telMob=this.selected.telMob;
		
		int i=-1;
		String modifPerso="";
		mysql c=new mysql();
		if(this.passWord!="" || this.confPassWord!=""){
			if(this.passWord.equals(this.confPassWord)){
	modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
				  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
				  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"', passWord='"+this.passWord+"' " +
				  " WHERE idPersonne='"+this.idPersonne+"'";
		i=c.updatebd(modifPerso);
			if(i!=-1){
				System.out.println(modifPerso);
				this.message="Modification du rceptionniste avec  mot de passe";
				System.out.println(this.message);
				}
			}else{ 
				this.message="Veuillez saisir le même mot de passe";
			  }
		}else{
	modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
			  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
			  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"' WHERE idPersonne='"+this.idPersonne+"'";

		i=c.updatebd(modifPerso);
			if(i!=-1){
				System.out.println(modifPerso);
				this.message="Modification du rceptionniste sans mot de passe";
				System.out.println(this.message);
			}
				

		}
		c.closebd();
	}
	
	public void ajoutLab(){
		int i=-1, j=-1;
		this.idCat=5;
		String insertPerso="INSERT INTO personne(nom, prenom, date_naissance,genre, tel_fixe, tel_mob, adresse, email, userName, passWord, idCat) " +
        " VALUES('"+this.nom+"', '"+this.prenom+"', '"+this.traitementDate(this.dateNaissance)+"', '"+this.genre+"', '"+this.telFixe+"'," +
        		" '"+this.telMob+"', '"+this.adresse+"', '"+this.email+"', '"+this.userName.toLowerCase()+"', '"+this.passWord+"', '"+this.idCat+"')";
		
		String getIPersonne="SELECT * FROM personne ORDER BY idPersonne DESC LIMIT 1";
		String getUserName="SELECT count(userName) as nombre FROM personne WHERE userName='"+this.userName.toLowerCase()+"'";
		mysql c=new mysql();
		
//		if(this.passWord.equals(this.confPassWord)){
//			this.message="Les deux mots de passe ne sont pas identiques";
//		}else{
			ResultSet res1=c.selectbd(getUserName);
				try {
					if(res1.next()){	
					//this.message="Ce nom d'utilisateur est déjà utilisé!\n Veuillez saisir un autre.";
					if(res1.getInt("nombre")>0){
						this.message="Ce nom d'utilisateur est déjà utilisé!\n Veuillez choisir un autre.";
					}else{
						i=c.updatebd(insertPerso);
						}
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		System.out.println(insertPerso);
		if(i!=-1){
			//this.message="Enregistrement d'une personne du nom de "+this.nom+" "+this.prenom;
		//System.out.println(this.message);
		
		
		ResultSet resPersonne=c.selectbd(getIPersonne);
		
		try {
			if(resPersonne.next()){
				
				idPersonne=resPersonne.getInt("idPersonne");
				
			}
			System.out.println("Dernier idPersonne:"+idPersonne);
			int status=1;
			this.code=this.genererCode();
			String reqInsertMed="INSERT INTO laborantin(codeLabo, status, idPersonne) " +
								" VALUES('"+this.code+"', '"+status+"', '"+idPersonne+"') ";
			j=c.updatebd(reqInsertMed);
			
			if(j!=-1){
				this.message="Enregistrement d'un laborantin du nom de "+this.nom+" "+this.prenom;
				System.out.println(this.message);
				this.confPassWord="";
				this.initialise();	
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		c.closebd();
	}
	
	public void modifLab(){
		this.idPersonne=this.selected.idPersonne;				this.adresse=this.selected.adresse;
		this.id=this.selected.id;								this.email=this.selected.email;
		this.idServiceInf=this.selected.idServiceInf;			this.userName=this.selected.userName;
		this.nom=this.selected.nom;
		this.prenom=this.selected.prenom;
		this.dateNaissance=this.selected.dateNaissance;
		this.genre=this.selected.genre;
		this.idService=this.selected.idService;
		this.telFixe=this.selected.telFixe;
		this.telMob=this.selected.telMob;
		
		int i=-1;
		String modifPerso="";
		mysql c=new mysql();
		if(this.passWord!="" || this.confPassWord!=""){
			if(this.passWord.equals(this.confPassWord)){
	modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
				  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
				  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"', passWord='"+this.passWord+"' " +
				  " WHERE idPersonne='"+this.idPersonne+"'";
		i=c.updatebd(modifPerso);
			if(i!=-1){
				System.out.println(modifPerso);
				this.message="Modification du laborantin avec  mot de passe";
				System.out.println(this.message);
				}
			}else{ 
				this.message="Veuillez saisir le même mot de passe";
			  }
		}else{
	modifPerso="UPDATE personne SET nom='"+this.nom+"', prenom='"+this.prenom+"', genre='"+this.genre+"'," +
			  "\n date_naissance='"+this.traitementDate(this.dateNaissance)+"', tel_fixe='"+this.telFixe+"', tel_mob='"+this.telMob+"'," +
			  "\n adresse='"+this.adresse+"', email='"+this.email+"', userName='"+this.userName+"' WHERE idPersonne='"+this.idPersonne+"'";

		i=c.updatebd(modifPerso);
			if(i!=-1){
				System.out.println(modifPerso);
				this.message="Modification du laborantin sans mot de passe";
				System.out.println(this.message);
			}
				

		}
		c.closebd();
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
	
	public void saisieService(){
		
		int i=-1;
		int validateur=0;
		//String reqSelect="SELECT COUNT(nomService) AS nombre FROM service WHERE nomService='"+this.nomService+"'";
		String requeteUpdate="INSERT INTO service(nomService) VALUES('"+this.nomService.toUpperCase()+"')";
		
		mysql sql=new mysql();
		
		//ResultSet res=sql.selectbd(reqSelect);
		
		/*try {
			if(res.next()){
				
				validateur=res.getInt("nombre");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(this.nomService.equals("")){
			
			this.message="Le champ service est vide!!";
			this.error=true;
			return;
		}
		else{
			
			if(this.nomService.startsWith("1")||this.nomService.startsWith("2")||this.nomService.startsWith("3")||this.nomService.startsWith("4")||this.nomService.startsWith("5")||this.nomService.startsWith("6")||this.nomService.startsWith("7")||this.nomService.startsWith("8")||this.nomService.startsWith("9")||this.nomService.startsWith("0")){
			
			  
			   this.message="Le nom du service contient des chiffres";
			   this.error=true;
			   return;
			}
			else{
				
				if(validateur>0){
					
					   this.message="Ce service existe deja";
					   this.error=true;
					   return;
				}
			
			}
			
			
		}
	}
	public void insertService(){
		int i=-1;
		int nbre=0;
		String reqSelect="SELECT COUNT(nomService) AS nombre FROM service WHERE nomService='"+this.nomService+"'";
		String req="INSERT INTO service(nomService) VALUES('"+this.nomService.toUpperCase()+"')";
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqSelect);
		
			try {
				if(res.next()){
					nbre=res.getInt("nombre");
					if(nbre>0){
						this.message="Ce service existe déjà";
					}else{
						i=c.updatebd(req);
						if(i>0){
							this.message="Le service de "+this.nomService.toUpperCase()+" est enregistré";
							this.initialiseService();
						}
						
					}
					
					c.closebd();
				}
				System.out.println("Message:"+this.message);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void modifService(){
		int i=-1;
		int nbre=0;
		String reqSelect="SELECT COUNT(nomService) AS nombre FROM service WHERE nomService='"+this.selected.nomService+"'";	
		String reqModif="UPDATE service SET nomService='"+this.selected.nomService+"' WHERE idService="+this.selected.idService+"";
		System.out.println(reqSelect);
		System.out.println(reqModif);
		
		//mysql c=new mysqreqSelect
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqSelect);
			try {
				if(res.next()){
					nbre=res.getInt("nombre");
						if(nbre>0){
							this.message="Ce service existe déjà";
						}else{
							i=c.updatebd(reqModif);
							if(i>0){
								this.message="Modification effectuée";
								
							}
							
						}
							c.closebd();
						System.out.println(this.message);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void initialiseService(){
		this.nomService="";
		System.out.println("Service:"+this.nomService);
	}
	
	private int idChambre;
	private String codeChambre;
	private int idPrix;
	private int prix;
	
	private List<administrateur> listChambre;
	
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

	public List<administrateur> getListChambre() {
		this.listChambre=new ArrayList<administrateur>();
//		  String req="SELECT * FROM chambre c " +
//		 			 " JOIN chambreprix cp ON cp.idChambre = c.idChambre " +
//		 			 " JOIN prix p ON p.idPrix = cp.idPrix " +
//		 			 " IN ( SELECT MAX( idPrix ) AS prixID FROM chambreprix " +
//		 			 " GROUP BY idChambre)";
		
//		SELECT DISTINCT * 
//		FROM chambrePrix cp, chambre c, prix p
//		WHERE c.idChambre = cp.idChambre
//		AND p.idPrix = cp.idPrix
//		AND cp.idPrix
//		IN (
//
//		SELECT MAX( idPrix ) AS prixID
//		FROM chambrePrix
//		GROUP BY idChambre
//		)
//		GROUP BY cp.idChambre
//		ORDER BY c.codeChambre
		
//		  String req="SELECT distinct * FROM chambrePrix cp, chambre c, prix p " +
//		   			 " WHERE c.idChambre = cp.idChambre AND p.idPrix = cp.idPrix AND cp.idPrix " +
//		   			 " IN (SELECT max( idPrix ) AS prixID FROM chambrePrix GROUP BY c.codeChambre) ORDER BY c.codeChambre";
		  
		   String req=" SELECT * FROM chambrePrix cp, chambre c, prix p WHERE c.idChambre = cp.idChambre" +
		  			  " AND p.idPrix = cp.idPrix AND cp.idPrix IN ( SELECT MAX( idPrix ) AS prixID FROM chambrePrix  GROUP BY idChambre )" +
		  			  " GROUP BY cp.idChambre ORDER BY cp.datePrixChambre DESC";
		  mysql c=new mysql();
		  ResultSet res=c.selectbd(req);
		  try {
			while(res.next()){
				 administrateur a=new administrateur();
				 a.idPrixChambre=res.getInt("idPrixChamb");
				 a.idChambre=res.getInt("idChambre");
				 a.codeChambre=res.getString("codeChambre");
				 a.idPrix=res.getInt("idPrix");
				 a.prix=res.getInt("prix");
				 this.listChambre.add(a);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChambre;
	}

	public void setListChambre(List<administrateur> listChambre) {
		this.listChambre = listChambre;
	}

	
	private List<SelectItem> listAllPrix;
	
	public List<SelectItem> getListAllPrix() {

		String req="SELECT * FROM prix";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
		
		if(this.listAllPrix==null){
			this.listAllPrix=new ArrayList<SelectItem>();
		}else{
			this.listAllPrix.clear();
		}
			try {
				while(res.next()){
					this.idPrix=res.getInt("idPrix");
					this.prix=res.getInt("prix");
					
					this.listAllPrix.add(new SelectItem(this.idPrix, ""+this.prix));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listAllPrix;
	}

	public void setListAllPrix(List<SelectItem> listAllPrix) {
		this.listAllPrix = listAllPrix;
		
	}
		
	public void initialiseChamb(){
		this.codeChambre="";
	}
	public void initialisePrix(){
		this.prix=0;
	}
	
	public void newChambre(){
		int i=-1;
		String  req="INSERT INTO chambre(codeChambre, status) VALUES('"+this.codeChambre.toUpperCase()+"', '0')";
		String verifChambre="SELECT COUNT(codeChambre) AS nombre FROM chambre" +
							" WHERE codeChambre='"+this.codeChambre.toUpperCase()+"' OR codeChambre='"+this.codeChambre.toLowerCase()+"'";
		mysql c=new mysql();
			int nbre=0;
		ResultSet res=c.selectbd(verifChambre);
		try {
			if(res.next()){
				nbre=res.getInt("nombre");
					if(nbre>0){
						this.error=true;
						this.message="Cette chambre est déjà enregistrée";
						
					}else{
				if(this.codeChambre.equals("") || this.codeChambre==null){
					this.message="Veuillez saisir la chambre";
				}else	i=c.updatebd(req);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(i>0){
			System.out.println("Insert chambre:"+req);
			this.message="Enregistrement de la chambre "+this.codeChambre.toUpperCase()+"";
			this.initialiseChamb();
			System.out.println(this.message);
		}
//			else{
//			this.message="Echec d'enregistrement";
//			System.out.println(this.message);
//		}
		
	}
	private List<SelectItem> listAllChambre;
	
	public List<SelectItem> getListAllChambre() {
		//String req="SELECT * FROM chambreprix cp JOIN chambre c ON c.idChambre=cp.idChambre ";
		String req="SELECT * FROM chambre c ORDER BY codeChambre";
		mysql c=new mysql();
		ResultSet res=c.selectbd(req);
			
		if(this.listAllChambre==null){
			this.listAllChambre=new ArrayList<SelectItem>();
		}else{
			this.listAllChambre.clear();
		}
		try {
			while(res.next()){
				this.idChambre=res.getInt("idChambre");
				this.codeChambre=res.getString("codeChambre");
				
				this.listAllChambre.add(new SelectItem(this.idChambre, this.codeChambre));
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAllChambre;
	}

	public void setListAllChambre(List<SelectItem> listAllChambre) {
		this.listAllChambre = listAllChambre;
	}

	public void newPrix(){
		int i=-1;
		int nbre=0;
		String req="INSERT INTO prix(prix) VALUES('"+this.prix+"')";
		String verifPrix="SELECT COUNT(prix) AS nombre FROM prix WHERE prix='"+this.prix+"'";
		 mysql c=new mysql();
		 ResultSet res=c.selectbd(verifPrix);
		 
		 try {
			if(res.next()){
				nbre=res.getInt("nombre");
					if(nbre>0){
						this.message="Ce prix existe déjà";
					}else{
						i=c.updatebd(req);
							if(i>0){
						this.message="Le prix de "+this.prix+" est enregistré";
						this.initialisePrix();
							}
					}
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ajoutChambre(){
		
	
	    
		this.idChambre=this.selected.idChambre;
		int i=-1;
		 String req="INSERT INTO chambreprix(idChambre, idPrix, datePrixChambre) " +
					" VALUES('"+this.idChambre+"', '"+this.idPrix+"', '"+this.traitementDateTime(new Date())+"')";
		 mysql c=new mysql();
		 i=c.updatebd(req);
		 
		 if(i>0){
			 this.message="Enregistrement effectuée";
		 }else{
			 this.message="Echec d'enregistrement";
		 }
		 
	}
	
	public void modifierChambre(){
		
		this.idChambre=this.selected.idChambre;
		this.idPrix=this.selected.idPrix;
		this.idPrixChambre=this.selected.idPrixChambre;
		int updateValid=-1;
		
		String requeteChambre="update chambreprix set idPrix='"+this.idPrix+"',datePrixChambre='"+this.traitementDateTime(new Date())+"' where idPrixChamb='"+this.idPrixChambre+"'";
		
		mysql sql=new mysql();
		
		updateValid=sql.updatebd(requeteChambre);
		
		if(updateValid!=-1){
			this.error=true;
			this.message="Modification reussie";
			System.out.println(this.message);
		}
		else{
			
			this.error=false;
			this.message="Modification echoué";
			System.out.println(this.message);
		}
		
	}
	
	
	
	
//  public void printFacture() throws BadElementException, MalformedURLException, IOException {
//	Document fact=new Document(PageSize.A4);
//	
//	try {
//		PdfWriter.getInstance(fact, new FileOutputStream("D:/facture.pdf"));
//		fact.open();
//		
//		this.sommePaye=0;
//		fact.add(new Paragraph("Prestation            Prix"));
//		for(int i=0; i<this.factureListener.size();i++){
//			
//    		System.out.println("Prestation existant:"+this.factureListener.get(i).nomPresta+" "+this.factureListener.get(i).prix);
//    				this.sommePaye=this.sommePaye+this.factureListener.get(i).prix;
//    				
//    				fact.add(new Paragraph(this.factureListener.get(i).nomPresta+"            "+this.factureListener.get(i).prix));
//    			
//    				}
//		
//					fact.add(new Paragraph("Total à payer="+this.sommePaye));
//		
//	} catch (DocumentException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	fact.close();
//}
	
	public List<administrateur> getListDesService() {
		this.listDesService=new ArrayList<administrateur>();
		
		mysql sql=new mysql();
		
		String requeteService="select distinct nomService from service";
		
		ResultSet res=sql.selectbd(requeteService);
		
		try {
			while(res.next()){
				
				administrateur pa =new administrateur();
				
				pa.nomService=res.getString("nomService");
				
				this.listDesService.add(pa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDesService;
	}

	public void setListDesService(List<administrateur> listDesService) {
	
		this.listDesService = listDesService;
	}
    
	public List<administrateur> getListChambreSansPrix() {
		this.listChambreSansPrix=new ArrayList<administrateur>();
		mysql sql=new mysql();
		
		String requeteChambre="select cha.idChambre,cha.codeChambre,chapri.idPrix,pri.prix from chambre " +
				"cha left join chambreprix chapri on cha.idChambre=chapri.idChambre " +
				"left join prix pri on pri.idPrix=chapri.idPrix " +
				"where chapri.idPrix is null "; 
		
		ResultSet res=sql.selectbd(requeteChambre);
		
		try {
			while(res.next()){
				
				administrateur pa=new administrateur();
				
				pa.idChambre=res.getInt("idChambre");
				pa.codeChambre=res.getString("codeChambre");
				pa.idPrix=res.getInt("idPrix");
				pa.prix=res.getInt("prix");
				
				if(pa.idPrix==0){
					pa.chambreStatus="Prix non attribue";
				}
				this.listChambreSansPrix.add(pa);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChambreSansPrix;
	}

	public void setListChambreSansPrix(List<administrateur> listChambreSansPrix) {
		this.listChambreSansPrix = listChambreSansPrix;
	}

	public administrateur() {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//administrateur a=new administrateur();
		
		//a.getListMedecin();
	System.out.println("");
		//a.getListInfirmier();
		//a.getListRecept();
	//a.getListLab();
	//a.getListService();
	//Date d=new Date();
	//System.out.println(a.genererCode());
	}

}
