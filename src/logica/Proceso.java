package logica;

public class Proceso {
	
	public Proceso() {
	}
	
	public Proceso(int PID, String nombre, int tEjecucion) {
		this.PID = PID;
		this.nombre = nombre;
		this.tEjecucion = tEjecucion;
	}

	private int PID = -1;			//ID del proceso
	private String nombre = "";		//Nombre del proceso
	private int tEjecucion = 0;		//Tiempo que necesita el proceso para ejecutarse
	private int llegada = -1;		//Tiempo en el que llega a la cola
	private int inicioB = 0;		//Tiempo de inicio de interrupcion
	private int duracionB = 0;		//Duracion de la interrupcion
	private int restante = 0;		//Tiempo que le queda al proceso para finalizar
	private int espera = 0;			//Tiempo que el proceso estubo en espera, no incluye tBloqueo
	private int bloqueo = 0;		//Tiempo que el proceso estubo en bloqueo
	private int iFinal = 0;			//Instante en el que el proceso finalizo
	private int tRetorno = 0;		//Tiempo total que duro el proceso en la cola
	private int tPerdido = 0;		//tRetorno - tEjecucion
	private int penalidad = -1;		//tRetorno/tEjecucion
	private int tRespuesta = -1;	//Tiempo desde que el proceso llego a la cola hasta ser atendido
	private int estado = -1;		//Almacena el estado del proceso
	
	// Getter y setter
	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int gettEjecucion() {
		return tEjecucion;
	}

	public void settEjecucion(int tEjecucion) {
		this.tEjecucion = tEjecucion;
	}

	public int getLlegada() {
		return llegada;
	}

	public void setLlegada(int llegada) {
		this.llegada = llegada;
	}

	public int getInicioB() {
		return inicioB;
	}

	public void setInicioB(int inicioB) {
		this.inicioB = inicioB;
	}

	public int getDuracionB() {
		return duracionB;
	}

	public void setDuracionB(int duracionB) {
		this.duracionB = duracionB;
	}

	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		this.espera = espera;
	}

	public int getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(int bloqueo) {
		this.bloqueo = bloqueo;
	}

	public int getiFinal() {
		return iFinal;
	}

	public void setiFinal(int iFinal) {
		this.iFinal = iFinal;
	}

	public int gettRetorno() {
		return tRetorno;
	}

	public void settRetorno(int tRetorno) {
		this.tRetorno = tRetorno;
	}

	public int gettPerdido() {
		return tPerdido;
	}

	public void settPerdido(int tPerdido) {
		this.tPerdido = tPerdido;
	}

	public int getPenalidad() {
		return penalidad;
	}

	public void setPenalidad(int penalidad) {
		this.penalidad = penalidad;
	}

	public int gettRespuesta() {
		return tRespuesta;
	}

	public void settRespuesta(int tRespuesta) {
		this.tRespuesta = tRespuesta;
	}

	public int getRestante() {
		return restante;
	}

	public void setRestante(int restante) {
		this.restante = restante;
	}

	/**
	 * 0-Sin iniciar | 1-Ejecucion |
	 * 2-Espera | 3-Interrupcion |
	 * 4-Finalizado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * 0-Sin iniciar | 1-Ejecucion |
	 * 2-Espera | 3-Interrupcion |
	 * 4-Finalizado
	 * @param estado 
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
