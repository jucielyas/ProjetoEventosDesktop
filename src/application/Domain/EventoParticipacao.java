package application.Domain;

public class EventoParticipacao extends Base {
	private int idEvento;
	private int idUsuario;
	private boolean participacaoCancelada;
	
	public void SetidEvento(int idEvento) {
	    this.idEvento = idEvento;
	  }
	public void SetidUsuario(int idUsuario) {
	    this.idUsuario = idUsuario;
	  }
	public void SetparticipacaoCancelada(boolean participacaoCancelada) {
	    this.participacaoCancelada = participacaoCancelada;
	  }
	
	
	public int GetidEvento() {
	    return this.idEvento;  
	  }
	public int GetidUsuario() {
	    return this.idUsuario;  
	  }
	public boolean GetparticipacaoCancelada() {
	    return this.participacaoCancelada;  
	  }
	
	
}

