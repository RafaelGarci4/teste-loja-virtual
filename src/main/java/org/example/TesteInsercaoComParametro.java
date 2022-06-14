package org.example;

import java.sql.*;

public class TesteInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        String nome = "Mouse 2";
        String descricao = "Mouse sem fio 2";
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.recuperarConexao();

       // String sql = ;
        PreparedStatement stm =  connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
        stm.setString(1,nome);
        stm.setString(2,descricao);
        //RETORNA  A CHAVE GERADA
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("o id criado foi: "+id);

        }
    }
}
