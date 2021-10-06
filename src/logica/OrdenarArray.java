package logica;

import java.util.ArrayList;

public class OrdenarArray {
	
	OrdenarArray(ArrayList<Proceso> listaProcesos){
		this.listaProcesos = listaProcesos;
	}
	
	public void ordenar() {
		int menor = 0;
		int actual = 0;
		int pos = 0;
		actual = listaProcesos.get(0).getLlegada();
		while(actual < listaProcesos.size()) {
			for (int i = actual; i < listaProcesos.size(); i++) {
				if(listaProcesos.get(i).getLlegada() <= menor) {
					actual = listaProcesos.get(i).getLlegada();
					pos = i;
				}
			}
			listaProcesos.set(actual, listaProcesos.get(pos));
			listaProcesos.remove(pos+1);
			actual++; 
		}
	}

	private ArrayList<Proceso> listaProcesos;

	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}
	
}
