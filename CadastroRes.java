import java.util.Scanner;

public class CadastroRes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Reserva r = new Reserva();

        System.out.print("Digite ID: ");
        r.idres = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite data de início da reserva: ");
        r.data_ini = entrada.nextLine();

        System.out.print("Digite data de fim da reserva: ");
        r.data_fim = entrada.nextLine();

        ReservaDAO rd = new ReservaDAO();
        rd.salvarReserva(r);
    }
}