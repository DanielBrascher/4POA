package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Contato;

public class ContatoController {
    private ArrayList<Contato> contatos;
    private final String arquivo = "contatos.txt";

    public ContatoController(){
        this.contatos = new ArrayList<>();
        carregarContatos();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        Contato contato = new Contato(nome, telefone, email);
        contatos.add(contato);
        salvarContatos();
        System.out.println("Contato adicionado com sucesso!");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("Lista de Contatos:");
            for (Contato contato : contatos) {
                contato.listarContato();
            }
        }
    }

    public void alterarContato(String telefone) {
        Contato contato = buscarContatoPorTelefone(telefone);
        if (contato != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Novo email: ");
            String novoEmail = scanner.nextLine();

            contato.setNome(novoNome);
            contato.setTelefone(novoTelefone);
            contato.setEmail(novoEmail);
            salvarContatos();
            System.out.println("Contato alterado com sucesso!");
        } else {
            System.out.println("Contato com telefone " + telefone + " não encontrado.");
        }
    }

    public void excluirContato(String telefone) {
        Contato contato = buscarContatoPorTelefone(telefone);
        if (contato != null) {
            contatos.remove(contato);
            salvarContatos();
            System.out.println("Contato excluído com sucesso!");
        } else {
            System.out.println("Contato com telefone " + telefone + " não encontrado.");
        }
    }

    private Contato buscarContatoPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                return contato;
            }
        }
        return null;
    }

    public void salvarContatos(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))){
            for (Contato contato : contatos){
                writer.write(contato.getNome() + ";" + contato.getTelefone() + ";" + contato.getEmail());
                writer.newLine();
            }
        }
        catch(Exception e){
            System.out.println("Erro ao salvar: " + e);
        }
    }

    public void carregarContatos(){
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String nome = dados[0];
                String telefone = dados[1];
                String email = dados[2];
                contatos.add(new Contato(nome, telefone, email));
            }
        }
        catch(Exception e){
            System.out.println("Erro ao carregar: " + e);
        }
    }

}
