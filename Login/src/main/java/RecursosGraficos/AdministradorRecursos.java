package RecursosGraficos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @author Usuario
 */
public class AdministradorRecursos {

    private Color colorAzul, colorAzulOscuro, colorBlanco, colorGrisBlanco,colorGrisClaro,colorGrisOscuro, colorMorado;
    private Font fuenteTitulo, fuenteSubtitulo, fuenteTexto, fuenteTitulo2; 
    private Border bordeGris, bordeInferiorMorado,bordeInferiorAzul, bordeDifuminado,bordeRedondeado,bordeRedondeadoLinealAzul,bordeRedondeadoLinealGris, bordeCircular;   
    private Cursor mano;
    private DefaultTableCellRenderer tablaPersonalizada;
    
    public AdministradorRecursos(ComponentesPersonalizados cPersonalizados){
        fuenteTitulo= new Font("Century Gothic", Font.BOLD,35);
        fuenteTitulo2= new Font("Montserrat", Font.PLAIN,18);
        fuenteSubtitulo= new Font("Forte", Font.PLAIN,13);
        fuenteTexto= new Font("Century Gothic", Font.PLAIN,12);
        colorGrisClaro= new Color(140,140,140);
        colorGrisBlanco=new Color(245,245,245);
        colorGrisOscuro= new Color(80,80,80);
        colorAzul= new Color(60,78,120);
        colorAzulOscuro= new Color(22,46,149);
        colorMorado= new Color (146,38,159);
        colorBlanco= Color.white;
        mano= new Cursor(Cursor.HAND_CURSOR);
        bordeGris= BorderFactory.createLineBorder(colorGrisClaro, 2, true);
        bordeInferiorMorado= BorderFactory.createMatteBorder(0, 0, 3, 0, colorMorado);
        bordeInferiorAzul= BorderFactory.createMatteBorder(0, 0, 3, 0, colorAzul);
        bordeDifuminado= cPersonalizados.devolverBordeDifuminado();
        bordeRedondeado= cPersonalizados.DibujarBordeRedondeado(null,40,2);
        bordeRedondeadoLinealGris= cPersonalizados.DibujarBordeRedondeado(colorGrisClaro,40,0);   
        bordeRedondeadoLinealAzul= cPersonalizados.DibujarBordeRedondeado(colorAzul,40,0); 
        bordeCircular= cPersonalizados.DibujarBordeCircular();
        tablaPersonalizada= cPersonalizados.devolverTablaPersonalizada(colorGrisBlanco, colorBlanco, colorAzul,colorGrisOscuro, fuenteTexto);
    }
    public Color getColorAzul() {
        return colorAzul;
    }

    public Color getColorAzulOscuro() {
        return colorAzulOscuro;
    }

    public Color getColorBlanco() {
        return colorBlanco;
    }

    public Color getColorGrisClaro() {
        return colorGrisClaro;
    }

    public Color getColorGrisOscuro() {
        return colorGrisOscuro;
    }

    public Color getColorMorado() {
        return colorMorado;
    }

    public Font getFuenteTitulo() {
        return fuenteTitulo;
    }

    public Font getFuenteTitulo2() {
        return fuenteTitulo2;
    }
    
    public Font getFuenteSubtitulo() {
        return fuenteSubtitulo;
    }

    public Font getFuenteTexto() {
        return fuenteTexto;
    }

    public Border getBordeGris() {
        return bordeGris;
    }

    public Border getBordeInferior(String color) {
        if(color.equals("Azul"))
            return bordeInferiorAzul;
        if(color.equals("Morado"))
            return bordeInferiorMorado;
        return null;
    }

    public Border getBordeDifuminado() {
        return bordeDifuminado;
    }

    public Border getBordeRedondeado() {
        return bordeRedondeado;
    }

    public Border getBordeRedondeadoLinealGris() {
        return bordeRedondeadoLinealGris;
    }

    public Border getBordeRedondeadoLinealAzul() {
        return bordeRedondeadoLinealAzul;
    }

    public Border getBordeCircular() {
        return bordeCircular;
    }
    
    public Color getColorGrisBlanco() {
        return colorGrisBlanco;
    }
    
    public Cursor getMano() {
        return mano;
    }

    public DefaultTableCellRenderer getTablaPersonalizada() {
        return tablaPersonalizada;
    }
}