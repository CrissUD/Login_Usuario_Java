package app.login;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import app.services.ObjGraficosService;
import app.services.RecursosService;

public class LoginTemplate extends JFrame{
    
    private static final long serialVersionUID = -2376574374287235404L;
    // Declaración servicios
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private LoginComponent loginComponent;

    // Declaración Objetos Gráficos
    private JPanel pIzquierda, pDerecha, pSvg, pUsuario, pClave;
    private JLabel lFondo, lLogo, lUsuario, lClave, lSvg1, lSvg2, lSvg3, lFacebook, lTwitter, lYoutube;
    private JLabel lTituloApp, lTituloLogin, lEslogan, lNotificaciones;
    private JTextField tUsuario;
    private JPasswordField tClave;
    private JButton bRegistrarse, bEntrar, bCerrar;
    private JButton bOpcion1, bOpcion2, bOpcion3;
    private JRadioButton rbSi, rbNo;
    private ButtonGroup grupo;

    // Declaración Objetos Decoradores
    private ImageIcon iFondo, iLogo, iUsuario1, iUsuario2, iClave1, iClave2, iPunto1, iPunto2;
    private ImageIcon iFacebook1, iFacebook2, iTwitter1, iTwitter2, iYoutube1, iYoutube2;
    private ImageIcon iSvg1, iSvg2, iSvg3, iDimAux;

    public LoginTemplate(LoginComponent loginComponent){
        this.loginComponent = loginComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJButtons();
        this.pIzquierda.add(pSvg);
        this.crearJLabels();
        this.crearFields();
        this.crearJRadioButtons();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void crearObjetosDecoradores(){
        iFondo = new ImageIcon("resources/images/fondo.png");
        iLogo = new ImageIcon("resources/images/logo.png");
        iUsuario1 = new ImageIcon("resources/images/usuario1.png");
        iUsuario2 = new ImageIcon("resources/images/usuario2.png");
        iClave1 = new ImageIcon("resources/images/clave1.png");
        iClave2 = new ImageIcon("resources/images/clave2.png");
        iPunto1 = new ImageIcon("resources/images/punto1.png");
        iPunto2 = new ImageIcon("resources/images/punto2.png");
        iFacebook1 = new ImageIcon("resources/images/facebook1.png");
        iFacebook2 = new ImageIcon("resources/images/facebook2.png");
        iTwitter1 = new ImageIcon("resources/images/twitter1.png");
        iTwitter2 = new ImageIcon("resources/images/twitter2.png");
        iYoutube1 = new ImageIcon("resources/images/youtube1.png");
        iYoutube2 = new ImageIcon("resources/images/youtube2.png");
        iSvg1 = new ImageIcon("resources/images/imagen1.png");
        iSvg2 = new ImageIcon("resources/images/imagen2.png");
        iSvg3 = new ImageIcon("resources/images/imagen3.png");
    }

    public void crearJPanels(){

        pIzquierda = sObjGraficos.construirJPanel(
            0, 0, 600, 500, Color.WHITE, null
        );
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(
            600, 0, 400, 500, Color.WHITE, null
        );
        this.add(pDerecha);

        pSvg = sObjGraficos.construirJPanel(
            100, 100, 1700, 345, new Color(0, 0, 0, 0), null
        );

        pUsuario = sObjGraficos.construirJPanel(
            pDerecha.getWidth()/2 - 170, 180, 300, 40, Color.WHITE, sRecursos.getBRedondeadoLinealGris()
        );
        pDerecha.add(pUsuario);

        pClave = sObjGraficos.construirJPanel(
            pDerecha.getWidth()/2-170, 240, 300, 40, Color.WHITE, sRecursos.getBRedondeadoLinealGris()
        );
        pDerecha.add(pClave);
    }

    public void crearJButtons(){
        //BOTÓN ENTRAR-----------------------------------------------------------------------------
        bEntrar = sObjGraficos.construirJButton(
            "Entrar", pDerecha.getWidth()/2-145, 310, 250, 45, sRecursos.getCMano(), null,
            null, sRecursos.getColorAzul(), Color.WHITE, sRecursos.getBRedondeado(), "c", true
        );
        bEntrar.addMouseListener(loginComponent);
        pDerecha.add(bEntrar);

        //BOTÓN CERRAR-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            sRecursos.getICerrar().getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
            null, 350, 10, 45, 30, sRecursos.getCMano(), iDimAux, null, null, null, null, "c", false
        );
        bCerrar.addMouseListener(loginComponent);
        pDerecha.add(bCerrar);

        //BOTÓN REGISTRARSE-----------------------------------------------------------------------
        bRegistrarse = sObjGraficos.construirJButton(
            "Registrarse", 240, 460, 145, 35, sRecursos.getCMano(), null, null, 
            sRecursos.getColorAzul(), Color.WHITE, sRecursos.getBRedondeado(), "c", true
        );
        bRegistrarse.addMouseListener(loginComponent);
        pDerecha.add(bRegistrarse);

        iDimAux = new ImageIcon(iPunto2.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));

