package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                    "root",
                    password);

            connection.close();

        }catch (SQLException e){
            System.out.println("Nao foi possivel realizar a coneccao com o Banco de Dados");
        }
    }

}
