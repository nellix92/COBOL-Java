       IDENTIFICATION DIVISION.
       PROGRAM-ID. OPERATORE.
       
       DATA DIVISION.
       
       WORKING-STORAGE SECTION.
       01 WS-USER-CHOICE           PIC 9.
       01 WS-EXIT-PROGRAM          PIC X VALUE 'N'.
       01 WS-LIBRO-CHIAVE          PIC X(50).
       01  WS-LIBRO.
           05 WS-ID-LIBRO          PIC X(13).
           05 WS-USERNAME          PIC X(50).
           05 WS-DATALIBRO          PIC X(10).
           
           

        01  L-LIBRO.
           05 L-IBCN PIC X(13).
           05 L-TITOLO-LIBRO          PIC X(100).
           05 L-AUTORE-LIBRO          PIC X(50).
           05 L-CODICE-LIBRO          PIC 9(5).
       01 WS-CHIAVE-SCELTA         PIC 9.
       01 WS-CODICE-CASA-EDITRICE  PIC 9(5).
       
       LINKAGE SECTION.
           01 LS-USERNAME PIC X(50).
       
       PROCEDURE DIVISION USING LS-USERNAME.
       MAIN-PROCEDURE.
           PERFORM UNTIL WS-EXIT-PROGRAM = 'Y'
       
      ******Visualizza il menu principale
       
               DISPLAY "Menu Biblioteca Online"
               DISPLAY "1. Visualizza libri"
               DISPLAY "2. Visualizza case editrici"
               DISPLAY "3. Visualizza libri per chiave di ricerca"
               DISPLAY "4. Prenotare un libro"
               DISPLAY "5. Esci"
               DISPLAY "Inserisci la tua scelta (1-5): "
               
      ******Accetta l'input dell'utente
              ACCEPT WS-USER-CHOICE
       
      ******Esegue la scelta dell'utente usando EVALUATE
               EVALUATE WS-USER-CHOICE
                   WHEN 1
      ******Chiamata alla procedura per visualizzare i libri
                       PERFORM VISUALIZZA-LIBRI
                   WHEN 2
      ******Chiamata alla procedura per visualizzare le case editrici
                       PERFORM VISUALIZZA-CASE-EDITRICI
                   WHEN 3
      ******Chiamata alla procedura per visualizzare i libri per chiave di ricerca
                       PERFORM VISUALIZZA-LIBRI-CHIAVE
                   WHEN 4
      ******Chiamata alla procedura per prenotare un libro
                       PERFORM PRENOTARE-LIBRO
                   WHEN 5
      ******Imposta il flag per uscire dal programma
                       MOVE 'Y' TO WS-EXIT-PROGRAM
                       EXIT PROGRAM
                   WHEN OTHER
      ******Gestisce scelte non valide
                       DISPLAY "Scelta non valida. Riprova."
               END-EVALUATE
           END-PERFORM
       
      ******Messaggio di ringraziamento e fine del programma
           DISPLAY "Grazie per aver usato la Biblioteca Online!".
           STOP RUN.
       
      *****Procedura per visualizzare i libri
       VISUALIZZA-LIBRI.
           DISPLAY "Esecuzione della visualizzazione dei libri.".
           CALL 'LIBRO' USING BY CONTENT 'd'.
      ******Qui va il codice per visualizzare i libri
           
       
      ******Procedura per visualizzare le case editrici
       VISUALIZZA-CASE-EDITRICI.
           DISPLAY 
           "Esecuzione della visualizzazione delle case editrici.".
           CALL 'CASAEDITRICE' USING BY CONTENT 'd'.
           
      ****** Qui va il codice per visualizzare le case editrici
           
       
      ******Procedura per visualizzare i libri per chiave di ricerca
       VISUALIZZA-LIBRI-CHIAVE.
         DISPLAY "Scegli il criterio di ricerca:"
           DISPLAY "1. Titolo"
           DISPLAY "2. Autore"
           DISPLAY "3. Codice Casa Editrice"
           DISPLAY "Inserisci la tua scelta (1-3): "
           ACCEPT WS-CHIAVE-SCELTA

           EVALUATE WS-CHIAVE-SCELTA
               WHEN 1
                   DISPLAY "Inserisci il titolo del libro: "
                   ACCEPT L-TITOLO-LIBRO
                   DISPLAY "Hai inserito il titolo: " L-TITOLO-LIBRO
                   CALL 'LIBRO' USING BY CONTENT 'st', L-LIBRO 
                   
               WHEN 2
                   DISPLAY "Inserisci l'autore del libro: "
                   ACCEPT L-AUTORE-LIBRO
                   DISPLAY "Hai inserito l'autore: " L-AUTORE-LIBRO
                    CALL 'LIBRO' USING BY CONTENT 'sa', L-LIBRO 
               WHEN 3
                   DISPLAY "Inserisci il codice della casa editrice: "
                   ACCEPT L-CODICE-LIBRO
                   DISPLAY 
                   "Hai inserito il codice: " L-CODICE-LIBRO
                   CALL 'LIBRO' USING BY CONTENT 'sc', L-LIBRO 
                  
               WHEN OTHER
                   DISPLAY "Scelta non valida. Riprova."
                 
           END-EVALUATE.
           
          
      ******Qui va il codice per la ricerca dei libri per chiave
           
       
      ******Procedura per prenotare un libro
       PRENOTARE-LIBRO.
           DISPLAY "Esecuzione della prenotazione del libro.".
          
           
           DISPLAY "Inserisci il codice del libro: ".
           ACCEPT WS-ID-LIBRO
           DISPLAY "Inserisci DATA del libro: ".
           ACCEPT WS-DATALIBRO
           DISPLAY "Hai inserito i seguenti dati: ".
           MOVE LS-USERNAME TO WS-USERNAME.
           
           DISPLAY "Codice: " WS-ID-LIBRO.
           CALL 'PRENOTAZIONE' USING 'i', WS-LIBRO.
           
            
      ******Qui va il codice per prenotare un libro