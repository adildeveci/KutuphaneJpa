package Login;

import javax.persistence.EntityManager;

import java.util.List;

import baksimdi.Hoca;

import com.mergeCons.egitim.util.EntityUtil;

public class UserAdd {
	
	Kullanici kullanici=new Kullanici();
	
	

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public void kaydet() {
		
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(kullanici);
		em.getTransaction().commit();
		kullanici = new Kullanici();
	}
	
	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(kullanici);
		em.getTransaction().commit();
		kullanici = new Kullanici();
	}
	
	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(kullanici);
		em.getTransaction().commit();
		kullanici = new Kullanici();
	}
	public void yeni() { 
		kullanici = new Kullanici();
	}
	public List<Kullanici> getHocaListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from User").getResultList();
	}

}
