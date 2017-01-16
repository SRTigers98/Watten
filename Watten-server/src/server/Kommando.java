package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kommando implements Serializable {

	private String kommando;

	private List<Serializable> parameter;

	private Serializable returnWert;

	public void addParameter(Serializable p) {
		if (parameter == null) {
			parameter = new ArrayList<>();
		}
		parameter.add(p);
	}

	public String getKommando() {
		return kommando;
	}

	public void setKommando(String kommando) {
		this.kommando = kommando;
	}

	public List<Serializable> getParameter() {
		return parameter;
	}

	public void setParameter(List<Serializable> parameter) {
		this.parameter = parameter;
	}

	public Serializable getReturnWert() {
		return returnWert;
	}

	public void setReturnWert(Serializable returnWert) {
		this.returnWert = returnWert;
	}

	// Setter und Getter

}
