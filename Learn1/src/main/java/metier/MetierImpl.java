package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.Client;
import dao.IDao;
@Component
public class MetierImpl implements IMetier {
	
	private IDao dao;
	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public void ajouter(Client c) {
		dao.addClient(c);
	}
	@Override
	public Client afficherParId(int id) {
	    return dao.getClientById(id);
	}


	@Override
	public void modifier(Client c) {
		dao.updateClient(c);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteClient(id);
	}

	@Override
	public List<Client> affichierTout() {
		return dao.getAllClients();
	}

	@Override
	public List<Client> affichierParNom(String nom) {
		return dao.serchClientByName(nom);
	}

}
