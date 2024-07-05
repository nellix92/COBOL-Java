       IDENTIFICATION DIVISION.
       PROGRAM-ID. CASAEDITRICE.
      ******************************************************************
      **************LIBRERIA PER OPERAZIONE TABELLA*********************
      ********************CASA EDITRICE********************************
      ******************************************************************
       AUTHOR. ANOIR.
       DATA DIVISION.
           
           WORKING-STORAGE SECTION.
           01 VALUESTABLE PIC  9(5) VALUE ZERO. 
           01 WS-CREDENZIALI.
               05 WS-USERNAME PIC X(50) VALUE SPACE.
               05 WS-PASSWORD PIC X(50) VALUE SPACE.


      *****************************************************************
      ***********************TABLE FORMATTING**************************
      *****************************************************************
           01  WS-LINE PIC X(125) VALUE ALL "-".

      *****************************************************************
      *****************HEADER TABLE FORMATTING*************************
      *****************************************************************

           01  WS-HEADER-COLUMNS.
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "CODICE".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "NOME".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "INDIRIZZO".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "CITTA".
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
                      
      *****************************************************************
      *****************INIZIO DEI COMANDI SQL**************************
      *****************************************************************
           EXEC SQL BEGIN DECLARE SECTION END-EXEC.
           01 DBNAME                PIC X(30) VALUE SPACE.
 
           01 RECORDCASAEDITRICE.
               05 CODICE PIC 9(5).
               05 NOME PIC X(100).
               05 INDIRIZZO PIC X(50).
               05 CITTA PIC X(50).
           EXEC SQL END DECLARE SECTION END-EXEC.
      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.


          
           LINKAGE SECTION.
           01 LS-TYPE PIC X(1).
           01 LS-RECORD.
               05 LS-CODICE PIC 9(5).
               05 LS-NOME PIC X(100).
               05 LS-INDIRIZZO PIC X(50).
               05 LS-CITTA PIC X(50).          

           PROCEDURE DIVISION USING LS-TYPE,LS-RECORD.
           MAIN.

           EVALUATE LS-TYPE
            WHEN 'd'
               PERFORM DISPLAYALLCASAEDITRICI
            WHEN 'i'
               PERFORM INSERTCASAEDITRICE
            WHEN 'r'
               PERFORM DELETECASAEDITRICE
           END-EVALUATE.

           




      ******************************************************************
      **************INSERISCI LA CASA EDITRICE**************************
      ******************************************************************
      ******************************************************************
           INSERTCASAEDITRICE.
           MOVE LS-RECORD TO RECORDCASAEDITRICE
           EXEC SQL
               INSERT INTO CASAEDITRICE(NOME,INDIRIZZO,CITTA) 
               VALUES (:NOME,:INDIRIZZO,:CITTA)
           END-EXEC.
           DISPLAY "ESEGUITO INSERIMENTO CASAEDITRICE "
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN
           EXIT PROGRAM.


      ******************************************************************
      **************MOSTRA LE CASE EDITRICI****************************
      ******************************************************************
      ******************************************************************

           DISPLAYALLCASAEDITRICI.
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
               SELECT * FROM CASAEDITRICE
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDCASAEDITRICE
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE CODICE TO WS-COLUMN-1
               MOVE NOME TO WS-COLUMN-2
               MOVE INDIRIZZO TO WS-COLUMN-3
               MOVE CITTA TO WS-COLUMN-4
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDCASAEDITRICE
               END-EXEC
               DISPLAY WS-COLUMNS
           END-PERFORM
           DISPLAY WS-LINE

           
           EXEC SQL
           CLOSE CASA_CURSOR
           END-EXEC


           EXIT PROGRAM.
           
      
      ******************************************************************
      **************ELIMINA LA CASA EDITRICE****************************
      ******************************************************************
      ******************************************************************
           DELETECASAEDITRICE.
           MOVE LS-RECORD TO RECORDCASAEDITRICE
           EXEC SQL
               DELETE FROM CASAEDITRICE  WHERE CODICE_CASA = :CODICE
           END-EXEC.
           DISPLAY "RIMOZIONE ESEGUITA CASA EDITRICE"
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN.
           EXIT PROGRAM.



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

