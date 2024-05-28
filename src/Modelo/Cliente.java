package Modelo;

import java.awt.image.BufferedImage;

public class Cliente {
	int ID;
	String nombre; 
	String apellido; 
	String correo; 
	int telefono;
	String fechaInicial;
	String fechaFinal; 
	String tipoMembresia; 
	String planMembresia; 
	String fechaNacimiento;
	BufferedImage imagen;
	String metodoPago;
	
	
	public Cliente(int iD, String nombre, String apellido, String correo, int telefono, String fechaInicial,
			String fechaFinal, String tipoMembresia, String planMembresia, String fechaNacimiento, BufferedImage imagen,
			String metodoPago) {
		
		ID = iD;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.tipoMembresia = tipoMembresia;
		this.planMembresia = planMembresia;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
		this.metodoPago = metodoPago;
	}


	public int getID() {
		return ID;
	}
	public int setID() {
		return ID;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public int getTelefono() {
		return telefono;
	}


	public String getFechaInicial() {
		return fechaInicial;
	}


	public String getFechaFinal() {
		return fechaFinal;
	}


	public String getTipoMembresia() {
		return tipoMembresia;
	}


	public String getPlanMembresia() {
		return planMembresia;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public BufferedImage getImagen() {
		return imagen;
	}


	public String getMetodoPago() {
		return metodoPago;
	}
	

}
