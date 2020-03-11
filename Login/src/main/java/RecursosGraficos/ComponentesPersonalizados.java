package RecursosGraficos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Usuario
 */
public class ComponentesPersonalizados {

    public Border devolverBordeDifuminado(){
       Border borde1=  BorderFactory.createLineBorder(new Color(246,243,247),1,true);
       Border borde2=  BorderFactory.createLineBorder(new Color(241,238,242),1,true);
       Border borde3=  BorderFactory.createCompoundBorder(borde2,borde1);
       Border borde4=  BorderFactory.createLineBorder(new Color(244,240,244),1,true);
       Border borde5=  BorderFactory.createCompoundBorder(borde4,borde3);
       Border borde6=  BorderFactory.createCompoundBorder(borde1,borde5);
       Border borde7=  BorderFactory.createLineBorder(new Color(251,247,251),1,true);
       Border borde8=  BorderFactory.createCompoundBorder(borde7,borde6);
       Border borde9=  BorderFactory.createLineBorder(new Color(252,248,252),1,true);
       Border borde10= BorderFactory.createCompoundBorder(borde9,borde8);
       Border borde11= BorderFactory.createLineBorder(new Color(253,249,253),1,true);
       Border borde12= BorderFactory.createCompoundBorder(borde11,borde10);
       Border borde13= BorderFactory.createLineBorder(new Color(254,250,254),1,true);
       Border borde14= BorderFactory.createCompoundBorder(borde13,borde12);
       Border borde15= BorderFactory.createLineBorder(new Color(255,251,255),1,true);
       Border bordeFinal = BorderFactory.createCompoundBorder(borde15,borde14);
       return bordeFinal;
    }
    
    public Border DibujarBordeRedondeado (Color color,int radio,int opcion) {
        Border b = new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int ancho, int alto) {
                Graphics2D g2= (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                g2.setPaint(color);
                RoundRectangle2D rectangulo= new RoundRectangle2D.Double();
                rectangulo.setRoundRect(x, y, ancho-1, alto-1, radio, radio);
                Area area = new Area(rectangulo);
                Component parent  = c.getParent();
                if (parent!=null) {
                    Color bg = parent.getBackground();
                    Rectangle rect = new Rectangle(0,0,ancho, alto);
                    Area borderRegion = new Area(rect);
                    borderRegion.subtract(area);
                    g2.setClip(borderRegion);
                    if(opcion==1){
                        ImageIcon yourImage=(ImageIcon)((JLabel) parent).getIcon();   
                        Image image = yourImage.getImage();
                        g2.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null),c.getX(), c.getY(), image.getWidth(null)+c.getX(), image.getHeight(null)+c.getY(),c);
                    }
                    if(opcion==2){
                        g2.setColor(bg);
                        g2.fillRect(0, 0, ancho, alto);
                    }
                    g2.setClip(null);
                }       
                g2.draw(area);
            }

            @Override
            public Insets getBorderInsets(Component cmpnt) {
                return new Insets(radio+1, radio+1, radio+2, radio);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }
        } ;
        return b;
    }
    
    public AbstractBorder DibujarBordeCircular() {
        AbstractBorder b= new AbstractBorder() {
        
            @Override
            public void paintBorder(Component c,Graphics g,int x, int y, int ancho, int alto) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                Ellipse2D circle2D = new Ellipse2D.Double();//java2d
                //dibuja el circulo en toda su extensión
                circle2D.setFrameFromCenter( 
                    new Point(x+ancho/2,y+alto/2), //centro 
                    new Point( ancho , alto) //ancho y alto
                );                         
                Area area = new Area(circle2D);        
                //pinta el fondo con el color del componente padre 
                Component parent  = c.getParent();
                if (parent!=null) {
                    Color bg = parent.getBackground();
                    Rectangle rect = new Rectangle(0,0,ancho, alto);
                    Area borderRegion = new Area(rect);
                    borderRegion.subtract(area);
                    g2.setClip(borderRegion);
                    g2.setColor(bg);
                    g2.fillRect(0, 0, ancho, alto);
                    g2.setClip(null);
                }                       
                g2.draw(area);
            }
        };
        return b;
    }      
    
    public DefaultTableCellRenderer devolverTablaPersonalizada(Color color1, Color color2,Color colorSeleccion, Color colorFuente,Font fuente){
        class MiRender extends DefaultTableCellRenderer{
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
               int row,int column){
               JLabel cell= (JLabel)super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
               this.setOpaque(true);
               this.setFont(fuente);
               this.setHorizontalAlignment(SwingConstants.CENTER);
               if (row%2==0){
                    this.setBackground(color1);
                    this.setForeground(colorFuente);
               } 
               else{
                    this.setBackground(color2);
                    this.setForeground(colorFuente);
               }
               if(isSelected==true){
                   this.setBackground(colorSeleccion);
                   this.setForeground(color2);
               }
               return this;
            }
        }
        return new MiRender();
    }
}
