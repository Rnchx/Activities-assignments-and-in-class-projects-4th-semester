public class Main
{
    public static void main (String[] args)
    {
        try
        {
            Horario horario = new Horario ((byte)19,(byte)30,(byte)45);

            System.out.println(horario); // 19:30:45

            System.out.println(horario.getHora());    // 19
            System.out.println(horario.getMinuto());  // 30
            System.out.println(horario.getSegundo()); // 45

            Horario futuro = horario.getHorarioFuturo(20);

            System.out.println(horario); // 19:30:45
            System.out.println(futuro);  // 19:31:05

            horario.adiante(20);

            System.out.println(horario); // 19:31:05

            horario.retroceda(20);

            System.out.println(horario); // 19:30:45

            Horario passado = horario.getHorarioPassado(50);

            System.out.println(horario); // 19:30:45
            System.out.println(passado); // 19:29:55

            horario.setHora((byte)23);
            horario.setMinuto((byte)59);
            horario.setSegundo((byte)59);

            System.out.println(horario); // 23:59:59

            horario.adiante(1);

            System.out.println(horario); // 00:00:00

            horario.retroceda(1);

            System.out.println(horario); // 23:59:59

            Horario outro = new Horario ((byte)23,(byte)59,(byte)59);

            System.out.println(horario.equals(outro)); // true
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }
}
