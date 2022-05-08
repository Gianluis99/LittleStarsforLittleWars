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





# Programma ASP

* nodo(ID,Costo,Livello)
    ID=identifica un nodo.
    Costo=indica il numero di navi che ha attualmente il nodo, o il numero di navi che il nodo  richiede per essere conquistato.
    livello=1,2,3 per la creazione delle navi

* arco(NodoX,NodoY)	
   arco collega NodoX con NodoY

* possesso(Nodo,Squadra,Istante).
     indica quale squadra ha il possesso di un nodo in un determinato istante


Questo programma si basa sul fatto di rendere un nodo intelligente, per ogni singolo nodo che appartiene ad una squadra verrà eseguito il programma e quindi
potrà compiere delle scelte:
* impossessarsi o non impossessarsi di un nodo? Qual è il nodo piu conveniente da impossessare? 
* Se i nodi sono della stessa squadra a chi mandare le navi?


# Dettagli sul programma
* Aggiornamento dei dati e  Conflitti gestiti tramite codice.
* Introduzione Id possesso.                                         
* 
*   -1 indica che il possesso c’è sin dall’inizio della passata, quindi  distinguerà 
*    i nodi che sono  impossessati sin dall inizio del ciclo, dai nodi che vengono impossessati durante la passata.


# ID Possesso
Grazie all'ID Possesso riusciamo a capire se il nodo è quello principale, un nodo che appartiene gia ad una squadra oppure un nodo che è stato impossessato durante
la passata.

* -2 indica il nodo principale, che potrà compiere scelte.
* -1 indica un nodo che ha gia una squdra.
* n indica che tale nodo è stato conquistato da un nodo n durante la passata.


tutti i nodi  che appartengono ad una squadra possono fare delle scelte, successivamente eseguiamo l’encodings, su un singolo nodo principale (-2)
Ogni nodo(tra quelli che appartengono gia ad una squadra ), continuerà a fare delle scelte fin quando il gioco non finisce.
Un nodo può fare solo una scelta per passata, ovvero puo impossessarsi solo di un nodo oppure puo mandare le navi solo ad un nodo, questo perchè i dati si aggiornano solo quando il nodo finirà la passata.


 2 tipologie thread:
Il primo Thread incarna il nodo, che potrà eseguire delle scelte
Il terzo thread si occuperà di scorrere tutti i nodi e in base al livello del nodo aggiungerà delle navi