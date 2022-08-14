package application.Domain;

import java.util.Date;

public class Evento  extends Base  {
	private int idCategoria;
	private String endereco;
	private String nome;
	private Date  data;
	private String descricao;
	
	
	public void SetIdCategoria(int idCategoria) {
	    this.idCategoria = idCategoria;
	  }
	
	public void SetEndereco(String endereco) {
	    this.endereco = endereco;	  
	  }
	public void SetNome(String nome) {
	    this.nome = nome;
	  }
	
	public void SetData(Date data) {
	    this.data = data;	  
	  }
	public void SetDescricao(String descricao) {
	    this.descricao = descricao;
	  }
	
	
	
	public int GetIdCategoria() {
	    return this.idCategoria;
	  }
	
	public String GetEndereco() {
	    return this.endereco;  
	  }
	public String GetNome() {
	    return this.nome;
	  }
	
	public Date GetData() {
	    return this.data;  
	  }
	
	public String GetDescricao() {
	    return this.descricao;
	  }

}

