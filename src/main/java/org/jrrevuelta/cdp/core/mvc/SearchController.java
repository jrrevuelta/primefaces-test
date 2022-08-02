package org.jrrevuelta.cdp.core.mvc;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jrrevuelta.cdp.core.ejb.PacienteManager;
import org.jrrevuelta.cdp.core.model.Paciente;
import org.primefaces.event.SelectEvent;

@Named("search")
@ViewScoped
public class SearchController implements Serializable {
	
	private Paciente selectedPaciente;
	private List<Paciente> pacientesList;

	// JRR: EJB layer is not replicated in the test
//	@EJB(name="ejb/CDP/PacienteManager") PacienteManager pacienteManager;
	@Inject PacienteManager pacienteManager;

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("org.jrrevuelta.cdp.core.mvc");

	
	public SearchController() {
		super();
		log.finest("SearchController MVC instantiated.");
	}

	@PostConstruct
	private void init() {}

	
	///////////////
	//  Actions  //
	///////////////
	
	public List<Paciente> completePaciente(String query) {
		log.info("Complete Paciente - with query [" + query + "]");
		
		String lowercaseQuery = query.toLowerCase();
		List<Paciente> list = getPacientesList()
				.stream()
				.filter(p -> p.getNombreCompleto().toLowerCase().contains(lowercaseQuery))
				.collect(Collectors.toList());
		for (Paciente p: list) {
			log.info("  " + p.getNombreCompleto());
		}
		return list;
	}
	
	public void selectPaciente(SelectEvent<Paciente> event) {
		log.info("Select Paciente - with event [" + event.getObject().getNombreCompleto() + "]");
		
		showPacienteSelected();
/*		
		Paciente p = event.getObject();
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler navigation = context.getApplication().getNavigationHandler();
		navigation.handleNavigation(context, null, "detalle-paciente?faces-redirect=true&paciente=" + p.getId());
*/
	}
	
	public void showPacienteSelected() {
		
		if (selectedPaciente != null) {
			log.info("Paciente selected [" + selectedPaciente.getId() + "] - [" + selectedPaciente.getNombreCompleto() + "]");
		} else {
			log.warning("No paciente is selected!!");
		}
	}
	
	
	//////////////////
	//  Properties  //
	//////////////////
	
	public Paciente getSelectedPaciente() { return selectedPaciente; }
	public void setSelectedPaciente(Paciente selectedPaciente) { this.selectedPaciente = selectedPaciente; }
	
	private List<Paciente> getPacientesList() { 
		if (pacientesList == null) {
			pacientesList = pacienteManager.getPacientesList();
		}
		return pacientesList;
	}
	
}
