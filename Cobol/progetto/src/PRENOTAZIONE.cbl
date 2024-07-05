       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRENOTAZIONE.
      ******************************************************************
      **************LIBRERIA PER OPERAZIONE TABELLA*********************
      ********************PRENOTAZIONE********************************
      ******************************************************************
       
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
                      05 FILLER  PIC X(30) VALUE "ISBN".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "USERNAME".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "DATA PRENOTAZIONE".
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

                      
      *****************************************************************
      *****************INIZIO DEI COMANDI SQL**************************
      *****************************************************************
           EXEC SQL BEGIN DECLARE SECTION END-EXEC.
           01 DBNAME                PIC X(30) VALUE SPACE.
 
           01 RECORDPRENOTAZIONE.
               05 ISBN PIC X(13).
               05 USERNAME PIC X(50).
               05 DATA_PRENOTAZIONE PIC X(10).
           EXEC SQL END DECLARE SECTION END-EXEC.
      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.


          
           LINKAGE SECTION.
           01 LS-TYPE PIC X(1).
           01 LS-RECORD.
               05 LS-ISBN PIC X(13).
               05 LS-USERNAME PIC X(50).
               05 LS-DATA_PRENOTAZIONE PIC X(10).       

           PROCEDURE DIVISION USING LS-TYPE,LS-RECORD.
           MAIN.

           EVALUATE LS-TYPE
            WHEN 'd'
               PERFORM DISPLAYPRENOTAZIONE
            WHEN 'i'
               PERFORM INSERTPRENOTAZIONE
           END-EVALUATE.

           
      ******************************************************************
      **************INSERISCI LA CASA EDITRICE**************************
      ******************************************************************
      ******************************************************************
           INSERTPRENOTAZIONE.
           MOVE LS-RECORD TO RECORDPRENOTAZIONE
           EXEC SQL
               INSERT INTO PRENOTAZIONE(ISBN,USERNAME,DATA_PRENOTAZIONE)
               VALUES (TRIM(:ISBN),TRIM(:USERNAME),
               TRIM(:DATA_PRENOTAZIONE))
           END-EXEC.
           DISPLAY "ESEGUITO INSERIMENTO PRENOTAZIONE "
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN.
           EXIT PROGRAM.


      ******************************************************************
      **************MOSTRA LE PRENOTAZIONI****************************
      ******************************************************************
      ******************************************************************

           DISPLAYPRENOTAZIONE.
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
              SELECT ISBN, USERNAME, DATA_PRENOTAZIONE FROM PRENOTAZIONE
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDPRENOTAZIONE
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE ISBN TO WS-COLUMN-1
               MOVE USERNAME TO WS-COLUMN-2
               MOVE DATA_PRENOTAZIONE TO WS-COLUMN-3
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDPRENOTAZIONE
               END-EXEC
               DISPLAY WS-COLUMNS
           END-PERFORM
           DISPLAY WS-LINE

           
           EXEC SQL
           CLOSE CASA_CURSOR
           END-EXEC


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
           