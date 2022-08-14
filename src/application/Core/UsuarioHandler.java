package application.Core;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application.DataIntegration.TxtService;
import application.Domain.Categoria;
import application.Domain.Usuario;

public class UsuarioHandler {
	private TxtService txtService;
	private Gson objJson = new Gson();
	private String entidade = "Usuarios.data.txt";
	
	public UsuarioHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Usuario> usuario) throws IOException {
		
		String jsonUsuario = objJson.toJson(usuario);
		boolean salvou = txtService.GravarArquivo(jsonUsuario);
		
		return salvou;
	}
	
	public List<Usuario> GetList() throws IOException {	
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
		List<Usuario> lista = new Gson().fromJson(json, listType);
		
		if(lista == null)
			lista = new ArrayList<Usuario>();
		
		return lista;
	}
	
	public int ObterNovoId() throws IOException {
		List<Usuario> lista = GetList();
		
		if(lista == null)
			return 1;
		return (int)lista.stream().count() + 1;
	}
}
