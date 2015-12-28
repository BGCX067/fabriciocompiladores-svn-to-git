/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import javax.swing.text.AbstractDocument;
import javax.swing.text.BoxView;
import javax.swing.text.Element;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 *
 * @author Fabricio
 */
public class BarraHorizontal extends StyledEditorKit {

    private EditorViewFactory vista;

    public BarraHorizontal() {
        vista = new EditorViewFactory();
    }

    @Override
    public ViewFactory getViewFactory() {
        return vista;
    }
}

class EditorViewFactory implements ViewFactory {

    public View create(Element elem) {
        String nombre = elem.getName();
        if (nombre != null) {
            if (nombre.equals(AbstractDocument.ParagraphElementName)) {
                return new VistaParrafo(elem);
            } else if (nombre.equals(AbstractDocument.SectionElementName)) {
                return new BoxView(elem, View.Y_AXIS);  //para los estilos
            }
        }
        return new LabelView(elem);
    }
}

class VistaParrafo extends ParagraphView {

    public VistaParrafo(Element elem) {
        super(elem);
    }

    @Override
    public void layout(int ancho, int altura) {
        //para que el textpane no quiebre la linea
        super.layout(Short.MAX_VALUE, altura);
    }

    @Override
    public float getMinimumSpan(int eje) {
        float span = super.getPreferredSpan(eje);
        if (eje == View.X_AXIS) {
            span = span + 10;
        }
        return span;
    }
}
