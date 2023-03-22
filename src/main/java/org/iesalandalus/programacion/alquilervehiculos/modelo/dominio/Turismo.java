package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
public class Turismo {
	
	
	//DECLARACIÓN
	
	private String [] ER_MARCA= {"Seat", "Land Rover", "KIA", "Rolls-Royce", "SsangYong"};
	private String ER_MATRICULA="[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}";
	private String marca,modelo,matricula;
	private int cilindrada;
	
	
	//CONSTRUCTORES
	
	public Turismo(String marca,String modelo,int cilindrada,String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	
	public Turismo(Turismo t) {
		if(t==null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setMarca(t.getMarca());
		setModelo(t.getModelo());
		setCilindrada(t.getCilindrada());
		setMatricula(t.getMatricula());

	}
	
	
	//MARCA 
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca==null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}		
		boolean marcaEncontrada=false;
		for(String i : ER_MARCA) {
			if(marca.equals(i)) {
				marcaEncontrada=true;
			}
		}
		if(marcaEncontrada==false) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		
		this.marca = marca;
	}
	
	
	//MODELO
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo==null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if(modelo.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}	
	
	
	//MATRICULA
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		if(matricula==null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if(!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		
		this.matricula = matricula;
	}
	
	
	//CILINDRADA
	
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		if(cilindrada<1 || cilindrada>5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		
		this.cilindrada = cilindrada;
	}
	
	
	//METODOS DE CLASE
	
	public static Turismo getTurismoConMatricula(String matricula) {
		if(matricula==null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		return new Turismo("Seat","Leon",1900,matricula);
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
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible");
	}
}
