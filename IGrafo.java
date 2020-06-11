import java.util.*;

public interface IGrafo {

	public int addCidade(String nome);

	public void encontraMenorCaminho(Cidade origem);

	public List<Cidade> criarCaminho(Cidade destino);

}
