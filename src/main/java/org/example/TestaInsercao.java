package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {


    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();


       Statement stm =  connection.createStatement();
                                                                                                //RETORNA  A CHAVE GERADA
       stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('mouse', 'mouse sem fio')",Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("o id criado foi: "+id);

        }
    }
}
