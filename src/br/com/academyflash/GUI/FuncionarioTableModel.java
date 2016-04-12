package br.com.academyflash.GUI;

import br.com.academyflash.business.FuncionarioBO;
import br.com.academyflash.entidades.Funcionario;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel{
    
    private List<Funcionario> funcionarios;
    private List<String> colunas;
    
    public FuncionarioTableModel() {
        funcionarios = FuncionarioBO.listarTodos();
        colunas = Arrays.asList("Nome", "CPF", "RG", "Genero", "Função", "Data Contrato");
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Funcionario funcionario = funcionarios.get(i);
        switch(i1){
            case 0: return funcionario.getNome();
            case 1: return funcionario.getCpf();
            case 2: return funcionario.getRg();
            case 3: return funcionario.getGenero();
            case 4: return funcionario.getFuncao();
            case 5: return funcionario.getData_contrato();
        }
        return null;
    }
}