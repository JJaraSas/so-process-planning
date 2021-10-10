package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;

public class FCFS {
	
	public FCFS(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
		generarTabla();
		avanzar();
	}
	
	private Proceso proceso;
	private DefaultTableModel modeloTabla;
	private ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	private ArrayList<int[]> dibujo = new ArrayList<int[]>();
	private int estadosDibujo[];
	
	/**
	 * Evalua cada proceso iniciando por el primero dado el algoritmo
	 * atiende siempre al primero que llega y luego evalua los demas
	 */
	public void avanzar() {
		boolean yaPaso = false;
		int tiempo = 0;
		boolean CPUlibre = true;
		
		while(!terminado()) {
			
			if(tiempo == 0) {
				//Mover el tiempo hasta el tiempo de llegada del primer proceso
				System.out.println("LLegada:" + listaProcesos.get(0).getLlegada());
				while(tiempo < listaProcesos.get(0).getLlegada()) {
					estadosDibujo = new int[listaProcesos.size()];
					tiempo++;
					//Se añaden estado 0 a la lista de dibujo hasta la llegada del primer proceso 
					for(int i=0;i<estadosDibujo.length;i++) {
						estadosDibujo[i] = 0;
					}
					dibujo.add(estadosDibujo);
				}
				listaProcesos.get(0).setEstado(1);
				CPUlibre = false;
			}
			estadosDibujo = new int[listaProcesos.size()];
			for (int i = 0; i < listaProcesos.size(); i++) {
				
				//Hacer si el estado es 0 (sin iniciar)
				if(listaProcesos.get(i).getEstado() == 0) {
					estadosDibujo[i] = 0;
					if(listaProcesos.get(i).getLlegada() == tiempo+1) {
						if(CPUlibre == true) {
							listaProcesos.get(i).setEstado(1);
							CPUlibre = false;
						}else
							listaProcesos.get(i).setEstado(2);
					}
				}
				
				//Hacer si el estado es 1 (Ejecucion)
				else if(listaProcesos.get(i).getEstado() == 1) {
					estadosDibujo[i] = 1;
					listaProcesos.get(i).setRestante(listaProcesos.get(i).getRestante()-1);
					if(listaProcesos.get(i).getRestante() == 0) {
						listaProcesos.get(i).setEstado(4);
						CPUlibre = true;
						yaPaso = true;
					}
					//Verifica si el tiempo ejecutado es igual al tiempo de inicio de interrupcion
					if(listaProcesos.get(i).getInicioB() != 0 &
					   (listaProcesos.get(i).getInicioB() == 
					   		(listaProcesos.get(i).gettEjecucion()-listaProcesos.get(i).getRestante()))
					   ) {
						listaProcesos.get(i).setEstado(3);
						CPUlibre = true;
					}
					
					if(yaPaso == true)
						i--;
				 
				}
				//Hacer si el estado es 2 (Espera)	
				else if(listaProcesos.get(i).getEstado()==2) {
					estadosDibujo[i] = 2;
					listaProcesos.get(i).setEspera(listaProcesos.get(i).getEspera()+1);
					if(CPUlibre == true) {
						listaProcesos.get(i).setEstado(1);
						CPUlibre = false;
					}else {
						estadosDibujo[i] = 2;
					}
					
				}
				//Hacer si el estado es 3 (interrupcion/bloqueo)	
				else if(listaProcesos.get(i).getEstado()==3) {
					estadosDibujo[i] = 3;
					listaProcesos.get(i).setBloqueo(listaProcesos.get(i).getBloqueo()+1);
					if(listaProcesos.get(i).getBloqueo() == listaProcesos.get(i).getDuracionB()) {
						if(CPUlibre == true)
							listaProcesos.get(i).setEstado(1);
						else
							listaProcesos.get(i).setEstado(2);
					}
				}
				//Hacer si el estado es 4 (finalizado)
				else if(listaProcesos.get(i).getEstado()==4) {
					if(!yaPaso)
						estadosDibujo[i] = 4;
					else
						yaPaso = false;
					
				}
				
			}
			dibujo.add(estadosDibujo);
			tiempo++;
		}
		//imprimirEstDibujo();
	}
	

	
	/**
	 * Con base en el modelo de tabla recibido se genera una tabla de procesos
	 * y se ordenan por el tiempo de llegada (FIFO)
	 */
	public void generarTabla() {
		
		for(int i = 0; i < modeloTabla.getRowCount(); i++){
			proceso = new Proceso();
			proceso.setNombre(modeloTabla.getValueAt(i, 0).toString());
			proceso.setLlegada(Integer.parseInt(modeloTabla.getValueAt(i, 1).toString()));
			proceso.settEjecucion(Integer.parseInt(modeloTabla.getValueAt(i, 2).toString()));			
			proceso.setInicioB(Integer.parseInt(modeloTabla.getValueAt(i, 3).toString()));
			proceso.setDuracionB(Integer.parseInt(modeloTabla.getValueAt(i, 4).toString()));
			proceso.setRestante(Integer.parseInt(modeloTabla.getValueAt(i, 2).toString()));
			proceso.setEstado(0);
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
			sumaRestantes = sumaRestantes + listaProcesos.get(i).getRestante();
		}
		if(sumaRestantes == 0)
			return true;
		else
			return false;
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
	
	public void imprimirEstDibujo() {
		System.out.println(" *** INICIO *** " );
		for(int i=0; i < dibujo.size(); i++) {
			for(int j=0; j < estadosDibujo.length; j++) {
				System.out.print(" | " + dibujo.get(i)[j] + " | " );
			}
			System.out.println();
		}
		System.out.println(" *** FIN *** " );
	}
	
	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public ArrayList<int[]> getDibujo() {
		return dibujo;
	}

	public void setDibujo(ArrayList<int[]> dibujo) {
		this.dibujo = dibujo;
	}

	public int[] getEstadosDibujo() {
		return estadosDibujo;
	}

	public void setEstadosDibujo(int[] estadosDibujo) {
		this.estadosDibujo = estadosDibujo;
	}
	
}
