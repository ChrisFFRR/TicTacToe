https://abhiandroid.com/ui/chronometer
https://www.youtube.com/watch?v=RLnb4vVkftc
http://www.androiddeft.com/2017/11/12/shared-preferences-android-kotlin/
https://stackoverflow.com/questions/46051658/how-to-save-data-by-using-sharedpreferences-in-a-fragment
https://www.youtube.com/watch?v=8GCXtCjtg40
https://developer.android.com/topic/libraries/architecture/navigation
https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#7
https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#10


  ## Oppdatering:
  - Jeg har laget en ny branch etter jeg skrev Readme med spørsmål, hvor jeg bruker sharedPreferences, men er litt usikker på om jeg gjør det på riktig måte. Jeg setter pris på om du kunne skrevet en liten tilbakemelding på det jeg har gjort i LogInBranch
  
  ## Oppdatering 2:
  
  -vennligst se på NavigationBranchen da dette er den nyeste løsningen på arkitektur
  
  ## Oppdatering 3:
  - ny branch hvor jeg har begynt å implementere ROOM database for spiller (id, navn og tid)

# Spørsmål til Tor Morten

Jeg skrev først all kode i mainactivity.kt, men har nå gjort det om til en egen fragment. Men er litt usikker på om det er "riktig" måte å behandle en fragment på? Eneste jeg har i mainactivity.kt nå er bare onCreate, så i utgangspunktet så gjorde jeg bare fragmenten til en activity?

## Spørsmål 1 
  - er dette good practice eller ikke..? 
  - Kan jeg bruke en fragment som activity, og bare ha routing til de forskjellige fragmentene i mainActivity? 
  (eller er det bedre å ha fragments som "containere" i en activity)
  
  - Hvis det er innafor, tenker jeg at oppsettet blir at jeg har en fragment for selve spillet, én fragment for log-in screen     og tilslutten fragment for highscore.
  
 ## Oppfølgingsspørsmål til fragments:
  - bruker man livssyklusene til fragment eller activity når man har 1 activity - multiple fragments?
  
 ## Spørsmål 2:
  - Vi gikk gjennom Room og databasebehandling i går, vil du si at det er lurt å bruke denne fremgangsmåten for high-score delen av dette prosjektet? Eller er det nok å skrive en high-score klasse hvor man har en Map som holder på vinner + tid f.eks?
  

  
    
   
   
    

