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
  - ny branch (DataBase branch) hvor jeg har implementert ROOM database for spiller (id, navn og tid). Dette er nyeste versjon, og databasen fungerer. 
  
  ## Oppdatering 4:
 - Har merget til master, så master er nyeste versjon. Trenger å implementere AI, så er jeg mer eller mindre ferdig med TTT :)
 
 ## Oppdatering 5:
 
 - Version 1.0 i master! Om du kan, gjerne si om det er noe som mangler eller om det dekker kravene :)
 

# Spørsmål til Tor Morten

Jeg skrev først all kode i mainactivity.kt, men har nå gjort det om til en egen fragment. Men er litt usikker på om det er "riktig" måte å behandle en fragment på? Eneste jeg har i mainactivity.kt nå er bare onCreate, så i utgangspunktet så gjorde jeg bare fragmenten til en activity?

## Spørsmål 1 
  - er dette good practice eller ikke..? 
  - Kan jeg bruke en fragment som activity, og bare ha routing til de forskjellige fragmentene i mainActivity? 
  (eller er det bedre å ha fragments som "containere" i en activity)
  
  - Hvis det er innafor, tenker jeg at oppsettet blir at jeg har en fragment for selve spillet, én fragment for log-in screen     og tilslutten fragment for highscore.
  
 ## Oppfølgingsspørsmål til fragments:
  - bruker man livssyklusene til fragment eller activity når man har 1 activity - multiple fragments?
  

  

  

  
    
   
   
    

