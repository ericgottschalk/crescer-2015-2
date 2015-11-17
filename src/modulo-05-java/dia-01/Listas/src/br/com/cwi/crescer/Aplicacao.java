package br.com.cwi.crescer;


public class Aplicacao {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("segundo");
        list.addFirst("terceiro");
        list.addFirst("quarto");
        list.addFirst("quinto");
        list.addFirst("sexto");
        list.addFirst("setimo");
        list.addLast("ultimo");
        list.add(0, "primeiro");
        try {
            list.printTxt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.listAll());
    }
}
