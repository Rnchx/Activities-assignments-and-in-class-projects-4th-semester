public class Horario
{
    private byte hora, minuto, segundo;

        public static boolean isValida (byte hora, byte minuto, short segundo)
    {
        if (hora<0 || hora>23) return false;

        if (minuto<0 || minuto>59) return false;

        if (segundo<0 || segundo>59) return false;

        return true;
    }

    public /*void*/ Horario (byte hora, byte minuto, byte segundo) throws Exception
    {
        if (!Horario.isValida(hora, minuto, segundo))
            throw new Exception ("Horário invalido");

        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }

    public void setHora (byte hora) throws Exception
    {
        if (!Horario.isValida(hora, this.minuto, this.segundo))
            throw new Exception ("Horário invalido");

        this.hora=hora;
    }

    public void setMinuto (byte minuto) throws Exception
    {
        if (!Horario.isValida(this.hora, minuto, this.segundo))
            throw new Exception ("Horário invalido");

        this.minuto=minuto;
    }

    public void setSegundo (byte segundo) throws Exception
    {
        if (!Horario.isValida(this.hora, this.minuto, segundo))
            throw new Exception ("Horário invalido");

        this.segundo=segundo;
    }

    public byte getHora ()
    {
        return this.hora;
    }

    public byte getMinuto ()
    {
        return this.minuto;
    }

    public byte getSegundo ()
    {
        return this.segundo;
    }

    public void adiante (int qtdSegundos) throws Exception
    {
        if (qtdSegundos<=0)
            throw new Exception ("Quantidade invalida");

        for (int i=0; i<qtdSegundos; i++)
        {
            if (this.segundo<59)
                this.segundo++;
            else if (this.minuto<59)
            {
                this.segundo=(byte)0;
                this.minuto++;
            }
            else if (this.hora<23)
            {
                this.segundo=(byte)0;
                this.minuto=(byte)0;
                this.hora++;
            }
            else
            {
                this.segundo=(byte)0;
                this.minuto=(byte)0;
                this.hora=(byte)0;
            }
        }
    }

    public void retroceda (int qtdSegundos) throws Exception
    {
        if (qtdSegundos<=0)
            throw new Exception ("Quantidade invalida");

        for (int i=0; i<qtdSegundos; i++)
        {
            if (this.segundo>0)
                this.segundo--;
            else if (this.minuto>0)
            {
                this.segundo=(byte)59;
                this.minuto--;
            }
            else if (this.hora>0)
            {
                this.segundo=(byte)59;
                this.minuto=(byte)59;
                this.hora--;
            }
            else
            {
                this.segundo=(byte)59;
                this.minuto=(byte)59;
                this.hora=(byte)23;
            }
        }
    }

    public Horario getHorarioFuturo (int qtdSegundos) throws Exception // nao altera o this
    {
        Horario retorno=null;

        try
        {
            retorno = new Horario (this.hora,this.minuto,this.segundo);
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro pq criei o novo horario a partir dum velho que ja foi validado

        retorno.adiante(qtdSegundos);

        return retorno;
    }

    public Horario getHorarioPassado (int qtdSegundos) throws Exception // nao altera o this
    {
        Horario retorno=null;

        try
        {
            retorno = new Horario (this.hora,this.minuto,this.segundo);
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro pq criei o novo horario a partir dum velho que ja foi validado

        retorno.retroceda(qtdSegundos);

        return retorno;
    }

    @Override
    public String toString ()
    {
        return (this.hora<10?"0":"")+
                this.hora + ":" +
               (this.minuto<10?"0":"")+
                this.minuto + ":" +
               (this.segundo<10?"0":"")+
                this.segundo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;

        Horario hor = (Horario)obj;

        if (hor.hora!=this.hora) return false;
        if (hor.minuto!=this.minuto) return false;
        if (hor.segundo!=this.segundo) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        return 60*60*this.hora +
               60*this.minuto +
               this.segundo;
    }
}
