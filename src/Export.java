
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Class Export:
 * Clase encargada de generar el archivo de salida
 * con el correspondiente map(k,v) formatado.
 */

public class Export {


	/**
	* Funcion que muestra por pantalla la salida del recuento de palabras al finalizar el MapReduce completo
	*/
	Export(String fileName, Vector<Pair> map) throws IOException{
		
		
		/*
	    BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter("File"+nFicheros+"_result.txt"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
		System.out.println(fileName+":");
			
		    for(int i=0;i<map.size();i++) {
		    				
		    				System.out.println(map.get(i).getPalabra()+" : "+map.get(i).getValor().toString().replaceAll("\\[", "").replaceAll("\\]",""));
							//writer.write(map.get(i).getPalabra()+" : "+map.get(i).getValor().toString().replaceAll("\\[", "").replaceAll("\\]",""));
							//writer.newLine();
					
		    }
		    System.out.println("\n");
		    
			//writer.close();
	}
}
