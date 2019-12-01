Jak odpalić?

Najpierw budujemy obraz cassandry. W tym celu w katalogu Cassandra wpisujemy polecenie:

docker build -f Dockerfile -t books-cassandra .

Następnie budujemy obraz api. W katalogu NoSQL:

docker build -f Dockerfile -t books-api .

I potem, będąc w tym samym katalogu odpalamay docker compose:

docker-compose up -d

Możemy sprawdzić logi:

docker-compose logs

Zatrzymujemy poleceniem:

docker-compose down