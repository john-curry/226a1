CC=javac
FLAGS=-g

all: TestAss1.java

%.class: %.java
	$(CC) $(FLAGS) $<

clean:
	rm *.class
