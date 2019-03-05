https://abhiandroid.com/ui/chronometer
https://www.youtube.com/watch?v=RLnb4vVkftc

# Spørsmål til Tor Morten

Jeg skrev først all kode i mainactivity.kt, men har nå gjort det om til en egen fragment. Men er litt usikker på om det er "riktig" måte å behandle en fragment på? Eneste jeg har i mainactivity.kt nå er bare onCreate, så i utgangspunktet så gjorde jeg bare fragmenten til en activity?

## Spørsmål 1 
  - er dette good practice eller ikke..? 
  - Kan jeg bruke en fragment som activity, og bare ha routing til de forskjellige fragmentene i mainActivity? 
  (eller er det bedre å ha fragments som "containere" i en activity)
  
  - Hvis det er innafor, tenker jeg at oppsettet blir at jeg har en fragment for selve spillet, én fragment for log-in screen     og tilslutten fragment for highscore.
  
 ## Oppfølgingsspørsmål til fragments:
  - bruker man livssyklusene til fragment eller activity når man vil lagre data i onPause, onSavedInstance etc?
  
 ## Spørsmål 2:
  - Vi gikk gjennom Room og databasebehandling i går, vil du si at det er lurt å bruke denne fremgangsmåten for high-score delen av dette prosjektet? Eller er det nok å skrive en high-score klasse hvor man har en Map som holder på vinner + tid f.eks?
  
    
   
   
    

