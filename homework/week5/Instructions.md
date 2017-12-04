## Homework 5 - Week 5

### Motivation
* Demonstrate your ability to program using interfaces and inner classes in the Java programming language.

### Instructions
* There are three tasks to complete
    - Implement music!
        - Copy all your MusicalInstrument subclasses from `homework/week4` into [directory](src/main/java/edu/nyu/cs9053/homework5)
        - Modify the [MusicalInstrument](src/main/java/edu/nyu/cs9053/homework5/MusicalInstrument.java) turning it into an interface
            - Add the following public method:
                - `void play((Rhythm rhythm, Note note, NoteCallback noteCallback)`
        - Ensure all your existing instruments (copied from `homework/week4`) compile
        - Implement three versions of the [Musician](src/main/java/edu/nyu/cs9053/homework5/Musician.java)
            - Make an implementation of [Musician](src/main/java/edu/nyu/cs9053/homework5/Musician.java) which plays at [tempo largo](https://en.wikipedia.org/wiki/Tempo#Measuring_tempo)
            - Make an implementation of [Musician](src/main/java/edu/nyu/cs9053/homework5/Musician.java) which plays at [tempo moderato](https://en.wikipedia.org/wiki/Tempo#Measuring_tempo)
            - Make an implementation of [Musician](src/main/java/edu/nyu/cs9053/homework5/Musician.java) which plays at [tempo prestissimo](https://en.wikipedia.org/wiki/Tempo#Measuring_tempo)
        - Play your music via the [Conductor](src/main/java/edu/nyu/cs9053/homework5/Conductor.java) main program
            - Hint, each "ditty" (i.e. all [Note](src/main/java/edu/nyu/cs9053/homework5/Note.java) objects comprising it) should be performed in 30 seconds at tempo of 100 bpm. Scale the musicians according to their tempo.
            - Hint, for simplicity each [Note](src/main/java/edu/nyu/cs9053/homework5/Note.java) within a "ditty" can be evenly spaced
    - Construct your appropriate musician implementations in the [MusicianProvider](src/main/java/edu/nyu/cs9053/homework5/MusicianProvider.java)
        - As well as randomly create one of your [MusicalInstrument](src/main/java/edu/nyu/cs9053/homework5/MusicalInstrument.java) implementations at each invocation of the `randomlyChoose` method
    - Create your own ditty and add into the appropriate place within the [Conductor](src/main/java/edu/nyu/cs9053/homework5/Conductor.java)
        - Hint, this should be the only modification to `Conductor` you do

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    