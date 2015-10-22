package gestores;

import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.ComentarioRespone;
import dto.UserRegistro.CuponResponse;
import dto.UserRegistro.FoodTruckResponse;
import dto.UserRegistro.GustosResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.UserRegistro.UsuarioRequest;
import dto.UserRegistro.UsuarioResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author GARY
 */
public class GestorBD {
    //Metodos de BD

    public UsuarioResponse RegistrarUsuario(UsuarioRequest usuario) {

        UsuarioResponse response = new UsuarioResponse();

        String sql = "INSERT INTO ft_usuario (usuario,pass,nombre,email) VALUES(?,?,?,?)";

        try {
            Connection conn = ConeccionBD.GetConnection();
            if(conn==null){
                throw  new ClassNotFoundException();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getEmail());

            int confirmacion = ps.executeUpdate();

            if (confirmacion == 1) {
                response.setMsgStatus("Usuario Registrado");
                response.setMsgError(null);
            } else {
                response.setMsgStatus("Error");
                response.setMsgError("Hubo un problema al crear usuario, verifique los campos de datos.");
                //problema hecho por el usuario
            }
        } catch (SQLException ex) {
            response.setMsgStatus("Error");
            response.setMsgError("Error al registrar el usuario. ");
            //error de sintaxis de sql
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            response.setMsgStatus("Error");
            response.setMsgError("Error al establecer conexión con base de datos.");
            //error de sintaxis de sql
            ex.printStackTrace();
        }
        return response;
    }
    
    public List<GustosResponse> seleccionarGustos() {

        GustosResponse gusto=new GustosResponse();
        List<GustosResponse> gustos = new ArrayList<GustosResponse>();

        try {

            String sql = "Select idcategoria,nombre,imagen from ft_categoria";
            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes = conn.prepareStatement(sql);
            ResultSet res = pes.executeQuery();

            while (res.next()) {
                
                gusto.setIdCategoria(res.getInt(1));
                gusto.setNombre(res.getString(2));
                gusto.setUrl(res.getString(3));

                gustos.add(gusto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gustos;

    }
    
    public List<FoodTruckResponse> FoodTruckPorCategoria(GustosResponse gustos) {

        FoodTruckResponse foodTruck = new FoodTruckResponse();
        List<FoodTruckResponse> listaFoodTruck = new ArrayList<FoodTruckResponse>();

        String sql = "select nombre,idFoodTruck from ft_foodtruck where idCategoria=?"; //cambiar query esta mal

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, gustos.getIdCategoria());
            ResultSet res = pes.executeQuery();

            while (res.next()) {

                foodTruck.setIdFoodTruck(res.getInt("idFoodTruck"));
                foodTruck.setNombre(res.getString("nombre"));
                foodTruck.setGustos(gustos);
               

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFoodTruck;
    }
    
    
    
    public void obtenerFoodTruck(FoodTruckResponse foodtruck) {

        String sql = "Select nombre,direccion,hora_inicio,hora_fin,email,condicion from ft_foodtruck";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            ResultSet res = pes.executeQuery();

            while (res.next()) {
            
            foodtruck.setComentarios(obtenerComentarios(foodtruck.getIdFoodTruck()));
            foodtruck.setCupones(obtenerCupones(foodtruck.getIdFoodTruck()));
            foodtruck.setDireccion(res.getString("direccion"));
            foodtruck.setHorarInicio(res.getString("hora_inicio"));
            foodtruck.setHorarFin(res.getString("hora_fin"));
            foodtruck.setEmail(res.getString("email"));
            foodtruck.setCondicion(res.getString("condicion"));
                        
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


  //Algunos Medotos de Apoyo 
    
        public List<ComentarioRespone> obtenerComentarios(int idFoodtruck) {

        ComentarioRespone comentario = new ComentarioRespone();
        comentario.setIdfoodtruck(idFoodtruck);
        List<ComentarioRespone> comentarios = new ArrayList<ComentarioRespone>();
        String sql = "Select comentario,fecha,idcliente from ft_comentario where idfoodtruck=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, idFoodtruck);
            ResultSet res = pes.executeQuery();

            while (res.next()) {
                comentario.setComentario(res.getString("comentario"));
                comentario.setIdCliente(res.getInt("idcliente"));
                comentario.setFecha(res.getDate("fecha"));
                comentarios.add(comentario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comentarios;

    }

    public List<CuponResponse> obtenerCupones(int idFoodtruck) {

        CuponResponse cupon = new CuponResponse();
        List<CuponResponse> cupones = new ArrayList<CuponResponse>();

        String sql = "Select  a.idCupon,a.nombre, a.descripcion from  CuponxFoodTruck a inner join  ft_cupon b on  a.idCupon=b.idCupon where  a.idFoodTruck=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, idFoodtruck);
            ResultSet res = pes.executeQuery();

            while (res.next()) {
                cupon.setIdCupon(res.getInt("idCupon"));
                cupon.setNombre(res.getString("nombre"));
                cupon.setDescripcion(res.getString("descripcion"));
                cupones.add(cupon);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cupones;

    }
    
    
    public void  ingresarGustos(List<GustosResponse> gustos,ClienteResponse cliente){
   
    String sql="Insert into clientexcategoria(iccliente,idcategoria) values(?,?)";
    

        try {
            
            Connection conn=ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes=conn.prepareStatement(sql);
       
         for(GustosResponse categoria:gustos){
             
             pes.setInt(1,categoria.getIdCategoria());
             pes.setInt(2,cliente.getIdCliente());
             int confirmacion=pes.executeUpdate();
         
         }                           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    
    }
    
    public ClienteResponse loginCliente(){
    ClienteResponse cliente=new ClienteResponse();
        
    
    
        
    return  cliente;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
