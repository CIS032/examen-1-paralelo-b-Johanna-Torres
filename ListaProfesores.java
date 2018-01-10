/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1_jt_jc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REDES
 */
public class ListaProfesores {

    ArrayList<Profesor> lista = new ArrayList<>();

    public void agregar(Profesor profe) {
        lista.add(profe);
    }

    public String listar() {
        String out = "";
        for (Profesor profesor : lista) {
            out += profesor + "\n";
        }
        return out;
    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("ListaDocentes.csv"), true));
            //pw.println("CEDULA;NOMBRES;APELLIDOS;TIPO PROFESOR;HORAS CLASE;HORAS COMPLEMENTARIAS");
            for (Profesor profesor : lista) {
                String out = profesor.getCedula() + ";" + profesor.getNombres() + ";" + profesor.getApellidos() + ";";
                if (profesor instanceof ProfesorTiempoCompleto) {
                    out += "Exclusiva";
                }
                if (profesor instanceof ProfesorMedioTiempo) {
                    out += "Semi Exclusiva";
                }
                if (profesor instanceof ProfesorTiempoParcial) {
                    out += "Tiempo Parcial";
                }
                out += ";" + profesor.getHorasClase() + ";" + profesor.horasComplementarias();
                pw.println(out);
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(ListaProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
