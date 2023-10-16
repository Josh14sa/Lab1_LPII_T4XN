package edu.cibertec.views;

import edu.cibertec.controller.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {

		String empleado;

		// ----------Metodo createEmpleado----------

		empleado = new UsuarioController().createEmpleado("Lopez Alvarez", "Roberto Luis", 29, "M", 2500.00);
		empleado = new UsuarioController().createEmpleado("Soto Roman", "Kiara", 20, "F", 1200.00);
		empleado = new UsuarioController().createEmpleado("Lopez Hurtado", "Karla", 26, "F", 2100.00);
		empleado = new UsuarioController().createEmpleado("Torres Gutierrez", "Javier Benajin", 20, "M", 1200.00);
		empleado = new UsuarioController().createEmpleado("Valencia Mamani", "Fausto", 28, "M", 2200.00);
		empleado = new UsuarioController().createEmpleado("Lopez Cure", "Ignacio", 27, "M", 2600.00);

		// -------Metodo deleteEmpleado------------

		empleado = new UsuarioController().deleteEmpleado(1);
		empleado = new UsuarioController().deleteEmpleado(4);

		// -------Metodo updateEmpleado-------------

		empleado = new UsuarioController().updateEmpleado(1, "Soto Roman", "Kiara", 20, "F", 2500.00);
		empleado = new UsuarioController().updateEmpleado(4, "Valencia Mamani", "Fausto", 28, "M", 2900.00);

		// ------------Metodo getEmpleado------------

		empleado = new UsuarioController().getEmpleado(3);
		empleado = new UsuarioController().getEmpleado(5);

		System.out.print(empleado);
	}

}