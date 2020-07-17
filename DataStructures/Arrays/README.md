# Arrays

- Arrays in java are implemented by Arraylist class and Vector class
- We do not use simple plain arrays normally, because its difficult to maintain them
- Arraylist and Vectors are dynamic array implementations

## Advantages

- Insertions using index are faster
- Traversing using index is faster
- Random traversals are faster because of index

## Disadvantages

- Insertions (upsertions) in between is slower
- Deletions are slower ( Need to move whole array )
- Traversals are slower if we do not know the index positions.

## Collection Classes

### ArrayLists

- Arraylists have array implementation as their backend
- Arraylists are not synchronized - they are not thread safe, multiple write operations in different threads on arraylists may not produce consistent results
- Default capacity is 10
- Link to [JavaDoc](https://docs.oracle.com/javase/9/docs/api/java/util/ArrayList.html)

### Vectors

- Vectors are dynamic arrays with arrays as implementation as their backend
- Vectors are synchronized - they are thread safe, which makes them slower
- Default capacity is 10
- Link to [JavaDoc](https://docs.oracle.com/javase/9/docs/api/java/util/Vector.html)