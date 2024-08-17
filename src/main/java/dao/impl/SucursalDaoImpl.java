package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.SucursalDao;
import models.Sucursal;

public class SucursalDaoImpl implements SucursalDao {

	@Override
	public List<Sucursal> listar() {
		Connection cn = null;
		List<Sucursal> sucursales = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_sucursal, nombre, direccion, imagen_url, telefono, correo, dias_atencion, horario_atencion, latitud, longitud FROM sucursales WHERE estado_auditoria = '1'";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			sucursales = new ArrayList();
			while(rs.next()) {
				sucursales.add(resultSetToObject(rs));
			}
			
			rs.close();
			pstm.close();
			
		} catch(Exception e){
			System.out.println(e);
			sucursales = null;
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

		return sucursales;
	}
	
	private Sucursal resultSetToObject(ResultSet rs) throws Exception {
		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(rs.getInt("id_sucursal"));
		sucursal.setNombre(rs.getString("nombre"));
		sucursal.setDireccion(rs.getString("direccion"));
		sucursal.setImagenUrl(rs.getString("imagen_url"));
		sucursal.setTelefono(rs.getString("telefono"));
		sucursal.setCorreo(rs.getString("correo"));
		sucursal.setDiasAtencion(rs.getString("dias_atencion"));
		sucursal.setHorarioAtencion(rs.getString("horario_atencion"));
		sucursal.setLatitud(rs.getString("latitud"));
		sucursal.setLongitud(rs.getString("longitud"));
		return sucursal;
	}
	
	

}
