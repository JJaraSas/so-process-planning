package logica;

public class ProcesosDisponibles {
	
	public ProcesosDisponibles() {
		cargarProcesos();
	}
	
	private Proceso disponibles[] = new Proceso[8];

	/**
	 * Crea la lista de procesos diponibles para las pruebas
	 */
	private void cargarProcesos() {
		disponibles[0] = new Proceso(1, "VLC", 10);
		disponibles[1] = new Proceso(2, "Chrome", 9);
		disponibles[2] = new Proceso(3, "Word", 8);
		disponibles[3] = new Proceso(4, "Excel", 7);
		disponibles[4] = new Proceso(5, "Eclipse", 6);
		disponibles[5] = new Proceso(6, "Spider", 5);
		disponibles[6] = new Proceso(7, "PDFRead", 4);
		disponibles[7] = new Proceso(8, "Block", 3);
	}
	
	public Proceso[] getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Proceso[] disponibles) {
		this.disponibles = disponibles;
	}

}
