package org.jrrevuelta.cdp.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

/**
 * The persistent class for the Paciente database table.
 * 
 */
/*
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({
	@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p WHERE p.status = :status"),
	@NamedQuery(name="Paciente.findByIdfr", query="SELECT p FROM Paciente p WHERE p.idfr = :idfr"),
	@NamedQuery(name="Paciente.maxNumHistoria", query="SELECT max(p.numHistoria) FROM Paciente p")
})
*/
public class Paciente implements Serializable {
	
	private int id;
	
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private int numHistoria;
//	private TipoIDFR tipoIdfr;
	private String idfr;
	private String telefono;
	private String email;
	private String direccion;
	private String cp;
	private String poblacion;
	private String autonomia;
	private Status status;
	private Date timestamp;
	
//	private CuestionarioSalud cuestionarioSalud;
//	private List<HistoriaClinica> historiaClinica = new ArrayList<HistoriaClinica>();
//	private List<DocumentoAnexo> documentosAnexos = new ArrayList<DocumentoAnexo>();

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("org.jrrevuelta.cdp.core.model");
	
	public enum Status {
		ACTIVE,
		DECEASED,
		DELETED
	}
	
	public Paciente() { log.finest("Paciente model entity instantiated."); }

//	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@JsonbTransient
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public String getNombre() { return this.nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellidos() { return this.apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	
//	@Transient
	public String getNombreCompleto() { return getNombre() + " " + getApellidos(); }
	
//	@Temporal(TemporalType.DATE)
//	@JsonbDateFormat("dd/MMM/yyyy")
	public Date getFechaNacimiento() { return this.fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	
	public int getNumHistoria() { return numHistoria; }
	public void setNumHistoria(int numHistoria) { this.numHistoria = numHistoria; }
/*	
	@ManyToOne @JoinColumn(name="TipoIDFR")
	public TipoIDFR getTipoIdfr() { return this.tipoIdfr; }
	public void setTipoIdfr(TipoIDFR tipoIdfr) { this.tipoIdfr = tipoIdfr; }
*/
	public String getIdfr() { return this.idfr; }
	public void setIdfr(String idfr) { this.idfr = idfr; }

	public String getTelefono() { return this.telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }

	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }

	public String getDireccion() { return this.direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	
	public String getCp() { return cp; }
	public void setCp(String cp) { this.cp = cp; }
	
	public String getPoblacion() { return poblacion; }
	public void setPoblacion(String poblacion) { this.poblacion = poblacion; }
	
	public String getAutonomia() { return autonomia; }
	public void setAutonomia(String autonomia) { this.autonomia = autonomia; }
	
//	@Enumerated(EnumType.STRING)
	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }
	
//	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamp() { return timestamp; }
	public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
/*	
	@OneToOne(mappedBy="paciente")
	@JsonbTransient
	public CuestionarioSalud getCuestionarioSalud() { return this.cuestionarioSalud; }
	public void setCuestionarioSalud(CuestionarioSalud cuestionarioSalud) { this.cuestionarioSalud = cuestionarioSalud; }
	
	@OneToMany(mappedBy="paciente")
	@JsonbTransient
	public List<HistoriaClinica> getHistoriaClinica() { return historiaClinica; }
	public void setHistoriaClinica(List<HistoriaClinica> historiaClinica) { this.historiaClinica = historiaClinica; }
	public void addHistoriaClinica(HistoriaClinica historiaClinica) { getHistoriaClinica().add(historiaClinica); }
	public void removeHistoriaClinica(HistoriaClinica historiaClinica) { getHistoriaClinica().remove(historiaClinica); }

	@OneToMany(mappedBy="paciente")
	@JsonbTransient
	public List<DocumentoAnexo> getDocumentosAnexos() { return documentosAnexos; }
	public void setDocumentosAnexos(List<DocumentoAnexo> documentosAnexos) { this.documentosAnexos = documentosAnexos; }
	public void addDocumentoAnexo(DocumentoAnexo documentoAnexo) { getDocumentosAnexos().add(documentoAnexo); }
	public void removeDocumentoAnexo(DocumentoAnexo documentoAnexo) { getDocumentosAnexos().remove(documentoAnexo); }
*/
}