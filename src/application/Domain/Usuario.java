package application.Domain;

public class Usuario extends Base{
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	public void SetNome(String nome) {
	    this.nome = nome;
	  }
	
	public void SetSobrenome(String  sobrenome) {
	    this.sobrenome = sobrenome;	  
	  }
	
	public String GetNome() {
	    return this.nome;
	  }
	
	public String GetSobrenome() {
	    return this.sobrenome;  
	  }
	
	public void SetEmail(String email) {
	    this.email = email;
	  }
	
	public void SetSenha(String senha) {
	    this.senha = senha;	  
	  }
	
	public String GetEmail() {
	    return this.email;
	  }
	
	public String GetSenha() {
	    return this.senha;  
	  }
}
