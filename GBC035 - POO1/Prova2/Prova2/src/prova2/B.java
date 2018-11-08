package prova2;

public class B
{
    int x;
    B (int i) { x = i; }
    void g () throws TabajaraException
    {
        if (x == 2) throw new SidelmawException("Danou-se");
        else throw new SiferrowException("Ferrou-se");
    }
}
