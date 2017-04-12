package city;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import ran.ReadCSVFile;

public class CityData {
	
	private static SessionFactory factory; 

	public void readFile(String csvFileToRead) {
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        //String[] products = new String[9];
        try {
                br = new BufferedReader(new FileReader(csvFileToRead));
                String headerLine = br.readLine();
                System.out.println( headerLine );
                
                while ((line = br.readLine()) != null) {
                		String[] products = new String[9];
                	
                        //products = line.split(splitBy);
                		
                        products = line.split(splitBy, -1);
                        
                        //int id = Integer.parseInt(products[0]);
                		String cntry = products[1];
                		System.out.println( cntry );
                		String rgn = products[2];
                		System.out.println( rgn );
                		String Ccity = products[3];
                		System.out.println( Ccity );
                		String postal = products[4];
                		System.out.println( postal );
                		float latti =  Float.parseFloat(products[5]);
                		System.out.println( latti );
                		float longi = Float.valueOf(products[6]);
                		System.out.println( longi );
                		int metro = 0;
						try
                		{
                		    if(products[7] != null)
                		     metro = Integer.parseInt( products[7] );
                		}
                		catch (NumberFormatException e)
                		{
                		    metro = 0;
                		}
                		//int metr0o = Integer.parseInt(products[7]);
                		//System.out.println( metr0o );
						
						int area = 0;
						try
                		{
                		    if(products[8] != null)
                		     area = Integer.parseInt( products[8] );
                		}
                		catch (NumberFormatException e)
                		{
                		    area = 0;
                		}
                		//int area = Integer.parseInt(products[8]);
                		//System.out.println( area );
                        
                		addCity(cntry, rgn, Ccity, postal, latti, longi , metro, area);
                		
//                        System.out.println( products.length );
//                        for ( int i = 0 ; i < products.length; i++ )
//                        {
//                        	System.out.println( i + "## " + products[i] );
//                        }
//                        System.out.println("Products [ locId = " + products[0] + " , country ="+ products[1] +
//" , region =" + products[2]  + " , city ="+ products[3]+ " , postalCode ="+ products[4] + " , latitude ="+ products[5] + 
//" , longitude ="+ products[6] + " , metroCode ="+ products[7] + " , areaCode ="+ products[8] + "]");
                        
                        
                }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                if (br != null) {
                        try {
                                br.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	        
	      }
		
		
		String csvFileToRead;
            csvFileToRead = "/C:/Users/boss/Documents/NetBeansProjects/lab55/GeoLiteCity-Location.csv";
        CityData reader = new CityData();
        System.out.println("ffdf");
        reader.readFile(csvFileToRead);
        
        
	}
	
	public Integer addCity(String cntry, String rgn, String Ccity , String postal, float latt , float longi, int metro, int area){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer cityID = null;
	      try{
	         tx = session.beginTransaction();
	         City _city = new City(cntry, rgn, Ccity, postal, latt, longi , metro, area);
	         cityID = (Integer) session.save(_city); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return cityID;
	}

}
