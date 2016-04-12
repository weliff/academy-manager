package br.com.academyflash.GUI;

import br.com.academyflash.business.AlunoBO;
import br.com.academyflash.entidades.Aluno;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel{
    
    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        return alunos;
    }
    private List<String> colunas;

    public AlunoTableModel(){
        alunos = AlunoBO.listarTodos();
        colunas = Arrays.asList("Nome", "CPF", "RG", "Genero", "Nome Instrutor", "Turno", "Data Inscrição");
                
    }
    
    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }
    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Aluno aluno = alunos.get(i);
        switch(i1){
            case 0: return aluno.getNome();
            case 1: return aluno.getCpf();
            case 2: return aluno.getRg();
            case 3: return aluno.getGenero();
            case 4: return aluno.getNomeDoInstrutor();
            case 5: return aluno.getTurno();
            case 6: return aluno.getDataDeInscricao();
        }
        return null;
    }
    
}
