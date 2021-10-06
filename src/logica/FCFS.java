package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;

public class FCFS {
	
	public FCFS(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
		generarTabla();
	}
	
	private Proceso proceso;
	private DefaultTableModel modeloTabla;
	private ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	
	public void avanzar() {
		
		int tiempo = 0;
		
		while(!terminado()) {
			if(tiempo == 0) {
				listaProcesos.get(0).setEstado(1);
			}
			for (int i = 0; i < listaProcesos.size(); i++) {
				//Hacer si el estado es 0 (sin iniciar)
				if(listaProcesos.get(1).getEstado()==0) {
					
				 //Hacer si el estado es 1 (Ejecucion)	
				}else if(listaProcesos.get(1).getEstado()==1) {
				
				 //Hacer si el estado es 2 (Espera)	
				}else if(listaProcesos.get(1).getEstado()==2) {
					
				 //Hacer si el estado es 3 (interrupcion)	
				}else if(listaProcesos.get(1).getEstado()==3) {
					
				 //Hacer si el estado es 4 (finalizado)
				}else if(listaProcesos.get(1).getEstado()==4)
				
			}
		}
	}
	
	/**
	 * Con base en el modelo de tabla recibido se genera una tabla de procesos
	 */
	public void generarTabla() {
		
		for(int i = 0; i < modeloTabla.getRowCount(); i++){
			proceso = new Proceso();
			proceso.setNombre(modeloTabla.getValueAt(i, 0).toString());
			proceso.setLlegada(Integer.parseInt(modeloTabla.getValueAt(i, 1).toString()));
			proceso.settEjecucion(Integer.parseInt(modeloTabla.getValueAt(i, 2).toString()));			
			proceso.setInicioB(Integer.parseInt(modeloTabla.getValueAt(i, 3).toString()));
			proceso.setDuracionB(Integer.parseInt(modeloTabla.getValueAt(i, 4).toString()));
			proceso.setRestante(Integer.parseInt(modeloTabla.getValueAt(i, 4).toString()));
			listaProcesos.add(proceso);
		}
		//Ordena la lista por tiempo de llegada usando Collections y Comparator
		Collections.sort(listaProcesos, new Comparator<Proceso>() {
			public int compare(Proceso p1, Proceso p2) {
				return Integer.valueOf(p1.getLlegada()).compareTo(Integer.valueOf(p2.getLlegada()));
			}
		});
		
		//imprimirArr();
	}
	
	/**
	 * Verifica el ArrayList para ver si algun proceso tiene tiempo restante 
	 * por ejecutar
	 * @return falso: Faltan procesos por terminar, 
	 * true: todos los procesos terminados
	 */
	public boolean terminado(){

		int sumaRestantes = 0;
		for(int i = 0; i < modeloTabla.getRowCount(); i++){
			sumaRestantes = listaProcesos.get(i).getRestante();
		}
		if(sumaRestantes == 0)
			return true;
		else
			return true;
	}
	
	public void imprimirArr() {
		for (int i = 0; i < listaProcesos.size(); i++) {
		     System.out.print(listaProcesos.get(i).getNombre() + " | ");
		     System.out.print(listaProcesos.get(i).getLlegada() + " | ");
		     System.out.print(listaProcesos.get(i).gettEjecucion() + " | ");
		     System.out.print(listaProcesos.get(i).getInicioB() + " | ");
		     System.out.print(listaProcesos.get(i).getDuracionB() + " | ");
		     System.out.println();
		 }
		listaProcesos.get(0).setEstado(1);
	}
	
	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}
}
