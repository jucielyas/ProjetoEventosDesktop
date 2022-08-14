package application.Core;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application.DataIntegration.TxtService;
import application.Domain.Evento;

public class EventoHandler {
	private TxtService txtService;
	private String entidade = "Events.data.txt";
	private Gson objJson = new Gson();
	
	public EventoHandler() {
		txtService = new TxtService(entidade);
	}
	public boolean Create(List<Evento> lista) throws IOException {
		
		String json = objJson.toJson(lista);
		boolean salvou = txtService.GravarArquivo(json);
		
		return salvou;
	}
	
	public List<Evento> GetList() throws IOException {	
		
		String json = txtService.ObterLeituraArquivo();
		
		Type listType = new TypeToken<ArrayList<Evento>>(){}.getType();
		List<Evento> lista = new Gson().fromJson(json, listType);
		
		if(lista == null)
			lista = new ArrayList<Evento>();
		
		return lista;
	}
	
	
	public int ObterNovoId() throws IOException {
		List<Evento> eventos = GetList();
		
		if(eventos == null)
			return 1;
		return (int)eventos.stream().count() + 1;
	}
}
