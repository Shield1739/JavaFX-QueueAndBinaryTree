package mp.utp.erdd.cola.data;

public class Nodo
{
	private String data;
	private Nodo next;

	/**
	 * Constructor de la Queue
	 * @param data La informacion a guardar
	 * @param next Posicion del siguiente String en el Queue
	 */

	public Nodo(String data, Nodo next)
	{
		this.data = data;
		this.next = next;
	}

	/**
	 * Setters
	 */

	public void setData(String data)
	{
		this.data = data;
	}

	public void setNext(Nodo next)
	{
		this.next = next;
	}

	/**
	 * Getters
	 */

	public String getData()
	{
		return data;
	}

	public Nodo getNext()
	{
		return next;
	}
}