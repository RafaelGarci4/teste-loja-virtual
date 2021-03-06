package org.example;

import java.sql.*;

public class TesteInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.recuperarConexao();
        connection.setAutoCommit(false);
       // String sql = ;

        try{
            PreparedStatement stm =  connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            adicionarVariavel("SmartTV", "45 Polegadas", stm);
            adicionarVariavel("Radio", "Radio de bateria", stm);

            connection.commit();
            stm.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();
        }

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        //RETORNA  A CHAVE GERADA
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("o id criado foi: "+id);

        }
    }
}
