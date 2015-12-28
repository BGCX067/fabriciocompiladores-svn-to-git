/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

import analizador.lexico.AnalizadorLexico.TOKEN;
import java.util.StringTokenizer;

/**
 *
 * @author lisset
 */
public class AFDOpLogicos {

    public void verificaTexto(String texto, AnalizadorLexico lex) {
        lex.getLexicos().clear();
        for (StringTokenizer stringTokenizer = new StringTokenizer(texto); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            lex.addLexico(new Lexico(validaToken(token), token));
        }

    }

    public TOKEN validaToken(String palabra) {


        TOKEN token = TOKEN.ERROR;
        int estado = 0;
        for (int i = 0; i < palabra.length(); i++) {
            Character c = palabra.charAt(i);
            switch (estado) {
                case 0:
                    if (c.equals('=')) {
                        estado = 1;
                        token = TOKEN.ASIGNACION;
                    } else if (c.equals('<')) {
                        estado = 3;
                        token = TOKEN.OPERACION_LOGICA;
                    } else if (c.equals('>')) {
                        estado = 4;
                        token = TOKEN.OPERACION_LOGICA;
                    } else if (c.equals('!')) {
                        estado = 5;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 1:
                    if (c.equals('=')) {
                        estado = 2;
                        token = TOKEN.OPERACION_LOGICA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 2:

                    estado = -1;
                    token = TOKEN.ERROR;

                    break;
                case 3:
                    if (c.equals('=')) {
                        estado = 2;
                        token = TOKEN.OPERACION_LOGICA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 4:
                    if (c.equals('=')) {
                        estado = 2;
                        token = TOKEN.OPERACION_LOGICA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 5:
                    if (c.equals('=')) {
                        estado = 6;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 6:
                    if (c.equals('=')) {
                        estado = 2;
                        token = TOKEN.OPERACION_LOGICA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;



                default:
                    token = TOKEN.ERROR;
            }


        }
        return token;

    }
}
