package Controlador;

import Modelo.Acceso;
import Modelo.DAO.AccesoDAO;
import Modelo.DAO.DAOManager;
import Modelo.DAO.EmpleadoDAO;
import Modelo.Empleado;
import Vista.AccesoView;
import Vista.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Javicuc
 */
public class AccesoController implements ActionListener {
    
    private Acceso      unObj;
    private AccesoDAO   objDAO;
    private AccesoView  objVista;
    private EmpleadoDAO empDAO;
    
    //private JLabel btnEntra;
    private JButton btnEntrar;
    private JPasswordField pass;
    private JTextField user;
    
    public AccesoController() {
        this.objDAO = new DAOManager().getAccesoDAO();
        this.empDAO = new DAOManager().getEmpleadoDAO();
        this.objVista = new AccesoView();
        
        this.objVista.setVisible(true);
        this.btnEntrar     = objVista.getBtnEntrar();
        this.pass          = objVista.getTFContraseña();
        this.user          = objVista.getTFUsuario();
        this.btnEntrar.addActionListener(this);
        //this.btnEntrar.addKeyListener((KeyListener) this);
        this.pass.addActionListener(this);
        this.user.addActionListener(this);
        //this.btnEntra      = objVista.getBtnEntra();        
        //this.btnEntra.addActionListener(this);
    }
    void EntrarActionPerformed() {
        try {
            unObj = getAcceso();
            if(objDAO.alreadyExisting(unObj)){
                unObj = objDAO.readByID(unObj);
                Empleado emp = empDAO.readByID(unObj.getFK_Empleado());
                objVista.dispose();
                System.out.println(unObj);
                System.out.println(emp);
                MainView main = new MainView(emp);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos...\nVuelve a intentarlo!!!");
                user.setText("");
                pass.setText("");
                objVista.setTFUsuario(user);
                objVista.setTFContraseña(pass);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Acceso getAcceso() {
        user = objVista.getTFUsuario();
        char[] c = objVista.getTFContraseña().getPassword();
        String contraseña = new String(c);
        return new Acceso(user.getText(),contraseña);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnEntrar)
            EntrarActionPerformed();
        else if(source == pass)
            EntrarActionPerformed();
        else if(source == user)
            EntrarActionPerformed();
    }
    
}