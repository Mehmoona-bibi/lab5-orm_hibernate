package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {
   private static SessionFactory factory;
   

    public static void main(String[] args) throws FileNotFoundException {
			   
	Scanner scanner = new Scanner(new File("C:\\Users\\boss\\Documents\\NetBeansProjects\\Lab_5\\GeoLiteCity-Location.csv"));
        scanner.useDelimiter(",");
        
        scanner.nextLine();
        scanner.nextLine();
        while(scanner.hasNextLine()){
       
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            if (fields.length >= 4) // At least one address specified.
            {
                for (String field: fields) System.out.print(field + "|");
                System.out.println();
            }
            else
            {
                System.err.println("Invalid record: " + line);
            }
            //System.out.print(scanner.next());
          
        }
    scanner.close();
            
   
            
            
	try{
                File cfg_file = new File("C:\\Users\\boss\\Documents\\NetBeansProjects\\Lab_5\\src\\Actor.cfg.xml");
                Configuration cfg = new Configuration();
                cfg.configure(cfg_file);
                cfg.addAnnotatedClass(Actor.class);
                factory = cfg.buildSessionFactory();
        } catch (Throwable ex){
                ex.printStackTrace();
        }
        
		Main m = new Main();
		m.listActors();
		
	}
	private void listActors(){
		Session ss = factory.openSession();
		Transaction tx = null;
		try{
			tx = ss.beginTransaction();
			List<Actor> actors = ss.createQuery("FROM Actor").list();
			for(Actor a : actors){
				System.out.println(a.getFname());
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ss.close();
		}
        
        }
}