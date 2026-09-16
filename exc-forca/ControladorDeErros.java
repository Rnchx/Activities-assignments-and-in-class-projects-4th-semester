public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax<=0)
            throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr==this.qtdMax)
            throw new Exception ("Quantidade maxima de erros atingida");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr==this.qtdMax)
            return true;

        return false;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + " de " + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        ControladorDeErros controlador = (ControladorDeErros)obj;

        if (controlador.qtdMax!=this.qtdMax) return false;
        if (controlador.qtdErr!=this.qtdErr) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        return 2*this.qtdMax + this.qtdErr;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if (c==null)
            throw new Exception ("Controlador invalido");

        this.qtdMax=c.qtdMax;
        this.qtdErr=c.qtdErr;
    }

    @Override
    public Object clone ()
    {
        ControladorDeErros retorno=null;

        try
        {
            retorno = new ControladorDeErros (this);
        }
        catch (Exception erro)
        {}

        return retorno;
    }
}