
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 */

/**
 * Class MapReduce:
 * Clase que engloba todos 
 * los procedimientos necesarios
 * para realizar el MapReduce.
 * (Import->Split->Merge(datasets)->Merge->Reduce)
 * Llama a todas las clases
 * menos la Controler que le llama
 * a esta.
 */
public class MapReduce {
	
	private Import lines;
	private Vector<Pair> map = new Vector<Pair>();
	


	/**
	* Constructor encargado de gestionar todas las etapas del MapReduce
	* asi como Splitter-->Mapping-->Esperar Threads-->shuffle-->Reduce
	*/
	MapReduce(String fileName, int nFicheros) throws IOException{
		
		//System.out.println("Importing file: "+fileName);
		this.lines= new Import(fileName);
		//System.out.println("Splitting - 2 Volumenes ...");
		Splitter split = new Splitter(lines.getLines());
		Mapping mp1 = new Mapping(split.getSubDataSet1());
		Mapping mp2 = new Mapping(split.getSubDataSet2());
		
		//System.out.println("Creando threads para cada dataset");
		Thread t1 = new Thread (mp1); 
		t1.start();
		Thread t2 = new Thread (mp2);
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Thread Finalizado");
		//System.out.println("Merging 2 Part...");
		this.map= this.shuffle(mp1.getMap(), mp2.getMap());
		//System.out.println("Reducing...");
		this.map=this.reduce(map);
		//System.out.println("Exportin file..");
		
		new Export(fileName, this.map);
		
		
		
	}
	
	
	
	
	/**
	* Funcion encarga agrupar todas aquellas palabras en la Lista <k,v>
	*/
	 public Vector<Pair> shuffle(Vector<Pair> map1, Vector<Pair> map2){
		 
		 Vector<Pair> mapFinal = new Vector<Pair>();
		 
		 
		    for(int i=0; i<map1.size();i++) {
				  
		 		 String tmp = map1.get(i).getPalabra();
		 		 boolean encontrado=false;
		 		 
		 		 for(int j= 0; j< map2.size();j++) {
		 			 
		 			// System.out.println("COMPARANDO"+tmp+" vs "+map.get(j).getPalabra());
		 			 
		 			 if(tmp.equals(map2.get(j).getPalabra())) {
		 				 
		 				 //System.out.println("IGUALES"+tmp+" vs "+map.get(j).getPalabra());
		 				 
		 				 List<Integer> aux = new ArrayList<Integer>();
		 				 aux.addAll(map1.get(i).getValor());								
		 				 aux.addAll(map2.get(j).getValor());
		 				 map2.remove(j);
		 				 Pair valor = new Pair(tmp,aux);
		 				 mapFinal.add(valor);
		 				encontrado=true;
		 				
		 			 }			 
		 		 }if(!encontrado) {
		 			 mapFinal.add(map1.get(i));
		 		 }
 
		 	  }
		    
		    for(int i=0;i<map2.size();i++) {
		    	 	
		    	mapFinal.add(map2.get(i));
		    }
		 
		 
		return mapFinal;
		  
	  }


	/**
	* Funcion encarga agrupar todas aquellas palabras repetidas en una sola
	*/
	 public Vector<Pair> reduce(Vector<Pair> map){
			for(int i=0; i<map.size();i++) {
	  			
	  			List<Integer> aux = new ArrayList<Integer>();
	  			aux.add(map.get(i).getValor().size());
	  			Pair aux2= new Pair(map.get(i).getPalabra(),aux);
	  			map.set(i, aux2);
	
	  		}
			
			return map;
	 }
}