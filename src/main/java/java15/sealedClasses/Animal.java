package java15.sealedClasses;

/**
 * If animal extends from Person the Compiler raises following error: Animal is not allowed in the
 * sealed hierarchy
 *
 * <p>It's important to note that any class that extends a sealed class must itself be declared
 * sealed, non-sealed, or final. This ensures the class hierarchy remains finite and known by the
 * compiler.
 */
public class Animal /*extends Person */ {}
