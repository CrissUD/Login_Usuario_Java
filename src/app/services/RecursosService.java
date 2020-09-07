package app.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

import javax.swing.border.Border;
import javax.swing.ImageIcon;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class RecursosService {

    // Declaración Servicios
    private GraficosAvanzadosService sGraficosAvanzados;

    // Declaración Objetos Decoradores
    private Color colorAzul, colorAzulOscuro, colorMorado, colorGrisOscuro, colorGrisClaro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo, fontBotones;
    private Cursor cMano;
    private Border bRedondeado, bRedondeadoLinealGris, bRedondeadoLinealAzul;
    private ImageIcon iCerrar;

    static private RecursosService servicio;

    private RecursosService(){
        sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.generarFuente();
        colorMorado = new Color(151, 0, 158);
        colorAzul = new Color(60, 78, 120);
        colorAzulOscuro = new Color(30, 48, 90);
        colorGrisOscuro = new Color(110, 110, 110);
        colorGrisClaro = new Color(245, 245, 245);
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("LuzSans-Book", Font.BOLD, 17);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        fontBotones = new Font("LuzSans-Book", Font.PLAIN, 15);
        cMano = new Cursor(Cursor.HAND_CURSOR);
        bRedondeado= sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, false, null);
        bRedondeadoLinealGris= sGraficosAvanzados.DibujarBordeRedondeado(colorGrisOscuro, 40, true, false, null);
        bRedondeadoLinealAzul= sGraficosAvanzados.DibujarBordeRedondeado(colorAzul, 40, true, false, null);
        iCerrar = new ImageIcon("resources/images/cerrar.png");
    }

    public void generarFuente(){
        try {
            GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/LUZRO.ttf")));
        } catch (IOException|FontFormatException e) {
                //Handle exception
        }
    }
    
    public Color getColorMorado(){
        return colorMorado;
    }

    public Color getColorAzul(){
        return colorAzul;
    }

    public Color getColorAzulOscuro(){
        return colorAzulOscuro;
    }

    public Color getColorGrisOscuro(){
        return colorGrisOscuro;
    }

    public Color getColorGrisClaro(){
        return colorGrisClaro;
    }

    public Font getFontTPrincipal(){
        return fontTPrincipal;
    }

    public Font getFontTitulo(){
        return fontTitulo;
    }
    
    public Font getFontSubtitulo(){
        return fontSubtitulo;
    }
    
    public Font getFontBotones(){
        return fontBotones;
    }

    public Cursor getCMano(){
        return cMano;
    }

    public Border getBRedondeado(){
        return bRedondeado;
    }

    public Border getBRedondeadoLinealGris(){
        return bRedondeadoLinealGris;
    }

    public Border getBRedondeadoLinealAzul(){
        return bRedondeadoLinealAzul;
    }

    public ImageIcon getICerrar(){
        return iCerrar;
    }

    public static RecursosService getService(){
        if(servicio == null)
            servicio = new RecursosService();
        return servicio;
    }
}