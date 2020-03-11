package Vista;

import RecursosGraficos.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
/**
 *
 * @author Usuario
 */
public class Login extends JFrame implements ActionListener{
    
    private ComponentesGraficos componentes;
    private ComponentesPersonalizados componentesPersonalizados;
    private AdministradorRecursos recursos;
    
    private JPanel panelIzquierda, panelDerecha,panelUsuarioFachada,panelClaveFachada;
    private JLabel labelFondo, labelLogo, labelUsuario,labelClave,labelImagen1,labelImagen2,labelImagen3;
    private JLabel labelTitulo, labelTituloFormulario, labelSubtituloFormulario;
    private ImageIcon imagenFondo, imagenLogo, imagenUsuario1,imagenUsuario2,
                      imagenClave1,imagenClave2, imagenPunto1, imagenPunto2,
                      imagenFacebook1, imagenTwitter1, imagenYoutube1,
                      imagenFacebook2, imagenTwitter2, imagenYoutube2,dimensionAuxiliar,
                      imagenAnimada1,imagenAnimada2,imagenAnimada3;
    private JTextField textoUsuario;
    private JPasswordField textoClave;
    private JButton botonRegistrarse, botonEntrar, botonOpcion1,botonOpcion2,botonOpcion3,
                    botonFacebook,botonTwitter, botonYoutube;
    private MouseListener evento;
    private int estado=0, botonSeleccionado=0,posicionFinal=100;
    private Timer timer;
    
    public Login(){
        componentes= new ComponentesGraficos();
        componentesPersonalizados= new ComponentesPersonalizados();
        recursos=new AdministradorRecursos(componentesPersonalizados);
        evento= this.devolverEvento();
        this.timer=new Timer(1,this);
        this.inicializarComponentes();
    }

