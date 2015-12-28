/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.sintactico;

import analizador.lexico.Lexico;
import analizador.lexico.AnalizadorLexico.TOKEN;
import java.util.Hashtable;

/**
 *
 * @author Fabricio
 */
public class ErrorSintaxis {

    //los posibles errores
    private static final String ERROR_ID = "Se esperaba identificador";
    private static final String ERROR_FIN = "Se esperaba final de instruccion ';'";
    private static final String ERROR_APERTURA = "Se esperaba apertura '('";
    private static final String ERROR_CIERRE = "Se esperaba cierre ')'";
    private static final Hashtable<Object, String> tablaError;
    private String descripcion;

    static {
        tablaError = new Hashtable<Object, String>();
        tablaError.put(Gramatica.NO_TERMINAL, ERROR_ID);
        tablaError.put(TOKEN.ABRIR_PARENTESIS, ERROR_APERTURA);
        tablaError.put(TOKEN.CERRAR_PARENTESIS, ERROR_CIERRE);
        tablaError.put(TOKEN.FIN_EXP, ERROR_FIN);
    }

    public ErrorSintaxis(TOKEN tokenAFD, Lexico lexema) {
        descripcion = String.format("Error en "+tokenAFD);

    }

    public String getDescripcion() {
        return descripcion;
    }
}
