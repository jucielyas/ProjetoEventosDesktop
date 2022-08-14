package application.Core;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application.DataIntegration.TxtService;
import application.Domain.Categoria;
import application.Domain.Evento;

public class CategoriaHandler {
	public TxtService txtService;
	private String entidade = "Categorias.data.txt";
	private Gson objJson = new Gson();
	
	public CategoriaHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Categoria> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Categoria> GetList() throws IOException {
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Categoria>>(){}.getType();
		List<Categoria> lista = new Gson().fromJson(json, listType);
		
		if(lista == null)
			lista = new ArrayList<Categoria>();
		
		return lista;
	}
	
	public int ObterNovoId() throws IOException {
		List<Categoria> lista = GetList();
		
		if(lista == null)
			return 1;
		return (int)lista.stream().count() + 1;
	}
}