        //BOTÓN OPCIÓN 1-----------------------------------------------------------------------------
        bOpcion1 = sObjGraficos.construirJButton(
            null, 10, 220, 30, 20, sRecursos.getCMano(), iDimAux, null, null, null, null, "c", false
        );
        bOpcion1.addActionListener(loginComponent);
        pIzquierda.add(bOpcion1);

        iDimAux = new ImageIcon(iPunto1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));

        //BOTÓN OPCIÓN 2-----------------------------------------------------------------------------
        bOpcion2 = sObjGraficos.construirJButton(
            null, 10, 250, 30, 20, sRecursos.getCMano(), iDimAux, null, null, null, null, "c", false
        );
        bOpcion2.addActionListener(loginComponent);
        pIzquierda.add(bOpcion2);

        //BOTÓN OPCIÓN 3-----------------------------------------------------------------------------
        bOpcion3 = sObjGraficos.construirJButton(
            null, 10, 280, 30, 20, sRecursos.getCMano(), iDimAux, null, null, null, null, "c", false
        );
        bOpcion3.addActionListener(loginComponent);
        pIzquierda.add(bOpcion3);
    }

    public void crearJLabels(){
        //LABEL LOGO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iLogo.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING));
        lLogo= sObjGraficos.construirJLabel(null, 50, 20, 40, 40, iDimAux, null, null, null, "c");
        pIzquierda.add(lLogo);

        //LABEL TITULO APP-----------------------------------------------------------------------------
        lTituloApp = sObjGraficos.construirJLabel(
            "Login de Usuario", 100, 20, 220, 30, null, Color.WHITE, null, sRecursos.getFontTPrincipal(), "c"
        );
        pIzquierda.add(lTituloApp);

        //LABEL SVG-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iSvg1.getImage().getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING));
        lSvg1= sObjGraficos.construirJLabel(null, 0, 0, 500, 345, iDimAux, null, null, null, "c");
        pSvg.add(lSvg1);

        //LABEL SVG 2-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iSvg2.getImage().getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING));
        lSvg2= sObjGraficos.construirJLabel(null, 600, 0, 500, 345, iDimAux, null, null, null, "c");
        pSvg.add(lSvg2);

        //LABEL SVG 3-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iSvg3.getImage().getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING));
        lSvg3= sObjGraficos.construirJLabel(null, 1200, 0, 500, 345, iDimAux, null, null, null, "c");
        pSvg.add(lSvg3);

        //LABEL ESLOGAN-----------------------------------------------------------------------------
        lEslogan = sObjGraficos.construirJLabel(
            "Te ayudamos en todo", pDerecha.getWidth()/2 - 85, 100, 130, 20, 
            null, sRecursos.getColorGrisOscuro(), null, sRecursos.getFontSubtitulo(), "c"
        );
        pDerecha.add(lEslogan);

        //LABEL TITULO LOGIN-----------------------------------------------------------------------------
        lTituloLogin = sObjGraficos.construirJLabel(
            "Registra tus Datos", pDerecha.getWidth()/2 - 100, 120, 150, 30, 
            null, sRecursos.getColorGrisOscuro(), null, sRecursos.getFontTitulo(), "c"
        );
        pDerecha.add(lTituloLogin);

        //LABEL NOTIFICACIONES-----------------------------------------------------------------------------
        lNotificaciones = sObjGraficos.construirJLabel(
            "¿Recibir Notificaciones?", (pDerecha.getWidth() - 180) / 2, 380, 140, 20, 
            null, sRecursos.getColorGrisOscuro(), null, sRecursos.getFontSubtitulo(), "c"
        );
        pDerecha.add(lNotificaciones);

        //LABEL USUARIO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iUsuario1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        lUsuario= sObjGraficos.construirJLabel(null, 260, 10, 20, 20, iDimAux, null, null, null, "c");
        pUsuario.add(lUsuario);

        //LABEL CLAVE-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iClave1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        lClave= sObjGraficos.construirJLabel(null, 260, 10, 20, 20, iDimAux, null, null, null, "c");
        pClave.add(lClave);

        //LABEL FACEBOOK-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iFacebook1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lFacebook= sObjGraficos.construirJLabel(null, 20, 460, 30, 30, iDimAux, null, null, null, "c");
        lFacebook.setCursor(sRecursos.getCMano());
        lFacebook.addMouseListener(loginComponent);
        pIzquierda.add(lFacebook);

        //LABEL TWITTER-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iTwitter1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lTwitter= sObjGraficos.construirJLabel(null, 60, 460, 30, 30, iDimAux, null, null, null, "c");
        lTwitter.setCursor(sRecursos.getCMano());
        lTwitter.addMouseListener(loginComponent);
        pIzquierda.add(lTwitter);

        //LABEL YOUTUBE-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iYoutube1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lYoutube= sObjGraficos.construirJLabel(null, 100, 460, 30, 30, iDimAux, null, null, null, "c");
        lYoutube.setCursor(sRecursos.getCMano());
        lYoutube.addMouseListener(loginComponent);
        pIzquierda.add(lYoutube);

        //LABEL FONDO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iFondo.getImage().getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING));
        lFondo= sObjGraficos.construirJLabel(null, 0, 0, 600, 600, iDimAux, null, null, null, "c");
        pIzquierda.add(lFondo);
    }

    public void crearFields(){
        tUsuario= sObjGraficos.construirJTextField(
            "Nombre Usuario", 15, 5, 240, 30, Color.WHITE, sRecursos.getColorGrisOscuro(), 
            sRecursos.getColorGrisOscuro(), null, null, "l"
        );
        tUsuario.addFocusListener(loginComponent);
        pUsuario.add(tUsuario);

        tClave= sObjGraficos.construirJPasswordField(
            "Clave Usuario", 15, 5, 240, 30, Color.WHITE, sRecursos.getColorGrisOscuro(), 
            sRecursos.getColorGrisOscuro(), null, null, "l"
        );
        tClave.addFocusListener(loginComponent);
        pClave.add(tClave);
    }

    public void crearJRadioButtons(){

        rbSi = sObjGraficos.construirJRadioButton(
            "Si", (pDerecha.getWidth() - 45) / 2 - 40, 355, 45, 25, sRecursos.getCMano(), null, null
        );
        pDerecha.add(rbSi);

        rbNo = sObjGraficos.construirJRadioButton(
            "No", (pDerecha.getWidth() + 45) / 2 - 40, 355, 45, 25, sRecursos.getCMano(), null, null
        );
        pDerecha.add(rbNo);

        grupo = new ButtonGroup();
        grupo.add(rbSi);
        grupo.add(rbNo);
    }

    public ImageIcon getIGray(JLabel label){
        if(label == lUsuario)
            iDimAux = new ImageIcon(iUsuario1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        if(label == lClave)
            iDimAux = new ImageIcon(iClave1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public ImageIcon getIBlue(JLabel label){
        if(label == lUsuario)
            iDimAux = new ImageIcon(iUsuario2.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        if(label == lClave)
            iDimAux = new ImageIcon(iClave2.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public ImageIcon getIWhite(JLabel label){
        if(label == lFacebook)
            iDimAux = new ImageIcon(iFacebook1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        if(label == lTwitter)
            iDimAux = new ImageIcon(iTwitter1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        if(label == lYoutube)
            iDimAux = new ImageIcon(iYoutube1.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public ImageIcon getIOrange(JLabel label){
        if(label == lFacebook)
            iDimAux = new ImageIcon(iFacebook2.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        if(label == lTwitter)
            iDimAux = new ImageIcon(iTwitter2.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        if(label == lYoutube)
            iDimAux = new ImageIcon(iYoutube2.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public ImageIcon getIPunto1(){
        iDimAux = new ImageIcon(iPunto1.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public ImageIcon getIPunto2(){
        iDimAux = new ImageIcon(iPunto2.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        return iDimAux;
    }

    public JButton getBCerrar(){
        return this.bCerrar;
    }

    public JButton getBEntrar(){
        return this.bEntrar;
    }

    public JButton getBRegistrarse(){
        return this.bRegistrarse;
    }

    public JButton getBOpcion(int boton){
        if(boton == 1)
            return this.bOpcion1;
        if(boton == 2)
            return this.bOpcion2;
        if(boton == 3)
            return this.bOpcion3;
        return null;
    }

    public JPanel getPSvg(){
        return this.pSvg;
    }

    public RecursosService getRecursosService(){
        return sRecursos;
    }
}