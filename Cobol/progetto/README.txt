#attiva il progetto
docker compose up -d

#accedi al terminale di db
docker compose exec -it db /bin/bash

createdb -U postgres biblioteca_db

exit

#accedi al terminale di db
docker compose exec oscobol /bin/bash

#dai i permessi
chmod +x /cpy/script.sh

cpy/script.sh

#FAI SOLO
cobcrun BIBLIOTECA

