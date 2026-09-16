public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if (qtd<=0)
            throw new Exception ("Quantidade invalida");

        this.texto = new char[qtd];

        for (int i=0; i<this.texto.length; i++)
            this.texto[i]='_';
    }

    public void revele (int posicao, char letra) throws Exception
    {
        if (posicao<0 || posicao>=this.texto.length)
            throw new Exception ("Posicao invalida");

        if (this.texto[posicao]!='_')
            throw new Exception ("Posicao ja revelada");

        this.texto[posicao]=letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for (int i=0; i<this.texto.length; i++)
            if (this.texto[i]=='_')
                return true;

        return false;
    }

    @Override
    public String toString ()
    {
        String retorno="";

        for (int i=0; i<this.texto.length; i++)
            retorno += this.texto[i] + " ";

        return retorno;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        Tracinhos tracinhos = (Tracinhos)obj;

        if (this.texto.length!=tracinhos.texto.length) return false;

        for (int i=0; i<this.texto.length; i++)
            if (this.texto[i]!=tracinhos.texto[i])
                return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret=0;

        for (int i=0; i<this.texto.length; i++)
            ret = 2*ret + this.texto[i];

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception
    {
        if (t==null)
            throw new Exception ("Tracinhos invalido");

        this.texto = new char[t.texto.length];

        for (int i=0; i<this.texto.length; i++)
            this.texto[i]=t.texto[i];
    }

    @Override
    public Object clone ()
    {
        Tracinhos retorno=null;

        try
        {
            retorno = new Tracinhos (this);
        }
        catch (Exception erro)
        {}

        return retorno;
    }
}