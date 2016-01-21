CC=javac
FLAGS=-g
#FILES=TestAss1.java BT.java TreeAndRepresentation.java FLrep.java ZOrep.java
TARGETS=TestAss1.class BT.class TreeAndRepresentation.class FLrep.class ZOrep.class

all: $(TARGETS)

%.class: %.java
	$(CC) $(FLAGS) $<

run1: 
	java TestAss1 < testZOFL_5.txt
run2: 
	java TestAss1 < testZOFL_100.txt
run3: 
	java TestAss1 < testZOFL_10000.txt
run4: 
	java TestAss1 < testZOFL_100000.txt

clean:
	rm *.class
