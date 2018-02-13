package hopital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hopital.model.Patient;

@Repository
@Transactional
public class PatientDaoJpa implements PatientDao {

	// @Autowired
	// // @Qualifier("entityManagerFactory") Pas nécessaire dans ce cas
	// private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public Patient find(Long id) {
		return em.find(Patient.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Patient> findAll() {
		Query query = em.createQuery("from Patient");
		return query.getResultList();
	}

	@Override
	public void create(Patient obj) {
		em.persist(obj);
	}

	@Override
	public Patient update(Patient obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Patient obj) {
		em.remove(obj);
	}

}
