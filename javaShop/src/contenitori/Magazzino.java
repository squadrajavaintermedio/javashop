package contenitori;

import java.util.ArrayList;

import articoli.Articolo;
import dao.DaoUser;
import dao.IDBNegozio;

public class Magazzino extends DaoUser implements IMagazzino{

	public Magazzino(IDBNegozio dao) {
		super(dao);
	}
	
	public int scorte(String tipo){
		int ris = 0;
		
		ArrayList<Articolo> lista = this.dao.articoli(tipo);
		
		for(int i = 0; i < lista.size(); i++){
			ris += lista.get(i).getQuantita();
		}
		
		return ris;
	}

	@Override
	public double budget(String tipo) {

		double budget = 0.0;
		ArrayList<Articolo> lista = this.dao.articoli(tipo);
		
		for(int i = 0; i < lista.size(); i++){
			budget += (lista.get(i).getQuantita() * lista.get(i).getPrezzo());
		}
		
		
		return budget;
	}

}