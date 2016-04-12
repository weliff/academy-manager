
package br.com.academyflash.GUI;

import br.com.academyflash.business.LoginBO;
import br.com.academyflash.entidades.Login;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LoginTableModel extends AbstractTableModel{
    private List<Login> logins;
    private List<String> colunas;
    
    public LoginTableModel() {
        logins = LoginBO.listarTodos();
        colunas = Arrays.asList("Usuário", "Nivel");
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }
    
    @Override
    public int getRowCount() {
        return logins.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Login login = logins.get(i);
        switch(i1){
            case 0: return login.getUsuario();
            case 1: return getNivel(login);
        }
        return null;
    }
    
    private String getNivel(Login login){
        if(login.getNivel() == 1){
            return "Administrador";
        }else if(login.getNivel() == 2){
            return "Funcionário";
        }
        return "Instrutor";
    }
        
}
