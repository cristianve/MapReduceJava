
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * 
 */

/**
 * Class Import:
 * Clase encargada de leer el archivo
 * especificado en los argumentos de entrada
 * y guardarlo cada linea en una posion
 * de un Vector<String>
 */

public class Import {
	
	
	private Vector<String> lines = new Vector<String>();
	
	
	
	/**
	* Constructor encargado de leer todas las lineas del fichero especificado por el fileName
	*/
	Import(String fileName) throws UnsupportedEncodingException{
		

		//File file = new File(fileName+".txt"); 
		File file = new File(fileName); 
		BufferedReader br = null;

		try {
			 br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
		} catch (FileNotFoundException e) {
			
			System.out.println("Error: Fichero no se ha encontrado.");
			e.printStackTrace();
		} 
		 
		String st;
		  
		try {
		
			while ((st = br.readLine()) != null) 
				lines.add(st.replaceAll("\\.", "").replaceAll("\\,", "").replaceAll("\\;","").toLowerCase()); //TODO ARREGLAR REPLACE
		} catch (IOException e) {
			System.out.println("Error: No se puede leer las lineas del fichero: "+fileName);
			e.printStackTrace();
		} 
		  
		  
	}

	public Vector<String> getLines() {
		return lines;
	}



	
}
