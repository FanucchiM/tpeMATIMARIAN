package tpeMATIMARIAN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backtracking {
	
	
	public static class Resultado {
	    List<Maquina> secuencia = new ArrayList<>();
	    int llamadas = 0;
	}
	
	public Resultado backtrackingOptimo(int objetivo, List<Maquina> maq) {
		//El arbol de exploracion empezara vacio, y empezara a recorrer las Maquinas una por una, siempre y cuando la suma para llegar
		// al objetivo sea menor, si es asi, lo agrego al array de posible solucion y sigo con los futuros candidatos.
		//Un estado no final y que no solucion seria un array de maquinas, y que el ultimo elemento que se quiere agregar se pasa del objetivo
		// y el backtracking sigue con otra Maquina. Si llegamos a la cantidad de piezas buscadas, luego se pregunta si la cantidad de maquinas es la mejor,
		//Si es asi, se remplaza del array "mejorSolucion" por la de "solucionActual".
		Resultado resultado = new Resultado();
	    backtracking(0,objetivo, maq, new ArrayList<>(), 0, resultado);
	    return resultado;
	}

	public static void backtracking(int indice, int objetivo, List<Maquina> maquinas, List<Maquina> actual, int sumaActual, Resultado resultado) {

		resultado.llamadas++;

		//Estado final solucion
	    if (sumaActual == objetivo) {
			//Preguntamos si es la mas optima
			if (resultado.secuencia.isEmpty() || actual.size() < resultado.secuencia.size()) {
				resultado.secuencia.clear();
				resultado.secuencia.addAll(actual);
			}
			//Si caemos en el else, es porque el estado todavia no es final
	    } else {
		    for(int i = indice; i < maquinas.size(); i++) {
				//si el candidato + la sumActual es menor a la cantidad de piezas objetivo, lo agregamos al array, si no podamos.
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
