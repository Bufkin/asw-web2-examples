package de.asw.java.training2016.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.bind.annotation.XmlRootElement;

public class IntrospectionExample {
	@XmlRootElement
	public static class Obj {

		private String value0 = "hallo";
		protected int value1 = 42;

		public String someMethod() {
			System.out.println("IntrospectionExample.Obj.someMethod()");
			return value0;
		}
	}

	public static void main(String[] args) throws Exception {
		Obj o = new Obj();

		System.out.println("# Liefert Information über die â€œStrukturâ€� eines Objektes:");
		ObjectInspector.inspect(o);

		System.out.println("\n# Dynamische Methodenaufrufe durchfÃ¼hren:");
//		o.someMethod();/expliziter aufruf
		System.out.println(o.getClass().getMethod("someMethod").invoke(o)); //aufruf über reflection

		System.out.println("\n# Manipulation von Objektzustand:");
		System.out.println("Vorher: " + o.someMethod());

		Field value0Field = o.getClass().getDeclaredField("value0");
		// private field 'value0' zugreifbar machen
		value0Field.setAccessible(true);
		value0Field.set(o, "huhu");

		System.out.println("Nachher: " + o.someMethod());
	}

	static class ObjectInspector {
		public static void inspect(Object o) throws Exception {

			log("## Inspecting object instance: %s%n", o);
			Class<?> clazz = o.getClass();

			log("%n## Inspecting class: %s%n", clazz);

			log("%n## Annotations:%n");
			for (Annotation anno : clazz.getDeclaredAnnotations()) {
				log("### declared annotation: %s%n", anno);
			}

			log("%n## Constructor:%n");
			for (Constructor<?> ctor : clazz.getDeclaredConstructors()) {
				log("### declared constructor: %s%n", ctor);
			}

			log("%n## Fields:%n");
			for (Field field : clazz.getDeclaredFields()) {

				field.setAccessible(true);
				log("### declared field: %s with value: %s%n", field, field.get(o));
			}

			log("%n## Methods%n");
			for (Method method : clazz.getDeclaredMethods()) {
				log("### declared methods: %s%n", method);
			}

			if (clazz.getSuperclass() != Object.class) {
				inspect(clazz.getSuperclass());
			}
		}

		private static void log(String msg, Object... args) {
			System.out.printf(msg, args);
		}
	}
}
