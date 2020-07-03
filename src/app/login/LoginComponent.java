package app.login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LoginComponent implements ActionListener, MouseListener, FocusListener {

    private LoginTemplate loginTemplate;
    private JButton boton;
    private JLabel label;
    private JTextField text;
    private JPanel panel;
    private String[] placeholdes = {"Nombre Usuario", "Clave Usuario"};
    private int estado = 1, estadoAnterior = 0, direccion = -1;
    private Timer timer;

    public LoginComponent(){
        this.timer=new Timer(1, this);
        this.loginTemplate = new LoginTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            this.estadoAnterior = estado;
            loginTemplate.getBOpcion(estadoAnterior).setIcon(loginTemplate.getIPunto1());
            if (e.getSource() == loginTemplate.getBOpcion(1)){
                this.estado = 1;
                this.direccion = -1;
            }
            if (e.getSource() == loginTemplate.getBOpcion(2))
                this.estado = 2;
            if (e.getSource() == loginTemplate.getBOpcion(3)){
                this.estado = 3;
                this.direccion = 1;
            }
            loginTemplate.getBOpcion(estado).setIcon(loginTemplate.getIPunto2());
            timer.start();
        }
        moverImagenes();
    }

    @Override
    public void focusGained(FocusEvent e) {
        text = ((JTextField) e.getSource());
        panel = (JPanel) text.getParent();
        label = (JLabel) panel.getComponent(0);
        panel.setBorder(loginTemplate.getRecursosService().getBRedondeadoLinealAzul());
        label.setIcon(loginTemplate.getIBlue(label));
        text.setForeground(loginTemplate.getRecursosService().getColorAzul());
        if(text.getText().equals(placeholdes[0]) || text.getText().equals(placeholdes[1]))
            text.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        text = ((JTextField) e.getSource());
        if(text.getText().equals("")){
            panel = (JPanel) text.getParent();
            label = (JLabel) panel.getComponent(0);
            panel.setBorder(loginTemplate.getRecursosService().getBRedondeadoLinealGris());
            label.setIcon(loginTemplate.getIGray(label));
            text.setForeground(loginTemplate.getRecursosService().getColorGrisOscuro());
            text.setText(placeholdes[0]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource() == loginTemplate.getBEntrar())
            JOptionPane.showMessageDialog(null, "Boton Entrar", "Advertencia", 1);
        if (e.getSource() == loginTemplate.getBCerrar())
            System.exit(0);
        if (e.getSource() == loginTemplate.getBRegistrarse()) 
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
    }

    @Override
    public void mousePressed(MouseEvent e){
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorAzulOscuro());
        }
        if (e.getSource() instanceof JLabel) {
            label = ((JLabel) e.getSource());
            label.setIcon(loginTemplate.getIOrange(label));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorAzul());
        }
        if (e.getSource() instanceof JLabel) {
            label = ((JLabel) e.getSource());
            label.setIcon(loginTemplate.getIWhite(label));
        }
    }

    private void moverImagenes(){
        switch(estado){
            case 1:
                if(loginTemplate.getPSvg().getX() == 100)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() + 1, loginTemplate.getPSvg().getY()
                    );
                break;
            case 2:
                if(loginTemplate.getPSvg().getX() == -500)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() + direccion, loginTemplate.getPSvg().getY()
                    );
                break;
            case 3:
                if(loginTemplate.getPSvg().getX() == -1100)
                    timer.stop();
                else
                    loginTemplate.getPSvg().setLocation(
                        loginTemplate.getPSvg().getX() - 1, loginTemplate.getPSvg().getY()
                    );
                break;
        }
        loginTemplate.repaint();
    }

    public LoginTemplate getLoginTemplate() {
        return this.loginTemplate;
    }
}