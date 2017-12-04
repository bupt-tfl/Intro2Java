## Homework 4 - Week 4

### Motivation
* Demonstrate your ability to program using inheritance in the Java programming language.
* Demonstrate your knowledge of proper `equals` and `hashCode` implementations in the Java programming language.
* Demonstrate your knowledge of variable arguments and enum types in the Java programming language.

### Instructions
* There are four tasks to complete
    - Create an object hierarchy which mimics the [musical instruments](https://en.wikipedia.org/wiki/List_of_musical_instruments) taxonomy.
        - The hierarchy should be contained within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - There should be a base class called [MusicalInstrument](src/main/java/edu/nyu/cs9053/homework4/hierarchy/MusicalInstrument.java)
            - It should not have any instance variables nor implement equals/hashCode
        - There should be the following subtypes (at least, there will be more to make a proper hierarchy):
            - [Tenoroon](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tenoroon.java)
            - [Triangle](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Triangle.java)
            - [Clarinet](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Clarinet.java)
            - [Keyboard](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Keyboard.java)
            - [BassGuitar](src/main/java/edu/nyu/cs9053/homework4/hierarchy/BassGuitar.java)
            - [Sanxian](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Sanxian.java)
            - [Tsuzumi](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tsuzumi.java)
            - [DrumMachine](src/main/java/edu/nyu/cs9053/homework4/hierarchy/DrumMachine.java)
            - [Bassoon](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Bassoon.java)
            - [Sitar](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Sitar.java)
            - [Cello](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Cello.java)
            - [ElectricGuitar](src/main/java/edu/nyu/cs9053/homework4/hierarchy/ElectricGuitar.java)
            - [Chenda](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Chenda.java)
            - [Piccolo](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Piccolo.java)
            - [Xylophone](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Xylophone.java)
        - Each of the types should have the following methods:
            - `getOrigin` which returns a `String` indicating the origin country
            - `getHsNumber` which returns the instrument's [Hornbostel–Sachs number](https://en.wikipedia.org/wiki/Hornbostel%E2%80%93Sachs) as a `String`
            - `getImageUrl` which returns an image URL of the instrument as a `String`
            - `getClassificationName` which returns the classification name of the instrument as a `String` (as detailed in the linked Wikipedia entry).
        - Each of the concrete types should have the following methods:
            - `getName` returns a name for the instrument as a `String`. This value is different per object.
            - `getAge` returns the age of the instrument as an `int` (this is the age of the object not of the instrument's existence). This value is different per object.
        - Try to limit code by sharing across classes, however some redundant code can be useful to keep segregation between classes unrelated to the hierarchy. This can include composition where you create another object hierarchy which your [MusicalInstrument](src/main/java/edu/nyu/cs9053/homework4/hierarchy/MusicalInstrument.java) implementations leverage.
    - Provide implementations of the `equals` and `hashCode` methods for each class within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - Note, these methods are testing equality and returning hashes for the objects and so should only include checks on type information and object specific values.
        - Note, do not use Objects helper class, write your own implementations.
    - Create an enum type representing the 5 musical ranges (see [Wikipedia](https://en.wikipedia.org/wiki/Musical_instrument#Range) for the 5 ranges);
        - Each range must also have a method returning it's low Hz range as an `int`
        - Each range must also have a method returning it's high Hz range as an `int`
        - The enum should be called [Range](src/main/java/edu/nyu/cs9053/homework4/Range.java) with package `edu.nyu.cs9053.homework4`
    - Create a static varargs method within [Range](src/main/java/edu/nyu/cs9053/homework4/Range.java) which takes a variable number of Range objects and prints each object's low and high frequency.

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    