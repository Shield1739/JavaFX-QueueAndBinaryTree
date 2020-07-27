package mp.utp.erdd.arbol.data;

public class Nodo
{
	private int data;

	private Nodo mas;
	private Nodo menos;

	/**
	 * Constructor de los nodos
	 * @param data informacion a guardar
	 */
	public Nodo(int data)
	{
		this.data = data;

		this.mas = null;
		this.menos = null;
	}

	/**
	 * Setters
	 */

	public void setData(int data)
	{
		this.data = data;
	}

	public void setMas(Nodo mas)
	{
		this.mas = mas;
	}

	public void setMenos(Nodo menos)
	{
		this.menos = menos;
	}

	/**
	 * Getters
	 */

	public int getData()
	{
		return data;
	}

	public Nodo getMas()
	{
		return mas;
	}

	public Nodo getMenos()
	{
		return menos;
	}
}