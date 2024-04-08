Omówienie zaimplementowanego algorytmu:

* Program stanowi implementację klasycznego problemu współbieżności: Problem czytelników i pisarzy.

* Zaimplementowane klasy to: Reader, Writer i Library. W metodzie main jest tworzone 10 obiektów czytelników i 3 obiekty pisarzy. W konstruktorach tych obiektów wywoływana jest metoda start() każdego z wątków, ponieważ klasy te dziedziczą po klasie Thread. 

* Zasady są takie, że w czytelni może maksymalnie przebywać 5 czytelników lub tylko jeden pisarz, gdyż zajmuje on zasoby na wyłączność. Dodatkowo, ani czytelnik ani pisarz nie zostaną nigdy zagłodzeni, ponieważ działają w wątkach na tym samym priorytecie.



