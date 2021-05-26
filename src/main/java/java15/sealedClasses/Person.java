package java15.sealedClasses;

/**
 * Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.
 *
 * It's important to note that any class that extends a sealed class must itself be declared sealed,
 * non-sealed, or final. This ensures the class hierarchy remains finite and known by the compiler.
 *
 * For further information take a look at the <a href="https://openjdk.java.net/jeps/360">JEP</a>
 *
 */
public abstract sealed class Person permits Manager, Employee{
}
