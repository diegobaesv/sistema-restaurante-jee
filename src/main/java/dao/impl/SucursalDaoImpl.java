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
	public List<Sucursal> listarSucursales() {
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

	

	@Override
	public Sucursal obtenerSucursal(Integer id) {
		Connection cn = null;
		Sucursal sucursal = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_sucursal, nombre, direccion, imagen_url, telefono, correo, dias_atencion, horario_atencion, latitud, longitud FROM sucursales WHERE estado_auditoria = '1' AND id_sucursal = ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				sucursal = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch(Exception e){
			System.out.println(e);
			sucursal = null;
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

		return sucursal;
	}
	
	@Override
	public void insertarSucursal(Sucursal sucursal) {
		Connection cn = null;
		try {
			cn = DatabaseAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO sucursales (nombre, direccion, imagen_url, telefono, correo, dias_atencion, horario_atencion, latitud, longitud) VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, sucursal.getNombre());
			pstm.setString(2, sucursal.getDireccion());
			pstm.setString(3, sucursal.getImagenUrl());
			pstm.setString(4, sucursal.getTelefono());
			pstm.setString(5, sucursal.getCorreo());
			pstm.setString(6, sucursal.getDiasAtencion());
			pstm.setString(7, sucursal.getHorarioAtencion());
			pstm.setString(8, sucursal.getLatitud());
			pstm.setString(9, sucursal.getLongitud());
			
			pstm.executeUpdate();
			cn.commit();
			
			pstm.close();
			
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
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
