       IDENTIFICATION DIVISION.
       PROGRAM-ID. LIBRO.
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
                      05 FILLER  PIC X(30) VALUE "ISBN".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE " TITOLO".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "AUTORE".
                      05 FILLER PIC X(1) VALUE "|".
                      05 FILLER  PIC X(30) VALUE "CODICECASAEDITRICE".
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
 

            
           01 RECORDLIBRO.
               05  ISBN            PIC X(13).
               05  TITOLO            PIC X(100).
               05  AUTORE            PIC X(50).
               05  CODICECASAEDITRICE PIC 9(5).
           EXEC SQL END DECLARE SECTION END-EXEC.
      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.


          
           LINKAGE SECTION.
           01 LS-TYPE.
               05 LS-OPERAZIONE1 PIC X(1).
               05 LS-OPERAZIONE2 PIC X(1).
               
           01 LS-RECORD.
               05 LS-ISBN PIC X(13).
               05 LS-TITOLO PIC X(100).
               05 LS-AUTORE PIC X(50).
               05 LS-CODICECASAEDITRICE PIC 9(5).          

           PROCEDURE DIVISION USING LS-TYPE,LS-RECORD.
           MAIN.

           EVALUATE LS-OPERAZIONE1
            WHEN 'd'
               PERFORM DISPLAYALLLIBRI
            WHEN 'i'
               PERFORM INSERTLIBRO
            WHEN 'r'
               PERFORM DELETELIBRO
            WHEN 's'
               PERFORM SEARCHBY
           END-EVALUATE.

           

           SEARCHBY.
           DISPLAY LS-RECORD
           display LS-OPERAZIONE2
           EVALUATE LS-OPERAZIONE2
            WHEN 't'
               PERFORM SEARCHWITHTITLE
            WHEN 'a'
               PERFORM SEARCHWITHAUTORE
            WHEN 'c'
               PERFORM SEARCHWITHCODICECASAEDITRICE
             
           END-EVALUATE
           EXIT PROGRAM.


           SEARCHWITHTITLE.
           MOVE LS-RECORD TO RECORDLIBRO
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
               SELECT * FROM LIBRO WHERE TITOLO = TRIM(:TITOLO)
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDLIBRO
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE ISBN TO WS-COLUMN-1
               MOVE TITOLO TO WS-COLUMN-2
               MOVE AUTORE TO WS-COLUMN-3
               MOVE CODICECASAEDITRICE TO WS-COLUMN-4
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDLIBRO
               END-EXEC
               DISPLAY WS-COLUMNS
           END-PERFORM
           DISPLAY WS-LINE

           
           EXEC SQL
           CLOSE CASA_CURSOR
           END-EXEC.


           SEARCHWITHAUTORE.
           MOVE LS-RECORD TO RECORDLIBRO
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
               SELECT * FROM LIBRO WHERE AUTORE = TRIM(:AUTORE)
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDLIBRO
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE ISBN TO WS-COLUMN-1
               MOVE TITOLO TO WS-COLUMN-2
               MOVE AUTORE TO WS-COLUMN-3
               MOVE CODICECASAEDITRICE TO WS-COLUMN-4
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDLIBRO
               END-EXEC
               DISPLAY WS-COLUMNS
           END-PERFORM
           DISPLAY WS-LINE

           
           EXEC SQL
           CLOSE CASA_CURSOR
           END-EXEC.

           SEARCHWITHCODICECASAEDITRICE.
           MOVE LS-RECORD TO RECORDLIBRO
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
               SELECT * FROM LIBRO
                WHERE CODICECASAEDITRICE = :CODICECASAEDITRICE
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDLIBRO
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE ISBN TO WS-COLUMN-1
               MOVE TITOLO TO WS-COLUMN-2
               MOVE AUTORE TO WS-COLUMN-3
               MOVE CODICECASAEDITRICE TO WS-COLUMN-4
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDLIBRO
               END-EXEC
               DISPLAY WS-COLUMNS
           END-PERFORM
           DISPLAY WS-LINE

           
           EXEC SQL
           CLOSE CASA_CURSOR
           END-EXEC.


           


      ******************************************************************
      **************INSERISCI LA CASA EDITRICE**************************
      ******************************************************************
      ******************************************************************
           INSERTLIBRO.
           MOVE LS-RECORD TO RECORDLIBRO
           DISPLAY RECORDLIBRO
           EXEC SQL
           INSERT INTO LIBRO(ISBN,TITOLO,AUTORE,CODICECASAEDITRICE) 
           VALUES 
           (TRIM(:ISBN),TRIM(:TITOLO),TRIM(:AUTORE),
           :CODICECASAEDITRICE)
           END-EXEC.
           DISPLAY "ESEGUITO INSERIMENTO LIBRO"
           IF SQLCODE NOT = 0 PERFORM ERROR-RUNTIME STOP RUN.
           EXIT PROGRAM.


      ******************************************************************
      **************MOSTRA I LIBRI****************************
      ******************************************************************
      ******************************************************************

           DISPLAYALLLIBRI.
           EXEC SQL
               DECLARE CASA_CURSOR CURSOR FOR
               SELECT * FROM LIBRO
           END-EXEC
           EXEC SQL
           OPEN CASA_CURSOR
           END-EXEC
           
           EXEC SQL
               FETCH CASA_CURSOR INTO :RECORDLIBRO
           END-EXEC
           DISPLAY WS-LINE
           DISPLAY WS-HEADER-COLUMNS
           DISPLAY WS-LINE
           PERFORM UNTIL SQLCODE NOT = 0
               MOVE ISBN TO WS-COLUMN-1
               MOVE TITOLO TO WS-COLUMN-2
               MOVE AUTORE TO WS-COLUMN-3
               MOVE CODICECASAEDITRICE TO WS-COLUMN-4
               EXEC SQL
                   FETCH CASA_CURSOR INTO :RECORDLIBRO
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
           DELETELIBRO.
           MOVE LS-RECORD TO RECORDLIBRO
           EXEC SQL
               DELETE FROM LIBRO  WHERE ISBN = :ISBN
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




