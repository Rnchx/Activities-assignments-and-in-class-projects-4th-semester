public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto==null || texto.length()==0)
            throw new Exception ("Texto invalido");

        this.texto=texto;
    }

    public int getQuantidade (char letra)
    {
        int qtd=0;

        for (int i=0; i<this.texto.length(); i++)
            if (this.texto.charAt(i)==letra)
                qtd++;

        return qtd;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        if (i<0)
            throw new Exception ("Indice invalido");

        int qtd=0;

        for (int j=0; j<this.texto.length(); j++)
        {
            if (this.texto.charAt(j)==letra)
            {
                if (qtd==i)
                    return j;

                qtd++;
            }
        }

        throw new Exception ("Ocorrencia inexistente");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        Palavra palavra = (Palavra)obj;

        if (!palavra.texto.equals(this.texto)) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        return this.texto.hashCode();
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}