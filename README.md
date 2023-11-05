# ULOiady
### Po co stworzyliśmy ULObiady?
Aplikacja ULObiady powstała z powodu powolnego systemu wydawania obiadów w naszej szkole. Obecny system w naszej szkole wygląda mniej więcej tak:
1. Uczeń zamawia posiłek w aplikacji dostawcy. Musi to zrobić dzień przed datą odbioru posiłku.
2. Dostawca, u którego szkoła się zaopatruje przywozi posiłki wraz z listą osób i obiadów. Każda klasa to inna kartka.
3. Grupa dyżurnych wydaje posiłki. Podchodzi uczeń, dyżurni sprawdzają czy jest na liście oraz jaki posiłek zamówił.
4. Uczeń dostaje obiad wraz z sztućcami.
   
System jest logiczny, i nie da się tego zrobić inaczej. A może jednak?
Punkt 2. zajmuje zdecydowanie za dużo czasu. Dyżurni gubią się w kartkach, nie potrafią znaleźć uczniów. Zdarzały się też sytuacje, że brakowało obiadów. Kolejka osób czekających na odebranie potrafiła ciągnąć się aż do schodów, gdzie blokowała przejście. Czas odbierania obiadu potrafił zajmować nawet połowę przerwy obiadowej. Uczniowie nie mieli czasu w spokoju zjeść. 
***Z pomocą przychodzi nasza aplikacja !!!***

### Jak działa aplikacja ULObiady?
To proste! Uczeń pobiera aplikację mobilną, tworzy konto z tymi samymi danymi co w aplikacji do zamawiania posiłków. Następnie loguje się i dostaje kod QR jako identyfikator. Dyżurny korzysta z aplikacji w wersji skanera kodów QR i dostaje informację, jaki posiłek zamawiała osoba, oraz czy już go odebrała. Aplikacja automatyzuje proces z punktu 3 oraz znacząco przyspiesza i ułatwia pracę dyżurnych.

### Jakie języki programowania/technologie zastosowaliśmy?
- Java -> aplikacja mobilna pisana w środowisku Android Studio
- Ubuntu -> serwer do hostowania bazy danych i obsługi zapytań
- Apache -> obsługa komunikacji między aplikacją mobilną a serwerem
- MySQL -> wykorzystany do obsługi bazy danych 
- PHP -> skrypty pozwoliły na komunikację między aplikacja mobilną a serwerem

### Jak widzimy dalszy rozwój naszego rozwiązania?
Przede wszystkim należałoby zaangażować szkołę w celu zezwolenia na wdrożenie rozwiązania w procesie wydawania obiadów. Jeszcze ważniejsze jest otrzymanie danych związanych z zamówieniami uczniów. W takim przypadku potrzebny byłby program konwertujący plik z danymi dostawcy na odpowiednie rekordy w bazie danych aplikacji (Python sprawdziłby się przy takiej automatyzacji znakomicie). Potrzebaby zezwolenia na zarządzanie danymi osobowymi uczniów. 

### Jakie zagrożenia/ryzyka widzimy dla naszego rozwiązania?
W aplikacji trzeba jeszcze dopracować UI, oraz zadbać o lepsze szyfrowanie wymiany danych między aplikacją a bazą danych. Potrzeba zaangażowania takich podmiotów jak szkoła oraz dostawca.

### Dlaczego powinniśmy wygrać?
Dobrym powodem jest fakt, że rozwiązuje ona realny problem, oraz że wdrożenie tego rozwiązania na prawdę może zautomatyzować, przyspieszyć i ułatwić proces wydawania obiadów.. 

wymyślić nazwę aplikacji(ULObiady), zmienić ikonki, dokończyć pisać readme, wrzucić do repozytorium obie plaikacjie + pliki apk, wyczścić bazę danych i dodać trochę przykładowych użytkowników dla testowania
