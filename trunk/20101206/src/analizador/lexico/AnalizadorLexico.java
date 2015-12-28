/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.lexico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lisset
 */
public class AnalizadorLexico {

    private List<Lexico> lexicos;
    private AFD afd;
    public enum TOKEN {EXP,NUMERO,RESERVADA,OPERACION,NOTACION_CIENTIFICA,ERROR,IDENTIFICADOR,ABRIR_PARENTESIS,CERRAR_PARENTESIS,ASIGNACION,OPERACION_LOGICA,ERROR_SINTACTICO,FIN_EXP,BIEN_ESCRITO};

    public AnalizadorLexico() {
        this.lexicos = new ArrayList<Lexico>();
        this.afd=new AFD();
    }

    public void crearTokens(String texto){
        this.afd.verificaTexto(texto, this);
        
    }

    public void addLexico(Lexico lexico){
        lexicos.add(lexico);
    }

    public List<Lexico> getLexicos() {
        return lexicos;
    }

    public void setLexicos(List<Lexico> lexicos) {
        this.lexicos = lexicos;
    }



}
