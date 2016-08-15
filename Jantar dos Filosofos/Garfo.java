import java.util.concurrent.Semaphore;

public class Garfo extends Semaphore {

	private static final long serialVersionUID = 1L;
	
	public static final int GARFO_0 = 0;
    public static final int GARFO_1 = 1;
    public static final int GARFO_2 = 2;
    public static final int GARFO_3 = 3;
    public static final int GARFO_4 = 4;

    private String nome;

    public Garfo(String nome) {
        super(1, true);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
}