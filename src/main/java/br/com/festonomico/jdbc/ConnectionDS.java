package br.com.festonomico.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDS {
	 
    Connection con;
    private String dbName = "/jdbc/festa";
 
    public Connection getConnection() {
        try {
            if (con == null) {
                Context initContext = new InitialContext();
                Context envContext  = (Context)initContext.lookup("java:/comp/env");
                
                DataSource ds = (DataSource)envContext.lookup(dbName);
                con = ds.getConnection();
                System.out.println("Conectado ao banco!:) ");
            }
            return con;
        } catch (Exception ex) {
            System.out.println("Nao pode abrir conexao para o banco de dados: " + ex.getMessage());
        }
        return con;
    }
}