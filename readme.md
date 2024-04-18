Projekt prostej "biblioteki", która przy pomocy zapytań http oraz wykorzystując 
REST API i JSONa daje możliwość transakcji typu CRUD do tabeli w bazie danych. Baza danych znajduje się w kontenerze.
Daje to możliwość uruchomienia bazy w bardziej izolowanym i przenoszalnym środowisku

W bazie znajduje się jedna tabela, która posiada następujące kolumny:\
-idBook,\
-titleBook,\
-nameAuthor,\
-surnameAuthor.

W ramach tych kolumn (które są też zmiennymi klasy Book) są udostępnione 
manipulacje opisane w adnotacjach klasy BookController. W klasie BookRepository
wstrzyknięto zależność jdbcTemplate- umożliwiło to stworzenie metod, które wysyłają
zapytania do bazy danych w języku mySQL. 

Lepszym rozwiązaniem wydaje się jednak użycie JPA Repository. Podejście 
takie daje możliwość korzystania z dostępnych już metod i nie naraża na popełnienie błedów 
składniowych w języku bazodanowym

Wykorzystano następujące technologie i biblioteki:\
-Java\
-Spring\
-Maven\
-MySQL
-Docker
-Lombok

Jak uruchomić kontener?

należy posiadać zainstalowanego dockera, a następnie ściągnąć obraz kontenera z
platformy DockerHub. Aby to wykonać należy uruchomić Terminal oraz wpisać komendę:



docker pull przemex13/simplelibrary:latest



następnie należy uruchomić kontener uwzględniając następujące parametry z pliku 
application.properties projektu:

spring.datasource.url=jdbc:mysql://localhost:3307/BookSet?useSSL=false \
spring.datasource.username=root \
spring.datasource.password=Przemek123

należy zatem wpisać polecenie:

docker run --name przemex13simpleLibraryContainer -e MYSQL_ROOT_PASSWORD=Przemek123 -d -p 3307:3306 przemex13/simplelibrary

W razie pytań, sugestii i problemów, służe pomocą \
przemyslaw@poskrobko@gmail.com