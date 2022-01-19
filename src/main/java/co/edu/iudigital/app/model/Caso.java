package co.edu.iudigital.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="casos")
public class Caso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;
	
	@Column
	private float latitud;
	
	@Column
	private float longitud;

	@Column
	private float altitud;

	@Column
	private Boolean visible;
	
	@Column
	private String descripcion;
	
	@Column(name = "url_map")
	private String urlMap;
	
	@Column(name = "rmi_url")
	private String rmiURL;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "delitos_id")
	private Delito delito;
	
	@PrePersist
	public void prePersist() {
		if(fechaHora == null) {
			fechaHora = LocalDateTime.now();
		}
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the latitud
	 */
	public float getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public float getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the altitud
	 */
	public float getAltitud() {
		return altitud;
	}

	/**
	 * @param altitud the altitud to set
	 */
	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

	/**
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the urlMap
	 */
	public String getUrlMap() {
		return urlMap;
	}

	/**
	 * @param urlMap the urlMap to set
	 */
	public void setUrlMap(String urlMap) {
		this.urlMap = urlMap;
	}

	/**
	 * @return the rmiURL
	 */
	public String getRmiURL() {
		return rmiURL;
	}

	/**
	 * @param rmiURL the rmiURL to set
	 */
	public void setRmiURL(String rmiURL) {
		this.rmiURL = rmiURL;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the delito
	 */
	public Delito getDelito() {
		return delito;
	}

	/**
	 * @param delito the delito to set
	 */
	public void setDelito(Delito delito) {
		this.delito = delito;
	}
	
	

}
