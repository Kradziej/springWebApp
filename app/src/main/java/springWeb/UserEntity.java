package springWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="uczestnicy" )
public class UserEntity {
	
	@Id
	@Column(name="Id")
	@GeneratedValue
	private Integer id;
	@Column(name="Imie")
	private String imie;
	@Column(name="Nazwisko")
	private String nazwisko;
	@Column(name="Grupa")
	private int grupa;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getGrupa() {
		return grupa;
	}
	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}

}
