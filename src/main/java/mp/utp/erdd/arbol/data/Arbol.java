package mp.utp.erdd.arbol.data;

public class Arbol
{
	Nodo root;
	String recorrido;

	static boolean valid;

	/**
	 * start
	 * Metodos publicos para separa el programa (el menu, etc...)
	 * y la clase del arbol
	 */

	public boolean addStart(int data)
	{
		valid = true;

		if (root == null)
		{
			root = new Nodo(data);
		}
		else
		{
			root = add(root, data);
		}

		return valid;
	}

	public boolean deleteStart(int data)
	{
		valid = true;

		if (root == null)
		{
			valid = false;
		}
		else
		{
			root = delete(root, data);
		}

		return valid;
	}

	/**
	 * Operaciones
	 */

	private Nodo add(Nodo working, int data)
	{
		//Guardamos en int ya que se usa 3 veces durante el metodo
		int workingData = working.getData();

		if (data > workingData)
		{
			Nodo mas = working.getMas();
			if (mas == null)
			{
				//Si el nodo mayor es null, crear nuevo nodo
				working.setMas(new Nodo(data));
			}
			else
			{
				/*
				Si el nodo existe llamar al metodo de nuevo
				Creamos el nodo aux para evitar errores de StackOverflow
				 */
				Nodo aux = add(working.getMas(), data);
				working.setMas(aux);
			}
		}
		else if (data < workingData)
		{
			Nodo menos = working.getMenos();
			if (menos == null)
			{
				//Si el nodo menor es null, crear nuevo nodo
				working.setMenos(new Nodo(data));
			}
			else
			{
				/*
				Si el nodo existe llamar al metodo de nuevo
				Creamos el nodo aux para evitar errores de StackOverflow
				 */
				Nodo aux = add(working.getMenos(), data);
				working.setMenos(aux);
			}
		}
		else
		{
			//Ya existe en el arbol
			valid = false;
		}

		//Siempre se devuelve el nodo root
		return working;
	}

	private Nodo delete(Nodo working, int data)
	{
		//Repetimos la logica del metodo add
		int workingData = working.getData();

		/*
		Si llegamos a encontrar un valor null
		significa que el valor no existe en el arbol
		 */
		if (data > workingData)
		{
			Nodo mas = working.getMas();
			if (mas == null)
			{
				valid = false;
			}
			else
			{
				Nodo aux = delete(working.getMas(), data);
				working.setMas(aux);
			}
		}
		else if (data < workingData)
		{
			Nodo menos = working.getMenos();
			if (menos == null)
			{
				valid = false;
			}
			else
			{
				Nodo aux = delete(working.getMenos(), data);
				working.setMenos(aux);
			}
		}
		else
		{
			//Valor encontrado
			Nodo mas = working.getMas();
			Nodo menos = working.getMenos();

			/*
			Primeros 3 if tomados del codigo en teams
			 */
			if (mas == null && menos == null)
			{
				//No tiene hijos
				return null;
			}
			else if (mas == null)
			{
				//tiene 1 hijo
				return menos;
			}
			else if (menos == null)
			{
				//tiene 1 hijo
				return mas;
			}
			else
			{
				/*
				Oh boy tiene 2 hijos
				Encontramos el succesor, metodo explicado mas abajo
				 */
				int valorMenor = encontrarSuccesor(mas);

				/*
				Seteamos el valor del succesor a nuestro working root
				Y creamos nodo aux para evitar error de StackOverflow
				 */
				working.setData(valorMenor);
				Nodo aux = delete(working.getMas(), valorMenor);
				working.setMas(aux);
			}
		}

		return working;
	}

	/**
	 * Aqui necesitamos encontrar el nodo succesor,
	 * osea el elemento mas a la izquierda en el subarbol derecho
	 * @param working nodo mayor
	 * @return data del nodo succesor
	 */

	private int encontrarSuccesor(Nodo working)
	{
		/*
		 * NOTA: working es el nodo a la DERECHA del nodo donde encontramos nuestro valor.
		 * Preguntamos si el nodo menor de working es null, ya econtramos el nodo mas a la izquierda y devolvemos data
		 * si no es volvemos a correr el metodo pasando el nodo que acabamos de leer y repetimos el proceso
		 * hasta que no encontremos nodo a la izquierda.
		 */
		return working.getMenos() == null ? working.getData() : encontrarSuccesor(working.getMenos());
	}

	public int findHeight(Nodo nodo)
	{
		if (nodo == null)
		{
			return 0;
		}
		else
		{
			return 1 + Math.max(findHeight(nodo.getMenos()), findHeight(nodo.getMas()));
		}
	}

	/**
	 * recorridos
	 */

	public String startInorder()
	{
		recorrido = "";
		inorder(root);

		return recorrido;
	}

	public String startPreorden()
	{
		recorrido = "";
		preorder(root);

		return recorrido;
	}

	public String startPostorden()
	{
		recorrido = "";
		postorden(root);

		return recorrido;
	}

	private void inorder(Nodo working)
	{
		if (working != null)
		{
			inorder(working.getMenos());
			recorrido += working.getData() + " ";
			inorder(working.getMas());
		}
	}

	private void preorder(Nodo working)
	{
		if (working != null)
		{
			recorrido += working.getData() + " ";
			preorder(working.getMenos());
			preorder(working.getMas());
		}
	}

	private void postorden(Nodo working)
	{
		if (working != null)
		{
			postorden(working.getMenos());
			postorden(working.getMas());
			recorrido += working.getData() + " ";
		}
	}

	public Nodo getRoot()
	{
		return root;
	}
}