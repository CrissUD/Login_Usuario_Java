package RecursosGraficos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * @author Cristian
 */
public class ComponentesGraficos {
    private JButton boton;
    private JRadioButton radioBoton;
    private JPanel panel;
    private JScrollPane panelBarra;
    private JLabel label;
    private JTextField texto;
    private JPasswordField textoP;
    private JComboBox combo;
    private JTextArea textoA;
    private JCheckBox check;
    
    public ComponentesGraficos(){
    }
        
    public JButton devolverBoton(String cadena, int x, int y, int ancho, int largo, Cursor mano, ImageIcon imagen, Font fuente, Color colorFondo, Color colorFuente, Border borde,int direccion, int tipo){
        boton= new JButton(cadena);
        boton.setSize(ancho, largo);
        boton.setLocation(x, y);
        boton.setFocusable(false);
        boton.setCursor(mano);
        boton.setFont(fuente);
        boton.setBackground(colorFondo);
        boton.setForeground(colorFuente);
        boton.setIcon(imagen);
        boton.setBorder(borde);
        if(tipo==1){
            boton.setContentAreaFilled(false);
        }
        switch(direccion){
            case 1:
                boton.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case 2:
                boton.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return boton;
    }
    
    public JRadioButton devolverRadioBoton(String cadena, int x, int y, int ancho, int largo, Cursor mano, Font fuente,Color colorFuente){
        radioBoton= new JRadioButton(cadena);
        radioBoton.setSize(ancho, largo);
        radioBoton.setLocation(x, y);
        radioBoton.setFocusable(false);
        radioBoton.setBackground(null);
        radioBoton.setCursor(mano);
        radioBoton.setFont(fuente);
        radioBoton.setForeground(colorFuente);
        return radioBoton;
    }
    
    public JPanel devolverPanel(int x, int y, int ancho, int alto, Color color, Border borde){
        panel = new JPanel(); 
        panel.setSize(ancho, alto);
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(color);
        panel.setBorder(borde);
        return panel;
    }
    
    public JScrollPane devolverPanelBarra(Component componente, int x, int y, int ancho, int alto, Color color, Border borde){
        panelBarra=new JScrollPane(componente);
        panelBarra.setSize(ancho, alto); 
        panelBarra.setLocation(x, y);
        panelBarra.getViewport().setBackground(color);
        panelBarra.setBorder(borde);
        return panelBarra;
    }
    
    public JLabel devolverLabel(String cadena, int x, int y, int ancho, int alto, ImageIcon imagen, Color colorFuente, Color colorFondo,Font fuente){        
        label= new JLabel(cadena);
        label.setSize(ancho, alto);
        label.setLocation(x, y);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        if(imagen!=null)
            label.setIcon(imagen);
        if(colorFondo!=null){
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        return label;
    }
    
    public JTextField devolverTextField(String cadena, int x, int y, int ancho, int alto,Color colorFondo, Color colorFuente, Color colorCaret, Font fuente, Border borde, int direccion){        
        texto = new JTextField();
        texto.setSize(ancho, alto);
        texto.setLocation(x, y);
        texto.setText(cadena);
        texto.setForeground(colorFuente);
        texto.setBackground(colorFondo);
        texto.setFont(fuente);
        texto.setBorder(borde);
        texto.setCaretColor(colorCaret);
        switch(direccion){
            case 1:
                texto.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 2:
                texto.setHorizontalAlignment(SwingConstants.RIGHT);
                break;        
            default:
                break;
        }
        return texto;
    }
    
    public JPasswordField devolverPasswordField(String cadena, int x, int y, int ancho, int alto,Color colorFondo, Color colorFuente, Color colorCaret, Font fuente, Border borde, int direccion){        
        textoP = new JPasswordField();
        textoP.setBounds(x,y, ancho, alto);
        textoP.setText(cadena);
        textoP.setForeground(colorFuente);
        textoP.setBackground(colorFondo);
        textoP.setCaretColor(colorCaret);
        textoP.setBorder(borde);
        switch(direccion){
            case 1:
                textoP.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 2:
                textoP.setHorizontalAlignment(SwingConstants.RIGHT);
                break;        
            default:
                break;
        }
        return textoP;
    }
    
    public JTextArea devolverTextArea(String cadena, int x, int y, int ancho, int alto,Color colorFondo, Color colorFuente, Color colorCaret, Font fuente, Border borde){        
        textoA = new JTextArea();
        textoA.setSize(ancho, alto);
        textoA.setLocation(x, y);
        textoA.setText(cadena);
        textoA.setFont(fuente);
        textoA.setForeground(colorFuente);
        textoA.setBackground(colorFondo);
        textoA.setCaretColor(colorCaret);
        textoA.setBorder(borde);
        return textoA;
    }
    
    public JCheckBox devolverCheckBox(String cadena, int x, int y, int ancho, int largo, Cursor mano, Font fuente,Color colorFuente){
        check= new JCheckBox(cadena);
        check.setSize(ancho, largo);
        check.setLocation(x, y);
        check.setFocusable(false);
        check.setBackground(null);
        check.setCursor(mano);
        check.setFont(fuente);
        check.setForeground(colorFuente);
        return check;
    }
    
    public JComboBox devolverComboBox(String cadena, int x, int y, int ancho, int alto,Color colorFondo, Color colorFuente, int direccion){
        combo=new JComboBox();
        combo.setSize(ancho, alto);
        combo.setLocation(x, y);
        String [] arregloCadena = cadena.split("_");
        for(int i=0; i<arregloCadena.length; i++){
            combo.addItem(arregloCadena[i]);
        } 
        combo.setBackground(colorFondo);
        combo.setForeground(colorFuente);
        for (int i=0; i<combo.getComponentCount(); i++) {
            if (combo.getComponent(i) instanceof AbstractButton)
                ((AbstractButton)combo.getComponent(i)).setBorder(BorderFactory.createLineBorder(colorFuente));
        }
        switch(direccion){
            case 1:
                ((JLabel)combo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 2:
                ((JLabel)combo.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
                break;        
            default:
                break;
        }
        return combo;
    }
}