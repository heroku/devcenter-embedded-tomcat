/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author rafae
 */
public class Conexao {
    public static Connection teste() throws SQLException, NamingException {
//        return DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/instaclone", "root", "root");
        return DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10232125?useSSL=true", "sql10232125", "g1ALnJFmgv");

    }
}
