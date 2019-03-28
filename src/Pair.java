
import java.util.List;

/**
 * Class Pair:
 * Estructura de datos para
 * guardar los valores Pair<key,value>
 * @key String word palabra
 * @value List<Integer> valor [1,2]
 */

public class Pair {

	private String palabra;
	private List<Integer> valor;
	
	
	public Pair(String word, List<Integer> valor){
		this.palabra=word;
		this.valor=valor;
	}




	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public List<Integer> getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor .add( valor);
	}
	
	
	
	
}
