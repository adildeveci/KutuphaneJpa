package Login;

import java.util.List;

import javax.persistence.EntityManager;
 
import com.mergeCons.egitim.util.EntityUtil;

public class KitapBean {
	private Boolean oturumAcik=true;//test
	private String Aranan="";
	public Boolean getOturumAcik() {
		return oturumAcik;
	}

	public void setOturumAcik(Boolean oturumAcik) {
		this.oturumAcik = oturumAcik;
	}

	public KitapBean(){
		 
	}
	private Kitap kitap= new Kitap();

	public Kitap getKitap() {
		return kitap;
	}

	public void setKitap(Kitap kitap) {
		this.kitap = kitap;
	}

	public void kaydet()
	{
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(kitap);
		em.getTransaction().commit();
		kitap = new Kitap();
	}
	
	public void yeni() { 
		kitap = new Kitap();
	}
	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(kitap);
		em.getTransaction().commit();
		kitap = new Kitap();
	}
	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(kitap);
		em.getTransaction().commit();
		kitap = new Kitap();
	}
	public List<Kitap> getKitapListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		//em.createQuery("FROM Kullanici Where Ad = :kullaniciAd AND sifre = :sifre").setParameter("kullaniciAd", kullaniciAd).setParameter("sifre", sifre).getResultList();
		return em.createQuery("from Kitap Where Kitapadi like :Kitapadi or Raf like :Raf or Yazari like :Yazari or Yayinevi like :Yayinevi or Turu like :Turu").setParameter("Kitapadi","%"+ Aranan+"%").setParameter("Raf", Aranan+"%").setParameter("Yazari","%"+ Aranan+"%").setParameter("Yayinevi", Aranan+"%").setParameter("Turu", Aranan+"%").getResultList();
	}

	
	
	public String getAranan() {
		return Aranan;
	}

	public void setAranan(String aranan) {
		Aranan = aranan;
	}
	
	
}
