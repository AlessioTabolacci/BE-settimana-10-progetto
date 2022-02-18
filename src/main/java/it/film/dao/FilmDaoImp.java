package it.film.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCrypt;
import it.film.entity.Film;

public class FilmDaoImp implements FilmDao {

	private	EntityManager em = null;

	public EntityManager getEm() {
		if(em == null) {
			em = EntityManagerHelper.getEntityManager();
		}
		return em;
	}


	/**
	 *
	 * 
	 *  @author Alessio Tabolacci 
	 *  @param Film f 
	 *  @return void
	 */

	public void aggiungiFilm(Film f) {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		getEm().getTransaction().begin();
		getEm().persist(f);
		getEm().getTransaction().commit();



	}

	/**
	 *
	 * 
	 *  @author Alessio Tabolacci 
	 *  @param f = film da salvare
	 *  @return void
	 * @throws Exception 
	 */


	public void aggiornaFilm(Film f) throws Exception {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);

		Film flm = getEm().find(Film.class, f.getId());
		if(flm==null) {
			throw new Exception("Film non trovato");
		}
		getEm().getTransaction().begin();
		getEm().merge(f);
		getEm().getTransaction().commit();

	}

	/**
	 *
	 * 
	 *  @author Alessio Tabolacci
	 *  @param  id = id del film da cancellare  
	 *  @return void
	 */


	public void cancellaFilm(int id) {
		try {
			Film f = trovaById(id);
			getEm().getTransaction().begin();
			getEm().remove(f);


		} catch (Exception e) {
			getEm().getTransaction().rollback();
		}
		finally {
			getEm().getTransaction().commit();

		}
	}

	public Film trovaById(int id) {
		return getEm().find(Film.class, id);

	}


	/**
	 *
	 * 
	 *  @author Alessio Tabolacci
	 *  @param regista = regista del film da ricercare
	 *  @return film del regista ricercato
	 */

	@SuppressWarnings("unchecked")
	public List<Film> trovaByRegista(String regista) {
		return getEm().createNamedQuery("film.trovaperregista").setParameter(1, regista).getResultList();
	}


	/**
	 *
	 * 
	 *  @author Alessio Tabolacci 
	 *  @param 
	 *  @return Lista di film presenti nel database
	 */

	@SuppressWarnings("unchecked")
	public List<Film> trovaTutti() {
		return getEm().createNamedQuery("film.trovatutti").getResultList();
	}

}
