import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector; 
import java.util.Hashtable; //List (k,v)

// Permite añadir librerias Vectors, Hash exclusivamente
// Requiere utilizacion de threads

public class Import {

	public Import(String fileName) {
		
	
	  File file = new File(fileName+".txt"); 
	  BufferedReader br = null;
	  
	  //Lectura fichero
	try {
		br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) {
		
		System.out.println("Error: Fichero no se ha encontrado.");
		e.printStackTrace();
	} 
	 
	//Cargar vector de lineas
	  String st; 
	  Vector<String> lines = new Vector<String>();
	  
	  try {
	
		while ((st = br.readLine()) != null) 
			lines.add(st);
	} catch (IOException e) {
		System.out.println("Error: No se puede leer las lineas del fichero: "+fileName+".txt");
		e.printStackTrace();
	} 
	  
	  //Mostrar vector de lineas
	  System.out.println("Mostrar Vector Lineas:\n\n");
	  for(int i=0;i<lines.size();i++){
		  
		  System.out.println(lines.get(i));
	  }
	  
	  
	  Hashtable <String,Integer> mapping = new Hashtable<String,Integer>();
	  //Split to Hastable
	  for(int i=0;i<lines.size();i++){
		  
		  String[] palabras = lines.get(i).split(" ");
		  
		  for(int j=0;j<palabras.length;j++) {
			  
			  mapping.put(palabras[j],1);
		  }
	  }
	  
	  // create a clone or shallow copy of hash table h 
    
      System.out.println("\nMapping<String,Interger> <key,value>:\n " + mapping); 
	  System.out.println("\nNumero de valores mapa: "+mapping.size());
	   
	}
}
