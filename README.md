## ToyBlockFactory
The toy block factory takes an order from a customer and generates an invoice detailing the amount of blocks (square, triangle, circle) and colours (red, blue, yellow) ordered and the cost of each.  A cutting report is generated for the cutting department and a painting report is generated for the paint department.

## Swimlanes Sequence Diagram
![Swimlanes Sequence Diagram](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/toyblockfactory-sequence-diagram.png)


##Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
Open the terminal
cd to where you want to save the project
To clone the repository type : git clone git@github.com:RuthMcilwaine/ToyBlockFactory.git
cd into the ./ToyBlockFactory/src directory
$ javac -d ../classes *.java
$ cd ../classes 
$ jar cvf ToyBlockFactory.jar *
$ jar tf ToyBlockFactory.jar
java Main (to start to program).


##Prerequisites

What things you need to install the software and how to install them
Install JDK 11. Follow instructions at the link:
https://www.oracle.com/au/java/technologies/javase-downloads.html 
Install the latest version of IntelliJ.  Follow instructions at the link: https://www.jetbrains.com/idea/download/#section=mac

##Installing

Once the program has downloaded, transfer to Applications directory. When this is finished, open the Applications directory and double click on IntelliJ to open it.

Choose import project from the menu selection and choose the ToyBlockFactory from the file directory. Continue with the prompts.
![install-1](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-1.png)

Make sure to select jdk-11 (or the most up to date) when choosing the project SDK.

![install-2](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-2.png)

To manually add the tests library from the main menu, select File and Project Structure.
Select Project Settings, then Libraries and click on the plus + symbol to include from Maven.
![install-3](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-3.png)

In the dialog that opens, specify the necessary library artifact, for example: org.junit.jupiter:junit-jupiter:5.4.2.
Apply the changes and close the dialog.
![install-4](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-4.png)


##Running the tests

Once the project is open in the IDE, the file structure can be viewed from the left. Double click on the tests directory and from the dropdown, click on the option to run ‘All Tests’.
![running-all-tests](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/running-all-tests.png)

##Break down into end to end tests

E2E is testing the application's workflow from beginning to end. It aims to replicate user scenarios so that the system can be validated for integration and data integrity and to ensure that it behaves as expected.

###Example:
```
@Test
void setsOneBlockToOrderWhenOneIsEntered() {
    int actual = takingOrder.questionAnswer(getScanner("1"), "");
    Assert.assertEquals(1, actual);
}
```

##Built With
Javac - the java compiler
Jar - java archive file

