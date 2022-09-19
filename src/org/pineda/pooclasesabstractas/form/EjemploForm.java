package org.pineda.pooclasesabstractas.form;

//import org.pineda.pooclasesabstractas.elementos.ElementoForm;
import org.pineda.pooclasesabstractas.elementos.InputForm;
import org.pineda.pooclasesabstractas.elementos.SelectForm;
import org.pineda.pooclasesabstractas.elementos.TextAreaForm;
import org.pineda.pooclasesabstractas.elementos.select.Opcion;

public class EjemploForm {

	public static void main(String[] args) {
		
		InputForm username = new InputForm("username");
		InputForm password = new InputForm("clave", "Password");
		InputForm email = new InputForm("email", "email");
		InputForm edad = new InputForm("edad", "number");
		
		TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);
		
		SelectForm lenguaje = new SelectForm("Lenguaje");
		Opcion java = new Opcion("1", "Java");
		lenguaje.addOpcion(java);
		lenguaje.addOpcion(new Opcion("2", "Phyton"));
		lenguaje.addOpcion(new Opcion("3", "JavaScript"));
		lenguaje.addOpcion(new Opcion("4", "TypeScript"));
		lenguaje.addOpcion(new Opcion("5", "PHP"));
		
		username.setValor("john.doe");
		password.setValor("a1b2c3");
		email.setValor("john.doe@correo.com");
		edad.setValor("28");
		
		java.setSelected(true);
		
//		//clse anonima se llama clase al vuelo y no es reutilizable
//		ElementoForm elementoForm = new ElementoForm() {
//			
//			@Override
//			public String dibujarHtml() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};

	}

}
