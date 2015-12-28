/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.lexico;



import analizador.lexico.AnalizadorLexico.TOKEN;
import java.util.StringTokenizer;


public class AFD {
    public void verificaTexto(String texto, AnalizadorLexico lex){
        lex.getLexicos().clear();
        for (StringTokenizer stringTokenizer = new StringTokenizer(texto); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            lex.addLexico(new Lexico(validaToken(token), token));
        }

    }

     private TOKEN validaToken(String palabra){
        TOKEN token = TOKEN.ERROR;
        token=new AFDSignos().validaToken(palabra);
        
        if(token==TOKEN.ERROR){
            token= new AFDNumeros().validaToken(palabra);
        }
        if(token==TOKEN.ERROR){
            token= new AFDReservadas().validaToken(palabra);
        }
        if(token==TOKEN.ERROR){
            token= new AFDIdentificador().validaToken(palabra);
        }
        if(token==TOKEN.ERROR){
            token=new AFDOpLogicos().validaToken(palabra);
        }



        return token;

    }


}
