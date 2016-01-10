# hoj2

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


```

Client interface public

```
void updateSilo(ContainerData d, int num);
void updateLoader();
void updateSiloPump(int num);
void updateProcessor(ContainerData d, int num);
void updateTank(ContainerData d, int num);
voidUpdateBottlePump(int num); 

```
