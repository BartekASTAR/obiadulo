# Obiadulo
## Formularz zgłoszeniowy: 
### 1) Na jakie potrzeby/problem odpowiada Wasze rozwiązanie? W jaki sposób wpisuje się w temat Hack Heroes 2023?
Aplikacja Obiadulo powstała z powodu powolnego systemu wydawania obiadów w naszej szkole. Obecny system w naszej szkole wygląda mniej więcej tak:

Uczeń zamawia posiłek w aplikacji dostawcy. Musi to zrobić dzień przed datą odbioru posiłku.
Dostawca, u którego szkoła się zaopatruje przywozi posiłki w kilku kartonach wraz z listą osób i obiadów. Każda klasa to inna kartka.
Grupa dyżurnych wydaje posiłki. Podchodzi uczeń, dyżurni sprawdzają czy jest na liście oraz jaki posiłek zamówił.
Uczeń dostaje obiad wraz z sztućcami.
System jest logiczny, i nie da się tego zrobić inaczej. A może jednak?

Punkt 3. zajmuje zdecydowanie za dużo czasu. Dyżurni gubią się w kartkach, nie potrafią znaleźć uczniów. Złe posiłki były wydawane złym osobom. Kolejka osób czekających na odebranie potrafiła ciągnąć się aż do schodów, gdzie blokowała przejście. Czas odbierania obiadu potrafił zajmować nawet połowę przerwy obiadowej. Uczniowie nie mieli czasu w spokoju zjeść.

Nasza aplikacja automatyzuje proces powolnego wydawania obiadów w szkołach które nie posiadają stołówki. Porzucamy sposób w którym wykorzystywane jest wiele kartek z listami imion i nazwisk i zastępujemy je kodami QR które identyfikują i upoważniają nas do odebrania posiłku. Projekt automatyzuje proces manualnego sprawdzania kartek i znacząco przyspiesza i ułatwia cały proces oraz pracę dyżurnych.

### 2) W jakich językach programowania, jakich technologiach powstała aplikacja/narzędzie?
- Java -> aplikacja mobilna pisana w środowisku Android Studio
- Ubuntu -> serwer do hostowania bazy danych i obsługi zapytań
- Apache HTTP Server -> obsługa komunikacji między aplikacją mobilną a serwerem
- MySQL -> wykorzystany do obsługi bazy danych
- PHP -> skrypty pozwoliły na komunikację między aplikacja mobilną a serwerem

### 3) Opisz działanie Waszej aplikacji/narzędzia (W jaki sposób działa Wasza aplikacja? Co może dzięki niej osiągnąć użytkownik? Jaką ma funkcjonalność?)
To proste! Uczeń pobiera aplikację mobilną, tworzy konto z tymi samymi danymi co w aplikacji do zamawiania posiłków(aplikacja dostawcy). Następnie loguje się i dostaje kod QR jako identyfikator. Dyżurny korzysta z aplikacji w wersji skanera kodów QR i dostaje informację, jaki posiłek zamawiała osoba, oraz czy już go odebrała. Aplikacja automatyzuje proces z punktu 3 oraz znacząco przyspiesza i ułatwia pracę dyżurnych.

### 4) Jak widzicie dalszy rozwój Waszego rozwiązania? (W jaki sposób Wasz projekt mógłby zostać wdrożony lub rozwijany? Jacy partnerzy mogliby się zaangażować w jego rozwój?)
Przede wszystkim należałoby zaangażować szkołę w celu zezwolenia na wdrożenie rozwiązania w procesie wydawania obiadów. Jeszcze ważniejsze jest otrzymanie danych związanych z zamówieniami uczniów. W takim przypadku potrzebny byłby program konwertujący plik z danymi dostawcy na odpowiednie rekordy w bazie danych aplikacji (Python sprawdziłby się przy takiej automatyzacji znakomicie). Potrzebaby zezwolenia na zarządzanie danymi osobowymi uczniów.

Innym pomysłem na rozwinięcie jest zastąpienie kodów QR kartami NFC lub brelokami RFiD. Rezygnujemy wtedy z aplikacji klienta, a skaner QR kodów zastępujemy czytnikiem NFC/RFiD. Na tym etapie zrezygnowaliśmy z tego pomysłu tworząc bardziej budżetowe rozwiązanie. Aplikacja ma potencjał przekształcenia z prostego programu automatyzującego wydawanie obiadów na zintegrowaną platformę do zamawiania i odbierania posiłków. Możnaby zrezygnować wtedy z aplikacji dostawcy. Jest to dość mocno ambitna wizja na przyszłościowy rozwój.

### 5) Jakie widzicie zagrożenia/ryzyka dla Waszego rozwiązania? (Opisz zdiagnozowane zagrożenia jak np. problemy technologiczne czy konieczność zaangażowania innych podmiotów np. urząd miasta)
W aplikacji trzeba jeszcze dopracować UI, oraz zadbać o lepsze szyfrowanie wymiany danych między aplikacją a bazą danych. Zasoby, którymi dysponuje serwer mogą nie być w stanie obsłużyć wszystkich zapytań w odpowiednim czasie. Potrzeba zaangażowania takich podmiotów jak szkoła oraz dostawca.

### 6) Dlaczego akurat Wy powinniście wygrać? (Napisz, co wyróżnia Was pomysł lub jego realizacja np. wybór innowacyjnej technologii)
Przede wszytskim nasza aplikacja rozwiązuje realny problem. Problem, który zauważyliśmy w naszej szkole, ale który może dotyczyć również innych szkół. Ponadto, nasze rozwiązanie jest proste oraz intuicyjne w obsłudze. Aplikacja posiada również duży potencjał na rozwinięcie w dużo bardziej zaawansowny system. Warto jeszcze wspomnieć, że był to nasz pierwszy projekt wykorzystujący Javę, Android Studio jak i popularny stos technologiczny LAMP.


## Testowanie aplikacji
Aplikacja ma dodane 10 przykładowych użytkowników wraz z zamówieniami. Wzór konta:
Imię: test% Nazwisko: test % Klasa: 1a Hasło: test%, gdzie % to liczba od 1 do 10

## Działanie
Użytkownik tworzy konto. Do konta przypisywany jest identyfikator, na podstawie którego generowany jest kod QR. Kiedy skanujemy kod użytkownika, sprawdzamy w bazie danych czy dana osoba zamówił posiłek, oraz rodzaj tego posiłku. Kiedy posiłek zostanie odebrany, w bazie aktualizowany jest status zamówienia i godzina odebrania. Kiedy odoba próbuje skanować kod już odebranego posiłku, generowany jest stosowny komunikat. 

apisać działanie, backend, 
