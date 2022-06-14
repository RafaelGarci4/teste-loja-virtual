package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();


        PreparedStatement stm =  connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > 2");
        stm.execute();


        Integer linhasModificadas =  stm.getUpdateCount();

        System.out.println("Quantidade de linhas alteradas : "+linhasModificadas);

    }
}
