package saisie;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;






public class login  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private String nom;
	private String prenom;
	private String userName;
	private String passWord;
	private String message;
	private int idService;
	private String typeUser;
	private String nomService;
	private int idCat;
	private int idPersonne;
	private String nomCat;
	private int idRec;
	private int idMedecin;
	private int idLaborantin;
	private int idInf;
	private int idAdmin;
	private String nameUser;
	private boolean status;
	private String confPassWord;
	private String newPassWord;
	private String messageChangePassWord;
	
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
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	
	
	
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	
	
	
	
	
	public int getIdRec() {
		return idRec;
	}
	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}
	public int getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}
	public int getIdLaborantin() {
		return idLaborantin;
	}
	public void setIdLaborantin(int idLaborantin) {
		this.idLaborantin = idLaborantin;
	}
	public int getIdInf() {
		return idInf;
	}
	public void setIdInf(int idInf) {
		this.idInf = idInf;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	
	
	
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String getConfPassWord() {
		return confPassWord;
	}
	public void setConfPassWord(String confPassWord) {
		this.confPassWord = confPassWord;
	}
	
	
	public String getNewPassWord() {
		return newPassWord;
	}
	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}
	public String getMessageChangePassWord() {
		return messageChangePassWord;
	}
	public void setMessageChangePassWord(String messageChangePassWord) {
		this.messageChangePassWord = messageChangePassWord;
	}
	public String validationUser(){
		
	  this.message="";
      mysql sql=new mysql();
      
      ResultSet res=null;
		
		String requete="select per.idPersonne,per.nom,per.prenom,per.userName,per.passWord,per.idCat,catPe.nomCat from personne per" +
				" join categorieperso catPe on catPe.idCat=per.idCat" +
				" where per.userName='"+this.userName+"'" +
				" and per.passWord='"+this.passWord+"'" +
				" order by per.idPersonne desc";
			
		System.out.println(requete);
		
		 res=sql.selectbd(requete);
		 
		 FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session =(HttpSession)context.getExternalContext().getSession(true);
			
		    session.setAttribute("id", idPersonne);
			session.setAttribute("userName",userName);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("ident", "ident");
			
			String idL=session.getAttribute("id").toString();
			this.idUser=Integer.parseInt(idL);
		
		try {
			if(res.next()){
				 
				this.idPersonne=res.getInt("idPersonne");
				System.out.println(idPersonne);
				this.idCat=res.getInt("idCat");
				this.nomCat=res.getString("nomCat");
				this.userName=res.getString("userName");
				System.out.println("Utilisateur:"+this.userName);
				System.out.println(this.nomCat);
				this.nameUser=this.userName;
				this.nom=res.getString("nom");
				this.prenom=res.getString("prenom");
				
				//int idPerso=this.idPersonne;
				System.out.println("nameUser:"+this.nameUser+" "+this.status);
				
				System.out.println("Nom:"+this.nom);
				
				
				
				
				if(this.nomCat.equalsIgnoreCase("receptionniste")){
					
					System.out.println("Affichage de l'utilisateur:receptionniste");
					
					String requeteRec="select idRec, status from receptionniste where idPersonne='"+this.idPersonne+"'";
					System.out.println(requeteRec);
					ResultSet resRec=sql.selectbd(requeteRec);
					
					if(resRec.next()){
						 
						this.idRec=resRec.getInt("idRec");
						this.status=resRec.getBoolean("status");
						System.out.println("Status:"+this.status);
						
						if(this.status==true){
						session.setAttribute("idRec", this.idRec);
						this.typeUser="receptionniste";
						}else{
							this.message="Vous êtes désactivés de l'application";
							this.typeUser="desactive";
						}
	
					}
		
					
				}
				else{
					
					if(this.nomCat.equalsIgnoreCase("infirmier")){
						System.out.println("infirmier");
						String requeteInf="SELECT idInf, status FROM infirmier WHERE idPersonne='"+this.idPersonne+"'";
						ResultSet resInf=sql.selectbd(requeteInf);
							if(resInf.next()){
								this.idInf=resInf.getInt("idInf");
								this.status=resInf.getBoolean("status");
								System.out.println("Status:"+this.status);
								
								if(this.status==true){
								session.setAttribute("idInf", this.idInf);
								this.typeUser="infirmier";
								}else{
									this.message="Vous êtes désactivés de l'application";
									this.typeUser="desactive";
								}
							}

						
						
						
					}
					else{
						
						if(this.nomCat.equalsIgnoreCase("medecin")){
							
							
							System.out.println("medecin");
							
							String requeteMed="select idMedecin, status from medecin where idPersonne='"+this.idPersonne+"'"; 
							ResultSet resMed=sql.selectbd(requeteMed);
							
							if(resMed.next()){
								
								this.idMedecin=resMed.getInt("idMedecin");
								this.status=resMed.getBoolean("status");
								System.out.println("Status:"+this.status);	
								
								if(this.status==true){
									session.setAttribute("idMedecin", this.idMedecin);
									this.typeUser="medecin";
								}else{
									this.message="Vous êtes désactivés de l'application";
									this.typeUser="desactive";
								}
								
							}
							
						}
						else{
							
							if(this.nomCat.equalsIgnoreCase("laborantin")){
								System.out.println("laborantin");
								String requeteLab="SELECT idLaborantin, status FROM laborantin WHERE idPersonne='"+this.idPersonne+"'";
								ResultSet resLab=sql.selectbd(requeteLab);
									if(resLab.next()){
								this.idLaborantin=resLab.getInt("idLaborantin");
								this.status=resLab.getBoolean("status");
								System.out.println("Status:"+this.status);
								if(this.status==true){
									this.typeUser="laborantin";
									session.setAttribute("idLaborantin", this.idLaborantin);	
								}else{
									this.typeUser="desactive";
									this.message="Vous êtes désactivés de l'application";
								}
								
									}
									
								
								
							}
							else{
								if(this.nomCat.equalsIgnoreCase("administrateur")){
									
									
									System.out.println("administrateur");
									
									this.typeUser="administrateur";
									
								}
								
								
								
							}
						}
					}
						
				}
				
				
			}
			else{
				  
				System.out.println("Pas d'utilisateur");
				
				
				this.message="L'identifiant ou le mot de passe sont incorrects!";
				
				System.out.println("Connection echoue");
				
				this.userName="";
				this.passWord="";

				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			this.message="Pas de connexion à la base de données!";
		}
		
		session.setAttribute("typeUser",this.typeUser);
		
		return typeUser;
	}
	
	
	public String deconnecteUser(){
		
		 FacesContext context = FacesContext.getCurrentInstance();
		   HttpSession session =(HttpSession)context.getExternalContext().getSession(true);   
		 
		   session.invalidate();
		 return "deconnexion";
	}
	
	public void changePassWord(){
		this.messageChangePassWord="";
		 FacesContext context = FacesContext.getCurrentInstance();
		 HttpSession session =(HttpSession)context.getExternalContext().getSession(true);
			
		    session.setAttribute("id", idPersonne);
			session.setAttribute("userName",userName);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("ident", "ident");
			
			String idL=session.getAttribute("id").toString();
			this.idUser=Integer.parseInt(idL);
			
			System.out.println("Id de l'utilisateur:"+this.idUser+" "+this.newPassWord+" "+this.confPassWord);
			String req="UPDATE personne SET passWord='"+this.newPassWord+"' WHERE idPersonne="+this.idUser+"";
			mysql sql=new mysql();
			int i=-1;
			
			if(this.newPassWord.equals(this.confPassWord)){
				i=sql.updatebd(req);
				
				if(i>0){
					this.messageChangePassWord="Mot de passe modifié";
					this.newPassWord="";
					this.confPassWord="";
				}
			}else{
				this.messageChangePassWord="Veuillez saisir le même mot de passe";
			}
			
			
	}

	public login(){
		
		
		
		
	}
	
}
