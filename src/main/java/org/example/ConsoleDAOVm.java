package org.example;
import BancoDeDados.BancoLooca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleDAOVm {

    public Console login(Console console) {

        String sql1 = "INSERT INTO ComputadorESpec (fkEmpresa, fkUsuario) VALUES (?, ?)";
        String sql2 = "INSERT INTO Monitoramento (fkComputador) VALUES (?)";


        try (PreparedStatement ps1 = BancoLooca.getbancoLooca().prepareStatement(sql1);
             PreparedStatement ps2 = BancoLooca.getbancoLooca().prepareStatement(sql2)) {

            console = buscarDadaos(console);

            if (console.getIdComputadorVm() == null || console.getIdComputadorVm() == 0) {
                ps1.setInt(1, console.getIdEmpresa());
                ps1.setInt(2, console.getIdUser());
                ps1.executeUpdate();

                console = buscarDadaos(console);
            }

            ps2.setInt(1, console.getIdComputadorVm());
            ps2.executeUpdate();

        } catch (SQLException e) {
        }

        return console;
    }

    private Console buscarDadaos(Console console) {
        String sql = "select u.nome, u.idUsuario, u.fkEmpresa, cs.idComputador from usuario u left join ComputadorESpec cs on u.idUsuario = cs.fkUsuario where u.email = ? and u.senha = ?";

        try (PreparedStatement ps = BancoLooca.getbancoLooca().prepareStatement(sql)) {

            ps.setString(1, console.getUser());
            ps.setString(2, console.getPassword());

            try (ResultSet rsUsuario = ps.executeQuery()) {
                if (rsUsuario.next()) {
                    String nomeUsuario = (String) rsUsuario.getObject("nome");
                    Integer idUsuario = (Integer) rsUsuario.getObject("idUsuario");
                    Integer idEmpresa = (Integer) rsUsuario.getObject("fkEmpresa");
                    Integer idComputador = (Integer) rsUsuario.getObject("idComputador");

                    console.setNome(nomeUsuario);
                    console.setIdUser(idUsuario);
                    console.setIdEmpresa(idEmpresa);
                    console.setIdComputadorVm(idComputador);
                    console.setEntrou(true);


                } else {
                    console.setEntrou(false);
                }
            }
        } catch (SQLException e) {
        }

        return console;
    }


}
