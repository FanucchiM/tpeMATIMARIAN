package tpeMATIMARIAN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            String archivo = "config.txt";
            int objetivo = 0;
            List<Maquina> maquinas = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                objetivo = Integer.parseInt(br.readLine().trim());
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(nombre, piezas));
                }
            } catch (IOException e) {
                System.out.println("Error leyendo archivo: " + e.getMessage());
                return;
            }



        // Ejecutamos el backtracking
            System.out.println("Solucion Backtracking");
            Backtracking bt = new Backtracking();
            Backtracking.Resultado resultado = bt.backtrackingOptimo(objetivo, maquinas);

            // Imprimimos los resultados
            System.out.println("Cantidad de maquinas utilizadas: " + resultado.secuencia.size());
            for (int i = 0; i < resultado.secuencia.size(); i++) {
                System.out.print("["+resultado.secuencia.get(i).getNombre() + " piezas: " + resultado.secuencia.get(i).getPiezas() +"]" );
            }
            System.out.println();

            System.out.println("Cantidad de estados generados: " + resultado.llamadas);


        System.out.println();
        System.out.println("Solucion Greedy");
        Greedy.GreedyMethod(objetivo, maquinas);


    }
    }
