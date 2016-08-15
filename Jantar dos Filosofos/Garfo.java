import java.util.concurrent.Semaphore;

public class Garfo extends Semaphore {

	private static final long serialVersionUID = 1L;
	
    //cria os gardos e os numera
	public static final int GARFO_0 = 0;
    public static final int GARFO_1 = 1;
    public static final int GARFO_2 = 2;
    public static final int GARFO_3 = 3;
    public static final int GARFO_4 = 4;

    private String nome;

    public Garfo(String nome) {

        //Dando permisão a super classe Semaphore
        //Java Docs - Classe Semaphote
        //emaphore(int permits, boolean fair)
        //Creates a Semaphore with the given number of permits and the given fairness setting.
        super(1, true);

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
}