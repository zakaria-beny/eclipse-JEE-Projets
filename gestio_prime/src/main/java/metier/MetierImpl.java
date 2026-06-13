package metier;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import DAO.IDAO;
import DAO.User;
import model.ModelUser;

public class MetierImpl implements IMetier{
	private IDAO dao;

	@Override
	public ModelUser calPrime(int id) {
		
		
		try {
		User u = dao.get(id);
		
		Date date = u.getDate_debut();
		long salaire = u.getSalaire();
		
		Period d = Period.between(LocalDate.parse(date.toString()), LocalDate.now());
		
		long prime = salaire + 500*d.getYears();
		
		ModelUser user = new ModelUser();
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setPrime(prime);
		
		return user;
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;

		
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

}
