CC=javac
FLAGS=-g
#FILES=TestAss1.java BT.java TreeAndRepresentation.java FLrep.java ZOrep.java
TARGETS=TestAss1.class BT.class TreeAndRepresentation.class FLrep.class ZOrep.class

all: $(TARGETS)

%.class: %.java
	$(CC) $(FLAGS) $<

run: 
	java TestAss1 < test2.txt

clean:
	rm *.class
