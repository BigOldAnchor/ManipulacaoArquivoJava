import java.io.IOException;
import javax.swing.JOptionPane;

public class ClassePrincipal {
    public static void main(String[] args) throws IOException {
        Aluno[] aluno = new Aluno[3];
        ClasseMetodos m = new ClasseMetodos();
        int opc = 0;
        
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar Aluno\n2 - Ler Aluno\n9 - Finaliza"));
            
            switch (opc) {
                case 1: 
                    aluno = m.GravaAluno(aluno);
                    break;
                case 2:
                    m.LerAluno(aluno);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "FINALIZADO");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
            }
        } while (opc != 9);
    }
}
