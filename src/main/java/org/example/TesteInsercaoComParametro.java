package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        String nome = "Mouse 2";
        String descricao = "Mouse sem fio 2";
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.recuperarConexao();


        Statement stm =  connection.createStatement();
        //RETORNA  A CHAVE GERADA
        stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('"+ nome +"','"+descricao+"')",Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("o id criado foi: "+id);

        }
    }
}
