package mp.utp.erdd.arbol;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import mp.utp.erdd.arbol.data.Nodo;

public class DrawingView extends Pane
{
	Color circleColor = Color.ALICEBLUE;
	private final int espacio = 50;

	void drawArbolStart(Nodo root)
	{
		if (root == null)
		{
			return;
		}

		drawArbol(root, getWidth() / 2, espacio, getWidth() / 4);
	}

	private void drawArbol(Nodo root, double x, double y, double h)
	{
		if (root.getMenos() != null)
		{
			Line line = new Line(x - h, y + espacio, x, y);
			getChildren().add(line);
			drawArbol(root.getMenos(), x - h, y + espacio, h / 2);
		}

		if (root.getMas() != null)
		{
			Line line = new Line(x + h, y + espacio, x, y);
			getChildren().add(line);
			drawArbol(root.getMas(), x + h, y + espacio, h / 2);
		}

		Text text = new Text(x - 6, y + 4, root.getData() + "");

		Circle circle = new Circle(x, y, 20);
		circle.setFill(circleColor);
		circle.setStroke(Color.BLACK);

		getChildren().addAll(circle, text);
	}
}
