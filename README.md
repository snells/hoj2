# hoj2



###Tehtävän jako
   
Topi toteuttaa palvelimen.   
Vesa toteuttaa Asiakkaan.   
Sakari tekee rajapinnat, viimeistelee ja lähettää.   




####Topi



Toteuta PanimoInter.java oleva interface Tiedostoon Panimo.java ja vaadittavat luokat.   

Ruuvikeitin siirtää rakaa-ainetta 200 kiloa sekunissa, katso jos hoj1 Timer.java:sta apua



#### Vesa


Asiakkaan toteutus on kansiossa client.    
Toteuta ClientInter.java tiedostoon Client.java.



Panimo interface public
```
// true jos onnistui
boolean startLoader(Client c);
boolean reserveSilo(Client c, int num);
boolean startSiloPump(Client c, int num);
boolean startProcessor(Client c, int num);
boolean startPump(Client c, int num);
boolean reserverTank(Client c, int num);
boolean startBottlePump(Client c, int num);


boolean inUseLoader();
boolean inUseSilo(int n);
boolean inUseSiloPump(int n);
boolean inUseProcessor(int n);
boolean inUsePump(int n);
boolean inUseTank(int n);
boolean inUseBottlePump(int n);

```

Client interface public

```

void print(String text);

```
