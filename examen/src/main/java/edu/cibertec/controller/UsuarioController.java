package edu.cibertec.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.cibertec.models.Usuario;


public class UsuarioController {
	
	//Creación Empleado
	public String createEmpleado (String apellidos, String nombres, int edad, String sexo, double salario) {
		
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		try {
			Usuario empleado;
			empleado = new Usuario(apellidos, nombres, edad, sexo, salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado creado";
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al crear empleado";
	}

	//Eliminar Empleado
	public String deleteEmpleado(int idempleado) {
		
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Usuario empleado = session.get(Usuario.class, idempleado);
			session.delete(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado eliminado";
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al eliminar empleado";

	}
	
	//Actualizar Empleado
	public String updateEmpleado (int idempleado, String apellidos, String nombres, int edad, String sexo, double salario) {
		
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Usuario empleado = session.get(Usuario.class, idempleado);
			empleado.setApellidos(apellidos);
			empleado.setNombres(nombres);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);
			session.update(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado actualizado";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar empleado";
	}
	
	//Obtener Empleado
	public String getEmpleado(int idempleado) {
		
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario empleado = session.get(Usuario.class, idempleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return empleado.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Empleado no existe";
	}
}
