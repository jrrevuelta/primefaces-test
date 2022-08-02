package org.jrrevuelta.cdp.core.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.jrrevuelta.cdp.core.model.Paciente;


// JRR: In the real thing, this is an EJB
@Named
@ApplicationScoped
public class PacienteManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	List<Paciente> pacientes = new ArrayList<Paciente>();
	
	
	// JRR: Artificially fill the list of Pacientes
	public PacienteManager() {
		super();
		
		Paciente p = null; 
		
		p = new Paciente();
		p.setId(1); p.setNombre("José Ramón"); p.setApellidos("Revuelta Lazcano");
		pacientes.add(p);
		p = new Paciente();
		p.setId(2); p.setNombre("Margarita"); p.setApellidos("Arana Menéndez");
		pacientes.add(p);
		p = new Paciente();
		p.setId(3); p.setNombre("Alejandro"); p.setApellidos("Pineda Gómez");
		pacientes.add(p);
		p = new Paciente();
		p.setId(4); p.setNombre("Emilio José"); p.setApellidos("García Mayo");
		pacientes.add(p);
		p = new Paciente();
		p.setId(5); p.setNombre("Jorge Armando"); p.setApellidos("Mercado Pérez");
		pacientes.add(p);
		p = new Paciente();
		p.setId(6); p.setNombre("Marcelo"); p.setApellidos("Arana Estrada");
		pacientes.add(p);
		p = new Paciente();
		p.setId(7); p.setNombre("Rodrigo"); p.setApellidos("Revuelta Arana");
		pacientes.add(p);
		p = new Paciente();
		p.setId(8); p.setNombre("María Jimena"); p.setApellidos("Revuelta Arana");
		pacientes.add(p);
		p = new Paciente();
		p.setId(9); p.setNombre("María José"); p.setApellidos("Revuelta Arana");
		pacientes.add(p);
		p = new Paciente();
		p.setId(10); p.setNombre("Pilar"); p.setApellidos("Mercado Pérez");
		pacientes.add(p);
		p = new Paciente();
		p.setId(11); p.setNombre("Joaquín"); p.setApellidos("Gómez Gurza");
		pacientes.add(p);
		p = new Paciente();
		p.setId(12); p.setNombre("Felipe"); p.setApellidos("García Buxó");
		pacientes.add(p);
		p = new Paciente();
		p.setId(13); p.setNombre("Luis"); p.setApellidos("Cervelló Gendrop");
		pacientes.add(p);

	}
	
	public List<Paciente> getPacientesList() {
		
		return pacientes;
	}
	
	public Paciente getPaciente(int id) {
		
		Paciente paciente = null;
		for (Paciente p: pacientes) {
			if (p.getId() == id) {
				paciente = p;
				break;
			}
		}
		
		return paciente;
	}
}
