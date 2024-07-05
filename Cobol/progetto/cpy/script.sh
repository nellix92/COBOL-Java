#!/bin/bash

# Array dei nomi dei file COBOL senza l'estensione
files=("AMMINISTRAZIONE" "CASAEDITRICE" "LIBRO" "PRENOTAZIONE" "UTENTE" "BIBLIOTECA" "DBUTIL" "OPERATORE" "RUOLOTABLEUTIL")

# Directory dei sorgenti COBOL
source_dir="/oscobol/src"

# Directory di destinazione per i file precompilati e compilati
output_dir="/oscobol"

# Loop attraverso ciascun file e applica i comandi ocesql e cobc
for file in "${files[@]}"; do
    echo "Processing $file.cbl..."
    
    # Esegui la precompilazione con ocesql
    ocesql "$source_dir/$file.cbl" "$output_dir/$file.pre"
    
    # Compila con cobc generando il file .so
    cobc -locesql "$output_dir/$file.pre" -o "$output_dir/$file.so"
    
    echo "$file.cbl processed successfully."
done

echo "All files have been processed."
