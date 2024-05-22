/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fiapproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adrie
 */
public class FiapProject {

    public static void main(String[] args) {
        
        String usuario = "root";
        String senha = "12345678";
        String host = "localhost";
        String porta = "3306";
        String bd = "fiap";
        
        try{
            //Define o Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //abertura conexão
            //definindo url
            Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd,usuario,senha);
            System.out.println("Conectou com sucesso");
            
            
            //PreparedStatement pstmt = null;
            
            /*
            //----------Insert----------
            pstmt = conexao.prepareStatement("INSERT INTO t_produto (nm_produto, vl_produto) VALUES (?, ?)");
            
            pstmt.setString(1, "Goiaba");  //primeiro parametro (nome)
            pstmt.setInt(2, 10);          //segundo parametro (valor)
            pstmt.execute();
            //--------------------------
            */
            
            
            /*
            //----------Update----------
            pstmt = conexao.prepareStatement("UPDATE t_produto SET vl_produto = ? where cd_produto = ?");
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 3);
            pstmt.execute();
            //--------------------------
            */
            
            
            
            /*
            //----------DELETE----------
            pstmt = conexao.prepareStatement("DELETE FROM t_produto WHERE cd_produto = ?");
            pstmt.setInt(1, 1);
            pstmt.execute();
            //--------------------------
            */
            
            
            
            /*
            //----------SELECT----------
            pstmt = conexao.prepareStatement("SELECT * FROM t_produto WHERE cd_produto = ?");
            pstmt.setInt(1, 3);
            ResultSet result = pstmt.executeQuery();
            
            while(result.next()){
                System.out.println("Codigo: " + result.getInt("cd_produto") + "\n" + "Produto: " + result.getString("nm_produto") + "\n" + "Valor: " + result.getInt("vl_produto"));
            }
            //--------------------------
            */
            
            
            
            //----------PROCEDURE----------
            CallableStatement cs = conexao.prepareCall("{call spInsertProduto(?,?)}");
            cs.setString(1, "Amexa");
            cs.setInt(2, 20);
            cs.execute();
            //--------------------------
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            conexao.close();
        //tratando erro de conexao
        }catch(SQLException e){
            System.err.println("Não foi possível conectar ao banco");
            e.printStackTrace();
        //tratando erro de driver não encontrado
        }catch(ClassNotFoundException e){
            System.err.println("O driver JDBC não foi encontrado");
            e.printStackTrace();
        }
    }
}
