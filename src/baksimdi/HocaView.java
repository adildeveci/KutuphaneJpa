package baksimdi;

import java.util.List;

import javax.persistence.EntityManager;

import com.mergeCons.egitim.util.EntityUtil;

public class HocaView {
	private Hoca hoca = new Hoca();

	public void kaydet() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(hoca);
		em.getTransaction().commit();
		hoca = new Hoca();
	}

	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(hoca);
		em.getTransaction().commit();
		hoca = new Hoca();
	}

	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(hoca);
		em.getTransaction().commit();
		hoca = new Hoca();
	}

	public List<Hoca> getHocaListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Hoca").getResultList();
	}

	public Hoca getHoca() {
		return hoca;
	}

	public void setHoca(Hoca hoca) {
		this.hoca = hoca;
	}
}