    public void inicializarComponentes(){
        
        imagenFondo = new ImageIcon("medios/fondo.png");
        imagenLogo = new ImageIcon("medios/logo.png");
        imagenUsuario1 = new ImageIcon("medios/usuario1.png");
        imagenUsuario2 = new ImageIcon("medios/usuario2.png");
        imagenClave1 = new ImageIcon("medios/clave1.png");
        imagenClave2 = new ImageIcon("medios/clave2.png");
        imagenPunto1 = new ImageIcon("medios/punto1.png");
        imagenPunto2 = new ImageIcon("medios/punto2.png");
        imagenFacebook1 = new ImageIcon("medios/facebook1.png");
        imagenFacebook2 = new ImageIcon("medios/facebook2.png");
        imagenTwitter1 = new ImageIcon("medios/twitter1.png");
        imagenTwitter2 = new ImageIcon("medios/twitter2.png");
        imagenYoutube1 = new ImageIcon("medios/youtube1.png");
        imagenYoutube2 = new ImageIcon("medios/youtube2.png");
        imagenAnimada1 = new ImageIcon("medios/imagen1.png");
        imagenAnimada2 = new ImageIcon("medios/imagen2.png");
        imagenAnimada3 = new ImageIcon("medios/imagen3.png");
        
        panelIzquierda= componentes.devolverPanel(0, 0, 600, 500, null, null);
        this.add(panelIzquierda);
        
        panelDerecha= componentes.devolverPanel(600, 0, 400, 500, null, null);
        this.add(panelDerecha);
        
        dimensionAuxiliar = new ImageIcon(imagenLogo.getImage().
                getScaledInstance(40, 40,Image.SCALE_AREA_AVERAGING));
        labelLogo= componentes.devolverLabel(null, 50, 20, 40, 40, 
                    dimensionAuxiliar, null, null, null);
        panelIzquierda.add(labelLogo);
        
        labelTitulo= componentes.devolverLabel("Login de Usuario", 100, 20, 200, 
                30, null, recursos.getColorBlanco(), null, recursos.getFuenteTitulo2());
        panelIzquierda.add(labelTitulo);
        
        dimensionAuxiliar = new ImageIcon(imagenFondo.getImage().
                getScaledInstance(600, 600,Image.SCALE_AREA_AVERAGING));
        
        labelFondo= componentes.devolverLabel(null, 0, 0, 600, 600, 
                    dimensionAuxiliar, null, null, null);
        panelIzquierda.add(labelFondo);      
        
        dimensionAuxiliar = new ImageIcon(imagenAnimada1.getImage().
                getScaledInstance(500, 345,Image.SCALE_AREA_AVERAGING));
        labelImagen1= componentes.devolverLabel(null, 100, 100, 500, 345, 
                    dimensionAuxiliar, null, null, null);
        labelFondo.add(labelImagen1);  
        
        dimensionAuxiliar = new ImageIcon(imagenAnimada2.getImage().
                getScaledInstance(500, 345,Image.SCALE_AREA_AVERAGING));
        labelImagen2= componentes.devolverLabel(null, 700, 100, 500, 345, 
                    dimensionAuxiliar, null, null, null);
        labelFondo.add(labelImagen2); 
        
        dimensionAuxiliar = new ImageIcon(imagenAnimada3.getImage().
                getScaledInstance(500, 345,Image.SCALE_AREA_AVERAGING));
        labelImagen3= componentes.devolverLabel(null, 1300, 100, 500, 345, 
                    dimensionAuxiliar, null, null, null);
        labelFondo.add(labelImagen3); 
        
        dimensionAuxiliar = new ImageIcon(imagenPunto1.getImage().
                getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
        botonOpcion1= componentes.devolverBoton(null, 10, 220, 30, 20, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonOpcion1.addMouseListener(evento);
        botonOpcion1.addActionListener(this);
        labelFondo.add(botonOpcion1);
        
        botonOpcion2= componentes.devolverBoton(null, 10, 250, 30, 20, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonOpcion2.addMouseListener(evento);
        botonOpcion2.addActionListener(this);
        labelFondo.add(botonOpcion2);
        
        botonOpcion3= componentes.devolverBoton(null, 10, 280, 30, 20, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonOpcion3.addMouseListener(evento);
        botonOpcion3.addActionListener(this);
        labelFondo.add(botonOpcion3);
        
        dimensionAuxiliar = new ImageIcon(imagenFacebook1.getImage().
                getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
        botonFacebook= componentes.devolverBoton(null, 20, 460, 30, 30, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonFacebook.addMouseListener(evento);
        labelFondo.add(botonFacebook);
        
        dimensionAuxiliar = new ImageIcon(imagenTwitter1.getImage().
                getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
        botonTwitter= componentes.devolverBoton(null, 60, 460, 30, 30, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonTwitter.addMouseListener(evento);
        labelFondo.add(botonTwitter);
        
        dimensionAuxiliar = new ImageIcon(imagenYoutube1.getImage().
                getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
        botonYoutube= componentes.devolverBoton(null, 100, 460, 30, 30, recursos.getMano(),
                dimensionAuxiliar, null, null, null, null, 0, 1);
        botonYoutube.addMouseListener(evento);
        labelFondo.add(botonYoutube);
        
        botonRegistrarse= componentes.devolverBoton("Registrarse", 230, 20, 145, 
                35, recursos.getMano(), null, null, recursos.getColorAzul(), recursos.getColorBlanco(),
                recursos.getBordeRedondeado(), 0, 0);
        panelDerecha.add(botonRegistrarse);
        
        labelSubtituloFormulario=componentes.devolverLabel("Te ayudamos en todo", panelDerecha.getWidth()/2-85, 
                100, 160, 20, null, recursos.getColorGrisOscuro(), null, recursos.getFuenteSubtitulo());
        panelDerecha.add(labelSubtituloFormulario);
        
        labelTituloFormulario=componentes.devolverLabel("Registra tus Datos", panelDerecha.getWidth()/2-100, 
                120, 160, 30, null, recursos.getColorGrisOscuro(), null, recursos.getFuenteTitulo2());
        panelDerecha.add(labelTituloFormulario);
       
        panelUsuarioFachada= componentes.devolverPanel(panelDerecha.getWidth()/2-170, 180, 300, 40, 
                recursos.getColorBlanco(), recursos.getBordeRedondeadoLinealGris());
        panelDerecha.add(panelUsuarioFachada);
        
        textoUsuario= componentes.devolverTextField("NombreUsuario", 8, 5, 
                240, 30, recursos.getColorBlanco(), recursos.getColorGrisClaro(), 
                recursos.getColorGrisClaro(), null, null, 0);
        textoUsuario.addMouseListener(evento);
        panelUsuarioFachada.add(textoUsuario);
            
        dimensionAuxiliar = new ImageIcon(imagenUsuario1.getImage().
                getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
        labelUsuario= componentes.devolverLabel(null, 260, 10, 20, 20, dimensionAuxiliar, 
                null, null, null);
        panelUsuarioFachada.add(labelUsuario);
        
        panelClaveFachada= componentes.devolverPanel(panelDerecha.getWidth()/2-170, 240, 300, 40, 
                recursos.getColorBlanco(), recursos.getBordeRedondeadoLinealGris());
        panelDerecha.add(panelClaveFachada);
        
        textoClave= componentes.devolverPasswordField("NombreUsuario", 8, 5, 
                240, 30, recursos.getColorBlanco(), recursos.getColorGrisClaro(), 
                recursos.getColorGrisClaro(), null, null, 0);
        textoClave.addMouseListener(evento);
        panelClaveFachada.add(textoClave);
        
        dimensionAuxiliar = new ImageIcon(imagenClave1.getImage().
                getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
        labelClave= componentes.devolverLabel(null, 260, 10, 20, 20, dimensionAuxiliar, 
                null, null, null);
        panelClaveFachada.add(labelClave);
        
        botonEntrar= componentes.devolverBoton("Entrar", panelDerecha.getWidth()/2-145, 300, 250, 
                45, recursos.getMano(), null, null, recursos.getColorAzul(), recursos.getColorBlanco(),
                recursos.getBordeRedondeado(), 0, 0);
        panelDerecha.add(botonEntrar);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setLayout(null);
        getContentPane().setBackground(recursos.getColorBlanco());
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==botonOpcion1){
            estado= 0;
            botonSeleccionado=0;
            timer.start();
        }
        if(arg0.getSource()==botonOpcion2){
            estado= 1;
            timer.start();
        }
        if(arg0.getSource()==botonOpcion3){
            estado= 2;
            botonSeleccionado=2;
            timer.start();
        }
        moverImagenes();
    }
    
    public MouseListener devolverEvento(){
        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(arg0.getSource()== textoUsuario){
                    panelUsuarioFachada.setBorder(recursos.getBordeRedondeadoLinealAzul());
                    panelClaveFachada.setBorder(recursos.getBordeRedondeadoLinealGris());
                    textoUsuario.setForeground(recursos.getColorAzul());
                    textoClave.setForeground(recursos.getColorGrisClaro());
                    dimensionAuxiliar = new ImageIcon(imagenUsuario2.getImage().
                    getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
                    labelUsuario.setIcon(dimensionAuxiliar);
                    dimensionAuxiliar = new ImageIcon(imagenClave1.getImage().
                    getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
                    labelClave.setIcon(dimensionAuxiliar);
                }
                if(arg0.getSource()== textoClave){
                    panelUsuarioFachada.setBorder(recursos.getBordeRedondeadoLinealGris());
                    panelClaveFachada.setBorder(recursos.getBordeRedondeadoLinealAzul());
                    textoUsuario.setForeground(recursos.getColorGrisClaro());
                    textoClave.setForeground(recursos.getColorAzul());
                    dimensionAuxiliar = new ImageIcon(imagenUsuario1.getImage().
                    getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
                    labelUsuario.setIcon(dimensionAuxiliar);
                    dimensionAuxiliar = new ImageIcon(imagenClave2.getImage().
                    getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));
                    labelClave.setIcon(dimensionAuxiliar);
                }    
            }

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                if(arg0.getSource() instanceof JButton){
                    JButton boton=(JButton) arg0.getSource();
                    if(arg0.getSource()==botonFacebook)
                        dimensionAuxiliar = new ImageIcon(imagenFacebook2.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
                    if(arg0.getSource()==botonTwitter)
                        dimensionAuxiliar = new ImageIcon(imagenTwitter2.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
                    if(arg0.getSource()==botonYoutube)
                        dimensionAuxiliar = new ImageIcon(imagenYoutube2.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));

                    if(arg0.getSource()==botonOpcion1 || arg0.getSource()==botonOpcion2 || arg0.getSource()==botonOpcion3)
                        dimensionAuxiliar = new ImageIcon(imagenPunto2.getImage().
                        getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));

                    boton.setIcon(dimensionAuxiliar);
                }
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                if(arg0.getSource() instanceof JButton){
                    JButton boton=(JButton) arg0.getSource();
                    if(arg0.getSource()==botonFacebook)
                        dimensionAuxiliar = new ImageIcon(imagenFacebook1.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
                    if(arg0.getSource()==botonTwitter)
                        dimensionAuxiliar = new ImageIcon(imagenTwitter1.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
                    if(arg0.getSource()==botonYoutube)
                        dimensionAuxiliar = new ImageIcon(imagenYoutube1.getImage().
                        getScaledInstance(30, 30,Image.SCALE_AREA_AVERAGING));
                    if(arg0.getSource()==botonOpcion1 || arg0.getSource()==botonOpcion2 || arg0.getSource()==botonOpcion3)
                        dimensionAuxiliar = new ImageIcon(imagenPunto1.getImage().
                        getScaledInstance(20, 20,Image.SCALE_AREA_AVERAGING));

                    boton.setIcon(dimensionAuxiliar);
                }   
            }
        };
        return evento;
    }
    
    private void moverImagenes(){
        switch(estado){
            case 0:
                if(labelImagen1.getX()==posicionFinal)
                    timer.stop();
                else{
                    labelImagen1.setLocation(labelImagen1.getX()+1, labelImagen1.getY());
                    labelImagen2.setLocation(labelImagen2.getX()+1, labelImagen2.getY());
                    labelImagen3.setLocation(labelImagen3.getX()+1, labelImagen3.getY());
                }
                break;
            case 1:
                int direccion=0;
                if(botonSeleccionado==0)
                    direccion=-1;
                if(botonSeleccionado==2)
                    direccion=1;
                if(labelImagen2.getX()==posicionFinal)
                    timer.stop();
                else{
                    labelImagen1.setLocation(labelImagen1.getX()+direccion, labelImagen1.getY());
                    labelImagen2.setLocation(labelImagen2.getX()+direccion, labelImagen2.getY());
                    labelImagen3.setLocation(labelImagen3.getX()+direccion, labelImagen3.getY());
                }
                break;
            case 2:
                if(labelImagen3.getX()==posicionFinal)
                    timer.stop();
                else{
                    labelImagen1.setLocation(labelImagen1.getX()-1, labelImagen1.getY());
                    labelImagen2.setLocation(labelImagen2.getX()-1, labelImagen2.getY());
                    labelImagen3.setLocation(labelImagen3.getX()-1, labelImagen3.getY());
                }
                break;
        }
    }
}
