package prova2.pkg2016;

public class Prova22016 
{
    public Prova22016 ()
    {
        Automovel garagem[] = new Automovel[2];
        garagem[0] = new Importado();
        garagem[1] = new Popular();
        testDrive(garagem);
    }

    void testDrive(Automovel carros[])
    {
        for(int i = 0; i < carros.length; i++)
        {
            carros[i].dirigir();
        }
    }
    }
