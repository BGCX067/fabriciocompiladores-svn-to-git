package analizadorlexico;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Estilos {

    public static SimpleAttributeSet COLOR_RESERVADA;
    public static SimpleAttributeSet COLOR_NUMERO;
    public static SimpleAttributeSet COLOR_OPERADOR;
    public static SimpleAttributeSet COLOR_ERROR;
    public static SimpleAttributeSet COLOR_NORMAL;

    static {
        COLOR_NORMAL = new SimpleAttributeSet();
        COLOR_RESERVADA = new SimpleAttributeSet(COLOR_NORMAL);
        COLOR_NUMERO = new SimpleAttributeSet(COLOR_NORMAL);
        COLOR_OPERADOR = new SimpleAttributeSet(COLOR_NORMAL);
        COLOR_ERROR = new SimpleAttributeSet(COLOR_NORMAL);

        StyleConstants.setForeground(COLOR_NORMAL, Color.BLACK);
        StyleConstants.setForeground(COLOR_RESERVADA, Color.BLUE);
        StyleConstants.setItalic(COLOR_RESERVADA, false);
        StyleConstants.setForeground(COLOR_OPERADOR, Color.GREEN);
        StyleConstants.setItalic(COLOR_OPERADOR, false);
        StyleConstants.setForeground(COLOR_NUMERO, Color.ORANGE);
        StyleConstants.setItalic(COLOR_NUMERO, false);
        StyleConstants.setForeground(COLOR_ERROR, Color.RED);
        StyleConstants.setItalic(COLOR_ERROR, false);
    }
}
