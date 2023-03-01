package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	
	
	//DECLARACIÓN
	
	protected DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int PRECIO_DIA=20;
	private LocalDate fechaAlquiler,fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;

	
	//CONSTRUCTORES
	public Alquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) {
		setCliente(new Cliente(cliente));
		setTurismo(new Turismo(turismo));
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler(Alquiler a) {
		if(a==null) {
			throw new NullPointerException("ERROR:El alquiler no puede ser nulo.");
		}
		setCliente(a.cliente);
		setTurismo(a.turismo);
		setFechaAlquiler(a.fechaAlquiler);
	}
	
	
	//FECHA ALQUILER
	
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if(fechaAlquiler==null) {
			throw new NullPointerException("ERROR: La fecha establecida no puede ser nula.");
		}
		if(fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha del alquiler no puede ser posterior a la fecha actual.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}
	

	//FECHA DEVOLUCIÓN
	
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		if(fechaDevolucion==null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if(fechaDevolucion.isBefore(fechaAlquiler)) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser anterior a la fecha de alquier.");
		}
		if(fechaDevolucion.isEqual(fechaAlquiler)) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser igual a la fecha de alquiler.");
		}
		if(fechaDevolucion.isAfter(LocalDate.now())){
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser posterior a hoy.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
	//CLIENTE
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No puedes alquilarle a un cliente nulo.");
		}
		this.cliente = cliente;
	}
	
	
	//TURISMO
	
	public Turismo getTurismo() {
		return turismo;
	}
	public void setTurismo(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: No puedes alquilar un turismo nulo.");
		}
		this.turismo = turismo;
	}
	
	
	//METODOS DE CLASE
	
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(fechaDevolucion==null) {
			throw new IllegalArgumentException("ERROR: No se puede devolver una fecha nula.");
		}
		if(getFechaDevolucion() !=null) {
			throw new OperationNotSupportedException("ERROR:");
		}
		setFechaDevolucion(fechaDevolucion);
	}
	
	public int getPrecio() {
		int numDias=(int)ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
		int precio=(turismo.getCilindrada()/10+PRECIO_DIA)*numDias;
		return precio;
	}
	
	
	//HASCODE & EQUALS

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}


	//TOSTRING
	
	@Override
	public String toString() {
		/*return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,
				ayer.format(Alquiler.FORMATO_FECHA), "Aún no devuelto", 0);*/
		return "Alquiler [fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion + ", cliente="
				+ cliente.toString() + ", turismo=" + turismo.toString() + "]";
	}
	
	
	
}
