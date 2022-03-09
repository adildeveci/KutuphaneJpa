package Login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.org.omg.CORBA.ParameterMode;
@Entity
@Table(name = "Kullanici")
/*@NamedStoredProcedureQuery(
		name = "Gir", 
		procedureName = "Gir", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "Username"), 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "Secret"), 
			@StoredProcedureParameter(mode = ParameterMode.OUT, type = Double.class, name = "s")
		}
	)*/
public class Kullanici implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Ad;
	private String Soyad;
	private String Sifre;
	private Integer Yas;
	private String Cinsiyet;
	private String Sehir;
	private Boolean isAdmin;
	@OneToMany(mappedBy="kitabiAlanKullanici")
	private List<Kitap> aldigiKitaplar = new ArrayList<Kitap>();
	
	
	
	public List<Kitap> getAldigiKitaplar() {
		return aldigiKitaplar;
	}
	public void setAldigiKitaplar(List<Kitap> aldigiKitaplar) {
		this.aldigiKitaplar = aldigiKitaplar;
	}
	 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getAd() {
		return Ad;
	}
	public void setAd(String ad) {
		Ad = ad;
	}
	public String getSoyad() {
		return Soyad;
	}
	public void setSoyad(String soyad) {
		Soyad = soyad;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}
	public Integer getYas() {
		return Yas;
	}
	public void setYas(Integer yas) {
		Yas = yas;
	}
	public String getCinsiyet() {
		return Cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		Cinsiyet = cinsiyet;
	}
	public String getSehir() {
		return Sehir;
	}
	public void setSehir(String sehir) {
		Sehir = sehir;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	

}
