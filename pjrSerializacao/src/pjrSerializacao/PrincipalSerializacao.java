package pjrSerializacao;

import java.io.*;
import java.util.ArrayList;

public class PrincipalSerializacao {
    public static void main(String[] args) {
        try {
            
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            pessoas.add(new Pessoa("Clara", 30, "99999"));
            pessoas.add(new Pessoa("João", 25, "88888"));
            pessoas.add(new Pessoa("Maria", 40, "77777"));
            String caminho = "pessoas.ser";

            ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream(caminho));
            objOS.writeObject(pessoas);
            objOS.close();
            System.out.println("Objetos serializados com sucesso em " + caminho);

            ObjectInputStream objIS = new ObjectInputStream(new FileInputStream(caminho));
            ArrayList<Pessoa> pessoasLidas = (ArrayList<Pessoa>) objIS.readObject();
            objIS.close();

            System.out.println("\nObjetos desserializados:");
            for (Pessoa p : pessoasLidas) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }~]]]]]]]]]]]]]]]]]
		