package dao;

import java.util.List;

import models.Sucursal;

public interface SucursalDao {
	public List<Sucursal> listarSucursales();
	public Sucursal obtenerSucursal(Integer id);
	public void insertarSucursal(Sucursal sucursal);
}