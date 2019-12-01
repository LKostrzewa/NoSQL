-- keyspace is like a database
CREATE KEYSPACE booksreviews WITH replication = {'class': 'NetworkTopologyStrategy', 'datacenter1': 1};

-- switch to the newly created keyspace
USE booksreviews;

-- Field id is primary key
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

-- Populate table from a csv file
COPY book (id,title,authors,avgrating,isbn,isbn13,language,pages,countrating,counttextreview)
FROM '/demo/books.csv' WITH DELIMITER=';' AND HEADER=TRUE;