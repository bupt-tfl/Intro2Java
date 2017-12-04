## Homework 2 - Week 2

### Motivation
* Demonstrate your ability to program the procedural aspects of Java by implementing real-world algorithms

### Instructions
* There are three tasks to complete
    - Implement the [Polyline Algorithm](https://developers.google.com/maps/documentation/utilities/polylinealgorithm) within the [PolylineEncoder](src/main/java/edu/nyu/cs9053/homework2/PolylineEncoder.java) class.
    - Implement the compound interest methods of [CompoundInterestCalculator](src/main/java/edu/nyu/cs9053/homework2/CompoundInterestCalculator.java) class.
    - Implement the command line [Program](src/main/java/edu/nyu/cs9053/homework2/Program.java) class to test your code, see [Program Instructions](#program-instructions)

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations


### Program Instructions
* The [Program](src/main/java/edu/nyu/cs9053/homework2/Program.java) should take command line arguments and parse them according to the following rules
    - The first argument should either be `gps` or `interest`
    - If the first argument is `gps` then the remaining arguments are GPS lat,lng pairs separated by spaces. 
        - Parse these arguments and pass them into your [PolylineEncoder](src/main/java/edu/nyu/cs9053/homework2/PolylineEncoder.java) implementation and print the result
    - If the first argument is `interest` then the second argument is either `annual` or `continuous`
        - If the second argument is `annual` then the remaining arguments are parsed as `principal`, `rate`, `period` and `years`. Parse these values and pass them into your [CompoundInterestCalculator](src/main/java/edu/nyu/cs9053/homework2/CompoundInterestCalculator.java) `compoundAnnually` method implementation and print the result
        - If the second argument is `continuous` then the remaining arguments are parsed as `principal`, `rate` and `years`. Parse these values and pass them into your [CompoundInterestCalculator](src/main/java/edu/nyu/cs9053/homework2/CompoundInterestCalculator.java) `continuousCompound` method implementation and print the result
* If any of the arguments are invalid then print `Invalid argument` to the command line and quit
    
### Example Runs of Program
    $ java -cp TODO edu.nyu.cs9053.homework2.Program foo
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program gps 38.5,-120.2 40.7,-120.95 43.252,-126.453
    $ _p~iF~ps|U_ulLnnqC_mqNvxq`@
    $ java -cp TODO edu.nyu.cs9053.homework2.Program interest foo
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program interest annual
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program interest annual 1500 0.043 4 6
    $ 438.8368221341036315119868759615438447390638938086647345973196039067038515540052407615743135238517425023019313812255859375000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program interest continuous 2340 0.031 3
    $ 228.0604605273118800

    

    