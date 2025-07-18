package com.example;

import java.sql.*;

public class App {
    // Parametri di connessione
    static String URL      = "jdbc:mysql://localhost:3306/testdb";
    static String USER     = "root";
    static String PASSWORD = "";

    public static void main(String[] args) {

        // Query per recuperare tutti gli utenti
        String query = "SELECT id, nome FROM utenti";

        // try chiude automaticamente: Connection, PreparedStatement, ResultSet
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Connessione riuscita. Elenco utenti:");

            // Scorri il ResultSet e stampa ogni riga
            while (rs.next()) {
                int    id   = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.printf(" ID = " + id + " " + "Nome = " + nome);
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l’accesso al database:");
            e.printStackTrace();
        }
    }
}

