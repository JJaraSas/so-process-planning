package logica;

public class Proceso {
	
	public Proceso() {
	}
	
	public Proceso(int PID, String nombre, int tEjecucion) {
		this.PID = PID;
		this.nombre = nombre;
		this.tEjecucion = tEjecucion;
	}

	private int PID = -1;
	private String nombre = "";
	private int tEjecucion = 0;
	private int llegada = -1;
	private int inicioB = -1;
	private int duracionB = -1;
	//"restante" almacena el tiempo que le queda al proceso para finalizar 
	private int restante = 0;
	private int espera = -1;
	private int bloqueo = -1;
	private int iFinal = -1;
	private int tRetorno = -1;
	private int tPerdido = -1;
	private int penalidad = -1;
	private int tRespuesta = -1;
	/**
	 * 1=Sin iniciar
	 */
	private int estado = -1;
	
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
	 * 3-Finalizado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * 0-Sin iniciar | 1-Ejecucion |
	 * 2-Espera | 3-Interrupcion |
	 * 3-Finalizado
	 * @param estado 
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
