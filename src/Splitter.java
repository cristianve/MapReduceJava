
import java.util.Vector;

/**
 * 
 */

/**
 * Class Splitter:
 * Clase encargada de divir las lineas
 * en dos datasets diferentes.
 * Reduce el volume global en 2.
 */
public class Splitter {
	
	
	  private Vector<String> subDataSet1 = new Vector<String>();
	  private Vector<String> subDataSet2 = new Vector<String>();

	  
	  
	  Splitter(Vector<String> lines){
		  
		  if(lines.size()>2) {
			  
			  int corte= (Integer) lines.size()/2; 
			  
			  for(int i=0;i<corte;i++) {
				  subDataSet1.add(lines.get(i));
			  }
			  
			  for(int i=corte;i<lines.size();i++) {
				  subDataSet2.add(lines.get(i));
			  }

			    
		  }else System.out.println("No se puede dividir el texto en 2 thread , minimo 2 lineas");
		  
		  
		
	}


	public Vector<String> getSubDataSet1() {
		return subDataSet1;
	}


	public Vector<String> getSubDataSet2() {
		return subDataSet2;
	}




}
