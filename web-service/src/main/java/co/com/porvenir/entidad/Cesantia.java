package co.com.porvenir.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
(
	name="CESANTIA"
	,uniqueConstraints=
	{
			 @UniqueConstraint(name="UK_USUARIO_CESANTIA",columnNames={"ID_AFILIADO"})
	}
)
public class Cesantia {
	
	@Id
	@Column(name="ID_CESANTIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AFILIADO",nullable=false)
	private Afiliado afiliado;
	@Column(name="SALDO",nullable=false)
	private long saldo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	public long getSaldo() {
		return saldo;
	}
	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
}
