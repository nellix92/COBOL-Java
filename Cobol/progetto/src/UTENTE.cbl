       IDENTIFICATION DIVISION.
       PROGRAM-ID. UTENTE.
      ******************************************************************
      **************LIBRERIA PER OPERAZIONE TABELLA*********************
      ********************UTENTE********************************
      ******************************************************************
       AUTHOR. MATTEO.
       DATA DIVISION.
           
           WORKING-STORAGE SECTION.
           01 VALUESTABLE PIC  9(5) VALUE ZERO. 
           01 WS-CREDENZIALI.
               05 WS-USERNAME PIC X(50) VALUE SPACE.
               05 WS-PASSWORD PIC X(50) VALUE SPACE.


      *****************************************************************
      ***********************TABLE FORMATTING**************************
      *****************************************************************
           01  WS-LINE PIC X(146) VALUE ALL "-".

      *****************************************************************
      *****************HEADER TABLE FORMATTING*************************
      *****************************************************************

           01  WS-HEADER-COLUMNS.
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "USERNAME".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "NOME".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "COGNOME".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "INDIRIZZO".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(20) VALUE "RUOLO".
                      05 FILLER PIC X(1) VALUE "|".

      *****************************************************************
      **********************TABLE S COLUMNS FORMATTING****************
      *****************************************************************
                  01  WS-COLUMNS.
                      05 FILLER PIC X(1) VALUE "|".
                      05 WS-COLUMN-1  PIC X(30).
                      05 FILLER PIC X(1) VALUE "|".
                      05 WS-COLUMN-2 PIC X(30).
                      05 FILLER PIC X(1) VALUE "|".
                      05 WS-COLUMN-3 PIC X(30).
                      05 FILLER PIC X(1) VALUE "|".
                      05 WS-COLUMN-4 PIC X(30).
                      05 FILLER PIC X(1) VALUE "|".
                      05 WS-COLUMN-5 PIC X(20).
                      05 FILLER PIC X(1) VALUE "|".
                      
      *****************************************************************
      *****************INIZIO DEI COMANDI SQL**************************
      *****************************************************************
                  EXEC SQL BEGIN DECLARE SECTION END-EXEC.
           01 DBNAME                PIC X(30) VALUE SPACE.
 
           01 RECORDUTENTE.
               05 USERNAME          PIC X(50).
              
               05 PASSWORD          PIC X(50).
               05 NOME              PIC X(50).
               05 COGNOME           PIC X(50).
               05 INDIRIZZO         PIC X(100).
               05 RUOLO             PIC X(20).
           EXEC SQL END DECLARE SECTION END-EXEC.

      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.
          
           LINKAGE SECTION.
           01 LS-TYPE               PIC X(1).
           01 LS-RECORD.
               05 LS-USERNAME       PIC X(50).
               05 LS-PASSWORD       PIC X(50)
               05 LS-NOME           PIC X(50).
               05 LS-COGNOME        PIC X(50).
               05 LS-INDIRIZZO      PIC X(100).
               05 LS-RUOLO          PIC X(20).          

           PROCEDURE DIVISION USING LS-TYPE, LS-RECORD.
           MAIN.
               EVALUATE LS-TYPE
                   WHEN 'd'
                       PERFORM DISPLAYALLUTENTE
                   WHEN 'i'
                       PERFORM INSERTUTENTE
                   WHEN 'r'
                       PERFORM DELETEUTENTE
               END-EVALUATE.
           STOP RUN.

      ******************************************************************
      **************INSERISCI L'UTENTE*********************************
      ******************************************************************
      ******************************************************************
           INSERTUTENTE.
           MOVE LS-RECORD TO RECORDUTENTE
           DISPLAY USERNAME
           EXEC SQL

            INSERT INTO
            UTENTE (USERNAME, PASSWORD, NOME, COGNOME, INDIRIZZO, RUOLO) 
             VALUES 
            (TRIM(:USERNAME),
             TRIM(:PASSWORD), TRIM(:NOME), TRIM(:COGNOME)
            , TRIM(:INDIRIZZO), TRIM(:RUOLO))
           END-EXEC.
           DISPLAY "ESEGUITO INSERIMENTO UTENTE"
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN.
           EXIT PROGRAM.
       
      ******************************************************************
      **************MOSTRA GLI UTENTI***********************************
      ******************************************************************
      ******************************************************************
           DISPLAYALLUTENTE.
               EXEC SQL
                   DECLARE UTENTE_CURSOR CURSOR FOR
               SELECT * 
               FROM UTENTE
               END-EXEC
               EXEC SQL
                   OPEN UTENTE_CURSOR
               END-EXEC
           
               EXEC SQL
                   FETCH UTENTE_CURSOR INTO :RECORDUTENTE
               END-EXEC

               DISPLAY WS-LINE
               DISPLAY WS-HEADER-COLUMNS
               DISPLAY WS-LINE
               PERFORM UNTIL SQLCODE NOT = 0
                   MOVE USERNAME TO WS-COLUMN-1
                   MOVE NOME TO WS-COLUMN-2
                   MOVE COGNOME TO WS-COLUMN-3
                   MOVE INDIRIZZO TO WS-COLUMN-4
                   MOVE RUOLO TO WS-COLUMN-5
                    EXEC SQL
                       FETCH UTENTE_CURSOR INTO :RECORDUTENTE
                   END-EXEC
                   DISPLAY WS-COLUMNS
               END-PERFORM
               DISPLAY WS-LINE

               EXEC SQL
                   CLOSE UTENTE_CURSOR
               END-EXEC

               EXIT PROGRAM.



      ******************************************************************
      **************ELIMINA L'UTENTE'****************************
      ******************************************************************
      ******************************************************************
           DELETEUTENTE.
           MOVE LS-RECORD TO RECORDUTENTE
           EXEC SQL
               DELETE FROM UTENTE  WHERE USERNAME = TRIM(:USERNAME)
           END-EXEC.
           DISPLAY "RIMOZIONE ESEGUITA CASA EDITRICE"
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN.
           EXIT PROGRAM.

           
      ******************************************************************
      **************GESTIONE ERRORI************************************
      ******************************************************************


           ERROR-RUNTIME.
               DISPLAY "*********SQL ERROR***********"
               EVALUATE SQLCODE
                 WHEN +10
                      DISPLAY "RECORD NOT FOUND"
                 WHEN -01
                      DISPLAY "CONNESSIONE FALLITA"
                 WHEN -20
                      DISPLAY "INTERNAL ERROR"
                 WHEN -30
                      DISPLAY "ERRORE POSTGRES"
                      DISPLAY "ERRCODE: " SQLSTATE
                      DISPLAY SQLERRMC
                 WHEN OTHER
                      DISPLAY "ERRORE SCONOSCIUTO"
                      DISPLAY "ERRCODE: " SQLSTATE
                      DISPLAY SQLERRMC
           STOP RUN.
