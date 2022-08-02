package org.primefaces.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestView implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String string;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }
    
    public String getString() {
		return string;
	}
    public void setString(String string) {
		this.string = string;
	}

}
