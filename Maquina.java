package tpeMATIMARIAN;

public class Maquina implements Comparable<Maquina> {
	private String nombre;
	private int piezas;
	
	public Maquina(String s, int p) {
		setNombre(s);
		setPiezas(p);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPiezas() {
		return piezas;
	}

	private void setPiezas(int piezas) {
		this.piezas = piezas;
	}

	@Override
	public int compareTo(Maquina o) {
		return o.getPiezas() - this.getPiezas();
 	}

}
