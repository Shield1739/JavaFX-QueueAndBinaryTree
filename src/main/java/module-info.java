module mp.utp.erdd {
    requires javafx.controls;
    requires javafx.fxml;

    opens mp.utp.erdd to javafx.fxml;
	opens mp.utp.erdd.cola to javafx.fxml;
	opens mp.utp.erdd.arbol to javafx.fxml;
    exports mp.utp.erdd;
	exports mp.utp.erdd.cola;
	exports mp.utp.erdd.arbol;
}