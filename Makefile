JAVAC	:= javac
JAR	:= jar
JDOC	:= javadoc

all: src
	cd src; $(JAVAC) *.java org/util/file/*.java
	cd src; $(JAR) -cf FileAction.jar module-info.* org/util/file/*
	mv src/FileAction.jar FileAction.jar

docs:
	mkdir docs
	cd src; $(JDOC) -private module-info.java org/util/file/*.java -d ../docs

clean:
	rm $(shell find -name '*.class')
	rm *.jar

clean-docs:
	rm -r docs
