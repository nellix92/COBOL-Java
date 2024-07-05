       IDENTIFICATION DIVISION.
       PROGRAM-ID. BIBLIOTECA.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
           01  WS-RECORDLOGIN.
                 05 WS-USERNAME PIC X(50).
                 05 WS-PASSWORD PIC X(50).
                 05 WS-COGNOME PIC X(50) VALUE SPACE.
                 05 WS-NOME PIC X(50) VALUE SPACE.
                 05 WS-INDIRIZZO PIC X(100) VALUE SPACE.
           01 WS-LOGGED PIC X(1).
           01 OPTION PIC S9 VALUE ZERO.
           01 USER-ROLE PIC X(30).

           01 WS-OPTIONS.
               05 FILLER PIC X(20) VALUE "1 - Login".
               05 FILLER PIC X(20) VALUE "2 - Registrazione".
               05 FILLER PIC X(20) VALUE "0 - Exit".

              
       PROCEDURE DIVISION.
           
           
      ******************************************************************
      *************MENU DI LOGIN E REGISTRAZIONE*********************
      *************************************************************
      ******************************************************************         
           MAIN.
      ****************CREAZIONE DELLE TABELLE***************************
           CALL 'DBUTIL' USING BY CONTENT 'c'
           DISPLAY "Benvenuto alla biblioteca virtuale!"
           PERFORM UNTIL OPTION = -1
           DISPLAY WS-OPTIONS
           DISPLAY "OPZIONE: " WITH NO ADVANCING
           ACCEPT OPTION
               EVALUATE OPTION
                WHEN 1 
                   PERFORM LOGIN
                WHEN 2
                   PERFORM REGISTRAZIONE
                WHEN 0
                   MOVE -1 TO OPTION
                   
                END-EVALUATE

           END-PERFORM
           PERFORM QUIT
           STOP RUN.
      ******************************************************************
      *************FORM DI LOGIN**************************************
      *************************************************************
      ******************************************************************     
           LOGIN.
               DISPLAY 'Inserisci nome utente: ' WITH NO ADVANCING.
               ACCEPT WS-USERNAME.
               DISPLAY 'Inserisci password:' WITH NO ADVANCING.
               ACCEPT WS-PASSWORD.
      *******************OPERAZIONE DI LOGIN IN DBUTIL******************
               CALL 'DBUTIL' USING 'l',WS-RECORDLOGIN, WS-LOGGED
               IF WS-LOGGED = 'y' THEN
      ****************OTTIENI IL RUOLO DALLA TABELLA RUOLO**************
                   CALL 'RUOLOTABLEUTIL' USING WS-USERNAME,USER-ROLE,'g'
                   DISPLAY "ACCESSO COMPLETATO  COME "USER-ROLE
                   EVALUATE USER-ROLE
                    WHEN 'SUPERAMMINISTRATORE'
                       CALL 'AMMINISTRATORE' USING WS-USERNAME,USER-ROLE
                    WHEN 'OPERATORE'
                       CALL 'OPERATORE' USING WS-USERNAME
                    WHEN 'AMMINISTRATORE'
                       CALL 'AMMINISTRATORE' USING WS-USERNAME,USER-ROLE
               END-IF.
               

           
      ******************************************************************
      ******************REGISTRAZIONE FORM******************************
      ******************************************************************     

           REGISTRAZIONE.
           DISPLAY 'Inserisci nome utente: ' WITH NO ADVANCING.
           ACCEPT WS-USERNAME.
           DISPLAY 'Inserisci password:' WITH NO ADVANCING.
           ACCEPT WS-PASSWORD.
           DISPLAY 'Inserisci nome:' WITH NO ADVANCING.
           ACCEPT WS-NOME.
           DISPLAY 'Inserisci cognome:' WITH NO ADVANCING.
           ACCEPT WS-COGNOME.
           DISPLAY 'Inserisci indirizzo:' WITH NO ADVANCING.
           ACCEPT WS-INDIRIZZO.
           CALL 'DBUTIL' USING 'r',WS-RECORDLOGIN, WS-LOGGED
           IF WS-LOGGED = 'y' THEN
               
               DISPLAY "REGISTRAZIONE COMPLETATA"
               
           ELSE
               DISPLAY "REGISTRAZIONE NON COMPLETATA"
           END-IF.
           
               
           

           QUIT.
           CALL 'DBUTIL' USING BY CONTENT 'q'
           STOP RUN.
