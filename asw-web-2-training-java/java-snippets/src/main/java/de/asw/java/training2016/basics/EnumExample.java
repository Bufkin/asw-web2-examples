package de.asw.java.training2016.basics;

public class EnumExample {

	public static void main(String[] args) {

//		example1();
		example2();
	}

	private static void example1() {
		Farbe foo = Farbe.GELB;

		switch (foo) {
		case ROT:
			System.out.println("rot");
			break;
		case GELB:
			System.out.println("gelb");
			break;
		case GR�N:
			System.out.println("gr�n");
			break;
		}
	}

	private static void example2() {
		Farbe foo = Farbe.GELB;

		switch (foo) {
		case ROT:
			System.out.println(foo.getName());
			break;
		case GELB:
			System.out.println(foo.getName());
			break;
		case GR�N:
			System.out.println(foo.getName());
			break;
		}
		
		System.out.println(foo.getFarbCode());
	}
	 
	enum Farbe {
		ROT("FF0000"), GELB("00FFFF"), GR�N("00FF00");
		
		private final String farbcode;
		
		private Farbe(String farbcode) {
			this.farbcode = farbcode;
		}

		String getName(){
			return name().toLowerCase();
		}
		
		String getFarbCode(){
			return this.farbcode;
		}
	}
	
}
