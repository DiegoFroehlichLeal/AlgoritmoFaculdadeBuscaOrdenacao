package Exemplos;

import javax.swing.*;
import java.util.ArrayList;

public class PrincipalPessoa {

    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {git
        int op = 0;
        do {
            op = menu();
            if (op == 1) cadastra();
            if (op == 2) ordenaPorAltura();
            if (op == 3) ordenaPorIdade();
            if (op == 4) buscaBinariaPorIdade();
            if (op == 5) mostraLista();

        } while (op != 6);
    }

    public static int menu() {
        String m = "1 - Cadastrar\n"
                + "2 - Ordenar por altura\n"
                + "3 - Ordenar por idade\n"
                + "4 - Buscar por idade\n"
                + "5 - Mostrar Lista\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));


    }

    public static void cadastra() {
        Pessoa p = new Pessoa();
        p.nome = JOptionPane.showInputDialog("Nome");
        p.idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        p.altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
        pessoas.add(p);
    }

    public static void mostraLista() {
        String r = "";
        for (Pessoa p : pessoas) {
            r += p.nome + "-" + p.idade + "-" + p.altura + "\n";
        }
        JOptionPane.showMessageDialog(null, r);
    }

    public static void ordenaPorIdade() {
        int pos = 0;
        int ultima = pessoas.size() - 1;
        Pessoa aux = new Pessoa();
        while (ultima != 0) {
            while (pos != ultima) {
                if (pessoas.get(pos).idade > pessoas.get(pos + 1).idade) {
                    aux = pessoas.get(pos);
                    pessoas.set(pos, pessoas.get(pos + 1));
                    pessoas.set(pos + 1, aux);

                }
                pos++;
            }
            pos = 0;
            ultima--;
        }
        mostraLista();
    }

    public static void ordenaPorAltura() {
        int pos = 0;
        int ultima = pessoas.size() - 1;
        Pessoa aux = new Pessoa();
        while (ultima != 0) {
            while (pos != ultima) {
                if (pessoas.get(pos).altura > pessoas.get(pos + 1).altura) {
                    aux = pessoas.get(pos);
                    pessoas.set(pos, pessoas.get(pos + 1));
                    pessoas.set(pos + 1, aux);
                }
                pos++;
            }
            pos = 0;
            ultima--;
        }

        mostraLista();

    }

    public static void mostraPessoa(Pessoa p) {
        JOptionPane.showMessageDialog(null, p.nome + " - " + p.altura + " - " + p.idade);
    }

    public static void buscaBinariaPorIdade() {
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Idade a buscar?"));
        int p = 0;
        int u = pessoas.size() - 1;
        int m = (p + u) / 2;
        while (p != u && m != p && m != u) {
            if (busca == pessoas.get(m).idade) {
                mostraPessoa(pessoas.get(m));
                p = u;
            }
            if (busca < pessoas.get(m).idade) {
                u = m;
                m = (p + u) / 2;
            }
            if (busca > pessoas.get(m).idade) {
                p = m;
                m = (p + u) / 2;
            }
        }
    }
}

