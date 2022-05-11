# LittleStarsforLittleWars 

Little Stars for Little Wars  è un gioco di strategia spaziale.
Hai un obiettivo semplice: catturare e conquistare tutti i sistemi stellari nemici.
Ogni sistema stellare produrrà delle navi in base al proprio livello.

I sistemi stellari vengono rappresentati dai nodi e gli archi rappresentano i collegamenti che ci sono tra di loro.

# Logica del Gioco
Suddiviso in due parti:
* Nella prima parte il nodo si occuperà di conquistare altri nodi.
* Nella seconda parte il nodo si occuperà di mandare le navi ai nodi vicini che sono della stessa squadra.


# Prima parte:il Nodo conquista altri nodi
* un nodo si impossessa di un altro nodo(neutro o nemico),solo se è collegato.
* il nodo sceglie il nodo piu conveniente da impossessare in base ai seguienti  parametri:
* Priorità sul nodo nemico in caso ci siano sia nodi neutri che nemici.
* Livello piu alto.
* Costo inferiore.
* un nodo non puo essere impossessato da piu squadre contemporaneamente.
* un nodo  puo impossessarsi di un altro nodo solo se il costo è maggiore
* un nodo non  puo impossessarsi di un altro nodo se hanno la stessa squadra

# Seconda parte:il Nodo manda le navi ai propri vicini
* se il nodo ha tutti i nodi vicini della stessa squadra allora manderà le proprie navi ai vicini.
* il nodo sceglie il nodo piu conveniente a cui mandare le navi in base ai seguienti  parametri:
* Nodo vicino che ha a sua volta un vicino dell'altra squadra.
* Nodo vicino che ha un livello inferiore.
* A parità di livello il nodo che possiede  meno unità.







# INTELLIGENZA ARTIFICIALE-Programma ASP

* nodo(ID,Costo,Livello)
    ID=identifica un nodo.
    Costo=indica il numero di navi che ha attualmente il nodo, o il numero di navi che il nodo  richiede per essere conquistato.
    livello=1,2,3 per la creazione delle navi

* arco(NodoX,NodoY)	
   arco collega NodoX con NodoY

* possesso(Nodo,Squadra,IDPossesso).
     indica quale squadra ha il possesso di un nodo.


Questo programma si basa sul fatto di rendere un nodo intelligente, per ogni singolo nodo che appartiene ad una squadra verrà eseguito il programma e quindi
potrà compiere delle scelte:
* impossessarsi o non impossessarsi di un nodo? Qual è il nodo piu conveniente da impossessare? 
* Se i nodi sono della stessa squadra a chi mandare le navi?


# Dettagli sul programma
* Aggiornamento dei dati e  Conflitti gestiti tramite codice.
* Introduzione Id possesso,associato ad un possesso.                                     


# ID Possesso
Grazie all'ID Possesso riusciamo a capire se il nodo è quello principale, un nodo che appartiene gia ad una squadra oppure un nodo che è stato impossessato durante
la passata.

* -2 indica il nodo principale, che potrà compiere scelte.
* -1 indica un nodo che ha gia una squdra.
* n indica che tale nodo è stato conquistato da un nodo n durante la passata.

Ogni nodo(tra quelli che appartengono gia ad una squadra ), continueranno a fare delle scelte fin quando il gioco non finisce.
Un nodo può fare solo una scelta per passata, ovvero puo impossessarsi solo di un nodo oppure puo mandare le navi solo ad un nodo, questo perchè i dati si aggiornano solo quando il nodo finirà la passata.



# Altre informazioni

# Thread-2 tipologie di thread:
* I primo Thread incarna la figura nodo, che potrà eseguire delle scelte
* Il secondo thread si occuperà di scorrere tutti i nodi e in base al livello del nodo aggiungerà delle navi.

# Interfaccia Grafica
Framework Swing in Java basato sul framework AWT utilizzato per creare applicazioni GUI proprio come AWT.
