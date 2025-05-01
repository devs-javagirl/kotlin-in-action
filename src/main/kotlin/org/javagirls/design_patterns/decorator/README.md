<h1>Decorator design pattern</h1>
Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside 
special wrapper objects that contain the behaviors.

“Wrapper” is the alternative nickname for the Decorator pattern that clearly expresses the main idea of the pattern. 
A wrapper is an object that can be linked with some target object. 
The wrapper contains the same set of methods as the target and delegates to it all requests it receives. 
However, the wrapper may alter the result by doing something either before or after it passes the request to the target.

Font: https://refactoring.guru/design-patterns/decorator

<h1>Class Delegation: using the by keyword</h1>
A common problem in the design of large object-oriented systems is fragiity caused by implementation inheritance.
When you extend a class and override some of its methods, your code becomes dependent on the implementation details
of the class you're extending.
When the system evolves and the implementation of the base class changes or new methods are added to it,
the assumptions about its behaviour you've made in your class can become invalid, so your code may end up not behaving correctly.

The design of Kotlin recognizes this problem and treats classes as final by default. 
This ensures that only those classes designed for extensibility can be inherited from.
When working on such a class, you see that it's open, and you keep in mind that modifications need to be compatible with derived classes.

But often, you need to add behavior to another class, even if it wasn't designed to be extended.
A common way to implement this is known as the decorator design pattern. 
The essence of the pattern is that a new class is created, implementing the same interface as the original class
and storing the instance of the original class as a field.
Methods in which the behavior of the original class doesn't need to be modified are forwarded to the original class instance.


Font: Kotlin in Action