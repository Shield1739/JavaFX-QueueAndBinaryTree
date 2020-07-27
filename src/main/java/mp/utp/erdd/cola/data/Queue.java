package mp.utp.erdd.cola.data;

public class Queue
{
	private Nodo head;
	private Nodo tail;

	private int size;

	/**
	 * Constructors del Queue
	 */

	public Queue()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Agregar el Sring al Queue
	 * @param data Informacion a agregar
	 */

	public void add(String data)
	{
		//Si el string es null, salir con error.
		if (data == null)
		{
			System.out.println("ERROR! NULL DATA");
			return;
		}

		if (size != 0) //Queue ya tiene elementos
		{
			Nodo working = this.tail;
			this.tail = new Nodo(data, null);
			working.setNext(this.tail);
		}
		else //Queue no tiene elementos
		{
			this.tail = new Nodo(data, null);
			this.head = this.tail;
		}

		size++;
	}

	/**
	 * Remover primer elemento del Queue
	 * @return Elemento removido
	 */

	public String remove()
	{
		//Si el Queue no tiene elementos, salir con error
		if (size == 0)
		{
			return null;
		}

		Nodo aux = this.head;
		String valor = aux.getData();

		this.head = aux.getNext();

		size--;
		return valor;
	}

	/**
	 * Un Getter con extra step
	 * Devuelve null si size = 0
	 * @return valor del primer nodo en el Queue
	 */

	public String see()
	{
		return size == 0 ? null : head.getData();
	}

	/**
	 * Getters
	 */

	public Nodo getHead()
	{
		return head;
	}

	public Nodo getTail()
	{
		return tail;
	}

	public int getSize()
	{
		return size;
	}
}