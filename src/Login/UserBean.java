package Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import java.util.ArrayList;
import java.util.List;









import com.mergeCons.egitim.util.EntityUtil;

import javax.persistence.Query; 
import javax.xml.ws.Response;
 
public class UserBean{
	
	/* private static final String PERSISTENCE_UNIT_NAME = "baglanyiKi";
     private static EntityManagerFactory factory;*/
	private  Kullanici oturum; 
	private Kullanici kullanici;
	private String Aranan="";
	private Kitap kitap;
	public Kitap getKitap() {
		return kitap;
	}
	public void setKitap(Kitap kitap) {
		this.kitap = kitap;
	}
	public String getAranan() {
		return Aranan;
	}
	public void setAranan(String aranan) {
		Aranan = aranan;
	}

	private String kullaniciAd;
	private String sifre;
	
	
	
	
 public String login()
{ 
	 	EntityManager em =EntityUtil.getEntityManager(); 
		   List<Kullanici> kullanicilar =em.createQuery("FROM Kullanici Where Ad = :kullaniciAd AND sifre = :sifre").setParameter("kullaniciAd", kullaniciAd).setParameter("sifre", sifre).getResultList();
         if(kullanicilar.isEmpty())	{
        	String hatamesaji="gecici";
         }
         else	
         {
        	// Kullanici kullanici= kullanicilar.get(0);
        	 this.setOturum(kullanicilar.get(0)); 
        	 return "Kitaplar.xhtml";
         } 
 return ""; 
}  
 
	public void kaydet()
	{
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
	public List<Kullanici> getKullaniciListesi() { 
		EntityManager em = EntityUtil.getEntityManager();
		 return em.createQuery("from Kullanici Where Ad like :Ad or Soyad like :Soyad").setParameter("Ad","%"+ Aranan+"%").setParameter("Soyad", Aranan+"%").getResultList();
	}
	public void kitapAl()
	{
		this.kitap.setKitabiAlanKullanici(this.oturum);
		KitapBean kitapBean= new KitapBean();
		kitapBean.setKitap(this.kitap);
		kitapBean.kaydet();
	}	
	public void oturumKapat()
	{
		this.oturum=null;
		
	}
	public void kitapVer()
	{
		this.kitap.setKitabiAlanKullanici(null);
		KitapBean kitapBean= new KitapBean();
		kitapBean.setKitap(this.kitap);
		kitapBean.kaydet();
	}
	
	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	public String getKullaniciAd() {
		return kullaniciAd;
	}
	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public Kullanici getOturum() {
		return oturum;
	}
	public void setOturum(Kullanici oturum) {
		this.oturum = oturum;
	}
		}

	
	 
