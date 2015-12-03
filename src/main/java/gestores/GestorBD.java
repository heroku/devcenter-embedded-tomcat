package gestores;

import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.ComentarioResponse;
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


public class GestorBD {

    private static GestorBD singleton = null;

    public static GestorBD getInstance() {

        if (singleton == null) {
            singleton = new GestorBD();
        }

        return singleton;
    }

    private GestorBD(){};   
    
//Metodos de BD
    
    public ClienteResponse VerificarLogin(String user, String pass) {
        String sql = "Select id_Cliente from cliente where usuario=? and password=?";
        ClienteResponse cliente;
        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setString(1, user);
            pes.setString(2, pass);
            ResultSet res = pes.executeQuery();
            cliente=new ClienteResponse();

            while (res.next()) {
                cliente.setId_Cliente(res.getInt("id_Cliente"));
            }
            

        } catch (SQLException ex) {
             cliente=new ClienteResponse();
        }

        return cliente;

    }

    public UsuarioResponse RegistrarUsuario(UsuarioRequest usuario) {

        UsuarioResponse response = new UsuarioResponse();

        String sql = "insert into cliente (usuario,pass,nombres,email) VALUES(?,?,?,?)";

        try {
            Connection conn = ConeccionBD.GetConnection();
            if (conn == null) {
                throw new ClassNotFoundException();
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
            response.setMsgError("Error al registrar el usuario.");
            //error de sintaxis de sql
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            response.setMsgStatus("Error");
            response.setMsgError("Error al establecer conexion con base de datos.");
            //error de sintaxis de sql
            ex.printStackTrace();
        }
        return response;
    }

    public List<GustosResponse> seleccionarGustos() {

        GustosResponse gusto = new GustosResponse();
        List<GustosResponse> gustos = new ArrayList<GustosResponse>();

        try {

            String sql = "Select id_categoria,nombre,foto from categoria";
            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes = conn.prepareStatement(sql);
            ResultSet res = pes.executeQuery();

            while (res.next()) {

                gusto.setId_Categoria(res.getInt(1));
                gusto.setNombre(res.getString(2));
                gusto.setFoto(res.getString(3));

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

        String sql = "select nombre,id_FoodTruck from foodtruck where id_Categoria=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, gustos.getId_Categoria());
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

        String sql = "Select nombre,latitud,longitud,horainicio,horafin,email from foodtruck where id_foodtruck=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, foodtruck.getIdFoodTruck());
            ResultSet res = pes.executeQuery();

            while (res.next()) {

                foodtruck.setComentarios(obtenerComentarios(foodtruck.getIdFoodTruck()));
                foodtruck.setCupones(obtenerCupones(foodtruck.getIdFoodTruck()));
                foodtruck.setNombre(res.getString("nombre"));
                foodtruck.setLatitud(res.getFloat("latitud"));
                foodtruck.setLatitud(res.getFloat("longitud"));
                foodtruck.setHorarInicio(res.getString("hora_inicio"));
                foodtruck.setHorarFin(res.getString("hora_fin"));
                foodtruck.setEmail(res.getString("email"));
            //foodtruck.setCondicion(res.getString("condicion"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarPerfil(ClienteResponse cliente) {

        String sql = "Select nombres,email from cliente where id_cliente=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, cliente.getId_Cliente());
            ResultSet res = pes.executeQuery();

            while (res.next()) {
                cliente.setEmail(sql);
                cliente.setNombres(sql);
                cliente.setGustos(obtenerGustosCliente(cliente.getId_Cliente()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  //Algunos Medotos de Apoyo 
    public List<ComentarioResponse> obtenerComentarios(int idFoodtruck) {

        ComentarioResponse comentario = new ComentarioResponse();
        comentario.setIdfoodtruck(idFoodtruck);
        List<ComentarioResponse> comentarios = new ArrayList<ComentarioResponse>();
        String sql = "Select c.descripcion,f.fechacomentario,f.id_cliente from comentarioxft  f inner join comentario c  on f.id_comentario=c.id_comentario where f.id_foodtruck=?";

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
    
    
    
    //cambiar direccion
    public void cambiarDireccion(FoodTruckResponse ft){
        String sql="update foodtruck set latitud=?,longitud=? where idFoodtruck=?";
         try{
            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setFloat(1,ft.getLatitud());
            pes.setFloat(2,ft.getLongitud());
            pes.setInt(3,ft.getIdFoodTruck());
            pes.executeUpdate();
         
         } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ingresar dcto
    public void ingresarOferta(CuponResponse cupon ){
        UsuarioResponse response = new UsuarioResponse();
        String sql= "Insert into cupon(idCupon,descripcion,nombre,idFoodtruck,cantidad) values(?,?,?,?,?)";
        try{
            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            
            pes.setInt(1,cupon.getIdCupon());
            pes.setString(2,cupon.getDescripcion());
            pes.setString(3,cupon.getNombre());
            pes.setInt(4,cupon.getIdfoodtruck());
            pes.setInt(5,cupon.getCantidad());
            int confirmacion =pes.executeUpdate();
             if (confirmacion == 1) {
                response.setMsgStatus("Usuario Registrado");
                response.setMsgError(null);
            } else {
                response.setMsgStatus("Error");
                response.setMsgError("Hubo un problema al crear usuario, verifique los campos de datos.");
             }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresarGustos(List<GustosResponse> gustos, ClienteResponse cliente) {

        String sql = "Insert into clientexcategoria(id_cliente,id_categoria) values(?,?)";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);

            for (GustosResponse categoria : gustos) {

                pes.setInt(1, categoria.getId_Categoria());
                pes.setInt(2, cliente.getId_Cliente());
                int confirmacion = pes.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ClienteResponse loginCliente() {
        ClienteResponse cliente = new ClienteResponse();
        return cliente;
    }

    public List<GustosResponse> obtenerGustosCliente(int id_cliente) {
        List<GustosResponse> gustos = new ArrayList<GustosResponse>();
        String sql = "Select g.id_categoria,c.nombre,c.foto from clientexcategoria g inner join categoria  c on g.id_categoria=c.id_categoria where g.id_cliente=?";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement pes;
            pes = conn.prepareStatement(sql);
            pes.setInt(1, id_cliente);
            ResultSet res = pes.executeQuery();
            GustosResponse gusto = new GustosResponse();

            while (res.next()) {
                gusto.setId_Categoria(res.getInt("id_categoira"));
                gusto.setNombre(res.getString("nombre"));
                gusto.setFoto(res.getString("foto"));
                gustos.add(gusto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gustos;
    }
    
    
        
    }

