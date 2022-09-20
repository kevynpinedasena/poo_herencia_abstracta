package org.pineda.pooclasesabstractas.form;

import java.util.ArrayList;
import java.util.List;

import org.pineda.pooclasesabstractas.elementos.ElementoForm;
//import org.pineda.pooclasesabstractas.elementos.ElementoForm;
import org.pineda.pooclasesabstractas.elementos.InputForm;
import org.pineda.pooclasesabstractas.elementos.SelectForm;
import org.pineda.pooclasesabstractas.elementos.TextAreaForm;
import org.pineda.pooclasesabstractas.elementos.select.Opcion;
import org.pineda.pooclasesabstractas.form.validador.EmailValidador;
import org.pineda.pooclasesabstractas.form.validador.LargoValidador;
import org.pineda.pooclasesabstractas.form.validador.NoNuloValidador;
import org.pineda.pooclasesabstractas.form.validador.NumeroValidador;
import org.pineda.pooclasesabstractas.form.validador.RequeridoValidador;

public class EjemploForm {

	public static void main(String[] args) {
		
		InputForm username = new InputForm("username");
		username.addValidador(new RequeridoValidador());
		
		InputForm password = new InputForm("clave", "Password");
		password.addValidador(new RequeridoValidador())
			.addValidador(new LargoValidador(6, 12));
		
		InputForm email = new InputForm("email", "email");
		email.addValidador(new RequeridoValidador())
			.addValidador(new EmailValidador());
		
		InputForm edad = new InputForm("edad", "number");
		edad.addValidador(new NumeroValidador());
		
		TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);
		
		SelectForm lenguaje = new SelectForm("Lenguaje");
		lenguaje.addValidador(new NoNuloValidador());
		
		Opcion java = new Opcion("1", "Java");
		lenguaje.addOpcion(java)
		.addOpcion(new Opcion("2", "Phyton"))
		.addOpcion(new Opcion("3", "JavaScript"))
		.addOpcion(new Opcion("4", "TypeScript"))
		.addOpcion(new Opcion("5", "PHP"));
		
		ElementoForm saludo = new ElementoForm("saludo") {
			
			@Override
			public String dibujarHtml() {
				// TODO Auto-generated method stub
				return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\">";
			}
		};
		
		
		saludo.setValor("Hola que tal este campo esta desabilitado!");
		username.setValor("john.doe");
		password.setValor("a1b2c3");
		email.setValor("john.doe@correo.com");
		edad.setValor("28");
		experiencia.setValor(".. Mas de 10 años de experiencia ...");
		java.setSelected(true);
		
		List<ElementoForm> elementos = new ArrayList<>();
		elementos.add(username);
		elementos.add(password);
		elementos.add(email);
		elementos.add(edad);
		elementos.add(experiencia);
		elementos.add(lenguaje);
		elementos.add(saludo);
		
		for (ElementoForm elementoForm : elementos) {
			System.out.println(elementoForm.dibujarHtml());
		}
		
		System.out.println();
//		es igual a foreach de arriba solo que tiene que meter una exprecion landan y es mas avanzada
		elementos.forEach(e -> {
			System.out.println(e.dibujarHtml());
		});
		
		elementos.forEach(e -> {
			if (!e.esValido()) {
				e.getErrores().forEach(err -> System.out.println(err));
				
//				esto es un atajo para una expresion landan funciona igual que el de arriba 
//				e.getErrores().forEach(System.out::println);
			}
		});
		
		
		
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
