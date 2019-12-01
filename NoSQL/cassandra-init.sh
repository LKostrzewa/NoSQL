CQL="DROP keyspace booksreviews;

CREATE KEYSPACE booksreviews WITH replication = {'class': 'NetworkTopologyStrategy', 'datacenter1': 1};
USE booksreviews;

Create Table Book(
    id int PRIMARY KEY,
    title text,
    authors text,
    avgRating float,
    isbn text,
    isbn13 text,
    language text,
    pages int,
    countRating int,
    countTextReview int
);

COPY book (id,title,authors,avgrating,isbn,isbn13,language,pages,countrating,counttextreview)
FROM '/demo/books.csv' WITH DELIMITER=';' AND HEADER=TRUE;"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

exec /docker-entrypoint.sh "$@"