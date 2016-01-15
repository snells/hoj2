Run from linux

./serv-compile
./start
# from another terminal run
./client-start


Run from eclipse

start server by running ServerImpl class
start client by running MainWindow class


# Run otherwise

compile
javac src/hoj/*.java -d bin/

start server
java -cp bin  -Djava.rmi.codebase=file:/ss/prog/java/hoj2/src/ hoj.ServerImpl

start client
java -cp bin  -Djava.rmi.codebase=file:/ss/prog/java/hoj2/src/ hoj.MainWindow






