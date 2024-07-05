       IDENTIFICATION DIVISION.
           PROGRAM-ID. AMMINISTRATORE.

       ENVIRONMENT DIVISION.
       DATA DIVISION.
       WORKING-STORAGE SECTION.

       01  WS-ADMIN    PIC 99.


       01 WS-RUOLO PIC X(30).
       
       01 UTENTE.
             05  USERNAME     PIC x(50).

             05  PASSWORD     PIC X(50).
             05  NOME         PIC X(50).
             05  COGNOME      PIC X(50).
             05  INDIRIZZO    PIC X(100).
             05 U-RUOLO PIC X(20).
       
       
       01  RUOLO        PIC 9 VALUE 0.
       
       01  LIBRO.
            05  ISBN         PIC X(13).
            05  TITOLO            PIC X(100).
            05  AUTORE            PIC X(50).
            05 CODICECASAEDITRICE PIC 9(5).
       
       01  CASA-EDITRICE.
            05  CODICE-CASA PIC 9(5).
            05  NOME-CASA-EDITRICE  PIC X(100).

            05  CITTA-CASA-EDITRICE  PIC X(50).

            05  INDIRIZZO-CASA-EDITRICE  PIC X(100).

       01  PRENOTAZIONE-ISBN      PIC 9(13).

       LINKAGE SECTION.
           01 LS-USERNAME PIC X(50).

           01 LS-RUOLO PIC X(30).

       PROCEDURE DIVISION USING LS-USERNAME,LS-RUOLO.
       MENU-AMMINISTRATORE.
           PERFORM WITH TEST AFTER UNTIL WS-ADMIN = 0
               DISPLAY 'MENU AMMINISTRATORE'
               DISPLAY '1. Inserisci Nuovo Utente'
               DISPLAY '2. Cancella Utente'
               DISPLAY '3. Visualizza Utenti'
               DISPLAY '4. Inserisci Libro'
               DISPLAY '5. Cancella Libro'
               DISPLAY '6. Visualizza Libri'
               DISPLAY '7. Inserisci Nuova Casa Editrice'
               DISPLAY '8. Cancella Casa Editrice'
               DISPLAY '9. Visualizza Case Editrici'
               DISPLAY '10. Visualizza Prenotazioni'
               IF LS-RUOLO = 'SUPERAMMINISTRATORE' THEN
               DISPLAY '11. Visualizza lista accessi per utente'
               END-IF
               DISPLAY '0. Esci'
               ACCEPT WS-ADMIN

               EVALUATE WS-ADMIN
                   WHEN 1
                      PERFORM INSERISCI-NUOVO-UTENTE
                   WHEN 2
                     PERFORM CANCELLA-UTENTE
                   WHEN 3
                       PERFORM VISUALIZZA-UTENTI
                   WHEN 4
                     PERFORM INSERISCI-LIBRO
                   WHEN 5
                      PERFORM CANCELLA-LIBRO
                   WHEN 6
                      PERFORM VISUALIZZA-LIBRI
                   WHEN 7
                      PERFORM INSERISCI-CASA-EDITRICE
                   WHEN 8
                      PERFORM CANCELLA-CASA-EDITRICE
                   WHEN 9
                      PERFORM VISUALIZZA-CASE-EDITRICI
                   WHEN 10
                      PERFORM VISUALIZZA-PRENOTAZIONI
                   WHEN 11
      *              IF LS-RUOLO = 'SUPERAMMINISTRATORE' THEN
                      
      *              END-IF
                   WHEN 0
                       DISPLAY 'Uscito.'
                       MOVE ZERO TO WS-ADMIN
                       EXIT PROGRAM
                   WHEN OTHER
                       DISPLAY 'Opzione non valida, riprova.'
               END-EVALUATE
           END-PERFORM.
           

           INSERISCI-NUOVO-UTENTE.
           DISPLAY 'Inserisci Nome:'
           ACCEPT NOME
           DISPLAY 'Inserisci Cognome:'
           ACCEPT COGNOME
           DISPLAY 'Inserisci Username:'
           ACCEPT USERNAME
           DISPLAY 'Inserisci Indirizzo:'
           ACCEPT INDIRIZZO
           DISPLAY 'Password:'
           ACCEPT PASSWORD
           
           IF LS-RUOLO = 'SUPERAMMINISTRATORE' THEN
              DISPLAY 
           'Inserisci Ruolo: 1(Amministratore) 2(OPER) 3(SUPERADMIN)' 
           ACCEPT RUOLO
           ELSE
           DISPLAY 
           'Inserisci Ruolo: 1(Amministratore) 2(OPER)' 
            ACCEPT RUOLO
           END-IF

           EVALUATE RUOLO
            WHEN 1
             MOVE 'AMMINISTRATORE' TO U-RUOLO
             CALL 'UTENTE' USING 'i',UTENTE
            WHEN 2 
            MOVE 'OPERATORE' TO U-RUOLO
             CALL 'UTENTE' USING 'i',UTENTE
              WHEN 1
             MOVE 'AMMINISTRATORE' TO U-RUOLO
             CALL 'UTENTE' USING 'i',UTENTE
            WHEN 3 
             IF LS-RUOLO = 'SUPERAMMINISTRATORE' THEN
            MOVE 'SUPERAMMINISTRATORE' TO U-RUOLO
             CALL 'UTENTE' USING 'i',UTENTE
             ELSE
             DISPLAY "NON HAI I PERMESSI PER FARLO"
             END-IF
            END-EVALUATE.
            

          

      *     PERFORM SALVA-UTENTE.
       
           
           
      *     SALVA-UTENTE.
      
      *    CANCELLA UTENTE TRANNE SUPER-AMMINISTRATORE*****************
           CANCELLA-UTENTE.
           DISPLAY 'Inserisci Nome Utente da rimuovere:'
           ACCEPT USERNAME
           CALL 'RUOLOTABLEUTIL' USING USERNAME,WS-RUOLO,'g'
           IF WS-RUOLO = 'SUPERAMMINISTRATORE' THEN
               DISPLAY 'L UTENTE HA PRIVILEGI PIU ALTI'
           ELSE
           CALL 'UTENTE' USING 'r',UTENTE
           END-IF.
      *    PERFORM RIMUOVI-UTENTE.
           
      *    RIMUOVI-UTENTE.
      *    DISPLAY 'Utente rimosso.'.

           VISUALIZZA-UTENTI.
           DISPLAY 'Elenco di tutti gli Utenti: '.
           CALL 'UTENTE' USING BY CONTENT 'd'.
      *    PERFORM MOSTRA-UTENTI.

      *    MOSTRA-UTENTI.
      *    DISPLAY 'Elenco Utenti: '.
           

           INSERISCI-LIBRO.
           DISPLAY 'Inserisci Titolo:'
           ACCEPT TITOLO
           DISPLAY 'Inserisci Autore:'
           ACCEPT AUTORE
           DISPLAY 'INSERISCI CODICE CASA EDITRICE:'
           ACCEPT CODICECASAEDITRICE
           DISPLAY 'Inserisci ISBN:'
           ACCEPT ISBN.
           CALL 'LIBRO' USING BY CONTENT 'i', LIBRO.



           CANCELLA-LIBRO.
              DISPLAY 'Inserisci ISBN del libro da cancellare:'
              ACCEPT ISBN.
      *        PERFORM RIMUOVI-LIBRO.
              CALL 'LIBRO' USING BY CONTENT 'r', LIBRO.
      *    RIMUOVI-LIBRO.
      *        DISPLAY 'Libro rimosso.'.


    
           VISUALIZZA-LIBRI.
               DISPLAY 'Elenco Libri: '.
               CALL 'LIBRO' USING BY CONTENT 'd' .       

    
           INSERISCI-CASA-EDITRICE.
               DISPLAY 'Inserisci Nome Casa Editrice:'
                ACCEPT  NOME-CASA-EDITRICE
               DISPLAY 'Inserisci città Casa Editrice:'
                ACCEPT  CITTA-CASA-EDITRICE
               DISPLAY 'Inserisci Indirizzo Casa Editrice:'
                ACCEPT  INDIRIZZO-CASA-EDITRICE.
                CALL 'CASAEDITRICE' USING BY CONTENT 'r', CASA-EDITRICE.
      *        PERFORM SALVA-CASA-EDITRICE.

      *    SALVA-CASA-EDITRICE.
      *        DISPLAY 'Casa Editrice salvata.'.

           CANCELLA-CASA-EDITRICE.
               DISPLAY 'Inserisci ID Casa Editrice da cancellare:'
               ACCEPT CODICE-CASA.
               CALL 'CASAEDITRICE' USING BY CONTENT 'r', CASA-EDITRICE.
      *        PERFORM RIMUOVI-CASA-EDITRICE.

      *       RIMUOVI-CASA-EDITRICE.
      *       DISPLAY 'Casa Editrice rimossa.'.
           
    
           VISUALIZZA-CASE-EDITRICI.
               DISPLAY 'Elenco Case Editrici: '.
      *        PERFORM MOSTRA-CASE-EDITRICI.
               CALL 'CASAEDITRICE' USING 'd'.
    
           VISUALIZZA-PRENOTAZIONI.
               DISPLAY 'Elenco Prenotazioni: '.
               CALL 'PRENOTAZIONE' USING 'd'.
      *        PERFORM MOSTRA-PRENOTAZIONI.
