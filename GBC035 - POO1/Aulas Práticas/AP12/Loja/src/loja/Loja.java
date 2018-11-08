package loja;

import java.util.ArrayList;

public class Loja {

    ArrayList<Cliente> clientes = new ArrayList<>();
    
    public void imprime()
    {
        for(int i = 0; i < clientes.size(); i++)
        {
            clientes.get(i).mala_direta();
            System.out.println("\n");
        }
    }
    
    public static void main(String[] args)
    {
        Loja l = new Loja();
        ClienteVIP c1 = new ClienteVIP("João da Silva","Rua Sapucaí, 10. Uberlândia – MG");
        ClienteVVIP c2 = new ClienteVVIP("Michael Jackson","Wonderland St., 100. Los Angeles – CA","Edgar Fidalgo");
        ClienteVVIP c3 = new ClienteVVIP("Zeca Pagodinho","Rua de Trás, 30. Xerém - RJ","Rui Cevada");
        l.clientes.add(c1);
        l.clientes.add(c2);
        l.clientes.add(c3);
        l.imprime();
        
    }
    
}
