package Login;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Kitap")
public class Kitap implements Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id; 
	private String Kitapadi;
	private String Raf;
	private String Yazari;
	private String Yayinevi;
	private String Turu;
	
	@ManyToOne
	private Kullanici kitabiAlanKullanici;
	
	
	public Kullanici getKitabiAlanKullanici() {
		return kitabiAlanKullanici;
	}
	public void setKitabiAlanKullanici(Kullanici kitabiAlanKullanici) {
		this.kitabiAlanKullanici = kitabiAlanKullanici;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getKitapadi() {
		return Kitapadi;
	}
	public void setKitapadi(String kitapadi) {
		Kitapadi = kitapadi;
	}
	public String getYazari() {
		return Yazari;
	}
	public void setYazari(String yazari) {
		Yazari = yazari;
	}
	public String getYayinevi() {
		return Yayinevi;
	}
	public void setYayinevi(String yayinevi) {
		Yayinevi = yayinevi;
	}
	public String getTuru() {
		return Turu;
	}
	public void setTuru(String turu) {
		Turu = turu;
	}
	public String getRaf() {
		return Raf;
	}
	public void setRaf(String raf) {
		Raf = raf;
	}
	

}
