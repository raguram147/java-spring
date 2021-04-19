package DefaultMethods.Interfaces;

public interface demo {
	default void print() {
		System.out.println("Welcome to My JDK!");
	}
	default void method2() {
		System.out.println("I'm from same interface of demo and i'm 2nd defalut method!");

	}
	static void method1() {
		System.out.println("I'm from same interface of demo and i'm static method!");

	}
}
