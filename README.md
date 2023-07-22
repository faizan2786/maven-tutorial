# maven-tutorial
A sample [Maven](https://maven.apache.org/index.html) project to demonstrate configuration of non-trivial project hierarchy in Java using Maven.

## How to Compile:
- clone the repo.
- go to the repo directory (where the top level `pom.xml` is located)
- run `mvn clean validate` command. This will validate the Maven project structure for entire module.
- run `mvn package` command. This will compile, test (if any) and generate the targets (`.jar` files) for **each project** in its respected `target/` folder.

## How to Run:
- Into a terminal, go to each project's directory
- run command: `java -jar target/<executable-name>.jar`

## Project structure:
The top-level directory defines a **parent module** that contains **two** children **projects**.

### The top-level `pom.xml` file includes:
- Its own project model definition - with `<packaging>pom</packaging>` which tells Maven that this is just a project model file and **not** an actual project.
- `<properties>...</properties>` - It defines **common** variables that can be used in any of the `pom.xml` file within the module.
- `<modules>...</modules>` - It defines *a list* of all sub-modules (**projects**) that are children of this parent project.
- `plugins/dependencies` - It defines **common** plugins and/or dependencies that are to be used for *each child project*.
  
## Children projects:
As you can see the top level `pom.xml` files lists two projects. Hence all of these projects will be build when we run maven builds on the top-level directory.

### **`Hypotenuse` project**:
This is an **independent** java project to demonstrate a single project configuration with testing in Maven.
-  It contains a `Hypotenuse.java` class file and `HypotenuseTest.java` test file in `test/` folder path.
-  The `pom.xml` file includes:
   -  As usual its own project definition. However, this time it uses  `<packaging>jar</packaging>` to indicate that this is a java project with a `.jar` type target (build file).
   -  It uses `maven-jar-plugin` to  build an "**executable**" `jar` file WITHOUT any dependecies included.\
      <ins>**Note**</ins>: we provide the _runnable_ **main class** (i.e. class with public **main function**) name
      in the configuration setting under `<mainfest>...</manifest>` tags. This sets which main method to run upon executing the jar file.
   -  It also defines *JUnit 5.x (Jupiter)* testing framework as its **local dependency**.
   -  Hence, when Maven will build this project, it will also run the tests included in `HypotenuseTest.java` file.

### **`RightAngleTriangle` project**:
This is a **dependent** java project to demonstrate maven configuration of a project that depends on *another project* in the **parent** module. 
- It contains a `RightAngleTriangle.java` class file that uses `getHypotenuse()` method from `Hypotenuse` class defined the project above.
- The `pom.xml` file includes:
   -  As usual its own project definition with  `<packaging>jar</packaging>` for `.jar` build target.
   -  It doesn't need any other library, hence it **does not** define any library dependency.
   -  However, it uses `Hypotenuse` class. Hence, the `Hypotenuse` **project** is listed as a **dependency**.\
      **IMPORTANT**: This way, Maven will add the `Hypotenuse` project on this project's *class path* **and** also,
               it will make sure that the `Hypotenuse` project **compiles before** this project.
  -  It also uses `maven-assembly-plugin` to  build an "**executable**" `jar` file **INCLUDING** any dependencies.\
     <ins>**Note**</ins>: we specifiy the phase (`package`), a goal type (`single`), `manifest` and descriptors (`descriptorRefs`) to build the target executable.

### Note: 
You can see that `pom.xml` file in each sub module includes `<parent>...</parent>` tag that lists the parent module's details. This tells Maven *how to locate the parent module* in case a sub module is compiled/built **separately** than its parent module.
