
import java.io.IOException;



/**
 * Class Controller:
 * Clase encargada de gestionar la entrada
 * y salida del programa, a nivel general.
 * El numero de entradas puede variar 1-n
 */
public class Controller {

	
	
	
	/**
	 * @param args ficheros de entrada para leer
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis(); //Tiempo Inicio Programa
		
		
		//ARGUMENT HANDLE 
		
		if(args.length==1) {
			//System.out.println("Numero de argumentos: 1");
			MapReduce mapReduce = new MapReduce(args[0],1);
		}else {
			//System.out.println("Numero de argumentos: "+args.length+"\n");
			for (int i=0;i<args.length;i++) { 
				//System.out.println("Importando File"+(i+1)+"...");
				MapReduce mapReduce = new MapReduce(args[i],i+1);
			}
		}
		
		
		 long stopTime = System.currentTimeMillis();
	     long elapsedTime = stopTime - startTime;
	  
	     System.out.println("\nTiempo de ejecucion total del programa: "+elapsedTime+"ns");

	}

}
