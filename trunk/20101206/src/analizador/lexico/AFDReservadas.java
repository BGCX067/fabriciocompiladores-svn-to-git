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
public class AFDReservadas {

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
                    if (c.equals('s')) {
                        estado = 1;
                        token = TOKEN.ERROR;
                    } else if (c.equals('r')) {
                        estado = 6;
                        token = TOKEN.ERROR;
                    } else if (c.equals('m')) {
                        estado = 11;
                        token = TOKEN.ERROR;
                    } else if (c.equals('d')) {
                        estado = 21;
                        token = TOKEN.ERROR;
                    } else if (c.equals('p')) {
                        estado = 27;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 1:
                    if (c.equals('u')) {
                        estado = 2;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 2:
                    if (c.equals('m')) {
                        estado = 3;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;

                case 3:
                    if (c.equals('a')) {
                        estado = 4;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 4:
                    if (c.equals('r')) {
                        estado = 5;
                        token = TOKEN.RESERVADA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 5:

                    estado = -1;
                    token = TOKEN.ERROR;

                    break;
                case 6:
                    if (c.equals('e')) {
                        estado = 7;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 7:
                    if (c.equals('s')) {
                        estado = 8;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;

                case 8:
                    if (c.equals('t')) {
                        estado = 9;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 9:
                    if (c.equals('a')) {
                        estado = 10;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 10:
                    if (c.equals('r')) {
                        estado = 5;
                        token = TOKEN.RESERVADA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 11:
                    if (c.equals('u')) {
                        estado = 12;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 12:
                    if (c.equals('l')) {
                        estado = 13;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 13:
                    if (c.equals('t')) {
                        estado = 14;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 14:
                    if (c.equals('i')) {
                        estado = 15;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 15:
                    if (c.equals('p')) {
                        estado = 16;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 16:
                    if (c.equals('l')) {
                        estado = 17;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 17:
                    if (c.equals('i')) {
                        estado = 18;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 18:
                    if (c.equals('c')) {
                        estado = 19;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 19:
                    if (c.equals('a')) {
                        estado = 20;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 20:
                    if (c.equals('r')) {
                        estado = 5;
                        token = TOKEN.RESERVADA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 21:
                    if (c.equals('i')) {
                        estado = 22;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 22:
                    if (c.equals('v')) {
                        estado = 23;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 23:
                    if (c.equals('i')) {
                        estado = 24;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 24:
                    if (c.equals('d')) {
                        estado = 25;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 25:
                    if (c.equals('i')) {
                        estado = 26;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 26:
                    if (c.equals('r')) {
                        estado = 5;
                        token = TOKEN.RESERVADA;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 27:
                    if (c.equals('o')) {
                        estado = 28;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 28:
                    if (c.equals('t')) {
                        estado = 29;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 29:
                    if (c.equals('e')) {
                        estado = 30;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 30:
                    if (c.equals('n')) {
                        estado = 31;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 31:
                    if (c.equals('c')) {
                        estado = 32;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 32:
                    if (c.equals('i')) {
                        estado = 33;
                        token = TOKEN.ERROR;
                    } else {
                        estado = -1;
                        token = TOKEN.ERROR;
                    }
                    break;
                case 33:
                    if (c.equals('a')) {
                        estado = 5;
                        token = TOKEN.RESERVADA;
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



