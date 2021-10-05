package logica;

import java.awt.Color;

public class ProcesosDisponibles {
	
	public ProcesosDisponibles() {
		cargarProcesos();
	}
	
	private Proceso disponibles[] = new Proceso[8];

	/**
	 * Crea la lista de procesos diponibles para las pruebas
	 */
	private void cargarProcesos() {
		disponibles[0] = new Proceso(1, "VLC", 10, new Color(244, 176, 132));
		disponibles[1] = new Proceso(2, "Chrome", 9, new Color(255, 217, 102));
		disponibles[2] = new Proceso(3, "Word", 8, new Color(155, 194, 230));
		disponibles[3] = new Proceso(4, "Excel", 7, new Color(169, 208, 142));
		disponibles[4] = new Proceso(5, "Eclipse", 6, new Color(153, 153, 255));
		disponibles[5] = new Proceso(6, "Spider", 5, new Color(113, 255, 196));
		disponibles[6] = new Proceso(7, "PDFRead", 4, new Color(255, 143, 146));
		disponibles[7] = new Proceso(8, "Block", 3, new Color(192, 192, 192));

		
		//Carga colores segmentos de codigo, datos y pila de cada programa (Para segmentacion)
		disponibles[0].getSegCodigo()[2] = new Color(244, 176, 132);
		disponibles[0].getSegDatos()[2] = new Color(248, 203, 173);
		disponibles[0].getSegPila()[2] = new Color(252, 228, 214);

		disponibles[1].getSegCodigo()[2] = new Color(255, 217, 102);
		disponibles[1].getSegDatos()[2] = new Color(255, 230, 153);
		disponibles[1].getSegPila()[2] = new Color(255, 242, 204);
		
		disponibles[2].getSegCodigo()[2] = new Color(155, 194, 230);
		disponibles[2].getSegDatos()[2] = new Color(189, 215, 238);
		disponibles[2].getSegPila()[2] = new Color(221, 235, 247);
		
		disponibles[3].getSegCodigo()[2] = new Color(169, 208, 142);
		disponibles[3].getSegDatos()[2] = new Color(198, 224, 180);
		disponibles[3].getSegPila()[2] = new Color(226, 239, 218);
		
		disponibles[4].getSegCodigo()[2] = new Color(153, 153, 255);
		disponibles[4].getSegDatos()[2] = new Color(171, 171, 255);
		disponibles[4].getSegPila()[2] = new Color(193, 193, 255);
		
		disponibles[5].getSegCodigo()[2] = new Color(113, 225, 196);
		disponibles[5].getSegDatos()[2] = new Color(144, 232, 209);
		disponibles[5].getSegPila()[2] = new Color(179, 239, 223);
		
		disponibles[6].getSegCodigo()[2] = new Color(255, 143, 146);
		disponibles[6].getSegDatos()[2] = new Color(255, 175, 177);
		disponibles[6].getSegPila()[2] = new Color(255, 197, 198);
		
		disponibles[7].getSegCodigo()[2] = new Color(192, 192, 192);
		disponibles[7].getSegDatos()[2] = new Color(207, 207, 207);
		disponibles[7].getSegPila()[2] = new Color(224, 224, 224);
		
	}
	
	public Proceso[] getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Proceso[] disponibles) {
		this.disponibles = disponibles;
	}

}
