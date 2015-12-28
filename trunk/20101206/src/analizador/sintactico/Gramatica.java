/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.sintactico;

import analizador.lexico.Lexico;
import analizador.lexico.AnalizadorLexico.TOKEN;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class Gramatica {

    private int indice = 0;
    ArrayList<Lexico> lexemas;
    ArrayList<ErrorSintaxis> errores;
    public static final TOKEN NO_TERMINAL = TOKEN.EXP;
    private static TOKEN[][] reglas = {
        {TOKEN.RESERVADA, TOKEN.ABRIR_PARENTESIS, NO_TERMINAL, NO_TERMINAL, TOKEN.CERRAR_PARENTESIS},
        {TOKEN.ABRIR_PARENTESIS, NO_TERMINAL, TOKEN.CERRAR_PARENTESIS},
        {NO_TERMINAL, TOKEN.OPERACION, NO_TERMINAL},
        {TOKEN.IDENTIFICADOR, TOKEN.ASIGNACION, NO_TERMINAL},
        {TOKEN.NUMERO},
        {TOKEN.IDENTIFICADOR},};

    public Gramatica(ArrayList<Lexico> lexemas) {
        this.lexemas = lexemas;
        errores = new ArrayList<ErrorSintaxis>();
        indice = -1;
    }

    public ArrayList<ErrorSintaxis> analiza() {
        while (indice < lexemas.size() - 1) {
            indice++;
            if (valida()) {
                if (indice < lexemas.size()) {
                    TOKEN token = lexemas.get(indice).getToken();
                    if (!token.equals(TOKEN.FIN_EXP)) {
                        errores.add(new ErrorSintaxis(TOKEN.FIN_EXP, lexemas.get(indice - 1)));
                        indice--;
                    }
                } else {
                    errores.add(new ErrorSintaxis(TOKEN.FIN_EXP, lexemas.get(indice - 1)));
                }
            }
        }

        return errores;
    }

    private boolean valida() {
        int regla;
        TOKEN token1 = null, token2 = null, aux;
        TOKEN produccion[];

        if (indice < lexemas.size()) {
            token1 = lexemas.get(indice).getToken();
        }
        if (indice + 1 < lexemas.size()) {
            token2 = lexemas.get(indice + 1).getToken();
        }
        indice++;

        regla = getProduccion(token1, token2);

        if (regla == -1) {

            errores.add(new ErrorSintaxis((TOKEN) NO_TERMINAL, lexemas.get(indice - 1)));
            return false;
        }

        produccion = reglas[regla];

        for (int i = 1; i < produccion.length; i++) {
            aux = produccion[i];
            if (indice < lexemas.size()) {
                token1 = lexemas.get(indice).getToken();


                if (aux.equals(NO_TERMINAL)) {
                    if (!valida());
                    indice--;
                } else if (!token1.equals(aux)) {
                    errores.add(new ErrorSintaxis(aux, lexemas.get(indice)));
                    indice--;

                }
                indice++;
            } else {
                errores.add(new ErrorSintaxis(aux, lexemas.get(indice - 1)));

            }
        }

        if (indice < lexemas.size()) {
            token1 = lexemas.get(indice).getToken();
            regla = getProduccion((TOKEN) NO_TERMINAL, token1);
            if (regla != -1) {
                indice--;
                if (!valida()) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getProduccion(TOKEN token1, TOKEN token2) {
        TOKEN prod1, prod2;

        for (int i = 0; i < reglas.length; i++) {
            prod1 = (TOKEN) reglas[i][0];
            if (token1.equals(TOKEN.ERROR)) {
                break;
            } else if (prod1.equals(NO_TERMINAL)) {
                prod2 = (TOKEN) reglas[i][1];
                if (prod2.equals(token2) || prod2.equals(NO_TERMINAL)) {
                    return i;
                }
            } else if (token1.equals(prod1)) {
                return i;
            }
        }
        return -1;
    }
}
