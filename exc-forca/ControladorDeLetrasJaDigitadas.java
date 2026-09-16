public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas="";
    }

    public boolean isJaDigitada (char letra)
    {
        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
            if (this.letrasJaDigitadas.charAt(i)==letra)
                return true;

        return false;
    }

    public void registre (char letra) throws Exception
    {
        if (this.isJaDigitada(letra))
            throw new Exception ("Letra ja digitada");

        this.letrasJaDigitadas += letra;
    }

    @Override
    public String toString ()
    {
        String retorno="";

        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
        {
            if (i>0)
                retorno += ",";

            retorno += this.letrasJaDigitadas.charAt(i);
        }

        return retorno;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        ControladorDeLetrasJaDigitadas controlador =
        (ControladorDeLetrasJaDigitadas)obj;

        if (!controlador.letrasJaDigitadas.equals(this.letrasJaDigitadas))
            return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        return this.letrasJaDigitadas.hashCode();
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception
    {
        if (controladorDeLetrasJaDigitadas==null)
            throw new Exception ("Controlador invalido");

        this.letrasJaDigitadas =
        controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    @Override
    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas retorno=null;

        try
        {
            retorno =
            new ControladorDeLetrasJaDigitadas (this);
        }
        catch (Exception erro)
        {}

        return retorno;
    }
}