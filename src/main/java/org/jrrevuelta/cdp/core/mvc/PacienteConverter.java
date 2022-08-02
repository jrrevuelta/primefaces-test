package org.jrrevuelta.cdp.core.mvc;

import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.jrrevuelta.cdp.core.ejb.PacienteManager;
import org.jrrevuelta.cdp.core.model.Paciente;

@FacesConverter(value="pacienteConverter", managed=true)
public class PacienteConverter implements Converter<Paciente> {

//	@EJB(name="ejb/CDP/PacienteManager") PacienteManager pacienteManager;
	@Inject PacienteManager pacienteManager;

	private static Logger log = Logger.getLogger("org.jrrevuelta.cdp.core.mvc");
	
	public PacienteConverter() {
		super();
		log.info("Paciente Converter instantiated.");
	}

	@Override
	public Paciente getAsObject(FacesContext context, UIComponent component, String pacienteId) throws ConverterException {
		log.info("Converting from id: [" + pacienteId + "]...");
		
		if (pacienteId != null) {
			int id = Integer.parseInt(pacienteId);
			Paciente p = pacienteManager.getPaciente(id);
			if (p != null) {
				log.info("...To Paciente: [" + p.getNombre() + " " + p.getApellidos() + "]");
			}
			return p;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Paciente paciente) throws ConverterException {
		log.info("Converting from paciente...");
		
		if (paciente != null) {
			log.info("...To Id: [" + paciente.getId() + "]");
			return Integer.toString(paciente.getId());
		} else {
			return "";
		}
	}

}
