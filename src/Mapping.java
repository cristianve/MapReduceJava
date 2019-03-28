
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 */

/**
 * Class Mapping:
 * Clase encargada de mappear todas
 * las palabras (word,[value]) y ejecutar los threads.
 * Dentro de cada thread se mappea y se
 * hace un merge.
 */

public class Mapping implements Runnable{
	
	private Vector<String> subDataset= new Vector<String>();
	private Vector<Pair> map = new Vector<Pair>();
	
	
	public Vector<Pair> getMap() {
		return map;
	}



	Mapping(Vector<String> subDataset){
		
		this.subDataset= subDataset;
	}

	
	
	
	@Override
	public void run() {

		//System.out.println("Run Thread ");
		//System.out.println("Mapping Part...");
		map= this.mapping(subDataset);
		//System.out.println("Merging 1 Part...");
		map=this.shuffle(map);
		
	}
	
	
	
	/**
	* Funcion encarga de mapear todas las palabras separadas por espacios
	*/
	
	public Vector<Pair> mapping (Vector<String> subDataset){
		 
		  String[] palabras = null;
		  Vector<Pair> map = new Vector<Pair>();
	
		  
		  
		  for(int i=0;i<subDataset.size();i++){
			  
			  palabras = subDataset.get(i).split(" ");
			  
			  for(int j=0;j<palabras.length;j++) {
				  
				  List<Integer> aux = new ArrayList<Integer>();
				  aux.add(j);
				  String pal = palabras[j];
				  map.add(new Pair(pal,aux));
			  }
		  }
		return map; 
	 }

	
	/**
	* Funcion encarga agrupar todas aquellas palabras en la Lista <k,v>
	*/
	public Vector<Pair> shuffle(Vector<Pair> map){
	 
		 for(int i=0; i<map.size();i++) {
		  
		 String tmp = map.get(i).getPalabra();
	
		 for(int j= i+1; j<map.size();j++) {
			 
			// System.out.println("COMPARANDO"+tmp+" vs "+map.get(j).getPalabra());
			 
			 if(tmp.equals(map.get(j).getPalabra())) {
				 
				 //System.out.println("IGUALES"+tmp+" vs "+map.get(j).getPalabra());
				 
				 List<Integer> aux2 = new ArrayList<Integer>();
				 
				 aux2.addAll(map.get(i).getValor());
				 aux2.addAll(map.get(j).getValor());
				 
				 Pair aux3= new Pair(tmp,aux2);
				 map.set(i, aux3 );
				 map.remove(j);
				 j--;
			 }
		 	} 
		 }


		 return map;

}

}
