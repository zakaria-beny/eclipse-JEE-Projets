package dao;

import java.util.List;

public interface IDao {
	public void addClient(Client c);
	public void updateClient(Client c);
	public void deleteClient(int id);
	public Client getClientById(int id);
	public List<Client> getAllClients();
	public List<Client> serchClientByName(String nom);
}
