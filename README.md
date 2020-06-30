## ToyBlockFactory
The toy block factory takes an order from a customer and generates an invoice detailing the amount of blocks (square, triangle, circle) and colours (red, blue, yellow) ordered and the cost of each.  A cutting report is generated for the cutting department and a painting report is generated for the paint department.
### Example input:
```
Welcome to the Toy Block Factory! 

Please input your Name: 
Ruth Lee
Please input your Address: 
1 Bob Ave
Please input your Due Date (eg.19/01/2019): 
20/02/2020
Please input the number of Red Squares: 
1
Please input the number of Blue Squares: 
1
Please input the number of Yellow Squares: 
1
Please input the number of Red Triangle: 
1
Please input the number of Blue Triangle: 
1
Please input the number of Yellow Triangle: 
1
Please input the number of Red Circle: 
1
Please input the number of Blue Circle: 
1
Please input the number of Yellow Circle: 
1
```

### Expected output:

```Your invoice report has been generated: 

Name: Ruth Lee, Address: 1 Bob Ave, Due Date: 20/02/2020

|          | red | blue | yellow | 
|  square  |  1  |  1   |   1    | 
| triangle |  1  |  1   |   1    | 
|  circle  |  1  |  1   |   1    | 
Squares 3 @ $1 ppi =  $3
Triangles 3 @ $2 ppi =  $6
Circles 3 @ $3 ppi =  $9
Red colour surcharge 3 @ $1 ppi =  $3

Total:  $21




Your cutting report has been generated: 

Name: Ruth Lee, Address: 1 Bob Ave, Due Date: 20/02/2020

|          | Qty |
|  square  |  6  |
| triangle |  6  |
|  circle  |  6  |




Your painting report has been generated: 

Name: Ruth Lee, Address: 1 Bob Ave, Due Date: 20/02/2020

|          | red | blue | yellow | 
|  square  |  3  |  3   |   3    | 
| triangle |  3  |  3   |   3    | 
|  circle  |  3  |  3   |   3    | 
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Open the terminal and cd into the directory where you want to save the project.

```
 $ git clone git@github.com:RuthMcilwaine/ToyBlockFactory.git
 $ cd src
 $ javac -d ../classes *.java
 $ cd ../classes 
 $ jar cvf ToyBlockFactory.jar *
 $ java Main (to start to program)
 ```


##  Prerequisites

What things you need to install the software and how to install them.

Install JDK 11. Follow instructions at the link: https://www.oracle.com/au/java/technologies/javase-downloads.html 

Install the latest version of IntelliJ.  Follow instructions at the link: https://www.jetbrains.com/idea/download/#section=mac

## Installing

Once the program has downloaded, transfer to Applications directory. When this is finished, open the Applications directory and double click on IntelliJ to open it.

Choose import project from the menu selection and choose the ToyBlockFactory from the file directory. Continue with the prompts.
<img src="https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-1.png" width="800" />

Make sure to select jdk-11 (or the most up to date) when choosing the project SDK.
<img src="https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-2.png" width="800" />

To manually add the tests library from the main menu, select File and Project Structure.
Select Project Settings, then Libraries and click on the plus + symbol to include from Maven.
<img src="https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-3.png" width="800" />

In the dialog that opens, specify the necessary library artifact, for example: org.junit.jupiter:junit-jupiter:5.4.2.
Apply the changes and close the dialog.

<img src="https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/install-4.png" width="800" />



## Swimlanes Sequence Diagram
![Swimlanes Sequence Diagram](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/toyblockfactory-sequence-diagram.png)


## Running the tests

Once the project is open in the IDE, the file structure can be viewed from the left. Double click on the tests directory and from the dropdown, click on the option to run ‘All Tests’.

<img src="https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/running-all-tests.png" width="500" />



## Test pyramid

E2E is testing the application's workflow from beginning to end. It aims to replicate user scenarios so that the system can be validated for integration and data integrity.

Integration testing combines individual units and tests the interaction between them, to expose any faults that might exist.

Unit tests are the smallest testable part of the application, and are used to ensure that the individual units are behaving as expected.

![test-pyramid](https://github.com/RuthMcilwaine/ToyBlockFactory/blob/master/docs/test-pyramid.png)


### Example of Integration:
```
 @Test
    void orderIsSetAndInvoiceIsDisplayed() {
        Customer customer = new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019");
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));

        Report report = reportGenerator.createInvoiceReport(order);
        report.getReportData().setCustomerDetails(customer);
        
        Assertions.assertEquals("\n\nYour invoice report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019\n\n" +

                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  0  |  0   |   0    | " + "\n" +
                "| triangle |  0  |  0   |   0    | " + "\n" +
                "|  circle  |  1  |  0   |   0    | " + "\n" +
                "Squares 0 @ $1 ppi =  $0" + "\n" +
                "Triangles 0 @ $2 ppi =  $0" + "\n" +
                "Circles 1 @ $3 ppi =  $3" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1\n\n" +

                "Total:  $4\n\n", report.printReport());
    }
```

## Built With

Javac - the java compiler

Jar - java archive file

