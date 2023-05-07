//crearemos metodos para la extrancion de datos de la base de datos
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao implements CRUD{
    
    Connection acceso;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    //Vendedor ve = new Vendedor();
    
    //metodo para validar acceso al sistema
    public Vendedor ValidarVendedor(String dni, String user){
        Vendedor v=new Vendedor();
        //
        String sql="select * from vendedor where Dni=? and User=?";
        try {
            acceso=con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            //buscar dentro de nuestra base de datos
            while(rs.next()){
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
                
            }
        } catch (Exception e) {
        }
        return v;
    }
    @Override
    public List listar() {
        List<Vendedor> lista=new ArrayList<>();
        String sql="select * from VENDEDOR";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vendedor v=new Vendedor();
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
                lista.add(v);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="insert into vendedor(IdVendedor,Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?,?)";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r; 
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="update vendedor set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdVendedor=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="delete from Vendedor where IdVendedor=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
