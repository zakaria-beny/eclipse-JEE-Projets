package metier;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.Employer;
import dao.IDao;

//@Component
@Service
public class MetierImpl implements IMetier {

	private IDao dao;
	
	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}


	@Override
	public Employer affchierEmp(int id) {
		Employer e = dao.getEmploer(id);
		
		Period p = Period.between(e.getDate_debut().toLocalDate(), LocalDate.now());
		double prime = (p.getYears() * e.getSalaire()) + 500.00;
		
		e.setSalaire(prime);
		
		return e;
			
	}

}
