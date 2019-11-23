package mypackage4;
import java.sql.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import oracle.jdbc.OracleDriver;

public class ConnectDB 
{
  Connection conexion;
  Statement statement;

  public ConnectDB(){
    final String sourceURL = "jdbc:oracle:thin:@201.131.41.50:1521:XE";
    final String UserName = "anavia";
    final String Password = "taller2019";
    try {
      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
      conexion = DriverManager.getConnection
                (sourceURL,UserName,Password);
      statement = conexion.createStatement ();
    } catch( SQLException sqle ) {
      System.err.println(sqle);
    }
  }
  
  public void closeConnection () {
    if(conexion!=null)
    try {
      statement.close();
      conexion.close();
      conexion=null;
    } catch (SQLException ex) {
        System.out.println("\nSQLException-------------\n");
        System.out.println("SQLState: "+ ex.getSQLState());
        System.out.println("Message : "+ ex.getMessage());
    }
  }
  
  ResultSet getData(String Consulta){
    ResultSet rs=null;
    try
    {
//      System.out.println(Consulta);
      rs=statement.executeQuery(Consulta);
    } catch (SQLException ex) {
        System.out.println("\nSQLException-------------\n");
        System.out.println("SQLState: "+ ex.getSQLState());
        System.out.println("Message : "+ ex.getMessage());
    }
    return rs;
  }

  int InsertaDatos(String Consulta){
    int NroReg=-1;
    try
    {
        NroReg=statement.executeUpdate(Consulta);
    }
    catch (SQLException ex)
    {   System.out.println("\nSQLException-------------\n");
        System.out.println("SQLState: "+ ex.getSQLState());
        System.out.println("Message : "+ ex.getMessage());
    }
    return NroReg;
  }

  String ValRegistro(String Consulta,String Campo){
    String Cadena=null;
    try
    {
      ResultSet rs=statement.executeQuery(Consulta);
      if (rs.next())
        Cadena=rs.getString(Campo);
      rs.close();
    } catch (SQLException ex) {
        System.out.println("\nSQLException-------------\n");
        System.out.println("SQLState: "+ ex.getSQLState());
        System.out.println("Message : "+ ex.getMessage());
    }
    return Cadena;
  }

  boolean Existe(String Consulta){
    boolean existe=false;
    try
    {
      ResultSet rs=statement.executeQuery(Consulta);
      if (rs.next())
        existe=true;
      else
        existe=false;
      rs.close();
    } catch (SQLException ex) {
        System.out.println("\nSQLException-------------\n");
        System.out.println("SQLState: "+ ex.getSQLState());
        System.out.println("Message : "+ ex.getMessage());
    }
    return existe;
  }
}