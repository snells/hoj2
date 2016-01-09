# hoj2



###Tehtävän jako
   
Topi toteuttaa palvelimen.   
Vesa toteuttaa Asiakkaan.   
Sakari tekee rajapinnat, viimeistelee ja lähettää.   




####Topi



Toteuta PanimoInter.java oleva interface Tiedostoon Panimo.java ja vaadittavat luokat.   

Ruuvikeitin siirtää rakaa-ainetta 200 kiloa sekunissa, katso jos hoj1 Timer.java:sta apua



#### Vesa


    
Toteuta ClientInter.java tiedostoon Client.java.



Panimo interface public
```
// true jos onnistui
boolean loaderStart(Client c);
boolean siloReserve(Client c, int num);
boolean siloPumpStart(Client c, int num);
boolean processorReserve(Client c, int num);
boolean processorStart(Client c, int num);
boolean pumpStart(Client c, int num);
boolean tankReserve(Client c, int num);
boolean bottlePumpStart(Client c, int num);


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
