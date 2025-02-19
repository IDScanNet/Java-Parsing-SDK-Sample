#!/usr/bin/env bash

set -ex

java -Djava.library.path=./ -cp "./*" Main.java

java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80120695.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80121187.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80121822.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80122840.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80122874.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80123733.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80123876.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80124497.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80124586.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/80124903.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/78587185.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Fakes/72986347.txt

java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/69501791.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/78484931.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79818556.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79913836.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79913873.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79913934.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79915197.txt
java -Djava.library.path=./ -cp "./*" Main.java ../TestData/Valid/79915360.txt