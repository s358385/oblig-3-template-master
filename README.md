# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Kaja Line Åbyholm Reehorst, s358385, s358385@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så brukte jeg programkode 5.2.3 a) fra kompendiet, for å implementere boolean leggInn(T verdi).
Innleggingsalgoritmen starter i rotnoden.
Hvis verdien som skal legges inn er mindre enn nodeverdien, går vi til venstre, hvis ikke til høyre.
Dette gjentas for hver node, helt til vi kommer til slutten av treet.
Verdien blir lagt inn i en ny node, og er barn til den siste noden vi psserte.
Vi bruker Node<T> q, for å holde styr på p.forelder.

I oppgave 2 så brukte jeg en hjelpevariabel Stack<Node> stack, for å implementere int antall(T verdi).
Jeg benytter stack for å traversere treet.
Så finner jeg ut når parameter verdi, er lik nodeverdi og teller antallet ganger dette forekommer.
Tilslutt returnerer jeg dette antallet;

I oppgave 3 brukte jeg programkode 5.1.7 h) for å implementere <T>Node<T> førstePostorden(Node<T> p).
I postorden er den første noden, bladnoden som ligger lengst til venstre i treet.
Ved hjelp av en while-løkke, setter jeg p til å være p.venstre, helt til det ikke er noen venstrebarn igjen.
SÅ går jeg videre over til høyre, og stopper når det ikke er noen høyrebarn igjen.
Tilslutt returnerer jeg den nye p som er den første noden i postorden.
For å implementere <T>Node<T> nestePostorden(Node<T> p), sjekker jeg for ulike tilfeller, hva den neste noden i postorden er.
Hvis p er rotnoden, så er p den siste i postorden, det er ingen neste node og vi returnerer null.
Eller hvis p er høyre barn til sin forelder eller den ikke eksisterer, er forelder den neste.
Eller hvis p er venstre barn til sin forelder og ikke et enebarn, så er den neste noden førstePostorden(høyrebarn).

I oppgave 4 brukte jeg programkode 5.1.15 c) for å
implementere postorden(Oppgave <? super T> oppgave).
Men jeg bruker postorden, istedenfor inorden.
Jeg bruker en while-løkke for å danne en postorden-traversering.
Jeg bruker metoden, nestePostorden for å finne neste metode. Og bruker p ikke er null, som en stopper.
Jeg brukte fasit til oppgave 7, fra kapittel 5.1.7,i kompendiet, for å implementere postorderRecursive(Node<T> p, Oppgave<? super T> oppgave).
Da traverserte jeg treet i postorden rekkefølge, ved å lage et rekursivt kall, først for venstrebarn og så høyrebarn.
