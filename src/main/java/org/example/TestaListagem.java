package org.example;

import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) {

        try{
            ConnectionFactory criaConexao = new ConnectionFactory();
            Connection con = criaConexao.recuperarConexao();
            //instancia qual vai ser o comando sql
             Statement stm = con.createStatement();
                //fala pra executar o seguinte comando/querry
                stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

                //recebe os resultados dessa querry
               ResultSet rst =  stm.getResultSet();

               while(rst.next()){
                   //coloca em variaveis para mostrar no terminal -> como parametro recebe o rotulo da coluna que detem a informacao
                   Integer id = rst.getInt("id");
                   System.out.println(id);
                   String nome = rst.getString("nome");
                   System.out.println(nome);
                   String descricao = rst.getString("descricao");
                   System.out.println(descricao);
               }


         con.close();

        }catch (SQLException e){
            System.out.println("Nao foi possivel realizar a coneccao com o Banco de Dados");
        }
    }
}
