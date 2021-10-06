package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;

import logica.Proceso;

@SuppressWarnings("serial")
public class PanelDibujoProc extends JPanel{
	
	public PanelDibujoProc(int tiempo, ArrayList<Proceso> listaProcesos) {
		this.tiempo = tiempo;
		this.listaProcesos = listaProcesos;
	}
	
	private int tiempo = 0;
	private ArrayList<Proceso> listaProcesos;
	
	
	
	private Color verde = new Color(86, 186, 7);
	private Color amarillo = new Color(215, 215, 84);
	private Color negro = new Color(0, 0, 0);
	
	/**
	 * Pintar el recuadro de procesos en memoria
	 */
    public void paint(Graphics g) {

    	
    	/*
    	//Modelo Particiones Estaticas Fijas
    	if(modelo == 1) {
        	
        	int pos = 0; 	//Llava la posicion de donde se va a dibujar
        	g.setFont(new Font("Tahoma", Font.BOLD, 7));		//Tamaño del texto en el dibujo
        	
        	//Calculando tamaño del S.O. para ser dibujada
        	double tamanoSO = (particionesEstFijas.getSO().getTamano()*100.0)/particionesEstFijas.getMemoriaPpal();
        	int drawSO = (int) (getWidth()*(tamanoSO/100));

        	g.setColor(amarillo);
        	g.fillRect(pos, 0, drawSO, getHeight());
        	g.setColor(negro);
        	g.drawRect(pos, 0, drawSO, getHeight()-1);
        	
        	g.drawString(particionesEstFijas.getParticiones()[0].getProceso().getNombre(), 5, (getHeight()*2)/5);
        	g.drawString("PID=" + particionesEstFijas.getParticiones()[0].getProceso().getPID(), 5, ((getHeight()*4)/5));
        	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
        	
        	pos = pos + drawSO;
        	
        	//Recorrer el arreglo de particiones para ir dibujando cada una
        	for(int i=1; i<particionesEstFijas.getParticiones().length;i++) {
        		
        		int tamDibujo = cacularTamDibujo(i);
        		int tamProceso = 0;
        		
        		g.setColor(verde);
        		
        		//Verificar si hay proceso en la particion, si lo hay calcular el tamaño
        		if(particionesEstFijas.getParticiones()[i].getDisponible() == true)
        			tamProceso = 0;	
        		else
        			tamProceso = cacularTamProceso(i);

            	g.fillRect(pos, 0, tamDibujo, getHeight());	//Pintar particion
            	
            	if (tamProceso != 0) {		//Si la particion tiene proceso pintar proceso
            		g.setColor(particionesEstFijas.getParticiones()[i].getProceso().getColor());
            		g.fillRect(pos, 0, tamProceso, getHeight());
            	}
            	
            	g.setColor(negro);			//Pintar borde
            	g.drawRect(pos, 0, tamDibujo, getHeight()-1);
            	
            	if(particionesEstFijas.getParticiones()[i].getDisponible() == false) {
                	g.drawString(particionesEstFijas.getParticiones()[i].getProceso().getNombre(), pos+5, (getHeight()*2)/5);
                	g.drawString("PID=" + particionesEstFijas.getParticiones()[i].getProceso().getPID(), pos+5, ((getHeight()*4)/5));
                	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
            	}
            	pos = pos + tamDibujo;		//Se suma el area dibujada a la posiscion
        	}
    	}
    	
    	//Modelo Particiones Estaticas Fijas
    	if(modelo == 2) {
        	
        	int pos = 0; 	//Llava la posicion de donde se va a dibujar
        	g.setFont(new Font("Tahoma", Font.BOLD, 7));		//Tamaño del texto en el dibujo
        	
        	//Calculando tamaño del S.O. para ser dibujada
        	double tamanoSO = (particionesEstVariables.getSO().getTamano()*100.0)/particionesEstVariables.getMemoriaPpal();
        	int drawSO = (int) (getWidth()*(tamanoSO/100));

        	g.setColor(amarillo);
        	g.fillRect(pos, 0, drawSO, getHeight());
        	g.setColor(negro);
        	g.drawRect(pos, 0, drawSO, getHeight()-1);
        	
        	g.drawString(particionesEstVariables.getParticiones()[0].getProceso().getNombre(), 5, (getHeight()*2)/5);
        	g.drawString("PID=" + particionesEstVariables.getParticiones()[0].getProceso().getPID(), 5, ((getHeight()*4)/5));
        	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
        	
        	pos = pos + drawSO;
        	
        	//Recorrer el arreglo de particiones para ir dibujando cada una
        	for(int i=1; i<particionesEstVariables.getParticiones().length;i++) {
        		
        		int tamDibujo = cacularTamDibujo(i);
        		int tamProceso = 0;
        		
        		g.setColor(verde);
        		
        		//Verificar si hay proceso en la particion, si lo hay calcular el tamaño
        		if(particionesEstVariables.getParticiones()[i].getDisponible() == true)
        			tamProceso = 0;	
        		else
        			tamProceso = cacularTamProceso(i);

            	g.fillRect(pos, 0, tamDibujo, getHeight());	//Pintar particion
            	
            	if (tamProceso != 0) {		//Si la particion tiene proceso pintar proceso
            		g.setColor(particionesEstVariables.getParticiones()[i].getProceso().getColor());
            		g.fillRect(pos, 0, tamProceso, getHeight());
            	}
            	
            	g.setColor(negro);			//Pintar borde
            	g.drawRect(pos, 0, tamDibujo, getHeight()-1);
            	
            	if(particionesEstVariables.getParticiones()[i].getDisponible() == false) {
                	g.drawString(particionesEstVariables.getParticiones()[i].getProceso().getNombre(), pos+5, (getHeight()*2)/5);
                	g.drawString("PID=" + particionesEstVariables.getParticiones()[i].getProceso().getPID(), pos+5, ((getHeight()*4)/5));
                	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
            	}
            	pos = pos + tamDibujo;		//Se suma el area dibujada a la posiscion
        	}
    	}
    	
    	//Modelo Particiones Dinamicas
    	if(modelo == 3) {
        	
        	int pos = 0; 	//Llava la posicion de donde se va a dibujar
        	g.setFont(new Font("Tahoma", Font.BOLD, 7));		//Tamaño del texto en el dibujo
        	
        	//Calculando tamaño del S.O. para ser dibujada
        	double tamanoSO = (particionesDinamicas.getSO().getTamano()*100.0)/particionesDinamicas.getMemoriaPpal();
        	int drawSO = (int) (getWidth()*(tamanoSO/100));

        	g.setColor(amarillo);
        	g.fillRect(pos, 0, drawSO, getHeight());
        	g.setColor(negro);
        	g.drawRect(pos, 0, drawSO, getHeight()-1);
        	
        	g.drawString(particionesDinamicas.getParticiones()[0].getProceso().getNombre(), 5, (getHeight()*2)/5);
        	g.drawString("PID=" + particionesDinamicas.getParticiones()[0].getProceso().getPID(), 5, ((getHeight()*4)/5));
        	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
        	
        	pos = pos + drawSO;
        	
        	//Recorrer el arreglo de particiones para ir dibujando cada una
        	for(int i=1; i<particionesDinamicas.getParticiones().length;i++) {
        		
        		int tamDibujo = cacularTamDibujo(i);
        		int tamProceso = 0;
        		
        		g.setColor(verde);
        		
        		//Verificar si hay proceso en la particion, si lo hay calcular el tamaño
        		if(particionesDinamicas.getParticiones()[i].getDisponible() == true)
        			tamProceso = 0;	
        		else
        			tamProceso = cacularTamProceso(i);

            	g.fillRect(pos, 0, tamDibujo, getHeight());	//Pintar particion
            	
            	if (tamProceso != 0) {		//Si la particion tiene proceso pintar proceso
            		g.setColor(particionesDinamicas.getParticiones()[i].getProceso().getColor());
            		g.fillRect(pos, 0, tamProceso, getHeight());
            	}
            	
            	g.setColor(negro);			//Pintar borde
            	g.drawRect(pos, 0, tamDibujo, getHeight()-1);
            	
            	if(particionesDinamicas.getParticiones()[i].getDisponible() == false) {
                	g.drawString(particionesDinamicas.getParticiones()[i].getProceso().getNombre(), pos+5, (getHeight()*2)/5);
                	g.drawString("PID=" + particionesDinamicas.getParticiones()[i].getProceso().getPID(), pos+5, ((getHeight()*4)/5));
                	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
            	}
            	pos = pos + tamDibujo;		//Se suma el area dibujada a la posiscion
        	}
    	}
    	
    	//Modelo Paginacion
    	if(modelo == 4) {
        	
        	int pos = 0; 	//Llava la posicion de donde se va a dibujar
        	g.setFont(new Font("Tahoma", Font.BOLD, 7));		//Tamaño del texto en el dibujo
        	
        	//Calculando tamaño del S.O. para ser dibujada
        	double tamanoSO = (paginacion.getSO().getTamano()*100.0)/paginacion.getMemoriaPpal();
        	int drawSO = (int) (getWidth()*(tamanoSO/100));

        	g.setColor(amarillo);
        	g.fillRect(pos, 0, drawSO, getHeight());
        	g.setColor(negro);
        	g.drawRect(pos, 0, drawSO, getHeight()-1);
        	
        	g.drawString(paginacion.getParticiones()[0].getProceso().getNombre(), 5, (getHeight()*2)/5);
        	g.drawString("PID=" + paginacion.getParticiones()[0].getProceso().getPID(), 5, ((getHeight()*4)/5));
        	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
        	
        	pos = pos + drawSO;
        	
        	//Recorrer el arreglo de particiones para ir dibujando cada una
        	for(int i=1; i<paginacion.getParticiones().length;i++) {
        		
        		int tamDibujo = cacularTamDibujo(i);
        		int tamProceso = 0;
  
        		g.setColor(verde);
        		
        		//Verificar si hay proceso en la particion, si lo hay calcular el tamaño
        		if(paginacion.getParticiones()[i].getDisponible() == true)
        			tamProceso = 0;	
        		else
        			tamProceso = cacularTamProceso(i);

            	g.fillRect(pos, 0, tamDibujo, getHeight());	//Pintar particion
            	
            	if (tamProceso != 0) {		//Si la particion tiene proceso pintar proceso
            		g.setColor(paginacion.getParticiones()[i].getProceso().getColor());
            		g.fillRect(pos, 0, tamProceso, getHeight());
            	}
            	
            	g.setColor(negro);			//Pintar borde
            	g.drawRect(pos, 0, tamDibujo, getHeight()-1);
            	
            	if(paginacion.getParticiones()[i].getDisponible() == false) {
                	g.drawString(paginacion.getParticiones()[i].getProceso().getNombre(), pos+5, (getHeight()*2)/5);
                	g.drawString("PID=" + paginacion.getParticiones()[i].getProceso().getPID(), pos+5, ((getHeight()*4)/5));
                	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
            	}
            	pos = pos + tamDibujo;		//Se suma el area dibujada a la posiscion
        	}
    	}
    	
    	//Modelo Segmentacion
    	if(modelo == 5) {
        	
        	int pos = 0; 	//Llava la posicion de donde se va a dibujar
        	g.setFont(new Font("Tahoma", Font.BOLD, 7));		//Tamaño del texto en el dibujo
        	
        	//Calculando tamaño del S.O. para ser dibujada
        	double tamanoSO = (segmentacion.getSO().getTamano()*100.0)/segmentacion.getMemoriaPpal();
        	int drawSO = (int) (getWidth()*(tamanoSO/100));

        	g.setColor(amarillo);
        	g.fillRect(pos, 0, drawSO, getHeight());
        	g.setColor(negro);
        	g.drawRect(pos, 0, drawSO, getHeight()-1);
        	
        	g.drawString(segmentacion.getParticiones()[0].getProceso().getNombre(), 5, (getHeight()*2)/5);
        	g.drawString("PID=" + segmentacion.getParticiones()[0].getProceso().getPID(), 5, ((getHeight()*4)/5));
        	
        	pos = pos + drawSO;
        	
        	//Recorrer el arreglo de particiones para ir dibujando cada una
        	for(int i=1; i<segmentacion.getParticiones().length;i++) {
        		
        		int tamDibujo = cacularTamDibujo(i);
        		int tamProceso = 0;
  
        		g.setColor(verde);
        		
        		//Verificar si hay proceso en la particion, si lo hay calcular el tamaño
        		if(segmentacion.getParticiones()[i].getDisponible() == true)
        			tamProceso = 0;	
        		else
        			tamProceso = cacularTamProceso(i);

            	g.fillRect(pos, 0, tamDibujo, getHeight());	//Pintar particion
            	
            	if (tamProceso != 0) {		//Si la particion tiene proceso pintar proceso segun el segmento
            		if(segmentacion.getParticiones()[i].isCodigo())
            			g.setColor( (Color)segmentacion.getParticiones()[i].getProceso().getSegCodigo()[2]);
            		
            		if(segmentacion.getParticiones()[i].isDatos())
            			g.setColor( (Color)segmentacion.getParticiones()[i].getProceso().getSegDatos()[2]);
            		
            		if(segmentacion.getParticiones()[i].isPila())
            			g.setColor( (Color)segmentacion.getParticiones()[i].getProceso().getSegPila()[2]);
            		
            		g.fillRect(pos, 0, tamProceso, getHeight());
            	}
            	
            	g.setColor(negro);			//Pintar borde
            	g.drawRect(pos, 0, tamDibujo, getHeight()-1);
            	
            	if(segmentacion.getParticiones()[i].getDisponible() == false) {
                	g.drawString(segmentacion.getParticiones()[i].getProceso().getNombre(), pos+5, (getHeight()*2)/5);
                	g.drawString("PID=" + segmentacion.getParticiones()[i].getProceso().getPID(), pos+5, ((getHeight()*4)/5));
                	//g.drawString("T: " + partcionesEstFijas.getParticiones()[0].getTamano() + "KB", 5, (getHeight()*3)/5);
            	}
            	pos = pos + tamDibujo;		//Se suma el area dibujada a la posiscion
        	}
    	}
    	*/
    }
	
}
