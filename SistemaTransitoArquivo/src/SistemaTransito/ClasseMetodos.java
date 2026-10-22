package SistemaTransito;

import java.io.*;
import javax.swing.*;

public class ClasseMetodos {
    public Estatistica[] gravaEstatistica(Estatistica[] estatisticas)  throws IOException{
        String fileName = "ArquivoEstatistica.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < estatisticas.length; i++) { estatisticas[i] = new Estatistica();}
        for (int i = 0; i < estatisticas.length; i++) {
            estatisticas[i].CodigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da cidade:"));
            gravar.write(Integer.toString(estatisticas[i].CodigoCidade));
            gravar.newLine();
            
            estatisticas[i].NomeCidade = JOptionPane.showInputDialog("Digite o nome da cidade:");
            gravar.write(estatisticas[i].NomeCidade);
            gravar.newLine();
            
            estatisticas[i].QtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes:"));
            gravar.write(Integer.toString(estatisticas[i].QtdAcidentes));
            gravar.newLine();
        }
        gravar.close();
        return estatisticas;
    }

    public void consultarPorQuantidadeAcidentes(Estatistica[] estatisticas) {
        for (int i = 0; i < estatisticas.length; i++) {
            if (estatisticas[i].QtdAcidentes > 100 && estatisticas[i].QtdAcidentes < 500) {
                JOptionPane.showMessageDialog(null, "Cidade: " + estatisticas[i].NomeCidade + "\nQuantidade de Acidentes: " + estatisticas[i].QtdAcidentes);
            }
        }
    }

    public void consultarPorEstatisticaAcidentes(Estatistica[] estatisticas) {
        int menorNumAcidentes = estatisticas[0].QtdAcidentes;
        int maiorNumAcidentes = estatisticas[0].QtdAcidentes;

        for (int i = 1; i < estatisticas.length; i++) {
            if (estatisticas[i].QtdAcidentes < menorNumAcidentes) {
                menorNumAcidentes = estatisticas[i].QtdAcidentes;
            }
            if (estatisticas[i].QtdAcidentes > maiorNumAcidentes) {
                maiorNumAcidentes = estatisticas[i].QtdAcidentes;
            }
        }

        JOptionPane.showMessageDialog(null, "Menor quantidade de acidentes: " + menorNumAcidentes);
        JOptionPane.showMessageDialog(null, "Maior quantidade de acidentes: " + maiorNumAcidentes);
    }

    public void consultarAcidentesAcimaDaMedia(Estatistica[] estatisticas) {
        int somaAcidentes = 0;
        for (int i = 0; i < estatisticas.length; i++) {
            somaAcidentes += estatisticas[i].QtdAcidentes;
        }
        double mediaAcidentes = (double) somaAcidentes / estatisticas.length;

        StringBuilder cidadesAcimaDaMedia = new StringBuilder();
        for (int i = 0; i < estatisticas.length; i++) {
            if (estatisticas[i].QtdAcidentes > mediaAcidentes) {
                cidadesAcimaDaMedia.append(estatisticas[i].NomeCidade).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, "Cidades com acidentes acima da média (" + mediaAcidentes + "):\n" + cidadesAcimaDaMedia.toString());
    }
    
    public void LerEstatistica (Estatistica[] estatisticas) throws IOException {
        String fileName = "ArquivoEstatistica.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for (int i = 0; i < estatisticas.length; i++) {
            estatisticas[i] = new Estatistica();
        }
        for (int i = 0; i < estatisticas.length; i++) {
            estatisticas[i].CodigoCidade = Integer.parseInt(ler.readLine());
            estatisticas[i].NomeCidade = ler.readLine();
            estatisticas[i].QtdAcidentes = Integer.parseInt(ler.readLine());
        }
        for (int i = 0; i < estatisticas.length; i++) {
            System.out.println("CODIGO " + estatisticas[i].CodigoCidade + " | " + estatisticas[i].NomeCidade + " | QTD:  " + estatisticas[i].QtdAcidentes + "\n");
        }
        ler.close();
    }
}