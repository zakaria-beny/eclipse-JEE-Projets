package metier;

import java.util.List;

import dao.Client;

public interface IMetier {
	public void ajouter(Client c);
	public void modifier(Client c);
	public void supprimer(int id);
	public Client afficherParId(int id);
	public List<Client> affichierTout();
	public List<Client> affichierParNom(String nom);
}
