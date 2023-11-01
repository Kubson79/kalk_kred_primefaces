package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;


@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String x;
	private String y;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getX() {
		return x ;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y ;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	public boolean obliczRate() {
		try {
			double x = Double.parseDouble(this.x);
			double y = Double.parseDouble(this.y);

			result = (x / (y*12)) + ((x / (y*12))*0.23);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (obliczRate()) {
			return "showRata";
		} 			
		return null;
	}
}