       IDENTIFICATION DIVISION.
       PROGRAM-ID. RUOLOTABLEUTIL.
       AUTHOR. ANOIR.
       DATA DIVISION.
           
           WORKING-STORAGE SECTION.
           01 VALUESTABLE PIC  9(5) VALUE ZERO. 
           01 WS-CREDENZIALI.
               05 WS-USERNAME PIC X(50) VALUE SPACE.
               05 WS-PASSWORD PIC X(50) VALUE SPACE.
      *****************************************************************
      *****************INIZIO DEI COMANDI SQL**************************
      *****************************************************************
           EXEC SQL BEGIN DECLARE SECTION END-EXEC.
           01 DBNAME                PIC X(30) VALUE SPACE.
 
           01 RECORDRUOLO.
               05 RUOLO PIC X(30).
               05 DESCRIZIONE PIC X(100).
           EXEC SQL END DECLARE SECTION END-EXEC.
      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.


           LINKAGE SECTION.
           01 LS-USERNAME PIC X(50).
           01 LS-RUOLO PIC X(30).
           01 LS-TYPE PIC X(1).

           
           PROCEDURE DIVISION USING LS-USERNAME,LS-RUOLO,LS-TYPE.
           MAIN.
           EVALUATE LS-TYPE
               WHEN 'g'
                   PERFORM GETUSERROLE
               WHEN 'd'
                   PERFORM DISPLAYALLROLES

           END-EVALUATE.
           EXIT PROGRAM.









           GETUSERROLE.
           MOVE LS-USERNAME TO WS-USERNAME
           EXEC SQL
               SELECT RUOLO INTO :RUOLO FROM UTENTE
               WHERE USERNAME=TRIM(:WS-USERNAME)
           END-EXEC
           MOVE RUOLO TO LS-RUOLO
           EXIT PROGRAM.
           
           
           DISPLAYALLROLES.
           EXEC SQL
               DECLARE C1 CURSOR FOR
               SELECT RUOLO FROM RUOLO
           END-EXEC
           EXEC SQL
               OPEN C1
           END-EXEC
           

           EXEC SQL
                   FETCH C1 INTO :RUOLO
           END-EXEC
           PERFORM UNTIL SQLCODE NOT = 0
               DISPLAY RUOLO
               EXEC SQL
               FETCH C1
                   INTO :RUOLO
               END-EXEC
           END-PERFORM

           EXEC SQL
               CLOSE C1
           END-EXEC
           EXIT PROGRAM.
