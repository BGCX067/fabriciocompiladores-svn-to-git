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
public class AFDIdentificador {

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
                    if (Character.isLetter(c)) {
                        estado = 1;
                        token = TOKEN.IDENTIFICADOR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 1:
                    if (Character.isLetter(c)) {
                        estado = 2;
                        token = TOKEN.IDENTIFICADOR;
                    } else if (Character.isDigit(c)) {
                        estado = 3;
                        token = TOKEN.IDENTIFICADOR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 2:
                    if (Character.isLetter(c)) {
                        estado = 2;
                        token = TOKEN.IDENTIFICADOR;
                    } else if (Character.isDigit(c)) {
                        estado = 2;
                        token = TOKEN.IDENTIFICADOR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;

                case 3:
                    if (Character.isLetter(c)) {
                        estado = 3;
                        token = TOKEN.IDENTIFICADOR;
                    } else if (Character.isDigit(c)) {
                        estado = 3;
                        token = TOKEN.IDENTIFICADOR;
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



