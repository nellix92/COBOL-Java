       IDENTIFICATION DIVISION.
       PROGRAM-ID. DBUTIL.
       AUTHOR. ANOIR.
       DATA DIVISION.
           
           WORKING-STORAGE SECTION.
           01 VALUESTABLE PIC  9(5) VALUE ZERO. 
           01 WS-CREDENZIALI.
               05 WS-USERNAME PIC X(50) VALUE SPACE.
               05 WS-PASSWORD PIC X(50) VALUE SPACE.
               05 WS-COGNOME PIC X(50) VALUE SPACE.
               05 WS-NOME PIC X(50) VALUE SPACE.
               05 WS-INDIRIZZO PIC X(100) VALUE SPACE.

      *****************************************************************
      *****************INIZIO DEI COMANDI SQL**************************
      *****************************************************************
           EXEC SQL BEGIN DECLARE SECTION END-EXEC.
           01 DBNAME                PIC X(30) VALUE SPACE.
           01 USERNAME              PIC X(50) VALUE SPACE.
           01 PASSWORD              PIC X(50) VALUE SPACE.
           
           01 RECORDRUOLO.
               05 RUOLO PIC X(30).
               05 DESCRIZIONE PIC X(100).
           EXEC SQL END DECLARE SECTION END-EXEC.
      *****************************************************************
      ********************INCLUDO SQLCA********************************
      *****************************************************************
           EXEC SQL INCLUDE SQLCA END-EXEC.


           LINKAGE SECTION.
           01 LS-TYPE.
              05 LS-OPERAZIONE1 PIC X(1).
           01 LS-RECORD PIC X(500).
           01 LS-REPLY PIC X(1).
           
           
       PROCEDURE DIVISION USING LS-TYPE,LS-RECORD,LS-REPLY.
           MAIN.
           EVALUATE TRUE
            WHEN LS-OPERAZIONE1='c'
               PERFORM CONNECTIONTODB
               PERFORM CREATEALLTABLES
            WHEN LS-OPERAZIONE1 ='l'
               PERFORM LOGIN
            WHEN LS-OPERAZIONE1='q'
               PERFORM COMMITANDCLOSE
               STOP RUN
            WHEN LS-OPERAZIONE1='r'
                 PERFORM REGISTRAZIONE
                 EXIT PROGRAM
            END-EVALUATE.
           EXIT PROGRAM.


      ******************************************************************
      ********************CONNESSIONE AL DATABASE***********************
      ******************************************************************
           CONNECTIONTODB.
           DISPLAY "Connessione alla biblioteca virtuale...".
           MOVE "biblioteca_db@db"        TO DBNAME
           MOVE "postgres"        TO USERNAME
           MOVE SPACE              TO PASSWORD
           EXEC SQL
               CONNECT :USERNAME IDENTIFIED BY :PASSWORD USING :DBNAME
           END-EXEC.
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.       
           DISPLAY "Sei connesso nella biblioteca virtuale.".


           LOGIN.
           MOVE LS-RECORD TO WS-CREDENZIALI
      ******************************************************************
      ************CONTA UTENTI CON LA STESSA PASSWORD E NOME************
      ******************************************************************

           EXEC SQL
               SELECT COUNT(*) INTO :VALUESTABLE FROM UTENTE
               WHERE USERNAME=TRIM(:WS-USERNAME) AND 
               PASSWORD=TRIM(:WS-PASSWORD)
           END-EXEC    
      ******************************************************************
      *******SE IL VALORE E' DIVERSO DA ZERO****************************
      *******L'ACCESSO E' ESEGUITO**************************************
      ****************************************************************** 
           IF VALUESTABLE = ZERO THEN
               
               MOVE 'n' TO LS-REPLY
               DISPLAY "ACCESSO NON ESEGUITO"

           ELSE
               MOVE 'y' TO LS-REPLY
           END-IF.      


           
      ******************************************************************
      *******CREA TUTTE LA TABELLE**************************************
      ******************************************************************     

           CREATEALLTABLES.
           PERFORM CREATETABLERUOLO.
           PERFORM CREATETABLECASAEDITRICE.
           PERFORM CREATETABLEUTENTE.
           PERFORM CREATETABLELIBRO.
           PERFORM CREATETABLEPRENOTAZIONE.

      ******************************************************************
      **************REGISTRAZIONE**************************************
      ******************************************************************     

           REGISTRAZIONE.
           MOVE LS-RECORD TO WS-CREDENZIALI
           DISPLAY WS-USERNAME
           EXEC SQL
           INSERT INTO 
           UTENTE(USERNAME,PASSWORD,NOME,COGNOME,INDIRIZZO,RUOLO) 
           VALUES  (TRIM(:WS-USERNAME), TRIM(:WS-PASSWORD),
           TRIM(:WS-COGNOME), TRIM(:WS-NOME),
           :WS-INDIRIZZO,'OPERATORE')
           END-EXEC
           MOVE 'y' TO LS-REPLY
           DISPLAY "STO PROVANDO A REGISTRARE..."
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN
           EXIT PROGRAM.


           CREATETABLERUOLO.
      ***************CREATE TABLE RUOLO IF NOT EXISTS*******************
           EXEC SQL
           CREATE TABLE IF NOT EXISTS RUOLO (
               RUOLO VARCHAR(30) PRIMARY KEY,
               DESCRIZIONE VARCHAR(100)
           )          
           END-EXEC.
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.    
           DISPLAY "TABLE CREATED"
      ***************CHECK IF THE TABLE IS EMPTY************************   
           EXEC SQL
           SELECT COUNT(*) INTO :VALUESTABLE FROM RUOLO
           END-EXEC.
           
           
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN. 
           DISPLAY "DONETHECOUNT"  
           IF VALUESTABLE = ZERO THEN
      ******************INSERISCE I RUOLI******************************
               EXEC SQL
               INSERT INTO RUOLO (RUOLO, DESCRIZIONE) VALUES 
                   ('SUPERAMMINISTRATORE', 'Ha tutti i permessi') 
               END-EXEC
 
               EXEC SQL
               INSERT INTO RUOLO (RUOLO, DESCRIZIONE) VALUES 
                   ('AMMINISTRATORE', 'Ha permessi amministrativi')
               END-EXEC
               EXEC SQL
               INSERT INTO RUOLO (RUOLO, DESCRIZIONE) VALUES 
                   ('OPERATORE', 'Ha permessi operativi')
               END-EXEC
           END-IF.
           
           
           
           
           CREATETABLECASAEDITRICE.
      ***************CREATE TABLE RUOLO IF NOT EXISTS*******************
           EXEC SQL
           CREATE TABLE IF NOT EXISTS CasaEditrice (
               CODICE_CASA SERIAL PRIMARY KEY,
               NOME VARCHAR(100),
               INDIRIZZO VARCHAR(100),
               CITTA VARCHAR(50)
           );
           END-EXEC.


           CREATETABLEUTENTE.
      ***************CREATE TABLE UTENTE IF NOT EXISTS*******************
           EXEC SQL
           CREATE TABLE IF NOT EXISTS UTENTE (
               USERNAME VARCHAR(50) PRIMARY KEY,           
               PASSWORD VARCHAR(50),  
               NOME VARCHAR(50),        
               COGNOME VARCHAR(50),  
               INDIRIZZO VARCHAR(100),   
               RUOLO VARCHAR(20),
               CONSTRAINT "fk_ruolo" FOREIGN KEY(RUOLO) 
               REFERENCES RUOLO(RUOLO)
           )
           END-EXEC
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.    
           DISPLAY "TABLE CREATED"
      ***************CHECK IF THE TABLE IS EMPTY************************   
           EXEC SQL
           SELECT COUNT(*) INTO :VALUESTABLE FROM UTENTE
           END-EXEC.
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.    
      ***************INSERT A SUPERADMIN********************************   

           IF VALUESTABLE = ZERO THEN
               EXEC SQL
                   INSERT INTO UTENTE 
                   VALUES ('Admin','Password','Matteo','Sintini',
                   'Lazio','SUPERAMMINISTRATORE')
               END-EXEC
                IF SQLCODE NOT = ZERO 
                PERFORM ERROR-RUNTIME STOP RUN    
           END-IF.
           

       
      ***************CREATE TABLE LIBRO IF NOT EXISTS*******************
           CREATETABLELIBRO.
           EXEC SQL
                  CREATE TABLE IF NOT EXISTS LIBRO (
                      ISBN CHAR(13) PRIMARY KEY,
                      TITOLO VARCHAR(100),
                      AUTORE VARCHAR(50),
                      CODICECASAEDITRICE SERIAL,
                      CONSTRAINT "FK_CASAEDITRICE" 
                      FOREIGN KEY(CODICECASAEDITRICE) 
                      REFERENCES CASAEDITRICE(CODICE_CASA)
                  )        
           END-EXEC.  
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.
      ***************CREATE TABLE PRENOTAZIONE IF NOT EXISTS**********
           CREATETABLEPRENOTAZIONE.
           EXEC SQL
               CREATE TABLE IF NOT EXISTS PRENOTAZIONE (
                      ISBN CHAR(13),
                      USERNAME VARCHAR(50),
                      DATA_PRENOTAZIONE CHAR(10),
                      PRIMARY KEY (ISBN, username),
                      CONSTRAINT "FK_LIBRO" FOREIGN KEY(ISBN) 
                      REFERENCES LIBRO(ISBN),
                      CONSTRAINT "FK_USER" FOREIGN KEY(USERNAME)
                      REFERENCES UTENTE(USERNAME)
               )
           END-EXEC.
           
           

      


           COMMITANDCLOSE.
      ********************COMMIT***************************************
           EXEC SQL COMMIT WORK END-EXEC.
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.       
      ****************DISCONNECT***************************************
           EXEC SQL DISCONNECT ALL END-EXEC. 
           IF SQLCODE NOT = ZERO PERFORM ERROR-RUNTIME STOP RUN.       
      *********************FINISH***************************************


















      *****************************************************************
      *****************SQL RUNTIME ERRORS******************************
      *****************************************************************

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






           
