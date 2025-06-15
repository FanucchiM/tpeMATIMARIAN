package tpeMATIMARIAN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backtracking {
	
	
	public static class Resultado {
	    List<Maquina> secuencia = new ArrayList<>();
	    int llamadas = 0;
	}
	
	public Resultado backtrackingOptimo(int objetivo, List<Maquina> maq) {
		Collections.sort(maq);
		Resultado resultado = new Resultado();
	    backtracking(0,objetivo, maq, new ArrayList<>(), 0, resultado);
	    return resultado;
	}

	public static void backtracking(int indice, int objetivo, List<Maquina> maquinas, List<Maquina> actual, int sumaActual, Resultado resultado) {


	    if (sumaActual == objetivo) {
			if (resultado.secuencia.isEmpty() || actual.size() < resultado.secuencia.size()) {
				resultado.secuencia.clear();
				resultado.secuencia.addAll(actual);
			}
	    	//resultado.secuencia = new ArrayList<>(actual);
	    } else {
		    for(int i = indice; i < maquinas.size(); i++) {
			    if((sumaActual + maquinas.get(i).getPiezas()) <= objetivo) {
			    	actual.add(maquinas.get(i));
			    	sumaActual = sumaActual + maquinas.get(i).getPiezas();
					backtracking(indice, objetivo, maquinas, actual, sumaActual, resultado);
					actual.remove(actual.size() - 1);
					sumaActual= sumaActual - maquinas.get(i).getPiezas();
			    }
		    }
	    }


	    
	   
	}
}
