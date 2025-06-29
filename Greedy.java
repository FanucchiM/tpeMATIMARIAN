package tpeMATIMARIAN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {
	
	
	public static void GreedyMethod(int total, List<Maquina> maq) {

		//es void, tiene que devolver lista, si no tiene nada y salio mal lista vacia y sino con los results
		  List<Maquina> secuencia = new ArrayList<>();
		  int resto = total;
		  int candidatosConsiderados = 0;
		  Collections.sort(maq);

		  while(!maq.isEmpty() && resto > 0) {
				  Maquina mejor = mejorCandidato(maq, resto);
				  if(mejor != null) {
					  secuencia.add(mejor);
					  resto = resto - mejor.getPiezas();
				  } else {
					//Si no hay un candidato adecuado devolvemos null
					  System.out.println("No hay una solucion adecuada");
				  }

//Dddd
		  }
	        // Mostrar resultados
	        System.out.println("Cantidad de piezas buscadas: " +total);
			for(Maquina m : secuencia) {
	        	System.out.print("["+m.getNombre() + "-" + m.getPiezas() + " piezas" + "]");
	        }
			System.out.println();
			System.out.println("Cantidad de de candidatos considerados: " + maq.size());
	}

	public static Maquina mejorCandidato(List<Maquina> machine, int objetivo){
		for(int i = 0; i < machine.size(); i++){
			//si la maquina hace mas piezas de las que necesito no la necesito mas
			if(machine.get(i).getPiezas() <= objetivo) {
				return machine.get(i);
			}
		}
		return null;
	}


	/*
	public static void main(String[] args) {
		Maquina m1 = new Maquina("M1", 7);
		Maquina m2 = new Maquina("M2", 8);
		
		List<Maquina> maquinas = new ArrayList<Maquina>();
		maquinas.add(m1);
		maquinas.add(m2);
		
		Greedy.GreedyMethod(14, maquinas);
		
		
	}
	*/

}
