package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Turismo {
	
	
	//DECLARACIÓN
	
	private String [] ER_MARCA= {"Seat", "Land Rover", "KIA", "Rolls-Royce", "SsangYong"};
	private String ER_MATRICULA="[0-9]{4}[a-zA-Z]{3}";
	private String marca,modelo,matricula;
	private int cilindrada;
	
	
	//CONSTRUCTORES
	
	public Turismo(String marca,String modelo,String matricula,int cilindrada) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
		setCilindrada(cilindrada);
	}
	
	public Turismo(Turismo t) {
		setMarca(t.getMarca());
		setModelo(t.getModelo());
		setMatricula(t.getMatricula());
		setCilindrada(t.getCilindrada());
	}
	
	
	//MARCA 
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca==null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if(marca.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: La marca no puede estar vacia");
		}
		
		boolean marcaEncontrada=false;
		for(String i : ER_MARCA) {
			if(marca.equals(i)) {
				marcaEncontrada=true;
			}
		}
		if(marcaEncontrada==false) {
			throw new IllegalArgumentException("ERROR: La marca no se encuentra entre las existentes.");
		}
		
		this.marca = marca;
	}
	
	
	//MODELO
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo==null) {
			throw new NullPointerException("ERROR: El módelo no puede ser nulo.");
		}
		if(modelo.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar vacio.");
		}
		this.modelo = modelo;
	}	
	
	
	//MATRICULA
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		if(matricula==null) {
			throw new NullPointerException("ERROR: La matricula no puede ser nula.");
		}
		if(matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: La matricula no puede estar vacia.");
		}
		if(matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matricula no cumple el formato deseado");
		}
		
		this.matricula = matricula;
	}
	
	
	//CILINDRADA
	
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		if(cilindrada<1 || cilindrada>5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada debe de estar comprendida entre 1 y 5000.");
		}
		
		this.cilindrada = cilindrada;
	}
	
	
	//METODOS DE CLASE
	
	public static Turismo getTurismoConMatricula(String matricula, Set<Turismo> coleccionTurismo) {
		for(Turismo turismo:coleccionTurismo) {
			if(turismo.getMatricula().equals(matricula)) {
				return turismo;
			}
		}
		return null;
	}
	
	
	//EQUALS & HASCODE
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	
	//TOSTRING
	
	@Override
	public String toString() {
		return marca + ", " + modelo + ", " + matricula + ", "
				+ cilindrada;
	}
}
