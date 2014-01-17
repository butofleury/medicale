package saisie;

//import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
public class data {

	public data() {
		// TODO Auto-generated constructor stub
	}
	
	//Foction qui recuperre toutes les categories
	public static List<SelectItem> getCategorie(){
		
		List<SelectItem> listCat=new ArrayList<SelectItem>();
		String getCategories="SELECT * FROM categorie";
		mysql c=new mysql();
		String[] colonne=null;
		
		ResultSet res=c.selectbd(getCategories);
		try {
			while(res.next()){
			colonne=new String[2];
			colonne[0]=""+res.getInt("idCat");
		    colonne[1]=res.getString("nomCat");
		    listCat.add(new SelectItem(colonne[0], colonne[1]));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCat;
		
		
		
		
	}
	
	//Fonction qui recuperre tous les patients
	public static List<String[]> getAllPatient(){
		List<String[]> listeAllPatient=new ArrayList<String[]>();
		String reqAllPatient="SELECT * FROM personne pe JOIN patient pa ON pe.idPersonne=pa.idPersonne";
		
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqAllPatient);
		String colonne[];
		try {
			while(res.next()){
				colonne=new String[11];
colonne[0]=""+res.getInt("idPersonne"); colonne[1]=res.getString("nom"); colonne[2]=res.getString("prenom");
colonne[3]=""+res.getDate("date_naissance"); colonne[4]=res.getString("tel_fixe"); colonne[5]=res.getString("tel_mob");
colonne[6]=res.getString("adresse");colonne[7]=res.getString("email"); colonne[8]=""+res.getInt("idPatient");
colonne[9]=res.getString("CodePatient"); colonne[10]=res.getString("profession");
		
	System.out.println(colonne[1]+","+ colonne[2]);
	listeAllPatient.add(colonne);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeAllPatient;
	}
	
	//Fonction qui recuperre tous les rendez-vous
	public static List<String[]> getAllRendezVous(){
		List<String[]> listeAllRendezVous=new ArrayList<String[]>();
		String reqAllPatient="SELECT * FROM rendezVous re"+
							"JOIN patient pa ON pa.idPatient = re.idPatient"+
							"JOIN service se ON se.idService = re.idService"+
							"JOIN personne pe ON pe.idPersonne = pa.idPersonne";
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqAllPatient);
		String colonne[];
		try {
			while(res.next()){
				colonne=new String[12];
				colonne[0]=""+res.getInt("idRendezVous");
		
				listeAllRendezVous.add(colonne);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeAllRendezVous;
		
	}
	
	//Fonction qui recuperre toutes les chambres
	public static List<SelectItem> getChambre(){
		List<SelectItem> listChambre=new ArrayList<SelectItem>();
		String reqChambre="SELECT * FROM chambre";
		mysql c=new mysql();
		String colonne[]=null;
		ResultSet res=c.selectbd(reqChambre);
		
		try {
			while(res.next()){
				colonne=new String[2];
				colonne[0]=""+res.getInt("idChambre");
				colonne[1]=res.getString("CodeChambre");
			System.out.println(colonne[0]+"  "+colonne[1]);
				listChambre.add(new SelectItem(colonne[0], colonne[1]));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChambre;
		
	}
	
	//Fonction qui recuperre tous les patients qui ont des soins qu'on a pas encore executés
	public static List<String[]> getPatientSoin(){
		List<String[]> patientSoin=new ArrayList<String[]>();
			
		String getPatient="SELECT * FROM patient p, personne pe, fichemed f " +
						  "WHERE  pe.idPersonne = p.idPersonne " +
						  "AND  p.idPatient = f.idPatient AND f.fait=0 " +
						  "GROUP BY f.idPatient order by f.dateConsultation";
				          
		mysql c=new mysql();
		
		ResultSet res=c.selectbd(getPatient);
		
		try {
			while(res.next()){
				String[] colonne=new  String[5];
				//colonne=new  String[5];
				colonne[0]=""+res.getInt("idPatient");
				colonne[1]=res.getString("CodePatient");
				colonne[2]=res.getString("nom");
				colonne[3]=res.getString("prenom");
				colonne[4]=res.getString("profession");
			System.out.println(colonne[0]+" "+colonne[1]+" "+colonne[2]+" "+colonne[3]+" "+colonne[4]);
				patientSoin.add(colonne);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return patientSoin;
		
	}
	
	//Fonction qui recuperre tous les patients dont leurs consultations est prévue aujourd'hui
	public static List<SelectItem> getPatientFiche(){
		List<SelectItem> listPatientFiche=new ArrayList<SelectItem>();
		String reqPatientFiche="SELECT * FROM fichemed f JOIN " +
								"patient p ON p.idPatient=f.idPatient " +
								"WHERE dateConsultation=CURRENT_DATE()";
		mysql c=new mysql();
		String colonne[]=null;
		ResultSet res=c.selectbd(reqPatientFiche);
		
		try {
			while(res.next()){
				colonne=new String[7];
				colonne[0]=""+res.getInt("idFiche");
				colonne[1]=""+res.getInt("idPatient");
				colonne[2]=res.getString("Soins");
				
				System.out.println(colonne[0]+" "+colonne[1]+" "+colonne[2]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPatientFiche;
		
		
	}
	//Fonction qui recuperre tous les infirmiers 
	public static List<String[]> getInfService(){
		List<String[]> listInf=new ArrayList<String[]>();
		String reqInf="SELECT * FROM infirmier i " +
					  "JOIN personne p ON p.idPersonne = i.idPersonne " +
					  "JOIN fichemed f ON f.idInf = f.idInf GROUP BY i.idInf";
		mysql c=new mysql();
		ResultSet res2=c.selectbd(reqInf); 
		String colonne[];

				try{
			while(res2.next()){
				colonne=new String[5];
				colonne[0]=""+res2.getInt("idInf");
				colonne[1]=res2.getString("CodeInf");
				colonne[2]=res2.getString("nom");
				colonne[3]=res2.getString("prenom");
				colonne[4]=res2.getString("userName");
			System.out.println(colonne[0]+"  "+colonne[1]+"  "+colonne[2]+" "+colonne[3]+" "+colonne[4]);
				listInf.add(colonne);
				}
			//return listInf;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return listInf;
	}
	
	//Fonction qui recuperre tous les patients ayant des soins exigés par le medecin
	public static List<String[]> getPatientFicheSoin(){
	 List<String[]> patientSoinsFiche=new ArrayList<String[]>();
	 String reqPatientSoins="SELECT * FROM fichemed f JOIN patient p ON p.idPatient=f.idPatient " +
							"JOIN personne pe ON pe.idPersonne=p.idPersonne WHERE f.Soins!='' GROUP BY f.idPatient";
	 mysql c=new mysql();
	 ResultSet res=c.selectbd(reqPatientSoins);
	 String colonne[]=null;
	 	try {
			while(res.next()){
		//if(res.getString("Soins")!=""){
				colonne=new String[5];
				colonne[0]=""+res.getInt("idPatient");
				colonne[1]=res.getString("CodePatient");
				colonne[2]=res.getString("nom");
				colonne[3]=res.getString("prenom");
				colonne[4]=res.getString("Soins");
			System.out.println(colonne[0]+"  "+colonne[1]+"  "+colonne[2]+" "+colonne[3]+" "+colonne[4]);
				patientSoinsFiche.add(colonne);
		//}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	return patientSoinsFiche;
	
		
	}
	
	//Fonction qui recuperre tous les patients hospitalisés
	public static List<String[]> getPatHosp(){
		List<String[]> getPatientHosp=new ArrayList<String[]>();

		String getPatHosp="SELECT * FROM fichemed f JOIN patient p ON p.idPatient=f.idPatient" +
						  "JOIN personne pe ON pe.idPersonne=p.idPersonne" +
						  "JOIN medecin m ON m.idMedecin=f.idMedecin WHERE f.idChambre>0";
		//connexionDB c1=new connexionDB("jdbc:mysql://localhost:3306/medicale");
		mysql c1=new mysql();
		 ResultSet res1=c1.selectbd(getPatHosp);
		 String colonne[]=new String[5];
		 System.out.println("Valeur du resultat:"+res1);
		 //System.out.println(res1.next());
		try {
			while(res1.next()){
				//colonne=new String[5];
				colonne[0]=""+res1.getInt("idFiche");
				colonne[1]=res1.getString("CodePatient");
				colonne[2]=res1.getString("nom");
				colonne[3]=res1.getString("prenom");
				colonne[4]=res1.getString("Soins");
			
			System.out.println(colonne[0]+" "+colonne[1]+" "+colonne[2]+" "+colonne[3]+" "+colonne[4]);
				getPatientHosp.add(colonne);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return getPatientHosp;
	}

	//Fonction qui recuperre toutes les prestations de categories soins
	public static List<String[]> getPrestSoin(){
		List<String[]> prestSoin=new ArrayList<String[]>();
		String reqPrestSoin="SELECT * FROM prestation pre JOIN prix p ON p.idPrix=pre.idPrix" +
							" JOIN categorieprest cp ON cp.idCatPrest=pre.idCatPrest" +
							" WHERE  cp.nomCatPrest='SOIN' ORDER BY pre.idPrestation";
		mysql c=new mysql();
		ResultSet res=c.selectbd(reqPrestSoin);
		String colonne[]=null;
		//String colonne[]=new String[9];
		//System.out.println("Liste des Soins:");
			try {
				while(res.next()){
		colonne=new String[9];
		colonne[0]=""+res.getInt("idPrestation");
		colonne[1]=res.getString("nomPrest");
		colonne[2]=""+res.getString("idCatPrest");
		colonne[3]=""+res.getString("idPrix");
		colonne[4]=""+res.getDate("datePrix");
		colonne[5]=""+res.getInt("idPrix");
		colonne[6]=""+res.getInt("prix");
		colonne[7]=""+res.getInt("idCatPrest");
		colonne[8]=res.getString("nomCatPrest");
		
		//System.out.println(colonne[0]+" "+colonne[1]+" "+colonne[2]+" "+colonne[3]+" "+colonne[4]+ " "+colonne[5]+" "+colonne[6]+" "+colonne[7]+" "+colonne[8]);
		prestSoin.add(colonne);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prestSoin;			
	} 
	
	//Fonction qui recuperre tous les rendez-vous qui n'ont pas encore été payé en totalité
//	public static List<String[]> getRendezVous(){
//		List<String[]> rendezVous=new ArrayList<String[]>();
////		String getRendezVous="SELECT * FROM rendezvous r " +
////		 "JOIN patient p on p.idPatient=r.idPatient " +
////		 "JOIN personne pe ON pe.idPersonne=p.idPersonne" +
////		 "JOIN service s ON s.idService=r.idService";
//		
//		String getRendezVous="SELECT * FROM rendezvous r JOIN service s ON s.idService=r.idService";
//		
//		connexionDB c=new connexionDB();
//		ResultSet res=c.selectBD(getRendezVous);
//		String[] data=null;
//		
//		try {
//			while(res.next()){
//				data=new String[15];
//			data[1]=""+res.getInt("idPatient");
//			data[8]=res.getString("nomService");
//			//System.out.println(Integer.parseInt(data[1]));
//		//data[1]=""+res.getInt("idPatient");
//		String getPatient="SELECT * FROM patient WHERE idPatient='"+Integer.parseInt(data[1])+"'";
//		connexionDB c1=new connexionDB();
//		ResultSet res1=c1.selectBD(getPatient);
//		//System.out.println("Resultat:"+res1);
//		if(res1.next()){
//		
//		String getPersoPat="SELECT * FROM personne WHERE idPersonne='"+res1.getInt("idPersonne")+"'";
//		
//		ResultSet res2=new connexionDB().selectBD(getPersoPat);
//			if(res2.next()){
//			data[3]=res2.getString("nom");
//			data[4]=res2.getString("prenom");}
//		}
//	
//				data[0]=""+res.getInt("idRendezVous");
//				data[1]=""+res.getInt("idPatient");
//				data[2]=""+res.getDate("dateRendezVous");
//				
//				data[5]=res.getString("nomService");
//				data[6]=""+res.getInt("montantPaye");
//				data[7]=""+res.getInt("montantRestant");
//				
//	//System.out.println(data[0]+" "+Integer.parseInt(data[1])+" "+data[2]+" "+data[6]+" "+data[7]+" "+data[5]);	
//   System.out.println("Return:"+data[1]+" "+data[3]+" "+data[4]+" "+data[2]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]);
//				rendezVous.add(data);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rendezVous;
//	}
	
	public static List<String[]> getRendVCredit(){
		List<String[]> listRdV=new ArrayList<String[]>();
		
		String getRendezVous="SELECT * FROM rendezvous r " +
		 					 "JOIN patient p on p.idPatient=r.idPatient " +
		 					 "JOIN personne pe ON pe.idPersonne=p.idPersonne " +
		 					 "JOIN service s ON s.idService=r.idService";
		System.out.println(getRendezVous);
		mysql c=new mysql();
		ResultSet res=null;
		 res=c.selectbd(getRendezVous);
		String[] data=null;
		try {
			while(res.next()){
				data=new String[10];
				
				data[0]=""+res.getInt("idRendezVous");
				data[1]=""+res.getDate("dateRendezVous");
				data[2]=""+res.getDate("dateAttribution");
				data[3]=res.getString("nom");
				data[4]=res.getString("prenom");
				if(res.getString("montantPaye")==null)
					data[5]=""+0;
				else	
				data[5]=res.getString("montantPaye");
				
				data[6]=res.getString("montantRestant");
				data[7]=res.getString("nomService");
			System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]);
				listRdV.add(data);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRdV;
		
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		//data.getAllPatient();
		//data.getPatientSoin();
		//data.getChambre();
		//data.getPatientFiche();
		//data.getInfService();
		//data.getPatientFicheSoin();
		//data.getPatientSoin();
		//data.getPatHosp();
		//data.getPrestSoin();
		//data.getRendezVous();
		data.getRendVCredit();
		
	}

}
