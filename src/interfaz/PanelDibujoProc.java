package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import logica.FCFS;

@SuppressWarnings("serial")
public class PanelDibujoProc extends JPanel{
	
	private int algoritmo;
	private DefaultTableModel modeloTabla;
	private ArrayList<int[]> dibujo = new ArrayList<int[]>();
	private FCFS fcfs;
	
	private Color verde = new Color(86, 186, 7);
	private Color rojo = new Color(227, 27, 4);
	private Color gris = new Color(179, 179, 179);
	private Color grisClaro = new Color(200, 200, 200);

	public PanelDibujoProc(int algoritmo, DefaultTableModel modeloTabla) {
		this.algoritmo = algoritmo;
		this.modeloTabla = modeloTabla;
		inciarAlgoritmo();
	}
	
	
	private void inciarAlgoritmo() {
		if(algoritmo == 1) {
			fcfs = new FCFS(modeloTabla);
			dibujo = fcfs.getDibujo();
			imprimirEstDibujo();
			//System.out.println(modeloTabla.getRowCount());
			//System.out.println(dibujo.size());
		}
		
	}


	public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        float distanciado[] = {4};
        BasicStroke punteado= new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f, distanciado, 0.0f);

    	g.setColor (Color.black);
    	//Linea vertical eje
    	g.drawLine (50, 210, 50, 20);
    	//Linea horizontal eje
    	g.drawLine (933, 210, 50, 210);
    	
    	int posX = 1;				//Posicion px en X, varia segun lo que se desee dibujar				
    	int posY = 200;				//Ultimo PX disponible en Y
    	int posY2 = 0;				//Auxiliar para moverse verticalmente
    	int tamDibujoProc = 25;		//Ancho disponible para c/proceso, dibujar 8 procesos en 200px
    	int unidadT = 21;			//PX entre numeracion
    	
    	//Escribir los nombres de procesos   	
    	for(int i = 0; i<modeloTabla.getRowCount(); i++) {
    		//Se toma la posicion en Y final y se va restando para subir el dibujo
			posY2 = posY - ((i+1) * tamDibujoProc);
	    	if(algoritmo == 1) {
	    		g.drawString(fcfs.getListaProcesos().get(i).getNombre(), posX, (posY2+15));
	    	}
    	}
    	
    	//Posicionar y bubujar ejes guias
    	posX = 50;
    	for (int i = 0; i <=42; i++) {
    		if(i != 0) {
        		//Dibujar lineas guia tiempo
        		g2d.setColor (grisClaro);
        		g2d.setStroke(punteado);
        		g2d.drawLine (posX, 20, posX, 206);
    		}
    		//Dibuja las lineas de los numeros
    		g.setColor (Color.black);
    		g.drawLine (posX, 208, posX, 212);
    		//Dibuja los numeros
    		g.drawString(String.valueOf(i), posX-3, 230);
    		posX = posX + unidadT;
    		
    	}
    	
    	//Posicionar y dibujar en base a la matriz de estados (dibujo)
    	posX = 50;
    	posY2 = 0;

    	for(int i=0; i<dibujo.size(); i++) {
    		posY2 = 0;
    		for(int j=0; j<dibujo.get(0).length; j++) {
    			//System.out.println("estado:" + dibujo.get(i)[j]);
    			if(dibujo.get(i)[j] == 1) {
    				g.setColor(verde);
    			}
    			else if(dibujo.get(i)[j] == 2) {
    				g.setColor(gris);
    			}
    			
    			else if(dibujo.get(i)[j] == 3) {
    				g.setColor(rojo);
    			}
    			
    			//Si el estado es sin iniciar o finalizado (1-4) no se dibuja nada
    			if(dibujo.get(i)[j] != 0 & dibujo.get(i)[j] != 4) {
    				//Se toma la posicion en Y final y se va restando para subir el dibujo
    				posY2 = posY - ((j+1) * tamDibujoProc);
    				//Se suma 2 y restan 4 para que no quede pegados los procesos
    				g.fillRect(posX, (posY2 + 2), unidadT, tamDibujoProc - 4);
    				//System.out.println("(i,j) = ("+ i + "," + j + ") Datos: (" + posX + "," + (posY2 + 2) + ","+posX + "," + (tamDibujoProc - 4) + ")");
    			}
    		}
    		posX = posX + unidadT;
    	}
    }
	
	public void imprimirEstDibujo() {
		System.out.println(" *** INICIO *** " );
		for(int i=0; i < dibujo.size(); i++) {
			for(int j=0; j < dibujo.get(0).length; j++) {
				System.out.print(" | " + dibujo.get(i)[j] + " | " );
			}
			System.out.println();
		}
		System.out.println(" *** FIN *** " );
	}
	
}
