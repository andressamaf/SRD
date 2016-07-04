package modelo.servicio;

import utilidades.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.entidades.Usuario;

public class ServicioUsuario {
	
	public static void main(String[] args) {
		ServicioUsuario su = new ServicioUsuario();
		Usuario u = new Usuario();
		u.setUsr_ci("1727299420");
		u.setUsr_clave("1727299420");
		if (su.permitirIngreso(u)){
			System.out.println("si");
		}
		else {
			System.out.println("no");
		}

	}
	
	
	public boolean permitirIngreso(Usuario usuario){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = connection.prepareStatement("select * from USUARIO where USR_CI = ? and USR_CLAVE = ?");
			st.setString(1, usuario.getUsr_ci());
			st.setString(2, usuario.getUsr_clave());
			st.execute();
			ResultSet rs = st.getResultSet();			
			
			if (rs.next()) {
				connection.close();
				return true;
			}
			else {
				connection.close();
				return false;
			}			
			
		} catch (Exception e) {
			System.out.println("Error en permitirIngreso()!");
		}
		return false;
	}
}
